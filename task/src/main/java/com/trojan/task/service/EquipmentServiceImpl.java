package com.trojan.task.service;

import com.trojan.task.entity.EquipmentDetails;
import com.trojan.task.repository.EquipmentRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl implements EquipmentService{

    @Autowired EquipmentRepository equipmentRepository;

    public EquipmentDetails getEquipById(Integer reqEquipId) throws NotFoundException {
        EquipmentDetails equipmentDetails = equipmentRepository.findByReqEquipmentId(reqEquipId);
        if (equipmentDetails != null) {
            return equipmentDetails;
        } else {
            throw new NotFoundException("Equipment not found with id: " + reqEquipId);
        }

    }
}
