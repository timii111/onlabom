// Generated from C:/Users/Timi/IdeaProjects/szakdoga/src/sample/boardgenerating\BoardLanguage.g4 by ANTLR 4.7.2
package sample.boardgenerating.languageelements;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BoardLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		START=1, SIZE=2, PATH=3, WATER=4, END=5, KEY=6, BUTTON=7, YELLOW=8, RED=9, 
		BLUE=10, GREEN=11, PURPLE=12, NUMBER=13, SKIPER=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"START", "SIZE", "PATH", "WATER", "END", "KEY", "BUTTON", "YELLOW", "RED", 
			"BLUE", "GREEN", "PURPLE", "NUMBER", "SKIPER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'start'", "'size'", "'path'", "'water'", "'end'", "'key'", "'button'", 
			"'yellow'", "'red'", "'blue'", "'green'", "'purple'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "START", "SIZE", "PATH", "WATER", "END", "KEY", "BUTTON", "YELLOW", 
			"RED", "BLUE", "GREEN", "PURPLE", "NUMBER", "SKIPER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public BoardLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BoardLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20j\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\6\16c\n\16\r\16\16\16d\3\17\3\17\3"+
		"\17\3\17\2\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\3\2\4\3\2\62;\5\2\13\f\17\17\"\"\2j\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5%\3\2\2\2\7*\3\2\2\2\t/\3\2\2\2\13\65"+
		"\3\2\2\2\r9\3\2\2\2\17=\3\2\2\2\21D\3\2\2\2\23K\3\2\2\2\25O\3\2\2\2\27"+
		"T\3\2\2\2\31Z\3\2\2\2\33b\3\2\2\2\35f\3\2\2\2\37 \7u\2\2 !\7v\2\2!\"\7"+
		"c\2\2\"#\7t\2\2#$\7v\2\2$\4\3\2\2\2%&\7u\2\2&\'\7k\2\2\'(\7|\2\2()\7g"+
		"\2\2)\6\3\2\2\2*+\7r\2\2+,\7c\2\2,-\7v\2\2-.\7j\2\2.\b\3\2\2\2/\60\7y"+
		"\2\2\60\61\7c\2\2\61\62\7v\2\2\62\63\7g\2\2\63\64\7t\2\2\64\n\3\2\2\2"+
		"\65\66\7g\2\2\66\67\7p\2\2\678\7f\2\28\f\3\2\2\29:\7m\2\2:;\7g\2\2;<\7"+
		"{\2\2<\16\3\2\2\2=>\7d\2\2>?\7w\2\2?@\7v\2\2@A\7v\2\2AB\7q\2\2BC\7p\2"+
		"\2C\20\3\2\2\2DE\7{\2\2EF\7g\2\2FG\7n\2\2GH\7n\2\2HI\7q\2\2IJ\7y\2\2J"+
		"\22\3\2\2\2KL\7t\2\2LM\7g\2\2MN\7f\2\2N\24\3\2\2\2OP\7d\2\2PQ\7n\2\2Q"+
		"R\7w\2\2RS\7g\2\2S\26\3\2\2\2TU\7i\2\2UV\7t\2\2VW\7g\2\2WX\7g\2\2XY\7"+
		"p\2\2Y\30\3\2\2\2Z[\7r\2\2[\\\7w\2\2\\]\7t\2\2]^\7r\2\2^_\7n\2\2_`\7g"+
		"\2\2`\32\3\2\2\2ac\t\2\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2e\34"+
		"\3\2\2\2fg\t\3\2\2gh\3\2\2\2hi\b\17\2\2i\36\3\2\2\2\4\2d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}