package com.ljl.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        // 创建ANTLR的输入流
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("example.gc");
        if (inputStream != null) {
            CharStream input = CharStreams.fromStream(inputStream);

            // 创建Lexer并传入输入流
            GCCLexer lexer = new GCCLexer(input);

            // 创建Token流
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // 创建Parser并传入Token流
            GCCParser parser = new GCCParser(tokens);

            // 开始解析，获取语法树
            ParseTree tree = parser.config();

            // 打印语法树
            printTree(tree, 0);
        } else {
            System.err.println("无法找到资源文件 example.gc");
        }
    }

    private static void printTree(ParseTree tree, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  "); // 每一级缩进两个空格
        }

        System.out.println(tree.getClass().getSimpleName() + ": " + tree.getText());

        for (int i = 0; i < tree.getChildCount(); i++) {
            printTree(tree.getChild(i), level + 1);
        }
    }
}
