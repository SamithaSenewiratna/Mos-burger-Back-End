package icet.edu.controller;



import icet.edu.dto.User;
import icet.edu.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {


final private UserService service;

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        service.addUser(user);
    }


    @GetMapping("/alluser")
    public List<User> getUser(){
        return service.getUser();

    }


    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id){

        service.deleteUser(id);

    }
    @PutMapping("/updateCustomer")
    public void updateUser(@RequestBody User user){
        service.updateUser(user);

    }

    @GetMapping("/searchById/{id}")
    public User searchUser(@PathVariable Integer id){
        return service.searchUser(id);

    }



    @GetMapping("/searchByEmail/{email}")
    public List<User> searchUserByEmail(@PathVariable String email){
        return service.searchUserByEmail(email);

    }


    // Search by Email and Password (Using Query Parameters for Security)
    @GetMapping("/searchForLog")
    public User searchUser(
            @RequestParam String email,
            @RequestParam String password) {

        User user = service.findUserByEmailAndPassword(email , password);

        return user;

    }



}
