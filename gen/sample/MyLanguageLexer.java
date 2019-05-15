// Generated from C:/Users/Timi/IdeaProjects/szakdoga/src/sample\MyLanguage.g4 by ANTLR 4.7.2
package sample;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		YELLOW=1, RED=2, BLUE=3, GREEN=4, PURPLE=5, NONE=6, IF=7, THEN=8, ELSE=9, 
		REPEAT=10, FOR=11, GO=12, TURNLEFT=13, TURNRIGHT=14, PUSH=15, EAT=16, 
		MYCOLOR=17, DEF=18, EQUAL=19, SQUARE1=20, SQUARE2=21, BRACKET1=22, BRACKET2=23, 
		BRACE1=24, BARCE2=25, NUMBER=26, WORD=27, SKIPER=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"YELLOW", "RED", "BLUE", "GREEN", "PURPLE", "NONE", "IF", "THEN", "ELSE", 
			"REPEAT", "FOR", "GO", "TURNLEFT", "TURNRIGHT", "PUSH", "EAT", "MYCOLOR", 
			"DEF", "EQUAL", "SQUARE1", "SQUARE2", "BRACKET1", "BRACKET2", "BRACE1", 
			"BARCE2", "NUMBER", "WORD", "SKIPER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'yellow'", "'red'", "'blue'", "'green'", "'purple'", "'none'", 
			"'if'", "'then'", "'else'", "'repeat'", "'for'", "'go'", "'turnLeft'", 
			"'turnRight'", "'push'", "'eat'", "'myColor'", "'def'", "'='", "'['", 
			"']'", "'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "YELLOW", "RED", "BLUE", "GREEN", "PURPLE", "NONE", "IF", "THEN", 
			"ELSE", "REPEAT", "FOR", "GO", "TURNLEFT", "TURNRIGHT", "PUSH", "EAT", 
			"MYCOLOR", "DEF", "EQUAL", "SQUARE1", "SQUARE2", "BRACKET1", "BRACKET2", 
			"BRACE1", "BARCE2", "NUMBER", "WORD", "SKIPER"
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


	public MyLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MyLanguage.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u00bc\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3"+
		"\32\3\32\3\33\6\33\u00b0\n\33\r\33\16\33\u00b1\3\34\6\34\u00b5\n\34\r"+
		"\34\16\34\u00b6\3\35\3\35\3\35\3\35\2\2\36\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36\3\2\5\3\2\62;\3\2c|\5\2\13\f\17"+
		"\17\"\"\2\u00bd\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\3;\3\2\2\2\5B\3\2\2\2\7F\3\2\2\2\tK\3\2\2\2\13Q\3\2\2\2\rX\3"+
		"\2\2\2\17]\3\2\2\2\21`\3\2\2\2\23e\3\2\2\2\25j\3\2\2\2\27q\3\2\2\2\31"+
		"u\3\2\2\2\33x\3\2\2\2\35\u0081\3\2\2\2\37\u008b\3\2\2\2!\u0090\3\2\2\2"+
		"#\u0094\3\2\2\2%\u009c\3\2\2\2\'\u00a0\3\2\2\2)\u00a2\3\2\2\2+\u00a4\3"+
		"\2\2\2-\u00a6\3\2\2\2/\u00a8\3\2\2\2\61\u00aa\3\2\2\2\63\u00ac\3\2\2\2"+
		"\65\u00af\3\2\2\2\67\u00b4\3\2\2\29\u00b8\3\2\2\2;<\7{\2\2<=\7g\2\2=>"+
		"\7n\2\2>?\7n\2\2?@\7q\2\2@A\7y\2\2A\4\3\2\2\2BC\7t\2\2CD\7g\2\2DE\7f\2"+
		"\2E\6\3\2\2\2FG\7d\2\2GH\7n\2\2HI\7w\2\2IJ\7g\2\2J\b\3\2\2\2KL\7i\2\2"+
		"LM\7t\2\2MN\7g\2\2NO\7g\2\2OP\7p\2\2P\n\3\2\2\2QR\7r\2\2RS\7w\2\2ST\7"+
		"t\2\2TU\7r\2\2UV\7n\2\2VW\7g\2\2W\f\3\2\2\2XY\7p\2\2YZ\7q\2\2Z[\7p\2\2"+
		"[\\\7g\2\2\\\16\3\2\2\2]^\7k\2\2^_\7h\2\2_\20\3\2\2\2`a\7v\2\2ab\7j\2"+
		"\2bc\7g\2\2cd\7p\2\2d\22\3\2\2\2ef\7g\2\2fg\7n\2\2gh\7u\2\2hi\7g\2\2i"+
		"\24\3\2\2\2jk\7t\2\2kl\7g\2\2lm\7r\2\2mn\7g\2\2no\7c\2\2op\7v\2\2p\26"+
		"\3\2\2\2qr\7h\2\2rs\7q\2\2st\7t\2\2t\30\3\2\2\2uv\7i\2\2vw\7q\2\2w\32"+
		"\3\2\2\2xy\7v\2\2yz\7w\2\2z{\7t\2\2{|\7p\2\2|}\7N\2\2}~\7g\2\2~\177\7"+
		"h\2\2\177\u0080\7v\2\2\u0080\34\3\2\2\2\u0081\u0082\7v\2\2\u0082\u0083"+
		"\7w\2\2\u0083\u0084\7t\2\2\u0084\u0085\7p\2\2\u0085\u0086\7T\2\2\u0086"+
		"\u0087\7k\2\2\u0087\u0088\7i\2\2\u0088\u0089\7j\2\2\u0089\u008a\7v\2\2"+
		"\u008a\36\3\2\2\2\u008b\u008c\7r\2\2\u008c\u008d\7w\2\2\u008d\u008e\7"+
		"u\2\2\u008e\u008f\7j\2\2\u008f \3\2\2\2\u0090\u0091\7g\2\2\u0091\u0092"+
		"\7c\2\2\u0092\u0093\7v\2\2\u0093\"\3\2\2\2\u0094\u0095\7o\2\2\u0095\u0096"+
		"\7{\2\2\u0096\u0097\7E\2\2\u0097\u0098\7q\2\2\u0098\u0099\7n\2\2\u0099"+
		"\u009a\7q\2\2\u009a\u009b\7t\2\2\u009b$\3\2\2\2\u009c\u009d\7f\2\2\u009d"+
		"\u009e\7g\2\2\u009e\u009f\7h\2\2\u009f&\3\2\2\2\u00a0\u00a1\7?\2\2\u00a1"+
		"(\3\2\2\2\u00a2\u00a3\7]\2\2\u00a3*\3\2\2\2\u00a4\u00a5\7_\2\2\u00a5,"+
		"\3\2\2\2\u00a6\u00a7\7*\2\2\u00a7.\3\2\2\2\u00a8\u00a9\7+\2\2\u00a9\60"+
		"\3\2\2\2\u00aa\u00ab\7}\2\2\u00ab\62\3\2\2\2\u00ac\u00ad\7\177\2\2\u00ad"+
		"\64\3\2\2\2\u00ae\u00b0\t\2\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b1\3\2\2"+
		"\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\66\3\2\2\2\u00b3\u00b5"+
		"\t\3\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b78\3\2\2\2\u00b8\u00b9\t\4\2\2\u00b9\u00ba\3\2\2\2"+
		"\u00ba\u00bb\b\35\2\2\u00bb:\3\2\2\2\5\2\u00b1\u00b6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}