package com.integ.devtools;

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
 * Created with IntelliJ IDEA.
 * User: aliang
 * Date: 6/9/14
 * Time: 5:48 PM
 */
@WebServlet(name = "IntegAppsServlet",
        urlPatterns = {"/integapps.json"})
public class IntegAppsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processHtml(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processHtml(request, response);
    }

    public void processHtml(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OutputStream stream = response.getOutputStream();
        response.setContentType("text/html");

        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(stream));

            writer.println("<html><body>Hello Word!!! here Moved to GITHUB</body></html>");
            writer.flush();

            System.out.print("dd");


        } finally {
            stream.close();
        }
    }

}
