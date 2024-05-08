package com.ljl.gcc;

import javafx.util.Pair;

import java.util.*;
import java.io.File;

public class GCCLexer {
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final TokenTable TOKEN_TABLE = new TokenTable(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    public static final int // 种别编码 TokenIndex NULL=0,
            WS=1, COMMENT=2, CONFIG_START=3, CONFIG_END=4, BG_START=5, BG_END=6, COL_START=7,
            COL_END=8, X_RANGE_START=9, X_RANGE_END=10, Y_RANGE_START=11, Y_RANGE_END=12,
            SHAPE_START=13, SHAPE_END=14, POINTS_START=15, POINTS_END=16, LINE_START=17,
            LINE_END=18, LINES_START=19, LINES_END=20, CURVE_START=21, CURVE_END=22,
            SCALE_START=23, SCALE_END=24, PAD_START=25, PAD_END=26, CENTER_START=27,
            CENTER_END=28, WID_START=29, WID_END=30, WIDTH_START=31, WIDTH_END=32,
            HEIGHT_START=33, HEIGHT_END=34, LIST_START=35, LIST_END=36, POINT_START=37,
            POINT_END=38, SLOPE_START=39, SLOPE_END=40, RADIUS_START=41, RADIUS_END=42,
            RANGE_START=43, RANGE_END=44, AMOUNT_START=45, AMOUNT_END=46, FUNCTION_START=47,
            FUNCTION_END=48, DIRECTION_START=49, DIRECTION_END=50, POS_START=51, POS_END=52,
            FROM_START=53, FROM_END=54, STEP_START=55, STEP_END=56, PRECISION_START=57,
            PRECISION_END=58, TYPE_START=59, TYPE_END=60, BOOLEAN=61, INF=62, COMMENT_START=63,
            COMMENT_END=64, NUMBER=65, COMMA=66, SEMICOLON=67, DIRECTION_TYPE=68,
            COLOR_TYPE=69, SHAPE_TYPE=70, FUNCTION_EXPR=71;
    private static String[] makeLiteralNames() {
        return new String[] { // 字面符
                null, null, null, "<config>", "</config>", "<bg>", "</bg>", "<col>",
                "</col>", "<xRange>", "</xRange>", "<yRange>", "</yRange>",
                "<shape>", "</shape>", "<points>", "</points>", "<line>", "</line>",
                "<lines>", "</lines>", "<curve>", "</curve>", "<scale>", "</scale>",
                "<pad>", "</pad>", "<center>", "</center>", "<wid>", "</wid>",
                "<width>", "</width>", "<height>", "</height>", "<list>", "</list>",
                "<point>", "</point>", "<slope>", "</slope>", "<radius>", "</radius>",
                "<range>", "</range>", "<amount>", "</amount>", "<function>",
                "</function>", "<direction>", "</direction>", "<pos>", "</pos>",
                "<from>", "</from>", "<step>", "</step>", "<precision>", "</precision>",
                "<type>", "</type>", null, "inf", "<!--", "-->", null, ",",
                ";"
        };

    }
    private static String[] makeSymbolicNames() {
        return new String[] { // 助记符
                null, "WS", "COMMENT", "CONFIG_START", "CONFIG_END", "BG_START", "BG_END",
                "COL_START", "COL_END", "X_RANGE_START", "X_RANGE_END", "Y_RANGE_START",
                "Y_RANGE_END", "SHAPE_START", "SHAPE_END", "POINTS_START", "POINTS_END",
                "LINE_START", "LINE_END", "LINES_START", "LINES_END", "CURVE_START",
                "CURVE_END", "SCALE_START", "SCALE_END", "PAD_START", "PAD_END", "CENTER_START",
                "CENTER_END", "WID_START", "WID_END", "WIDTH_START", "WIDTH_END", "HEIGHT_START",
                "HEIGHT_END", "LIST_START", "LIST_END", "POINT_START", "POINT_END", "SLOPE_START",
                "SLOPE_END", "RADIUS_START", "RADIUS_END", "RANGE_START", "RANGE_END",
                "AMOUNT_START", "AMOUNT_END", "FUNCTION_START", "FUNCTION_END", "DIRECTION_START",
                "DIRECTION_END", "POS_START", "POS_END", "FROM_START", "FROM_END", "STEP_START",
                "STEP_END", "PRECISION_START", "PRECISION_END", "TYPE_START", "TYPE_END",
                "BOOLEAN", "INF", "COMMENT_START", "COMMENT_END", "NUMBER", "COMMA",
                "SEMICOLON", "DIRECTION_TYPE", "COLOR_TYPE", "SHAPE_TYPE", "FUNCTION_EXPR"
        };
    }

    private static final List<String> DIRECTION_TYPES = new ArrayList<>(Arrays.asList(
            "x", "y"));
    private static final List<String> COLOR_TYPES = new ArrayList<>(Arrays.asList(
            "red", "orange", "yellow", "green", "cyan", "blue",
            "indigo", "violet", "white", "gray", "black"));
    private static final List<String> SHAPE_TYPES = new ArrayList<>(Arrays.asList(
            "oval", "rect"));

    String raw_gc = "";
    ArrayList<Pair<Integer,String>> tokenized_gc;

    public GCCLexer(String raw_gc) {
        this.raw_gc = raw_gc;
        this.filterWhitespace();
        this.filterComment();
        this.tokenized_gc = new ArrayList<>();
    }

    public void filterWhitespace() {
        // 过滤空格、制表符、回车符、换行符
        this.raw_gc = this.raw_gc.replaceAll("[ \t\r\n]+", "");
    }

    public void filterComment() {
        // 过滤注释
        this.raw_gc = this.raw_gc.replaceAll("<!--.*?-->", ""); //?:非贪婪匹配（尽可能少的匹配字符）
    }

    public boolean lexGC() {
        if(raw_gc.length() == 0) { // 判断是否为空
            return true;
        }
        else if(raw_gc.charAt(0)=='<' && raw_gc.charAt(1) != '/') { // 判断是否为起始标签
            if(startTag()) { // 识别起始标签
                if(lexGC()){ // 向下递归解析
                    if(endTag()){ // 识别结束标签
                        // 后文向下递归解析
                        if(lexGC()){
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
        int e = raw_gc.indexOf("<"); // 获取<的位置
        String sentence = raw_gc.substring(0, e); // 获取内容
        System.out.println("@CONTENT:" + sentence);
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
        raw_gc = raw_gc.substring(e); // 向后解析
        return result;
    }
    public boolean token(String word) { // 处理word
        if(!word.equals("")) { // 判断是否为空
            System.out.println("@TOKEN:" + word);
            if(isBoolean(word)) {
                int token_type = TOKEN_TABLE.getTokenTypeBySymbolicName("BOOLEAN");
                Pair<Integer,String> token = new Pair<>(token_type, word);
                tokenized_gc.add(token);
                return true;
            }
            else if(isNumber(word)) {
                int token_type = TOKEN_TABLE.getTokenTypeBySymbolicName("NUMBER");
                Pair<Integer,String> token = new Pair<>(token_type, word);
                tokenized_gc.add(token);
                return true;
            }
            else if(isInf(word)) {
                int token_type = TOKEN_TABLE.getTokenTypeBySymbolicName("INF");
                Pair<Integer,String> token = new Pair<>(token_type, word);
                tokenized_gc.add(token);
                return true;
            }
            else if(isDirectionType(word)) {
                int token_type = TOKEN_TABLE.getTokenTypeBySymbolicName("DIRECTION_TYPE");
                Pair<Integer,String> token = new Pair<>(token_type, word);
                tokenized_gc.add(token);
                return true;
            }
            else if(isColorType(word)) {
                int token_type = TOKEN_TABLE.getTokenTypeBySymbolicName("COLOR_TYPE");
                Pair<Integer,String> token = new Pair<>(token_type, word);
                tokenized_gc.add(token);
                return true;
            }
            else if(isShapeType(word)) {
                int token_type = TOKEN_TABLE.getTokenTypeBySymbolicName("SHAPE_TYPE");
                Pair<Integer,String> token = new Pair<>(token_type, word);
                tokenized_gc.add(token);
                return true;
            }
            else if(isFunctionExpression(word)) {
                int token_type = TOKEN_TABLE.getTokenTypeBySymbolicName("FUNCTION_EXPR");
                Pair<Integer,String> token = new Pair<>(token_type, word);
                tokenized_gc.add(token);
                return true;
            }
            else if(isComma(word)){
                int token_type = TOKEN_TABLE.getTokenTypeBySymbolicName("COMMA");
                Pair<Integer,String> token = new Pair<>(token_type, word);
                tokenized_gc.add(token);
                return true;
            }
            else if(isSemicolon(word)){
                int token_type = TOKEN_TABLE.getTokenTypeBySymbolicName("SEMICOLON");
                Pair<Integer,String> token = new Pair<>(token_type, word);
                tokenized_gc.add(token);
                return true;
            }
            else {
                System.out.println("ERR: 不识别的标记 "+ word);
                return false;
            }
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
        int s = raw_gc.indexOf("<");
        int e = raw_gc.indexOf(">");
        int token_type = TOKEN_TABLE.getTokenTypeByLiteralName(raw_gc.substring(s, e + 1));
        System.out.println("@STARTTAG:"+ raw_gc.substring(s, e + 1));
        if(token_type == -1) {
            System.out.println("ERR: 不识别的标签 "+ raw_gc.substring(s, e + 1));
            return false;
        }
        else {
            // 语法分析
//            String start_tag = raw_gc.substring(s+1, e); // s跳过<, e跳过>
            Pair<Integer,String> token = new Pair<>(token_type, raw_gc.substring(s, e + 1));
            tokenized_gc.add(token);
            raw_gc = raw_gc.substring(e+1); // 向后解析
            return true;
        }
    }
    public boolean endTag() { // 处理结束标签</example>，输入起始标签名example，返回是否匹配
        int s = raw_gc.indexOf("<");
        int e = raw_gc.indexOf(">");
        if(e<0 || s<0) {
            return false;
        }
        int token_type = TOKEN_TABLE.getTokenTypeByLiteralName(raw_gc.substring(s, e + 1));
        System.out.println("@ENDTAG:"+ raw_gc.substring(s, e + 1));
        if(token_type == -1) {
            System.out.println("ERR: 不识别的标签 "+ raw_gc.substring(s, e + 1));
            return false;
        }
        else {
            // 语法分析
//            String end_tag = raw_gc.substring(s+2, e); // s跳过</, e跳过>
//            boolean result = raw_gc.charAt(s+1) == '/' && start_tag.equalsIgnoreCase(end_tag); // 判断是否匹配
            Pair<Integer,String> token = new Pair<>(token_type, raw_gc.substring(s, e + 1));
            tokenized_gc.add(token);
            raw_gc = raw_gc.substring(e+1); // 向后解析
            return true;
        }
    }
    public static void main(String args[]) {
        //Reading input from the file.
        System.out.println("Input: ");
        System.out.println("----------------------------------------------------------------------");
        StringBuilder input = new StringBuilder();
        try{
            File file = new File(GCCParser.class.getClassLoader().getResource("example-simple.gc").getFile());
            Scanner scan = new Scanner(file);
            String line = "";
            while(scan.hasNextLine()){
                line =scan.nextLine();
                if(!line.equals("")){
                    System.out.println(line);
                    input.append(line);
                }
            }
        }catch(Exception e){
            System.out.println("File could not Loaded!!");
        }

        System.out.println("----------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Output: ");
        GCCLexer gccLexer = new GCCLexer(input.toString());
        if(gccLexer.lexGC()) {
            System.out.println("Success");
            System.out.println("Tokenized GC : ");
            for(Pair<Integer,String> token : gccLexer.tokenized_gc){
                System.out.println("TokenType: " + TOKEN_TABLE.getSymbolicName(token.getKey()) + " ,TokenValue: " + token.getValue());
            }
        }
        else {
            System.out.println("Failed");
        }
        System.out.println("----------------------------------------------------------------------");

    }

}
