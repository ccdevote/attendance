package com.jianyu.attendance;

/**
 * Created by pig on 4/28/14.
 */
public class AttendanceInfo {
    private String name;
    private double time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

//    public int compareTo(Object o){
//        double time_cp = ((AttendanceInfo)o).time;
//        return (time < time_cp ? -1 : (time == time_cp ? 0 :1 ));
//    }

}
