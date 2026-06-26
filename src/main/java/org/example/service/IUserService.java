package org.example.service;

import org.example.bean.UserBean;

import java.util.List;

public interface IUserService {
    UserBean getUserById(long id);
    List<UserBean> getAllUserList();
}
