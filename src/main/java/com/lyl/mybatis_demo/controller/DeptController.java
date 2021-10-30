package com.lyl.mybatis_demo.controller;



import com.lyl.mybatis_demo.common.pojo.Result;
import com.lyl.mybatis_demo.entity.Dept;
import com.lyl.mybatis_demo.service.DeptService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * (Dept)表控制层
 *
 * @author 罗亚龙
 * @since 2021-10-26 11:31:39
 */
@RestController
@AllArgsConstructor
@RequestMapping("/dept")
public class DeptController {
    /**
     * 服务对象
     */
    private final DeptService deptService;

    /**
     * 分页查询
     * @param pageNum 页码
     * @param pageSize 数量
     * @return Result
     */
    @GetMapping
    public Result selectAll(@RequestParam(required = false,defaultValue = "1") int pageNum,
                            @RequestParam(required = false,defaultValue = "10") int pageSize){
        return deptService.selectAll(pageNum,pageSize);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result selectOne(@PathVariable Serializable id) {
        return Result.success(deptService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param dept 实体对象
     * @return 新增结果
     */
    @PostMapping
    public Object insert(@RequestBody Dept dept) {
        return this.deptService.save(dept);
    }

    /**
     * 修改数据
     *
     * @param dept 实体对象
     * @return 修改结果
     */
    @PutMapping
    public Object update(@RequestBody Dept dept) {
        return deptService.updateById(dept);
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public Object delete(@RequestParam("idList") List<Long> idList) {
        return deptService.removeByIds(idList);
    }
}

