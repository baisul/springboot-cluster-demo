package org.example.dao;

import org.example.bean.UserBean;
import org.example.model.User;

public interface IUserDao {
    UserBean getUserById(long id);
}
