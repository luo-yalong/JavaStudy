package com.lyl.mybatis_demo.NormalTest;

import com.github.javafaker.Faker;
import com.lyl.mybatis_demo.utils.MockUtil;
import org.junit.jupiter.api.Test;

import java.util.Locale;

/**
 * @author 罗亚龙
 * @date 2021/10/27 11:20
 */
public class TestMock {

    @Test
    void test2(){
        for (int i = 0; i < 10; i++) {
            System.out.println("name = " + MockUtil.getChineseName() + " , sex = " + (MockUtil.getSex() == 0 ? "女" : "男") + " , age = " +
                    MockUtil.getAge(20,40));
        }
    }

    @Test
    void test3(){
        Faker faker = new Faker(Locale.CHINA);

        String address;
        for (int i = 0; i < 10; i++) {
            address = faker.address().cityName() + faker.address().streetAddress();
            System.out.println("name = " + faker.name().fullName() + " , sex = " + faker.random().nextInt(2) + " , age = " +
                    faker.random().nextInt(18,40) + " ,address = " + address);
        }
    }
}
