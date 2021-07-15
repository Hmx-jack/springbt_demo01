package org.hand.springbt_demo01.controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hand.springbt_demo01.dao.UserMapper;
import org.hand.springbt_demo01.dto.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:  控制器层
 * @author: 33206-hmx
 **/

/**
 * 此处@RestController = @ResponseBody + @Controller
 * 服务器请求转到控制器层 再通过mapper地址转到对应的mapper函数
 */
@RestController
/**@Controller
@ResponseBody*/
public class HelloController {

    SqlSession sqlSession;
    UserMapper userMapper;
    User user;
    /**
     * mapper ：接受来自浏览器的hello请求
     * @ResponseBody :将我们的返回写给浏览器
     * @return
     */
    @RequestMapping("/hello")
    public String hello(){
        return "hello springBoot world!";

    }




}
