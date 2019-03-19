package kr.hs.dgsw.web_01_319;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements kr.hs.dgsw.web_01_319.UserService {

    List<User> userList;

    public UserServiceImpl() {
        userList = new ArrayList<>();
        userList.add(new User("1","user1","user111@dgsw"));
        userList.add(new User("2","user2","user222@dgsw"));
        userList.add(new User("3","user3","user333@dgsw"));
    }

    @Override
    public List<User> list(){
        return this.userList; //List의 모든 내용을 불러옴
    }

    @Override
    public User view(String id){
        return this.userList.stream()
                .filter(user -> user.getId().equals(id))
                .findAny()
                .orElse(null);
    }
    public User find1(String name) {
        Iterator<User> userIterator = this.userList.iterator();
        while (userIterator.hasNext()){
            User user = userIterator.next();
            if(user.getName().equals(name))
                return user;
        }
        return null;
    }
    public User find2(String name){
        for(User user : this.userList){
            if(user.getName().equals(name))
                return user;
        }
        return null;
    }
    public User find3(String name){
        User found = this.userList.stream()
                .filter(user -> user.getName().equals(name))
                .findAny()
                .orElse(null);
        return found;
    }

    @Override
    public boolean add(User user){
        User found = this.view(user.getId());
        if(found.equals(user.getId()))
            return this.userList.add(user);
        return false;
    }

    //??
    @PutMapping("/user")
    public User update(User user){
        User found = this.view(user.getId());
        if(found != null){
            found.setName(user.getName());
            found.setEmail(user.getEmail());
        }
        return found;
    }

    @Override
    public boolean delete(String id){
        User found = this.view(id);
        return this.userList.remove(found);
    }
}

//    @Override
//    public User view(String name){
//        for(int i=0; i<this.userList.size(); i++){
//            User found = this.userList.get(i);
//            if(found.getName().equals(name))
//                return found;
//        }
//        return null;
//    }
