package com.detroitlabs.svsu.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.detroitlabs.svsu.R;
import com.detroitlabs.svsu.models.TODOItem;
import com.detroitlabs.svsu.utils.TODOController;

import java.util.ArrayList;

public class TODOListActivity extends ListActivity implements AdapterView.OnItemLongClickListener {

    private TODOController todoController;
    private ArrayAdapter<TODOItem> todoAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        todoController = TODOController.defaultController(getApplicationContext());

        initList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == Activity.RESULT_OK) {

            switch (requestCode) {
                case TODOItemActivity.ADD_TODO_REQUEST_CODE:
                    TODOItem todoItem = data.getParcelableExtra(TODOItem.KEY_TODO);
                    todoController.saveTODO(todoItem);
                    updateList();
                    break;
            }

        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
        TODOItem todoItem = (TODOItem) adapterView.getItemAtPosition(position);
        showDeleteDialog(todoItem);
        return true;
    }

    public void clickedAddTODOMenu(MenuItem menuItem) {
        openAddTODO(null);
    }

    public void clickedAddTODOButton(View view) {
        openAddTODO(null);
    }

    private void openAddTODO(TODOItem itemToEdit) {
        Intent openTodoAdd = new Intent(this, TODOItemActivity.class);
        startActivityForResult(openTodoAdd, TODOItemActivity.ADD_TODO_REQUEST_CODE);
    }

    private void showDeleteDialog(final TODOItem todoItem) {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.dialog_delete_title))
                .setMessage(getString(R.string.dialog_delete_message))
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        todoController.removeTODO(todoItem);
                        updateList();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .show();
    }

    private void updateList() {
        todoAdapter.clear();
        todoAdapter.addAll(todoController.getTODOItems());
        todoAdapter.notifyDataSetChanged();
    }

    private void initList() {
        todoAdapter = new ArrayAdapter<TODOItem>(this, android.R.layout.simple_list_item_1, new ArrayList<TODOItem>());

        getListView().setAdapter(todoAdapter);
        getListView().setOnItemLongClickListener(this);

        updateList();
    }
}

