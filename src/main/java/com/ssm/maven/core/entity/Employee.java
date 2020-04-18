package com.ssm.maven.core.entity;

import java.io.Serializable;

/**
 * @author Administrator
 * @date 20200418
 */
public class Employee implements Serializable {
    private String id;
    private  String name;
    private String mobile;
    private int isPartyMember;
    private int isMarried;
    private String position;
    private int joinAt;
    private int nationality;
    private String profession;
    private String remarks;
    private int deleteFlag;
    private int createdAt;
    private int updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public int getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(int isMarried) {
        this.isMarried = isMarried;
    }

    public int getIsPartyMember() {
        return isPartyMember;
    }

    public void setIsPartyMember(int isPartyMember) {
        this.isPartyMember = isPartyMember;
    }

    public int getJoinAt() {
        return joinAt;
    }

    public void setJoinAt(int joinAt) {
        this.joinAt = joinAt;
    }

    public int getNationality() {
        return nationality;
    }

    public void setNationality(int nationality) {
        this.nationality = nationality;
    }

    public int getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(int updatedAt) {
        this.updatedAt = updatedAt;
    }
}
