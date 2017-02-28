package com.job.dao.impl;

import com.job.domain.Application;
import com.job.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by goufaning on 2016/11/21.
 */
public class ApplyJobDaoImpl implements com.job.dao.ApplyJobDao {

    @Override
    public boolean insert(int userId, int jobId) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "insert into application(userId,jobId) values(" +userId + "," +jobId + ")";
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
    public List<Application> getApplications(int userId) {
        String sql = "select * from application where userId= "+ userId;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Application> applications = new LinkedList<>();
        try {
            conn = JdbcUtils.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Application application = new Application();
                application.setId(rs.getInt("id"));
                application.setUserId(rs.getInt("userId"));
                application.setJobId(rs.getInt("jobId"));
                applications.add(application);
            }
            return applications;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(rs,stmt,conn);
        }
        return null;
    }
}
