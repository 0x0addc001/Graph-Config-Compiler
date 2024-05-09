package com.ljl.gcc.parser;

import com.ljl.gcc.token.Token;

public class TokenNode implements TreeNode {
    public Token token;
    public RuleNode parent;

    public TokenNode(Token token) {
        this.token = token;
    }

    public TreeNode getChild(int i) {
        return null;
    }

    public RuleNode getParent() {
        return this.parent;
    }

    public void setParent(RuleNode parent) {
        this.parent = parent;
    }

    public int getChildCount() {
        return 0;
    }

    public Token getToken() {
        return this.token;
    }

    public String getText() {
        return this.token.getText();
    }
}
