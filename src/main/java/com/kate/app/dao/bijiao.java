package com.kate.app.dao;

import java.util.Comparator;

public class bijiao implements Comparator {  
    public int compare(String object1, String object2) {// 实现接口中的方法  
        String p1 = object1; // 强制转换  
        String p2 = object2;  
        return p2.compareTo(p1);  
    }  
}  