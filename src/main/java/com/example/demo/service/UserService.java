package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wxj on 2018/8/9.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserOne(String uid) {
        System.out.println("执行select语句");
        return userMapper.getOne(uid);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void UpdateUsenameByUid(User user/*String uid, String usename*/) {
        boolean b = false;
        try {
           b = userMapper.UpdateUsenameByUid(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("UpdateUsenameByUid() rollback");
        }
        System.out.println(b);
    }

}
