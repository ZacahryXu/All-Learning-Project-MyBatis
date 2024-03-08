package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther:Zachary Xu~
 * @version:1.0
 */
public interface SQLMapper {
    /**
     * 根据用户模糊查询用户信息
     */
    List<User> getUserByLike(@Param("username") String name);

    /**
     * 批量删除
     */
    int deleteMore(@Param("ids") String ids);
    /**
     * 查询指定表中的数据
     */
    List<User> getUserByTabName(@Param("tableName") String tableName);
    /**
     * 添加用户信息
     */
    void insertUser(User user);
}
