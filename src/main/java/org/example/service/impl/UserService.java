package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bean.UserBean;
import org.example.dao.IUserDao;
import org.example.mapper.UserMapper;
import org.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper,UserBean> implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public UserBean getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<UserBean> getAllUserList() {
        return userDao.getAllUserList();
    }
}
