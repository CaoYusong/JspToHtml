package com.cys.jsptohtml.service;

import com.cys.jsptohtml.schema.Footer;



public class FooterService {  
  
    private static Footer f = new Footer();  
    static{  
        f.setDes("����-�ȷ�-�ù�˾�أ��������۹���������");  
    }  
      
    public static void update(String des){  
        f.setDes(des);  
    }  
      
    public static Footer gerFooter(){  
        return f;  
    }  
}  
