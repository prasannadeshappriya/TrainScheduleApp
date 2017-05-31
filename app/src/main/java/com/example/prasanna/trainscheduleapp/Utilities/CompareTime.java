package com.example.prasanna.trainscheduleapp.Utilities;

/**
 * Created by prasanna on 5/31/17.
 */

public abstract class CompareTime {
    //Return true if time1 > time2
    public static boolean compareTime(String time1, String time2){
        String timeArr1[] = time1.split(":");
        String timeArr2[] = time2.split(":");
        if (timeArr1.length>2){
            if (timeArr2.length>2){
                if(Integer.parseInt(timeArr1[0])>Integer.parseInt(timeArr2[0])){
                    return true;
                }else if(Integer.parseInt(timeArr1[0])<Integer.parseInt(timeArr2[0])){
                    return false;
                }else if(Integer.parseInt(timeArr1[0])==Integer.parseInt(timeArr2[0])){
                    if(Integer.parseInt(timeArr1[1])>Integer.parseInt(timeArr2[1])){
                        return true;
                    }else if(Integer.parseInt(timeArr1[1])<Integer.parseInt(timeArr2[1])){
                        return false;
                    }else if(Integer.parseInt(timeArr1[1])==Integer.parseInt(timeArr2[1])){
                        if(Integer.parseInt(timeArr1[2])>Integer.parseInt(timeArr2[2])){
                            return true;
                        }else if(Integer.parseInt(timeArr1[2])<Integer.parseInt(timeArr2[2])){
                            return false;
                        }else if(Integer.parseInt(timeArr1[2])==Integer.parseInt(timeArr2[2])){
                            return true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
