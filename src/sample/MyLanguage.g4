grammar MyLanguage;

program: commandlines*;

commandlines: (command | structure)+ ;

structure: branch | cycle ;

branch: 'if' '[' equality ']' 'then' '[' commandlines ']' elseStatement?;

elseStatement: 'else' '[' commandlines ']' ;

cycle: 'repeat' '[' commandlines ']' 'for' '[' NUMBER ']' ;

equality: getColor '=' color;

command: goThere | pushIt | eatIt | getColor | turnLeft | turnRight ;

goThere: 'go' '(' NUMBER ')';
pushIt: 'push' '(' ')';
eatIt: 'eat' '(' ')';
getColor: 'myColor' '(' ')';
turnLeft: 'turnLeft' '(' NUMBER ')';
turnRight: 'turnRight' '(' NUMBER ')';

color: YELLOW | RED | BLUE | GREEN | NONE | PURPLE;

//színek
YELLOW: 'yellow';
RED: 'red';
BLUE: 'blue';
GREEN: 'green';
PURPLE: 'purple';
NONE: 'none';

//használt kifejezések
IF: 'if';
THEN: 'then';
ELSE: 'else';
REPEAT: 'repeat';
FOR: 'for';

GO: 'go';
TURNLEFT: 'turnLeft';
TURNRIGHT: 'turnRight';
PUSH: 'push';
EAT: 'eat';
MYCOLOR: 'myColor';

EQUAL: '=';

SQUARE1: '[';
SQUARE2: ']';
BRACKET1: '(';
BRACKET2: ')';

NUMBER: [0-9]+ ;
SKIPER: (' ' | '\n' | '\t' | '\r') -> skip;