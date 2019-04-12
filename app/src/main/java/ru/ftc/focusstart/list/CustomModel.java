package ru.ftc.focusstart.list;

public class CustomModel {

    private String text;
    private String title;

    public CustomModel(String text, String title) {
        this.text = text;
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }
}
