package com.ljl.gcc;

import java.util.*;

public class RuleContext{
    public RuleContext parent;
    public List<RuleContext> children;

    public RuleContext() {
    }

    public RuleContext(RuleContext parent) {
        this.parent = parent;
    }

    public int depth() {
        int n = 0;

        for(RuleContext p = this; p != null; ++n) {
            p = p.parent;
        }

        return n;
    }

    public RuleContext getRuleContext() {
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

    public void setParent(RuleContext parent) {
        this.parent = parent;
    }

    public <T extends List<RuleContext>> T addAnyChild(T t) {
        if (this.children == null) {
            this.children = new ArrayList();
        }

        this.children.add(t);
        return t;
    }

    public addChild(RuleContext ruleInvocation) {
        return this.addAnyChild(ruleInvocation);
    }

    public TerminalNode addChild(TerminalNode t) {
        t.setParent(this);
        return this.addAnyChild(t);
    }

    public void removeLastChild() {
        if (this.children != null) {
            this.children.remove(this.children.size() - 1);
        }

    }

    public RuleContext getParent() {
        return this.getParent();
    }

    public List<RuleContext> getChild(int i) {
        return this.children != null && i >= 0 && i < this.children.size() ? (List<RuleContext>) this.children.get(i) : null;
    }

    public <T extends ParseTree> T getChild(Class<? extends T> ctxType, int i) {
        if (this.children != null && i >= 0 && i < this.children.size()) {
            int j = -1;
            Iterator var4 = this.children.iterator();

            while(var4.hasNext()) {
                ParseTree o = (ParseTree)var4.next();
                if (ctxType.isInstance(o)) {
                    ++j;
                    if (j == i) {
                        return (ParseTree)ctxType.cast(o);
                    }
                }
            }

            return null;
        } else {
            return null;
        }
    }

    public TerminalNode getToken(int ttype, int i) {
        if (this.children != null && i >= 0 && i < this.children.size()) {
            int j = -1;
            Iterator var4 = this.children.iterator();

            while(var4.hasNext()) {
                ParseTree o = (ParseTree)var4.next();
                if (o instanceof TerminalNode) {
                    TerminalNode tnode = (TerminalNode)o;
                    Token symbol = tnode.getSymbol();
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

    public List<TerminalNode> getTokens(int ttype) {
        if (this.children == null) {
            return Collections.emptyList();
        } else {
            List<TerminalNode> tokens = null;
            Iterator var3 = this.children.iterator();

            while(var3.hasNext()) {
                ParseTree o = (ParseTree)var3.next();
                if (o instanceof TerminalNode) {
                    TerminalNode tnode = (TerminalNode)o;
                    Token symbol = tnode.getSymbol();
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

    public <T extends RuleContext> T getRuleContext(Class<? extends T> ctxType, int i) {
        return this.getChild(ctxType, i);
    }

    public <T extends RuleContext> List<T> getRuleContexts(Class<? extends T> ctxType) {
        if (this.children == null) {
            return Collections.emptyList();
        } else {
            List<T> contexts = null;
            Iterator var3 = this.children.iterator();

            while(var3.hasNext()) {
                ParseTree o = (ParseTree)var3.next();
                if (ctxType.isInstance(o)) {
                    if (contexts == null) {
                        contexts = new ArrayList();
                    }

                    contexts.add((ParserRuleContext)ctxType.cast(o));
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
