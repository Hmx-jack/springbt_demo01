package org.hand.springbt_demo01.controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hand.springbt_demo01.dao.UserMapper;
import org.hand.springbt_demo01.dto.User;
import org.hand.springbt_demo01.dto.UserVo;
import org.hand.springbt_demo01.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 用户的增删改查
 * @author:
 **/
@RestController
public class UserController {
    SqlSession sqlSession;
    UserMapper userMapper;
    @Resource
    private UserService userService;

    /**
     *
     * @return 返回所有用户信息
     * @throws IOException
     */
    @RequestMapping("/query")
    public List<User> queryUser() throws IOException {
        /** 创建sql session factory */
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        /** 创建SqlSession 对象 */
        sqlSession = sqlSessionFactory.openSession();
        /**
         * mapper代理
         */
        userMapper = sqlSession.getMapper(UserMapper.class);

        List<User>  users = new ArrayList<>();
        users = userMapper.queryUsers();
        return users;
//        for(User us : users){
//            return ("用户名： "+us.getUser_id()+
//                    "用户名： "+us.getUser_name()+
//                    "年龄： "+us.getUser_age()+
//                    "联系电话： "+us.getUser_tel()+
//                    "创建时间"+us.getCreate_time()+
//                    "更新时间"+us.getUpdate_time());
//
//        }


    }

    /**
     *user不能用全局变量 血的教训！！
     * 这里不能用setter赋值 后面在于数据库对应时无法映射到 必须带入参数并在dao层指明字段值@Param
     * @param user_name
     * @param user_age 注意类型为integer包装类 否则会报类型错  血的教训！！！
     * @param user_tel
     * @param create_time
     * @param update_time
     * @return
     * @throws IOException
     */
    @RequestMapping("insert")
    public String insertUser(String user_name,Integer user_age,String user_tel,Date create_time,Date update_time ) throws IOException {
        /** 创建sql session factory */
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        /** 创建SqlSession 对象 */
        sqlSession = sqlSessionFactory.openSession();
        /**
         * mapper代理
         */
        userMapper = sqlSession.getMapper(UserMapper.class);
        user_name = "Jack";
        user_age = 23;
        user_tel = "15109514416";
        Date date = new Date();
        create_time = date;
        update_time = date;
        User user = new User();
        user.setUser_name(user_name);
        user.setUser_age(user_age);
        user.setUser_tel(user_tel);

        user.setCreate_time(create_time);
        user.setUpdate_time(update_time);
        int sign = userMapper.insertUser(user_name,user_age,user_tel,create_time,update_time);
        sqlSession.commit();
        sqlSession.close();
        return "插入用户记录："+
                    "\n\t 用户名： "+user.getUser_name()+
                    "\n\t 年龄： "+user.getUser_age()+
                    "\n\t 联系电话： "+user.getUser_tel()+
                    "\n\t 创建时间"+user.getCreate_time()+
                    "\n\t 更新时间"+user.getUpdate_time();
    }

    /**
     * 按照用户名删除用户信息
     * @param user_name
     * @return
     * @throws IOException
     */
    @RequestMapping("delete")
    public String deleteUser(String user_name) throws IOException {
        /** 创建sql session factory */
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        /** 创建SqlSession 对象 */
        sqlSession = sqlSessionFactory.openSession();
        /**
         * mapper代理
         */
        userMapper = sqlSession.getMapper(UserMapper.class);
        User user= new User();
        user_name = "jack";
        user.setUser_name(user_name);
        int sign = userMapper.deleteUser(user_name);
        sqlSession.commit();
        sqlSession.close();
        return "删除用户： "+user.getUser_name();
    }

    @RequestMapping("update")
    public String updateUser(String user_name,String user_newName,Integer user_newAge,String user_newTel,Date update_time ) throws IOException {
        /** 创建sql session factory */
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        /** 创建SqlSession 对象 */
        sqlSession = sqlSessionFactory.openSession();
        /**
         * mapper代理
         */
        userMapper = sqlSession.getMapper(UserMapper.class);
        user_name = "jack";
        user_newName = "Jack";
        user_newAge = 23;
        user_newTel = "15109514416";

        Date date = new Date();
        update_time = date;

        int sign = userMapper.updateUser(user_name,user_newName,user_newAge,user_newTel,update_time);
        sqlSession.commit();
        sqlSession.close();
        return "更新用户： "+user_name+"-->"+user_newName;
    }


    @RequestMapping("/queryByCondition")
    public List<UserVo> queryUserByCondition()  {


        String user_name = "mimi";
        String user_tel = "10086";
        Integer role_code = null;
        String role_name = null;
        List<User>  users = new ArrayList<>();
        List<UserVo>  userVos = new ArrayList<>();
        userVos = userService.queryByConditon(user_name, user_tel,  role_code, role_name);
        return userVos;


    }

}
