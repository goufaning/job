package com.job.service;

import com.job.dao.ResumeDao;
import com.job.domain.Resume;
import com.job.utils.DaoFactory;

/**
 * Created by goufaning on 2016/11/15.
 */
public class ResumeService {
    private ResumeDao dao = DaoFactory.getInstance().createDao("com.job.dao.impl.ResumeDaoImpl",ResumeDao.class);

    public boolean addResume(Resume resume) {
        return dao.addResume(resume);
    }

    public Resume findResumeById(String resumeId) {
        return dao.find(resumeId);
    }

    public boolean addPhoto(String resumeId,String imgUrl) {
        return dao.update(resumeId,imgUrl);
    }

    public boolean deleteResume(String resumeId) {
        return dao.delete(resumeId);
    }
}
