package com.synisys.dataManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class JsonManager {
    public static String arrayListToJson(ArrayList<String> arr){
        String item = "";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(arr.isEmpty())
            return "[]";

        for (int i = 0; i < arr.size(); i++) {
            item = "{\"id\": "+"\""+(i+1) +"\", "+"\"name\":"+"\""+ arr.get(i) +"\"},";

            sb.append(item);
            item = "";

        }
        sb.replace(sb.length()-1, sb.length(),"]");
        return sb.toString();
    }

}
