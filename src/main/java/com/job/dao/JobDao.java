package com.job.dao;

import com.job.domain.Job;

import java.util.List;

/**
 * Created by goufaning on 2016/11/20.
 */
public interface JobDao {
    List<Job> getAllData();
    Job getJob(int jobId);
}
