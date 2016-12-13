package com.theankang.dao.impl;

import com.theankang.dao.AttentionGroupDAO;
import com.theankang.model.AttentionGroup;
import com.theankang.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jsdgw on 12/2/16.
 */
@Repository("attentionGroupDAO")
public class AttentionGroupDAOImpl implements AttentionGroupDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /*
     *获取和当前线程绑定的Session
     */
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addAttentionGroup(AttentionGroup attentionGroup) {
        getSession().save(attentionGroup);
    }

    public void updateAttentionGroup(AttentionGroup attentionGroup) {
        getSession().update(attentionGroup);
    }

    public void deleteAttentionGroup(AttentionGroup attentionGroup) {
        getSession().delete(attentionGroup);
    }

    /*
     * untested
     */
    public AttentionGroup findAttentionGroupById(String attentionGroupId) {
        String hql = "from AttentionGroup attentionGroup where attentionGroup.agId = :attentionGroupId";
        Query query = getSession().createQuery(hql);
        query.setParameter("attentionGroupId", attentionGroupId);
        AttentionGroup attentionGroup = (AttentionGroup) query.uniqueResult();
        return attentionGroup;
    }

    public AttentionGroup findAttentionGroupByMember(User user) {
        String sql = "select * from attention_group_table where ag_id = (select ag_id from user_attention_table where user_id = ?";
        Query query = getSession().createNativeQuery(sql);
        AttentionGroup attentionGroup = (AttentionGroup) query.setParameter(0, user.getUserId()).uniqueResult();

        return attentionGroup;
    }

    public List<AttentionGroup> findAttentionGroupByUser(User user) {
        String sql = "select * from user_attention_table where user_id = ?";
        Query query = getSession().createNativeQuery(sql);
        query.setParameter(0, user.getUserId());
        List<AttentionGroup> attentionGroupList = query.list();
        return attentionGroupList;
    }

}
