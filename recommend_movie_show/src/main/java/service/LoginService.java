package service;

import common.E3Result;

public interface LoginService {
    //登录
    E3Result userLogin(String username, String password);
}
