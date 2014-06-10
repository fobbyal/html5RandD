package com.integ.devtools;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

    Set<String> clients;
    Set<String> products;
    List<IntegAppInfo> allData;

    public AppDisplayInfo(ArrayList<IntegAppInfo> allData) {
        this.allData = allData;


        Map<String, Set<IntegAppInfo>> productTags =
                allData.stream().collect(Collectors.groupingBy(l -> l.getProductName(), Collectors.toSet()));
        Map<String, Set<IntegAppInfo>> clientTags =
                allData.stream().collect(Collectors.groupingBy(l -> l.getClient(), Collectors.toSet()));
        clients = clientTags.keySet();
        products = productTags.keySet();

        tagIndex = productTags;

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
