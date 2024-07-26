package com.trojan.task.mapper;

import com.trojan.task.dto.RequestDTO;
import com.trojan.task.entity.EquipmentDetails;
import com.trojan.task.entity.ProjectDetails;
import com.trojan.task.entity.RequestCreate;
import com.trojan.task.repository.EquipmentRepository;
import com.trojan.task.repository.ProjectRepository;
import com.trojan.task.service.RequestServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.trojan.task.utils.ConvertUtils.*;

@Component
public class RequestMapper {

    Logger logger = LoggerFactory.getLogger(RequestMapper.class);

    @Autowired ProjectRepository projectRepository;

    @Autowired EquipmentRepository equipmentRepository;

    public RequestCreate map(RequestDTO requestDTO) {
        RequestCreate requestCreation = new RequestCreate();
        //To find the project and equipment id is present in respective tables.
        ProjectDetails project = projectRepository.findByReqProjectId(stringToInt(requestDTO.getProjectId()));
        EquipmentDetails equipment = equipmentRepository.findByReqEquipmentId(stringToInt(requestDTO.getEquipmentId()));
        //If project and equipment id is not present in respective tables then, throw the run time exception.
        if (project == null) {
            throw new RuntimeException("Invalid project id");
        }
        if (equipment == null) {
            throw new RuntimeException("Invalid equipment id");
        }
        //If it is present then set the values to respective fields of RequestCreate table.
        requestCreation.setReqProjectId(project.getReqProjectId());
        requestCreation.setReqEquipId(equipment.getReqEquipmentId());
        requestCreation.setProjectName(project.getProjectName());
        requestCreation.setEquipmentName(equipment.getEquipmentName());
        requestCreation.setShift(requestDTO.getShift());
        requestCreation.setFuel(requestDTO.getFuel());
        requestCreation.setReqNotes(requestDTO.getReqNotes());
        logger.info("Successfully sets the respective fields to RequestCreate Entity and returning requestCreation");
        return requestCreation;
    }

    public RequestDTO remap(RequestCreate requestCreation) {
        RequestDTO requestDTO =new RequestDTO();
        requestDTO.setReqId(longToString(requestCreation.getReqId()));
        requestDTO.setProjectId(intToString(requestCreation.getReqProjectId()));
        requestDTO.setEquipmentId(intToString(requestCreation.getReqEquipId()));
        requestDTO.setReqNotes(requestCreation.getReqNotes());
        requestDTO.setProjectName(requestCreation.getProjectName());
        requestDTO.setEquipmentName(requestCreation.getEquipmentName());
        requestDTO.setFuel(requestCreation.getFuel());
        requestDTO.setShift(requestCreation.getShift());
        logger.info("Successfully sets the respective fields to RequestDTO and returning requestDTO");
        return  requestDTO;
    }
}
