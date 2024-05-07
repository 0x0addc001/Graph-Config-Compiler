parser grammar GCCParser;

options {
    tokenVocab = GCCLexer;
}

// Define parser rules

// Main rules
config: CONFIG_START element* CONFIG_END;

element: bg | shape | points | line | lines | curve | scale;

bg: BG_START col x_range y_range BG_END;

shape: SHAPE_START col wid pad type center width height SHAPE_END;

points: POINTS_START col wid pad radius list POINTS_END;

line: LINE_START col wid point slope LINE_END;

lines: LINES_START col wid list LINES_END;

curve: CURVE_START col wid range amount FUNCTION CURVE_END;

scale: SCALE_START col wid direction pos from step amount precision SCALE_END;

// Basic rules
doublePair: DOUBLE COMMA DOUBLE;

doublePairList: (doublePair)*;

doubleTriplet: DOUBLE COMMA DOUBLE COMMA DOUBLE;

color_val: COLOR_TYPE | doubleTriplet;

col: COL_START color_val? COL_END;

x_range: X_RANGE_START doublePair X_RANGE_END;

y_range: Y_RANGE_START doublePair Y_RANGE_END;

wid: WID_START DOUBLE WID_END;

width: WIDTH_START DOUBLE WIDTH_END;

height: HEIGHT_START DOUBLE HEIGHT_END;

pad: PAD_START (TRUE | FALSE) PAD_END;

radius: RADIUS_START DOUBLE RADIUS_END;

list: LIST_START doublePairList LIST_END;

point: POINT_START doublePair POINT_END;

slope: SLOPE_START (INF | DOUBLE) SLOPE_END;

range: RANGE_START doublePair RANGE_END;

amount: AMOUNT_START DOUBLE AMOUNT_END;

direction: DIRECTION_START DIRECTION DIRECTION_END;

pos: POS_START DOUBLE POS_END;

from: FROM_START DOUBLE FROM_END;

step: STEP_START DOUBLE STEP_END;

precision: PRECISION_START DOUBLE PRECISION_END;

type: TYPE_START SHAPE_TYPE TYPE_END;

center: CENTER_START doublePair CENTER_END;
