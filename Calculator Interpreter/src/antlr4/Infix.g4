grammar Infix;

input:
    (expression)*
    ;
expression:
    term
    | expression HIGHOP expression
    | expression LOWOP expression
    | command
    ;
term:
    LPAREN expression RPAREN
    | INTEGER
    ;
command:
    identifier EQUALS expression
    | identifier
    ;
identifier:
    IDENTIFIER
    ;

DOT: '.';
INTEGER: [0-9]+ (DOT [0-9+]+)?;
IDENTIFIER: [a-z]([a-zA-Z0-9]*);
HIGHOP: '/' | '*';
LOWOP: '+' | '-';
LPAREN: '(';
RPAREN: ')';
EQUALS: '=';
WHITESPACE: [ \t\r\n]+ -> skip;