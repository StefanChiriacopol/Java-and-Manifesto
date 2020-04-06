package com.exemple.android.schoolbox;

import java.util.ArrayList;
import java.util.List;

class DataHolder {
    final ArrayList<nume_list> people = new ArrayList<>();

    private DataHolder() {}

    static DataHolder getInstance() {
        if( instance == null ) {
            instance = new DataHolder();
        }
        return instance;
    }

    private static DataHolder instance;
}