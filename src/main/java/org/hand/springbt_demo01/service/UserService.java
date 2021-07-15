package org.hand.springbt_demo01.service;

import org.apache.ibatis.annotations.Param;
import org.hand.springbt_demo01.dto.User;
import org.hand.springbt_demo01.dto.UserVo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    /**
     * service动态sql查询接口
     * @param user_name
     * @param user_tel
     * @param role_code
     * @param role_name
     * @return
     */
      List<UserVo> queryByConditon(String user_name,
                                   String user_tel,
                                   Integer role_code,
                                   String role_name);

}
