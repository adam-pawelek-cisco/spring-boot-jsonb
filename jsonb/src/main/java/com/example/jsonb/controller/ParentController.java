package com.example.jsonb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import com.example.jsonb.data.Parent;
import com.example.jsonb.data.ParentRepo;
import com.example.jsonb.service.ParentService;


@RestController
@RequiredArgsConstructor
public class ParentController {

    private final ParentService parentService;


    @PostMapping()
    public void addParent(@RequestBody Parent parent){
        parentService.addParent(parent);
    }

    @GetMapping()
    public List<Parent> getParent(){
        return parentService.getParent();
    }
}
