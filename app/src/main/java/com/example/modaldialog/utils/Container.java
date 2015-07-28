package com.example.modaldialog.utils;

import android.app.Activity;

import com.example.modaldialog.showTextView.ShowTextView;

/**
 * Created by bolovanos on 9.6.15.
 */
public class Container {


    public ShowTextView showTextView;


    private static Container instance = null;

    public static Container getInstance(){
        if(instance==null){
            instance = new Container();
        }
        return instance;
    }


    public void initShowTextView(Activity activity) {
        showTextView = new ShowTextView(activity);
    }

}
