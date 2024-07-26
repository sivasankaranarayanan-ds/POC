package com.trojan.task.service;

import com.trojan.task.dto.RequestDTO;
import com.trojan.task.entity.EquipmentDetails;
import com.trojan.task.entity.ProjectDetails;
import com.trojan.task.entity.RequestCreate;
import com.trojan.task.repository.EquipmentRepository;
import com.trojan.task.repository.ProjectRepository;
import com.trojan.task.repository.RequestCreationRepository;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.trojan.task.utils.ConvertUtils.stringToInt;

@Service
@Transactional
public class RequestServiceImpl implements RequestService{

    Logger logger = LoggerFactory.getLogger(RequestServiceImpl.class);

    @Autowired RequestCreationRepository requestCreationRepository;

    @Autowired ProjectRepository projectRepository;

    @Autowired EquipmentRepository equipmentRepository;

    //To save a request
    public RequestCreate saveRequest(RequestCreate requestCreation) {
        //If successfully sets all the data with respective field, then the request goes to saving process.
        RequestCreate savedRequest = requestCreationRepository.save(requestCreation);
        logger.info("Successfully saved the new request");
        return savedRequest;
    }
    //TODO -> why ChangeSetPersister
    //TO get a request by ID
    public RequestCreate getRequestById(Long requestId) throws NotFoundException {
        Optional<RequestCreate> requestOptional = requestCreationRepository.findById(requestId);
        if(requestOptional.isPresent()){
            logger.info("The Request details has successfully taken with request id {}", requestId);
            return requestOptional.get();
        }
        else{
            throw new NotFoundException("Request Not Found");
        }
    }

    //To get all the requests list.
    public List getAllRequest(){
        logger.info("All Request Returning Successfully");
        return requestCreationRepository.findAll();
    }

    //To update the existing data in the respective request id.
    public RequestCreate updateRequest(Long requestId, RequestDTO requestDTO) {
        Optional<RequestCreate> existingRequestOpt = requestCreationRepository.findById(requestId);
        //Check if existing request data is present
        if (existingRequestOpt.isPresent()) {
            RequestCreate existingRequest = existingRequestOpt.get();

            ProjectDetails project = projectRepository.findByReqProjectId(stringToInt(requestDTO.getProjectId()));
            EquipmentDetails equipment = equipmentRepository.findByReqEquipmentId(stringToInt((requestDTO.getEquipmentId())));
            if (project == null) {
                throw new RuntimeException("Invalid project id");
            }
            if(equipment == null){
                throw new RuntimeException(("Invalid equipment id"));
            }

            existingRequest.setEquipmentName(equipment.getEquipmentName());
            existingRequest.setProjectName(project.getProjectName());
            existingRequest.setShift(requestDTO.getShift());
            existingRequest.setFuel(requestDTO.getFuel());
            existingRequest.setReqNotes(requestDTO.getReqNotes());

            logger.info("Successfully updated the request {}", requestId);

            return requestCreationRepository.save(existingRequest);
        } else {
            logger.info("The Request has not been Updated {}", requestId);
            throw new RuntimeException("Request not found");
        }
    }

    //To Delete a request with id
    public String deleteRequest(Long reqId) {
        try {
            Optional<RequestCreate> requestOptional = requestCreationRepository.findById(reqId);
            if (requestOptional.isPresent()) {
                requestCreationRepository.deleteById(reqId);
                logger.info("Successfully deleted the request: {}", reqId);
                return "Deleted Successfully";
            } else {
                logger.info("Request with id {} not found, thus not deleted", reqId);
                throw new Exception("The request has not been deleted because it was not found");
            }
        } catch (Exception e) {
            logger.error("An error occurred while trying to delete the request with id {}: {}", reqId, e.getMessage());
            return "An error occurred while trying to delete the request : " + e.getMessage();
        }
    }
}
