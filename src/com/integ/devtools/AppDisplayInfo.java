package com.integ.devtools;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: aliang
 * Date: 6/10/14
 * Time: 4:54 PM
 */
public class AppDisplayInfo implements Serializable {
    Set<String> tags;

    Map<String, Set<IntegAppInfo>> tagIndex;

    List<String> clients;
    List<String> products;
    List<IntegAppInfo> allData;

    public AppDisplayInfo(ArrayList<IntegAppInfo> allData) {
        this.allData = allData;


        Map<String, Set<IntegAppInfo>> productTags =
                allData.stream().collect(Collectors.groupingBy(L -> L.getProductName(), Collectors.toSet()));

        Map<String, Set<IntegAppInfo>> clientTags =
                allData.stream().collect(Collectors.groupingBy(L -> L.getClient(), Collectors.toSet()));

        clients = clientTags.keySet().stream().sorted().collect(Collectors.toList());
        products = productTags.keySet().stream().sorted().collect(Collectors.toList());

        tagIndex = new HashMap<>();
        tagIndex.putAll(productTags);

        for (String key : clientTags.keySet()) {
            if (tagIndex.containsKey(key)) {
                tagIndex.get(key).addAll(clientTags.get(key));
            } else {
                tagIndex.put(key, clientTags.get(key));
            }
        }

        tags = tagIndex.keySet();


    }
}
