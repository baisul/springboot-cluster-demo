package org.example.biz;

import org.example.bean.UserBean;
import org.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BizUser {
    @Autowired
    private IUserService userService;

    public UserBean getUserById(long id) {
        return userService.getUserById(id);
    }

    public List<UserBean> getAllUserList() {
        return null;
    }

}
