package com.example.jsonb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.example.jsonb.data.Parent;
import com.example.jsonb.data.ParentRepo;


@Service
@RequiredArgsConstructor
public class ParentService {
    private  final ParentRepo parentRepo;

    public void addParent(Parent parent){
		/*
		parentRepo.save(new Parent(
						"parent1",
						asList(new Child("child1"), new Child("child2")),
						new Bio("bio1")
				)
		);
		 */
        parentRepo.save(parent);
    }


    public List<Parent> getParent(){
        return parentRepo.findAll();
    }
}
