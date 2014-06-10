package com.integ.devtools;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: aliang
 * Date: 6/10/14
 * Time: 3:41 PM
 */
public class LoadAll implements JSonRequestHandler {
    @Override
    public Object handleRequest(HttpServletRequest request) throws Exception {
        AppInfoDAO dao = new AppInfoDAO();
        return new AppDisplayInfo(dao.getInfo());

    }
}
