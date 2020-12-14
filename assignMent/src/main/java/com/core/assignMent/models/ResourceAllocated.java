package com.core.assignMent.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "resourceAllocated")
public class ResourceAllocated {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "userId")
    private long userId;
    @Column(name = "resourceId")
    private long resourceId;
    @Column(name = "resourceName")
    private String resourceName;

}
