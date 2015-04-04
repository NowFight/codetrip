package org.codetrip.dao;

import java.io.Serializable;

/**
 * Created by RuFeng on 2015/2/3.
 */
public abstract class Dao<T> implements Serializable {
    /**
     * 通过ID查找
     *
     * @param Id
     * @return T
     * */
    public abstract T find(Long Id);

    /**
     * 插入新记录
     *
     * @param record
     * */
    public abstract void insertNew(T record);
}
