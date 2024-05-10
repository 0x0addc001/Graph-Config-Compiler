%{
#include <stdio.h>
extern int yylex();
extern FILE* yyin;
void yyerror(const char* s);
%}

%token CONFIG_START CONFIG_END BG_START BG_END COL_START COL_END X_RANGE_START X_RANGE_END
%token Y_RANGE_START Y_RANGE_END SHAPE_START SHAPE_END POINTS_START POINTS_END
%token LINE_START LINE_END LINES_START LINES_END CURVE_START CURVE_END
%token SCALE_START SCALE_END PAD_START PAD_END CENTER_START CENTER_END
%token WID_START WID_END WIDTH_START WIDTH_END HEIGHT_START HEIGHT_END
%token LIST_START LIST_END POINT_START POINT_END SLOPE_START SLOPE_END
%token RADIUS_START RADIUS_END RANGE_START RANGE_END AMOUNT_START AMOUNT_END
%token FUNCTION_START FUNCTION_END DIRECTION_START DIRECTION_END POS_START POS_END
%token FROM_START FROM_END STEP_START STEP_END PRECISION_START PRECISION_END
%token TYPE_START TYPE_END BOOLEAN INF COMMA SEMICOLON DIRECTION_TYPE COLOR_TYPE
%token SHAPE_TYPE FUNCTION_EXPR NUMBER

%%

config: CONFIG_START element_list CONFIG_END
    { printf("Parsed Config\n"); }
    ;

element_list: element_list element
    { printf("Parsed Element List\n"); }
    | /* empty */
    { printf("Parsed Element List\n"); }
    ;

element: bg
        { printf("Parsed Element\n"); }
        | shape
        { printf("Parsed Element\n"); }
        | points
        { printf("Parsed Element\n"); }
        | line
        { printf("Parsed Element\n"); }
        | lines
        { printf("Parsed Element\n"); }
        | curve
        { printf("Parsed Element\n"); }
        | scale
        { printf("Parsed Element\n"); }
        ;

bg: BG_START col x_range y_range BG_END
    { printf("Parsed BG\n"); }
    ;

shape: SHAPE_START col wid pad type center width height SHAPE_END
    { printf("Parsed Shape\n"); }
    ;

points: POINTS_START col wid pad radius list POINTS_END
    { printf("Parsed Points\n"); }
    ;

line: LINE_START col wid point slope LINE_END
    { printf("Parsed Line\n"); }
    ;

lines: LINES_START col wid list LINES_END
    { printf("Parsed Lines\n"); }
    ;

curve: CURVE_START col wid range amount function CURVE_END
    { printf("Parsed Curve\n"); }
    ;

scale: SCALE_START col wid direction pos from step amount precision SCALE_END
    { printf("Parsed Scale\n"); }
    ;

col: COL_START color_val COL_END
    { printf("Parsed Col\n"); }
    ;

x_range: X_RANGE_START number_pair X_RANGE_END
    { printf("Parsed XRange\n"); }
    ;

y_range: Y_RANGE_START number_pair Y_RANGE_END
    { printf("Parsed YRange\n"); }
    ;

wid: WID_START NUMBER WID_END
    { printf("Parsed Wid\n"); }
    ;

width: WIDTH_START NUMBER WIDTH_END
    { printf("Parsed Width\n"); }
    ;

height: HEIGHT_START NUMBER HEIGHT_END
    { printf("Parsed Height\n"); }
    ;

pad: PAD_START BOOLEAN PAD_END
    { printf("Parsed Pad\n"); }
    ;

radius: RADIUS_START NUMBER RADIUS_END
    { printf("Parsed Radius\n"); }
    ;

list: LIST_START number_pair_list LIST_END
    { printf("Parsed List\n"); }
    ;

point: POINT_START number_pair POINT_END
    { printf("Parsed Point\n"); }
    ;

slope: SLOPE_START slope_value SLOPE_END
    { printf("Parsed Slope\n"); }
    ;

slope_value: INF
    { printf("Parsed Slope Value\n"); }
    | NUMBER
    { printf("Parsed Slope Value\n"); }
    ;

range: RANGE_START number_pair RANGE_END
    { printf("Parsed Range\n"); }
    ;

amount: AMOUNT_START NUMBER AMOUNT_END
    { printf("Parsed Amount\n"); }
    ;

direction: DIRECTION_START DIRECTION_TYPE DIRECTION_END
    { printf("Parsed Direction\n"); }
    ;

pos: POS_START NUMBER POS_END
    { printf("Parsed Pos\n"); }
    ;

from: FROM_START NUMBER FROM_END
    { printf("Parsed From\n"); }
    ;

step: STEP_START NUMBER STEP_END
    { printf("Parsed Step\n"); }
    ;

precision: PRECISION_START NUMBER PRECISION_END
    { printf("Parsed Precision\n"); }
    ;

type: TYPE_START SHAPE_TYPE TYPE_END
    { printf("Parsed Type\n"); }
    ;

center: CENTER_START number_pair CENTER_END
    { printf("Parsed Center\n"); }
    ;

function: FUNCTION_START FUNCTION_EXPR FUNCTION_END
    { printf("Parsed Function\n"); }
    ;

number_triplet: NUMBER COMMA NUMBER COMMA NUMBER
    { printf("Parsed Number Triplet\n"); }
    ;

number_pair: NUMBER COMMA NUMBER SEMICOLON
    { printf("Parsed Number Pair\n"); }
    |
    NUMBER COMMA NUMBER
    { printf("Parsed Number Pair\n"); }
    ;

number_pair_list: number_pair_list number_pair
    { printf("Parsed Number Pair List\n"); }
    | number_pair
    { printf("Parsed Number Pair List\n"); }
    ;

color_val: COLOR_TYPE
    { printf("Parsed Color Value\n"); }
    | number_triplet
    { printf("Parsed Color Value\n"); }
    | /* empty */
    { printf("Parsed Color Value\n"); }
    ;

%%

int main(int argc, char* argv[]) {

    if (argc != 2) {
        fprintf(stderr, "Usage: %s <input_file>\n", argv[0]);
        return 1;
    }

    FILE* file = fopen(argv[1], "r");
    if (!file) {
        fprintf(stderr, "Error opening file: %s\n", argv[1]);
        return 1;
    }

    yyin = file;
    yyparse();
    fclose(file);

    return 0;
}

void yyerror(const char* s) {
    fprintf(stderr, "%s\n", s);
}
