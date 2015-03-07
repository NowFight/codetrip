package org.codetrip.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by RuFeng on 2015/2/3.
 */
public class BaseDao extends Dao {

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
    public String getMapperPrefix() {
        return getClass().getInterfaces()[0].getName();
    }
}
