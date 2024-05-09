// Generated from D:/CompilerPrincipleProjects/Graph-Config-Compiler-Project/Graph-Config-Compiler/src/main/java/com/ljl/antlr/GCParser.g4 by ANTLR 4.13.1
package com.ljl.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GCParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GCParser#config}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConfig(GCParser.ConfigContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(GCParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#bg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBg(GCParser.BgContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#shape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShape(GCParser.ShapeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#points}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoints(GCParser.PointsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(GCParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#lines}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLines(GCParser.LinesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#curve}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurve(GCParser.CurveContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#scale}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScale(GCParser.ScaleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#col}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCol(GCParser.ColContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#x_range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX_range(GCParser.X_rangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#y_range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitY_range(GCParser.Y_rangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#wid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWid(GCParser.WidContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#width}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWidth(GCParser.WidthContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#height}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeight(GCParser.HeightContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#pad}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPad(GCParser.PadContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#radius}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRadius(GCParser.RadiusContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(GCParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#point}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoint(GCParser.PointContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#slope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlope(GCParser.SlopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(GCParser.RangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#amount}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAmount(GCParser.AmountContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#direction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirection(GCParser.DirectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#pos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPos(GCParser.PosContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#from}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrom(GCParser.FromContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#step}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStep(GCParser.StepContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#precision}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecision(GCParser.PrecisionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(GCParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#center}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCenter(GCParser.CenterContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(GCParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#number_pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber_pair(GCParser.Number_pairContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#number_pair_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber_pair_list(GCParser.Number_pair_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#number_triplet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber_triplet(GCParser.Number_tripletContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCParser#color_val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColor_val(GCParser.Color_valContext ctx);
}