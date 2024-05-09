package com.ljl.gcc;

public class Token {

    public static final int INVALID_TYPE = 0;
    public static final int EOF = -1;

    private int type;
    private String text;
    private int index = -1;

    public Token(int type) {
        this.type = type;
    }

    public Token(int type, String text) {
        this.type = type;
        this.text = text;
    }

    public int getType() {
        return this.type;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public void setType(int type) {
        this.type = type;
    }

    public int getTokenIndex() {
        return this.index;
    }

    public void setTokenIndex(int index) {
        this.index = index;
    }

}
