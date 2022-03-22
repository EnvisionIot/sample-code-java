/**
 * Copyright (C), 2015-2022, Envision
 * FileName: DateTimeUtil
 * Author:   xibin.song
 * Date:     3/15/2022 11:24 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/15/2022
 * @since 1.0.0
 */

public class DateTimeUtil {
    public static String getDateTime(){
        java.util.Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(date);
        return format;
    }
}
