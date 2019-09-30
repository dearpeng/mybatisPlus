package com.alimama.mybatisplus.entity;

import java.time.LocalDate;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 'cls.contract_account_view' is not BASE TABLE
 * </p>
 *
 * @author pwx
 * @since 2019-09-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 名字
     */
    private String lastName;

    /**
     * 性别 0:女 1:男
     */
    private Integer gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 部门id
     */
    private Long departmentId;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 生日
     */
    private LocalDate birth;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;


}
