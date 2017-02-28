package com.job.service;

import com.job.dao.ApplyJobDao;
import com.job.domain.Application;
import com.job.utils.DaoFactory;

import java.util.List;

/**
 * Created by goufaning on 2016/11/21.
 */
public class ApplicationService {
    private ApplyJobDao dao = DaoFactory.getInstance().createDao("com.job.dao.impl.ApplyJobDaoImpl",ApplyJobDao.class);

    public boolean insert(int userId,int jobId) {
        return dao.insert(userId,jobId);
    }

    public List<Application> getApplications(int userId) {
        return dao.getApplications(userId);
    }
}
