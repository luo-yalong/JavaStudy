package com.lyl.mybatis_demo.NormalTest;

import org.junit.jupiter.api.Test;

/**
 * @author 罗亚龙
 * @date 2021/10/27 10:27
 */
public class Tests2 {

    @Test
    void test1(){
        long l = 4194304L;
        l = l / 1024;
        System.out.println(l);

        System.out.println(l / 1024);


    }
}
