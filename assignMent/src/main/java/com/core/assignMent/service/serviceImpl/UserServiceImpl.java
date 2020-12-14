package com.core.assignMent.service.serviceImpl;

import com.core.assignMent.dto.ResourceAllocatedJson;
import com.core.assignMent.dto.ResponseJson;
import com.core.assignMent.dto.UsersJson;
import com.core.assignMent.models.ResourceAllocated;
import com.core.assignMent.models.Users;
import com.core.assignMent.repository.ResourceAllocatedRepository;
import com.core.assignMent.repository.UserRepository;
import com.core.assignMent.service.UserService;
import com.core.assignMent.utils.AtomicIdCounter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResourceAllocatedRepository resourceAllocatedRepository;

    @Override
    public List<UsersJson> getAllUsers() {
        List<Users> usersList = userRepository.findAll();
        List<UsersJson> usersJsons = new ArrayList<>();
        for (Users users: usersList) {
            UsersJson usersJson = new UsersJson();
            usersJson.setDelete(users.isDeleteOption());
            usersJson.setId(users.getId());
            usersJson.setPosition(users.getPosition());
            usersJson.setRead(users.isReadOption());
            usersJson.setUserId(users.getUserId());
            usersJson.setUserName(users.getUserName());
            usersJson.setUserType(users.getUserType());
            usersJson.setWrite(users.isWriteOption());
            List<ResourceAllocated> resourceAllocatedList = resourceAllocatedRepository.findAllByUserId(users.getUserId());
            List<ResourceAllocatedJson> resourceAllocatedJsons = new ArrayList<>();
            if (!resourceAllocatedList.isEmpty()) {
                for (ResourceAllocated resourceAllocated: resourceAllocatedList) {
                    ResourceAllocatedJson resourceAllocatedJson = new ResourceAllocatedJson();
                    BeanUtils.copyProperties(resourceAllocated, resourceAllocatedJson);
                    resourceAllocatedJsons.add(resourceAllocatedJson);
                }
            }
            usersJson.setResourcesJsonList(resourceAllocatedJsons);
            usersJson.setOption1(users.isOption1());
            usersJson.setOption2(users.isOption2());
            usersJsons.add(usersJson);
        }
        return usersJsons;
    }

    @Override
    public ResponseJson updateUser(UsersJson usersJson) {
        Users users = userRepository.findByUserId(usersJson.getUserId());
        users.setDeleteOption(usersJson.isDelete());
        users.setPosition(usersJson.getPosition());
        users.setReadOption(usersJson.isRead());
        users.setUserId(usersJson.getUserId());
        users.setUserName(usersJson.getUserName());
        users.setUserType(usersJson.getUserType());
        users.setWriteOption(usersJson.isWrite());
        users.setOption1(usersJson.isOption1());
        users.setOption2(usersJson.isOption2());
        userRepository.save(users);
        ResponseJson responseJson = new ResponseJson();
        responseJson.setMessage("Updated succesfully");
        responseJson.setResponseCode(200);
        return responseJson;
    }

    @Override
    public ResponseJson addUser(UsersJson usersJson) {
        Users users = new Users();
        users.setUserId(AtomicIdCounter.getUniqueID());
        users.setDeleteOption(usersJson.isDelete());
        users.setPosition(usersJson.getPosition());
        users.setReadOption(usersJson.isRead());
        users.setUserId(usersJson.getUserId());
        users.setUserName(usersJson.getUserName());
        users.setUserType(usersJson.getUserType());
        users.setWriteOption(usersJson.isWrite());
        users.setOption1(usersJson.isOption1());
        users.setOption2(usersJson.isOption2());
        userRepository.save(users);
        return null;
    }
}
