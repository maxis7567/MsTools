package com.hinext.maxis7567.mstools;

public class Validation {
    public static boolean checkMobileNumber(String number) {
        if (number.length()>3){
            if (number.charAt(0)=='+'){
                return number.matches("^[+]?[0-9]{8,20}$");
            }else if (number.charAt(0)=='0'){
                if (number.length() == 11) {
                    String tmp = String.valueOf(number.charAt(0));
                    tmp = tmp.concat(String.valueOf(number.charAt(1)));
                    return tmp.equals("09");
                } else return false;
            }else return false;
        }else return false;
    }
    public static boolean checkPhoneNumber(String num){
        if (num.length()>=7){
            return num.matches("^0\\d{2,3}\\d{4}$");
        }else return false;
    }
    public static boolean clock24HHMM(String time,char separator){
        return time.matches("(?:[01]\\d|2[0123])"+separator+"(?:[012345]\\d)");
    }
    public static boolean nameValidation(String name) {
        return name.matches("^[\\u0600-\\u065F\\u066A-\\u06EF\\u06FA-\\u06FFa-zA-Z ]+[\\u0600-\\u065F\\u066A-\\u06EF\\u06FA-\\u06FFa-zA-Z-_ ]*$");
    }
}
