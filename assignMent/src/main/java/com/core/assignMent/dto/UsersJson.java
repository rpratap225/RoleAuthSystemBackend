package com.core.assignMent.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class UsersJson {
    private int id;
    private String userName;
    private long userId;
    private String position;
    private boolean read;
    private boolean write;
    private boolean delete;
    private int userType;
    private List<ResourceAllocatedJson> resourcesJsonList;
    private boolean option1;
    private boolean option2;
}
