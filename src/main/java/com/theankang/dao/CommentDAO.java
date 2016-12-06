package com.theankang.dao;

import com.theankang.model.Comment;
import com.theankang.model.Message;
import com.theankang.model.User;

import java.util.List;


public interface CommentDAO {

    public void addComment(Comment comment);
    public void updateComment(Comment comment);
    public void deleteComment(Comment comment);
    public Comment findCommentById(String replyId);

}
