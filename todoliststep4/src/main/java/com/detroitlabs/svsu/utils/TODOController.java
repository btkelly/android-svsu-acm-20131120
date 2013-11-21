package com.detroitlabs.svsu.utils;

import com.detroitlabs.svsu.models.TODOItem;

import java.util.ArrayList;

/**
 * Created by bobbake4 on 11/18/13.
 */
public class TODOController {

    private static TODOController defaultController;

    public static TODOController defaultController() {
        if(defaultController == null) {
            defaultController = new TODOController();
        }

        return defaultController;
    }

    private ArrayList<TODOItem> todoItems;

    private TODOController() {

    }

    public void saveTODO(TODOItem todoItem) {
        getTODOItems().add(todoItem);
    }

    public void removeTODO(TODOItem todoItem) {
        getTODOItems().remove(todoItem);
    }

    public ArrayList<TODOItem> getTODOItems() {
        return todoItems == null ? todoItems = new ArrayList<TODOItem>() : todoItems;
    }
}
