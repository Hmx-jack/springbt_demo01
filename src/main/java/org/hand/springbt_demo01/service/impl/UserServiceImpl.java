package org.hand.springbt_demo01.service.impl;

import org.hand.springbt_demo01.dao.UserMapper;
import org.hand.springbt_demo01.dto.User;
import org.hand.springbt_demo01.dto.UserVo;
import org.hand.springbt_demo01.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:
 **/
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<UserVo> queryByConditon(String user_name, String user_tel, Integer role_code, String role_name) {

        return userMapper.queryByCondition(user_name, user_tel,  role_code, role_name);
    }
}
