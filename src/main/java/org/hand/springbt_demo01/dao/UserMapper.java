package org.hand.springbt_demo01.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hand.springbt_demo01.dto.User;
import org.hand.springbt_demo01.dto.UserVo;

import java.util.Date;
import java.util.List;

/**
 * @author 33206
 */
@Mapper
public interface UserMapper {

    /**
     * 查询接口函数
     * @return
     */
    List<User> queryUsers();

    /**
     * 条件查询
     * @param user
     * @return
     */
    User queryUser(User user);

    User queryByAge(User user);

    /**
     *
     * @param user_name
     * @param user_age
     * @param user_tel
     * @param create_time
     * @param update_time
     * @return
     */
    int insertUser(@Param("user_name") String user_name,@Param("user_age")  Integer user_age,
                   @Param("user_tel") String user_tel,@Param("create_time")  Date create_time, @Param("update_time") Date update_time);

    /**
     *
     * @param user_name
     * @return
     */
    int deleteUser(@Param("user_name") String user_name);

    /**
     * 更新用户信息
     * @param user_name
     * @param user_newName
     * @param user_newAge
     * @param user_newTel
     * @param update_time
     * @return
     */
    int updateUser(@Param("user_name")String user_name,
                   @Param("user_newName") String user_newName,
                   @Param("user_age") Integer user_newAge,
                   @Param("user_tel")String user_newTel,
                   @Param("update_time")Date update_time);


    List<UserVo> queryByCondition(@Param("user_name")String user_name,
                                  @Param("user_tel")String user_tel,
                                  @Param("role_code")Integer role_code,
                                  @Param("role_name")String role_name);
}
