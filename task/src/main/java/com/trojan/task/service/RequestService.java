package com.trojan.task.service;

import com.trojan.task.dto.RequestDTO;
import com.trojan.task.entity.RequestCreate;
import javassist.NotFoundException;
import java.util.List;

public interface RequestService {

    RequestCreate saveRequest(RequestCreate requestCreation);

    RequestCreate getRequestById(Long requestId) throws NotFoundException;

    RequestCreate updateRequest(Long requestId, RequestDTO requestDTO);

    String deleteRequest(Long reqId);

    List getAllRequest();
}
