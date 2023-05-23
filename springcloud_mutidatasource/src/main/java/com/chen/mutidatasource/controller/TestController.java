package com.chen.mutidatasource.controller;

import com.chen.mutidatasource.dao.StudentMapper;
import com.chen.mutidatasource.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName:TestController
 * @Auther: 26050
 * @Description:
 * @Date: 2023/3/13 18:13
 * @Version: v1.0
 */
@RestController
public class TestController {

    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/shpere/test")
    public List<Student> test(){
        return studentMapper.selectList(null);
    }
}
