package com.example.jpa;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JpaController {

    @Autowired
    JpaService jpaService;

    @GetMapping("/")
    public String displayE(Model model){
      // Entityインスタンスリストを取得する
      Iterable<User> userList = jpaService.findAllList();

      // DBから取得した値を整形したMapを取得する
      Map<Integer, String> userMap = jpaService.findAllMap();

      model.addAttribute("userList", userList);
      model.addAttribute("userMap", userMap);
      return "view";
    }

}