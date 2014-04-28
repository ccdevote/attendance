package com.jianyu.attendance;

import java.util.Comparator;

/**
 * Created by pig on 4/28/14.
 */
public class AttendanceComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        double time1 = ((AttendanceInfo) o1).getTime();
        double time2 = ((AttendanceInfo) o2).getTime();
        if(time1 < time2){
            return 1;
        } else {
            return -1;
        }
    }
}
