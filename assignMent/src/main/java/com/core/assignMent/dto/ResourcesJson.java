package com.core.assignMent.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ResourcesJson {
    private int id;
    private long resourceId;
    private long resourceName;
}
