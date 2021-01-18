package ca.chefsjournal.model;

import java.util.ArrayList;

public class Folder {
    private String name;
    private ArrayList<Object> items;

    public Folder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
