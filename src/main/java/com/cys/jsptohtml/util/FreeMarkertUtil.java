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
            // ͨ��Freemaker��Configuration��ȡ��Ӧ��ftl
            Configuration cfg = new Configuration();
            // �趨ȥ�����ȡ��Ӧ��ftlģ���ļ�
            cfg.setClassForTemplateLoading(this.getClass(), "ftl");
            // ��ģ���ļ�Ŀ¼���ҵ�����Ϊname���ļ�
            Template temp = cfg.getTemplate(name);
            System.out.println(temp.getName());
            return temp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	    /** 
	     * @param templateName ģ������ 
	     * @param root ģ��� ������ģ������������ 
	     * @param out ������� ������������� 
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
