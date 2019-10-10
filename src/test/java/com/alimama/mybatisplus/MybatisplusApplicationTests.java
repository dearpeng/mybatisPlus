package com.alimama.mybatisplus;

import com.alibaba.fastjson.JSON;
import com.alimama.mybatisplus.entity.Employee;
import com.alimama.mybatisplus.mapper.EmployeeMapper;
import com.alimama.mybatisplus.service.IEmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisplusApplicationTests {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void contextLoads() {
//        List<Employee> employees = employeeService.list();
        List<Employee> employees = employeeMapper.selectList(new QueryWrapper<Employee>().like("department_id", 3l));
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

    /**
     * 测试my自带分页
     */
    @Test
    public void testMpSelfPage() {
        IPage<Employee> employees= employeeService.page(new Page<>(1, 3),new QueryWrapper<Employee>().like("department_id",3L));
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
    @Test
    public void testListMap() {
        List<Map<String, Object>> maps = employeeService.listMaps(new QueryWrapper<Employee>().like("department_id", 3L));
        System.out.println("=============================================");
        System.out.println(maps);
        System.out.println("=============================================");
    }

    /**
     * 测试使用wrapper自定义sql,使用@Select,queryWrapper
     */
    @Test
    public void testWrapperCustomSql() {
        List<Employee> list = employeeService.mapperJavaWrappperSql(new QueryWrapper<Employee>().like("department_id",3l));
        System.out.println("=============================================");
        System.out.println(list);
        System.out.println("=============================================");
    }

    /**
     * 使用@Select,直接传参进去,不使用queryWrapper
     */
    @Test
    public void testWrapperCustomSql2() {
        Employee employee = new Employee();
        employee.setDepartmentId(3l);
        List<Employee> list = employeeService.mapperJavaWrappperSql2(employee);
        System.out.println("=============================================");
        System.out.println(list);
        System.out.println("=============================================");
    }

    /**
     * 使用xml,queryw
     */
    @Test
    public void testXmlWrapper() {
        List<Employee> list = employeeService.testXmlWrapper(new QueryWrapper<Employee>().eq("department_id",3L));
        System.out.println("=============================================");
        System.out.println(list);
        System.out.println("=============================================");
    }

    /**
     * 删除,没有逻辑删除前
     */
    @Test
    public void testlogicDelete() {
        Integer integer = employeeService.logicDelete(new QueryWrapper<Employee>().eq("department_id",3L));
        System.out.println("=============================================");
        System.out.println(integer);
        System.out.println("=============================================");
    }


    /**
     * 删除,使用逻辑删除
     */
    @Test
    public void testSelfLogicDelete() {
        Boolean integer= employeeService.remove(new QueryWrapper<Employee>().eq("department_id",3L));
        System.out.println("=============================================");
        System.out.println(integer);
        System.out.println("=============================================");
    }



}
