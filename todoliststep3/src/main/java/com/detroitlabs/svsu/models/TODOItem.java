package com.detroitlabs.svsu.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bobbake4 on 11/18/13.
 */
public class TODOItem implements Parcelable {

    public static final String KEY_TODO = "todo_object";

    private String todoMessage;

    public TODOItem() {

    }

    public String getTodoMessage() {
        return todoMessage;
    }

    public void setTodoMessage(String todoMessage) {
        this.todoMessage = todoMessage;
    }

    @Override
    public String toString() {
        return todoMessage;
    }

    // Parcelable section

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.todoMessage);
    }

    private TODOItem(Parcel in) {
        this.todoMessage = in.readString();
    }

    public static Parcelable.Creator<TODOItem> CREATOR = new Parcelable.Creator<TODOItem>() {
        public TODOItem createFromParcel(Parcel source) {
            return new TODOItem(source);
        }

        public TODOItem[] newArray(int size) {
            return new TODOItem[size];
        }
    };
}
