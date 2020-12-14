package com.core.assignMent.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class Users {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "userId")
    private long userId;
    @Column(name = "position")
    private String position;
    @Column(name = "readOption")
    private boolean readOption;
    @Column(name = "writeOption")
    private boolean writeOption;
    @Column(name = "deleteOption")
    private boolean deleteOption;
    @Column(name = "userType")
    private int userType;
    @Column(name = "option1")
    private boolean option1;
    @Column(name = "option2")
    private boolean option2;
}
