package xyz.yifanernei.personalassistant;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import xyz.yifanernei.personalassistant.database.DBHelper;
import xyz.yifanernei.personalassistant.util.DateTime;
import xyz.yifanernei.personalassistant.util.GUID;

public class ProjectDetail extends AppCompatActivity
    implements View.OnClickListener{

    EditText mName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        findViewById(R.id.bt_ok).setOnClickListener(this);
        findViewById(R.id.bt_cancel).setOnClickListener(this);

        mName = findViewById(R.id.et_name);
    }

    boolean saveProject()
    {
        ContentValues cv = new ContentValues();
        cv.put("id", GUID.generant());
        cv.put("name", mName.getText().toString());
        cv.put("cdate", DateTime.now(DateTime.Fmt_Date));
        cv.put("cuser", "1");
        cv.put("manager", "1");
        cv.put("status", "1");

        DBHelper dh = new DBHelper(this);
        SQLiteDatabase db = dh.getWritableDatabase();

        db.insert("t_project", null, cv);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.bt_ok:
                if (saveProject()) {
                    setResult(RESULT_OK);
                    finish();
                }
                break;
            case R.id.bt_cancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
