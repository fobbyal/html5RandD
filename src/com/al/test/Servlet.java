package com.al.test;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Created by showdown on 6/7/14.
 */
@WebServlet(name="TestServlet",
        urlPatterns={"/test"}
        )
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processHtml(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processHtml(request,response);
    }

    public void processHtml(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        OutputStream stream = response.getOutputStream();
        response.setContentType("text/html");

        try{
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(stream));

            writer.println("<html><body>Hello Word!!! here Moved to GITHUB</body></html>");
            writer.flush();


        }finally {
            stream.close();
        }
    }
}
