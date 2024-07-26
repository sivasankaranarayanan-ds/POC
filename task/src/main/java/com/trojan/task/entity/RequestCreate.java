package com.trojan.task.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "request_creation")
public class RequestCreate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private long reqId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "equipment_name")
    private String equipmentName;

    @Column(name = "project_id")
    private int reqProjectId;

    @Column(name = "equipment_id")
    private int reqEquipId;

    @Column(name = "req_notes", nullable = false)
    private String reqNotes;

    @Column(name = "shift")
    private int shift;

    @Column(name = "fuel")
    private String fuel;

    public long getReqId() {
        return reqId;
    }

    public void setReqId(long reqId) {
        this.reqId = reqId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public int getReqProjectId() {
        return reqProjectId;
    }

    public void setReqProjectId(int reqProjectId) {
        this.reqProjectId = reqProjectId;
    }

    public int getReqEquipId() {
        return reqEquipId;
    }

    public void setReqEquipId(int reqEquipId) {
        this.reqEquipId = reqEquipId;
    }

    public String getReqNotes() {
        return reqNotes;
    }

    public void setReqNotes(String reqNotes) {
        this.reqNotes = reqNotes;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
}
