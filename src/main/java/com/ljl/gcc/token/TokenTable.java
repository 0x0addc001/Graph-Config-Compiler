package com.ljl.gcc.token;

public class TokenTable {
    private static final String[] EMPTY_NAMES = new String[0];
    private final String[] literalNames;
    private final String[] symbolicNames;

    public TokenTable(String[] literalNames, String[] symbolicNames) {
        this.literalNames = literalNames != null ? literalNames : EMPTY_NAMES;
        this.symbolicNames = symbolicNames != null ? symbolicNames : EMPTY_NAMES;
    }

    public String getLiteralName(int tokenType) { // 获取种别编码对应的字面符
        return tokenType >= 0 && tokenType < this.literalNames.length ? this.literalNames[tokenType] : null;
    }

    public String getSymbolicName(int tokenType) { // 获取种别编码对应的助记符
        if (tokenType >= 0 && tokenType < this.symbolicNames.length) {
            return this.symbolicNames[tokenType];
        } else {
            return tokenType == -1 ? "EOF" : null;
        }
    }

    public int getTokenTypeByLiteralName(String literalName) {
        for (int i = 0; i < this.literalNames.length; ++i) {
            if (this.literalNames[i] != null && this.literalNames[i].equals(literalName)) {
                return i;
            }
        }
        return -1;
    }

    public int getTokenTypeBySymbolicName(String symbolicName) {
        for (int i = 0; i < this.symbolicNames.length; ++i) {
            if (this.symbolicNames[i] != null &&this.symbolicNames[i].equals(symbolicName)) {
                return i;
            }
        }
        return -1;
    }

    public String[] getLiteralNames() {
        return this.literalNames;
    }

    public String[] getSymbolicNames() {
        return this.symbolicNames;
    }
}
