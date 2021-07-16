package com.example.keephealty.model;

public class Profile {
    private String text;
    private int icon;

    public Profile() {}

    public Profile(int icon, String text) {
        this.icon = icon;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
