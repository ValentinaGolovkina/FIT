package com.fittest.userdoc.Dto;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

public class DocDto {

    private UUID id;
    private String name;
    private Integer number;
    private Date date;
    private UUID userId;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public UUID getUser() {
        return userId;
    }
    public void setUser(UUID userId) {
        this.userId = userId;
    }
}
