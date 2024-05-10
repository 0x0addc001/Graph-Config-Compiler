# GCLex 
All the Lex tokens of the GC language described in EBNF.
```ebnf
CONFIG_START = '<config>';
CONFIG_END = '</config>';
BG_START = '<bg>';
BG_END = '</bg>';
COL_START = '<col>';
COL_END = '</col>';
X_RANGE_START = '<xRange>';
X_RANGE_END = '</xRange>';
Y_RANGE_START = '<yRange>';
Y_RANGE_END = '</yRange>';
SHAPE_START = '<shape>';
SHAPE_END = '</shape>';
POINTS_START = '<points>';
POINTS_END = '</points>';
LINE_START = '<line>';
LINE_END = '</line>';
LINES_START = '<lines>';
LINES_END = '</lines>';
CURVE_START = '<curve>';
CURVE_END = '</curve>';
SCALE_START = '<scale>';
SCALE_END = '</scale>';
PAD_START = '<pad>';
PAD_END = '</pad>';
CENTER_START = '<center>';
CENTER_END = '</center>';
WID_START = '<wid>';
WID_END = '</wid>';
WIDTH_START = '<width>';
WIDTH_END = '</width>';
HEIGHT_START = '<height>';
HEIGHT_END = '</height>';
LIST_START = '<list>';
LIST_END = '</list>';
POINT_START = '<point>';
POINT_END = '</point>';
SLOPE_START = '<slope>';
SLOPE_END = '</slope>';
RADIUS_START = '<radius>';
RADIUS_END = '</radius>';
RANGE_START = '<range>';
RANGE_END = '</range>';
AMOUNT_START = '<amount>';
AMOUNT_END = '</amount>';
FUNCTION_START = '<function>';
FUNCTION_END = '</function>';
DIRECTION_START = '<direction>';
DIRECTION_END = '</direction>';
POS_START = '<pos>';
POS_END = '</pos>';
FROM_START = '<from>';
FROM_END = '</from>';
STEP_START = '<step>';
STEP_END = '</step>';
PRECISION_START = '<precision>';
PRECISION_END = '</precision>';
TYPE_START = '<type>';
TYPE_END = '</type>';
BOOLEAN = 'true' | 'false';
INF = 'inf';
COMMENT_START = '<!--';
COMMENT_END = '-->';
$ONE_TO_NINE: '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' ;
$ZERO_TO_NINE: '0' | $ONE_TO_NINE ;
NUMBER = ['-'],('0' | ($ONE_TO_NINE),{$ZERO_TO_NINE}),['.',($ZERO_TO_NINE),{$ZERO_TO_NINE}];
COMMA = ',';
SEMICOLON  = ';';
DIRECTION_TYPE = 'x' | 'y';
COLOR_TYPE = 'red' | 'orange' | 'yellow' | 'green' | 'cyan' | 'blue' | 'indigo' | 'violet' | 'white' | 'gray' | 'black';
SHAPE_TYPE = 'oval' | 'rect';
FUNCTION_EXPR = '{',{-('<' | '}')},'}';
WS = (' '|'\t'|'\r'|'\n'){' '|'\t'|'\r'|'\n'};
$COMENT_CONTENT: {(-'-') | ('-',-'-') | ('-','-',-'>')};
COMMENT = COMMENT_START,COMENT_CONTENT,COMMENT_END;
```
Table of symbols
The following represents a proposed ISO/IEC 14977 standard, by R. S. Scowen, page 7, tables 1 and 2.

| Usage              | Notation  | Alternative  | Meaning       |
|--------------------|-----------|--------------|---------------|
| definition         | =         |              |               |
| concatenation      | ,         |              |               |
| termination        | ;         | .            |               |
| alternation        | \|        | / or !       |               |
| optional           | [ ... ]   | (/ ... /)    | none or once  |
| repetition         | { ... }   | (: ... :)    | none or more  |
| grouping           | ( ... )   |              |               |
| terminal string    | " ... "   |              |               |
| terminal string    | ' ... '   |              |               |
| comment            | (* ... *) |              |               |
| special sequence   | ? ... ?   |              |               |
| exception          | -         |              |               |

Additional symbols

| Usage              | Notation  | Alternative  | Meaning       |
|--------------------|-----------|--------------|---------------|
| fragment           | $         |              | virtual       |
