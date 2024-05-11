package com.ljl.gcc.compiler.token;

import com.ljl.gcc.compiler.GCCompiler;

public class Token extends GCCompiler {

    private int type; // TokenType 种别编码
    private String text; // CharStream 中对应的内容
    private int index = -1; // TokenStream 中的索引

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

    @Override
    public String toString() {
        return "Token{" +
                "type=" + TOKENTABLE.getSymbolicName(this.type) +
                ", text='" + text + '\'' +
                ", index=" + index +
                '}';
    }
}
