package com.detroitlabs.svsu.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.detroitlabs.svsu.R;

/**
 * Created by bobbake4 on 11/18/13.
 */
public class TODOItemActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_item);
    }

    public void saveTODO(View view) {
        Toast.makeText(this, "Clicked save", Toast.LENGTH_SHORT).show();
        finish();
    }
}
