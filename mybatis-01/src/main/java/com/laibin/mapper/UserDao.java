package com.laibin.mapper;

import com.laibin.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserDao {
    @Select("SELECT * FROM user")
    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    //万能的Map
    int addUser2(Map<String, Object> map);

    int updateUser(User user);

    int deleteUser(int id);

    List<User> getUserLike(String value);
}