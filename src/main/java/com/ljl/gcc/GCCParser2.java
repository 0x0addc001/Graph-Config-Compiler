package com.ljl.gcc;

import java.util.List;

public class GCCParser2 {

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

	private List<Token> _input;
	private int _currentIndex;
	private RuleContext _ctx;
	protected boolean matchedEOF;

	public GCCParser2 (List<Token> input) {
		this._input = input;
	}

	public Token getCurrentToken() {
		return this._input.get(_currentIndex);
	}

	public Token match(int ttype) throws Exception {
		Token t = this.getCurrentToken();
		if (t.getType() == ttype) {
			if (ttype == -1) {
				this.matchedEOF = true;
			}
		} else {
			// throw new Exception("Token type mismatch");
			System.out.println("Token type mismatch");
		}

		return t;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConfigContext extends RuleContext {
		public TerminalNode CONFIG_START() { return getToken(GCCParser2.CONFIG_START, 0); }
		public TerminalNode CONFIG_END() { return getToken(GCCParser2.CONFIG_END, 0); }
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public ConfigContext(RuleContext parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_config; }
	}

	public final ConfigContext config() throws Exception {
		ConfigContext _localctx = new ConfigContext(_ctx);
		int _la;
		try {
			match(CONFIG_START);
			while (?) {
				element();
			}
			match(CONFIG_END);
		}
		catch(Exception re){
			System.out.println("Recognization exception in config");
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElementContext extends RuleContext {
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
		public ElementContext(RuleContext parent, int invokingState) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule() {
			if ( listener instanceof GCCParserListener) ((GCCParserListener)listener).enterElement(this);
		}
		@Override
		public void exitRule() {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitElement(this);
		}
	}

	public final ElementContext element() throws Exception {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		try {
			switch (_input.get(_currentIndex).getType()) {
			case BG_START:
				bg();
				break;
			case SHAPE_START:
				shape();
				break;
			case POINTS_START:
				points();
				break;
			case LINE_START:
				line();
				break;
			case LINES_START:
				lines();
				break;
			case CURVE_START:
				curve();
				break;
			case SCALE_START:
				scale();
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (Exception re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BgContext extends RuleContext {
		public TerminalNode BG_START() { return getToken(GCCParser2.BG_START, 0); }
		public ColContext col() {
			return getRuleContext(ColContext.class,0);
		}
		public X_rangeContext x_range() {
			return getRuleContext(X_rangeContext.class,0);
		}
		public Y_rangeContext y_range() {
			return getRuleContext(Y_rangeContext.class,0);
		}
		public TerminalNode BG_END() { return getToken(GCCParser2.BG_END, 0); }
		public BgContext(RuleContext parent, int invokingState) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_bg; }
	}

	public final BgContext bg() throws Exception {
		BgContext _localctx = new BgContext(_ctx, getState());
		try {
			match(BG_START);
			col();
			x_range();
			y_range();
			match(BG_END);
		}
		catch (Exception re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		return _localctx;
	}

	public static class ShapeContext extends RuleContext {
		public TerminalNode SHAPE_START() { return getToken(GCCParser2.SHAPE_START, 0); }
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
		public TerminalNode SHAPE_END() { return getToken(GCCParser2.SHAPE_END, 0); }
		public ShapeContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final ShapeContext shape() throws Exception {
		ShapeContext _localctx = new ShapeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_shape);
		try {
			match(SHAPE_START);
			col();
			wid();
			pad();
			type();
			center();
			width();
			height();
			match(SHAPE_END);
		}
		catch (Exception re) {
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
	public static class PointsContext extends RuleContext {
		public TerminalNode POINTS_START() { return getToken(GCCParser2.POINTS_START, 0); }
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
		public TerminalNode POINTS_END() { return getToken(GCCParser2.POINTS_END, 0); }
		public PointsContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final PointsContext points() throws Exception {
		PointsContext _localctx = new PointsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_points);
		try {
			match(POINTS_START);
			col();
			wid();
			pad();
			radius();
			list();
			match(POINTS_END);
		}
		catch (Exception re) {
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
	public static class LineContext extends RuleContext {
		public TerminalNode LINE_START() { return getToken(GCCParser2.LINE_START, 0); }
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
		public TerminalNode LINE_END() { return getToken(GCCParser2.LINE_END, 0); }
		public LineContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final LineContext line() throws Exception {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_line);
		try {
			match(LINE_START);
			col();
			wid();
			point();
			slope();
			match(LINE_END);
		}
		catch (Exception re) {
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
	public static class LinesContext extends RuleContext {
		public TerminalNode LINES_START() { return getToken(GCCParser2.LINES_START, 0); }
		public ColContext col() {
			return getRuleContext(ColContext.class,0);
		}
		public WidContext wid() {
			return getRuleContext(WidContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode LINES_END() { return getToken(GCCParser2.LINES_END, 0); }
		public LinesContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final LinesContext lines() throws Exception {
		LinesContext _localctx = new LinesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_lines);
		try {
			match(LINES_START);
			col();
			wid();
			list();
			match(LINES_END);
		}
		catch (Exception re) {
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
	public static class CurveContext extends RuleContext {
		public TerminalNode CURVE_START() { return getToken(GCCParser2.CURVE_START, 0); }
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
		public TerminalNode CURVE_END() { return getToken(GCCParser2.CURVE_END, 0); }
		public CurveContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final CurveContext curve() throws Exception {
		CurveContext _localctx = new CurveContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_curve);
		try {
			match(CURVE_START);
			col();
			wid();
			range();
			amount();
			function();
			match(CURVE_END);
		}
		catch (Exception re) {
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
	public static class ScaleContext extends RuleContext {
		public TerminalNode SCALE_START() { return getToken(GCCParser2.SCALE_START, 0); }
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
		public TerminalNode SCALE_END() { return getToken(GCCParser2.SCALE_END, 0); }
		public ScaleContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final ScaleContext scale() throws Exception {
		ScaleContext _localctx = new ScaleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_scale);
		try {
			match(SCALE_START);
			col();
			wid();
			direction();
			pos();
			from();
			step();
			amount();
			precision();
			match(SCALE_END);
		}
		catch (Exception re) {
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
	public static class ColContext extends RuleContext {
		public TerminalNode COL_START() { return getToken(GCCParser2.COL_START, 0); }
		public TerminalNode COL_END() { return getToken(GCCParser2.COL_END, 0); }
		public Color_valContext color_val() {
			return getRuleContext(Color_valContext.class,0);
		}
		public ColContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final ColContext col() throws Exception {
		ColContext _localctx = new ColContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_col);
		int _la;
		try {
			match(COL_START);
			_la = _input.LA(1);
			if (_la==NUMBER || _la==COLOR_TYPE) {
				color_val();
			}
			match(COL_END);
		}
		catch (Exception re) {
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
	public static class X_rangeContext extends RuleContext {
		public TerminalNode X_RANGE_START() { return getToken(GCCParser2.X_RANGE_START, 0); }
		public Number_pairContext number_pair() {
			return getRuleContext(Number_pairContext.class,0);
		}
		public TerminalNode X_RANGE_END() { return getToken(GCCParser2.X_RANGE_END, 0); }
		public X_rangeContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final X_rangeContext x_range() throws Exception {
		X_rangeContext _localctx = new X_rangeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_x_range);
		try {
			match(X_RANGE_START);
			number_pair();
			match(X_RANGE_END);
		}
		catch (Exception re) {
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
	public static class Y_rangeContext extends RuleContext {
		public TerminalNode Y_RANGE_START() { return getToken(GCCParser2.Y_RANGE_START, 0); }
		public Number_pairContext number_pair() {
			return getRuleContext(Number_pairContext.class,0);
		}
		public TerminalNode Y_RANGE_END() { return getToken(GCCParser2.Y_RANGE_END, 0); }
		public Y_rangeContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final Y_rangeContext y_range() throws Exception {
		Y_rangeContext _localctx = new Y_rangeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_y_range);
		try {
			match(Y_RANGE_START);
			number_pair();
			match(Y_RANGE_END);
		}
		catch (Exception re) {
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
	public static class WidContext extends RuleContext {
		public TerminalNode WID_START() { return getToken(GCCParser2.WID_START, 0); }
		public TerminalNode NUMBER() { return getToken(GCCParser2.NUMBER, 0); }
		public TerminalNode WID_END() { return getToken(GCCParser2.WID_END, 0); }
		public WidContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final WidContext wid() throws Exception {
		WidContext _localctx = new WidContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_wid);
		try {
			match(WID_START);
			match(NUMBER);
			match(WID_END);
		}
		catch (Exception re) {
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
	public static class WidthContext extends RuleContext {
		public TerminalNode WIDTH_START() { return getToken(GCCParser2.WIDTH_START, 0); }
		public TerminalNode NUMBER() { return getToken(GCCParser2.NUMBER, 0); }
		public TerminalNode WIDTH_END() { return getToken(GCCParser2.WIDTH_END, 0); }
		public WidthContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final WidthContext width() throws Exception {
		WidthContext _localctx = new WidthContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_width);
		try {
			match(WIDTH_START);
			match(NUMBER);
			match(WIDTH_END);
		}
		catch (Exception re) {
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
	public static class HeightContext extends RuleContext {
		public TerminalNode HEIGHT_START() { return getToken(GCCParser2.HEIGHT_START, 0); }
		public TerminalNode NUMBER() { return getToken(GCCParser2.NUMBER, 0); }
		public TerminalNode HEIGHT_END() { return getToken(GCCParser2.HEIGHT_END, 0); }
		public HeightContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final HeightContext height() throws Exception {
		HeightContext _localctx = new HeightContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_height);
		try {
			match(HEIGHT_START);
			match(NUMBER);
			match(HEIGHT_END);
		}
		catch (Exception re) {
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
	public static class PadContext extends RuleContext {
		public TerminalNode PAD_START() { return getToken(GCCParser2.PAD_START, 0); }
		public TerminalNode BOOLEAN() { return getToken(GCCParser2.BOOLEAN, 0); }
		public TerminalNode PAD_END() { return getToken(GCCParser2.PAD_END, 0); }
		public PadContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final PadContext pad() throws Exception {
		PadContext _localctx = new PadContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_pad);
		try {
			match(PAD_START);
			match(BOOLEAN);
			match(PAD_END);
		}
		catch (Exception re) {
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
	public static class RadiusContext extends RuleContext {
		public TerminalNode RADIUS_START() { return getToken(GCCParser2.RADIUS_START, 0); }
		public TerminalNode NUMBER() { return getToken(GCCParser2.NUMBER, 0); }
		public TerminalNode RADIUS_END() { return getToken(GCCParser2.RADIUS_END, 0); }
		public RadiusContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final RadiusContext radius() throws Exception {
		RadiusContext _localctx = new RadiusContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_radius);
		try {
			match(RADIUS_START);
			match(NUMBER);
			match(RADIUS_END);
		}
		catch (Exception re) {
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
	public static class ListContext extends RuleContext {
		public TerminalNode LIST_START() { return getToken(GCCParser2.LIST_START, 0); }
		public Number_pair_listContext number_pair_list() {
			return getRuleContext(Number_pair_listContext.class,0);
		}
		public TerminalNode LIST_END() { return getToken(GCCParser2.LIST_END, 0); }
		public ListContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final ListContext list() throws Exception {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_list);
		try {
			match(LIST_START);
			number_pair_list();
			match(LIST_END);
		}
		catch (Exception re) {
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
	public static class PointContext extends RuleContext {
		public TerminalNode POINT_START() { return getToken(GCCParser2.POINT_START, 0); }
		public Number_pairContext number_pair() {
			return getRuleContext(Number_pairContext.class,0);
		}
		public TerminalNode POINT_END() { return getToken(GCCParser2.POINT_END, 0); }
		public PointContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final PointContext point() throws Exception {
		PointContext _localctx = new PointContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_point);
		try {
			match(POINT_START);
			number_pair();
			match(POINT_END);
		}
		catch (Exception re) {
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
	public static class SlopeContext extends RuleContext {
		public TerminalNode SLOPE_START() { return getToken(GCCParser2.SLOPE_START, 0); }
		public TerminalNode SLOPE_END() { return getToken(GCCParser2.SLOPE_END, 0); }
		public TerminalNode INF() { return getToken(GCCParser2.INF, 0); }
		public TerminalNode NUMBER() { return getToken(GCCParser2.NUMBER, 0); }
		public SlopeContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final SlopeContext slope() throws Exception {
		SlopeContext _localctx = new SlopeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_slope);
		int _la;
		try {
			match(SLOPE_START);
			_la = _input.LA(1);
			if ( !(_la==INF || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			match(SLOPE_END);
		}
		catch (Exception re) {
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
	public static class RangeContext extends RuleContext {
		public TerminalNode RANGE_START() { return getToken(GCCParser2.RANGE_START, 0); }
		public Number_pairContext number_pair() {
			return getRuleContext(Number_pairContext.class,0);
		}
		public TerminalNode RANGE_END() { return getToken(GCCParser2.RANGE_END, 0); }
		public RangeContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final RangeContext range() throws Exception {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_range);
		try {
			match(RANGE_START);
			number_pair();
			match(RANGE_END);
		}
		catch (Exception re) {
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
	public static class AmountContext extends RuleContext {
		public TerminalNode AMOUNT_START() { return getToken(GCCParser2.AMOUNT_START, 0); }
		public TerminalNode NUMBER() { return getToken(GCCParser2.NUMBER, 0); }
		public TerminalNode AMOUNT_END() { return getToken(GCCParser2.AMOUNT_END, 0); }
		public AmountContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final AmountContext amount() throws Exception {
		AmountContext _localctx = new AmountContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_amount);
		try {
			match(AMOUNT_START);
			match(NUMBER);
			match(AMOUNT_END);
		}
		catch (Exception re) {
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
	public static class DirectionContext extends RuleContext {
		public TerminalNode DIRECTION_START() { return getToken(GCCParser2.DIRECTION_START, 0); }
		public TerminalNode DIRECTION_TYPE() { return getToken(GCCParser2.DIRECTION_TYPE, 0); }
		public TerminalNode DIRECTION_END() { return getToken(GCCParser2.DIRECTION_END, 0); }
		public DirectionContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final DirectionContext direction() throws Exception {
		DirectionContext _localctx = new DirectionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_direction);
		try {
			match(DIRECTION_START);
			match(DIRECTION_TYPE);
			match(DIRECTION_END);
		}
		catch (Exception re) {
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
	public static class PosContext extends RuleContext {
		public TerminalNode POS_START() { return getToken(GCCParser2.POS_START, 0); }
		public TerminalNode NUMBER() { return getToken(GCCParser2.NUMBER, 0); }
		public TerminalNode POS_END() { return getToken(GCCParser2.POS_END, 0); }
		public PosContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final PosContext pos() throws Exception {
		PosContext _localctx = new PosContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_pos);
		try {
			setState(200);
			match(POS_START);
			setState(201);
			match(NUMBER);
			setState(202);
			match(POS_END);
		}
		catch (Exception re) {
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
	public static class FromContext extends RuleContext {
		public TerminalNode FROM_START() { return getToken(GCCParser2.FROM_START, 0); }
		public TerminalNode NUMBER() { return getToken(GCCParser2.NUMBER, 0); }
		public TerminalNode FROM_END() { return getToken(GCCParser2.FROM_END, 0); }
		public FromContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final FromContext from() throws Exception {
		FromContext _localctx = new FromContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_from);
		try {
			match(FROM_START);
			match(NUMBER);
			match(FROM_END);
		}
		catch (Exception re) {
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
	public static class StepContext extends RuleContext {
		public TerminalNode STEP_START() { return getToken(GCCParser2.STEP_START, 0); }
		public TerminalNode NUMBER() { return getToken(GCCParser2.NUMBER, 0); }
		public TerminalNode STEP_END() { return getToken(GCCParser2.STEP_END, 0); }
		public StepContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final StepContext step() throws Exception {
		StepContext _localctx = new StepContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_step);
		try {
			match(STEP_START);
			match(NUMBER);
			match(STEP_END);
		}
		catch (Exception re) {
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
	public static class PrecisionContext extends RuleContext {
		public TerminalNode PRECISION_START() { return getToken(GCCParser2.PRECISION_START, 0); }
		public TerminalNode NUMBER() { return getToken(GCCParser2.NUMBER, 0); }
		public TerminalNode PRECISION_END() { return getToken(GCCParser2.PRECISION_END, 0); }
		public PrecisionContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final PrecisionContext precision() throws Exception {
		PrecisionContext _localctx = new PrecisionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_precision);
		try {
			match(PRECISION_START);
			match(NUMBER);
			match(PRECISION_END);
		}
		catch (Exception re) {
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
	public static class TypeContext extends RuleContext {
		public TerminalNode TYPE_START() { return getToken(GCCParser2.TYPE_START, 0); }
		public TerminalNode SHAPE_TYPE() { return getToken(GCCParser2.SHAPE_TYPE, 0); }
		public TerminalNode TYPE_END() { return getToken(GCCParser2.TYPE_END, 0); }
		public TypeContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final TypeContext type() throws Exception {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_type);
		try {
			match(TYPE_START);
			match(SHAPE_TYPE);
			match(TYPE_END);
		}
		catch (Exception re) {
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
	public static class CenterContext extends RuleContext {
		public TerminalNode CENTER_START() { return getToken(GCCParser2.CENTER_START, 0); }
		public Number_pairContext number_pair() {
			return getRuleContext(Number_pairContext.class,0);
		}
		public TerminalNode CENTER_END() { return getToken(GCCParser2.CENTER_END, 0); }
		public CenterContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final CenterContext center() throws Exception {
		CenterContext _localctx = new CenterContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_center);
		try {
			match(CENTER_START);
			number_pair();
			match(CENTER_END);
		}
		catch (Exception re) {
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
	public static class FunctionContext extends RuleContext {
		public TerminalNode FUNCTION_START() { return getToken(GCCParser2.FUNCTION_START, 0); }
		public TerminalNode FUNCTION_EXPR() { return getToken(GCCParser2.FUNCTION_EXPR, 0); }
		public TerminalNode FUNCTION_END() { return getToken(GCCParser2.FUNCTION_END, 0); }
		public FunctionContext(RuleContext parent, int invokingState) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws Exception {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_function);
		try {
			match(FUNCTION_START);
			match(FUNCTION_EXPR);
			match(FUNCTION_END);
		}
		catch (Exception re) {
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
	public static class Number_pairContext extends RuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(GCCParser2.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(GCCParser2.NUMBER, i);
		}
		public TerminalNode COMMA() { return getToken(GCCParser2.COMMA, 0); }
		public TerminalNode SEMICOLON() { return getToken(GCCParser2.SEMICOLON, 0); }
		public Number_pairContext(RuleContext parent, int invokingState) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_number_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterNumber_pair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitNumber_pair(this);
		}
	}

	public final Number_pairContext number_pair() throws Exception {
		Number_pairContext _localctx = new Number_pairContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_number_pair);
		int _la;
		try {
			match(NUMBER);
			match(COMMA);
			match(NUMBER);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				match(SEMICOLON);
			}
		}
		catch (Exception re) {
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
	public static class Number_pair_listContext extends RuleContext {
		public List<Number_pairContext> number_pair() {
			return getRuleContexts(Number_pairContext.class);
		}
		public Number_pairContext number_pair(int i) {
			return getRuleContext(Number_pairContext.class,i);
		}
		public Number_pair_listContext(RuleContext parent, int invokingState) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_number_pair_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterNumber_pair_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitNumber_pair_list(this);
		}
	}

	public final Number_pair_listContext number_pair_list() throws Exception {
		Number_pair_listContext _localctx = new Number_pair_listContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_number_pair_list);
		int _la;
		try {
			_la = _input.LA(1);
			do {
				number_pair();
				_la = _input.LA(1);
			} while ( _la==NUMBER );
		}
		catch (Exception re) {
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
	public static class Number_tripletContext extends RuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(GCCParser2.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(GCCParser2.NUMBER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GCCParser2.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GCCParser2.COMMA, i);
		}
		public Number_tripletContext(RuleContext parent, int invokingState) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_number_triplet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).enterNumber_triplet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCCParserListener ) ((GCCParserListener)listener).exitNumber_triplet(this);
		}
	}

	public final Number_tripletContext number_triplet() throws Exception {
		Number_tripletContext _localctx = new Number_tripletContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_number_triplet);
		try {
			match(NUMBER);
			match(COMMA);
			match(NUMBER);
			match(COMMA);
			match(NUMBER);
		}
		catch (Exception re) {
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
	public static class Color_valContext extends RuleContext {
		public TerminalNode COLOR_TYPE() { return getToken(GCCParser2.COLOR_TYPE, 0); }
		public Number_tripletContext number_triplet() {
			return getRuleContext(Number_tripletContext.class,0);
		}
		public Color_valContext(RuleContext parent, int invokingState) {
			super(parent);
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
	}

	public final Color_valContext color_val() throws Exception {
		Color_valContext _localctx = new Color_valContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_color_val);
		try {
			switch (_input.LA(1)) {
			case COLOR_TYPE:
				match(COLOR_TYPE);
				break;
			case NUMBER:
				number_triplet();
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (Exception re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

}
