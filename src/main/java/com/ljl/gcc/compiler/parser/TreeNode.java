package com.ljl.gcc.compiler.parser;

public interface TreeNode {
    TreeNode getParent();

    void setParent(RuleNode treeNode);

    TreeNode getChild(int index);

    int getChildCount();

    String getText();
}
