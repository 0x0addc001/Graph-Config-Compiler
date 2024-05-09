parser grammar GCParser;

options {
    tokenVocab = GCLexer;
}

// Define parser rules

// Main rules
config: CONFIG_START (element*) CONFIG_END;

element: bg | shape | points | line | lines | curve | scale;

bg: BG_START col x_range y_range BG_END;

shape: SHAPE_START col wid pad type center width height SHAPE_END;

points: POINTS_START col wid pad radius list POINTS_END;

line: LINE_START col wid point slope LINE_END;

lines: LINES_START col wid list LINES_END;

curve: CURVE_START col wid range amount function CURVE_END;

scale: SCALE_START col wid direction pos from step amount precision SCALE_END;

col: COL_START color_val? COL_END;

x_range: X_RANGE_START number_pair X_RANGE_END;

y_range: Y_RANGE_START number_pair Y_RANGE_END;

wid: WID_START NUMBER WID_END;

width: WIDTH_START NUMBER WIDTH_END;

height: HEIGHT_START NUMBER HEIGHT_END;

pad: PAD_START BOOLEAN PAD_END;

radius: RADIUS_START NUMBER RADIUS_END;

list: LIST_START number_pair_list LIST_END;

point: POINT_START number_pair POINT_END;

slope: SLOPE_START (INF | NUMBER) SLOPE_END;

range: RANGE_START number_pair RANGE_END;

amount: AMOUNT_START NUMBER AMOUNT_END;

direction: DIRECTION_START DIRECTION_TYPE DIRECTION_END;

pos: POS_START NUMBER POS_END;

from: FROM_START NUMBER FROM_END;

step: STEP_START NUMBER STEP_END;

precision: PRECISION_START NUMBER PRECISION_END;

type: TYPE_START SHAPE_TYPE TYPE_END;

center: CENTER_START number_pair CENTER_END;

function: FUNCTION_START FUNCTION_EXPR FUNCTION_END;

// Basic rules
number_pair: NUMBER COMMA NUMBER SEMICOLON?;

number_pair_list: (number_pair)+;

number_triplet: NUMBER COMMA NUMBER COMMA NUMBER;

color_val: COLOR_TYPE | number_triplet;
