package com.detroitlabs.svsu.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.detroitlabs.svsu.R;

public class TODOListActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void clickedAddTODOMenu(MenuItem menuItem) {
        openAddTODO();
    }

    public void clickedAddTODOButton(View view) {
        openAddTODO();
    }

    private void openAddTODO() {
        Intent openTodoAdd = new Intent(this, TODOItemActivity.class);
        startActivity(openTodoAdd);
    }

}

