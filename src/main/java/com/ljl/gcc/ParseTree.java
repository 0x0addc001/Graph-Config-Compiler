package com.ljl.gcc;

public interface ParseTree {
    ParseTree getParent();

    ParseTree getChild(int var1);

    void setParent(RuleContext var1);

    String getText();
}
