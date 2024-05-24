package com.ljl.gcc.drawer;

import com.ljl.gcc.compiler.GCCompiler;
import com.ljl.gcc.compiler.parser.TreeNode;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GCDrawer extends JFrame {
    GCCompiler compiler = new GCCompiler();
    JPanel panelConfig = new JPanel();
    JPanel panelConfigBtn = new JPanel();
    JButton show = new JButton("绘图");
    JButton configSample = new JButton("配置样例");
    TextArea fieldConfig = new TextArea("",30,30,TextArea.SCROLLBARS_BOTH);
    myCanvas cv = new myCanvas();
    Component[] configs={show,configSample};
    public static ArrayList<MyElement> MyElements =new ArrayList<MyElement>();
    private static final Map<String, Color> colorMap = new HashMap<>();

    static {
        colorMap.put("red", Color.RED);
        colorMap.put("orange", Color.ORANGE);
        colorMap.put("yellow", Color.YELLOW);
        colorMap.put("green", Color.GREEN);
        colorMap.put("cyan", Color.CYAN);
        colorMap.put("blue", Color.BLUE);
        colorMap.put("indigo", new Color(75, 0, 130));
        colorMap.put("violet", new Color(238, 130, 238));
        colorMap.put("white", Color.WHITE);
        colorMap.put("gray", Color.GRAY);
        colorMap.put("black", Color.BLACK);
    }

    public static Color parseColor(String colorName) {
        return colorMap.getOrDefault(colorName.toLowerCase(), Color.BLACK);
    }

    public GCDrawer(){
        super("计算机211_李嘉梁_211302104");
        setBounds(0, 0, 2500, 1500);
        add(panelConfig, BorderLayout.EAST);
        add(cv, BorderLayout.CENTER);

        panelConfig.setLayout(new BorderLayout());
        for(Component config :configs){
            panelConfigBtn.add(config);
            config.setFont(new Font("TimesRoman",Font.PLAIN,25));
            config.setPreferredSize(new Dimension(500,50));
        }
        panelConfig.add(panelConfigBtn, BorderLayout.NORTH);
        panelConfig.add(fieldConfig,BorderLayout.CENTER);
        fieldConfig.setFont(new Font("TimesRoman",Font.PLAIN,25));
        configSample.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = compiler.read("example.gc");
                System.out.println(text);
                fieldConfig.setText(text);
            }
        });
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MyElements.clear();
                    TreeNode configNode = compiler.compile(fieldConfig.getText());
                    if(configNode != null) {
                        if (configNode.getClass().getSimpleName().equals("ConfigNode")) {
                            for (int i = 0; i < configNode.getChildCount(); i++) {//bg,points,lines,line,curve,shape,xScale,yScale
                                TreeNode elementNode = configNode.getChild(i);
                                if (elementNode.getClass().getSimpleName().equals("ElementNode")) {
                                    TreeNode myElementNode = elementNode.getChild(0);
                                    switch (myElementNode.getClass().getSimpleName()) {
                                        case "BgNode":
                                            Bg myBg = new Bg();
                                            myBg.elementName = "bg";
                                            for (int j = 0; j < myElementNode.getChildCount(); j++) {//col,xRange,yRange
                                                TreeNode attributeNode = myElementNode.getChild(j);
                                                switch (attributeNode.getClass().getSimpleName()) {
                                                    case "ColNode":
                                                        TreeNode valueNode = attributeNode.getChild(1);
                                                        if (valueNode.getClass().getSimpleName().equals("Color_valNode")) {
                                                            TreeNode subValueNode = valueNode.getChild(0);
                                                            if (subValueNode.getClass().getSimpleName().equals("Number_tripletNode")) {
                                                                double R = Double.parseDouble(subValueNode.getChild(0).getText());
                                                                double G = Double.parseDouble(subValueNode.getChild(2).getText());
                                                                double B = Double.parseDouble(subValueNode.getChild(4).getText());
                                                                int r = (int) R;
                                                                int g = (int) G;
                                                                int b = (int) B;
                                                                if (r >= 0 && r <= 255 && g >= 0 && g <= 255 && b >= 0 && b <= 255) {
                                                                    myBg.col = new Color(r, g, b);
                                                                } else {
                                                                    myBg.col = Color.BLACK;
                                                                    System.out.println("Semantic Error: invalid color value RGB =" + r + "," + g + "," + b);
                                                                }
                                                            } else if (subValueNode.getClass().getSimpleName().equals("TokenNode")) {
                                                                myBg.col = parseColor(subValueNode.getText());
                                                                //System.out.println(myBg.col);
                                                            } else {
                                                                myBg.col = Color.BLACK;
                                                            }
                                                        } else {
                                                            myBg.col = Color.BLACK;
                                                        }
                                                        break;
                                                    case "X_rangeNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        if (valueNode.getClass().getSimpleName().equals("Number_pairNode")) {
                                                            myBg.xRangeLeft = Double.parseDouble(valueNode.getChild(0).getText());
                                                            myBg.xRangeRight = Double.parseDouble(valueNode.getChild(2).getText());
                                                        } else {
                                                            System.out.println("Semantic Error: unmatched element value:" + valueNode.getClass().getSimpleName());
                                                        }
                                                        break;
                                                    case "Y_rangeNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        if (valueNode.getClass().getSimpleName().equals("Number_pairNode")) {
                                                            myBg.yRangeBottom = Double.parseDouble(valueNode.getChild(0).getText());
                                                            myBg.yRangeTop = Double.parseDouble(valueNode.getChild(2).getText());
                                                        } else {
                                                            System.out.println("Semantic Error: unmatched element value:" + valueNode.getClass().getSimpleName());
                                                        }
                                                        break;
                                                    case "TokenNode":
                                                        // 起始或结束标签
                                                        break;
                                                    default:
                                                        System.out.println("Semantic Error: unknown element attribute:" + attributeNode.getClass().getSimpleName());
                                                        // System.exit(1);
                                                }
                                            }
                                            MyElements.add(myBg);
                                            break;
                                        case "PointsNode":
                                            Points myPoints = new Points();
                                            myPoints.elementName = "points";
                                            for (int j = 0; j < myElementNode.getChildCount(); j++) {//col,wid,pad,radius,list
                                                TreeNode attributeNode = myElementNode.getChild(j);
                                                switch (attributeNode.getClass().getSimpleName()) {
                                                    case "ColNode":
                                                        TreeNode valueNode = attributeNode.getChild(1);
                                                        if (valueNode.getClass().getSimpleName().equals("Color_valNode")) {
                                                            TreeNode subValueNode = valueNode.getChild(0);
                                                            if (subValueNode.getClass().getSimpleName().equals("Number_tripletNode")) {
                                                                double R = Double.parseDouble(subValueNode.getChild(0).getText());
                                                                double G = Double.parseDouble(subValueNode.getChild(2).getText());
                                                                double B = Double.parseDouble(subValueNode.getChild(4).getText());
                                                                int r = (int) R;
                                                                int g = (int) G;
                                                                int b = (int) B;
                                                                if (r >= 0 && r <= 255 && g >= 0 && g <= 255 && b >= 0 && b <= 255) {
                                                                    myPoints.col = new Color(r, g, b);
                                                                } else {
                                                                    myPoints.col = Color.BLACK;
                                                                    System.out.println("Semantic Error: invalid color value RGB =" + r + "," + g + "," + b);
                                                                }
                                                            } else if (subValueNode.getClass().getSimpleName().equals("TokenNode")) {
                                                                myPoints.col = parseColor(subValueNode.getText());
                                                                //System.out.println(myBg.col);
                                                            } else {
                                                                myPoints.col = Color.BLACK;
                                                            }
                                                        } else {
                                                            myPoints.col = Color.BLACK;
                                                        }
                                                        break;
                                                    case "WidNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myPoints.wid = Double.parseDouble(valueNode.getText());
                                                        break;
                                                    case "PadNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myPoints.pad = Boolean.parseBoolean(valueNode.getText());
                                                        break;
                                                    case "RadiusNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myPoints.radius = Double.parseDouble(valueNode.getText());
                                                        break;
                                                    case "ListNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        for (int k = 0; k < valueNode.getChildCount(); k++) {//col,wid,pad,radius,list
                                                            TreeNode subValueNode = valueNode.getChild(k);
                                                            myPoints.x.add(Double.parseDouble(subValueNode.getChild(0).getText()));
                                                            myPoints.y.add(Double.parseDouble(subValueNode.getChild(2).getText()));
                                                        }
                                                        break;
                                                    case "TokenNode":
                                                        // 起始或结束标签
                                                        break;
                                                    default:
                                                        System.out.println("Semantic Error: unknown element attribute:" + attributeNode.getClass().getSimpleName());
                                                        // System.exit(1);
                                                }
                                            }
                                            MyElements.add(myPoints);
                                            break;
                                        case "LinesNode":
                                            Lines myLines = new Lines();
                                            myLines.elementName = "lines";
                                            for (int j = 0; j < myElementNode.getChildCount(); j++) {//col,wid,pad,radius,list
                                                TreeNode attributeNode = myElementNode.getChild(j);
                                                switch (attributeNode.getClass().getSimpleName()) {
                                                    case "ColNode":
                                                        TreeNode valueNode = attributeNode.getChild(1);
                                                        if (valueNode.getClass().getSimpleName().equals("Color_valNode")) {
                                                            TreeNode subValueNode = valueNode.getChild(0);
                                                            if (subValueNode.getClass().getSimpleName().equals("Number_tripletNode")) {
                                                                double R = Double.parseDouble(subValueNode.getChild(0).getText());
                                                                double G = Double.parseDouble(subValueNode.getChild(2).getText());
                                                                double B = Double.parseDouble(subValueNode.getChild(4).getText());
                                                                int r = (int) R;
                                                                int g = (int) G;
                                                                int b = (int) B;
                                                                if (r >= 0 && r <= 255 && g >= 0 && g <= 255 && b >= 0 && b <= 255) {
                                                                    myLines.col = new Color(r, g, b);
                                                                } else {
                                                                    myLines.col = Color.BLACK;
                                                                    System.out.println("Semantic Error: invalid color value RGB =" + r + "," + g + "," + b);
                                                                }
                                                            } else if (subValueNode.getClass().getSimpleName().equals("TokenNode")) {
                                                                myLines.col = parseColor(subValueNode.getText());
                                                                //System.out.println(myBg.col);
                                                            } else {
                                                                myLines.col = Color.BLACK;
                                                            }
                                                        } else {
                                                            myLines.col = Color.BLACK;
                                                        }
                                                        break;
                                                    case "WidNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myLines.wid = Double.parseDouble(valueNode.getText());
                                                        break;
                                                    case "ListNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        for (int k = 0; k < valueNode.getChildCount(); k++) {//col,wid,pad,radius,list
                                                            TreeNode subValueNode = valueNode.getChild(k);
                                                            myLines.x.add(Double.parseDouble(subValueNode.getChild(0).getText()));
                                                            myLines.y.add(Double.parseDouble(subValueNode.getChild(2).getText()));
                                                        }
                                                        break;
                                                    case "TokenNode":
                                                        // 起始或结束标签
                                                        break;
                                                    default:
                                                        System.out.println("Semantic Error: unknown element attribute:" + attributeNode.getClass().getSimpleName());
                                                        // System.exit(1);
                                                }
                                            }
                                            MyElements.add(myLines);
                                            break;
                                        case "LineNode":
                                            Line myLine = new Line();
                                            myLine.elementName = "line";
                                            for (int j = 0; j < myElementNode.getChildCount(); j++) {//col,wid,point,slope
                                                TreeNode attributeNode = myElementNode.getChild(j);
                                                switch (attributeNode.getClass().getSimpleName()) {
                                                    case "ColNode":
                                                        TreeNode valueNode = attributeNode.getChild(1);
                                                        if (valueNode.getClass().getSimpleName().equals("Color_valNode")) {
                                                            TreeNode subValueNode = valueNode.getChild(0);
                                                            if (subValueNode.getClass().getSimpleName().equals("Number_tripletNode")) {
                                                                double R = Double.parseDouble(subValueNode.getChild(0).getText());
                                                                double G = Double.parseDouble(subValueNode.getChild(2).getText());
                                                                double B = Double.parseDouble(subValueNode.getChild(4).getText());
                                                                int r = (int) R;
                                                                int g = (int) G;
                                                                int b = (int) B;
                                                                if (r >= 0 && r <= 255 && g >= 0 && g <= 255 && b >= 0 && b <= 255) {
                                                                    myLine.col = new Color(r, g, b);
                                                                } else {
                                                                    myLine.col = Color.BLACK;
                                                                    System.out.println("Semantic Error: invalid color value RGB =" + r + "," + g + "," + b);
                                                                }
                                                            } else if (subValueNode.getClass().getSimpleName().equals("TokenNode")) {
                                                                myLine.col = parseColor(subValueNode.getText());
                                                                //System.out.println(myBg.col);
                                                            } else {
                                                                myLine.col = Color.BLACK;
                                                            }
                                                        } else {
                                                            myLine.col = Color.BLACK;
                                                        }
                                                        break;
                                                    case "WidNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myLine.wid = Double.parseDouble(valueNode.getText());
                                                        break;
                                                    case "PointNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        if (valueNode.getClass().getSimpleName().equals("Number_pairNode")) {
                                                            myLine.x = Double.parseDouble(valueNode.getChild(0).getText());
                                                            myLine.y = Double.parseDouble(valueNode.getChild(2).getText());
                                                        }
                                                        break;
                                                    case "SlopeNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myLine.slope = valueNode.getText();
                                                        break;
                                                    case "TokenNode":
                                                        // 起始或结束标签
                                                        break;
                                                    default:
                                                        System.out.println("Semantic Error: unknown element attribute:" + attributeNode.getClass().getSimpleName());
                                                        // System.exit(1);
                                                }
                                            }
                                            MyElements.add(myLine);
                                            break;
                                        case "CurveNode":
                                            Curve myCurve = new Curve();
                                            myCurve.elementName = "curve";
                                            for (int j = 0; j < myElementNode.getChildCount(); j++) {//col,wid,point,slope
                                                TreeNode attributeNode = myElementNode.getChild(j);
                                                switch (attributeNode.getClass().getSimpleName()) {
                                                    case "ColNode":
                                                        TreeNode valueNode = attributeNode.getChild(1);
                                                        if (valueNode.getClass().getSimpleName().equals("Color_valNode")) {
                                                            TreeNode subValueNode = valueNode.getChild(0);
                                                            if (subValueNode.getClass().getSimpleName().equals("Number_tripletNode")) {
                                                                double R = Double.parseDouble(subValueNode.getChild(0).getText());
                                                                double G = Double.parseDouble(subValueNode.getChild(2).getText());
                                                                double B = Double.parseDouble(subValueNode.getChild(4).getText());
                                                                int r = (int) R;
                                                                int g = (int) G;
                                                                int b = (int) B;
                                                                if (r >= 0 && r <= 255 && g >= 0 && g <= 255 && b >= 0 && b <= 255) {
                                                                    myCurve.col = new Color(r, g, b);
                                                                } else {
                                                                    myCurve.col = Color.BLACK;
                                                                    System.out.println("Semantic Error: invalid color value RGB =" + r + "," + g + "," + b);
                                                                }
                                                            } else if (subValueNode.getClass().getSimpleName().equals("TokenNode")) {
                                                                myCurve.col = parseColor(subValueNode.getText());
                                                                //System.out.println(myBg.col);
                                                            } else {
                                                                myCurve.col = Color.BLACK;
                                                            }
                                                        } else {
                                                            myCurve.col = Color.BLACK;
                                                        }
                                                        break;
                                                    case "WidNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myCurve.wid = Double.parseDouble(valueNode.getText());
                                                        break;
                                                    case "RangeNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        if (valueNode.getClass().getSimpleName().equals("Number_pairNode")) {
                                                            myCurve.rangeLeft = Double.parseDouble(valueNode.getChild(0).getText());
                                                            myCurve.rangeRight = Double.parseDouble(valueNode.getChild(2).getText());
                                                        }
                                                        break;
                                                    case "FunctionNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        String str = valueNode.getText();
                                                        if (str.startsWith("{") && str.endsWith("}")) {
                                                            str = str.substring(1, str.length() - 1);
                                                            myCurve.function = str;
                                                        }
                                                        break;
                                                    case "AmountNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myCurve.amount = Double.parseDouble(valueNode.getText());
                                                        break;
                                                    case "TokenNode":
                                                        // 起始或结束标签
                                                        break;
                                                    default:
                                                        System.out.println("Semantic Error: unknown element attribute:" + attributeNode.getClass().getSimpleName());
                                                        // System.exit(1);
                                                }
                                            }
                                            MyElements.add(myCurve);
                                            break;
                                        case "ShapeNode":
                                            Shape myShape = new Shape();
                                            myShape.elementName = "shape";
                                            for (int j = 0; j < myElementNode.getChildCount(); j++) {//col,wid,type,pad,center,width,height
                                                TreeNode attributeNode = myElementNode.getChild(j);
                                                switch (attributeNode.getClass().getSimpleName()) {
                                                    case "ColNode":
                                                        TreeNode valueNode = attributeNode.getChild(1);
                                                        if (valueNode.getClass().getSimpleName().equals("Color_valNode")) {
                                                            TreeNode subValueNode = valueNode.getChild(0);
                                                            if (subValueNode.getClass().getSimpleName().equals("Number_tripletNode")) {
                                                                double R = Double.parseDouble(subValueNode.getChild(0).getText());
                                                                double G = Double.parseDouble(subValueNode.getChild(2).getText());
                                                                double B = Double.parseDouble(subValueNode.getChild(4).getText());
                                                                int r = (int) R;
                                                                int g = (int) G;
                                                                int b = (int) B;
                                                                if (r >= 0 && r <= 255 && g >= 0 && g <= 255 && b >= 0 && b <= 255) {
                                                                    myShape.col = new Color(r, g, b);
                                                                } else {
                                                                    myShape.col = Color.BLACK;
                                                                    System.out.println("Semantic Error: invalid color value RGB =" + r + "," + g + "," + b);
                                                                }
                                                            } else if (subValueNode.getClass().getSimpleName().equals("TokenNode")) {
                                                                myShape.col = parseColor(subValueNode.getText());
                                                                //System.out.println(myBg.col);
                                                            } else {
                                                                myShape.col = Color.BLACK;
                                                            }
                                                        } else {
                                                            myShape.col = Color.BLACK;
                                                        }
                                                        break;
                                                    case "WidNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myShape.wid = Double.parseDouble(valueNode.getText());
                                                        break;
                                                    case "TypeNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myShape.type = valueNode.getText();
                                                        break;
                                                    case "PadNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myShape.pad = Boolean.parseBoolean(valueNode.getText());
                                                        break;
                                                    case "CenterNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        if (valueNode.getClass().getSimpleName().equals("Number_pairNode")) {
                                                            myShape.x = Double.parseDouble(valueNode.getChild(0).getText());
                                                            myShape.y = Double.parseDouble(valueNode.getChild(2).getText());
                                                        } else {
                                                            System.out.println("Semantic Error: unmatched element value:" + valueNode.getClass().getSimpleName());
                                                        }
                                                        break;
                                                    case "WidthNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myShape.width = Double.parseDouble(valueNode.getText());
                                                        break;
                                                    case "HeightNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myShape.height = Double.parseDouble(valueNode.getText());
                                                        break;
                                                    case "TokenNode":
                                                        // 起始或结束标签
                                                        break;
                                                    default:
                                                        System.out.println("Semantic Error: unknown element attribute:" + attributeNode.getClass().getSimpleName());
                                                        // System.exit(1);
                                                }
                                            }
                                            MyElements.add(myShape);
                                            break;
                                        case "ScaleNode":
                                            Scale myScale = new Scale();
                                            myScale.elementName = "scale";
                                            for (int j = 0; j < myElementNode.getChildCount(); j++) {//col,wid,direction,pos,from,step,amount,precision
                                                TreeNode attributeNode = myElementNode.getChild(j);
                                                switch (attributeNode.getClass().getSimpleName()) {
                                                    case "ColNode":
                                                        TreeNode valueNode = attributeNode.getChild(1);
                                                        if (valueNode.getClass().getSimpleName().equals("Color_valNode")) {
                                                            TreeNode subValueNode = valueNode.getChild(0);
                                                            if (subValueNode.getClass().getSimpleName().equals("Number_tripletNode")) {
                                                                double R = Double.parseDouble(subValueNode.getChild(0).getText());
                                                                double G = Double.parseDouble(subValueNode.getChild(2).getText());
                                                                double B = Double.parseDouble(subValueNode.getChild(4).getText());
                                                                int r = (int) R;
                                                                int g = (int) G;
                                                                int b = (int) B;
                                                                if (r >= 0 && r <= 255 && g >= 0 && g <= 255 && b >= 0 && b <= 255) {
                                                                    myScale.col = new Color(r, g, b);
                                                                } else {
                                                                    myScale.col = Color.BLACK;
                                                                    System.out.println("Semantic Error: invalid color value RGB =" + r + "," + g + "," + b);
                                                                }
                                                            } else if (subValueNode.getClass().getSimpleName().equals("TokenNode")) {
                                                                myScale.col = parseColor(subValueNode.getText());
                                                                //System.out.println(myBg.col);
                                                            } else {
                                                                myScale.col = Color.BLACK;
                                                            }
                                                        } else {
                                                            myScale.col = Color.BLACK;
                                                        }
                                                        break;
                                                    case "WidNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myScale.wid = Double.parseDouble(valueNode.getText());
                                                        break;
                                                    case "DirectionNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myScale.direction = valueNode.getText();
                                                        break;
                                                    case "PosNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myScale.pos = Double.parseDouble(valueNode.getText());
                                                        break;
                                                    case "FromNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myScale.from = Double.parseDouble(valueNode.getText());
                                                        break;
                                                    case "StepNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myScale.step = Double.parseDouble(valueNode.getText());
                                                        break;
                                                    case "AmountNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myScale.amount = Double.parseDouble(valueNode.getText());
                                                        break;
                                                    case "PrecisionNode":
                                                        valueNode = attributeNode.getChild(1);
                                                        myScale.precision = Double.parseDouble(valueNode.getText());
                                                        break;
                                                    case "TokenNode":
                                                        // 起始或结束标签
                                                        break;
                                                    default:
                                                        System.out.println("Semantic Error: unknown element attribute:" + attributeNode.getClass().getSimpleName());
                                                        // System.exit(1);
                                                }
                                            }
                                            MyElements.add(myScale);
                                            break;
                                        case "TokenNode":
                                            // 起始或结束标签
                                            break;
                                        default:
                                            System.out.println("Semantic Error: unknown element:" + elementNode.getClass().getSimpleName());
                                            // System.exit(1);
                                    }
                                }
                            }
                        }
                    }
                    cv.repaint();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GCDrawer();
    }
}
class myCanvas extends Canvas{
    Double zeroX = 20.0;//default
    Double zeroY = 20.0;//default
    Double intersectX = 50.0;//default
    Double intersectY = 50.0;//default
    Double intervalX = 20.0;//default
    Double intervalY = 20.0;//default
    Double xRangeLeft;//左刻度
    Double xRangeRight;//右刻度
    Double yRangeTop;//顶刻度
    Double yRangeBottom;//底刻度
    Double posX = 0.0;//default
    Double posY = 0.0;//default
    int time=0;//update
    myCanvas() {
        //setBackground(Color.WHITE);
        setPreferredSize(new Dimension(300,300));
        setFont(new Font("TimesRoman",Font.PLAIN,25));
    }
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        for(MyElement myElement: GCDrawer.MyElements){
            if(myElement.elementName.equals("bg")){
                Bg myBg= (Bg)myElement;
                setBackground(myBg.col);
                intervalX = getWidth() / (myBg.xRangeRight-myBg.xRangeLeft);//单位数值对应显示长度
                intervalY = getHeight() / (myBg.yRangeTop- myBg.yRangeBottom);
                xRangeLeft=myBg.xRangeLeft;
                xRangeRight=myBg.xRangeRight;
                yRangeTop= myBg.yRangeTop;
                yRangeBottom=myBg.yRangeBottom;
            }
            else if(myElement.elementName.equals("scale")){//col,wid,direction,pos,from,step,amount,precision
                Scale myScale = (Scale)myElement;
                g2d.setColor(myScale.col);
                g2d.setStroke(new BasicStroke(myScale.wid.floatValue()));
                if(myScale.direction.equals("x")){
                    double edgeX=(myScale.from-xRangeLeft)*intervalX;//x轴左端点横坐标
                    posX= myScale.pos;
                    zeroX=(0.0-xRangeLeft)*intervalX;//x轴零点横坐标

                    intersectX=(posY-xRangeLeft)*intervalX;//y轴横坐标//posY已知//一错二对

                    Line2D line = new Line2D.Double(edgeX,intersectY,edgeX+myScale.amount*myScale.step*intervalX,intersectY);//intersectY已知//一错二对
                    g2d.draw(line);
                    int amount=0;
                    for (double i = edgeX; amount <= myScale.amount; i += intervalX*myScale.step, amount++) {//从左向右
                        Line2D mark = new Line2D.Double(i,intersectY,i,intersectY-10);
                        g2d.draw(mark);
                        //NumberFormat nf= NumberFormat.getNumberInstance();
                        DecimalFormat nf = new DecimalFormat("0.00000");
                        nf.setMaximumFractionDigits(myScale.precision.intValue());
                        //nf.setRoundingMode(RoundingMode.UP);
                        g2d.drawString(nf.format(myScale.from + amount* myScale.step), (float) i, Float.parseFloat(String.valueOf(intersectY+45)));
                    }
                }
                else if(myScale.direction.equals("y")){
                    double edgeY=(yRangeTop- myScale.from)*intervalY;//y轴下端点纵坐标
                    posY= myScale.pos;
                    zeroY=(yRangeTop-0.0)*intervalY;//y轴零点纵坐标

                    intersectY=(yRangeTop-posX)*intervalY;//x轴纵坐标//posX已知//一错二对

                    Line2D line = new Line2D.Double(intersectX,edgeY,intersectX,edgeY - myScale.amount*myScale.step*intervalY);//intersectX已知//一错二对
                    g2d.draw(line);
                    int amount=0;
                    for (double i = edgeY; amount <= myScale.amount; i -= intervalY*myScale.step, amount++) {//从下向上
                        Line2D mark = new Line2D.Double(intersectX,i,intersectX+10,i);
                        g2d.draw(mark);
                        //NumberFormat nf= NumberFormat.getNumberInstance();
                        DecimalFormat nf = new DecimalFormat("0.00000");
                        nf.setMaximumFractionDigits(myScale.precision.intValue());
                        //nf.setRoundingMode(RoundingMode.UP);
                        g2d.drawString(nf.format(myScale.from + amount* myScale.step), Float.parseFloat(String.valueOf(intersectX-45)), (float) i);
                    }
                }
                time++;
                if (time == 2){
                    update(g2d);
                    System.out.println("Updated!");
                    time = 0;
                }
            }
            else if(myElement.elementName.equals("shape")){
                Shape myShape = (Shape)myElement;
                g2d.setColor(myShape.col);
                g2d.setStroke(new BasicStroke(myShape.wid.floatValue()));
                if (myShape.type.equals("oval")){
                    Ellipse2D oval =new Ellipse2D.Double(zeroX+intervalX*myShape.x-intervalX*myShape.width/2, zeroY-intervalY*myShape.y-intervalY*myShape.height/2, intervalX*myShape.width, intervalY*myShape.height);
                    if(myShape.pad){
                        g2d.fill(oval);
                    }
                    else{
                        g2d.draw(oval);
                    }
                }
                else if (myShape.type.equals("rect")){
                    Rectangle2D rect =new Rectangle2D.Double(zeroX+intervalX*myShape.x-intervalX*myShape.width/2, zeroY-intervalY*myShape.y-intervalY*myShape.height/2, intervalX*myShape.width, intervalY*myShape.height);
                    if(myShape.pad){
                        g2d.fill(rect);
                    }
                    else{
                        g2d.draw(rect);
                    }
                }
            }
            else if(myElement.elementName.equals("points")){//col,wid,pad,radius,list
                Points myPoints = (Points)myElement;
                g2d.setColor(myPoints.col);
                g2d.setStroke(new BasicStroke(myPoints.wid.floatValue()));
                for(int i=0; i<myPoints.x.size();i++){
                    Ellipse2D oval =new Ellipse2D.Double(zeroX+intervalX* myPoints.x.get(i) -myPoints.radius, zeroY-intervalY* myPoints.y.get(i)-myPoints.radius, myPoints.radius*2.0, myPoints.radius*2.0);
                    if(myPoints.pad){
                        g2d.fill(oval);
                    }
                    else{
                        g2d.draw(oval);
                    }
                }
            }
            else if(myElement.elementName.equals("lines")){//col,wid,list
                Lines myLines = (Lines)myElement;
                g2d.setColor(myLines.col);
                g2d.setStroke(new BasicStroke(myLines.wid.floatValue()));
                for(int i=0; i<myLines.x.size()-1;i++){
                    Line2D line =new Line2D.Double(zeroX+intervalX* myLines.x.get(i), zeroY-intervalY* myLines.y.get(i), zeroX+intervalX* myLines.x.get(i+1), zeroY-intervalY* myLines.y.get(i+1));
                    g2d.draw(line);
                }
            }
            else if(myElement.elementName.equals("line")){//col,wid,point,slope
                Line myLine = (Line)myElement;
                g2d.setColor(myLine.col);
                g2d.setStroke(new BasicStroke(myLine.wid.floatValue()));
                if(myLine.slope.equals("inf")) {
                    Line2D line =new Line2D.Double(zeroX+intervalX*myLine.x,0,zeroX+intervalX*myLine.x,getHeight());
                    g2d.draw(line);
                }
                else if(Double.parseDouble(myLine.slope)==0) {
                    Line2D line =new Line2D.Double(0,zeroX+intervalX*myLine.y,getWidth(),zeroX+intervalX*myLine.y);
                    g2d.draw(line);
                }
                else{
                    double k =Double.parseDouble(myLine.slope);
                    double xLeft = xRangeLeft;
                    double yLeft = xLeft-k*myLine.x+myLine.y;
                    double xRight = xRangeRight;
                    double yRight = k*xRight-k*myLine.x+myLine.y;
                    Line2D line =new Line2D.Double(0, zeroY-intervalY* yLeft, getWidth(), zeroY-intervalY* yRight);
                    g2d.draw(line);
                }
            }
            else if(myElement.elementName.equals("curve")){//col,wid,range,amount,function
                Curve myCurve = (Curve)myElement;
                g2d.setColor(myCurve.col);
                g2d.setStroke(new BasicStroke(myCurve.wid.floatValue()));
                ArrayList<Double> x = new ArrayList<Double>();
                ArrayList<Double> y = new ArrayList<Double>();
                ScriptEngineManager manager = new ScriptEngineManager();
                ScriptEngine engine = manager.getEngineByName("js");
                double curveInterval = (myCurve.rangeRight- myCurve.rangeLeft)/ myCurve.amount;
                for(double i=myCurve.rangeLeft; i<=myCurve.rangeRight;i+=curveInterval){
                    x.add(i);
                    String iString = Double.toString(i);
                    Double result = null;
                    try {
                        result = Double.valueOf(engine.eval(myCurve.function.replace("x",iString)).toString());
                    } catch (ScriptException e) {
                        e.printStackTrace();
                    }
                    y.add(result);
                }
                for(int i=0; i<x.size()-1;i++) {
                    Line2D line = new Line2D.Double(zeroX + intervalX * x.get(i), zeroY - intervalY * y.get(i), zeroX + intervalX * x.get(i + 1), zeroY - intervalY * y.get(i + 1));
                    g2d.draw(line);
                }
            }
        }
    }
}
class MyElement{//bg,points,lines,line,curve,shape,xScale,yScale
    String elementName; // 元素名
    Color col = Color.BLACK; // 颜色
}
class Bg extends MyElement{
    Double xRangeLeft; // 左界
    Double xRangeRight; // 右界
    Double yRangeTop; // 上界
    Double yRangeBottom; // 下界
}
class Points extends MyElement{//wid,pad,radius,list
    Double wid = 1.0d; // 线宽
    Boolean pad; // 填充
    Double radius; // 半径
    ArrayList<Double> x = new ArrayList<Double>(); // x集
    ArrayList<Double> y = new ArrayList<Double>(); // y集
}
class Lines extends MyElement{//wid,list
    Double wid = 1.0d; // 线宽
    ArrayList<Double> x = new ArrayList<Double>(); // x集
    ArrayList<Double> y = new ArrayList<Double>(); // y集
}
class Line extends MyElement{//wid,point,slope
    Double wid = 1.0d; // 线宽
    Double x; // x坐标
    Double y; // y坐标
    String slope; // 斜率
}
class Curve extends MyElement{//wid,range,amount,function
    Double wid = 1.0d; // 线宽
    Double rangeLeft; // 左界
    Double rangeRight; // 右界
    Double amount; // 线元数
    String function; // 函数方程
}
class Shape extends MyElement{//wid,type,pad,center(x,y),width,height
    Double wid = 1.0d; // 线宽
    String type; // 形状
    Boolean pad; // 填充
    //String center;//x,y
    Double x; // 中心x坐标
    Double y; // 中心y坐标
    Double width; // 宽度
    Double height; // 高度
}
class Scale extends MyElement{//wid,direction,pos,from,step,amount,precision
    Double wid = 1.0d; // 线宽
    String direction; // 方向
    Double pos; // 起始点相对坐标
    Double from; // 起始点值
    Double step; // 步长
    Double amount; // 线段数
    Double precision; // 精度
}
