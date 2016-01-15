package com.cys.jsptohtml.util;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkertUtil {
	
	public Template getTemplate(String name) {
        try {
            // 通过Freemaker的Configuration读取相应的ftl
            Configuration cfg = new Configuration();
            // 设定去哪里读取相应的ftl模板文件
            cfg.setClassForTemplateLoading(this.getClass(), "ftl");
            // 在模板文件目录中找到名称为name的文件
            Template temp = cfg.getTemplate(name);
            System.out.println(temp.getName());
            return temp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	    /** 
	     * @param templateName 模板名字 
	     * @param root 模板根 用于在模板内输出结果集 
	     * @param out 输出对象 具体输出到哪里 
	     */  
	    public  void processTemplate(Template template,Map<?,?> root, Writer out){  
	        try{  
	        	System.out.println("processTemplate");
	            template.process(root, out);   
	            out.flush();     
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } catch (TemplateException e) {  
	            e.printStackTrace();  
	        }finally{  
	             try {  
	                out.close();  
	                out=null;  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	    }  
}
