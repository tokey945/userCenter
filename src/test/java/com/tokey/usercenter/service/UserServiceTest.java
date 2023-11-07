package com.tokey.usercenter.service;

import com.tokey.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 用户服务测试
 * @author tokey
 */
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void addUserTest() {
        User user = new User();
        user.setUsername("tokey");
        user.setUserAccount("123");
        user.setAvatarUrl("https://images.zsxq.com/Ft4h8WySAXkI5WYAjHmoD7tklLHC?e=1701359999&token=kIxbL07-8jAj8w1n4s9zv64FuZZNEATmlU_Vm6zD:q7PR2cIWDT-CpbFQDYDjTFpAK8w=");
        user.setGender(1);
        user.setUserPassword("123");
        user.setPhone("123");
        user.setEmail("123");

        boolean result = userService.save(user);
        System.out.println(result);
        Assertions.assertTrue(result);
    }@Test

    public void userRegisterTest() {
        User user = new User();
        user.setUsername("tokey");
        user.setUserAccount("123");
        user.setAvatarUrl("https://images.zsxq.com/Ft4h8WySAXkI5WYAjHmoD7tklLHC?e=1701359999&token=kIxbL07-8jAj8w1n4s9zv64FuZZNEATmlU_Vm6zD:q7PR2cIWDT-CpbFQDYDjTFpAK8w=");
        user.setGender(1);
        user.setUserPassword("123");
        user.setPhone("123");
        user.setEmail("123");

        long result = userService.userRegister("tokey", "123456","123456");
        System.out.println(result);
    }

    @Test
    public void findUserByIdTest() {
        Integer id = 1;
        User user = userService.getById(id);
        System.out.println(user);


    }


}