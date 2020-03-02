package com.fittest.userdoc.service;

import com.fittest.userdoc.Dto.DocDto;
import com.fittest.userdoc.Dto.UserDto;
import com.fittest.userdoc.Mapper.Mapper;
import com.fittest.userdoc.entity.DocMongo;
import com.fittest.userdoc.entity.Document;
import com.fittest.userdoc.entity.User;
import com.fittest.userdoc.entity.UserMongo;
import com.fittest.userdoc.repository.DocumentMDRepository;
import com.fittest.userdoc.repository.DocumentRepository;
import com.fittest.userdoc.repository.UserMDRepository;
import com.fittest.userdoc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserServiceImpl implements UserService  {

    @Autowired
    private UserMDRepository userMDRepository;
    @Autowired
    private DocumentMDRepository documentMDRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public void create(UserDto userDto) {
        UserMongo userMongo = Mapper.mapToMongoEntity(userDto);
        UUID uuid = UUID.randomUUID();
        userMongo.setId(uuid);
        User user = Mapper.mapToEntity(userDto);
        user.setGuid(uuid);
        userMDRepository.save(userMongo);
        userRepository.save(user);
    }

    @Override
    public boolean update(UserDto userDto, UUID id) {
        Optional<User> userdb = userRepository.findByGuid(id);
        if(userdb.isPresent())
        {
            UserMongo usermongo = Mapper.mapToMongoEntity(userDto);
            usermongo.setId(id);
            User user = Mapper.mapToEntity(userDto);
            user.setId(userdb.get().getId());
            user.setGuid(id);
            userRepository.save(user);
            userMDRepository.save(usermongo);
            return true;
        }
        else return false;
    }

    @Override
    public boolean delete(UUID id) {
        Optional<User> user = userRepository.findByGuid(id);
        if(user.isPresent())
        {
            documentMDRepository.deleteByUserId(id);
            userMDRepository.deleteById(id);
            userRepository.deleteById(user.get().getId());
            return true;
        }
        else return false;
    }

    @Override
    public boolean addDocument(UUID userId, DocDto docDto) {
        Optional<User> userdb = userRepository.findByGuid(userId);
        if(userdb.isPresent())
        {
            UUID uuid = UUID.randomUUID();
            DocMongo docMongo = Mapper.mapToMongoEntity(docDto);
            docMongo.setId(uuid);
            docMongo.setUserId(userId);
            documentMDRepository.save(docMongo);
            Document doc = Mapper.mapToEntity(docDto);
            doc.setGuid(uuid);
            doc.setUser(userdb.get().getId());
            documentRepository.save(doc);
            return true;
        }
        else return false;
    }

    @Override
    public List<DocDto> getDocuments(UUID userId) {
        List<DocMongo> docs = documentMDRepository.findByUserIdAndDateAfter(userId, new Date());
        List<DocDto> docDtos = new ArrayList<DocDto>();
        for (DocMongo d: docs) {
            docDtos.add(Mapper.mapToDto(d));
        }
        return docDtos;
    }
}
