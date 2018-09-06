package xyz.yifanernei.personalassistant.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    static final String [] INITSQLS = {
        //ver 1
        "create table sys_config(k, v)"
            , "create table sys_user(id, name)"
            , "create table t_project(id, name, cdate, cuser, manager, status)"
            , "create table t_project_item(id, pid, cont, cdate, cuser, pdate, edate, status)"
            , "create table sys_itemname(tp, code, name)"
            , "insert into t_project values('', '测试项目', '2018-09-05', '1', '1', '1')"
    };

    static final int [] VerIndex = {
        0, 5
    };

    static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, "data.db", null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for (String sql :
                INITSQLS) {
            sqLiteDatabase.execSQL(sql);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        int bidx = VerIndex[i + 1];
        int eidx = VerIndex[i1 + 1];

        for (int idx = bidx; idx < eidx; ++idx)
        {
            sqLiteDatabase.execSQL(INITSQLS[idx]);
        }
    }
}
