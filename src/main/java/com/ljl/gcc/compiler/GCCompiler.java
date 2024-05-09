package com.ljl.gcc.compiler;

import com.ljl.gcc.compiler.lexer.GCLexer;
import com.ljl.gcc.compiler.parser.GCParser;
import com.ljl.gcc.compiler.parser.TreeNode;
import com.ljl.gcc.compiler.token.Token;
import com.ljl.gcc.compiler.token.TokenTable;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GCCompiler {

    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    protected static final TokenTable TOKENTABLE = new TokenTable(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    protected static final int // 种别编码 INVALID_TYPE = 0,EOF = -1,
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
    protected static final int
            RULE_config = 0, RULE_element = 1, RULE_bg = 2, RULE_shape = 3, RULE_points = 4,
            RULE_line = 5, RULE_lines = 6, RULE_curve = 7, RULE_scale = 8, RULE_col = 9,
            RULE_x_range = 10, RULE_y_range = 11, RULE_wid = 12, RULE_width = 13,
            RULE_height = 14, RULE_pad = 15, RULE_radius = 16, RULE_list = 17, RULE_point = 18,
            RULE_slope = 19, RULE_range = 20, RULE_amount = 21, RULE_direction = 22,
            RULE_pos = 23, RULE_from = 24, RULE_step = 25, RULE_precision = 26, RULE_type = 27,
            RULE_center = 28, RULE_function = 29, RULE_number_pair = 30, RULE_number_pair_list = 31,
            RULE_number_triplet = 32, RULE_color_val = 33;
    protected static String[] makeLiteralNames() {
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
    protected static String[] makeSymbolicNames() {
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

    protected static final List<String> DIRECTION_TYPES = new ArrayList<>(Arrays.asList(
            "x", "y"));
    protected static final List<String> COLOR_TYPES = new ArrayList<>(Arrays.asList(
            "red", "orange", "yellow", "green", "cyan", "blue",
            "indigo", "violet", "white", "gray", "black"));
    protected static final List<String> SHAPE_TYPES = new ArrayList<>(Arrays.asList(
            "oval", "rect"));

    public TokenTable getTokenTable() {
        return TOKENTABLE;
    }

    public static void main(String args[]) {
        GCCompiler compiler = new GCCompiler();
        String text = compiler.read("example.gc");
        compiler.compile(text);
    }

    public String read(String filePath) {
        //Reading input from the file.
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Input: ");
        StringBuilder input = new StringBuilder();
        try{
            File file = new File(GCCompiler.class.getClassLoader().getResource(filePath).getFile());
            Scanner scan = new Scanner(file);
            String line = "";
            while(scan.hasNextLine()){
                line =scan.nextLine();
                if(!line.equals("")){
//                    System.out.println(line);
                    input.append(line).append("\n");
                }
            }
        }catch(Exception e){
            System.out.println("File could not Loaded!!");
            System.err.println("无法找到资源文件 example.gc");
        }
        System.out.println("----------------------------------------------------------------------");
        return input.toString();
    }

    public TreeNode compile(String input) {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Lex Output: ");
        // 创建Lexer并传入输入流
        GCLexer lexer = new GCLexer(input);
        // 开始词法分析
        if(lexer.lex()) {
            System.out.println("Lex Successfully");
            System.out.println("Tokens: ");
            // 获取Token流
            List<Token> tokens = lexer.get_output();
            // 打印Token流
            printTokens(tokens);
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Parse Output: ");
            // 创建Parser并传入Token流
            GCParser parser = new GCParser(tokens);
            // 开始语法分析
            if(parser.parse()) {
                System.out.println("Parse Successfully");
                System.out.println("Parse Tree: ");
                // 获取语法树
                TreeNode rootNode = parser.get_output();
                // 打印语法树
                printTree(rootNode, 0);
                System.out.println("----------------------------------------------------------------------");
                return rootNode;
            }
            else {
                System.out.println("Parse Failed");
            }
        }
        else {
            System.out.println("Lex Failed");
        }
        return null;
    }

    public void printTokens(List<Token> tokens){
        for(Token token : tokens){
            System.out.println(token.toString());
        }
    }

    private void printTree(TreeNode treeNode, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  "); // 每一级缩进两个空格
        }

        System.out.println(treeNode.getClass().getSimpleName() + ": " + treeNode.getText());

        for (int i = 0; i < treeNode.getChildCount(); i++) {
            printTree(treeNode.getChild(i), level + 1);
        }
    }

}
