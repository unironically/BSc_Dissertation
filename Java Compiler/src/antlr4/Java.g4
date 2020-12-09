grammar Java;
/*
 * Productions and terminals supporting the use of the following operations:
 *      - Printing a string literal
 */

input:
    classDeclaration*
    ;

classDeclaration:
    classModifierList CLASS identifier superClassDeclaration? LBRACE classBody RBRACE
    ;

superClassDeclaration:
    EXTENDS identifier
    ;

classModifierList:
    classModifier*
    ;

classModifier:
    PUBLIC
    | STATIC
    ;

classBody:
    classBodyDeclaration*
    ;

classBodyDeclaration:
    classModifierList memberDeclaration
    ;

memberDeclaration:
    methodDeclaration
    | constructorDeclaration
    | fieldDeclaration
    // future: class fields etc.
    ;

methodDeclaration:
    returnType identifier LPAREN parameters RPAREN LBRACE methodBody RBRACE
    ;

constructorDeclaration:
    identifier LPAREN parameters RPAREN LBRACE methodBody RBRACE
    ;

fieldDeclaration:
    localVariableDeclaration ';'
    ;

returnType:
    VOID
    | type;

type:
    identifier // String, Integer, ...
    | type (LSQUARE RSQUARE)+
    ;

parameters:
    | parameter (COMMA parameter)*
    ;

parameter:
    type identifier
    ;

methodBody:
    statement*
    ;

statement:
    IF LPAREN expression RPAREN block (ELSE block)?
    |(localVariableDeclaration | expression | RETURN expression?) SEMI
    ;

block:
    statement
    | LBRACE statement* RBRACE
    ;
localVariableDeclaration:
    type localDeclarationList
    ;

localDeclarationList:
    localDeclaration (COMMA localDeclaration)*
    ;

localDeclaration:
    identifier (ASSIGN expression)?
    ;

expression:
    literal
    | identifier
    | THIS
    | methodReference
    | expression DOT (identifier | methodReference)
    | expression bop=('*'|'/') expression
    | expression bop=('+'|'-') expression
    | expression bop=('<=' | '>=' | '>' | '<') expression
    | expression bop=('==' | '!=') expression
    | expression bop='&&' expression
    | expression bop='||' expression
    | <assoc=right> expression ASSIGN expression
    | constructor
    ;

constructor:
    NEW (
    classObjectConstructor
    | arrayConstructor)
    ;

classObjectConstructor:
    type LPAREN expressionList? RPAREN
    ;

arrayConstructor:
    type LBRACE expressionList? RBRACE
    | identifier (LSQUARE expression RSQUARE)+
    ;

literal:
    STRING_LITERAL
    | INTEGER_LITERAL
    | BOOLEAN_LITERAL
    | NULL_LITERAL
    ;

methodReference:
    identifier LPAREN expressionList? RPAREN
    | SUPER LPAREN expressionList? RPAREN
    | THIS LPAREN expressionList? RPAREN
    ;

expressionList:
   expression (COMMA expression)*
    ;

identifier:
    IDENTIFIER
    ;

// Keywords
PUBLIC: 'public';
STATIC: 'static';
VOID: 'void';
CLASS: 'class';
RETURN: 'return';
EXTENDS: 'extends';
IF: 'if';
ELSE: 'else';
SUPER: 'super';
THIS: 'this';
NEW: 'new';

// Literals
BOOLEAN_LITERAL: 'true' | 'false';
STRING_LITERAL: '"' .*? '"';
INTEGER_LITERAL: ('0' | [1-9][0-9]*);
NULL_LITERAL: 'null';

// Separators
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
LSQUARE: '[';
RSQUARE: ']';
SEMI: ';';
COMMA: ',';
DOT: '.';

// Operators
ASSIGN: '=';
DIV: '/';
MUL: '*';
ADD: '+';
SUB: '-';
EQ: '==';
NE: '!=';
AND: '&&';
OR: '||';
NOT: '!';

// Assignment operators

// Comments/whitespace
COMMENT: '/*' .*? '*/' -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;
WHITESPACE: [ \t\r\n\u000C]+ -> skip;

// Identifier
IDENTIFIER: [A-Za-z_][A-Za-z0-9_]*;

