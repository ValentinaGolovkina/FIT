package com.fittest.userdoc.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
//@Getter
//@Setter
@Table(name="office_user")
public class User {

    public User(){}
    private long id;
    private String name;
    private String surname;
    private Integer age;
    private UUID guid;


    private List<Document> documents = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id", nullable = false, insertable = true, updatable = true)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", length = 40)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname", length = 60)
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "guid")
    public UUID getGuid() {
        return guid;
    }
    public void setGuid(UUID guid) {
        this.guid = guid;
    }



    /* mappedBy - свойство в ContactTelDetailEntity, связанное с внешнем ключом в этой таблице
       cascade - операция обновления должна распространяться на дочерние записи
       orphanRemoval - после обновления, записи которых больше нет в наборе должны быть удалены из БД
    */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<Document> getDocuments() {
        return documents;
    }
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

}
