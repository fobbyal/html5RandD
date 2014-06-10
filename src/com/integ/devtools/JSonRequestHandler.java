package com.integ.devtools;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: aliang
 * Date: 6/10/14
 * Time: 3:41 PM
 */
public interface JSonRequestHandler {
    default public String doRequest(HttpServletRequest requst) throws ServletException, IOException {
        try {
            Gson gson = new Gson();
            return gson.toJson(new JSONResponse(handleRequest(requst)));
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof RuntimeException) {
                throw (RuntimeException) e;
            } else {
                throw new ServletException("Something went wrong in hadleing request", e);
            }
        }
    }

    public Object handleRequest(HttpServletRequest request) throws Exception;

}
