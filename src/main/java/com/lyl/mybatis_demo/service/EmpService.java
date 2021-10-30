package com.lyl.mybatis_demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyl.mybatis_demo.common.pojo.Result;
import com.lyl.mybatis_demo.entity.Emp;

import java.io.Serializable;

/**
 * (Emp)表服务接口
 *
 * @author 罗亚龙
 * @since 2021-10-26 11:19:34
 */
public interface EmpService extends IService<Emp> {

    /**
     * 分页查询
     * @param pageNum 页码
     * @param pageSize 数量
     * @param keyword 关键字
     * @return Result
     */
    Result selectAll(int pageNum,int pageSize,String keyword);


    /**
     * 查询单条数据
     * @param id id
     * @return Result
     */
    Result selectOne(Serializable id);

}

