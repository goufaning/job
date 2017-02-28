package com.job.service;

import com.job.dao.UserDao;
import com.job.domain.User;
import com.job.utils.DaoFactory;

/**
 * Created by goufaning on 2016/11/13.
 */
public class UserService {
    private UserDao dao = DaoFactory.getInstance().createDao("com.job.dao.impl.UserDaoImpl",UserDao.class);

    public boolean register(User user) {
        return dao.addUser(user);
    }

    public User findUser(String username,String password) {
        return dao.find(username,password);
    }

    public boolean setResume(int userId, String resumeId) {
        return dao.update(userId,resumeId);
    }
}
