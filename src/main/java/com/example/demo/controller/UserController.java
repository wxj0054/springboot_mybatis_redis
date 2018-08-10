package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wxj on 2018/8/9.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUserOne")
    @Cacheable("userCache")
    public User getUserOne(@RequestParam String uid){
        return userService.getUserOne(uid);
    }

    @RequestMapping("UpdateUsenameByUid")
    //清除掉全部缓存
    @CacheEvict(value="userCache",allEntries=true)
    public void UpdateUsenameByUid(User user/*@RequestParam String uid, @RequestParam String usename*/){
        userService.UpdateUsenameByUid(user/*uid, usename*/);
    }

}
