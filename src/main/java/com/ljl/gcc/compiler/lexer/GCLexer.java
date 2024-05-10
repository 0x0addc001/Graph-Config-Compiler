package com.ljl.gcc.compiler.lexer;

import com.ljl.gcc.compiler.GCCompiler;
import com.ljl.gcc.compiler.token.Token;

import java.util.ArrayList;
import java.util.List;

public class GCLexer extends GCCompiler {

    public GCLexer(String input) {
        this._input = input;
        this.stripWhitespaceText();
        this.ignoreComments();
        this._output = new ArrayList<>();
    }

    private String _input = ""; // raw content
    private ArrayList<Token> _output; // tokens list

    public ArrayList<Token> get_output() {
        for (int i = 0; i < _output.size(); i++){
            _output.get(i).setTokenIndex(i);
        }
        return _output;
    }

    public void stripWhitespaceText() {
        // 过滤空格、制表符、回车符、换行符
        this._input = this._input.replaceAll("[ \t\r\n]+", "");
    }

    public void ignoreComments() {
        // 过滤注释
        this._input = this._input.replaceAll("<!--.*?-->", ""); //?:非贪婪匹配（尽可能少的匹配字符）
    }

    public boolean lex() {
        if(_input.length() == 0) { // 判断是否为空
            return true;
        }
        else if(_input.charAt(0)=='<' && _input.charAt(1) != '/') { // 判断是否为起始标签
            if(startTag()) { // 识别起始标签
                if(lex()){ // 向下递归解析
                    if(endTag()){ // 识别结束标签
                        // 后文向下递归解析
                        if(lex()){
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        else{ // 判断是否为内容
            Boolean content = content();
            return content;
        }
    }
    public boolean content() {
        int e = _input.indexOf("<"); // 获取<的位置
        String sentence = _input.substring(0, e); // 获取内容
//        System.out.println("@CONTENT:" + sentence);
        boolean result = true;

        /* -- 分割句子 --*/
        List<String> words = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();
        boolean withinBrace = false;
        for (char c : sentence.toCharArray()) {
            if (c == '{') {
                withinBrace = true;
            } else if (c == '}') {
                withinBrace = false;
            }
            if ((c == ',' || c == ';') && !withinBrace) { // 使用换行符或逗号分割句子但是在花括号内的不分割
                words.add(currentWord.toString());
                currentWord.setLength(0); // 清空当前单词

                currentWord.append(c); // 添加逗号或分号
                words.add(currentWord.toString());
                currentWord.setLength(0); // 清空当前单词
            } else {
                currentWord.append(c);
            }
        }
        if (currentWord.length() > 0) { // 处理最后一个单词
            words.add(currentWord.toString());
        }
        /* -- 分割句子 --*/

        for (String word : words) { // 对句子中的每个单词做token识别
            result = result && token(word); // 去除单词两侧的空格
        }
        _input = _input.substring(e); // 向后解析
        return result;
    }
    public boolean token(String word) { // 处理word
        if(!word.equals("")) { // 判断是否为空
//            System.out.println("@TOKEN:" + word);
            int token_type;
            if(isBoolean(word)) {
                token_type = TOKENTABLE.getTokenTypeBySymbolicName("BOOLEAN");
            }
            else if(isNumber(word)) {
                token_type = TOKENTABLE.getTokenTypeBySymbolicName("NUMBER");
            }
            else if(isInf(word)) {
                token_type = TOKENTABLE.getTokenTypeBySymbolicName("INF");
            }
            else if(isDirectionType(word)) {
                token_type = TOKENTABLE.getTokenTypeBySymbolicName("DIRECTION_TYPE");
            }
            else if(isColorType(word)) {
                token_type = TOKENTABLE.getTokenTypeBySymbolicName("COLOR_TYPE");
            }
            else if(isShapeType(word)) {
                token_type = TOKENTABLE.getTokenTypeBySymbolicName("SHAPE_TYPE");
            }
            else if(isFunctionExpression(word)) {
                token_type = TOKENTABLE.getTokenTypeBySymbolicName("FUNCTION_EXPR");
            }
            else if(isComma(word)){
                token_type = TOKENTABLE.getTokenTypeBySymbolicName("COMMA");
            }
            else if(isSemicolon(word)){
                token_type = TOKENTABLE.getTokenTypeBySymbolicName("SEMICOLON");
            }
            else {
                System.out.println("ERR: 不识别的标记 "+ word);
                return false;
            }
            Token token = new Token(token_type, word);
            _output.add(token);
            return true;
        }
        return false;
    }
    public boolean isBoolean(String str) {
        return str.equalsIgnoreCase("true") || str.equalsIgnoreCase("false");
    }
    public boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
        }
        catch(Exception e) {
            return false;
        }
        return true;
    }
    public boolean isInf(String str) {
        return str.equalsIgnoreCase("inf");
    }
    public boolean isDirectionType(String str) {
        return DIRECTION_TYPES.contains(str.toLowerCase());
    }
    public boolean isColorType(String str) {
        return COLOR_TYPES.contains(str.toLowerCase());
    }
    public boolean isShapeType(String str) {
        return SHAPE_TYPES.contains(str.toLowerCase());
    }
    public boolean isFunctionExpression(String str) {
        return str.matches("^\\{[^<}]*\\}$");
    }
    public boolean isComma(String start_tag) {
        return start_tag.equals(",");
    }
    public boolean isSemicolon(String start_tag) {
        return start_tag.equals(";");
    }
    public boolean startTag() { // 处理起始标签<example>，返回起始标签名 example
        int s = _input.indexOf("<");
        int e = _input.indexOf(">");
        int token_type = TOKENTABLE.getTokenTypeByLiteralName(_input.substring(s, e + 1));
//        System.out.println("@STARTTAG:"+ _input.substring(s, e + 1));
        if(token_type == -1) {
            System.out.println("ERR: 不识别的标签 "+ _input.substring(s, e + 1));
            return false;
        }
        else {
            // 语法分析
//            String start_tag = raw_gc.substring(s+1, e); // s跳过<, e跳过>
            Token token = new Token(token_type, _input.substring(s, e + 1));
            _output.add(token);
            _input = _input.substring(e+1); // 向后解析
            return true;
        }
    }
    public boolean endTag() { // 处理结束标签</example>，输入起始标签名example，返回是否匹配
        int s = _input.indexOf("<");
        int e = _input.indexOf(">");
        if(e<0 || s<0) {
            return false;
        }
        int token_type = TOKENTABLE.getTokenTypeByLiteralName(_input.substring(s, e + 1));
//        System.out.println("@ENDTAG:"+ _input.substring(s, e + 1));
        if(token_type == -1) {
            System.out.println("ERR: 不识别的标签 "+ _input.substring(s, e + 1));
            return false;
        }
        else {
            // 语法分析
//            String end_tag = raw_gc.substring(s+2, e); // s跳过</, e跳过>
//            boolean result = raw_gc.charAt(s+1) == '/' && start_tag.equalsIgnoreCase(end_tag); // 判断是否匹配
            Token token = new Token(token_type, _input.substring(s, e + 1));
            _output.add(token);
            _input = _input.substring(e+1); // 向后解析
            return true;
        }
    }

}
