package com.theankang.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jsdgw on 11/28/16.
 */
@Entity
@Table(name = "message_table", schema = "weibo_db", catalog = "")
public class Message {

    private Integer messageId;
    private String messageContent;
    private String links;
    private Integer messageFavorite;
    private Integer messageReply;
    private Integer messageForward;
    private Date messagePublishedTime;

    /*
     * add an bidirectional mapping
     * one to many
     * user - message
     */
    private User user;
    /*
     * and so many mappings
     */
    private Topic topic;
    private Set<Comment> commentSet = new HashSet<Comment>();


    @Id
    @Column(name = "message_id", nullable = false)
    @GenericGenerator(name = "generator", strategy = "native")
    @GeneratedValue(generator = "generator")
    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    @Basic
    @Column(name = "message_content", nullable = false, length = 255)
    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Basic
    @Column(name = "links", nullable = true, length = 150)
    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    @Basic
    @Column(name = "message_favorite", nullable = false)
    public Integer getMessageFavorite() {
        return messageFavorite;
    }

    public void setMessageFavorite(Integer messageFavorite) {
        this.messageFavorite = messageFavorite;
    }

    @Basic
    @Column(name = "message_reply", nullable = false)
    public Integer getMessageReply() {
        return messageReply;
    }

    public void setMessageReply(Integer messageReply) {
        this.messageReply = messageReply;
    }


    @Basic
    @Column(name = "message_forward", nullable = false)
    public Integer getMessageForward() {
        return messageForward;
    }

    public void setMessageForward(Integer messageForward) {
        this.messageForward = messageForward;
    }

    @Basic
    @Column(name = "message_published_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getMessagePublishedTime() {
        return messagePublishedTime;
    }

    public void setMessagePublishedTime(Date messagePublishedTime) {
        this.messagePublishedTime = messagePublishedTime;
    }

    /*
     * I found both annotation and xml are needed
     * So, here is the question?
     */
    @ManyToOne
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "topic_id")
    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @OneToMany
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }
}
