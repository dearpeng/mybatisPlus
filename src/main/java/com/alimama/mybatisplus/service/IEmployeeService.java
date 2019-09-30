package com.alimama.mybatisplus.service;

import com.alimama.mybatisplus.entity.Employee;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.PrivateKey;
import java.util.List;

/**
 * <p>
 * 'cls.contract_account_view' is not BASE TABLE 服务类
 * </p>
 *
 * @author pwx
 * @since 2019-09-29
 */
public interface IEmployeeService extends IService<Employee> {


    // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
    // page.setOptimizeCountSql(false);
    // 当 total 为小于 0 或者设置 setSearchCount(false) 分页插件不会进行 count 查询
    // 要点!! 分页返回的对象与传入的对象是同一个
    IPage<Employee> selectEmployeeListByPage(Page<Employee> page);
}