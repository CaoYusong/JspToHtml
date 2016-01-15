package com.cys.jsptohtml.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cys.jsptohtml.util.ProcessClient;

public class JspToHtmlServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public JspToHtmlServlet() {  
        super();  
    }  
	
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
    	System.out.println("doget");
        this.doPost(request, response);  
    }  
  
      
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
    	System.out.println("doPost");
        // html生成之后存放的路径
        String dirPath = request.getSession().getServletContext().getRealPath("/templateDir/html");  
        File path = new File(dirPath);  
        // 生成的文件的名字
        String indexFileName = "index.html";  
        /**
		 * 判断是否已经存在该html文件，存在了就直接访问html ，不存在生成html文件
		 */  
        String[] indexfileList = path.list(new FilenameFilter(){

			public boolean accept(File dir, String name) {
				return name.endsWith(".html");
			}
        });
        System.out.println(indexfileList);
        if(indexfileList.length<=0){  
            Writer out = new OutputStreamWriter(new FileOutputStream(dirPath+"/"+indexFileName),"UTF-8"); 
            // 生成html文件
            ProcessClient.processBody(out,"body.ftl");  
            request.getRequestDispatcher("/templateDir/html/index.html").forward(request, response);   
        }else{  
            request.getRequestDispatcher("/templateDir/html/"+indexfileList[0]).forward(request, response);   
        }  
	

}
}
