package com.fittest.userdoc.Dto;

import com.fittest.userdoc.entity.DocMongo;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDto {

    @Id
    private UUID id;
    private String name;
    private String surname;
    private Integer age;
    private List<DocMongo> documents = new ArrayList<>();

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

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }


    public List<DocMongo> getDocuments() {
        return documents;
    }
    public void setDocuments(List<DocMongo> documents) {
        this.documents = documents;
    }
}
