package com.ljl.gcc;

import java.util.*;
import java.io.File;

public class GCCParser {
    String gc = "";
    ArrayList<String> token;

    public GCCParser(String gc) {
        this.gc = gc;
        this.token = new ArrayList<String>();
    }

    public String parseGC() {
        gc = gc.trim();
        if(gc.length() == 0) { // 判断是否为空
            return "";
        }
        else if(gc.charAt(0)=='<' && gc.charAt(1) != '/') { // 判断是否为起始标签
            String st = startTag(); // 获取起始标签
            String r = parseGC(); // 向下递归解析
            boolean result = endTag(st); // 获取结束标签并判断是否匹配起始标签
            String r1 = parseGC(); // 向下递归解析
            if(!result || r1==null || r == null) {
                System.out.println("Invalid GC!!!");
                return null;
            }
            if(r1.length()>0) {
                return "{'"+st+"':"+r+","+r1.substring(1, r1.length()-1)+"}"; // 返回多个属性集合
            }
            else {

                return "{'"+st+"':"+r+"}"; // 返回单个属性集合
            }
        }
        else{ // 判断是否为内容
            String content = content();
            return content;
        }
    }
    public String content() { // 处理内容
        int e = gc.indexOf("<"); // 获取<的位置
        String result = gc.substring(0, e).trim(); // 获取内容
        if(!result.equals("")) { // 判断是否为空
            if(!(isBoolean(result) || isNumber(result))) {
                result = "'" + result + "'";
            }
            token.add(result);
        }
        gc = gc.substring(e); // 向后解析
        return result;
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
    public String startTag() { // 处理起始标签<example>
        int s = gc.indexOf("<");
        int e = gc.indexOf(">");
        String result = gc.substring(s + 1, e); // s跳过<, e跳过>
        gc = gc.substring(e+1); // 向后解析
        token.add(result); // 添加到token中
        return result;
    }
    public boolean endTag(String start) { // 处理结束标签</example>
        int s = gc.indexOf("<");
        int e = gc.indexOf(">");
        if(e<0 || s<0) {
            return false;
        }
        String tag = gc.substring(s+2, e); // s跳过</, e跳过>
        boolean result = gc.charAt(s+1) == '/' && start.equalsIgnoreCase(tag);
        gc = gc.substring(e+1); // 向后解析
        return result;
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
        GCCParser file = new GCCParser(input.toString());
        String output = file.parseGC();
        System.out.println("Tokens : "+file.token.toString());
        System.out.println("----------------------------------------------------------------------");
        System.out.println(format(output));
        System.out.println("----------------------------------------------------------------------");

    }
    public static String format(String str) {
        if(str == null) {
            System.out.print("NOT Valid JSON");
            return "";
        }
        String result = "";
        int tabs = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '{') {
                tabs++;
                result += "{\n";
                for(int j=0; j<tabs; j++)
                    result += "\t";
            }
            else if(str.charAt(i)=='}'){
                result+="\n";
                tabs--;
                for(int j=0; j<tabs; j++)
                    result += "\t";

                result += "}";
            }
            else if(str.charAt(i) == ',') {
                result += ",\n";
                for(int j=0; j<tabs; j++)
                    result += "\t";
            }
            else {
                result += str.charAt(i);
            }

        }
        return result;
    }

}
