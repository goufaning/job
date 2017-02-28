package com.job.dao.impl;

import com.job.domain.Job;
import com.job.utils.JdbcUtils;
import com.job.dao.JobDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by goufaning on 2016/11/20.
 */
public class JobDaoImpl implements JobDao {
    @Override
    public List<Job> getAllData() {
        String sql = "select * from job";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Job> joblist = new LinkedList<>();
        try {
            conn = JdbcUtils.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Job job = new Job();
                job.setId(rs.getInt("id"));
                job.setJobName(rs.getString("name"));
                job.setDepartment(rs.getString("department"));
                job.setEducation(rs.getString("education"));
                job.setWorkPlace(rs.getString("workplace"));
                job.setSalary(rs.getString("salary"));
                job.setDetail(rs.getString("detail"));
                job.setCompany(rs.getString("company"));
                job.setCompanymassage(rs.getString("companymassage"));
                joblist.add(job);
            }
            return joblist;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(rs,stmt,conn);
        }
        return null;
    }

    @Override
    public Job getJob(int jobId) {
        String sql = "select * from job where id="+ jobId;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Job job = new Job();
        try {
            conn = JdbcUtils.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                job.setId(rs.getInt("id"));
                job.setJobName(rs.getString("name"));
                job.setDepartment(rs.getString("department"));
                job.setEducation(rs.getString("education"));
                job.setWorkPlace(rs.getString("workplace"));
                job.setSalary(rs.getString("salary"));
                job.setDetail(rs.getString("detail"));
                job.setCompany(rs.getString("company"));
                job.setCompanymassage(rs.getString("companymassage"));
                return job;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(rs,stmt,conn);
        }
        return null;
    }
}
