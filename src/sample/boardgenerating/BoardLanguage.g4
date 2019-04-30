grammar BoardLanguage;

program: startTile sizes (tileCommand)*;

startTile: START NUMBER NUMBER;

sizes: SIZE NUMBER NUMBER;

tileCommand: boardTile addExtra?;

addExtra: extra color;

boardTile: PATH | WATER | END;

extra: KEY | BUTTON;

color: YELLOW | RED | BLUE | GREEN | NONE | PURPLE;

//játékeíró elemek
START: 'start';
SIZE: 'size';

//pályaelemtípusok
PATH: 'path';
WATER: 'water';
END: 'end';

//plusz elemek
KEY: 'key';
BUTTON: 'button';

//színek
YELLOW: 'yellow';
RED: 'red';
BLUE: 'blue';
GREEN: 'green';
PURPLE: 'purple';
NONE: 'none';

NUMBER: [0-9]+ ;
SKIPER: (' ' | '\n' | '\t' | '\r') -> skip;