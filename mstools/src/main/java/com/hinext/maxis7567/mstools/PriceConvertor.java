package com.hinext.maxis7567.mstools;

import java.text.DecimalFormat;


public class PriceConvertor {
    public static String Convert(long price){
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        return (decimalFormat.format(price));
    }

}
