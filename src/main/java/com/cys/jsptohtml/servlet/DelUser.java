package com.cys.jsptohtml.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cys.jsptohtml.service.UserService;
import com.cys.jsptohtml.util.ProcessClient;
  
/** 
 * @author cys 
 **/  
@SuppressWarnings("serial")
public class DelUser extends HttpServlet {  
  
      
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
            this.doPost(request, response);  
    }  
  
    //ɾ���û�  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
         System.out.println("Del dopost");
        String id = request.getParameter("id");  
        UserService.delete(Integer.valueOf(id));  
          
        //����html��λ��  
        String dirPath = request.getSession().getServletContext().getRealPath("/templateDir/html");  
        //�ļ�����  
        String indexFileName = "index.html";  
          
        //ɾ��ԭ�����ļ�  
        delOldHtml(dirPath,indexFileName);  
          
        //��ֹ��������棬�������������µ�html  
        UUID uuid = UUID.randomUUID();  
        Writer out = new OutputStreamWriter(new FileOutputStream(dirPath+"/"+uuid+indexFileName),"UTF-8");  
        ProcessClient.processBody(out, "body.ftl");
        response.sendRedirect("templateDir/html/"+uuid+"index.html");  
    }  
      
    /** 
     * ɾ��ԭ����html�ļ� 
     * @param htmlDir 
     * @param htmlName 
     */  
    private void delOldHtml(String htmlDir,String htmlName){  
        File path = new File(htmlDir);  
        String[] indexfileList = path.list(new FilenameFilter(){

			public boolean accept(File dir, String name) {
				return name.endsWith(".html");
			}
        	
        });  
        if(indexfileList.length>0){  
            for(String f:indexfileList){  
                File delf = new File(htmlDir+"/"+f);  
                delf.delete();  
            }  
        }  
    }  
  
}