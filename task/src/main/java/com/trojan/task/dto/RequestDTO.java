package com.trojan.task.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {

    private String reqId;
    private String projectId;
    private String equipmentId;
    private String projectName;
    private String equipmentName;
    private String reqNotes;
    private int shift;
    private String fuel;
}