package cn.canying.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import cn.canying.bean.User;
import cn.canying.dao.UserMapper;
import cn.canying.services.UserService;

@Service("userServicesImpl")
public class UserServicesImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
    private RedisTemplate<Object,Object> redisTemplate;
	
	@Override
	public List<User> test() {
		// TODO Auto-generated method stub
		/**
         * redis序列化
         *//*
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        *//**
         * redis中查询
         *//*
        List<User> userList =  (List<User>)redisTemplate.opsForValue().get("");
        *//**
         * 查不到去数据库中查
         *//*
        if(null == userList){
        	userList = userMapper.test();
            *//**
             * 将数据放到redis中
             *//*
            redisTemplate.opsForValue().set("",userList,15, TimeUnit.MINUTES);
        }
        return userList;*/
		
		
		
		List<User>list=userMapper.test();
		return list;
	}
	
}
