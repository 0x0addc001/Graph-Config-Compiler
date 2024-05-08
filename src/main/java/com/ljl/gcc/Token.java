package com.ljl.gcc;

public class Token {
    protected int type;
    protected String text;
    protected int index = -1;

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
