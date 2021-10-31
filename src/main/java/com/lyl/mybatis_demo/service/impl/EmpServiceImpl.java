package com.lyl.mybatis_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyl.mybatis_demo.common.pojo.Result;
import com.lyl.mybatis_demo.dao.EmpDao;
import com.lyl.mybatis_demo.entity.Emp;
import com.lyl.mybatis_demo.service.EmpService;
import com.lyl.mybatis_demo.vo.EmpVo;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Emp)表服务实现类
 *
 * @author 罗亚龙
 * @since 2021-10-26 11:19:34
 */
@Service("empService")
@AllArgsConstructor
public class EmpServiceImpl extends ServiceImpl<EmpDao, Emp> implements EmpService {

    private final EmpDao empDao;
    private final RedisTemplate redisTemplate;

    @Override
    public Result selectAll(int pageNum, int pageSize,String keyword) {
        PageHelper.startPage(pageNum,pageSize);

        //查询数据
        QueryWrapper<Emp> query = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(keyword)) {
            query.like("name", keyword);
        }
        List<Emp> empList = empDao.selectList(query);
        PageInfo<Emp> empPageInfo = new PageInfo<>(empList);
        List<EmpVo> empVoList = empList.stream().map(this::empToEmpVo).collect(Collectors.toList());

        PageInfo<EmpVo> empVoPageInfo = new PageInfo<>();
        BeanUtils.copyProperties(empPageInfo,empVoPageInfo);
        empVoPageInfo.setList(empVoList);



        return Result.success(empVoPageInfo);
    }

    private EmpVo empToEmpVo(Emp emp){
        EmpVo empVo = new EmpVo();
        BeanUtils.copyProperties(emp,empVo);
        empVo.setSex((emp.getSex() == 0) ? "女" : "男");
        return empVo;
    }

    @Override
    public Result selectOne(Serializable id) {
        //先从缓存中获取，如果有则直接返回
        //如果无，则查询mysql,并将数据设置到缓存
        String key = "user:" + id;
        Object empObj = redisTemplate.opsForValue().get(key);
        if (empObj == null) {
            synchronized (this.getClass()){
                //在同步代码块中再次查询缓存中数据
                empObj = redisTemplate.opsForValue().get(key);
                if (empObj == null) {
                    System.out.println("========查询数据库=========");
                    empObj = empDao.selectById(id);
                    redisTemplate.opsForValue().set(key, empObj);
                }else {
                    System.out.println("========缓存(同步代码块)=========>>>>>>>>>>>>>>>>");
                }
            }
        }else {
            System.out.println("========缓存=========>>>>>>>>>>>>>>>>");
        }
        return Result.success(empObj);
    }
}

