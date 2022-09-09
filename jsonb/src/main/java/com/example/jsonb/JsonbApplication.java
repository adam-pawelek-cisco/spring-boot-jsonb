package com.example.jsonb;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsonb.data.Bio;
import com.example.jsonb.data.Child;
import com.example.jsonb.data.Parent;
import com.example.jsonb.data.ParentRepo;

@SpringBootApplication
@RestController
public class JsonbApplication {

	@Autowired
	ParentRepo  parentRepo;
	public static void main(String[] args) {
		SpringApplication.run(JsonbApplication.class, args);
		System.out.println(org.hibernate.Version.getVersionString());


	}

	@PostMapping()
	public void hello(@RequestBody Parent parent){
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

	@GetMapping()
	public List<Parent> getParent(){
		return parentRepo.findAll();
	}


}