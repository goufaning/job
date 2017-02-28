package com.job.dao;

import com.job.domain.Application;

import java.util.List;

/**
 * Created by goufaning on 2016/11/21.
 */
public interface ApplyJobDao {
    boolean insert(int userId, int jobId);
    List<Application> getApplications(int userId);
}
