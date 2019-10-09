package com.alimama.mybatisplus.mapper;

import com.alimama.mybatisplus.entity.Employee;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 'cls.contract_account_view' is not BASE TABLE Mapper 接口
 * </p>
 *
 * @author pwx
 * @since 2019-09-29
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
    /**
     * <p>
     * 查询 : 查询用户列表，分页显示
     * 注意!!: 如果入参是有多个,需要加注解指定参数名才能在xml中取值
     * </p>
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @return 分页对象
     */
    IPage<Employee> selectEmployeeListByPage(Page<Employee> page);

    @Select("select * from employee ${ew.customSqlSegment}")
    List<Employee> mapperJavaWrappperSql(@Param(Constants.WRAPPER)QueryWrapper<Employee> eq);

    @Select("select * from employee where department_id = #{employee.departmentId}")
    List<Employee> mapperJavaWrappperSql2(@Param("employee") Employee employee);

    List<Employee> testXmlWrapper(@Param(Constants.WRAPPER) QueryWrapper<Employee> queryWrapper);
}
