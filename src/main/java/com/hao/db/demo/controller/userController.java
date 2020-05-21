package com.hao.db.demo.controller;

import com.hao.db.demo.bean.Userloginlog;
import com.hao.db.demo.mapper.UserloginlogMapper;
import com.hao.db.demo.service.redisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class userController {

    @Autowired
    UserloginlogMapper userloginlogMapper;

    @Autowired
    redisService redisService;

    @PostMapping("/getUserList")
    public List<Userloginlog> getUserList(){


        List<Userloginlog> list = userloginlogMapper.getList();

        boolean aaa = redisService.set("aaa", list.get(0));

        System.out.println(aaa);


        return list;

    }

    @PostMapping("/setholler")
    public Map<String,Object>  setholler(@RequestParam("username")String username, @RequestParam("password")String password){

        Userloginlog aaa = (Userloginlog) redisService.get("aaa");

        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        map.put("aaa",aaa);

        return map;

    }






}
