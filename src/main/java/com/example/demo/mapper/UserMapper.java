package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by wxj on 2018/8/9.
 */
@Repository
public interface UserMapper {

    @Select("select uid, usename from user where uid=#{uid}")
    User getOne(String uid);

    @Update("update user set usename=#{usename} where uid=#{uid}")
    boolean UpdateUsenameByUid(User user);

}
