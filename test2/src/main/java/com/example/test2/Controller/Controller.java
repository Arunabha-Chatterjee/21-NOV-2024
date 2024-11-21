package com.example.test2.Controller;

import com.example.test2.Model.Student;
import com.example.test2.Model.Users;
import com.example.test2.Repository.Repo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {
    List<Student> Students = new ArrayList<>(Arrays.asList(new Student(1, "Karan"),
            new Student(2, "Rohan")));


    @Autowired
    Repo repo;

    @GetMapping("/users")
    public List<Users> getStudents() {
        return repo.findAll();
    }

    @PostMapping("/register")
    public void register(@RequestBody Users user){
        repo.save(user);
    }

    @DeleteMapping("/delete/{Id}")
    public void DeleteUser(@PathVariable int Id){
        repo.deleteById(Id);
    }
}