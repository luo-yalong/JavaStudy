package com.lyl.mybatis_demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyl.mybatis_demo.common.pojo.Result;
import com.lyl.mybatis_demo.entity.Dept;

/**
 * (Dept)表服务接口
 *
 * @author 罗亚龙
 * @since 2021-10-26 11:19:34
 */
public interface DeptService extends IService<Dept> {


    /**
     * 分页查询
     * @param pageNum 页码
     * @param pageSize 数量
     * @return Result
     */
    Result selectAll(int pageNum, int pageSize);
}

