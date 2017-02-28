package com.job.dao;

import com.job.domain.Resume;

/**
 * Created by goufaning on 2016/11/16.
 */
public interface ResumeDao {
    boolean addResume(Resume resume);
    Resume find(String id);
    boolean delete(String id);
    boolean update(String resumeId, String imgurl);


}
