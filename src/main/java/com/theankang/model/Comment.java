package com.theankang.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by jsdgw on 11/28/16.
 */
@Entity
@Table(name = "comment_table", schema = "weibo_db", catalog = "")
public class Comment {
    private Integer commentId;
    private Date commentTime;
    private String commentContent;

    /*
     * add relationships
     */
    private User user;
    private Message message;


    @Id
    @Column(name = "comment_id", nullable = false, length = 11)
    @GenericGenerator(name = "generator", strategy = "native")
    @GeneratedValue(generator = "generator")
    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "comment_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @Basic
    @Column(name = "comment_content", nullable = false, length = 255)
    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }


    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "message_id")
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }


}
