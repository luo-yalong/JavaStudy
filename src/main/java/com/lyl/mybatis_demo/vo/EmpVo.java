package com.lyl.mybatis_demo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author 罗亚龙
 * @date 2021/10/27 16:15
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class EmpVo {
    private Integer id;

    private String name;

    private String sex;
    /**
     * 年龄
     */
    private Integer age;
}
