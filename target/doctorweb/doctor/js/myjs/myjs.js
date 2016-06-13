/**
 * Created by lzc on 2016/6/12.
 */
function valPhone(phoneNumber) {
    if (!/^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/i.test(phoneNumber)) {
        return false;
    } else {
        return true;
    }
}

String.prototype.format = function(args) {
    if (arguments.length>0) {
        var result = this;
        if (arguments.length == 1 && typeof (args) == "object") {
            for (var key in args) {
                var reg=new RegExp ("({"+key+"})","g");
                result = result.replace(reg, args[key]);
            }
        }
        else {
            for (var i = 0; i < arguments.length; i++) {
                if(arguments[i]==undefined)
                {
                    return "";
                }
                else
                {
                    var reg=new RegExp ("({["+i+"]})","g");
                    result = result.replace(reg, arguments[i]);
                }
            }
        }
        return result;
    }
    else {
        return this;
    }
}