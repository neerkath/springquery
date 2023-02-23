package com.kgisl.springquery.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.springquery.model.Employee;
import com.kgisl.springquery.repository.UserRepository;



@RestController
@RequestMapping("/employee")

public class Usercontroller {
    @Autowired
       public UserRepository userRepository;
       @GetMapping("/")
public @ResponseBody ResponseEntity<List<Employee>> getAll() {
return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
}

@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Employee> getTeamById(@PathVariable("id") int id) {
Employee user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
return new ResponseEntity<>(user, HttpStatus.OK);
}

@PostMapping(value = "/create", headers = "Accept=application/json")
public ResponseEntity<Employee> createTeam(@RequestBody Employee user) {
Employee actualUser = userRepository.save(user);
HttpHeaders headers = new HttpHeaders();
return new ResponseEntity<>(actualUser, headers, HttpStatus.CREATED);
}

@PutMapping(value = "/{id}", headers = "Accept=application/json")
public ResponseEntity<Employee> updateUser(@PathVariable("id") int id, @RequestBody Employee currentUser) {
Employee user = userRepository.save(currentUser);
return new ResponseEntity<>(user, HttpStatus.OK);
}

@DeleteMapping(value = "/{id}", headers = "Accept=application/json")
public ResponseEntity<Employee> deleteUser(@PathVariable("id") int id) {
userRepository.deleteById(id);
return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}


}
