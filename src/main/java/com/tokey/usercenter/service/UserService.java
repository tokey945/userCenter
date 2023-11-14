package com.tokey.usercenter.service;

import com.tokey.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tokey
 * @description 针对表【user(用户表)】的数据库操作Service
 * @createDate 2023-10-29 21:27:26
 */
public interface UserService extends IService<User> {
    /**
     * 用户注册
     * @param userAccount
     * @param userPassword
     * @param checkPassword
     * @return
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登陆
     * @param userAccount
     * @param userPassword
     * @param request
     * @return
     */
    User doLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);
}
