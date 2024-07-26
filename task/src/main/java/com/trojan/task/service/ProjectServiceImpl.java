package com.trojan.task.service;

import com.trojan.task.entity.ProjectDetails;
import com.trojan.task.repository.ProjectRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired ProjectRepository projectRepository;

    @Override
    public ProjectDetails getProjectById(Integer reqProjectId) throws NotFoundException {
        ProjectDetails projectDetails = projectRepository.findByReqProjectId(reqProjectId);
        if (projectDetails != null) {
            return projectDetails;
        } else {
            throw new NotFoundException("Project not found with id: " + reqProjectId);
        }
    }
}
