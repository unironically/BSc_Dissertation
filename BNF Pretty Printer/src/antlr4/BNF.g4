/**
* Implementation of a BNF specification of the form 'head ::= body' using ANTLR4.
* Supported BNF syntax as described in Section 3.6: [http://www.cs.rhul.ac.uk/courses/CS3480/partialbook.pdf]
* Not including RDP syntax
* @author Luke Bessant
*/

grammar BNF;
spec: comment? (production)*; // Start symbol
production: nonterminal HASFORM choices FSTOP comment?;
choices: choice (BAR choice)*;
choice: (group | kleene | optional | positive | nonterminal | terminal | empty)*;
group: (LPAREN choices RPAREN);
kleene: (LBRACE choices RBRACE) | (LPAREN choices RPAREN ASTERISK);
optional: (LSQUARE choices RSQUARE) | (LPAREN choices RPAREN QMARK);
positive: (LPAREN choices RPAREN PLUS);
nonterminal: IDENTIFIER;
terminal: TERMINAL;
empty: HASH;
comment: COMMENT;

TERMINAL: ('\'' TEXT '\'') | ('"' TEXT '"');
IDENTIFIER: ([a-z] | [A-Z] | [0-9] | '_')+;
COMMENT: ('(*' TEXT '*)');
TEXT: .*?;
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
LSQUARE: '[';
RSQUARE: ']';
QMARK: '?';
ASTERISK: '*';
PLUS: '+';
BAR: '|';
HASH: '#';
HASFORM: '::=';
FSTOP: '.';
WHITESPACE: [ \t\r\n]+ -> skip ;