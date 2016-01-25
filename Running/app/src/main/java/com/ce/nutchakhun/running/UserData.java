package com.ce.nutchakhun.running;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Nutchakhun on 1/25/2016 AD.
 */
public class UserData {
    private static Integer age_user=null;
    private static Integer weight_user=null;
    private static Integer height_user=null;
    private static Integer sex_user=null;
    private static Double actLevel_user=null;
    private static Integer calPerDay_user=null;

    public static void updateUser(Activity activity, Integer age, Integer weight, Integer height, Integer sex, Double actLevel, Integer calPerDay){
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("age",age);
        editor.putInt("weight",weight);
        editor.putInt("height",height);
        editor.putInt("sex",sex);
        editor.putFloat("actLevel", (float) (double) actLevel);
        editor.putInt("calPerDay", calPerDay);
        editor.commit();

        age_user=age;
        weight_user=weight;
        height_user=height;
        sex_user=sex;
        actLevel_user=actLevel;
        calPerDay_user=calPerDay;



    }

    public static Integer getAge(Activity activity) {
        if (age_user == null) {
            SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);

            age_user = sharedPref.getInt("age", -1);

            if(age_user==-1) age_user=null;
        }



        return age_user;


    }
    public static Integer getWeight(Activity activity) {
        if (weight_user == null) {
            SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);

            weight_user = sharedPref.getInt("weight", -1);

            if(weight_user==-1) weight_user=null;
        }



        return weight_user;


    }

    public static Integer getHeight(Activity activity) {
        if (height_user == null) {
            SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);

            height_user = sharedPref.getInt("height", -1);

            if(height_user==-1) height_user=null;
        }



        return height_user;


    }
    public static Integer getSex(Activity activity) {
        if (sex_user == null) {
            SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);

            sex_user = sharedPref.getInt("sex", -1);

            if(sex_user==-1) sex_user=null;
        }



        return sex_user;


    }

    public static Double getActLevel(Activity activity) {
        if (actLevel_user == null) {
            SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);

            actLevel_user = (double)sharedPref.getFloat("actLevel", -1);

            if(actLevel_user==-1) actLevel_user=null;
        }



        return actLevel_user;


    }




    public static Integer getCalPerDay(Activity activity) {
        if (calPerDay_user == null) {
            SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);

            calPerDay_user = sharedPref.getInt("calPerDay", -1);

            if(calPerDay_user==-1) calPerDay_user=null;
        }



        return calPerDay_user;


    }







}
