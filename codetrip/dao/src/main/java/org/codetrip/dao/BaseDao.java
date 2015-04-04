package org.codetrip.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

/**
 * Created by RuFeng on 2015/2/3.
 */
public class BaseDao<T> implements Dao<T> {

    private final static Logger LOG = Logger.getLogger(BaseDao.class.getName());

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
     * @param id
     * @return T
     */
    @Override
    public T find(Long id) {
        return sqlSession.selectOne(getNamespace() + ".find", id);
    }

    /**
     * 插入新记录
     *
     * @param record
     */
    @Override
    public void insert(T record) {
        int row = sqlSession.insert(getNamespace() + ".insert", record);
        if (row == 0) {
            LOG.warning("no row inserted");
        }
    }

    /**
     * 更新
     *
     * @param record
     */
    @Override
    public void update(T record) {
        int row = sqlSession.update(getNamespace() + ".update", record);
        if (row == 0) {
            LOG.warning("no row updated");
        }
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        int row = sqlSession.delete(getNamespace() + ".delete", id);
        if (row == 0) {
            LOG.warning("no row deleted");
        }
    }
}
