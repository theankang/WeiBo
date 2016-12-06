package com.theankang.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jsdgw on 11/28/16.
 */
@Entity
@Table(name = "topic_table", schema = "weibo_db", catalog = "")
public class Topic {

    private Integer topicId;
    private Integer topicSum;
    private String topicName;
    private String topicContent;

    private Set<Message> messageSet = new HashSet<Message>();

    @Id
    @Column(name = "topic_id", nullable = false, length = 11)
    @GenericGenerator(name = "generator", strategy = "native")
    @GeneratedValue(generator = "generator")
    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    @Basic
    @Column(name = "topic_sum", nullable = false)
    public Integer getTopicSum() {
        return topicSum;
    }

    public void setTopicSum(Integer topicSum) {
        this.topicSum = topicSum;
    }

    @Basic
    @Column(name = "topic_name", nullable = false, length = 20)
    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    @Basic
    @Column(name = "topic_content", nullable = false, length = 255)
    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    @OneToMany
    public Set<Message> getMessageSet() {
        return messageSet;
    }

    public void setMessageSet(Set<Message> messageSet) {
        this.messageSet = messageSet;
    }
}
