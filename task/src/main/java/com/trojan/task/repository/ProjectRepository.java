package com.trojan.task.repository;

import com.trojan.task.entity.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectDetails, Long> {
    ProjectDetails findByReqProjectId(Integer reqProjectId);
}
