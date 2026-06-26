package org.example.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.bean.UserBean;
import org.example.dao.IUserDao;
import org.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDao implements IUserDao {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserBean getUserById(long id) {
        var query = new LambdaQueryWrapper<UserBean>();
        query.select(UserBean::getId,UserBean::getName,UserBean::getAge,UserBean::getCreate_time)
                .eq(UserBean::getId,id);
        return userMapper.selectOne(query);
    }

    @Override
    public List<UserBean> getAllUserList() {
        var query = new LambdaQueryWrapper<UserBean>();
        return userMapper.selectList(query);
    }
}
