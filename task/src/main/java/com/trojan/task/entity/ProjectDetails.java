package com.trojan.task.entity;

import javax.persistence.*;

@Entity
@Table(name = "project_details")
public class ProjectDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int reqProjectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "location")
    private String location;

    @Column(name = "division")
    private String division;


    public int getReqProjectId() {
        return reqProjectId;
    }

    public void setReqProjectId(int reqProjectId) {
        this.reqProjectId = reqProjectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
