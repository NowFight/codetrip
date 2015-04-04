package org.codetrip.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by RuFeng on 2015/2/3.
 */
public class BaseDao<T> extends Dao<T> {

    @Autowired
    private SqlSession sqlSession;

    /**
     * 获得sqlSession
     *
     * @return sqlSession
     */
    public SqlSession getSession() {
        return sqlSession;
    }

    /**
     * 通过Java的Class对象获得mapper的前缀
     *
     * @return String
     */
    public String getNamespace() {
        return getClass().getInterfaces()[0].getName();
    }

    /**
     * 通过ID查找
     *
     * @param Id
     * @return T
     */
    @Override
    public T find(Long Id) {
        return sqlSession.selectOne(getNamespace() + "find", Id);
    }

    /**
     * 插入新记录
     *
     * @param record
     */
    @Override
    public void insertNew(T record) {
        sqlSession.insert(getNamespace() + "insert", record);
    }
}
