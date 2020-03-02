package com.fittest.userdoc.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name="document")
public class Document {

    private long id;
    private String name;
    private Integer number;
    private Date date;
    private UUID guid;
    private long userId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="user_id", referencedColumnName = "id")
    @Column(name = "user_id")
    public long getUser() {
        return userId;
    }
    public void setUser(long userId) {
        this.userId = userId;
    }

    public UUID getGuid(){ return  guid; }
    public void setGuid(UUID uuid) { this.guid = uuid; }
}
