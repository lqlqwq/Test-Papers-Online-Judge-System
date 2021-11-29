package com.pro.util;

public class MaxAndMin {
    public static int getMaxNum(int args[]){
        int max = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i] > args[max]){max = i;}
        }
        return args[max];
    }
    public static int getMinNum(int args[]){
        int min=0;
        for(int i=0;i<args.length;i++){
            if(args[i]<args[min])
                min=i;
        }
        return args[min];
    }
}
