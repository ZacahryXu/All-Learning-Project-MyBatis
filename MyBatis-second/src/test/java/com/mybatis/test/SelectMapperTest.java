package com.mybatis.test;

import com.mybatis.mapper.SelectMapper;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @auther:Zachary Xu~
 * @version:1.0
 */
public class SelectMapperTest {
    /**
     * MyBatis的各种查询功能：
     * 1. 若查询出的数据只有一条
     * a>可以通过实体类对象接收
     * b>可以通过list集合接收
     * c>可以通过amp集合接收
     * 结果：{password=123456, sex=男, id=4, age=23, email=12345@qq.com, username=张三}
     * 2. 若查询出的数据有多条
     * a>可以通过实体类型的list集合接收
     * b>可以通过map类型的list集合接收
     * c>可以在mapper接口的方法上添加@MapKey注解，此时就可以将每条数据转换的map集合作为值，以某个字段的值作为字段，放在同一个map集合中
     * 注意：一定不能通过实体类对象接收，此时会抛出异常TooManyResultsException
     *
     * MyBatis中设置了默认的类型别名
     * java.lang.Integer-->int,integer
     * int-->_int,_integer
     * Map-->map
     * String-->string
     * 修改
     */
    @Test
    public void testGetAllUsertoMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());
    }
    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdToMap(4));
    }
    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUser());
    }
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(4));
    }

}
