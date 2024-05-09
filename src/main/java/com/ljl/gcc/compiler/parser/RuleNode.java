package com.ljl.gcc.compiler.parser;

import com.ljl.gcc.compiler.token.Token;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RuleNode implements TreeNode {
    public RuleNode parent;
    public List<TreeNode> children;

    public RuleNode() {
    }

    public RuleNode(RuleNode parent) {
        this.parent = parent;
    }

    public int depth() {
        int n = 0;

        for(RuleNode p = this; p != null; ++n) {
            p = p.parent;
        }

        return n;
    }

    public RuleNode getRuleNode() {
        return this;
    }

    public String getText() {
        if (this.getChildCount() == 0) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder();

            for(int i = 0; i < this.getChildCount(); ++i) {
                builder.append(this.getChild(i).getText());
            }

            return builder.toString();
        }
    }

    public int getRuleIndex() {
        return -1;
    }

    public void setParent(RuleNode parent) {
        this.parent = parent;
    }

    public <T extends TreeNode> T addAnyChild(T t) {
        if (this.children == null) {
            this.children = new ArrayList();
        }

        this.children.add(t);
        return t;
    }

    public RuleNode addChild(RuleNode ruleInvocation) {
        return this.addAnyChild(ruleInvocation);
    }

    public TokenNode addChild(TokenNode t) {
        t.setParent(this);
        return this.addAnyChild(t);
    }

    public void removeLastChild() {
        if (this.children != null) {
            this.children.remove(this.children.size() - 1);
        }

    }

    public RuleNode getParent() {
        return this.getParent();
    }

    public TreeNode getChild(int i) {
        return this.children != null && i >= 0 && i < this.children.size() ? (TreeNode) this.children.get(i) : null;
    }

    public <T extends TreeNode> T getChild(Class<? extends T> rndType, int i) {
        if (this.children != null && i >= 0 && i < this.children.size()) {
            int j = -1;
            Iterator var = this.children.iterator();

            while(var.hasNext()) {
                TreeNode o = (TreeNode)var.next();
                if (rndType.isInstance(o)) {
                    ++j;
                    if (j == i) {
                        return rndType.cast(o); // TreeNode -> rndTypeNode
                    }
                }
            }

            return null;
        } else {
            return null;
        }
    }

    public TokenNode getTokenNode(int ttype, int i) {
        if (this.children != null && i >= 0 && i < this.children.size()) {
            int j = -1;
            Iterator var = this.children.iterator();

            while(var.hasNext()) {
                TreeNode o = (TreeNode)var.next();
                if (o instanceof TokenNode) {
                    TokenNode tnode = (TokenNode)o;
                    Token symbol = tnode.getToken();
                    if (symbol.getType() == ttype) {
                        ++j;
                        if (j == i) {
                            return tnode;
                        }
                    }
                }
            }

            return null;
        } else {
            return null;
        }
    }

    public List<TokenNode> getTokenNodes(int ttype) {
        if (this.children == null) {
            return Collections.emptyList();
        } else {
            List<TokenNode> tokens = null;
            Iterator var = this.children.iterator();

            while(var.hasNext()) {
                TreeNode o = (TreeNode)var.next();
                if (o instanceof TokenNode) {
                    TokenNode tnode = (TokenNode)o;
                    Token symbol = tnode.getToken();
                    if (symbol.getType() == ttype) {
                        if (tokens == null) {
                            tokens = new ArrayList();
                        }

                        tokens.add(tnode);
                    }
                }
            }

            if (tokens == null) {
                return Collections.emptyList();
            } else {
                return tokens;
            }
        }
    }

    public <T extends RuleNode> T getRuleNode(Class<? extends T> rndType, int i) {
        return this.getChild(rndType, i);
    }

    public <T extends RuleNode> List<T> getRuleNodes(Class<? extends T> rndType) {
        if (this.children == null) {
            return Collections.emptyList();
        } else {
            List<T> contexts = null;
            Iterator var = this.children.iterator();

            while(var.hasNext()) {
                TreeNode o = (TreeNode)var.next();
                if (rndType.isInstance(o)) {
                    if (contexts == null) {
                        contexts = new ArrayList();
                    }

                    contexts.add(rndType.cast(o)); // TreeNode -> rndTypeNode
                }
            }

            if (contexts == null) {
                return Collections.emptyList();
            } else {
                return contexts;
            }
        }
    }

    public int getChildCount() {
        return this.children != null ? this.children.size() : 0;
    }

}
