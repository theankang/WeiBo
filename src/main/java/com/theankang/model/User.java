package com.theankang.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by An Kang on 11/28/16.
 * auto generate these JavaBean and hbm.xml file by hibernate tool.
 */
@Entity
@Table(name = "user_table", schema = "weibo_db")
public class User {

    private Integer userId;
    private String userPassword;
    private String userName;
    private String userNickname;
    private String userProfilePhoto;
    private String email;
    private String sex;
    private String school;
    private String work;
    private Integer phoneNumber;
    private String userInfo;
    private Date registrationDate;

    /*
     * add an bidirectional mapping
     * one to many
     * user - message
     * What should I use List or Set
     */
    private Set<Message> messageSet = new HashSet<Message>();

    /*
     * and other mapping
     */
    private Set<Comment> commentSet = new HashSet<Comment>();
    private Set<AttentionGroup> attentionGroupSet = new HashSet<AttentionGroup>();

    @Id
    @GenericGenerator(name = "generator", strategy = "native")
    @GeneratedValue(generator = "generator")
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name", length = 20)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_nickname", nullable = false, length = 20)
    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    @Basic
    @Column(name = "user_password", nullable = false, length = 20)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_profile_photo", length = 255)
    public String getUserProfilePhoto() {
        return userProfilePhoto;
    }

    public void setUserProfilePhoto(String userProfilePhoto) {
        this.userProfilePhoto = userProfilePhoto;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "sex", nullable = true, length = 1)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "school", nullable = true, length = 255)
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Basic
    @Column(name = "work", nullable = true, length = 255)
    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Basic
    @Column(name = "phone_number", nullable = true, precision = 0)
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "user_info", nullable = true, length = 255)
    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    @Basic
    @Column(name = "registration_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public Set<Message> getMessageSet() {
        return messageSet;
    }

    public void setMessageSet(Set<Message> messageSet) {
        this.messageSet = messageSet;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public Set<AttentionGroup> getAttentionGroupSet() {
        return attentionGroupSet;
    }

    public void setAttentionGroupSet(Set<AttentionGroup> attentionGroupSet) {
        this.attentionGroupSet = attentionGroupSet;
    }


    public User(Integer userId, String userNickname, Timestamp registrationDate) {
        this.userId = userId;
        this.userNickname = userNickname;
        this.registrationDate = registrationDate;
    }

    public User() {

    }

}
