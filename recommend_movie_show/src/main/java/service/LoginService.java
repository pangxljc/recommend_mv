package service;

import common.E3Result;

/**
 * Created by ZXL on 2018/3/2.
 */
public interface LoginService {
    //登录
    E3Result userLogin(String username, String password);
}
