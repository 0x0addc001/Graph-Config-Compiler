%{
#include <stdio.h>
#include "GCParser.tab.h"  // 包含Bison生成的头文件
FILE* yyin;
%}

%option noyywrap

CONFIG_START   "<config>"
CONFIG_END     "</config>"
BG_START       "<bg>"
BG_END         "</bg>"
COL_START      "<col>"
COL_END        "</col>"
X_RANGE_START  "<xRange>"
X_RANGE_END    "</xRange>"
Y_RANGE_START  "<yRange>"
Y_RANGE_END    "</yRange>"
SHAPE_START    "<shape>"
SHAPE_END      "</shape>"
POINTS_START   "<points>"
POINTS_END     "</points>"
LINE_START     "<line>"
LINE_END       "</line>"
LINES_START    "<lines>"
LINES_END      "</lines>"
CURVE_START    "<curve>"
CURVE_END      "</curve>"
SCALE_START    "<scale>"
SCALE_END      "</scale>"
PAD_START      "<pad>"
PAD_END        "</pad>"
CENTER_START   "<center>"
CENTER_END     "</center>"
WID_START      "<wid>"
WID_END        "</wid>"
WIDTH_START    "<width>"
WIDTH_END      "</width>"
HEIGHT_START   "<height>"
HEIGHT_END     "</height>"
LIST_START     "<list>"
LIST_END       "</list>"
POINT_START    "<point>"
POINT_END      "</point>"
SLOPE_START    "<slope>"
SLOPE_END      "</slope>"
RADIUS_START   "<radius>"
RADIUS_END     "</radius>"
RANGE_START    "<range>"
RANGE_END      "</range>"
AMOUNT_START   "<amount>"
AMOUNT_END     "</amount>"
FUNCTION_START "<function>"
FUNCTION_END   "</function>"
DIRECTION_START "<direction>"
DIRECTION_END   "</direction>"
POS_START      "<pos>"
POS_END        "</pos>"
FROM_START     "<from>"
FROM_END       "</from>"
STEP_START     "<step>"
STEP_END       "</step>"
PRECISION_START "<precision>"
PRECISION_END   "</precision>"
TYPE_START     "<type>"
TYPE_END       "</type>"
BOOLEAN        "true"|"false"
INF            "inf"
COMMENT_START  "<!--"
COMMENT_END    "-->"
NUMBER         ("-"?)("0"|[1-9][0-9]*)("."[0-9]+)?
COMMA          ","
SEMICOLON      ";"
DIRECTION_TYPE "x"|"y"
COLOR_TYPE     "red"|"orange"|"yellow"|"green"|"cyan"|"blue"|"indigo"|"violet"|"white"|"gray"|"black"
SHAPE_TYPE     "oval"|"rect"
FUNCTION_EXPR  "{"[^<}]+"}"
WS             [ \t\r\n]+
COMMENT_CONTENT ([^-]|"-"[^-]|"--"[^>])*
COMMENT        {COMMENT_START}{COMMENT_CONTENT}{COMMENT_END}

%%
{WS}             { /* Ignore whitespace */ }
{COMMENT}       { /* Ignore comments */ }
{CONFIG_START}   { return CONFIG_START; }
{CONFIG_END}     { return CONFIG_END; }
{BG_START}       { return BG_START; }
{BG_END}         { return BG_END; }
{COL_START}      { return COL_START; }
{COL_END}        { return COL_END; }
{X_RANGE_START}  { return X_RANGE_START; }
{X_RANGE_END}    { return X_RANGE_END; }
{Y_RANGE_START}  { return Y_RANGE_START; }
{Y_RANGE_END}    { return Y_RANGE_END; }
{SHAPE_START}    { return SHAPE_START; }
{SHAPE_END}      { return SHAPE_END; }
{POINTS_START}   { return POINTS_START; }
{POINTS_END}     { return POINTS_END; }
{LINE_START}     { return LINE_START; }
{LINE_END}       { return LINE_END; }
{LINES_START}    { return LINES_START; }
{LINES_END}      { return LINES_END; }
{CURVE_START}    { return CURVE_START; }
{CURVE_END}      { return CURVE_END; }
{SCALE_START}    { return SCALE_START; }
{SCALE_END}      { return SCALE_END; }
{PAD_START}      { return PAD_START; }
{PAD_END}        { return PAD_END; }
{CENTER_START}   { return CENTER_START; }
{CENTER_END}     { return CENTER_END; }
{WID_START}      { return WID_START; }
{WID_END}        { return WID_END; }
{WIDTH_START}    { return WIDTH_START; }
{WIDTH_END}      { return WIDTH_END; }
{HEIGHT_START}   { return HEIGHT_START; }
{HEIGHT_END}     { return HEIGHT_END; }
{LIST_START}     { return LIST_START; }
{LIST_END}       { return LIST_END; }
{POINT_START}    { return POINT_START; }
{POINT_END}      { return POINT_END; }
{SLOPE_START}    { return SLOPE_START; }
{SLOPE_END}      { return SLOPE_END; }
{RADIUS_START}   { return RADIUS_START; }
{RADIUS_END}     { return RADIUS_END; }
{RANGE_START}    { return RANGE_START; }
{RANGE_END}      { return RANGE_END; }
{AMOUNT_START}   { return AMOUNT_START; }
{AMOUNT_END}     { return AMOUNT_END; }
{FUNCTION_START} { return FUNCTION_START; }
{FUNCTION_END}   { return FUNCTION_END; }
{DIRECTION_START} { return DIRECTION_START; }
{DIRECTION_END}  { return DIRECTION_END; }
{POS_START}      { return POS_START; }
{POS_END}        { return POS_END; }
{FROM_START}     { return FROM_START; }
{FROM_END}       { return FROM_END; }
{STEP_START}     { return STEP_START; }
{STEP_END}       { return STEP_END; }
{PRECISION_START} { return PRECISION_START; }
{PRECISION_END} { return PRECISION_END; }
{TYPE_START}     { return TYPE_START; }
{TYPE_END}       { return TYPE_END; }
{BOOLEAN}        { return BOOLEAN; }
{INF}            { return INF; }
{NUMBER}         { return NUMBER; }
{COMMA}          { return COMMA; }
{SEMICOLON}      { return SEMICOLON; }
{DIRECTION_TYPE} { return DIRECTION_TYPE; }
{COLOR_TYPE}     { return COLOR_TYPE; }
{SHAPE_TYPE}     { return SHAPE_TYPE; }
{FUNCTION_EXPR}  { return FUNCTION_EXPR; }
.                { printf("Unrecognized token: %s\n", yytext); }
%%
