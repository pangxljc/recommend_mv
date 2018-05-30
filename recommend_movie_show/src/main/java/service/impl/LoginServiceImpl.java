package service.impl;

import common.E3Result;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import po.User;
import po.UserExample;
import service.LoginService;

import java.util.List;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public E3Result userLogin(String username, String password) {
        // 1、判断用户和密码是否正确
        // 根据用户名查询用户信息
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        // 执行查询
        List<User> list = userMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            // 返回登录失败
            return E3Result.build(400, "用户名或密码错误");
        }
        // 取用户信息
        User user = list.get(0);
        // 判断密码是否正确
        if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
            // 2、如果不正确，返回登录失败
            return E3Result.build(400, "用户名或密码错误");
        } else {
            return E3Result.ok(user);
        }
    }
}
