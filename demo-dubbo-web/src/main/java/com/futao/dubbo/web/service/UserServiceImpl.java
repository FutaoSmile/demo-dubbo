package com.futao.dubbo.web.service;

import com.futao.api.model.user.User;
import com.futao.api.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Dubbo本地存根示例
 *
 * @author ft
 * @date 2021/1/13
 */
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserService userService;

    @Override
    public List<User> listUsers() {
        log.info("本地存根被调用");
        return userService.listUsers();
    }
}
