package com.company;

import java.util.ArrayList;

public interface ISavable {
    ArrayList<Object> save();

    void restore(ArrayList<Object> fields);
}
