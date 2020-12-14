package com.core.assignMent.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "resources")
public class Resources {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "resourceId")
    private long resourceId;
    @Column(name = "resourceName")
    private long resourceName;

}
