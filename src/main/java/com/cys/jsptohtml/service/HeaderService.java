package com.cys.jsptohtml.service;

import com.cys.jsptohtml.schema.Header;




 
public class HeaderService {  
  
    private static Header h = new Header();  
      
    static{  
        h.setAddress("北京朝阳CBD");  
        h.setCompanyName("上海唐秀！！！");  
    }  
      
    public static void update(String address,String companyName){  
        h.setAddress(address);  
        h.setCompanyName(companyName);  
    }  
      
    public static Header getHeader(){  
        return h;  
    }  
}  