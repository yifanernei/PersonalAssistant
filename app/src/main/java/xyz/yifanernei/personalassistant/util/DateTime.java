package xyz.yifanernei.personalassistant.util;

import android.widget.SimpleCursorAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
    final public static String Fmt_Date = "yyyy-MM-dd";
    final public static String Fmt_DateTime = "yyyy-MM-dd HH:mm:ss";

    public static String now(String fmt)
    {
        SimpleDateFormat df = new SimpleDateFormat(fmt);//设置日期格式
        return df.format(new Date());
    }

    public static String fmt(Date d, String fmt)
    {
        SimpleDateFormat df = new SimpleDateFormat(fmt);//设置日期格式
        return df.format(d);
    }

    public static Date parse(String cont, String fmt)
    {
        SimpleDateFormat df = new SimpleDateFormat(fmt);
        try {
            return df.parse(cont);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Date();
    }
}
