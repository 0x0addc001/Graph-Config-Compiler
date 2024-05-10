@echo off
flex GCLexer.l
bison -d GCParser.y
gcc lex.yy.c GCParser.tab.c -o GCCompiler
