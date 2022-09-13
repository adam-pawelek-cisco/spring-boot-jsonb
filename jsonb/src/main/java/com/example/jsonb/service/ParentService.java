package com.example.jsonb.service;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.example.jsonb.data.Bio;
import com.example.jsonb.data.Child;
import com.example.jsonb.data.Parent;
import com.example.jsonb.data.ParentRepo;


@Service
@RequiredArgsConstructor
public class ParentService {
    private  final ParentRepo parentRepo;

    public void addParent(Parent parent){

        parentRepo.save(parent);
    }

    public void addParents(){
        List<Parent> parents = new ArrayList<Parent>();
        for (int i = 0; i < 10000; i++) {
            parents.add(new Parent(
                            "parent1",
                            asList(new Child("child1"), new Child("child2")),
                            new Bio("bio1")
                    )
            );
        }
        long startTime = System.nanoTime();
        parentRepo.saveAll(parents);
        long endTime   = System.nanoTime();
        long totalTime = TimeUnit.NANOSECONDS.toSeconds(endTime - startTime);
        System.out.println(totalTime);
    }


    public List<Parent> getParent(){
        return parentRepo.findAll();
    }
}
