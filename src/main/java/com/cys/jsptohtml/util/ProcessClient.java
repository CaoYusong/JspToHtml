package com.cys.jsptohtml.util;

import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cys.jsptohtml.schema.Footer;
import com.cys.jsptohtml.schema.Header;
import com.cys.jsptohtml.schema.User;
import com.cys.jsptohtml.service.FooterService;
import com.cys.jsptohtml.service.HeaderService;
import com.cys.jsptohtml.service.UserService;

import freemarker.template.Template;
  
 
  
/** 
 * @author ajun   
 **/  
public class ProcessClient {  
	
    private static Map<String,Object> root = new HashMap<String,Object>();  
  
    /** 
     * 调用FreeMarkertUtil.java 
     * FreeMarkertUtil.processTemplate("body.ftl", root, out); 
     * 来生成html文件 
     * @param out 
     */  
    public static void processBody(Writer out,String filename){  
        Header h = HeaderService.getHeader();  
        root.put("h", h);  
        Footer f = FooterService.gerFooter();  
        root.put("f", f);  
        List<User> users = UserService.getUsers();  
        root.put("users", users);
        FreeMarkertUtil freeMarkertUtil = new FreeMarkertUtil();
        Template template = freeMarkertUtil.getTemplate(filename);
        freeMarkertUtil.processTemplate(template, root, out);
    }  
}