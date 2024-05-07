// Generated from D:/CompilerPrincipleProjects/Graph-Config-Compiler-Project/Graph-Config-Compiler/src/main/java/com/ljl/gcc/antlr/GCCParser.g4 by ANTLR 4.13.1
package com.ljl.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GCCParser}.
 */
public interface GCCParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GCCParser#config}.
	 * @param ctx the parse tree
	 */
	void enterConfig(GCCParser.ConfigContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#config}.
	 * @param ctx the parse tree
	 */
	void exitConfig(GCCParser.ConfigContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(GCCParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(GCCParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#bg}.
	 * @param ctx the parse tree
	 */
	void enterBg(GCCParser.BgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#bg}.
	 * @param ctx the parse tree
	 */
	void exitBg(GCCParser.BgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#shape}.
	 * @param ctx the parse tree
	 */
	void enterShape(GCCParser.ShapeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#shape}.
	 * @param ctx the parse tree
	 */
	void exitShape(GCCParser.ShapeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#points}.
	 * @param ctx the parse tree
	 */
	void enterPoints(GCCParser.PointsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#points}.
	 * @param ctx the parse tree
	 */
	void exitPoints(GCCParser.PointsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(GCCParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(GCCParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#lines}.
	 * @param ctx the parse tree
	 */
	void enterLines(GCCParser.LinesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#lines}.
	 * @param ctx the parse tree
	 */
	void exitLines(GCCParser.LinesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#curve}.
	 * @param ctx the parse tree
	 */
	void enterCurve(GCCParser.CurveContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#curve}.
	 * @param ctx the parse tree
	 */
	void exitCurve(GCCParser.CurveContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#scale}.
	 * @param ctx the parse tree
	 */
	void enterScale(GCCParser.ScaleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#scale}.
	 * @param ctx the parse tree
	 */
	void exitScale(GCCParser.ScaleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#doublePair}.
	 * @param ctx the parse tree
	 */
	void enterDoublePair(GCCParser.DoublePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#doublePair}.
	 * @param ctx the parse tree
	 */
	void exitDoublePair(GCCParser.DoublePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#doublePairList}.
	 * @param ctx the parse tree
	 */
	void enterDoublePairList(GCCParser.DoublePairListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#doublePairList}.
	 * @param ctx the parse tree
	 */
	void exitDoublePairList(GCCParser.DoublePairListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#doubleTriplet}.
	 * @param ctx the parse tree
	 */
	void enterDoubleTriplet(GCCParser.DoubleTripletContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#doubleTriplet}.
	 * @param ctx the parse tree
	 */
	void exitDoubleTriplet(GCCParser.DoubleTripletContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#color_val}.
	 * @param ctx the parse tree
	 */
	void enterColor_val(GCCParser.Color_valContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#color_val}.
	 * @param ctx the parse tree
	 */
	void exitColor_val(GCCParser.Color_valContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#col}.
	 * @param ctx the parse tree
	 */
	void enterCol(GCCParser.ColContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#col}.
	 * @param ctx the parse tree
	 */
	void exitCol(GCCParser.ColContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#x_range}.
	 * @param ctx the parse tree
	 */
	void enterX_range(GCCParser.X_rangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#x_range}.
	 * @param ctx the parse tree
	 */
	void exitX_range(GCCParser.X_rangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#y_range}.
	 * @param ctx the parse tree
	 */
	void enterY_range(GCCParser.Y_rangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#y_range}.
	 * @param ctx the parse tree
	 */
	void exitY_range(GCCParser.Y_rangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#wid}.
	 * @param ctx the parse tree
	 */
	void enterWid(GCCParser.WidContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#wid}.
	 * @param ctx the parse tree
	 */
	void exitWid(GCCParser.WidContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#width}.
	 * @param ctx the parse tree
	 */
	void enterWidth(GCCParser.WidthContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#width}.
	 * @param ctx the parse tree
	 */
	void exitWidth(GCCParser.WidthContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#height}.
	 * @param ctx the parse tree
	 */
	void enterHeight(GCCParser.HeightContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#height}.
	 * @param ctx the parse tree
	 */
	void exitHeight(GCCParser.HeightContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#pad}.
	 * @param ctx the parse tree
	 */
	void enterPad(GCCParser.PadContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#pad}.
	 * @param ctx the parse tree
	 */
	void exitPad(GCCParser.PadContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#radius}.
	 * @param ctx the parse tree
	 */
	void enterRadius(GCCParser.RadiusContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#radius}.
	 * @param ctx the parse tree
	 */
	void exitRadius(GCCParser.RadiusContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(GCCParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(GCCParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#point}.
	 * @param ctx the parse tree
	 */
	void enterPoint(GCCParser.PointContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#point}.
	 * @param ctx the parse tree
	 */
	void exitPoint(GCCParser.PointContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#slope}.
	 * @param ctx the parse tree
	 */
	void enterSlope(GCCParser.SlopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#slope}.
	 * @param ctx the parse tree
	 */
	void exitSlope(GCCParser.SlopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(GCCParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(GCCParser.RangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#amount}.
	 * @param ctx the parse tree
	 */
	void enterAmount(GCCParser.AmountContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#amount}.
	 * @param ctx the parse tree
	 */
	void exitAmount(GCCParser.AmountContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#direction}.
	 * @param ctx the parse tree
	 */
	void enterDirection(GCCParser.DirectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#direction}.
	 * @param ctx the parse tree
	 */
	void exitDirection(GCCParser.DirectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#pos}.
	 * @param ctx the parse tree
	 */
	void enterPos(GCCParser.PosContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#pos}.
	 * @param ctx the parse tree
	 */
	void exitPos(GCCParser.PosContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#from}.
	 * @param ctx the parse tree
	 */
	void enterFrom(GCCParser.FromContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#from}.
	 * @param ctx the parse tree
	 */
	void exitFrom(GCCParser.FromContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#step}.
	 * @param ctx the parse tree
	 */
	void enterStep(GCCParser.StepContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#step}.
	 * @param ctx the parse tree
	 */
	void exitStep(GCCParser.StepContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#precision}.
	 * @param ctx the parse tree
	 */
	void enterPrecision(GCCParser.PrecisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#precision}.
	 * @param ctx the parse tree
	 */
	void exitPrecision(GCCParser.PrecisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GCCParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GCCParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCCParser#center}.
	 * @param ctx the parse tree
	 */
	void enterCenter(GCCParser.CenterContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCCParser#center}.
	 * @param ctx the parse tree
	 */
	void exitCenter(GCCParser.CenterContext ctx);
}
