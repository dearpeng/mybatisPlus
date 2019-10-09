package com.alimama.mybatisplus.service.impl;

import com.alimama.mybatisplus.entity.Employee;
import com.alimama.mybatisplus.mapper.EmployeeMapper;
import com.alimama.mybatisplus.service.IEmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 'cls.contract_account_view' is not BASE TABLE 服务实现类
 * </p>
 *
 * @author pwx
 * @since 2019-09-29
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public IPage<Employee> selectEmployeeListByPage(Page<Employee> page) {
        return employeeMapper.selectEmployeeListByPage(page);
    }

    @Override
    public List<Employee> mapperJavaWrappperSql(QueryWrapper<Employee> employee) {
        return employeeMapper.mapperJavaWrappperSql(employee);
    }

    @Override
    public List<Employee> mapperJavaWrappperSql2(Employee employee) {
        return employeeMapper.mapperJavaWrappperSql2(employee);
    }

    @Override
    public List<Employee> testXmlWrapper(QueryWrapper<Employee> queryWrapper) {
        return employeeMapper.testXmlWrapper(queryWrapper);
    }
}
