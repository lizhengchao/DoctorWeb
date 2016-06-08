package com.doctor.common;

import java.util.List;

/**
 * Created by lzc on 2016/5/12.
 */
public interface Service<D, Q> {

    public Result<Integer> insert(D d);

    public Result<D> insertResultDO(D d);

    public Result<Integer> count(Q query);

    public Result<Void> delete(Q query);

    public Result<List<D>> find(Q query);

    public Result<Integer> update(D temp);

    public Result<D> get(Q query);

}
