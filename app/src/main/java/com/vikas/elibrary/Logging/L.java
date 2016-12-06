package com.vikas.elibrary.Logging;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Dell on 12/19/2015.
 */
public class L {

    public static void m(String msg){
        Log.d("Vikas",""+msg);
    }
    public static void t(Context context, String msg) {
        Toast.makeText(context,msg+"",Toast.LENGTH_SHORT).show();
    }
}
