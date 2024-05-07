// Generated from D:/CompilerPrincipleProjects/Graph-Config-Compiler-Project/Graph-Config-Compiler/src/main/java/com/ljl/gcc/antlr/GCCParser.g4 by ANTLR 4.13.1
package com.ljl.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GCCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, CONFIG_START=2, CONFIG_END=3, BG_START=4, BG_END=5, COL_START=6,
		COL_END=7, X_RANGE_START=8, X_RANGE_END=9, Y_RANGE_START=10, Y_RANGE_END=11,
		SHAPE_START=12, SHAPE_END=13, POINTS_START=14, POINTS_END=15, LINE_START=16,
		LINE_END=17, LINES_START=18, LINES_END=19, CURVE_START=20, CURVE_END=21,
		SCALE_START=22, SCALE_END=23, PAD_START=24, PAD_END=25, CENTER_START=26,
		CENTER_END=27, WID_START=28, WID_END=29, WIDTH_START=30, WIDTH_END=31,
		HEIGHT_START=32, HEIGHT_END=33, LIST_START=34, LIST_END=35, POINT_START=36,
		POINT_END=37, SLOPE_START=38, SLOPE_END=39, RADIUS_START=40, RADIUS_END=41,
		RANGE_START=42, RANGE_END=43, AMOUNT_START=44, AMOUNT_END=45, FUNCTION_START=46,
		FUNCTION_END=47, DIRECTION_START=48, DIRECTION_END=49, POS_START=50, POS_END=51,
		FROM_START=52, FROM_END=53, STEP_START=54, STEP_END=55, PRECISION_START=56,
		PRECISION_END=57, TYPE_START=58, TYPE_END=59, TRUE=60, FALSE=61, INF=62,
		DIRECTION=63, COMMENT_START=64, COMMENT_END=65, DOUBLE=66, COMMA=67, COLOR_TYPE=68,
		SHAPE_TYPE=69, FUNCTION=70, COMMENT=71;
	public static final int
		RULE_config = 0, RULE_element = 1, RULE_bg = 2, RULE_shape = 3, RULE_points = 4,
		RULE_line = 5, RULE_lines = 6, RULE_curve = 7, RULE_scale = 8, RULE_doublePair = 9,
		RULE_doublePairList = 10, RULE_doubleTriplet = 11, RULE_color_val = 12,
		RULE_col = 13, RULE_x_range = 14, RULE_y_range = 15, RULE_wid = 16, RULE_width = 17,
		RULE_height = 18, RULE_pad = 19, RULE_radius = 20, RULE_list = 21, RULE_point = 22,
		RULE_slope = 23, RULE_range = 24, RULE_amount = 25, RULE_direction = 26,
		RULE_pos = 27, RULE_from = 28, RULE_step = 29, RULE_precision = 30, RULE_type = 31,
		RULE_center = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"config", "element", "bg", "shape", "points", "line", "lines", "curve",
			"scale", "doublePair", "doublePairList", "doubleTriplet", "color_val",
			"col", "x_range", "y_range", "wid", "width", "height", "pad", "radius",
			"list", "point", "slope", "range", "amount", "direction", "pos", "from",
			"step", "precision", "type", "center"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'<config>'", "'</config>'", "'<bg>'", "'</bg>'", "'<col>'",
			"'</col>'", "'<xRange>'", "'</xRange>'", "'<yRange>'", "'</yRange>'",
			"'<shape>'", "'</shape>'", "'<points>'", "'</points>'", "'<line>'", "'</line>'",
			"'<lines>'", "'</lines>'", "'<curve>'", "'</curve>'", "'<scale>'", "'</scale>'",
			"'<pad>'", "'</pad>'", "'<center>'", "'</center>'", "'<wid>'", "'</wid>'",
			"'<width>'", "'</width>'", "'<height>'", "'</height>'", "'<list>'", "'</list>'",
			"'<point>'", "'</point>'", "'<slope>'", "'</slope>'", "'<radius>'", "'</radius>'",
			"'<range>'", "'</range>'", "'<amount>'", "'</amount>'", "'<function>'",
			"'</function>'", "'<direction>'", "'</direction>'", "'<pos>'", "'</pos>'",
			"'<from>'", "'</from>'", "'<step>'", "'</step>'", "'<precision>'", "'</precision>'",
			"'<type>'", "'</type>'", "'true'", "'false'", "'inf'", null, "'<!--'",
			"'-->'", null, "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "CONFIG_START", "CONFIG_END", "BG_START", "BG_END", "COL_START",
			"COL_END", "X_RANGE_START", "X_RANGE_END", "Y_RANGE_START", "Y_RANGE_END",
			"SHAPE_START", "SHAPE_END", "POINTS_START", "POINTS_END", "LINE_START",
			"LINE_END", "LINES_START", "LINES_END", "CURVE_START", "CURVE_END", "SCALE_START",
			"SCALE_END", "PAD_START", "PAD_END", "CENTER_START", "CENTER_END", "WID_START",
			"WID_END", "WIDTH_START", "WIDTH_END", "HEIGHT_START", "HEIGHT_END",
			"LIST_START", "LIST_END", "POINT_START", "POINT_END", "SLOPE_START",
			"SLOPE_END", "RADIUS_START", "RADIUS_END", "RANGE_START", "RANGE_END",
			"AMOUNT_START", "AMOUNT_END", "FUNCTION_START", "FUNCTION_END", "DIRECTION_START",
			"DIRECTION_END", "POS_START", "POS_END", "FROM_START", "FROM_END", "STEP_START",
			"STEP_END", "PRECISION_START", "PRECISION_END", "TYPE_START", "TYPE_END",
			"TRUE", "FALSE", "INF", "DIRECTION", "COMMENT_START", "COMMENT_END",
			"DOUBLE", "COMMA", "COLOR_TYPE", "SHAPE_TYPE", "FUNCTION", "COMMENT"
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
	public String getGrammarFileName() { return "GCCParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GCCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConfigContext extends ParserRuleContext {
		public TerminalNode CONFIG_START() { return getToken(GCCParser.CONFIG_START, 0); }
		public TerminalNode CONFIG_END() { return getToken(GCCParser.CONFIG_END, 0); }
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
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterConfig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitConfig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitConfig(this);
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
			setState(66);
			match(CONFIG_START);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5591056L) != 0)) {
				{
				{
				setState(67);
				element();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
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
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_element);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BG_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				bg();
				}
				break;
			case SHAPE_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				shape();
				}
				break;
			case POINTS_START:
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				points();
				}
				break;
			case LINE_START:
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				line();
				}
				break;
			case LINES_START:
				enterOuterAlt(_localctx, 5);
				{
				setState(79);
				lines();
				}
				break;
			case CURVE_START:
				enterOuterAlt(_localctx, 6);
				{
				setState(80);
				curve();
				}
				break;
			case SCALE_START:
				enterOuterAlt(_localctx, 7);
				{
				setState(81);
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
		public TerminalNode BG_START() { return getToken(GCCParser.BG_START, 0); }
		public ColContext col() {
			return getRuleContext(ColContext.class,0);
		}
		public X_rangeContext x_range() {
			return getRuleContext(X_rangeContext.class,0);
		}
		public Y_rangeContext y_range() {
			return getRuleContext(Y_rangeContext.class,0);
		}
		public TerminalNode BG_END() { return getToken(GCCParser.BG_END, 0); }
		public BgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterBg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitBg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitBg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BgContext bg() throws RecognitionException {
		BgContext _localctx = new BgContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(BG_START);
			setState(85);
			col();
			setState(86);
			x_range();
			setState(87);
			y_range();
			setState(88);
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
		public TerminalNode SHAPE_START() { return getToken(GCCParser.SHAPE_START, 0); }
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
		public TerminalNode SHAPE_END() { return getToken(GCCParser.SHAPE_END, 0); }
		public ShapeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterShape(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitShape(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitShape(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShapeContext shape() throws RecognitionException {
		ShapeContext _localctx = new ShapeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_shape);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(SHAPE_START);
			setState(91);
			col();
			setState(92);
			wid();
			setState(93);
			pad();
			setState(94);
			type();
			setState(95);
			center();
			setState(96);
			width();
			setState(97);
			height();
			setState(98);
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
		public TerminalNode POINTS_START() { return getToken(GCCParser.POINTS_START, 0); }
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
		public TerminalNode POINTS_END() { return getToken(GCCParser.POINTS_END, 0); }
		public PointsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_points; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterPoints(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitPoints(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitPoints(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointsContext points() throws RecognitionException {
		PointsContext _localctx = new PointsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_points);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(POINTS_START);
			setState(101);
			col();
			setState(102);
			wid();
			setState(103);
			pad();
			setState(104);
			radius();
			setState(105);
			list();
			setState(106);
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
		public TerminalNode LINE_START() { return getToken(GCCParser.LINE_START, 0); }
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
		public TerminalNode LINE_END() { return getToken(GCCParser.LINE_END, 0); }
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(LINE_START);
			setState(109);
			col();
			setState(110);
			wid();
			setState(111);
			point();
			setState(112);
			slope();
			setState(113);
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
		public TerminalNode LINES_START() { return getToken(GCCParser.LINES_START, 0); }
		public ColContext col() {
			return getRuleContext(ColContext.class,0);
		}
		public WidContext wid() {
			return getRuleContext(WidContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode LINES_END() { return getToken(GCCParser.LINES_END, 0); }
		public LinesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lines; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterLines(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitLines(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitLines(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinesContext lines() throws RecognitionException {
		LinesContext _localctx = new LinesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_lines);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(LINES_START);
			setState(116);
			col();
			setState(117);
			wid();
			setState(118);
			list();
			setState(119);
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
		public TerminalNode CURVE_START() { return getToken(GCCParser.CURVE_START, 0); }
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
		public TerminalNode FUNCTION() { return getToken(GCCParser.FUNCTION, 0); }
		public TerminalNode CURVE_END() { return getToken(GCCParser.CURVE_END, 0); }
		public CurveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_curve; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterCurve(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitCurve(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitCurve(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CurveContext curve() throws RecognitionException {
		CurveContext _localctx = new CurveContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_curve);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(CURVE_START);
			setState(122);
			col();
			setState(123);
			wid();
			setState(124);
			range();
			setState(125);
			amount();
			setState(126);
			match(FUNCTION);
			setState(127);
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
		public TerminalNode SCALE_START() { return getToken(GCCParser.SCALE_START, 0); }
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
		public TerminalNode SCALE_END() { return getToken(GCCParser.SCALE_END, 0); }
		public ScaleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scale; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterScale(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitScale(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitScale(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScaleContext scale() throws RecognitionException {
		ScaleContext _localctx = new ScaleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_scale);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(SCALE_START);
			setState(130);
			col();
			setState(131);
			wid();
			setState(132);
			direction();
			setState(133);
			pos();
			setState(134);
			from();
			setState(135);
			step();
			setState(136);
			amount();
			setState(137);
			precision();
			setState(138);
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
	public static class DoublePairContext extends ParserRuleContext {
		public List<TerminalNode> DOUBLE() { return getTokens(GCCParser.DOUBLE); }
		public TerminalNode DOUBLE(int i) {
			return getToken(GCCParser.DOUBLE, i);
		}
		public TerminalNode COMMA() { return getToken(GCCParser.COMMA, 0); }
		public DoublePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doublePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterDoublePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitDoublePair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitDoublePair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoublePairContext doublePair() throws RecognitionException {
		DoublePairContext _localctx = new DoublePairContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_doublePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(DOUBLE);
			setState(141);
			match(COMMA);
			setState(142);
			match(DOUBLE);
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
	public static class DoublePairListContext extends ParserRuleContext {
		public List<DoublePairContext> doublePair() {
			return getRuleContexts(DoublePairContext.class);
		}
		public DoublePairContext doublePair(int i) {
			return getRuleContext(DoublePairContext.class,i);
		}
		public DoublePairListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doublePairList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterDoublePairList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitDoublePairList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitDoublePairList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoublePairListContext doublePairList() throws RecognitionException {
		DoublePairListContext _localctx = new DoublePairListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_doublePairList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOUBLE) {
				{
				{
				setState(144);
				doublePair();
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class DoubleTripletContext extends ParserRuleContext {
		public List<TerminalNode> DOUBLE() { return getTokens(GCCParser.DOUBLE); }
		public TerminalNode DOUBLE(int i) {
			return getToken(GCCParser.DOUBLE, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GCCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GCCParser.COMMA, i);
		}
		public DoubleTripletContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleTriplet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterDoubleTriplet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitDoubleTriplet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitDoubleTriplet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoubleTripletContext doubleTriplet() throws RecognitionException {
		DoubleTripletContext _localctx = new DoubleTripletContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_doubleTriplet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(DOUBLE);
			setState(151);
			match(COMMA);
			setState(152);
			match(DOUBLE);
			setState(153);
			match(COMMA);
			setState(154);
			match(DOUBLE);
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
		public TerminalNode COLOR_TYPE() { return getToken(GCCParser.COLOR_TYPE, 0); }
		public DoubleTripletContext doubleTriplet() {
			return getRuleContext(DoubleTripletContext.class,0);
		}
		public Color_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_color_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterColor_val(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitColor_val(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitColor_val(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Color_valContext color_val() throws RecognitionException {
		Color_valContext _localctx = new Color_valContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_color_val);
		try {
			setState(158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COLOR_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				match(COLOR_TYPE);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				doubleTriplet();
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
	public static class ColContext extends ParserRuleContext {
		public TerminalNode COL_START() { return getToken(GCCParser.COL_START, 0); }
		public TerminalNode COL_END() { return getToken(GCCParser.COL_END, 0); }
		public Color_valContext color_val() {
			return getRuleContext(Color_valContext.class,0);
		}
		public ColContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_col; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterCol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitCol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitCol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColContext col() throws RecognitionException {
		ColContext _localctx = new ColContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_col);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(COL_START);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOUBLE || _la==COLOR_TYPE) {
				{
				setState(161);
				color_val();
				}
			}

			setState(164);
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
		public TerminalNode X_RANGE_START() { return getToken(GCCParser.X_RANGE_START, 0); }
		public DoublePairContext doublePair() {
			return getRuleContext(DoublePairContext.class,0);
		}
		public TerminalNode X_RANGE_END() { return getToken(GCCParser.X_RANGE_END, 0); }
		public X_rangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_x_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterX_range(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitX_range(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitX_range(this);
			else return visitor.visitChildren(this);
		}
	}

	public final X_rangeContext x_range() throws RecognitionException {
		X_rangeContext _localctx = new X_rangeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_x_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(X_RANGE_START);
			setState(167);
			doublePair();
			setState(168);
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
		public TerminalNode Y_RANGE_START() { return getToken(GCCParser.Y_RANGE_START, 0); }
		public DoublePairContext doublePair() {
			return getRuleContext(DoublePairContext.class,0);
		}
		public TerminalNode Y_RANGE_END() { return getToken(GCCParser.Y_RANGE_END, 0); }
		public Y_rangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_y_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterY_range(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitY_range(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitY_range(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Y_rangeContext y_range() throws RecognitionException {
		Y_rangeContext _localctx = new Y_rangeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_y_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(Y_RANGE_START);
			setState(171);
			doublePair();
			setState(172);
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
		public TerminalNode WID_START() { return getToken(GCCParser.WID_START, 0); }
		public TerminalNode DOUBLE() { return getToken(GCCParser.DOUBLE, 0); }
		public TerminalNode WID_END() { return getToken(GCCParser.WID_END, 0); }
		public WidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterWid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitWid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitWid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WidContext wid() throws RecognitionException {
		WidContext _localctx = new WidContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_wid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(WID_START);
			setState(175);
			match(DOUBLE);
			setState(176);
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
		public TerminalNode WIDTH_START() { return getToken(GCCParser.WIDTH_START, 0); }
		public TerminalNode DOUBLE() { return getToken(GCCParser.DOUBLE, 0); }
		public TerminalNode WIDTH_END() { return getToken(GCCParser.WIDTH_END, 0); }
		public WidthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_width; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterWidth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitWidth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitWidth(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WidthContext width() throws RecognitionException {
		WidthContext _localctx = new WidthContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_width);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(WIDTH_START);
			setState(179);
			match(DOUBLE);
			setState(180);
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
		public TerminalNode HEIGHT_START() { return getToken(GCCParser.HEIGHT_START, 0); }
		public TerminalNode DOUBLE() { return getToken(GCCParser.DOUBLE, 0); }
		public TerminalNode HEIGHT_END() { return getToken(GCCParser.HEIGHT_END, 0); }
		public HeightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_height; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterHeight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitHeight(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitHeight(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeightContext height() throws RecognitionException {
		HeightContext _localctx = new HeightContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_height);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(HEIGHT_START);
			setState(183);
			match(DOUBLE);
			setState(184);
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
		public TerminalNode PAD_START() { return getToken(GCCParser.PAD_START, 0); }
		public TerminalNode PAD_END() { return getToken(GCCParser.PAD_END, 0); }
		public TerminalNode TRUE() { return getToken(GCCParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(GCCParser.FALSE, 0); }
		public PadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pad; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterPad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitPad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitPad(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PadContext pad() throws RecognitionException {
		PadContext _localctx = new PadContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_pad);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(PAD_START);
			setState(187);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(188);
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
		public TerminalNode RADIUS_START() { return getToken(GCCParser.RADIUS_START, 0); }
		public TerminalNode DOUBLE() { return getToken(GCCParser.DOUBLE, 0); }
		public TerminalNode RADIUS_END() { return getToken(GCCParser.RADIUS_END, 0); }
		public RadiusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_radius; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterRadius(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitRadius(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitRadius(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RadiusContext radius() throws RecognitionException {
		RadiusContext _localctx = new RadiusContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_radius);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(RADIUS_START);
			setState(191);
			match(DOUBLE);
			setState(192);
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
		public TerminalNode LIST_START() { return getToken(GCCParser.LIST_START, 0); }
		public DoublePairListContext doublePairList() {
			return getRuleContext(DoublePairListContext.class,0);
		}
		public TerminalNode LIST_END() { return getToken(GCCParser.LIST_END, 0); }
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(LIST_START);
			setState(195);
			doublePairList();
			setState(196);
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
		public TerminalNode POINT_START() { return getToken(GCCParser.POINT_START, 0); }
		public DoublePairContext doublePair() {
			return getRuleContext(DoublePairContext.class,0);
		}
		public TerminalNode POINT_END() { return getToken(GCCParser.POINT_END, 0); }
		public PointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_point; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterPoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitPoint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitPoint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointContext point() throws RecognitionException {
		PointContext _localctx = new PointContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_point);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(POINT_START);
			setState(199);
			doublePair();
			setState(200);
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
		public TerminalNode SLOPE_START() { return getToken(GCCParser.SLOPE_START, 0); }
		public TerminalNode SLOPE_END() { return getToken(GCCParser.SLOPE_END, 0); }
		public TerminalNode INF() { return getToken(GCCParser.INF, 0); }
		public TerminalNode DOUBLE() { return getToken(GCCParser.DOUBLE, 0); }
		public SlopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterSlope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitSlope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitSlope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlopeContext slope() throws RecognitionException {
		SlopeContext _localctx = new SlopeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_slope);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(SLOPE_START);
			setState(203);
			_la = _input.LA(1);
			if ( !(_la==INF || _la==DOUBLE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(204);
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
		public TerminalNode RANGE_START() { return getToken(GCCParser.RANGE_START, 0); }
		public DoublePairContext doublePair() {
			return getRuleContext(DoublePairContext.class,0);
		}
		public TerminalNode RANGE_END() { return getToken(GCCParser.RANGE_END, 0); }
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(RANGE_START);
			setState(207);
			doublePair();
			setState(208);
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
		public TerminalNode AMOUNT_START() { return getToken(GCCParser.AMOUNT_START, 0); }
		public TerminalNode DOUBLE() { return getToken(GCCParser.DOUBLE, 0); }
		public TerminalNode AMOUNT_END() { return getToken(GCCParser.AMOUNT_END, 0); }
		public AmountContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_amount; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterAmount(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitAmount(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitAmount(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AmountContext amount() throws RecognitionException {
		AmountContext _localctx = new AmountContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_amount);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(AMOUNT_START);
			setState(211);
			match(DOUBLE);
			setState(212);
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
		public TerminalNode DIRECTION_START() { return getToken(GCCParser.DIRECTION_START, 0); }
		public TerminalNode DIRECTION() { return getToken(GCCParser.DIRECTION, 0); }
		public TerminalNode DIRECTION_END() { return getToken(GCCParser.DIRECTION_END, 0); }
		public DirectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_direction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterDirection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitDirection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitDirection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectionContext direction() throws RecognitionException {
		DirectionContext _localctx = new DirectionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_direction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(DIRECTION_START);
			setState(215);
			match(DIRECTION);
			setState(216);
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
		public TerminalNode POS_START() { return getToken(GCCParser.POS_START, 0); }
		public TerminalNode DOUBLE() { return getToken(GCCParser.DOUBLE, 0); }
		public TerminalNode POS_END() { return getToken(GCCParser.POS_END, 0); }
		public PosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterPos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitPos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitPos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PosContext pos() throws RecognitionException {
		PosContext _localctx = new PosContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_pos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(POS_START);
			setState(219);
			match(DOUBLE);
			setState(220);
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
		public TerminalNode FROM_START() { return getToken(GCCParser.FROM_START, 0); }
		public TerminalNode DOUBLE() { return getToken(GCCParser.DOUBLE, 0); }
		public TerminalNode FROM_END() { return getToken(GCCParser.FROM_END, 0); }
		public FromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitFrom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitFrom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromContext from() throws RecognitionException {
		FromContext _localctx = new FromContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_from);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(FROM_START);
			setState(223);
			match(DOUBLE);
			setState(224);
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
		public TerminalNode STEP_START() { return getToken(GCCParser.STEP_START, 0); }
		public TerminalNode DOUBLE() { return getToken(GCCParser.DOUBLE, 0); }
		public TerminalNode STEP_END() { return getToken(GCCParser.STEP_END, 0); }
		public StepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_step; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitStep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitStep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StepContext step() throws RecognitionException {
		StepContext _localctx = new StepContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_step);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(STEP_START);
			setState(227);
			match(DOUBLE);
			setState(228);
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
		public TerminalNode PRECISION_START() { return getToken(GCCParser.PRECISION_START, 0); }
		public TerminalNode DOUBLE() { return getToken(GCCParser.DOUBLE, 0); }
		public TerminalNode PRECISION_END() { return getToken(GCCParser.PRECISION_END, 0); }
		public PrecisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precision; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterPrecision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitPrecision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitPrecision(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrecisionContext precision() throws RecognitionException {
		PrecisionContext _localctx = new PrecisionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_precision);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(PRECISION_START);
			setState(231);
			match(DOUBLE);
			setState(232);
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
		public TerminalNode TYPE_START() { return getToken(GCCParser.TYPE_START, 0); }
		public TerminalNode SHAPE_TYPE() { return getToken(GCCParser.SHAPE_TYPE, 0); }
		public TerminalNode TYPE_END() { return getToken(GCCParser.TYPE_END, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(TYPE_START);
			setState(235);
			match(SHAPE_TYPE);
			setState(236);
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
		public TerminalNode CENTER_START() { return getToken(GCCParser.CENTER_START, 0); }
		public DoublePairContext doublePair() {
			return getRuleContext(DoublePairContext.class,0);
		}
		public TerminalNode CENTER_END() { return getToken(GCCParser.CENTER_END, 0); }
		public CenterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_center; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterCenter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitCenter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCCParserVisitor ) return ((GCCParserVisitor<? extends T>)visitor).visitCenter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CenterContext center() throws RecognitionException {
		CenterContext _localctx = new CenterContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_center);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(CENTER_START);
			setState(239);
			doublePair();
			setState(240);
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

	public static final String _serializedATN =
		"\u0004\u0001G\u00f3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000\u0001\u0000\u0005\u0000"+
		"E\b\u0000\n\u0000\f\u0000H\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001S\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0005\n\u0092\b\n\n\n\f\n\u0095"+
		"\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0003\f\u009f\b\f\u0001\r\u0001\r\u0003\r\u00a3"+
		"\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0000\u0000!\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:<>@\u0000\u0002\u0001\u0000<=\u0002\u0000>>BB\u00db"+
		"\u0000B\u0001\u0000\u0000\u0000\u0002R\u0001\u0000\u0000\u0000\u0004T"+
		"\u0001\u0000\u0000\u0000\u0006Z\u0001\u0000\u0000\u0000\bd\u0001\u0000"+
		"\u0000\u0000\nl\u0001\u0000\u0000\u0000\fs\u0001\u0000\u0000\u0000\u000e"+
		"y\u0001\u0000\u0000\u0000\u0010\u0081\u0001\u0000\u0000\u0000\u0012\u008c"+
		"\u0001\u0000\u0000\u0000\u0014\u0093\u0001\u0000\u0000\u0000\u0016\u0096"+
		"\u0001\u0000\u0000\u0000\u0018\u009e\u0001\u0000\u0000\u0000\u001a\u00a0"+
		"\u0001\u0000\u0000\u0000\u001c\u00a6\u0001\u0000\u0000\u0000\u001e\u00aa"+
		"\u0001\u0000\u0000\u0000 \u00ae\u0001\u0000\u0000\u0000\"\u00b2\u0001"+
		"\u0000\u0000\u0000$\u00b6\u0001\u0000\u0000\u0000&\u00ba\u0001\u0000\u0000"+
		"\u0000(\u00be\u0001\u0000\u0000\u0000*\u00c2\u0001\u0000\u0000\u0000,"+
		"\u00c6\u0001\u0000\u0000\u0000.\u00ca\u0001\u0000\u0000\u00000\u00ce\u0001"+
		"\u0000\u0000\u00002\u00d2\u0001\u0000\u0000\u00004\u00d6\u0001\u0000\u0000"+
		"\u00006\u00da\u0001\u0000\u0000\u00008\u00de\u0001\u0000\u0000\u0000:"+
		"\u00e2\u0001\u0000\u0000\u0000<\u00e6\u0001\u0000\u0000\u0000>\u00ea\u0001"+
		"\u0000\u0000\u0000@\u00ee\u0001\u0000\u0000\u0000BF\u0005\u0002\u0000"+
		"\u0000CE\u0003\u0002\u0001\u0000DC\u0001\u0000\u0000\u0000EH\u0001\u0000"+
		"\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GI\u0001"+
		"\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IJ\u0005\u0003\u0000\u0000"+
		"J\u0001\u0001\u0000\u0000\u0000KS\u0003\u0004\u0002\u0000LS\u0003\u0006"+
		"\u0003\u0000MS\u0003\b\u0004\u0000NS\u0003\n\u0005\u0000OS\u0003\f\u0006"+
		"\u0000PS\u0003\u000e\u0007\u0000QS\u0003\u0010\b\u0000RK\u0001\u0000\u0000"+
		"\u0000RL\u0001\u0000\u0000\u0000RM\u0001\u0000\u0000\u0000RN\u0001\u0000"+
		"\u0000\u0000RO\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RQ\u0001"+
		"\u0000\u0000\u0000S\u0003\u0001\u0000\u0000\u0000TU\u0005\u0004\u0000"+
		"\u0000UV\u0003\u001a\r\u0000VW\u0003\u001c\u000e\u0000WX\u0003\u001e\u000f"+
		"\u0000XY\u0005\u0005\u0000\u0000Y\u0005\u0001\u0000\u0000\u0000Z[\u0005"+
		"\f\u0000\u0000[\\\u0003\u001a\r\u0000\\]\u0003 \u0010\u0000]^\u0003&\u0013"+
		"\u0000^_\u0003>\u001f\u0000_`\u0003@ \u0000`a\u0003\"\u0011\u0000ab\u0003"+
		"$\u0012\u0000bc\u0005\r\u0000\u0000c\u0007\u0001\u0000\u0000\u0000de\u0005"+
		"\u000e\u0000\u0000ef\u0003\u001a\r\u0000fg\u0003 \u0010\u0000gh\u0003"+
		"&\u0013\u0000hi\u0003(\u0014\u0000ij\u0003*\u0015\u0000jk\u0005\u000f"+
		"\u0000\u0000k\t\u0001\u0000\u0000\u0000lm\u0005\u0010\u0000\u0000mn\u0003"+
		"\u001a\r\u0000no\u0003 \u0010\u0000op\u0003,\u0016\u0000pq\u0003.\u0017"+
		"\u0000qr\u0005\u0011\u0000\u0000r\u000b\u0001\u0000\u0000\u0000st\u0005"+
		"\u0012\u0000\u0000tu\u0003\u001a\r\u0000uv\u0003 \u0010\u0000vw\u0003"+
		"*\u0015\u0000wx\u0005\u0013\u0000\u0000x\r\u0001\u0000\u0000\u0000yz\u0005"+
		"\u0014\u0000\u0000z{\u0003\u001a\r\u0000{|\u0003 \u0010\u0000|}\u0003"+
		"0\u0018\u0000}~\u00032\u0019\u0000~\u007f\u0005F\u0000\u0000\u007f\u0080"+
		"\u0005\u0015\u0000\u0000\u0080\u000f\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0005\u0016\u0000\u0000\u0082\u0083\u0003\u001a\r\u0000\u0083\u0084\u0003"+
		" \u0010\u0000\u0084\u0085\u00034\u001a\u0000\u0085\u0086\u00036\u001b"+
		"\u0000\u0086\u0087\u00038\u001c\u0000\u0087\u0088\u0003:\u001d\u0000\u0088"+
		"\u0089\u00032\u0019\u0000\u0089\u008a\u0003<\u001e\u0000\u008a\u008b\u0005"+
		"\u0017\u0000\u0000\u008b\u0011\u0001\u0000\u0000\u0000\u008c\u008d\u0005"+
		"B\u0000\u0000\u008d\u008e\u0005C\u0000\u0000\u008e\u008f\u0005B\u0000"+
		"\u0000\u008f\u0013\u0001\u0000\u0000\u0000\u0090\u0092\u0003\u0012\t\u0000"+
		"\u0091\u0090\u0001\u0000\u0000\u0000\u0092\u0095\u0001\u0000\u0000\u0000"+
		"\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000"+
		"\u0094\u0015\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000"+
		"\u0096\u0097\u0005B\u0000\u0000\u0097\u0098\u0005C\u0000\u0000\u0098\u0099"+
		"\u0005B\u0000\u0000\u0099\u009a\u0005C\u0000\u0000\u009a\u009b\u0005B"+
		"\u0000\u0000\u009b\u0017\u0001\u0000\u0000\u0000\u009c\u009f\u0005D\u0000"+
		"\u0000\u009d\u009f\u0003\u0016\u000b\u0000\u009e\u009c\u0001\u0000\u0000"+
		"\u0000\u009e\u009d\u0001\u0000\u0000\u0000\u009f\u0019\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a2\u0005\u0006\u0000\u0000\u00a1\u00a3\u0003\u0018\f\u0000"+
		"\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005\u0007\u0000\u0000"+
		"\u00a5\u001b\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\b\u0000\u0000\u00a7"+
		"\u00a8\u0003\u0012\t\u0000\u00a8\u00a9\u0005\t\u0000\u0000\u00a9\u001d"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005\n\u0000\u0000\u00ab\u00ac\u0003"+
		"\u0012\t\u0000\u00ac\u00ad\u0005\u000b\u0000\u0000\u00ad\u001f\u0001\u0000"+
		"\u0000\u0000\u00ae\u00af\u0005\u001c\u0000\u0000\u00af\u00b0\u0005B\u0000"+
		"\u0000\u00b0\u00b1\u0005\u001d\u0000\u0000\u00b1!\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0005\u001e\u0000\u0000\u00b3\u00b4\u0005B\u0000\u0000\u00b4"+
		"\u00b5\u0005\u001f\u0000\u0000\u00b5#\u0001\u0000\u0000\u0000\u00b6\u00b7"+
		"\u0005 \u0000\u0000\u00b7\u00b8\u0005B\u0000\u0000\u00b8\u00b9\u0005!"+
		"\u0000\u0000\u00b9%\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005\u0018\u0000"+
		"\u0000\u00bb\u00bc\u0007\u0000\u0000\u0000\u00bc\u00bd\u0005\u0019\u0000"+
		"\u0000\u00bd\'\u0001\u0000\u0000\u0000\u00be\u00bf\u0005(\u0000\u0000"+
		"\u00bf\u00c0\u0005B\u0000\u0000\u00c0\u00c1\u0005)\u0000\u0000\u00c1)"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005\"\u0000\u0000\u00c3\u00c4\u0003"+
		"\u0014\n\u0000\u00c4\u00c5\u0005#\u0000\u0000\u00c5+\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c7\u0005$\u0000\u0000\u00c7\u00c8\u0003\u0012\t\u0000"+
		"\u00c8\u00c9\u0005%\u0000\u0000\u00c9-\u0001\u0000\u0000\u0000\u00ca\u00cb"+
		"\u0005&\u0000\u0000\u00cb\u00cc\u0007\u0001\u0000\u0000\u00cc\u00cd\u0005"+
		"\'\u0000\u0000\u00cd/\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005*\u0000"+
		"\u0000\u00cf\u00d0\u0003\u0012\t\u0000\u00d0\u00d1\u0005+\u0000\u0000"+
		"\u00d11\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005,\u0000\u0000\u00d3\u00d4"+
		"\u0005B\u0000\u0000\u00d4\u00d5\u0005-\u0000\u0000\u00d53\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d7\u00050\u0000\u0000\u00d7\u00d8\u0005?\u0000\u0000"+
		"\u00d8\u00d9\u00051\u0000\u0000\u00d95\u0001\u0000\u0000\u0000\u00da\u00db"+
		"\u00052\u0000\u0000\u00db\u00dc\u0005B\u0000\u0000\u00dc\u00dd\u00053"+
		"\u0000\u0000\u00dd7\u0001\u0000\u0000\u0000\u00de\u00df\u00054\u0000\u0000"+
		"\u00df\u00e0\u0005B\u0000\u0000\u00e0\u00e1\u00055\u0000\u0000\u00e19"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u00056\u0000\u0000\u00e3\u00e4\u0005"+
		"B\u0000\u0000\u00e4\u00e5\u00057\u0000\u0000\u00e5;\u0001\u0000\u0000"+
		"\u0000\u00e6\u00e7\u00058\u0000\u0000\u00e7\u00e8\u0005B\u0000\u0000\u00e8"+
		"\u00e9\u00059\u0000\u0000\u00e9=\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005"+
		":\u0000\u0000\u00eb\u00ec\u0005E\u0000\u0000\u00ec\u00ed\u0005;\u0000"+
		"\u0000\u00ed?\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005\u001a\u0000\u0000"+
		"\u00ef\u00f0\u0003\u0012\t\u0000\u00f0\u00f1\u0005\u001b\u0000\u0000\u00f1"+
		"A\u0001\u0000\u0000\u0000\u0005FR\u0093\u009e\u00a2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
