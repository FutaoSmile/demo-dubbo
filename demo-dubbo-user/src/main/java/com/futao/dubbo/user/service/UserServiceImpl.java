package com.futao.dubbo.user.service;

import com.futao.api.model.user.User;
import com.futao.api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author futao
 * @date 2021/1/7
 */
@Service
@org.apache.dubbo.config.annotation.Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> listUsers() {
        return Arrays.asList(new User(), new User());
    }
}
