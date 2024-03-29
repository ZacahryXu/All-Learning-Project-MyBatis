package com.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.mapper.EmpMapper;
import com.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @auther:Zachary Xu~
 * @version:1.0
 */
public class PageHelperTest {
    /**
     * limit index,pageSize
     * index:当前页的起始索引
     * pageSize：每页显示的条数
     * pageNum；当前页的页码
     * index=(pageNum-1)*pageSize
     *
     * 使用MyBatis的分页插件实现分页功能：
     * 1.需要在查询功能之前开启分页
     * PageHelper.startPage(int pageNum,int pageSize);
     * 2.在查询功能之后获取分页相关信息
     *  PageInfo<Emp> page = new PageInfo<>(list, 5);
     *  List表示分页数据
     *  5表示当前导航分页的数量
     */
    @Test
    public void testPageHelper(){
        {
            try {
                InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
                SqlSession sqlSession = sqlSessionFactory.openSession(true);
                EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
                //Page<Object> page =PageHelper.startPage(2,4);
                PageHelper.startPage(2,4);
                List<Emp> list =mapper.selectByExample(null);
                PageInfo<Emp> page = new PageInfo<>(list, 5);
                //list.forEach(emp -> System.out.println(emp));
                System.out.println(page);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
