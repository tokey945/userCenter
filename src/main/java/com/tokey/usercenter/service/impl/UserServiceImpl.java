package com.tokey.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tokey.usercenter.model.domain.User;
import com.tokey.usercenter.service.UserService;
import com.tokey.usercenter.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tokey
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2023-10-29 21:27:26
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 加盐
     */
    private static final String SALT = "tokey";
    private static final String USER_LOGIN_STATUS = "tokey";

    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        //校验
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
            //todo 修改自定义异常
            return -1;
        }
        if (userAccount.length() < 4) {
            return -1;
        }
        if (userPassword.length() < 8 || checkPassword.length() < 8) {
            return -1;
        }
        if (!userPassword.equals(checkPassword)) {
            return -1;
        }
        //账户不能含有特殊字符
        Matcher matcher = Pattern.compile("[`~!@#$^&*()=|{}':;',\\\\[\\\\].<>/?~！@#￥……&*（）――|{}【】‘；：”“'。，、？]").matcher(userAccount);
        if (matcher.find()) {
            return -1;
        }

        //账户不能重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        long count = userMapper.selectCount(queryWrapper);
        if (count > 0) {
            return -1;
        }
        //加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        //插入数据
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(encryptPassword);
        boolean result = this.save(user);
        if (!result) {
            return -1;
        }
        return user.getId();    //id为null会报错
    }

    /**
     * 用户登陆
     * @param userAccount
     * @param userPassword
     * @return
     */
    @Override
    public User doLogin(String userAccount, String userPassword, HttpServletRequest request) {
        //校验
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return null;
        }
        if (userAccount.length() < 4) {
            return null;
        }
        if (userPassword.length() < 8 ) {
            return null;
        }
        //账户不能含有特殊字符
        Matcher matcher = Pattern.compile("[`~!@#$^&*()=|{}':;',\\\\[\\\\].<>/?~！@#￥……&*（）――|{}【】‘；：”“'。，、？]").matcher(userAccount);
        if (matcher.find()) {
            return null;
        }
        //加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());

        //查询用户是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        queryWrapper.or();
        queryWrapper.eq("userPassword", encryptPassword);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            log.info("user login failed, userAccount cannot match userPassword");
            return null;
        }
        //脱敏
         User safetyUser = new User();
         safetyUser.setId(user.getId());
         safetyUser.setUsername(user.getUsername());
         safetyUser.setUserAccount(user.getUserAccount());
         safetyUser.setAvatarUrl(user.getAvatarUrl());
         safetyUser.setGender(user.getGender());
         safetyUser.setPhone(user.getPhone());
         safetyUser.setEmail(user.getEmail());
         safetyUser.setUserStatus(user.getUserStatus());
         safetyUser.setCreateTime(user.getCreateTime());

        //记录用户的登录态
        request.getSession().setAttribute(USER_LOGIN_STATUS, safetyUser);
        return safetyUser;
    }

}




