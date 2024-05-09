// Generated from D:/CompilerPrincipleProjects/Graph-Config-Compiler-Project/Graph-Config-Compiler/src/main/java/com/ljl/antlr/GCParser.g4 by ANTLR 4.13.1
package com.ljl.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
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
	public static final int
		RULE_config = 0, RULE_element = 1, RULE_bg = 2, RULE_shape = 3, RULE_points = 4, 
		RULE_line = 5, RULE_lines = 6, RULE_curve = 7, RULE_scale = 8, RULE_col = 9, 
		RULE_x_range = 10, RULE_y_range = 11, RULE_wid = 12, RULE_width = 13, 
		RULE_height = 14, RULE_pad = 15, RULE_radius = 16, RULE_list = 17, RULE_point = 18, 
		RULE_slope = 19, RULE_range = 20, RULE_amount = 21, RULE_direction = 22, 
		RULE_pos = 23, RULE_from = 24, RULE_step = 25, RULE_precision = 26, RULE_type = 27, 
		RULE_center = 28, RULE_function = 29, RULE_number_pair = 30, RULE_number_pair_list = 31, 
		RULE_number_triplet = 32, RULE_color_val = 33;
	private static String[] makeRuleNames() {
		return new String[] {
			"config", "element", "bg", "shape", "points", "line", "lines", "curve", 
			"scale", "col", "x_range", "y_range", "wid", "width", "height", "pad", 
			"radius", "list", "point", "slope", "range", "amount", "direction", "pos", 
			"from", "step", "precision", "type", "center", "function", "number_pair", 
			"number_pair_list", "number_triplet", "color_val"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'<config>'", "'</config>'", "'<bg>'", "'</bg>'", "'<col>'", 
			"'</col>'", "'<xRange>'", "'</xRange>'", "'<yRange>'", "'</yRange>'", 
			"'<shape>'", "'</shape>'", "'<points>'", "'</points>'", "'<line>'", "'</line>'", 
			"'<lines>'", "'</lines>'", "'<curve>'", "'</curve>'", "'<scale>'", "'</scale>'", 
			"'<pad>'", "'</pad>'", "'<center>'", "'</center>'", "'<wid>'", "'</wid>'", 
			"'<width>'", "'</width>'", "'<height>'", "'</height>'", "'<list>'", "'</list>'", 
			"'<point>'", "'</point>'", "'<slope>'", "'</slope>'", "'<radius>'", "'</radius>'", 
			"'<range>'", "'</range>'", "'<amount>'", "'</amount>'", "'<function>'", 
			"'</function>'", "'<direction>'", "'</direction>'", "'<pos>'", "'</pos>'", 
			"'<from>'", "'</from>'", "'<step>'", "'</step>'", "'<precision>'", "'</precision>'", 
			"'<type>'", "'</type>'", null, "'inf'", "'<!--'", "'-->'", null, "','", 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
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
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "GCParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConfigContext extends ParserRuleContext {
		public TerminalNode CONFIG_START() { return getToken(GCParser.CONFIG_START, 0); }
		public TerminalNode CONFIG_END() { return getToken(GCParser.CONFIG_END, 0); }
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public ConfigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_config; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterConfig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitConfig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitConfig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConfigContext config() throws RecognitionException {
		ConfigContext _localctx = new ConfigContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_config);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(CONFIG_START);
			{
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 11182112L) != 0)) {
				{
				{
				setState(69);
				element();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(75);
			match(CONFIG_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElementContext extends ParserRuleContext {
		public BgContext bg() {
			return getRuleContext(BgContext.class,0);
		}
		public ShapeContext shape() {
			return getRuleContext(ShapeContext.class,0);
		}
		public PointsContext points() {
			return getRuleContext(PointsContext.class,0);
		}
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public LinesContext lines() {
			return getRuleContext(LinesContext.class,0);
		}
		public CurveContext curve() {
			return getRuleContext(CurveContext.class,0);
		}
		public ScaleContext scale() {
			return getRuleContext(ScaleContext.class,0);
		}
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_element);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BG_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				bg();
				}
				break;
			case SHAPE_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				shape();
				}
				break;
			case POINTS_START:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				points();
				}
				break;
			case LINE_START:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				line();
				}
				break;
			case LINES_START:
				enterOuterAlt(_localctx, 5);
				{
				setState(81);
				lines();
				}
				break;
			case CURVE_START:
				enterOuterAlt(_localctx, 6);
				{
				setState(82);
				curve();
				}
				break;
			case SCALE_START:
				enterOuterAlt(_localctx, 7);
				{
				setState(83);
				scale();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BgContext extends ParserRuleContext {
		public TerminalNode BG_START() { return getToken(GCParser.BG_START, 0); }
		public ColContext col() {
			return getRuleContext(ColContext.class,0);
		}
		public X_rangeContext x_range() {
			return getRuleContext(X_rangeContext.class,0);
		}
		public Y_rangeContext y_range() {
			return getRuleContext(Y_rangeContext.class,0);
		}
		public TerminalNode BG_END() { return getToken(GCParser.BG_END, 0); }
		public BgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterBg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitBg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitBg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BgContext bg() throws RecognitionException {
		BgContext _localctx = new BgContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(BG_START);
			setState(87);
			col();
			setState(88);
			x_range();
			setState(89);
			y_range();
			setState(90);
			match(BG_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ShapeContext extends ParserRuleContext {
		public TerminalNode SHAPE_START() { return getToken(GCParser.SHAPE_START, 0); }
		public ColContext col() {
			return getRuleContext(ColContext.class,0);
		}
		public WidContext wid() {
			return getRuleContext(WidContext.class,0);
		}
		public PadContext pad() {
			return getRuleContext(PadContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public CenterContext center() {
			return getRuleContext(CenterContext.class,0);
		}
		public WidthContext width() {
			return getRuleContext(WidthContext.class,0);
		}
		public HeightContext height() {
			return getRuleContext(HeightContext.class,0);
		}
		public TerminalNode SHAPE_END() { return getToken(GCParser.SHAPE_END, 0); }
		public ShapeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterShape(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitShape(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitShape(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShapeContext shape() throws RecognitionException {
		ShapeContext _localctx = new ShapeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_shape);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(SHAPE_START);
			setState(93);
			col();
			setState(94);
			wid();
			setState(95);
			pad();
			setState(96);
			type();
			setState(97);
			center();
			setState(98);
			width();
			setState(99);
			height();
			setState(100);
			match(SHAPE_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PointsContext extends ParserRuleContext {
		public TerminalNode POINTS_START() { return getToken(GCParser.POINTS_START, 0); }
		public ColContext col() {
			return getRuleContext(ColContext.class,0);
		}
		public WidContext wid() {
			return getRuleContext(WidContext.class,0);
		}
		public PadContext pad() {
			return getRuleContext(PadContext.class,0);
		}
		public RadiusContext radius() {
			return getRuleContext(RadiusContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode POINTS_END() { return getToken(GCParser.POINTS_END, 0); }
		public PointsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_points; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterPoints(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitPoints(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitPoints(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointsContext points() throws RecognitionException {
		PointsContext _localctx = new PointsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_points);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(POINTS_START);
			setState(103);
			col();
			setState(104);
			wid();
			setState(105);
			pad();
			setState(106);
			radius();
			setState(107);
			list();
			setState(108);
			match(POINTS_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LineContext extends ParserRuleContext {
		public TerminalNode LINE_START() { return getToken(GCParser.LINE_START, 0); }
		public ColContext col() {
			return getRuleContext(ColContext.class,0);
		}
		public WidContext wid() {
			return getRuleContext(WidContext.class,0);
		}
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public SlopeContext slope() {
			return getRuleContext(SlopeContext.class,0);
		}
		public TerminalNode LINE_END() { return getToken(GCParser.LINE_END, 0); }
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(LINE_START);
			setState(111);
			col();
			setState(112);
			wid();
			setState(113);
			point();
			setState(114);
			slope();
			setState(115);
			match(LINE_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LinesContext extends ParserRuleContext {
		public TerminalNode LINES_START() { return getToken(GCParser.LINES_START, 0); }
		public ColContext col() {
			return getRuleContext(ColContext.class,0);
		}
		public WidContext wid() {
			return getRuleContext(WidContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode LINES_END() { return getToken(GCParser.LINES_END, 0); }
		public LinesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lines; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterLines(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitLines(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitLines(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinesContext lines() throws RecognitionException {
		LinesContext _localctx = new LinesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_lines);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(LINES_START);
			setState(118);
			col();
			setState(119);
			wid();
			setState(120);
			list();
			setState(121);
			match(LINES_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CurveContext extends ParserRuleContext {
		public TerminalNode CURVE_START() { return getToken(GCParser.CURVE_START, 0); }
		public ColContext col() {
			return getRuleContext(ColContext.class,0);
		}
		public WidContext wid() {
			return getRuleContext(WidContext.class,0);
		}
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public AmountContext amount() {
			return getRuleContext(AmountContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TerminalNode CURVE_END() { return getToken(GCParser.CURVE_END, 0); }
		public CurveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_curve; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterCurve(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitCurve(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitCurve(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CurveContext curve() throws RecognitionException {
		CurveContext _localctx = new CurveContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_curve);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(CURVE_START);
			setState(124);
			col();
			setState(125);
			wid();
			setState(126);
			range();
			setState(127);
			amount();
			setState(128);
			function();
			setState(129);
			match(CURVE_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ScaleContext extends ParserRuleContext {
		public TerminalNode SCALE_START() { return getToken(GCParser.SCALE_START, 0); }
		public ColContext col() {
			return getRuleContext(ColContext.class,0);
		}
		public WidContext wid() {
			return getRuleContext(WidContext.class,0);
		}
		public DirectionContext direction() {
			return getRuleContext(DirectionContext.class,0);
		}
		public PosContext pos() {
			return getRuleContext(PosContext.class,0);
		}
		public FromContext from() {
			return getRuleContext(FromContext.class,0);
		}
		public StepContext step() {
			return getRuleContext(StepContext.class,0);
		}
		public AmountContext amount() {
			return getRuleContext(AmountContext.class,0);
		}
		public PrecisionContext precision() {
			return getRuleContext(PrecisionContext.class,0);
		}
		public TerminalNode SCALE_END() { return getToken(GCParser.SCALE_END, 0); }
		public ScaleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scale; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterScale(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitScale(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitScale(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScaleContext scale() throws RecognitionException {
		ScaleContext _localctx = new ScaleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_scale);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(SCALE_START);
			setState(132);
			col();
			setState(133);
			wid();
			setState(134);
			direction();
			setState(135);
			pos();
			setState(136);
			from();
			setState(137);
			step();
			setState(138);
			amount();
			setState(139);
			precision();
			setState(140);
			match(SCALE_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColContext extends ParserRuleContext {
		public TerminalNode COL_START() { return getToken(GCParser.COL_START, 0); }
		public TerminalNode COL_END() { return getToken(GCParser.COL_END, 0); }
		public Color_valContext color_val() {
			return getRuleContext(Color_valContext.class,0);
		}
		public ColContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_col; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterCol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitCol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitCol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColContext col() throws RecognitionException {
		ColContext _localctx = new ColContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_col);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(COL_START);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMBER || _la==COLOR_TYPE) {
				{
				setState(143);
				color_val();
				}
			}

			setState(146);
			match(COL_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class X_rangeContext extends ParserRuleContext {
		public TerminalNode X_RANGE_START() { return getToken(GCParser.X_RANGE_START, 0); }
		public Number_pairContext number_pair() {
			return getRuleContext(Number_pairContext.class,0);
		}
		public TerminalNode X_RANGE_END() { return getToken(GCParser.X_RANGE_END, 0); }
		public X_rangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_x_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterX_range(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitX_range(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitX_range(this);
			else return visitor.visitChildren(this);
		}
	}

	public final X_rangeContext x_range() throws RecognitionException {
		X_rangeContext _localctx = new X_rangeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_x_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(X_RANGE_START);
			setState(149);
			number_pair();
			setState(150);
			match(X_RANGE_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Y_rangeContext extends ParserRuleContext {
		public TerminalNode Y_RANGE_START() { return getToken(GCParser.Y_RANGE_START, 0); }
		public Number_pairContext number_pair() {
			return getRuleContext(Number_pairContext.class,0);
		}
		public TerminalNode Y_RANGE_END() { return getToken(GCParser.Y_RANGE_END, 0); }
		public Y_rangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_y_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterY_range(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitY_range(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitY_range(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Y_rangeContext y_range() throws RecognitionException {
		Y_rangeContext _localctx = new Y_rangeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_y_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(Y_RANGE_START);
			setState(153);
			number_pair();
			setState(154);
			match(Y_RANGE_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WidContext extends ParserRuleContext {
		public TerminalNode WID_START() { return getToken(GCParser.WID_START, 0); }
		public TerminalNode NUMBER() { return getToken(GCParser.NUMBER, 0); }
		public TerminalNode WID_END() { return getToken(GCParser.WID_END, 0); }
		public WidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterWid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitWid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitWid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WidContext wid() throws RecognitionException {
		WidContext _localctx = new WidContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_wid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(WID_START);
			setState(157);
			match(NUMBER);
			setState(158);
			match(WID_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WidthContext extends ParserRuleContext {
		public TerminalNode WIDTH_START() { return getToken(GCParser.WIDTH_START, 0); }
		public TerminalNode NUMBER() { return getToken(GCParser.NUMBER, 0); }
		public TerminalNode WIDTH_END() { return getToken(GCParser.WIDTH_END, 0); }
		public WidthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_width; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterWidth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitWidth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitWidth(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WidthContext width() throws RecognitionException {
		WidthContext _localctx = new WidthContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_width);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(WIDTH_START);
			setState(161);
			match(NUMBER);
			setState(162);
			match(WIDTH_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HeightContext extends ParserRuleContext {
		public TerminalNode HEIGHT_START() { return getToken(GCParser.HEIGHT_START, 0); }
		public TerminalNode NUMBER() { return getToken(GCParser.NUMBER, 0); }
		public TerminalNode HEIGHT_END() { return getToken(GCParser.HEIGHT_END, 0); }
		public HeightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_height; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterHeight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitHeight(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitHeight(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeightContext height() throws RecognitionException {
		HeightContext _localctx = new HeightContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_height);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(HEIGHT_START);
			setState(165);
			match(NUMBER);
			setState(166);
			match(HEIGHT_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PadContext extends ParserRuleContext {
		public TerminalNode PAD_START() { return getToken(GCParser.PAD_START, 0); }
		public TerminalNode BOOLEAN() { return getToken(GCParser.BOOLEAN, 0); }
		public TerminalNode PAD_END() { return getToken(GCParser.PAD_END, 0); }
		public PadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pad; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterPad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitPad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitPad(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PadContext pad() throws RecognitionException {
		PadContext _localctx = new PadContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_pad);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(PAD_START);
			setState(169);
			match(BOOLEAN);
			setState(170);
			match(PAD_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RadiusContext extends ParserRuleContext {
		public TerminalNode RADIUS_START() { return getToken(GCParser.RADIUS_START, 0); }
		public TerminalNode NUMBER() { return getToken(GCParser.NUMBER, 0); }
		public TerminalNode RADIUS_END() { return getToken(GCParser.RADIUS_END, 0); }
		public RadiusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_radius; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterRadius(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitRadius(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitRadius(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RadiusContext radius() throws RecognitionException {
		RadiusContext _localctx = new RadiusContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_radius);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(RADIUS_START);
			setState(173);
			match(NUMBER);
			setState(174);
			match(RADIUS_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListContext extends ParserRuleContext {
		public TerminalNode LIST_START() { return getToken(GCParser.LIST_START, 0); }
		public Number_pair_listContext number_pair_list() {
			return getRuleContext(Number_pair_listContext.class,0);
		}
		public TerminalNode LIST_END() { return getToken(GCParser.LIST_END, 0); }
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(LIST_START);
			setState(177);
			number_pair_list();
			setState(178);
			match(LIST_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PointContext extends ParserRuleContext {
		public TerminalNode POINT_START() { return getToken(GCParser.POINT_START, 0); }
		public Number_pairContext number_pair() {
			return getRuleContext(Number_pairContext.class,0);
		}
		public TerminalNode POINT_END() { return getToken(GCParser.POINT_END, 0); }
		public PointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_point; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterPoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitPoint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitPoint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointContext point() throws RecognitionException {
		PointContext _localctx = new PointContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_point);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(POINT_START);
			setState(181);
			number_pair();
			setState(182);
			match(POINT_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SlopeContext extends ParserRuleContext {
		public TerminalNode SLOPE_START() { return getToken(GCParser.SLOPE_START, 0); }
		public TerminalNode SLOPE_END() { return getToken(GCParser.SLOPE_END, 0); }
		public TerminalNode INF() { return getToken(GCParser.INF, 0); }
		public TerminalNode NUMBER() { return getToken(GCParser.NUMBER, 0); }
		public SlopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterSlope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitSlope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitSlope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlopeContext slope() throws RecognitionException {
		SlopeContext _localctx = new SlopeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_slope);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(SLOPE_START);
			setState(185);
			_la = _input.LA(1);
			if ( !(_la==INF || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(186);
			match(SLOPE_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RangeContext extends ParserRuleContext {
		public TerminalNode RANGE_START() { return getToken(GCParser.RANGE_START, 0); }
		public Number_pairContext number_pair() {
			return getRuleContext(Number_pairContext.class,0);
		}
		public TerminalNode RANGE_END() { return getToken(GCParser.RANGE_END, 0); }
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(RANGE_START);
			setState(189);
			number_pair();
			setState(190);
			match(RANGE_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AmountContext extends ParserRuleContext {
		public TerminalNode AMOUNT_START() { return getToken(GCParser.AMOUNT_START, 0); }
		public TerminalNode NUMBER() { return getToken(GCParser.NUMBER, 0); }
		public TerminalNode AMOUNT_END() { return getToken(GCParser.AMOUNT_END, 0); }
		public AmountContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_amount; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterAmount(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitAmount(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitAmount(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AmountContext amount() throws RecognitionException {
		AmountContext _localctx = new AmountContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_amount);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(AMOUNT_START);
			setState(193);
			match(NUMBER);
			setState(194);
			match(AMOUNT_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DirectionContext extends ParserRuleContext {
		public TerminalNode DIRECTION_START() { return getToken(GCParser.DIRECTION_START, 0); }
		public TerminalNode DIRECTION_TYPE() { return getToken(GCParser.DIRECTION_TYPE, 0); }
		public TerminalNode DIRECTION_END() { return getToken(GCParser.DIRECTION_END, 0); }
		public DirectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_direction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterDirection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitDirection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitDirection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectionContext direction() throws RecognitionException {
		DirectionContext _localctx = new DirectionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_direction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(DIRECTION_START);
			setState(197);
			match(DIRECTION_TYPE);
			setState(198);
			match(DIRECTION_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PosContext extends ParserRuleContext {
		public TerminalNode POS_START() { return getToken(GCParser.POS_START, 0); }
		public TerminalNode NUMBER() { return getToken(GCParser.NUMBER, 0); }
		public TerminalNode POS_END() { return getToken(GCParser.POS_END, 0); }
		public PosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterPos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitPos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitPos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PosContext pos() throws RecognitionException {
		PosContext _localctx = new PosContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_pos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(POS_START);
			setState(201);
			match(NUMBER);
			setState(202);
			match(POS_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FromContext extends ParserRuleContext {
		public TerminalNode FROM_START() { return getToken(GCParser.FROM_START, 0); }
		public TerminalNode NUMBER() { return getToken(GCParser.NUMBER, 0); }
		public TerminalNode FROM_END() { return getToken(GCParser.FROM_END, 0); }
		public FromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitFrom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitFrom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromContext from() throws RecognitionException {
		FromContext _localctx = new FromContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_from);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(FROM_START);
			setState(205);
			match(NUMBER);
			setState(206);
			match(FROM_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StepContext extends ParserRuleContext {
		public TerminalNode STEP_START() { return getToken(GCParser.STEP_START, 0); }
		public TerminalNode NUMBER() { return getToken(GCParser.NUMBER, 0); }
		public TerminalNode STEP_END() { return getToken(GCParser.STEP_END, 0); }
		public StepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_step; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitStep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitStep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StepContext step() throws RecognitionException {
		StepContext _localctx = new StepContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_step);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(STEP_START);
			setState(209);
			match(NUMBER);
			setState(210);
			match(STEP_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrecisionContext extends ParserRuleContext {
		public TerminalNode PRECISION_START() { return getToken(GCParser.PRECISION_START, 0); }
		public TerminalNode NUMBER() { return getToken(GCParser.NUMBER, 0); }
		public TerminalNode PRECISION_END() { return getToken(GCParser.PRECISION_END, 0); }
		public PrecisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precision; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterPrecision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitPrecision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitPrecision(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrecisionContext precision() throws RecognitionException {
		PrecisionContext _localctx = new PrecisionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_precision);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(PRECISION_START);
			setState(213);
			match(NUMBER);
			setState(214);
			match(PRECISION_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode TYPE_START() { return getToken(GCParser.TYPE_START, 0); }
		public TerminalNode SHAPE_TYPE() { return getToken(GCParser.SHAPE_TYPE, 0); }
		public TerminalNode TYPE_END() { return getToken(GCParser.TYPE_END, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(TYPE_START);
			setState(217);
			match(SHAPE_TYPE);
			setState(218);
			match(TYPE_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CenterContext extends ParserRuleContext {
		public TerminalNode CENTER_START() { return getToken(GCParser.CENTER_START, 0); }
		public Number_pairContext number_pair() {
			return getRuleContext(Number_pairContext.class,0);
		}
		public TerminalNode CENTER_END() { return getToken(GCParser.CENTER_END, 0); }
		public CenterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_center; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterCenter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitCenter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitCenter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CenterContext center() throws RecognitionException {
		CenterContext _localctx = new CenterContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_center);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(CENTER_START);
			setState(221);
			number_pair();
			setState(222);
			match(CENTER_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode FUNCTION_START() { return getToken(GCParser.FUNCTION_START, 0); }
		public TerminalNode FUNCTION_EXPR() { return getToken(GCParser.FUNCTION_EXPR, 0); }
		public TerminalNode FUNCTION_END() { return getToken(GCParser.FUNCTION_END, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(FUNCTION_START);
			setState(225);
			match(FUNCTION_EXPR);
			setState(226);
			match(FUNCTION_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Number_pairContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(GCParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(GCParser.NUMBER, i);
		}
		public TerminalNode COMMA() { return getToken(GCParser.COMMA, 0); }
		public TerminalNode SEMICOLON() { return getToken(GCParser.SEMICOLON, 0); }
		public Number_pairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterNumber_pair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitNumber_pair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitNumber_pair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Number_pairContext number_pair() throws RecognitionException {
		Number_pairContext _localctx = new Number_pairContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_number_pair);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(NUMBER);
			setState(229);
			match(COMMA);
			setState(230);
			match(NUMBER);
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(231);
				match(SEMICOLON);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Number_pair_listContext extends ParserRuleContext {
		public List<Number_pairContext> number_pair() {
			return getRuleContexts(Number_pairContext.class);
		}
		public Number_pairContext number_pair(int i) {
			return getRuleContext(Number_pairContext.class,i);
		}
		public Number_pair_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number_pair_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterNumber_pair_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitNumber_pair_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitNumber_pair_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Number_pair_listContext number_pair_list() throws RecognitionException {
		Number_pair_listContext _localctx = new Number_pair_listContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_number_pair_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(234);
				number_pair();
				}
				}
				setState(237); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Number_tripletContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(GCParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(GCParser.NUMBER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GCParser.COMMA, i);
		}
		public Number_tripletContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number_triplet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterNumber_triplet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitNumber_triplet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitNumber_triplet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Number_tripletContext number_triplet() throws RecognitionException {
		Number_tripletContext _localctx = new Number_tripletContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_number_triplet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(NUMBER);
			setState(240);
			match(COMMA);
			setState(241);
			match(NUMBER);
			setState(242);
			match(COMMA);
			setState(243);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Color_valContext extends ParserRuleContext {
		public TerminalNode COLOR_TYPE() { return getToken(GCParser.COLOR_TYPE, 0); }
		public Number_tripletContext number_triplet() {
			return getRuleContext(Number_tripletContext.class,0);
		}
		public Color_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_color_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).enterColor_val(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCParserListener ) ((GCParserListener)listener).exitColor_val(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCParserVisitor ) return ((GCParserVisitor<? extends T>)visitor).visitColor_val(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Color_valContext color_val() throws RecognitionException {
		Color_valContext _localctx = new Color_valContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_color_val);
		try {
			setState(247);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COLOR_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				match(COLOR_TYPE);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
				number_triplet();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001G\u00fa\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0001\u0000\u0001"+
		"\u0000\u0005\u0000G\b\u0000\n\u0000\f\u0000J\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001U\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\t\u0091\b\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0003\u001e\u00e9\b\u001e\u0001\u001f\u0004\u001f"+
		"\u00ec\b\u001f\u000b\u001f\f\u001f\u00ed\u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001!\u0001!\u0003!\u00f8\b!\u0001!\u0000\u0000\"\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@B\u0000\u0001\u0002\u0000>>AA\u00e2\u0000D\u0001\u0000"+
		"\u0000\u0000\u0002T\u0001\u0000\u0000\u0000\u0004V\u0001\u0000\u0000\u0000"+
		"\u0006\\\u0001\u0000\u0000\u0000\bf\u0001\u0000\u0000\u0000\nn\u0001\u0000"+
		"\u0000\u0000\fu\u0001\u0000\u0000\u0000\u000e{\u0001\u0000\u0000\u0000"+
		"\u0010\u0083\u0001\u0000\u0000\u0000\u0012\u008e\u0001\u0000\u0000\u0000"+
		"\u0014\u0094\u0001\u0000\u0000\u0000\u0016\u0098\u0001\u0000\u0000\u0000"+
		"\u0018\u009c\u0001\u0000\u0000\u0000\u001a\u00a0\u0001\u0000\u0000\u0000"+
		"\u001c\u00a4\u0001\u0000\u0000\u0000\u001e\u00a8\u0001\u0000\u0000\u0000"+
		" \u00ac\u0001\u0000\u0000\u0000\"\u00b0\u0001\u0000\u0000\u0000$\u00b4"+
		"\u0001\u0000\u0000\u0000&\u00b8\u0001\u0000\u0000\u0000(\u00bc\u0001\u0000"+
		"\u0000\u0000*\u00c0\u0001\u0000\u0000\u0000,\u00c4\u0001\u0000\u0000\u0000"+
		".\u00c8\u0001\u0000\u0000\u00000\u00cc\u0001\u0000\u0000\u00002\u00d0"+
		"\u0001\u0000\u0000\u00004\u00d4\u0001\u0000\u0000\u00006\u00d8\u0001\u0000"+
		"\u0000\u00008\u00dc\u0001\u0000\u0000\u0000:\u00e0\u0001\u0000\u0000\u0000"+
		"<\u00e4\u0001\u0000\u0000\u0000>\u00eb\u0001\u0000\u0000\u0000@\u00ef"+
		"\u0001\u0000\u0000\u0000B\u00f7\u0001\u0000\u0000\u0000DH\u0005\u0003"+
		"\u0000\u0000EG\u0003\u0002\u0001\u0000FE\u0001\u0000\u0000\u0000GJ\u0001"+
		"\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000"+
		"IK\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000KL\u0005\u0004\u0000"+
		"\u0000L\u0001\u0001\u0000\u0000\u0000MU\u0003\u0004\u0002\u0000NU\u0003"+
		"\u0006\u0003\u0000OU\u0003\b\u0004\u0000PU\u0003\n\u0005\u0000QU\u0003"+
		"\f\u0006\u0000RU\u0003\u000e\u0007\u0000SU\u0003\u0010\b\u0000TM\u0001"+
		"\u0000\u0000\u0000TN\u0001\u0000\u0000\u0000TO\u0001\u0000\u0000\u0000"+
		"TP\u0001\u0000\u0000\u0000TQ\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000"+
		"\u0000TS\u0001\u0000\u0000\u0000U\u0003\u0001\u0000\u0000\u0000VW\u0005"+
		"\u0005\u0000\u0000WX\u0003\u0012\t\u0000XY\u0003\u0014\n\u0000YZ\u0003"+
		"\u0016\u000b\u0000Z[\u0005\u0006\u0000\u0000[\u0005\u0001\u0000\u0000"+
		"\u0000\\]\u0005\r\u0000\u0000]^\u0003\u0012\t\u0000^_\u0003\u0018\f\u0000"+
		"_`\u0003\u001e\u000f\u0000`a\u00036\u001b\u0000ab\u00038\u001c\u0000b"+
		"c\u0003\u001a\r\u0000cd\u0003\u001c\u000e\u0000de\u0005\u000e\u0000\u0000"+
		"e\u0007\u0001\u0000\u0000\u0000fg\u0005\u000f\u0000\u0000gh\u0003\u0012"+
		"\t\u0000hi\u0003\u0018\f\u0000ij\u0003\u001e\u000f\u0000jk\u0003 \u0010"+
		"\u0000kl\u0003\"\u0011\u0000lm\u0005\u0010\u0000\u0000m\t\u0001\u0000"+
		"\u0000\u0000no\u0005\u0011\u0000\u0000op\u0003\u0012\t\u0000pq\u0003\u0018"+
		"\f\u0000qr\u0003$\u0012\u0000rs\u0003&\u0013\u0000st\u0005\u0012\u0000"+
		"\u0000t\u000b\u0001\u0000\u0000\u0000uv\u0005\u0013\u0000\u0000vw\u0003"+
		"\u0012\t\u0000wx\u0003\u0018\f\u0000xy\u0003\"\u0011\u0000yz\u0005\u0014"+
		"\u0000\u0000z\r\u0001\u0000\u0000\u0000{|\u0005\u0015\u0000\u0000|}\u0003"+
		"\u0012\t\u0000}~\u0003\u0018\f\u0000~\u007f\u0003(\u0014\u0000\u007f\u0080"+
		"\u0003*\u0015\u0000\u0080\u0081\u0003:\u001d\u0000\u0081\u0082\u0005\u0016"+
		"\u0000\u0000\u0082\u000f\u0001\u0000\u0000\u0000\u0083\u0084\u0005\u0017"+
		"\u0000\u0000\u0084\u0085\u0003\u0012\t\u0000\u0085\u0086\u0003\u0018\f"+
		"\u0000\u0086\u0087\u0003,\u0016\u0000\u0087\u0088\u0003.\u0017\u0000\u0088"+
		"\u0089\u00030\u0018\u0000\u0089\u008a\u00032\u0019\u0000\u008a\u008b\u0003"+
		"*\u0015\u0000\u008b\u008c\u00034\u001a\u0000\u008c\u008d\u0005\u0018\u0000"+
		"\u0000\u008d\u0011\u0001\u0000\u0000\u0000\u008e\u0090\u0005\u0007\u0000"+
		"\u0000\u008f\u0091\u0003B!\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0090"+
		"\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0005\b\u0000\u0000\u0093\u0013\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0005\t\u0000\u0000\u0095\u0096\u0003<\u001e\u0000\u0096\u0097\u0005"+
		"\n\u0000\u0000\u0097\u0015\u0001\u0000\u0000\u0000\u0098\u0099\u0005\u000b"+
		"\u0000\u0000\u0099\u009a\u0003<\u001e\u0000\u009a\u009b\u0005\f\u0000"+
		"\u0000\u009b\u0017\u0001\u0000\u0000\u0000\u009c\u009d\u0005\u001d\u0000"+
		"\u0000\u009d\u009e\u0005A\u0000\u0000\u009e\u009f\u0005\u001e\u0000\u0000"+
		"\u009f\u0019\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005\u001f\u0000\u0000"+
		"\u00a1\u00a2\u0005A\u0000\u0000\u00a2\u00a3\u0005 \u0000\u0000\u00a3\u001b"+
		"\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005!\u0000\u0000\u00a5\u00a6\u0005"+
		"A\u0000\u0000\u00a6\u00a7\u0005\"\u0000\u0000\u00a7\u001d\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a9\u0005\u0019\u0000\u0000\u00a9\u00aa\u0005=\u0000"+
		"\u0000\u00aa\u00ab\u0005\u001a\u0000\u0000\u00ab\u001f\u0001\u0000\u0000"+
		"\u0000\u00ac\u00ad\u0005)\u0000\u0000\u00ad\u00ae\u0005A\u0000\u0000\u00ae"+
		"\u00af\u0005*\u0000\u0000\u00af!\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005"+
		"#\u0000\u0000\u00b1\u00b2\u0003>\u001f\u0000\u00b2\u00b3\u0005$\u0000"+
		"\u0000\u00b3#\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005%\u0000\u0000\u00b5"+
		"\u00b6\u0003<\u001e\u0000\u00b6\u00b7\u0005&\u0000\u0000\u00b7%\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b9\u0005\'\u0000\u0000\u00b9\u00ba\u0007\u0000"+
		"\u0000\u0000\u00ba\u00bb\u0005(\u0000\u0000\u00bb\'\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0005+\u0000\u0000\u00bd\u00be\u0003<\u001e\u0000\u00be"+
		"\u00bf\u0005,\u0000\u0000\u00bf)\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005"+
		"-\u0000\u0000\u00c1\u00c2\u0005A\u0000\u0000\u00c2\u00c3\u0005.\u0000"+
		"\u0000\u00c3+\u0001\u0000\u0000\u0000\u00c4\u00c5\u00051\u0000\u0000\u00c5"+
		"\u00c6\u0005D\u0000\u0000\u00c6\u00c7\u00052\u0000\u0000\u00c7-\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c9\u00053\u0000\u0000\u00c9\u00ca\u0005A\u0000"+
		"\u0000\u00ca\u00cb\u00054\u0000\u0000\u00cb/\u0001\u0000\u0000\u0000\u00cc"+
		"\u00cd\u00055\u0000\u0000\u00cd\u00ce\u0005A\u0000\u0000\u00ce\u00cf\u0005"+
		"6\u0000\u0000\u00cf1\u0001\u0000\u0000\u0000\u00d0\u00d1\u00057\u0000"+
		"\u0000\u00d1\u00d2\u0005A\u0000\u0000\u00d2\u00d3\u00058\u0000\u0000\u00d3"+
		"3\u0001\u0000\u0000\u0000\u00d4\u00d5\u00059\u0000\u0000\u00d5\u00d6\u0005"+
		"A\u0000\u0000\u00d6\u00d7\u0005:\u0000\u0000\u00d75\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d9\u0005;\u0000\u0000\u00d9\u00da\u0005F\u0000\u0000\u00da"+
		"\u00db\u0005<\u0000\u0000\u00db7\u0001\u0000\u0000\u0000\u00dc\u00dd\u0005"+
		"\u001b\u0000\u0000\u00dd\u00de\u0003<\u001e\u0000\u00de\u00df\u0005\u001c"+
		"\u0000\u0000\u00df9\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005/\u0000\u0000"+
		"\u00e1\u00e2\u0005G\u0000\u0000\u00e2\u00e3\u00050\u0000\u0000\u00e3;"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005A\u0000\u0000\u00e5\u00e6\u0005"+
		"B\u0000\u0000\u00e6\u00e8\u0005A\u0000\u0000\u00e7\u00e9\u0005C\u0000"+
		"\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000"+
		"\u0000\u00e9=\u0001\u0000\u0000\u0000\u00ea\u00ec\u0003<\u001e\u0000\u00eb"+
		"\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed"+
		"\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee"+
		"?\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005A\u0000\u0000\u00f0\u00f1\u0005"+
		"B\u0000\u0000\u00f1\u00f2\u0005A\u0000\u0000\u00f2\u00f3\u0005B\u0000"+
		"\u0000\u00f3\u00f4\u0005A\u0000\u0000\u00f4A\u0001\u0000\u0000\u0000\u00f5"+
		"\u00f8\u0005E\u0000\u0000\u00f6\u00f8\u0003@ \u0000\u00f7\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f6\u0001\u0000\u0000\u0000\u00f8C\u0001\u0000"+
		"\u0000\u0000\u0006HT\u0090\u00e8\u00ed\u00f7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}