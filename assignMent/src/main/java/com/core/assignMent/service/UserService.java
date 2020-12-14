package com.core.assignMent.service;

import com.core.assignMent.dto.ResponseJson;
import com.core.assignMent.dto.UsersJson;

import java.util.List;

public interface UserService {
    public List<UsersJson> getAllUsers();

    public ResponseJson updateUser(UsersJson usersJson);

    public ResponseJson addUser(UsersJson usersJson);
}
