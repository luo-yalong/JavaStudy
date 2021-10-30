package com.lyl.mybatis_demo.controller;


import com.lyl.mybatis_demo.common.pojo.Result;
import com.lyl.mybatis_demo.entity.Emp;
import com.lyl.mybatis_demo.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * (Emp)表控制层
 *
 * @author 罗亚龙
 * @since 2021-10-26 11:31:41
 */
@RestController
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmpController {
    /**
     * 服务对象
     */
    private final EmpService empService;

    @GetMapping
    public Result selectAll(@RequestParam(required = false,defaultValue = "1") int pageNum,
                            @RequestParam(required = false,defaultValue = "10") int pageSize,String keyword){
        return empService.selectAll(pageNum,pageSize,keyword);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result selectOne(@PathVariable Serializable id) {
        return empService.selectOne(id);
    }

    /**
     * 新增数据
     *
     * @param emp 实体对象
     * @return 新增结果
     */
    @PostMapping
    public Result insert(@RequestBody Emp emp) {
        System.out.println("插入数据：" + emp);
        this.empService.save(emp);
        return Result.success(empService.getById(emp.getId()));
    }

    /**
     * 修改数据
     *
     * @param emp 实体对象
     * @return 修改结果
     */
    @PutMapping
    @Transactional(rollbackFor = Exception.class)
    public Result update(@RequestBody Emp emp) {
        System.out.println("更新操作：" + emp);
        empService.updateById(emp);
        return Result.success(empService.getById(emp.getId()));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public Result delete(@RequestParam("idList") List<Long> idList) {
        empService.removeByIds(idList);
        return Result.success();
    }
}

