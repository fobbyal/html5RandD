package com.integ.devtools;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: aliang
 * Date: 6/10/14
 * Time: 4:08 PM
 */
public class JSONResponse implements Serializable {

    boolean error = false;

    String message;

    Object response;

    public JSONResponse(Object data) {
        this.response = data;
    }

    public JSONResponse(String message) {
        this.message = message;
        error = true;
    }


}
