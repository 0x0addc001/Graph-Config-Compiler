// Generated from D:/CompilerPrincipleProjects/Graph-Config-Compiler-Project/Graph-Config-Compiler/src/main/java/com/ljl/gcc/antlr/GCCParser.g4 by ANTLR 4.13.1
package com.ljl.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GCCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GCCParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GCCParser#config}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConfig(GCCParser.ConfigContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(GCCParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#bg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBg(GCCParser.BgContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#shape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShape(GCCParser.ShapeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#points}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoints(GCCParser.PointsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(GCCParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#lines}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLines(GCCParser.LinesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#curve}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurve(GCCParser.CurveContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#scale}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScale(GCCParser.ScaleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#doublePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoublePair(GCCParser.DoublePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#doublePairList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoublePairList(GCCParser.DoublePairListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#doubleTriplet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleTriplet(GCCParser.DoubleTripletContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#color_val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColor_val(GCCParser.Color_valContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#col}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCol(GCCParser.ColContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#x_range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX_range(GCCParser.X_rangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#y_range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitY_range(GCCParser.Y_rangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#wid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWid(GCCParser.WidContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#width}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWidth(GCCParser.WidthContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#height}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeight(GCCParser.HeightContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#pad}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPad(GCCParser.PadContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#radius}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRadius(GCCParser.RadiusContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(GCCParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#point}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoint(GCCParser.PointContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#slope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlope(GCCParser.SlopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(GCCParser.RangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#amount}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAmount(GCCParser.AmountContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#direction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirection(GCCParser.DirectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#pos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPos(GCCParser.PosContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#from}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrom(GCCParser.FromContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#step}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStep(GCCParser.StepContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#precision}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecision(GCCParser.PrecisionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(GCCParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCCParser#center}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCenter(GCCParser.CenterContext ctx);
}
