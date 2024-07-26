package com.trojan.task.repository;

import com.trojan.task.entity.EquipmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentDetails, String> {
    EquipmentDetails findByReqEquipmentId(Integer reqEquipmentId);
}

