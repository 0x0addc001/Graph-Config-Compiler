package com.ljl.gcc;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
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

public class GCCDrawer extends JFrame {
    JPanel panelConfig = new JPanel();
    JPanel panelConfigBtn = new JPanel();
    JButton show = new JButton("绘图");
    JButton configSample = new JButton("配置样例");
    TextArea fieldConfig = new TextArea("",30,30,TextArea.SCROLLBARS_BOTH);
    myCanvas cv = new myCanvas();
    Component[] configs={show,configSample};
    public static ArrayList<MyElement> MyElements =new ArrayList<MyElement>();
    public GCCDrawer(){
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
                    Document document = saxReader.read(GCCDrawer.class.getClassLoader()
                            .getResource("config.xml"));
                    String text = document.asXML();
                    //System.out.println(text);
                    fieldConfig.setText(text);
                } catch (DocumentException ex) {
                    ex.printStackTrace();
                }
            }
        });
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //SAXReader saxReader = new SAXReader();
                try {
                    //Document document = saxReader.read(GCCDrawer.class.getClassLoader()
                    //        .getResource("config.xml"));
                    Document document = DocumentHelper.parseText(fieldConfig.getText());
                    Element rootElement = document.getRootElement();
                    List<Element> ElementList = rootElement.elements();
                    MyElements.clear();
                    for (Element myElement : ElementList) {//bg,points,lines,line,curve,shape,xScale,yScale
                        if(myElement.getName().equals("bg")){
                            Bg myBg = new Bg();
                            myBg.elementName="bg";
                            List<Element> myElementAttributeList = myElement.elements();
                            for (Element Attribute : myElementAttributeList) {//col,xRange,yRange
                                if(Attribute.getName().equals("col")){
                                    if(Attribute.getText().contains(",")){
                                        float R=Float.parseFloat(Attribute.getText().split(",")[0]);
                                        float G=Float.parseFloat(Attribute.getText().split(",")[1]);
                                        float B=Float.parseFloat(Attribute.getText().split(",")[2]);
                                        int r= (int)R;
                                        int g= (int)G;
                                        int b= (int)B;
                                        myBg.col= new Color(r,g,b);
                                    }
                                    else if(Attribute.getText().trim().equals(""))myBg.col = Color.BLACK;
                                    else{
                                        Field field = Class.forName("java.awt.Color").getField(Attribute.getText().trim());
                                        myBg.col = (Color)field.get(null);
                                        //System.out.println(myBg.col);
                                    }
                                }
                                else if(Attribute.getName().equals("xRange")){
                                    myBg.xRangeLeft=Double.parseDouble(Attribute.getText().split(",")[0]);
                                    myBg.xRangeRight=Double.parseDouble(Attribute.getText().split(",")[1]);
                                }
                                else if(Attribute.getName().equals("yRange")){
                                    myBg.yRangeBottom=Double.parseDouble(Attribute.getText().split(",")[0]);
                                    myBg.yRangeTop=Double.parseDouble(Attribute.getText().split(",")[1]);
                                }
                            }
                            MyElements.add(myBg);
                        }
                        else if(myElement.getName().equals("points")){
                            Points myPoints = new Points();
                            myPoints.elementName="points";
                            List<Element> myElementAttributeList = myElement.elements();
                            for (Element Attribute : myElementAttributeList) {//col,wid,pad,radius,list
                                if(Attribute.getName().equals("col")){
                                    if(Attribute.getText().contains(",")){
                                        float R=Float.parseFloat(Attribute.getText().split(",")[0]);
                                        float G=Float.parseFloat(Attribute.getText().split(",")[1]);
                                        float B=Float.parseFloat(Attribute.getText().split(",")[2]);
                                        int r= (int)R;
                                        int g= (int)G;
                                        int b= (int)B;
                                        myPoints.col= new Color(r,g,b);
                                    }
                                    else if(Attribute.getText().trim().equals(""))myPoints.col = Color.BLACK;
                                    else{
                                        Field field = Class.forName("java.awt.Color").getField(Attribute.getText().trim());
                                        myPoints.col = (Color)field.get(null);
                                        //System.out.println(myShape.col);
                                    }
                                }
                                else if(Attribute.getName().equals("wid")){
                                    myPoints.wid=Float.parseFloat(Attribute.getText());
                                }
                                else if(Attribute.getName().equals("pad")){
                                    myPoints.pad=Attribute.getText().trim();
                                }
                                else if(Attribute.getName().equals("radius")){
                                    myPoints.radius=Double.parseDouble(Attribute.getText());
                                }
                                else if(Attribute.getName().equals("list")){
                                    String s=Attribute.getText();
                                    BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(s.getBytes(Charset.forName("utf8"))), Charset.forName("utf8")));
                                    String line;
                                    while ( (line = br.readLine()) != null ) {
                                        if(!line.trim().equals("")){
                                            myPoints.x.add(Double.parseDouble(line.split(",")[0]));
                                            myPoints.y.add(Double.parseDouble(line.split(",")[1]));
                                        }
                                    }
                                }
                            }
                            MyElements.add(myPoints);
                        }
                        else if(myElement.getName().equals("lines")){
                            Lines myLines = new Lines();
                            myLines.elementName="lines";
                            List<Element> myElementAttributeList = myElement.elements();
                            for (Element Attribute : myElementAttributeList) {//col,wid,pad,radius,list
                                if(Attribute.getName().equals("col")){
                                    if(Attribute.getText().contains(",")){
                                        float R=Float.parseFloat(Attribute.getText().split(",")[0]);
                                        float G=Float.parseFloat(Attribute.getText().split(",")[1]);
                                        float B=Float.parseFloat(Attribute.getText().split(",")[2]);
                                        int r= (int)R;
                                        int g= (int)G;
                                        int b= (int)B;
                                        myLines.col= new Color(r,g,b);
                                    }
                                    else if(Attribute.getText().trim().equals(""))myLines.col = Color.BLACK;
                                    else{
                                        Field field = Class.forName("java.awt.Color").getField(Attribute.getText().trim());
                                        myLines.col = (Color)field.get(null);
                                        System.out.println(myLines.col);
                                    }
                                }
                                else if(Attribute.getName().equals("wid")){
                                    myLines.wid=Float.parseFloat(Attribute.getText());
                                }
                                else if(Attribute.getName().equals("list")){
                                    String s=Attribute.getText();
                                    BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(s.getBytes(Charset.forName("utf8"))), Charset.forName("utf8")));
                                    String line;
                                    while ( (line = br.readLine()) != null ) {
                                        if(!line.trim().equals("")){
                                            myLines.x.add(Double.parseDouble(line.split(",")[0]));
                                            myLines.y.add(Double.parseDouble(line.split(",")[1]));
                                        }
                                    }
                                }
                            }
                            MyElements.add(myLines);
                        }
                        else if(myElement.getName().equals("line")){
                            Line myLine = new Line();
                            myLine.elementName="line";
                            List<Element> myElementAttributeList = myElement.elements();
                            for (Element Attribute : myElementAttributeList) {//col,wid,point,slope
                                if(Attribute.getName().equals("col")){
                                    if(Attribute.getText().contains(",")){
                                        float R=Float.parseFloat(Attribute.getText().split(",")[0]);
                                        float G=Float.parseFloat(Attribute.getText().split(",")[1]);
                                        float B=Float.parseFloat(Attribute.getText().split(",")[2]);
                                        int r= (int)R;
                                        int g= (int)G;
                                        int b= (int)B;
                                        myLine.col= new Color(r,g,b);
                                    }
                                    else if(Attribute.getText().trim().equals(""))myLine.col = Color.BLACK;
                                    else{
                                        Field field = Class.forName("java.awt.Color").getField(Attribute.getText().trim());
                                        myLine.col = (Color)field.get(null);
                                        //System.out.println(myShape.col);
                                    }
                                }
                                else if(Attribute.getName().equals("wid")){
                                    myLine.wid=Float.parseFloat(Attribute.getText());
                                }
                                else if(Attribute.getName().equals("point")){
                                    myLine.x=Double.parseDouble(Attribute.getText().split(",")[0]);
                                    myLine.y=Double.parseDouble(Attribute.getText().split(",")[1]);
                                }
                                else if(Attribute.getName().equals("slope")){
                                    myLine.slope=Attribute.getText().trim();
                                }
                            }
                            MyElements.add(myLine);
                        }
                        else if(myElement.getName().equals("curve")){
                            Curve myCurve = new Curve();
                            myCurve.elementName="curve";
                            List<Element> myElementAttributeList = myElement.elements();
                            for (Element Attribute : myElementAttributeList) {//col,wid,point,slope
                                if(Attribute.getName().equals("col")){
                                    if(Attribute.getText().contains(",")){
                                        float R=Float.parseFloat(Attribute.getText().split(",")[0]);
                                        float G=Float.parseFloat(Attribute.getText().split(",")[1]);
                                        float B=Float.parseFloat(Attribute.getText().split(",")[2]);
                                        int r= (int)R;
                                        int g= (int)G;
                                        int b= (int)B;
                                        myCurve.col= new Color(r,g,b);
                                    }
                                    else if(Attribute.getText().trim().equals(""))myCurve.col = Color.BLACK;
                                    else{
                                        Field field = Class.forName("java.awt.Color").getField(Attribute.getText().trim());
                                        myCurve.col = (Color)field.get(null);
                                        //System.out.println(myShape.col);
                                    }
                                }
                                else if(Attribute.getName().equals("wid")){
                                    myCurve.wid=Float.parseFloat(Attribute.getText());
                                }
                                else if(Attribute.getName().equals("range")){
                                    myCurve.rangeLeft=Double.parseDouble(Attribute.getText().split(",")[0]);
                                    myCurve.rangeRight=Double.parseDouble(Attribute.getText().split(",")[1]);
                                }
                                else if(Attribute.getName().equals("function")){
                                    myCurve.function=Attribute.getText().trim();
                                }
                                else if(Attribute.getName().equals("amount")){
                                    myCurve.amount=Double.parseDouble(Attribute.getText());
                                }
                            }
                            MyElements.add(myCurve);
                        }
                        else if(myElement.getName().equals("shape")){
                            Shape myShape = new Shape();
                            myShape.elementName="shape";
                            List<Element> myElementAttributeList = myElement.elements();
                            for (Element Attribute : myElementAttributeList) {//col,wid,type,pad,center,width,height
                                if(Attribute.getName().equals("col")){
                                    if(Attribute.getText().contains(",")){
                                        float R=Float.parseFloat(Attribute.getText().split(",")[0]);
                                        float G=Float.parseFloat(Attribute.getText().split(",")[1]);
                                        float B=Float.parseFloat(Attribute.getText().split(",")[2]);
                                        int r= (int)R;
                                        int g= (int)G;
                                        int b= (int)B;
                                        myShape.col= new Color(r,g,b);
                                    }
                                    else if(Attribute.getText().trim().equals(""))myShape.col = Color.BLACK;
                                    else{
                                        Field field = Class.forName("java.awt.Color").getField(Attribute.getText().trim());
                                        myShape.col = (Color)field.get(null);
                                        //System.out.println(myShape.col);
                                    }
                                }
                                else if(Attribute.getName().equals("wid")){
                                    myShape.wid=Float.parseFloat(Attribute.getText());
                                }
                                else if(Attribute.getName().equals("type")){
                                    myShape.type=Attribute.getText().trim();
                                }
                                else if(Attribute.getName().equals("pad")){
                                    myShape.pad=Attribute.getText().trim();
                                }
                                else if(Attribute.getName().equals("center")){
                                    //myShape.center=Attribute.getText();
                                    myShape.x=Double.parseDouble(Attribute.getText().split(",")[0]);
                                    myShape.y=Double.parseDouble(Attribute.getText().split(",")[1]);
                                }
                                else if(Attribute.getName().equals("width")){
                                    myShape.width=Double.parseDouble(Attribute.getText());;
                                }
                                else if(Attribute.getName().equals("height")){
                                    myShape.height=Double.parseDouble(Attribute.getText());
                                }
                            }
                            MyElements.add(myShape);
                        }
                        else if(myElement.getName().equals("scale")){
                            Scale myScale = new Scale();
                            myScale.elementName="scale";
                            List<Element> myElementAttributeList = myElement.elements();
                            for (Element Attribute : myElementAttributeList) {//col,wid,direction,pos,from,step,amount,precision
                                if(Attribute.getName().equals("col")){
                                    if(Attribute.getText().contains(",")){
                                        float R=Float.parseFloat(Attribute.getText().split(",")[0]);
                                        float G=Float.parseFloat(Attribute.getText().split(",")[1]);
                                        float B=Float.parseFloat(Attribute.getText().split(",")[2]);
                                        int r= (int)R;
                                        int g= (int)G;
                                        int b= (int)B;
                                        myScale.col= new Color(r,g,b);
                                    }
                                    else if(Attribute.getText().trim().equals(""))myScale.col = Color.BLACK;
                                    else{
                                        Field field = Class.forName("java.awt.Color").getField(Attribute.getText().trim());
                                        myScale.col = (Color)field.get(null);
                                        //System.out.println(myShape.col);
                                    }
                                }
                                else if(Attribute.getName().equals("wid")){
                                    myScale.wid=Float.parseFloat(Attribute.getText());
                                }
                                else if(Attribute.getName().equals("direction")){
                                    myScale.direction=Attribute.getText().trim();
                                }
                                else if(Attribute.getName().equals("pos")){
                                    myScale.pos=Double.parseDouble(Attribute.getText());
                                }
                                else if(Attribute.getName().equals("from")){
                                    myScale.from=Double.parseDouble(Attribute.getText());
                                }
                                else if(Attribute.getName().equals("step")){
                                    myScale.step=Double.parseDouble(Attribute.getText());;
                                }
                                else if(Attribute.getName().equals("amount")){
                                    myScale.amount=Double.parseDouble(Attribute.getText());
                                }
                                else if(Attribute.getName().equals("precision")){
                                    myScale.precision=Double.parseDouble(Attribute.getText());
                                }
                            }
                            MyElements.add(myScale);
                        }
                    }
                    cv.repaint();
                } catch (DocumentException ex) {
                    ex.printStackTrace();
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
        new GCCDrawer();
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
        for(MyElement myElement: GCCDrawer.MyElements){
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
