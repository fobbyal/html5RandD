package com.integ.devtools;

import com.google.gson.Gson;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: aliang
 * Date: 6/9/14
 * Time: 5:48 PM
 */
@WebServlet(name = "IntegAppsServlet",
        urlPatterns = {"/integapptools.json"})
public class IntegAppsServlet extends HttpServlet {


    HashMap<String, JSonRequestHandler> handlerMapping;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        handlerMapping = new HashMap<>();
        handlerMapping.put("load_all", new LoadAll());
        handlerMapping.put("search", new Search());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processJSONRequst(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processJSONRequst(request, response);
    }

    public void processJSONRequst(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print("got to request");
        Gson gson = new Gson();

        response.setContentType("application/json");

        try (OutputStream stream = response.getOutputStream()) {
            String action = request.getParameter("action");
            System.out.println("Got action " + action);
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(stream));

            if (handlerMapping.containsKey(action)) {
                String x = handlerMapping.get(action).doRequest(request);
                writer.println(x);
            } else {
                writer.println(gson.toJson(new JSONResponse("Could not find mapping for " + action)));
            }


            writer.flush();


        }
    }

}
