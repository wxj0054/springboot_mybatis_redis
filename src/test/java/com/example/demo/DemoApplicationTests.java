package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@MapperScan("com.example.demo.mapper")
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisService redisService;

    @Test
    public void contextLoads() {
        User userOne = getUserOne("1");
        System.out.println(userOne);

        userOne = getUserOne("1");
        System.out.println(userOne);

        userOne = getUserOne("1");
        System.out.println(userOne);
    }

    @Cacheable("user")
    public User getUserOne(String id) {
        System.out.println("执行sql语句");
        return userMapper.getOne(id);
    }

    @Test
    public void redisSet() {
        boolean b = redisService.set("k100", "v100");
        if (b)
            System.out.println("插入成功");
        else
            System.out.println("插入失败");
    }

    @Test
    public void redisRemove() {
        boolean b = redisService.remove("k100");
        if (b)
            System.out.println("删除成功");
        else
            System.out.println("删除失败");
    }
}
