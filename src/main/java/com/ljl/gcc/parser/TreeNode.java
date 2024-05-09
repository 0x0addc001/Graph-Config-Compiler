package com.ljl.gcc.parser;

public interface TreeNode {
    TreeNode getParent();

    void setParent(RuleNode ruleNode);

    TreeNode getChild(int index);

    int getChildCount();

    String getText();
}
