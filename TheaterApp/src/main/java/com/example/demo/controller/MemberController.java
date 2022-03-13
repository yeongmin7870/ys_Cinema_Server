package com.example.demo.controller;

import com.example.demo.model.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;


@RestController
public class MemberController {

    private Map<String, Member> memberMap;

    @Autowired
    private MemberService service;


    @GetMapping("/member/{id}")
    public Member getMember(@PathVariable("id") int id){
        return service.get(id);
    }

    @GetMapping("/members")
    public List<Member> list(){
        return service.listAll();
    }



}
