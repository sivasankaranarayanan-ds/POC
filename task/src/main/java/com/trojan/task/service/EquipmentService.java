package com.trojan.task.service;

import com.trojan.task.entity.EquipmentDetails;
import javassist.NotFoundException;

public interface EquipmentService {

    EquipmentDetails getEquipById(Integer reqEquipId) throws NotFoundException;

}
