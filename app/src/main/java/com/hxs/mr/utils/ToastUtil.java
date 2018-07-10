package com.hxs.mr.utils;

import com.hxs.mr.app.App;

/**
 ***********************
 * 功 能:基于TastyToast 的toast再次封装
 * *********************
 */
public class ToastUtil {

    public static void Success(String msg){
        SAToast.makeText(App.getInstance(),msg).show();
    }
    public static void Error(String msg){
        SAToast.makeText(App.getInstance(),msg).show();
    }
    public static void Info(String msg){
        //TastyToast.makeText(App.getInstance(),msg,1,TastyToast.INFO).show();

        SAToast.makeText(App.getInstance(),msg).show();
    }
    public static void Warning(String msg){
        SAToast.makeText(App.getInstance(),msg).show();
    }
    public static void Confusing(String msg){
        SAToast.makeText(App.getInstance(),msg).show();
    }

}
