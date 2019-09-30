package com.alimama.mybatisplus.service.impl;

import com.alimama.mybatisplus.entity.Employee;
import com.alimama.mybatisplus.mapper.EmployeeMapper;
import com.alimama.mybatisplus.service.IEmployeeService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
