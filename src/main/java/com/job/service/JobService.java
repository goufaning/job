package com.job.service;

import com.job.dao.JobDao;
import com.job.domain.Job;
import com.job.utils.DaoFactory;

import java.util.List;

/**
 * Created by goufaning on 2016/11/20.
 */
public class JobService {
    private JobDao dao = DaoFactory.getInstance().createDao("com.job.dao.impl.JobDaoImpl",JobDao.class);

    public List<Job> getData() {
        return dao.getAllData();
    }
    public Job find(int jobId) {
        return dao.getJob(jobId);
    }
}
