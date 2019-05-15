// Generated from C:/Users/Timi/IdeaProjects/szakdoga/src/sample/boardgenerating\BoardLanguage.g4 by ANTLR 4.7.2
package sample.boardgenerating;
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
		BLUE=10, GREEN=11, PURPLE=12, NONE=13, NUMBER=14, SKIPER=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"START", "SIZE", "PATH", "WATER", "END", "KEY", "BUTTON", "YELLOW", "RED", 
			"BLUE", "GREEN", "PURPLE", "NONE", "NUMBER", "SKIPER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'start'", "'size'", "'path'", "'water'", "'end'", "'key'", "'button'", 
			"'yellow'", "'red'", "'blue'", "'green'", "'purple'", "'none'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "START", "SIZE", "PATH", "WATER", "END", "KEY", "BUTTON", "YELLOW", 
			"RED", "BLUE", "GREEN", "PURPLE", "NONE", "NUMBER", "SKIPER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21q\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\6\17j\n\17\r\17\16\17k\3\20\3\20\3\20\3\20\2\2\21\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21\3\2\4\3\2\62"+
		";\5\2\13\f\17\17\"\"\2q\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\3!\3\2\2\2\5\'\3\2\2\2\7,\3\2\2\2\t\61\3\2\2\2\13\67\3\2\2\2\r;\3"+
		"\2\2\2\17?\3\2\2\2\21F\3\2\2\2\23M\3\2\2\2\25Q\3\2\2\2\27V\3\2\2\2\31"+
		"\\\3\2\2\2\33c\3\2\2\2\35i\3\2\2\2\37m\3\2\2\2!\"\7u\2\2\"#\7v\2\2#$\7"+
		"c\2\2$%\7t\2\2%&\7v\2\2&\4\3\2\2\2\'(\7u\2\2()\7k\2\2)*\7|\2\2*+\7g\2"+
		"\2+\6\3\2\2\2,-\7r\2\2-.\7c\2\2./\7v\2\2/\60\7j\2\2\60\b\3\2\2\2\61\62"+
		"\7y\2\2\62\63\7c\2\2\63\64\7v\2\2\64\65\7g\2\2\65\66\7t\2\2\66\n\3\2\2"+
		"\2\678\7g\2\289\7p\2\29:\7f\2\2:\f\3\2\2\2;<\7m\2\2<=\7g\2\2=>\7{\2\2"+
		">\16\3\2\2\2?@\7d\2\2@A\7w\2\2AB\7v\2\2BC\7v\2\2CD\7q\2\2DE\7p\2\2E\20"+
		"\3\2\2\2FG\7{\2\2GH\7g\2\2HI\7n\2\2IJ\7n\2\2JK\7q\2\2KL\7y\2\2L\22\3\2"+
		"\2\2MN\7t\2\2NO\7g\2\2OP\7f\2\2P\24\3\2\2\2QR\7d\2\2RS\7n\2\2ST\7w\2\2"+
		"TU\7g\2\2U\26\3\2\2\2VW\7i\2\2WX\7t\2\2XY\7g\2\2YZ\7g\2\2Z[\7p\2\2[\30"+
		"\3\2\2\2\\]\7r\2\2]^\7w\2\2^_\7t\2\2_`\7r\2\2`a\7n\2\2ab\7g\2\2b\32\3"+
		"\2\2\2cd\7p\2\2de\7q\2\2ef\7p\2\2fg\7g\2\2g\34\3\2\2\2hj\t\2\2\2ih\3\2"+
		"\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\36\3\2\2\2mn\t\3\2\2no\3\2\2\2op\b"+
		"\20\2\2p \3\2\2\2\4\2k\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}