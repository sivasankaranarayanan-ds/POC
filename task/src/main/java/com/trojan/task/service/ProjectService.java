package com.trojan.task.service;

import javassist.NotFoundException;
import com.trojan.task.entity.ProjectDetails;

public interface ProjectService {

    ProjectDetails getProjectById(Integer projectId) throws NotFoundException;
}
