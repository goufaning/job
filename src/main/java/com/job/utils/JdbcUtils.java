package com.job.utils;

import java.sql.*;


public class JdbcUtils {
    //数据库用户名
    private static final String USERNAME = "root";
    //数据库密码
    private static final String PASSWORD = "********";
    //驱动信息
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    // 数据库地址
    private static final String URL = "jdbc:mysql://cdb-qx0xu3qi.cd.tencentcdb.com:10015/job";


    /**
     * 获得数据库的连接
     *
     * @return 数据库连接
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    /**
     * 释放数据库连接
     */
    private static void release(Statement stmt,Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void release(ResultSet rs,Statement stmt,Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        release(stmt,conn);
    }
}
