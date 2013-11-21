package com.detroitlabs.svsu.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.detroitlabs.svsu.R;
import com.detroitlabs.svsu.models.TODOItem;

/**
 * Created by bobbake4 on 11/18/13.
 */
public class TODOItemActivity extends Activity {

    public static final int ADD_TODO_REQUEST_CODE = 0x1234;

    private EditText todoMessageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_item);

        initEditText();
    }

    public void saveTODO(View view) {
        if(checkValidData()) {

            TODOItem todoItem = new TODOItem();

            String newMessage = todoMessageView.getText().toString();
            todoItem.setTodoMessage(newMessage);

            Intent returnData = new Intent();
            returnData.putExtra(TODOItem.KEY_TODO, todoItem);
            setResult(Activity.RESULT_OK, returnData);
            finish();
        } else {
            showInvalidDataDialog();
        }
    }

    private void showInvalidDataDialog() {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.dialog_invalid_data_title))
                .setMessage(getString(R.string.dialog_invalid_data_message))
                .show();
    }

    private boolean checkValidData() {
        return todoMessageView.getText().toString().trim().length() > 0;
    }

    private void initEditText() {
        todoMessageView = (EditText) findViewById(R.id.todoMessage);
    }
}
