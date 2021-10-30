package com.lyl.mybatis_demo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * (Dept)表实体类
 *
 * @author 罗亚龙
 * @since 2021-10-26 11:19:34
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Dept extends Model<Dept> implements Serializable{
    private static final long serialVersionUID = -24829461143198122L;
    
    private Integer id;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 部门描述
     */
    private String descript;

}

