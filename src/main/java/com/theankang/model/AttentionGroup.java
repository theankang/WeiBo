package com.theankang.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jsdgw on 12/2/16.
 */
@Entity
@Table(name = "attention_group_table", schema = "weibo_db", catalog = "")
public class AttentionGroup {

    private Integer attentionGroupId;
    private Integer attentionGroupMemberSum;
    private String attentionGroupName;

    /*
     * add relationships
     */
    private User user;
    private Set<User> memberSet = new HashSet<User>();


    @Id
    @Column(name = "attention_group_id", nullable = false)
    @GenericGenerator(name = "generator", strategy = "native")
    @GeneratedValue(generator = "generator")
    public Integer getAttentionGroupId() {
        return attentionGroupId;
    }

    public void setAttentionGroupId(Integer attentionGroupId) {
        this.attentionGroupId = attentionGroupId;
    }

    @Basic
    @Column(name = "attention_group_member_sum", nullable = false)
    public Integer getAttentionGroupMemberSum() {
        return attentionGroupMemberSum;
    }

    public void setAttentionGroupMemberSum(Integer attentionGroupMemberSum) {
        this.attentionGroupMemberSum = attentionGroupMemberSum;
    }

    @Basic
    @Column(name = "attention_group_name", nullable = false, length = 20)
    public String getAttentionGroupName() {
        return attentionGroupName;
    }

    public void setAttentionGroupName(String attentionGroupName) {
        this.attentionGroupName = attentionGroupName;
    }

    @ManyToOne
    @JoinColumn (name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany
    public Set<User> getMemberSet() {
        return memberSet;
    }

    public void setMemberSet(Set<User> memberSet) {
        this.memberSet = memberSet;
    }



}
