package com.example.wzh.bmobtest2.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Author by wzh,Date on 2019/3/17.
 * PS: Not easy to write code, please indicate.
 * Toast提示工具类
 */
public class ToastUtils {

    public static void toast(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void toast(Context context,int msgId){
        Toast.makeText(context, msgId, Toast.LENGTH_SHORT).show();
    }

}
