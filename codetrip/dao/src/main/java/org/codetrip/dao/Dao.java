package org.codetrip.dao;

import java.io.Serializable;

/**
 * Created by RuFeng on 2015/2/3.
 */
public interface Dao<T> extends Serializable {
    /**
     * 通过ID查找
     *
     * @param id
     * @return T
     * */
    public abstract T find(Long id);

    /**
     * 插入新记录
     *
     * @param record
     * */
    public abstract void insert(T record);

    /**
     * 更新
     *
     * @param record
     * */
    public abstract void update(T record);

    /**
     * 删除
     *
     * @param id
     * */
    public abstract void delete(Long id);
}
