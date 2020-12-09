grammar StackCode;

input:
    (statement)*
    ;
statement:
    push
    | operation
    ;
operation:
    WORD SEMICOLON
    ;
push:
    WORD INTEGER SEMICOLON
    ;

WORD: [A-Z]+;
DOT: '.';
INTEGER: [0-9]+ (DOT [0-9]+)?;
PUSH: 'PUSH';
SEMICOLON: ';';
WHITESPACE: [ \t\r\n]+ -> skip;