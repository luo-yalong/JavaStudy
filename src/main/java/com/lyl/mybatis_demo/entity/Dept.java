package com.lyl.mybatis_demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

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

    @TableId(type = IdType.AUTO)
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

