package com.integ.devtools;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Created by showdown on 6/10/14.
 */
public class GSonTest {

    public static void main(String[] args) {
        Gson gson = new Gson();


        ArrayList<String> list = new ArrayList<>();

        IntStream.rangeClosed(1, 4).boxed().forEach(v ->{ list.add("Number "+v);});

        System.out.println(gson.toJson(list));




    }
}
