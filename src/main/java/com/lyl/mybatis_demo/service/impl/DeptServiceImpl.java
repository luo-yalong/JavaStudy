package com.lyl.mybatis_demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyl.mybatis_demo.common.pojo.Result;
import com.lyl.mybatis_demo.dao.DeptDao;
import com.lyl.mybatis_demo.entity.Dept;
import com.lyl.mybatis_demo.service.DeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Dept)表服务实现类
 *
 * @author 罗亚龙
 * @since 2021-10-26 11:19:34
 */
@Service("deptService")
@RequiredArgsConstructor
public class DeptServiceImpl extends ServiceImpl<DeptDao, Dept> implements DeptService {

    private final DeptDao deptDao;

    @Override
    public Result selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Dept> deptList = deptDao.selectList(null);
        PageInfo<Dept> info = new PageInfo<>(deptList);
        return Result.success(info);
    }
}

