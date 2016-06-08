package com.doctor.common;

import java.util.List;

/**
 * Created by lzc on 2016/5/12.
 */
public abstract class CommonService<D, Q, DA extends DAO<D, Q>> implements Service<D, Q> {

    public abstract DA getDao();

    @Override
    public Result<D> insertResultDO(D d) {
        try {
            D ret = getDao().insertReturnDO(d);
            return Result.buildSuccessResult(ret);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<D>(null, false, "插入失败", 500);
        }
    }

    @Override
    public Result<List<D>> find(Q query) {
        try {
            List<D> ret = getDao().find(query);
            return Result.buildSuccessResult(ret);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<List<D>>(null, false, "查找失败", 500);
        }
    }

    @Override
    public Result<D> get(Q query) {
        try {
            D ret = getDao().get(query);
            return Result.buildSuccessResult(ret);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<D>(null, false, "查找单个失败", 500);
        }
    }

    @Override
    public Result<Integer> insert(D temp) {
        try {
            Integer ret = getDao().insert(temp);
            return Result.buildSuccessResult(ret);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<Integer>(null, false, "插入失败", 500);
        }
    }

    @Override
    public Result<Integer> update(D temp) {
        try {
            int ret = getDao().update(temp);
            return Result.buildSuccessResult(ret);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<Integer>(null, false, "更新失败", 500);
        }
    }

    @Override
    public Result<Void> delete(Q query) {
        try {
            int ret = getDao().delete(query);
            return Result.buildSuccessResult(ret);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<Void>(null, false, "删除失败", 500);
        }
    }


    @Override
    public Result<Integer> count(Q query) {
        try {
            int ret = getDao().count(query);
            return Result.buildSuccessResult(ret);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<Integer>(null, false, "计算数量失败", 500);
        }
    }
}
