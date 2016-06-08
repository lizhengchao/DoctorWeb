/**
 * Created by lzc on 2016/5/30.
 */
function getIdSelections() {
    return $.map($table.bootstrapTable('getSelections'), function (row) {
        return row.id
    });
}

function responseHandler(res) {
    $.each(res.rows, function (i, row) {
        row.state = $.inArray(row.id, selections) !== -1;
    });
    return res;
}

function detailFormatter(index, row) {
    var html = [];
    $.each(row, function (key, value) {
        html.push('<p><b>' + key + ':</b> ' + value + '</p>');
    });
    return html.join('');
}

function inputFormatter(value) {
    var checked = value ? 'checked' : '';
    return '<input type="checkbox" ' + checked + ' />';
}

window.inputEvents = {
    'change :checkbox': function (e, value, row, index) {
        row.selling = $(e.target).prop('checked');
        $table.bootstrapTable('updateRow', {
            index: index,
            row: row
        });
    }
};


function getHeight() {
    return $(window).height() - $('h1').outerHeight(true);
}

$(function () {
    var scripts = [
            location.search.substring(1) || 'assets/bootstrap-table/src/bootstrap-table.js',
            'assets/bootstrap-table/src/extensions/export/bootstrap-table-export.js',
            'http://rawgit.com/hhurz/tableExport.jquery.plugin/master/tableExport.js',
            'assets/bootstrap-table/src/extensions/editable/bootstrap-table-editable.js',
            'http://rawgit.com/vitalets/x-editable/master/dist/bootstrap3-editable/js/bootstrap-editable.js'
        ],
        eachSeries = function (arr, iterator, callback) {
            callback = callback || function () {
            };
            if (!arr.length) {
                return callback();
            }
            var completed = 0;
            var iterate = function () {
                iterator(arr[completed], function (err) {
                    if (err) {
                        callback(err);
                        callback = function () {
                        };
                    }
                    else {
                        completed += 1;
                        if (completed >= arr.length) {
                            callback(null);
                        }
                        else {
                            iterate();
                        }
                    }
                });
            };
            iterate();
        };

    eachSeries(scripts, getScript, initTable);
});

function getScript(url, callback) {
    var head = document.getElementsByTagName('head')[0];
    var script = document.createElement('script');
    script.src = url;

    var done = false;
    // Attach handlers for all browsers
    script.onload = script.onreadystatechange = function () {
        if (!done && (!this.readyState ||
            this.readyState == 'loaded' || this.readyState == 'complete')) {
            done = true;
            if (callback)
                callback();

            // Handle memory leak in IE
            script.onload = script.onreadystatechange = null;
        }
    };

    head.appendChild(script);

    // We handle everything using the script element injection
    return undefined;
}



