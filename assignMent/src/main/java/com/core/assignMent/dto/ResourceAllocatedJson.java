package com.core.assignMent.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ResourceAllocatedJson {
    private int id;
    private long userId;
    private long resourceId;
    private String resourceName;
}
