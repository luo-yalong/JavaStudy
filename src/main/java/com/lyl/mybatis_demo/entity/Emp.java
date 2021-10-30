package com.lyl.mybatis_demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Emp)表实体类
 *
 * @author 罗亚龙
 * @since 2021-10-26 11:19:34
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Emp extends Model<Emp> implements Serializable{
    private static final long serialVersionUID = 304572763849077964L;

    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private String name;
    
    private Integer sex;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 部门
     */
    private Integer dept;

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", dept=" + dept +
                '}';
    }
}

