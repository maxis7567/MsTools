package com.hinext.maxis7567.mstools;

public class PostTimeCal {

    public static String Calculator(long unix){
        if (unix<60){
            return (unix +" ثانیه");
        }else if(unix < 3600){
            return (unix / 60 +" دقیقه");
        }else if(unix < 86400){
            return (unix / 3600 +" ساعت");
        }else if(unix < 604800){
            return (unix / 86400 +" روز");
        }else if (unix < 2592000){
            return (unix / 604800 +" هفته");
        }else if (unix < 31104000){
            return (unix / 2592000 +" ماه");
        }else {
            return (unix / 31104000 +" سال");
        }
    }
}
