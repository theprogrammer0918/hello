package com.omcodes.hello.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class userDaoServices {
    private static List<User> users = new ArrayList<>();

    static{
        users.add(new User(1, "Adam",new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }
    public List<User> findAll(){
        return users;
    }

    public User save(User u){
        if(u.getId()==null){
            u.setId(users.size()+1);
        }
        users.add(u);
        return u;
    }

    public User find(int id){
        for(User i : users){
            if(i.getId() == id){
                return i;
            }
        }
        return null;
    }

    public User deleteUserById(int id){
        for(User i : users){
            if(i.getId()==id){
                users.remove(i);
                return i;
            }
        }
        return null;
    }
}
