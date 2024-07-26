package com.trojan.task.controller;

import com.trojan.task.dto.RequestDTO;
import com.trojan.task.entity.RequestCreate;
import com.trojan.task.mapper.RequestMapper;
import com.trojan.task.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {

    //TODO -> project_id and equipment_id and documentation and separate implementation and service class

    @Autowired RequestService requestService;

    @Autowired RequestMapper requestMapper;

    //This API is used to save the new request.
    @PostMapping
    public ResponseEntity<Object> createRequests(@RequestBody RequestDTO requestDTO) {
        RequestCreate savedRequest =requestService.saveRequest(requestMapper.map(requestDTO));
        return new ResponseEntity<>(savedRequest, HttpStatus.OK);
    }

    //This API is used to get a request by Request ID.
    @GetMapping("/{reqId}")
    public ResponseEntity<Object> getRequestById(@PathVariable("reqId") Long requestId) throws javassist.NotFoundException {
        RequestCreate requestCreation = requestService.getRequestById(requestId);
        RequestDTO requestDTO = requestMapper.remap(requestCreation);
        return new ResponseEntity<>(requestDTO, HttpStatus.OK);
    }

    //This API is used to get all the request data present in the respective table.
    @GetMapping("/getAllRequest")
    public ResponseEntity<Object> getAllRequest(){
        List requestList =requestService.getAllRequest();
        return new ResponseEntity<>(requestList, HttpStatus.OK);
    }

    //TODO -> avoid update name in api
    //This API is used to Update the existing request data and again save the respective table.
    @PutMapping("/{reqId}")
    public ResponseEntity<RequestCreate> updateRequest(@PathVariable("reqId") Long requestId, @RequestBody RequestDTO requestDTO) {
        RequestCreate updatedRequest = requestService.updateRequest(requestId, requestDTO);
        return new ResponseEntity<>(updatedRequest, HttpStatus.OK);
    }
    //TODO -> avoid delete name in api
    //This API is used to Delete the request by ID.
    @DeleteMapping("/{reqId}")
    public ResponseEntity<String> deleteRequest(@PathVariable Long reqId) {
        String deletedRequest = requestService.deleteRequest(reqId);
        return new ResponseEntity<>(deletedRequest, HttpStatus.OK);
    }
}