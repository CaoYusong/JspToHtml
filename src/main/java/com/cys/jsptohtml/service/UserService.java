package com.cys.jsptohtml.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cys.jsptohtml.schema.User;

public class UserService {  
	  
    private static List<User> users = new ArrayList<User>();  
      
    static{  
        for(int i=0;i<10;i++){  
            User u = new User(i,"ajun"+i,i+10,new Date());  
            users.add(u);  
        }  
    }  
      
    public static List<User> getUsers(){  
        return users;  
    }  
      
    public static void delete(int index){  
        for(int i=0 ;i<users.size();i++){  
            User u = users.get(i);  
            if(u.getId()==index){  
                users.remove(u);  
                //users.remove(index);  
            }  
        }  
    }  
}  