package com.job.dao;

import com.job.domain.User;

/**
 * Created by goufaning on 2016/11/13.
 */
public interface UserDao {
    boolean addUser(User user);
    User find(String username, String password);
    boolean update(int userId, String resumeId);
}
