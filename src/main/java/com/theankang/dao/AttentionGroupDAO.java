package com.theankang.dao;

import com.theankang.model.AttentionGroup;
import com.theankang.model.User;

import java.util.List;

public interface AttentionGroupDAO {

    public void addAttentionGroup(AttentionGroup attentionGroup);
    public void updateAttentionGroup(AttentionGroup attentionGroup);
    public void deleteAttentionGroup(AttentionGroup attentionGroup);
    public AttentionGroup findAttentionGroupById(String attentionGroupId);
    public AttentionGroup findAttentionGroupByMember(User user);
    public List<AttentionGroup> findAttentionGroupByUser(User user);

}
