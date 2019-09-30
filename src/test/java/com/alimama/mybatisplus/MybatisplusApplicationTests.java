package com.alimama.mybatisplus;

import com.alibaba.fastjson.JSON;
import com.alimama.mybatisplus.entity.Employee;
import com.alimama.mybatisplus.service.IEmployeeService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.bytebuddy.matcher.ElementMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.Soundbank;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisplusApplicationTests {

    @Autowired
    private IEmployeeService employeeService;

    @Test
    public void contextLoads() {
        List<Employee> employees = employeeService.list();
        System.out.println("=============================================");
        System.out.println(JSON.toJSONString(employees));
        System.out.println("=============================================");
    }


    @Test
    public void testPage() {
        Page<Employee> page = new Page<>();
        page.setCurrent(1);
        page.setSize(3);
        IPage<Employee> employees = employeeService.selectEmployeeListByPage(page);
        System.out.println("=============================================");
        System.out.println("获取的总记录数:" + JSON.toJSONString(employees.getRecords()));
        System.out.println("=============================================");
        System.out.println("数据库总的记录数:" + JSON.toJSONString(employees.getTotal()));
        System.out.println("=============================================");
        System.out.println("每页的大小:" + JSON.toJSONString(employees.getSize()));
        System.out.println("=============================================");
        System.out.println("现在有多少页:" + JSON.toJSONString(employees.getPages()));
        System.out.println("=============================================");
    }

}
