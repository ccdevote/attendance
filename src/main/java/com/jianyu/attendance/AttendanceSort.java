package com.jianyu.attendance;

import java.sql.Time;
import java.util.*;

/**
 * Created by pig on 4/28/14.
 */
public class AttendanceSort {
    public static Map<String,AttendanceInfo> map = new HashMap<String, AttendanceInfo>();

    public static void doConvert(List<String> list){
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            StringTokenizer tokenizer = new StringTokenizer(iterator.next().trim()," ");
            AttendanceInfo info =null;
            String name = tokenizer.nextToken();
            int type = Integer.parseInt(tokenizer.nextToken());
            if(map.get(name)!=null){
                info = map.get(name);
            }else{
                info = new AttendanceInfo();
                info.setName(name);
                info.setTime(0);
            }
            StringTokenizer time_token = new StringTokenizer(tokenizer.nextToken(),"-");
            String time1 = time_token.nextToken();
            String time2 = time_token.nextToken();
            StringTokenizer time1_token = new StringTokenizer(time1,":");
            StringTokenizer time2_token = new StringTokenizer(time2,":");
            String time1_hour = time1_token.nextToken();
            String time1_minute = time1_token.nextToken();
            String time2_hour = time2_token.nextToken();
            String time2_minute = time2_token.nextToken();
            double hour = Integer.parseInt(time2_hour)-Integer.parseInt(time1_hour);
            double minute = Integer.parseInt(time2_minute)-Integer.parseInt(time1_minute);
            if(minute<0){
                minute = -(minute+60);
            }
            double time = hour+(minute/60);
            switch (type){
                case 1:
                case 2:
                    info.setTime(info.getTime()+time);
                    map.put(name,info);
                    break;
                case 3:
                    info.setTime(info.getTime()-time);
                    map.put(name,info);
                    break;
            }
        }

    }
    public AttendanceInfo[] doSort(){
        AttendanceInfo[] infos = new AttendanceInfo[map.size()];
        int k=0;
        for (String key :map.keySet()){
            infos[k++]=map.get(key);
        }
        Arrays.sort(infos,new AttendanceComparator());
        return infos;
    }
}
