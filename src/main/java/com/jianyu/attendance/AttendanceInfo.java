package com.jianyu.attendance;

import java.util.List;

/**
 * Created by pig on 4/28/14.
 */
public class AttendanceInfo {
    private String name;
    private int type;
    private long time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public static List<AttendanceInfo> parseToAttendanceList(List<String> list){
        //TODO parse List<String> to List<AttendanceInfo>
        return null;
    }
}
