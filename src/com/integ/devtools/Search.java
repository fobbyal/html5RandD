package com.integ.devtools;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: aliang
 * Date: 6/11/14
 * Time: 5:41 PM
 */
public class Search implements JSonRequestHandler {
    @Override
    public Object handleRequest(HttpServletRequest request) throws Exception {
        AppInfoDAO dao = new AppInfoDAO();
        String searchString = request.getParameter("searchString");
        String searchType = request.getParameter("searchType");
        return dao.search(searchString, searchType);

    }
}