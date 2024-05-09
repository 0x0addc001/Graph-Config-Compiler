package com.ljl.gcc.parser;

import com.ljl.gcc.GCCompiler;
import com.ljl.gcc.token.Token;

import java.util.Iterator;
import java.util.List;

public class GCParser extends GCCompiler {

	public GCParser(List<Token> input) {
		this._input = input;
		for (int i = 0; i < input.size(); i++){
			input.get(i).setTokenIndex(i);
		}
	}

	private List<Token> _input; // 从词法分析获得的token序列
	private TreeNode _output; // 语法分析树根节点
	private int _currentIndex = 0; // 当前token索引
	private RuleNode _rnd; // 当前规则节点
	private boolean matchedEOF;

	public boolean parse() {
		try {
			this._output = this.config();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public TreeNode get_output() {
		return _output;
	}

	public Token getCurrentToken() {
		return this._input.get(_currentIndex);
	}

	public int getCurrentTokenType() {return this._input.get(_currentIndex).getType();}

	public Token consume() {
		Token o = this.getCurrentToken();
		if (o.getType() != -1) {
			this._currentIndex++;
		}
		TokenNode node = this._rnd.addChild(new TokenNode(o));
		return o;
	}

	public Token retreat() {
		Token o = this.getCurrentToken();
		if (o.getTokenIndex() > 0) {
			this._currentIndex--;
		}
		return o;
	}

	public Token match(int ttype) throws Exception {
		Token t = this.getCurrentToken();
		if (t.getType() == ttype) {
			if (ttype == -1) {
				this.matchedEOF = true;
				// stop parsing
				return t;
			}
			this.consume();
		} else {
			this.retreat();
			throw new Exception("Token type mismatch: " + t.getType());
		}
		return t;
	}

	protected void addRuleNodeToTree() {
		RuleNode parent = this._rnd.parent;
		if (parent != null) {
			parent.addChild(this._rnd);
		}
	}

	public void enterRule(RuleNode localrnd, int ruleIndex) {
		this._rnd = localrnd;
		this.addRuleNodeToTree();
	}

	public void exitRule() {
		this._rnd = (RuleNode)this._rnd.parent;
	}

	public static class ConfigNode extends RuleNode {
		public TokenNode CONFIG_START() { return getTokenNode(CONFIG_START, 0); }
		public TokenNode CONFIG_END() { return getTokenNode(CONFIG_END, 0); }
		public List<ElementNode> element() {
			return getRuleNodes(ElementNode.class);
		}
		public ElementNode element(int i) {
			return getRuleNode(ElementNode.class,i);
		}
		public ConfigNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_config; }
	}

	public final ConfigNode config() throws Exception {
		ConfigNode _localrnd = new ConfigNode(_rnd);
		enterRule(_localrnd, RULE_config);
		int _la;
		try {
			match(CONFIG_START);
			_la = this.getCurrentTokenType();
			while (_la != CONFIG_END) {
				element();
				_la = this.getCurrentTokenType();
			}
			match(CONFIG_END);
		}
		catch(Exception re){
			System.out.println("Recognition exception in config");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}

	public static class ElementNode extends RuleNode {
		public BgNode bg() {
			return getRuleNode(BgNode.class,0);
		}
		public ShapeNode shape() {
			return getRuleNode(ShapeNode.class,0);
		}
		public PointsNode points() {
			return getRuleNode(PointsNode.class,0);
		}
		public LineNode line() {
			return getRuleNode(LineNode.class,0);
		}
		public LinesNode lines() {
			return getRuleNode(LinesNode.class,0);
		}
		public CurveNode curve() {
			return getRuleNode(CurveNode.class,0);
		}
		public ScaleNode scale() {
			return getRuleNode(ScaleNode.class,0);
		}
		public ElementNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_element; }
	}

	public final ElementNode element() throws Exception {
		ElementNode _localrnd = new ElementNode(_rnd);
		enterRule(_localrnd, RULE_element);
		try {
			switch (this.getCurrentTokenType()) {
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
				throw new Exception("No Viable Alternative in element: " + this.getCurrentTokenType());
			}
		}
		catch (Exception e) {
			System.out.println("Recognition exception in element");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}

	public static class BgNode extends RuleNode {
		public TokenNode BG_START() { return getTokenNode(BG_START, 0); }
		public ColNode col() {
			return getRuleNode(ColNode.class,0);
		}
		public X_rangeNode x_range() {
			return getRuleNode(X_rangeNode.class,0);
		}
		public Y_rangeNode y_range() {
			return getRuleNode(Y_rangeNode.class,0);
		}
		public TokenNode BG_END() { return getTokenNode(BG_END, 0); }
		public BgNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_bg; }
	}

	public final BgNode bg() throws Exception {
		BgNode _localrnd = new BgNode(_rnd);
		enterRule(_localrnd, RULE_bg);
		try {
			match(BG_START);
			col();
			x_range();
			y_range();
			match(BG_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in bg");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}

	public static class ShapeNode extends RuleNode {
		public TokenNode SHAPE_START() { return getTokenNode(SHAPE_START, 0); }
		public ColNode col() {
			return getRuleNode(ColNode.class,0);
		}
		public WidNode wid() {
			return getRuleNode(WidNode.class,0);
		}
		public PadNode pad() {
			return getRuleNode(PadNode.class,0);
		}
		public TypeNode type() {
			return getRuleNode(TypeNode.class,0);
		}
		public CenterNode center() {
			return getRuleNode(CenterNode.class,0);
		}
		public WidthNode width() {
			return getRuleNode(WidthNode.class,0);
		}
		public HeightNode height() {
			return getRuleNode(HeightNode.class,0);
		}
		public TokenNode SHAPE_END() { return getTokenNode(SHAPE_END, 0); }
		public ShapeNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_shape; }
	}

	public final ShapeNode shape() throws Exception {
		ShapeNode _localrnd = new ShapeNode(_rnd);
		enterRule(_localrnd, RULE_shape);
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
		catch (Exception e) {
			System.out.println("Recognition exception in shape");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}

	public static class PointsNode extends RuleNode {
		public TokenNode POINTS_START() { return getTokenNode(POINTS_START, 0); }
		public ColNode col() {
			return getRuleNode(ColNode.class,0);
		}
		public WidNode wid() {
			return getRuleNode(WidNode.class,0);
		}
		public PadNode pad() {
			return getRuleNode(PadNode.class,0);
		}
		public RadiusNode radius() {
			return getRuleNode(RadiusNode.class,0);
		}
		public ListNode list() {
			return getRuleNode(ListNode.class,0);
		}
		public TokenNode POINTS_END() { return getTokenNode(POINTS_END, 0); }
		public PointsNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_points; }
	}

	public final PointsNode points() throws Exception {
		PointsNode _localrnd = new PointsNode(_rnd);
		enterRule(_localrnd,  RULE_points);
		try {
			match(POINTS_START);
			col();
			wid();
			pad();
			radius();
			list();
			match(POINTS_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in points");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}

	public static class LineNode extends RuleNode {
		public TokenNode LINE_START() { return getTokenNode(LINE_START, 0); }
		public ColNode col() {
			return getRuleNode(ColNode.class,0);
		}
		public WidNode wid() {
			return getRuleNode(WidNode.class,0);
		}
		public PointNode point() {
			return getRuleNode(PointNode.class,0);
		}
		public SlopeNode slope() {
			return getRuleNode(SlopeNode.class,0);
		}
		public TokenNode LINE_END() { return getTokenNode(LINE_END, 0); }
		public LineNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_line; }
	}

	public final LineNode line() throws Exception {
		LineNode _localrnd = new LineNode(_rnd);
		enterRule(_localrnd, RULE_line);
		try {
			match(LINE_START);
			col();
			wid();
			point();
			slope();
			match(LINE_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in line");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}

	public static class LinesNode extends RuleNode {
		public TokenNode LINES_START() { return getTokenNode(LINES_START, 0); }
		public ColNode col() {
			return getRuleNode(ColNode.class,0);
		}
		public WidNode wid() {
			return getRuleNode(WidNode.class,0);
		}
		public ListNode list() {
			return getRuleNode(ListNode.class,0);
		}
		public TokenNode LINES_END() { return getTokenNode(LINES_END, 0); }
		public LinesNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_lines; }
	}

	public final LinesNode lines() throws Exception {
		LinesNode _localrnd = new LinesNode(_rnd);
		enterRule(_localrnd, RULE_lines);
		try {
			match(LINES_START);
			col();
			wid();
			list();
			match(LINES_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in lines");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}

	public static class CurveNode extends RuleNode {
		public TokenNode CURVE_START() { return getTokenNode(CURVE_START, 0); }
		public ColNode col() {
			return getRuleNode(ColNode.class,0);
		}
		public WidNode wid() {
			return getRuleNode(WidNode.class,0);
		}
		public RangeNode range() {
			return getRuleNode(RangeNode.class,0);
		}
		public AmountNode amount() {
			return getRuleNode(AmountNode.class,0);
		}
		public FunctionNode function() {
			return getRuleNode(FunctionNode.class,0);
		}
		public TokenNode CURVE_END() { return getTokenNode(CURVE_END, 0); }
		public CurveNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_curve; }
	}

	public final CurveNode curve() throws Exception {
		CurveNode _localrnd = new CurveNode(_rnd);
		enterRule(_localrnd, RULE_curve);
		try {
			match(CURVE_START);
			col();
			wid();
			range();
			amount();
			function();
			match(CURVE_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in curve");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}

	public static class ScaleNode extends RuleNode {
		public TokenNode SCALE_START() { return getTokenNode(SCALE_START, 0); }
		public ColNode col() {
			return getRuleNode(ColNode.class,0);
		}
		public WidNode wid() {
			return getRuleNode(WidNode.class,0);
		}
		public DirectionNode direction() {
			return getRuleNode(DirectionNode.class,0);
		}
		public PosNode pos() {
			return getRuleNode(PosNode.class,0);
		}
		public FromNode from() {
			return getRuleNode(FromNode.class,0);
		}
		public StepNode step() {
			return getRuleNode(StepNode.class,0);
		}
		public AmountNode amount() {
			return getRuleNode(AmountNode.class,0);
		}
		public PrecisionNode precision() {
			return getRuleNode(PrecisionNode.class,0);
		}
		public TokenNode SCALE_END() { return getTokenNode(SCALE_END, 0); }
		public ScaleNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_scale; }
	}

	public final ScaleNode scale() throws Exception {
		ScaleNode _localrnd = new ScaleNode(_rnd);
		enterRule(_localrnd, RULE_scale);
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
		catch (Exception e) {
			System.out.println("Recognition exception in scale");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}

	public static class ColNode extends RuleNode {
		public TokenNode COL_START() { return getTokenNode(COL_START, 0); }
		public TokenNode COL_END() { return getTokenNode(COL_END, 0); }
		public Color_valNode color_val() {
			return getRuleNode(Color_valNode.class,0);
		}
		public ColNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_col; }
	}

	public final ColNode col() throws Exception {
		ColNode _localrnd = new ColNode(_rnd);
		enterRule(_localrnd, RULE_col);
		int _la;
		try {
			match(COL_START);
			_la = this.getCurrentTokenType();
			if (_la==NUMBER || _la==COLOR_TYPE) {
				color_val();
			}
			match(COL_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in col");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class X_rangeNode extends RuleNode {
		public TokenNode X_RANGE_START() { return getTokenNode(X_RANGE_START, 0); }
		public Number_pairNode number_pair() {
			return getRuleNode(Number_pairNode.class,0);
		}
		public TokenNode X_RANGE_END() { return getTokenNode(X_RANGE_END, 0); }
		public X_rangeNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_x_range; }
	}

	public final X_rangeNode x_range() throws Exception {
		X_rangeNode _localrnd = new X_rangeNode(_rnd);
		enterRule(_localrnd, RULE_x_range);
		try {
			match(X_RANGE_START);
			number_pair();
			match(X_RANGE_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in x_range");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}

	public static class Y_rangeNode extends RuleNode {
		public TokenNode Y_RANGE_START() { return getTokenNode(Y_RANGE_START, 0); }
		public Number_pairNode number_pair() {
			return getRuleNode(Number_pairNode.class,0);
		}
		public TokenNode Y_RANGE_END() { return getTokenNode(Y_RANGE_END, 0); }
		public Y_rangeNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_y_range; }
	}

	public final Y_rangeNode y_range() throws Exception {
		Y_rangeNode _localrnd = new Y_rangeNode(_rnd);
		enterRule(_localrnd, RULE_y_range);
		try {
			match(Y_RANGE_START);
			number_pair();
			match(Y_RANGE_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in y_range");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class WidNode extends RuleNode {
		public TokenNode WID_START() { return getTokenNode(WID_START, 0); }
		public TokenNode NUMBER() { return getTokenNode(NUMBER, 0); }
		public TokenNode WID_END() { return getTokenNode(WID_END, 0); }
		public WidNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_wid; }
	}

	public final WidNode wid() throws Exception {
		WidNode _localrnd = new WidNode(_rnd);
		enterRule(_localrnd, RULE_wid);
		try {
			match(WID_START);
			match(NUMBER);
			match(WID_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in wid");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class WidthNode extends RuleNode {
		public TokenNode WIDTH_START() { return getTokenNode(WIDTH_START, 0); }
		public TokenNode NUMBER() { return getTokenNode(NUMBER, 0); }
		public TokenNode WIDTH_END() { return getTokenNode(WIDTH_END, 0); }
		public WidthNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_width; }
	}

	public final WidthNode width() throws Exception {
		WidthNode _localrnd = new WidthNode(_rnd);
		enterRule(_localrnd, RULE_width);
		try {
			match(WIDTH_START);
			match(NUMBER);
			match(WIDTH_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in width");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class HeightNode extends RuleNode {
		public TokenNode HEIGHT_START() { return getTokenNode(HEIGHT_START, 0); }
		public TokenNode NUMBER() { return getTokenNode(NUMBER, 0); }
		public TokenNode HEIGHT_END() { return getTokenNode(HEIGHT_END, 0); }
		public HeightNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_height; }
	}

	public final HeightNode height() throws Exception {
		HeightNode _localrnd = new HeightNode(_rnd);
		enterRule(_localrnd, RULE_height);
		try {
			match(HEIGHT_START);
			match(NUMBER);
			match(HEIGHT_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in height");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class PadNode extends RuleNode {
		public TokenNode PAD_START() { return getTokenNode(PAD_START, 0); }
		public TokenNode BOOLEAN() { return getTokenNode(BOOLEAN, 0); }
		public TokenNode PAD_END() { return getTokenNode(PAD_END, 0); }
		public PadNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_pad; }
	}

	public final PadNode pad() throws Exception {
		PadNode _localrnd = new PadNode(_rnd);
		enterRule(_localrnd, RULE_pad);
		try {
			match(PAD_START);
			match(BOOLEAN);
			match(PAD_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in pad");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class RadiusNode extends RuleNode {
		public TokenNode RADIUS_START() { return getTokenNode(RADIUS_START, 0); }
		public TokenNode NUMBER() { return getTokenNode(NUMBER, 0); }
		public TokenNode RADIUS_END() { return getTokenNode(RADIUS_END, 0); }
		public RadiusNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_radius; }
	}

	public final RadiusNode radius() throws Exception {
		RadiusNode _localrnd = new RadiusNode(_rnd);
		enterRule(_localrnd, RULE_radius);
		try {
			match(RADIUS_START);
			match(NUMBER);
			match(RADIUS_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in radius");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class ListNode extends RuleNode {
		public TokenNode LIST_START() { return getTokenNode(LIST_START, 0); }
		public Number_pair_listNode number_pair_list() {
			return getRuleNode(Number_pair_listNode.class,0);
		}
		public TokenNode LIST_END() { return getTokenNode(LIST_END, 0); }
		public ListNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_list; }
	}

	public final ListNode list() throws Exception {
		ListNode _localrnd = new ListNode(_rnd);
		enterRule(_localrnd, RULE_list);
		try {
			match(LIST_START);
			number_pair_list();
			match(LIST_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in list");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class PointNode extends RuleNode {
		public TokenNode POINT_START() { return getTokenNode(POINT_START, 0); }
		public Number_pairNode number_pair() {
			return getRuleNode(Number_pairNode.class,0);
		}
		public TokenNode POINT_END() { return getTokenNode(POINT_END, 0); }
		public PointNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_point; }
	}

	public final PointNode point() throws Exception {
		PointNode _localrnd = new PointNode(_rnd);
		enterRule(_localrnd, RULE_point);
		try {
			match(POINT_START);
			number_pair();
			match(POINT_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in point");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class SlopeNode extends RuleNode {
		public TokenNode SLOPE_START() { return getTokenNode(SLOPE_START, 0); }
		public TokenNode SLOPE_END() { return getTokenNode(SLOPE_END, 0); }
		public TokenNode INF() { return getTokenNode(INF, 0); }
		public TokenNode NUMBER() { return getTokenNode(NUMBER, 0); }
		public SlopeNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_slope; }
	}

	public final SlopeNode slope() throws Exception {
		SlopeNode _localrnd = new SlopeNode(_rnd);
		enterRule(_localrnd, RULE_slope);
		int _la;
		try {
			match(SLOPE_START);
			_la = this.getCurrentTokenType();
			if ( !(_la==INF || _la==NUMBER) ) {
				throw new Exception("No Viable Alternative in slope: " + this.getCurrentTokenType());
			}
			else {
				if ( this.getCurrentTokenType()==Token.EOF ) matchedEOF = true;
				consume();
			}
			match(SLOPE_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in slope");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class RangeNode extends RuleNode {
		public TokenNode RANGE_START() { return getTokenNode(RANGE_START, 0); }
		public Number_pairNode number_pair() {
			return getRuleNode(Number_pairNode.class,0);
		}
		public TokenNode RANGE_END() { return getTokenNode(RANGE_END, 0); }
		public RangeNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_range; }
	}

	public final RangeNode range() throws Exception {
		RangeNode _localrnd = new RangeNode(_rnd);
		enterRule(_localrnd, RULE_range);
		try {
			match(RANGE_START);
			number_pair();
			match(RANGE_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in range");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class AmountNode extends RuleNode {
		public TokenNode AMOUNT_START() { return getTokenNode(AMOUNT_START, 0); }
		public TokenNode NUMBER() { return getTokenNode(NUMBER, 0); }
		public TokenNode AMOUNT_END() { return getTokenNode(AMOUNT_END, 0); }
		public AmountNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_amount; }
	}

	public final AmountNode amount() throws Exception {
		AmountNode _localrnd = new AmountNode(_rnd);
		enterRule(_localrnd, RULE_amount);
		try {
			match(AMOUNT_START);
			match(NUMBER);
			match(AMOUNT_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in amount");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class DirectionNode extends RuleNode {
		public TokenNode DIRECTION_START() { return getTokenNode(DIRECTION_START, 0); }
		public TokenNode DIRECTION_TYPE() { return getTokenNode(DIRECTION_TYPE, 0); }
		public TokenNode DIRECTION_END() { return getTokenNode(DIRECTION_END, 0); }
		public DirectionNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_direction; }
	}

	public final DirectionNode direction() throws Exception {
		DirectionNode _localrnd = new DirectionNode(_rnd);
		enterRule(_localrnd, RULE_direction);
		try {
			match(DIRECTION_START);
			match(DIRECTION_TYPE);
			match(DIRECTION_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in direction");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class PosNode extends RuleNode {
		public TokenNode POS_START() { return getTokenNode(POS_START, 0); }
		public TokenNode NUMBER() { return getTokenNode(NUMBER, 0); }
		public TokenNode POS_END() { return getTokenNode(POS_END, 0); }
		public PosNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_pos; }
	}

	public final PosNode pos() throws Exception {
		PosNode _localrnd = new PosNode(_rnd);
		enterRule(_localrnd, RULE_pos);
		try {
			match(POS_START);
			match(NUMBER);
			match(POS_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in pos");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class FromNode extends RuleNode {
		public TokenNode FROM_START() { return getTokenNode(FROM_START, 0); }
		public TokenNode NUMBER() { return getTokenNode(NUMBER, 0); }
		public TokenNode FROM_END() { return getTokenNode(FROM_END, 0); }
		public FromNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_from; }
	}

	public final FromNode from() throws Exception {
		FromNode _localrnd = new FromNode(_rnd);
		enterRule(_localrnd, RULE_from);
		try {
			match(FROM_START);
			match(NUMBER);
			match(FROM_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in from");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class StepNode extends RuleNode {
		public TokenNode STEP_START() { return getTokenNode(STEP_START, 0); }
		public TokenNode NUMBER() { return getTokenNode(NUMBER, 0); }
		public TokenNode STEP_END() { return getTokenNode(STEP_END, 0); }
		public StepNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_step; }
	}

	public final StepNode step() throws Exception {
		StepNode _localrnd = new StepNode(_rnd);
		enterRule(_localrnd, RULE_step);
		try {
			match(STEP_START);
			match(NUMBER);
			match(STEP_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in step");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class PrecisionNode extends RuleNode {
		public TokenNode PRECISION_START() { return getTokenNode(PRECISION_START, 0); }
		public TokenNode NUMBER() { return getTokenNode(NUMBER, 0); }
		public TokenNode PRECISION_END() { return getTokenNode(PRECISION_END, 0); }
		public PrecisionNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_precision; }
	}

	public final PrecisionNode precision() throws Exception {
		PrecisionNode _localrnd = new PrecisionNode(_rnd);
		enterRule(_localrnd, RULE_precision);
		try {
			match(PRECISION_START);
			match(NUMBER);
			match(PRECISION_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in precision");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class TypeNode extends RuleNode {
		public TokenNode TYPE_START() { return getTokenNode(TYPE_START, 0); }
		public TokenNode SHAPE_TYPE() { return getTokenNode(SHAPE_TYPE, 0); }
		public TokenNode TYPE_END() { return getTokenNode(TYPE_END, 0); }
		public TypeNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeNode type() throws Exception {
		TypeNode _localrnd = new TypeNode(_rnd);
		enterRule(_localrnd, RULE_type);
		try {
			match(TYPE_START);
			match(SHAPE_TYPE);
			match(TYPE_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in type");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class CenterNode extends RuleNode {
		public TokenNode CENTER_START() { return getTokenNode(CENTER_START, 0); }
		public Number_pairNode number_pair() {
			return getRuleNode(Number_pairNode.class,0);
		}
		public TokenNode CENTER_END() { return getTokenNode(CENTER_END, 0); }
		public CenterNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_center; }
	}

	public final CenterNode center() throws Exception {
		CenterNode _localrnd = new CenterNode(_rnd);
		enterRule(_localrnd, RULE_center);
		try {
			match(CENTER_START);
			number_pair();
			match(CENTER_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in center");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class FunctionNode extends RuleNode {
		public TokenNode FUNCTION_START() { return getTokenNode(FUNCTION_START, 0); }
		public TokenNode FUNCTION_EXPR() { return getTokenNode(FUNCTION_EXPR, 0); }
		public TokenNode FUNCTION_END() { return getTokenNode(FUNCTION_END, 0); }
		public FunctionNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	}

	public final FunctionNode function() throws Exception {
		FunctionNode _localrnd = new FunctionNode(_rnd);
		enterRule(_localrnd, RULE_function);
		try {
			match(FUNCTION_START);
			match(FUNCTION_EXPR);
			match(FUNCTION_END);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in function");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class Number_pairNode extends RuleNode {
		public List<TokenNode> NUMBER() { return getTokenNodes(NUMBER); }
		public TokenNode NUMBER(int i) {
			return getTokenNode(NUMBER, i);
		}
		public TokenNode COMMA() { return getTokenNode(COMMA, 0); }
		public TokenNode SEMICOLON() { return getTokenNode(SEMICOLON, 0); }
		public Number_pairNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_number_pair; }
	}

	public final Number_pairNode number_pair() throws Exception {
		Number_pairNode _localrnd = new Number_pairNode(_rnd);
		enterRule(_localrnd, RULE_number_pair);
		int _la;
		try {
			match(NUMBER);
			match(COMMA);
			match(NUMBER);
			_la = this.getCurrentTokenType();
			if (_la==SEMICOLON) {
				match(SEMICOLON);
			}
		}
		catch (Exception e) {
			System.out.println("Recognition exception in number_pair");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class Number_pair_listNode extends RuleNode {
		public List<Number_pairNode> number_pair() {
			return getRuleNodes(Number_pairNode.class);
		}
		public Number_pairNode number_pair(int i) {
			return getRuleNode(Number_pairNode.class,i);
		}
		public Number_pair_listNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_number_pair_list; }
	}

	public final Number_pair_listNode number_pair_list() throws Exception {
		Number_pair_listNode _localrnd = new Number_pair_listNode(_rnd);
		enterRule(_localrnd, RULE_number_pair_list);
		int _la;
		try {
			_la = this.getCurrentTokenType();
			do {
				number_pair();
				_la = this.getCurrentTokenType();
			} while ( _la==NUMBER );
		}
		catch (Exception e) {
			System.out.println("Recognition exception in number_pair_list");
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class Number_tripletNode extends RuleNode {
		public List<TokenNode> NUMBER() { return getTokenNodes(NUMBER); }
		public TokenNode NUMBER(int i) {
			return getTokenNode(NUMBER, i);
		}
		public List<TokenNode> COMMA() { return getTokenNodes(COMMA); }
		public TokenNode COMMA(int i) {
			return getTokenNode(COMMA, i);
		}
		public Number_tripletNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_number_triplet; }
	}

	public final Number_tripletNode number_triplet() throws Exception {
		Number_tripletNode _localrnd = new Number_tripletNode(_rnd);
		enterRule(_localrnd, RULE_number_triplet);
		try {
			match(NUMBER);
			match(COMMA);
			match(NUMBER);
			match(COMMA);
			match(NUMBER);
		}
		catch (Exception e) {
			System.out.println("Recognition exception in number_triplet");;
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}


	public static class Color_valNode extends RuleNode {
		public TokenNode COLOR_TYPE() { return getTokenNode(COLOR_TYPE, 0); }
		public Number_tripletNode number_triplet() {
			return getRuleNode(Number_tripletNode.class,0);
		}
		public Color_valNode(RuleNode parent) {
			super(parent);
		}
		@Override public int getRuleIndex() { return RULE_color_val; }
	}

	public final Color_valNode color_val() throws Exception {
		Color_valNode _localrnd = new Color_valNode(_rnd);
		enterRule(_localrnd, RULE_color_val);
		try {
			switch (this.getCurrentTokenType()) {
			case COLOR_TYPE:
				match(COLOR_TYPE);
				break;
			case NUMBER:
				number_triplet();
				break;
			default:
				throw new Exception("No viable alternative in color_val: " + this.getCurrentTokenType());
			}
		}
		catch (Exception e) {
			System.out.println("Recognition exception in color_val");;
		}
		finally {
			exitRule();
		}
		return _localrnd;
	}

}
