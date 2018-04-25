package com.zrq.controller;

import com.zrq.entity.User;
import com.zrq.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by zrq on 2018-4-18.
 *
 * 用于页面路径跳转
 */
@SessionAttributes({"user"})
@Controller
@RequestMapping("/")
public class UrlController {
    @Autowired
    private LoginService loginService;
    /**
     * 默认进入系统返回页面
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/url")
    public String url(){return "url";}

    @RequestMapping("/login")
    public String login(){return "login";}

    @RequestMapping("/home")
    public String home(){return "home";}

    /**
     * 登录验证
     * @param user
     * @param role
     * @return
     */
    @RequestMapping("validate")
    public String validate(User user, @RequestParam(required = false) String role, Map<String,Object> map){
        User existUser=loginService.findUser(user);
        if(existUser!=null) {
            existUser.setPassword("");
            map.put("user",existUser);
            return "home";
        }
        String msg="用户名或密码错误";
        map.put("msg",msg);
        return "login";
    }

    /**
     * 后台向前端传值方式一
     *
     * 前端HTML页面需添加xmlns:th命名空间来使用后台的传值
     * @param map
     * @return
     */
    @RequestMapping("/test")
    public String test(Map<String,Object> map){
        map.put("hello","嘻嘻嘻");
        return "test";
    }

    /**
     * 后台向前端传值方式二
     *
     * 前端HTML页面需添加xmlns:th使用后台的传值
     * @param model
     * @return
     */
    @RequestMapping("test2")
    public String test2(Model model){
        model.addAttribute("hello","hahahha");
        return "test";
    }
}
