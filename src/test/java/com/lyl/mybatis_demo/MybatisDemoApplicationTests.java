package com.lyl.mybatis_demo;

import com.github.javafaker.Faker;
import com.lyl.mybatis_demo.dao.DeptDao;
import com.lyl.mybatis_demo.dao.EmpDao;
import com.lyl.mybatis_demo.entity.Dept;
import com.lyl.mybatis_demo.entity.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SpringBootTest
class MybatisDemoApplicationTests {

    @Resource
    private EmpDao empDao;
    @Resource
    private DeptDao deptDao;

    @Test
    void testInsertDept(){
        List<Dept> deptList = new ArrayList<>();
        deptList.add(new Dept().setName("开发部").setDescript("开发新产品"));
        deptList.add(new Dept().setName("采购部").setDescript("采购企业所需的用品"));
        deptList.add(new Dept().setName("财务部").setDescript("管理企业的财务"));
        deptList.add(new Dept().setName("人事部").setDescript("为企业招聘人才"));
        deptList.add(new Dept().setName("销售部").setDescript("销售公司开发出的产品"));
        deptDao.insertBatch(deptList);
    }

    @Test
    void testInsert() {
        Faker faker = new Faker(Locale.CHINA);

        long start = System.currentTimeMillis();
        List<Emp> empList = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            empList.add(new Emp()
                    .setName(faker.name().fullName())
                    .setAge(faker.random().nextInt(18, 40))
                    .setSex(faker.random().nextInt(2))
                    .setDept(faker.random().nextInt(1, 5))
            );
        }
        long end = System.currentTimeMillis();
        System.out.println("生成数据-运行时间:" + (end - start) + "ms");


        start = System.currentTimeMillis();
        int i = empDao.insertBatch(empList);
        System.out.println("i = " + i);
        end = System.currentTimeMillis();
        System.out.println("批量插入-运行时间:" + (end - start) + "ms");
    }

}
