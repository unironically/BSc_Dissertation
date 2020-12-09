BNF Syntax
 ==========
### Brief
Below listed is the syntax for BNF specifications supported by this program:
- Non-terminal/identifier - ```identifier_name```
- Terminal - ```'terminal'```
- Empty character - ```#```
- 'Or' clause - ```clause | clause```
- Optional clause - ```[clause]```
- Group clause - ```(clause)```
- Positive closure - ```(clause)+``` (*one or more of clause*)
- Kleene closure - ```{clause}``` or ```(clause)*``` (*zero or more of clause*)
- Comment - ```(*this is a comment*)```

*'Clause' here referring to any of the syntax referred to across all above points -
(non-terminal/terminal/empty character/or clause/optional clause/group clause/positive closure/kleene closure).*
### Example
*sample.bnf*:
```
(* Before comment! *)
start ::= '[' digit_list ']'. (* Test comment! *)
digit_list ::= digit digit_tail.
digit_tail ::= # | ',' digit_list.
digit ::= '0' | '1' | ('2' | 'two') | '3' | '4' | '5' | '6' | '7'  | '8' | '9'.
(* After comment! *)
```
