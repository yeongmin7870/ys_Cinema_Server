package com.example.demo.service;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MemberService {

    @Autowired
    private MemberRepository mepo;


    public List<Member> listAll(){
        return mepo.findAll();
    }

    public Member get(int id) {
        return mepo.findById(id).get();
    }
}
