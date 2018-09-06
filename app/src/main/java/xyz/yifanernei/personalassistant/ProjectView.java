package xyz.yifanernei.personalassistant;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.time.format.DateTimeFormatter;

import xyz.yifanernei.personalassistant.Enity.ProjectInfo;
import xyz.yifanernei.personalassistant.Enity.ProjectStatus;
import xyz.yifanernei.personalassistant.Enity.UserInfo;
import xyz.yifanernei.personalassistant.adapter.ProjectViewAdapter;
import xyz.yifanernei.personalassistant.database.DBHelper;
import xyz.yifanernei.personalassistant.util.DateTime;

public class ProjectView extends AppCompatActivity {

    DBHelper mDB;
    ListView mLv;
    ProjectViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act = new Intent(ProjectView.this, ProjectDetail.class);
                startActivityForResult(act, 0);
            }
        });

        mLv = findViewById(R.id.list);
        mLv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                return false;
            }
        });

        mAdapter = new ProjectViewAdapter(this);
        mLv.setAdapter(mAdapter);

        flush();
    }

    void flush()
    {
        mDB = new DBHelper(this);
        SQLiteDatabase db = mDB.getReadableDatabase();
        Cursor cur = db.rawQuery("select id, name, cdate, cuser, manager, status from t_project order by status, cdate", null);

        mAdapter.clear();
        while (cur.moveToNext())
        {
            ProjectInfo info = new ProjectInfo();
            int idx = 0;
            info.setId(cur.getString(idx++));
            info.setName( cur.getString(idx++));
            info.setCdate( DateTime.parse(cur.getString(idx++), DateTime.Fmt_Date));
            info.setManager( new UserInfo(cur.getString(idx++), "email"));
            info.setStatus(ProjectStatus.values()[cur.getInt(idx++)]);

            mAdapter.push_back(info);
        }

        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != 0)
        {
            super.onActivityResult(requestCode, resultCode, data);
        }
        else
        {
            if (resultCode == RESULT_OK)
            {
                flush();
            }
        }
    }
}
