package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @auther:Zachary Xu~
 * @version:1.0
 */
public interface CacheMapper {
    Emp getEmpByEid(@Param("eid") Integer eid);
    void insertEmp(Emp emp);
}
