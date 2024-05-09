package com.ljl.gcc;

public class TerminalNode implements ParseTree{
    public Token symbol;
    public RuleContext parent;

    public TerminalNode(Token symbol) {
        this.symbol = symbol;
    }

    public ParseTree getChild(int i) {
        return null;
    }

    public Token getSymbol() {
        return this.symbol;
    }

    public RuleContext getParent() {
        return this.parent;
    }

    public void setParent(RuleContext parent) {
        this.parent = parent;
    }

    public int getChildCount() {
        return 0;
    }

    public String getText() {
        return this.symbol.getText();
    }
}
