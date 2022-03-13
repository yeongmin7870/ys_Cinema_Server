package com.example.demo.controller;

import com.example.demo.model.Member;
import com.example.demo.service.MemberService;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@Controller
public class MemberController {

    private Map<String, Member> memberMap;

    @Autowired
    private MemberService service;

    @ResponseBody
    @RequestMapping("/test3")
    public String test3(){
        JsonObject obj = new JsonObject();

        obj.addProperty("member","라라라");

        return obj.toString();
    }


    @GetMapping("/member/{id}")
    public Member getMember(@PathVariable("id") int id){
        return service.get(id);
    }

    @GetMapping("/members")
    public List<Member> list(){
        return service.listAll();
    }



}
