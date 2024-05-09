package com.ljl.gcc.drawer;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;

import com.ljl.gcc.compiler.GCCompiler;
import com.ljl.gcc.compiler.parser.TreeNode;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.dom4j.DocumentHelper;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

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

    public GCDrawer(){
        super("计算机211_李嘉梁_211302104");
        setBounds(400, 400, 1700, 1000);
        add(panelConfig, BorderLayout.EAST);
        add(cv, BorderLayout.CENTER);

        panelConfig.setLayout(new BorderLayout());
        for(Component config :configs){
            panelConfigBtn.add(config);
            config.setFont(new Font("TimesRoman",Font.PLAIN,25));
            config.setPreferredSize(new Dimension(220,50));
        }
        panelConfig.add(panelConfigBtn, BorderLayout.NORTH);
        panelConfig.add(fieldConfig,BorderLayout.CENTER);
        fieldConfig.setFont(new Font("TimesRoman",Font.PLAIN,25));
        configSample.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SAXReader saxReader = new SAXReader();
                try {
                    Document document = saxReader.read(GCDrawer.class.getClassLoader()
                            .getResource("config.xml"));
                    String text = document.asXML();
                    //System.out.println(text);
                    fieldConfig.setText(text);
                } catch (DocumentException ex) {
                    ex.printStackTrace();
                }
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
                    if(configNode.getClass().getSimpleName().equals("ConfigNode")) {
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
                                                        TreeNode subValueNode = valueNode.getChild(1);
                                                        if (subValueNode.getClass().getSimpleName().equals("Number_tripletNode")) {
                                                            double R = Double.parseDouble(subValueNode.getChild(0).getText());
                                                            double G = Double.parseDouble(subValueNode.getChild(2).getText());
                                                            double B = Double.parseDouble(subValueNode.getChild(4).getText());
                                                            int r = (int) R;
                                                            int g = (int) G;
                                                            int b = (int) B;
                                                            myBg.col = new Color(r, g, b);
                                                        }
                                                        else if (subValueNode.getClass().getSimpleName().equals("TokenNode")){
                                                            Field field = Class.forName("java.awt.Color").getField(subValueNode.getText());
                                                            myBg.col = (Color) field.get(null);
                                                            //System.out.println(myBg.col);
                                                        }
                                                        else {
                                                            myBg.col = Color.BLACK;
                                                        }
                                                    }
                                                    break;
                                                case "X_rangeNode":
                                                    valueNode = attributeNode.getChild(1);
                                                    if (valueNode.getClass().getSimpleName().equals("Number_pairNode")) {
                                                        myBg.xRangeLeft = Double.parseDouble(valueNode.getChild(0).getText());
                                                        myBg.xRangeRight = Double.parseDouble(valueNode.getChild(2).getText());
                                                    }
                                                    break;
                                                case "Y_rangeNode":
                                                    valueNode = attributeNode.getChild(1);
                                                    if (valueNode.getClass().getSimpleName().equals("Number_pairNode")) {
                                                        myBg.yRangeBottom = Double.parseDouble(valueNode.getChild(0).getText());
                                                        myBg.yRangeTop = Double.parseDouble(valueNode.getChild(2).getText());
                                                    }
                                                    break;
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
                                                        TreeNode subValueNode = valueNode.getChild(1);
                                                        if (subValueNode.getClass().getSimpleName().equals("Number_tripletNode")) {
                                                            double R = Double.parseDouble(subValueNode.getChild(0).getText());
                                                            double G = Double.parseDouble(subValueNode.getChild(2).getText());
                                                            double B = Double.parseDouble(subValueNode.getChild(4).getText());
                                                            int r = (int) R;
                                                            int g = (int) G;
                                                            int b = (int) B;
                                                            myPoints.col = new Color(r, g, b);
                                                        }
                                                        else if (subValueNode.getClass().getSimpleName().equals("TokenNode")){
                                                            Field field = Class.forName("java.awt.Color").getField(subValueNode.getText());
                                                            myPoints.col = (Color) field.get(null);
                                                            //System.out.println(myBg.col);
                                                        }
                                                        else {
                                                            myPoints.col = Color.BLACK;
                                                        }
                                                    }
                                                    break;
                                                    // ----------------------------------------------------------------------------- //
                                                case "WidNode":
                                                    myPoints.wid = Float.parseFloat(attributeNode.getText());
                                                    break;
                                                case "PadNode":
                                                    myPoints.pad = attributeNode.getText().trim();
                                                    break;
                                                case "RadiusNode":
                                                    myPoints.radius = Double.parseDouble(attributeNode.getText());
                                                    break;
                                                case "ListNode":
                                                    String s = attributeNode.getText();
                                                    BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(s.getBytes(Charset.forName("utf8"))), Charset.forName("utf8")));
                                                    String line;
                                                    while ((line = br.readLine()) != null) {
                                                        if (!line.trim().equals("")) {
                                                            myPoints.x.add(Double.parseDouble(line.split(",")[0]));
                                                            myPoints.y.add(Double.parseDouble(line.split(",")[1]));
                                                        }
                                                    }
                                                    break;
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
                                                    if (attributeNode.getText().contains(",")) {
                                                        float R = Float.parseFloat(attributeNode.getText().split(",")[0]);
                                                        float G = Float.parseFloat(attributeNode.getText().split(",")[1]);
                                                        float B = Float.parseFloat(attributeNode.getText().split(",")[2]);
                                                        int r = (int) R;
                                                        int g = (int) G;
                                                        int b = (int) B;
                                                        myLines.col = new Color(r, g, b);
                                                    } else if (attributeNode.getText().trim().equals(""))
                                                        myLines.col = Color.BLACK;
                                                    else {
                                                        Field field = Class.forName("java.awt.Color").getField(attributeNode.getText().trim());
                                                        myLines.col = (Color) field.get(null);
                                                        System.out.println(myLines.col);
                                                    }
                                                    break;
                                                case "WidNode":
                                                    myLines.wid = Float.parseFloat(attributeNode.getText());
                                                    break;
                                                case "ListNode":
                                                    String s = attributeNode.getText();
                                                    BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(s.getBytes(Charset.forName("utf8"))), Charset.forName("utf8")));
                                                    String line;
                                                    while ((line = br.readLine()) != null) {
                                                        if (!line.trim().equals("")) {
                                                            myLines.x.add(Double.parseDouble(line.split(",")[0]));
                                                            myLines.y.add(Double.parseDouble(line.split(",")[1]));
                                                        }
                                                    }
                                                    break;
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
                                                    if (attributeNode.getText().contains(",")) {
                                                        float R = Float.parseFloat(attributeNode.getText().split(",")[0]);
                                                        float G = Float.parseFloat(attributeNode.getText().split(",")[1]);
                                                        float B = Float.parseFloat(attributeNode.getText().split(",")[2]);
                                                        int r = (int) R;
                                                        int g = (int) G;
                                                        int b = (int) B;
                                                        myLine.col = new Color(r, g, b);
                                                    } else if (attributeNode.getText().trim().equals(""))
                                                        myLine.col = Color.BLACK;
                                                    else {
                                                        Field field = Class.forName("java.awt.Color").getField(attributeNode.getText().trim());
                                                        myLine.col = (Color) field.get(null);
                                                        //System.out.println(myShape.col);
                                                    }
                                                    break;
                                                case "WidNode":
                                                    myLine.wid = Float.parseFloat(attributeNode.getText());
                                                    break;
                                                case "PointNode":
                                                    myLine.x = Double.parseDouble(attributeNode.getText().split(",")[0]);
                                                    myLine.y = Double.parseDouble(attributeNode.getText().split(",")[1]);
                                                    break;
                                                case "SlopeNode":
                                                    myLine.slope = attributeNode.getText().trim();
                                                    break;
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
                                                    if (attributeNode.getText().contains(",")) {
                                                        float R = Float.parseFloat(attributeNode.getText().split(",")[0]);
                                                        float G = Float.parseFloat(attributeNode.getText().split(",")[1]);
                                                        float B = Float.parseFloat(attributeNode.getText().split(",")[2]);
                                                        int r = (int) R;
                                                        int g = (int) G;
                                                        int b = (int) B;
                                                        myCurve.col = new Color(r, g, b);
                                                    } else if (attributeNode.getText().trim().equals(""))
                                                        myCurve.col = Color.BLACK;
                                                    else {
                                                        Field field = Class.forName("java.awt.Color").getField(attributeNode.getText().trim());
                                                        myCurve.col = (Color) field.get(null);
                                                        //System.out.println(myShape.col);
                                                    }
                                                    break;
                                                case "WidNode":
                                                    myCurve.wid = Float.parseFloat(attributeNode.getText());
                                                    break;
                                                case "RangeNode":
                                                    myCurve.rangeLeft = Double.parseDouble(attributeNode.getText().split(",")[0]);
                                                    myCurve.rangeRight = Double.parseDouble(attributeNode.getText().split(",")[1]);
                                                    break;
                                                case "FunctionNode":
                                                    myCurve.function = attributeNode.getText().trim();
                                                    break;
                                                case "AmountNode":
                                                    myCurve.amount = Double.parseDouble(attributeNode.getText());
                                                    break;
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
                                                    if (attributeNode.getText().contains(",")) {
                                                        float R = Float.parseFloat(attributeNode.getText().split(",")[0]);
                                                        float G = Float.parseFloat(attributeNode.getText().split(",")[1]);
                                                        float B = Float.parseFloat(attributeNode.getText().split(",")[2]);
                                                        int r = (int) R;
                                                        int g = (int) G;
                                                        int b = (int) B;
                                                        myShape.col = new Color(r, g, b);
                                                    } else if (attributeNode.getText().trim().equals(""))
                                                        myShape.col = Color.BLACK;
                                                    else {
                                                        Field field = Class.forName("java.awt.Color").getField(attributeNode.getText().trim());
                                                        myShape.col = (Color) field.get(null);
                                                        //System.out.println(myShape.col);
                                                    }
                                                    break;
                                                case "WidNode":
                                                    myShape.wid = Float.parseFloat(attributeNode.getText());
                                                    break;
                                                case "TypeNode":
                                                    myShape.type = attributeNode.getText().trim();
                                                    break;
                                                case "PadNode":
                                                    myShape.pad = attributeNode.getText().trim();
                                                    break;
                                                case "CenterNode":
                                                    //myShape.center=Attribute.getText();
                                                    myShape.x = Double.parseDouble(attributeNode.getText().split(",")[0]);
                                                    myShape.y = Double.parseDouble(attributeNode.getText().split(",")[1]);
                                                    break;
                                                case "WidthNode":
                                                    myShape.width = Double.parseDouble(attributeNode.getText());
                                                    ;
                                                    break;
                                                case "HeightNode":
                                                    myShape.height = Double.parseDouble(attributeNode.getText());
                                                    break;
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
                                                    if (attributeNode.getText().contains(",")) {
                                                        float R = Float.parseFloat(attributeNode.getText().split(",")[0]);
                                                        float G = Float.parseFloat(attributeNode.getText().split(",")[1]);
                                                        float B = Float.parseFloat(attributeNode.getText().split(",")[2]);
                                                        int r = (int) R;
                                                        int g = (int) G;
                                                        int b = (int) B;
                                                        myScale.col = new Color(r, g, b);
                                                    } else if (attributeNode.getText().trim().equals(""))
                                                        myScale.col = Color.BLACK;
                                                    else {
                                                        Field field = Class.forName("java.awt.Color").getField(attributeNode.getText().trim());
                                                        myScale.col = (Color) field.get(null);
                                                        //System.out.println(myShape.col);
                                                    }
                                                    break;
                                                case "WidNode":
                                                    myScale.wid = Float.parseFloat(attributeNode.getText());
                                                    break;
                                                case "DirectionNode":
                                                    myScale.direction = attributeNode.getText().trim();
                                                    break;
                                                case "PosNode":
                                                    myScale.pos = Double.parseDouble(attributeNode.getText());
                                                    break;
                                                case "FromNode":
                                                    myScale.from = Double.parseDouble(attributeNode.getText());
                                                    break;
                                                case "StepNode":
                                                    myScale.step = Double.parseDouble(attributeNode.getText());
                                                    break;
                                                case "AmountNode":
                                                    myScale.amount = Double.parseDouble(attributeNode.getText());
                                                    break;
                                                case "PrecisionNode":
                                                    myScale.precision = Double.parseDouble(attributeNode.getText());
                                                    break;
                                            }
                                        }
                                        MyElements.add(myScale);
                                        break;
                                }
                            }
                        }
                    }
                    cv.repaint();
                } catch (NoSuchFieldException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
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
                g2d.setStroke(new BasicStroke(myScale.wid));
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
                g2d.setStroke(new BasicStroke(myShape.wid));
                if (myShape.type.equals("oval")){
                    Ellipse2D oval =new Ellipse2D.Double(zeroX+intervalX*myShape.x-intervalX*myShape.width/2, zeroY-intervalY*myShape.y-intervalY*myShape.height/2, intervalX*myShape.width, intervalY*myShape.height);
                    if(myShape.pad.equals("true")){
                        g2d.fill(oval);
                    }
                    else{
                        g2d.draw(oval);
                    }
                }
                else if (myShape.type.equals("rect")){
                    Rectangle2D rect =new Rectangle2D.Double(zeroX+intervalX*myShape.x-intervalX*myShape.width/2, zeroY-intervalY*myShape.y-intervalY*myShape.height/2, intervalX*myShape.width, intervalY*myShape.height);
                    if(myShape.pad.equals("true")){
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
                g2d.setStroke(new BasicStroke(myPoints.wid));
                for(int i=0; i<myPoints.x.size();i++){
                    Ellipse2D oval =new Ellipse2D.Double(zeroX+intervalX* myPoints.x.get(i) -myPoints.radius, zeroY-intervalY* myPoints.y.get(i)-myPoints.radius, myPoints.radius*2.0, myPoints.radius*2.0);
                    if(myPoints.pad.equals("true")){
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
                g2d.setStroke(new BasicStroke(myLines.wid));
                for(int i=0; i<myLines.x.size()-1;i++){
                    Line2D line =new Line2D.Double(zeroX+intervalX* myLines.x.get(i), zeroY-intervalY* myLines.y.get(i), zeroX+intervalX* myLines.x.get(i+1), zeroY-intervalY* myLines.y.get(i+1));
                    g2d.draw(line);
                }
            }
            else if(myElement.elementName.equals("line")){//col,wid,point,slope
                Line myLine = (Line)myElement;
                g2d.setColor(myLine.col);
                g2d.setStroke(new BasicStroke(myLine.wid));
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
                g2d.setStroke(new BasicStroke(myCurve.wid));
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
    String elementName;
    Color col = Color.BLACK;
}
class Bg extends MyElement{
    Double xRangeLeft;
    Double xRangeRight;
    Double yRangeTop;
    Double yRangeBottom;
}
class Points extends MyElement{//wid,pad,radius,list
    Float wid=1.0f;
    String pad;
    Double radius;
    ArrayList<Double> x = new ArrayList<Double>();
    ArrayList<Double> y = new ArrayList<Double>();
}
class Lines extends MyElement{//wid,list
    Float wid=1.0f;
    ArrayList<Double> x = new ArrayList<Double>();
    ArrayList<Double> y = new ArrayList<Double>();
}
class Line extends MyElement{//wid,point,slope
    Float wid=1.0f;
    Double x;
    Double y;
    String slope;
}
class Curve extends MyElement{//wid,range,amount,function
    Float wid=1.0f;
    Double rangeLeft;
    Double rangeRight;
    Double amount;
    String function;
}
class Shape extends MyElement{//wid,type,pad,center,width,height
    Float wid=1.0f;
    String type;
    String pad;
    //String center;//x,y
    Double x;
    Double y;
    Double width;
    Double height;
}
class Scale extends MyElement{//wid,direction,pos,from,step,amount,precision
    Float wid=1.0f;
    String direction;
    Double pos;
    Double from;
    Double step;
    Double amount;
    Double precision;
}
