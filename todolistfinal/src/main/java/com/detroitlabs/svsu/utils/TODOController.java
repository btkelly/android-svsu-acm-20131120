package com.detroitlabs.svsu.utils;

import android.app.Application;
import android.content.Context;

import com.detroitlabs.svsu.models.TODOItem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by bobbake4 on 11/18/13.
 */
public class TODOController {

    private static final String TODO_FILENAME = "TODO.txt";

    private static TODOController defaultController;
    private static Context application;

    public static TODOController defaultController(Context applicationContext) {
        if (!(applicationContext instanceof Application))
            throw new RuntimeException("You must pass an application context to obtain the TODOController");

        if(defaultController == null) {
            defaultController = new TODOController();
            application = applicationContext;
        }

        return defaultController;
    }

    private ArrayList<TODOItem> todoItems;

    private TODOController() {

    }

    public void saveTODO(TODOItem todoItem) {
        getTODOItems().add(todoItem);
        saveTODOList();
    }

    public void removeTODO(TODOItem todoItem) {
        getTODOItems().remove(todoItem);
        saveTODOList();
    }

    public ArrayList<TODOItem> getTODOItems() {
        return todoItems == null ? todoItems = loadTODOList() : todoItems;
    }

    private void saveTODOList() {
        try {
            FileOutputStream fileOutputStream = application.openFileOutput(TODO_FILENAME, Context.MODE_PRIVATE);

            byte[] rawTODOList = TODOItem.convertTODOListToString(getTODOItems()).getBytes();
            fileOutputStream.write(rawTODOList);

            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<TODOItem> loadTODOList() {
        try {
            FileInputStream fileInputStream = application.openFileInput(TODO_FILENAME);

            byte[] rawTODOItems = new byte[fileInputStream.available()];
            fileInputStream.read(rawTODOItems);

            String stingTODOItems = new String(rawTODOItems);

            return TODOItem.parseTODOItems(stingTODOItems);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<TODOItem>();
    }
}
