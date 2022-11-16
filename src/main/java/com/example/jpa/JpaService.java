package com.example.jpa;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaService {
    
    @Autowired
    JpaRepository jpaRepository;

    Logger log = LoggerFactory.getLogger("JpaService");

    // Entityインスタンスリストを取得し、そのまま返却する
    public Iterable<User> findAllList(){
        Iterable<User> userList = jpaRepository.findAll();
        log.info("userList" + String.valueOf(userList));
        return userList;
    }

    // Entityインスタンスリストを取得し、要素をMap型に整形したものを返却する
    public Map<Integer, String> findAllMap() {
        Iterable<User> userList = jpaRepository.findAll();

        Map<Integer, String> userMap = new HashMap<>();
        for(User user: userList){
            userMap.put(user.getId(), user.getName());
        };
        log.info("userMap" + String.valueOf(userMap));
        
        return userMap;
    }
  
}
