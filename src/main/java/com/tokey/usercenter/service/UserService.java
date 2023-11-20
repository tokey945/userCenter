package com.tokey.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tokey.usercenter.model.domain.User;
import com.tokey.usercenter.model.domain.request.UserRegisterRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tokey
 * @description 针对表【user(用户表)】的数据库操作Service
 * @createDate 2023-10-29 21:27:26
 */
public interface UserService extends IService<User> {
    /**
     * 用户注册
     * @param userRegisterRequest
     * @return
     */
    long userRegister(UserRegisterRequest userRegisterRequest);

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

    /**
     * 注销登录
     * @param request
     * @return
     */
    Integer userLogOut(HttpServletRequest request);
}
