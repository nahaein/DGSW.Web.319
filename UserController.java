package kr.hs.dgsw.web_01_319;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.font.TextHitInfo;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    @ResponseBody
    public List<User> list(){
        return this.userService.list();
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User view(@PathVariable String id){
        return this.userService.view(id);
    }

    @PostMapping("/user")
    @ResponseBody
    public boolean add(@RequestBody User user){ return this.userService.add(user); }

    @PutMapping("/user")
    @ResponseBody
    public User update(@RequestBody User user){
        return this.userService.update(user);
    }

    @DeleteMapping("/user/{name}") @ResponseBody
    public boolean delete(@PathVariable String name){
        return this.userService.delete(name);
    }
}

//POST(insert) GET(read) PUT(update) DELETE(delete)
//CURD Create(insert) Read Update Delete
//i     nsert       select update delete
