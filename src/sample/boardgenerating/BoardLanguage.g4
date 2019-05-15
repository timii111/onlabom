grammar BoardLanguage;

program: startTile sizes end (tileCommand)*;

startTile: START NUMBER NUMBER;

sizes: SIZE NUMBER NUMBER;

end: END NUMBER NUMBER;

tileCommand: coords boardTile addExtra?;

coords: NUMBER NUMBER;

addExtra: extra color;

boardTile: PATH | WATER;

extra: KEY | BUTTON;

color: YELLOW | RED | BLUE | GREEN | PURPLE;

//játékleíró elemek
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

NUMBER: [0-9]+ ;
SKIPER: (' ' | '\n' | '\t' | '\r') -> skip;