package com.doctor.common;

import java.util.List;

/**
 * Created by lzc on 2016/5/12.
 */
public interface DAO<D,Q>{

    int insert(D tempDO);

    List<D> find(Q query);

    int count(Q query);

    int update(D tempDO);

    D get(Q query);

    int delete(Q query);

    D insertReturnDO(D tempDO);


}
