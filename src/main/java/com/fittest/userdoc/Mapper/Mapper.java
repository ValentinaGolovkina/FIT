package com.fittest.userdoc.Mapper;

import com.fittest.userdoc.Dto.DocDto;
import com.fittest.userdoc.Dto.UserDto;
import com.fittest.userdoc.entity.DocMongo;
import com.fittest.userdoc.entity.Document;
import com.fittest.userdoc.entity.User;
import com.fittest.userdoc.entity.UserMongo;

import java.util.UUID;

public class Mapper {

    public static UserDto mapToDto(UserMongo user){
     UserDto userDto = new UserDto();
     userDto.setId(user.getId());
     userDto.setAge(user.getAge());
     userDto.setName(user.getName());
     userDto.setSurname(user.getSurname());

     return userDto;
    }

    public static UserMongo mapToMongoEntity(UserDto userDto){
        UserMongo user = new UserMongo();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setSurname(userDto.getSurname());

        return user;
    }

    public static User mapToEntity(UserDto userDto){
        User user = new User();
         user.setGuid(userDto.getId());
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setSurname(userDto.getSurname());

        return user;
    }

    public static DocDto mapToDto(DocMongo doc){
        DocDto docDto = new DocDto();
        docDto.setId(doc.getId());
        docDto.setDate(doc.getDate());
        docDto.setName(doc.getName());
        docDto.setNumber(doc.getNumber());

        return  docDto;
    }

    public static DocMongo mapToMongoEntity(DocDto docDto){
        DocMongo doc = new DocMongo();
        doc.setId(docDto.getId());
        doc.setDate(docDto.getDate());
        doc.setName(docDto.getName());
        doc.setNumber(docDto.getNumber());

        return  doc;
    }

    public static Document mapToEntity(DocDto docDto){
        Document doc = new Document();
        doc.setGuid(docDto.getId());
        doc.setDate(docDto.getDate());
        doc.setName(docDto.getName());
        doc.setNumber(docDto.getNumber());

        return  doc;
    }
}
