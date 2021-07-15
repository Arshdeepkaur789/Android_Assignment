package com.example.assignment;

import java.util.ArrayList;
import java.util.List;

public class dataFile {



    public static int calculatePrice(int a , int b){
        int c = a* b;
        return  c;
    }


    private static List<String> data = new ArrayList<>();

    public static void addItem(String item) {
        data.add(item);
    }

    public static List<String> getData() {
        return data;
    }

}
