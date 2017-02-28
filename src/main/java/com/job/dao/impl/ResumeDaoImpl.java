package com.job.dao.impl;

import com.job.dao.ResumeDao;
import com.job.domain.Resume;
import com.job.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by goufaning on 2016/11/15.
 */
public class ResumeDaoImpl implements  ResumeDao {

    @Override
    public boolean addResume(Resume resume) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "insert into resume(id,name,sex,education,email,evaluation,telephone,university,workexperience,projectexperience,age,major) values('"+resume.getId()+"','" + resume.getName() + "','" + resume.getSex() + "','" + resume.getEducation() + "'," +
                "'" + resume.getEmail() + "','" + resume.getEvaluation() + "','" + resume.getTelephone() + "','" + resume.getUniversity() + "','" + resume.getWorkexperience() + "'," +
                "'" + resume.getProjectexperience() + "'," + resume.getAge() + ",'" + resume.getMajor() + "')";
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
    public Resume find(String id) {
        String sql = "select * from resume where id= '"+ id + "'";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Resume resume = new Resume();
                resume.setId(rs.getString("id"));
                resume.setName(rs.getString("name"));
                resume.setSex(rs.getString("sex"));
                resume.setEducation(rs.getString("education"));
                resume.setEmail(rs.getString("email"));
                resume.setAge(rs.getInt("age"));
                resume.setEvaluation(rs.getString("evaluation"));
                resume.setMajor(rs.getString("major"));
                resume.setProjectexperience(rs.getString("projectexperience"));
                resume.setTelephone(rs.getString("telephone"));
                resume.setUniversity(rs.getString("university"));
                resume.setWorkexperience(rs.getString("workexperience"));
                resume.setImgurl( rs.getString("imgurl"));
                return resume;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(rs,stmt,conn);
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        String sql = "delete from resume where id='" + id+"'";
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
    @Override
    public boolean update(String resumeId, String imgurl) {
        String sql = "update resume set imgurl= '"+ imgurl+"' where id = '" + resumeId +"'";
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
