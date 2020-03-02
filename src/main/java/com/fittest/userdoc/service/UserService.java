package com.fittest.userdoc.service;

import com.fittest.userdoc.Dto.DocDto;
import com.fittest.userdoc.Dto.UserDto;
import java.util.List;
import java.util.UUID;

public interface UserService {

    void create(UserDto user);

    boolean update(UserDto user, UUID id);

    boolean delete(UUID id);

    boolean addDocument(UUID id, DocDto document);

    List<DocDto> getDocuments(UUID id);

}