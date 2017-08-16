package com.example.park.signup.helper;

import java.util.regex.Pattern;

/**
 * Created by park on 2017-08-15.
 */

public class RegexHelper {
    private  static RegexHelper current = null;

    public static RegexHelper getInstance() {
        if(current ==null){
            current = new RegexHelper();
        }
        return current;
    }

    public static void freeInstance() {
        current =null;
    }

    private RegexHelper(){
        super();
    }

    public boolean isValue(String str){
        boolean result = false;
        if(str != null){
            result = !str.trim().equals("");
        }
        return result;
    }


    public boolean isEmail(String str){
        boolean result = false;
        if(isValue(str)){
            result = Pattern.matches("^[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$",str);
        }
        return  result;
    }
    public boolean isCellPhone(String str){
        boolean result = false;
        if(isValue(str)){
            result = Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$",str);
        }
        return  result;
    }

}
