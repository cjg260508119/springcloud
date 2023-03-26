package com.chen.sphere.test;

import com.chen.sphere.dao.StudentMapper;
import com.chen.sphere.entity.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName:MybatisPlusTest
 * @Auther: 26050
 * @Description:
 * @Date: 2023/3/13 17:53
 * @Version: v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Student> studentList = studentMapper.selectList(null);
        Assert.assertEquals(1, studentList.size());

        studentList.forEach(System.out::println);
    }
}
