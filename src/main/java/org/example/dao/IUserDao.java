package org.example.dao;

import org.example.bean.UserBean;
import org.example.model.User;

import java.util.List;

public interface IUserDao {
    UserBean getUserById(long id);
    List<UserBean> getAllUserList();
}
