package com.jianyu.attendance;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by pig on 4/28/14.
 */
public class AttendanceSort {
    public static Map<String,AttendanceInfo> map = new HashMap<String, AttendanceInfo>();
    public void doSort(String data){
        StringTokenizer tokenizer = new StringTokenizer(data.trim()," ");
        AttendanceInfo info = new AttendanceInfo();
        info.setName(tokenizer.nextToken());
        info.setType(Integer.parseInt(tokenizer.nextToken()));
        StringTokenizer token = new StringTokenizer(tokenizer.nextToken(),"-");
    }
}
