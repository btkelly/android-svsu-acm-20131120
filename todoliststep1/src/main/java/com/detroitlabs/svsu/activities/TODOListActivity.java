package com.detroitlabs.svsu.activities;

import android.app.ListActivity;
import android.os.Bundle;

import com.detroitlabs.svsu.R;

public class TODOListActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
    }

}

