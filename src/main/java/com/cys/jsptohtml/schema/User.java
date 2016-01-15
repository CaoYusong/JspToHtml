package com.cys.jsptohtml.schema;

import java.util.Date;  

public class User {  
      
    private Integer id;  
  
    private String name ;  
      
    private int age;  
      
    private Date birthday;  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public int getAge() {  
        return age;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
  
    public Date getBirthday() {  
        return birthday;  
    }  
  
    public void setBirthday(Date birthday) {  
        this.birthday = birthday;  
    }  
  
      
    public Integer getId() {  
        return id;  
    }  
  
    public void setId(Integer id) {  
        this.id = id;  
    }  
  
    public User(Integer id,String name, int age, Date birthday) {  
        super();  
        this.name = name;  
        this.age = age;  
        this.birthday = birthday;  
        this.id = id;  
    }  
  
    public User() {  
        super();  
    }  
      
      
}  