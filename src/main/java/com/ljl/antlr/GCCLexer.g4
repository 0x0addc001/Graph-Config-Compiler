lexer grammar GCCLexer;

// Define tokens

// Ignore whitespace
WS: [ \t\r\n]+ -> skip;

CONFIG_START: '<config>';
CONFIG_END: '</config>';
BG_START: '<bg>';
BG_END: '</bg>';
COL_START: '<col>';
COL_END: '</col>';
X_RANGE_START: '<xRange>';
X_RANGE_END: '</xRange>';
Y_RANGE_START: '<yRange>';
Y_RANGE_END: '</yRange>';
SHAPE_START: '<shape>';
SHAPE_END: '</shape>';
POINTS_START: '<points>';
POINTS_END: '</points>';
LINE_START: '<line>';
LINE_END: '</line>';
LINES_START: '<lines>';
LINES_END: '</lines>';
CURVE_START: '<curve>';
CURVE_END: '</curve>';
SCALE_START: '<scale>';
SCALE_END: '</scale>';
PAD_START: '<pad>';
PAD_END: '</pad>';
CENTER_START: '<center>';
CENTER_END: '</center>';
WID_START: '<wid>';
WID_END: '</wid>';
WIDTH_START: '<width>';
WIDTH_END: '</width>';
HEIGHT_START: '<height>';
HEIGHT_END: '</height>';
LIST_START: '<list>';
LIST_END: '</list>';
POINT_START: '<point>';
POINT_END: '</point>';
SLOPE_START: '<slope>';
SLOPE_END: '</slope>';
RADIUS_START: '<radius>';
RADIUS_END: '</radius>';
RANGE_START: '<range>';
RANGE_END: '</range>';
AMOUNT_START: '<amount>';
AMOUNT_END: '</amount>';
FUNCTION_START: '<function>';
FUNCTION_END: '</function>';
DIRECTION_START: '<direction>';
DIRECTION_END: '</direction>';
POS_START: '<pos>';
POS_END: '</pos>';
FROM_START: '<from>';
FROM_END: '</from>';
STEP_START: '<step>';
STEP_END: '</step>';
PRECISION_START: '<precision>';
PRECISION_END: '</precision>';
TYPE_START: '<type>';
TYPE_END: '</type>';
TRUE: 'true';
FALSE: 'false';
INF: 'inf';
DIRECTION: 'x' | 'y';
COMMENT_START: '<!--';
COMMENT_END: '-->';
DOUBLE: ('-')? ('0' | [1-9] [0-9]*) ('.' [0-9]+)?;
COMMA: ',';
COLOR_TYPE: 'red' | 'orange' | 'yellow' | 'green' | 'cyan' | 'blue' | 'indigo' | 'violet' | 'white' | 'gray' | 'black';
SHAPE_TYPE: 'oval' | 'rect';

fragment FUNCTION_CONTENT: (~[<])*;
FUNCTION: FUNCTION_START FUNCTION_CONTENT FUNCTION_END;

// Ignore comments
fragment COMMENT_CONTENT: ((~'-') | ('-' ~'-') | ('-' '-' ~'>'))*;
COMMENT: COMMENT_START COMMENT_CONTENT COMMENT_END -> skip;
