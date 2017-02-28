package com.job.dao.impl;

import com.job.dao.UserDao;
import com.job.domain.User;
import com.job.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by goufaning on 2016/11/13.
 */
public class UserDaoImpl implements UserDao {

    @Override
    public boolean addUser(User user) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "insert into user(username,password,email) values('" + user.getUsername() + "','" + user.getPassword() + "','" + user.getMail() + "')";
        try {
            conn = JdbcUtils.getConnection();
            stmt = conn.createStatement();
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(rs,stmt,conn);
        }
        return false;
    }

    @Override
    public User find(String username, String password) {
        String sql = "select * from user where username= '"+ username +"' and password='"+password+ "'";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setMail(rs.getString("email"));
                user.setResumeId(rs.getString("resumeId"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(rs,stmt,conn);
        }
        return null;
    }

    @Override
    public boolean update(int userId, String resumeId) {
        String sql = "update user set resumeId = '"+ resumeId +"' where id=" + userId ;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            stmt = conn.createStatement();
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(rs,stmt,conn);
        }
        return false;
    }


}
