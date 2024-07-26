package com.trojan.task.entity;

import javax.persistence.*;

@Entity
@Table(name = "equipment_details")
public class EquipmentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_id")
    private int reqEquipmentId;

    @Column(name = "equipment_name")
    private String equipmentName;

    @Column(name = "plate_no")
    private Long plateNo;

    @Column(name = "model_no")
    private String modelNo;

    public int getReqEquipmentId() {
        return reqEquipmentId;
    }

    public void setReqEquipmentId(int reqEquipmentId) {
        this.reqEquipmentId = reqEquipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Long getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(Long plateNo) {
        this.plateNo = plateNo;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }
}
