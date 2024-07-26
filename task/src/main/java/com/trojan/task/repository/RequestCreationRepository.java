package com.trojan.task.repository;

import com.trojan.task.entity.RequestCreate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestCreationRepository extends JpaRepository<RequestCreate, Long> {
}
