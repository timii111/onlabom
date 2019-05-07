// Generated from C:/Users/Timi/IdeaProjects/szakdoga/src/sample/boardgenerating\BoardLanguage.g4 by ANTLR 4.7.2
package sample.boardgenerating.languageelements;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BoardLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		START=1, SIZE=2, PATH=3, WATER=4, END=5, KEY=6, BUTTON=7, YELLOW=8, RED=9, 
		BLUE=10, GREEN=11, PURPLE=12, NONE=13, NUMBER=14, SKIPER=15;
	public static final int
		RULE_program = 0, RULE_startTile = 1, RULE_sizes = 2, RULE_end = 3, RULE_tileCommand = 4, 
		RULE_coords = 5, RULE_addExtra = 6, RULE_boardTile = 7, RULE_extra = 8, 
		RULE_color = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "startTile", "sizes", "end", "tileCommand", "coords", "addExtra", 
			"boardTile", "extra", "color"
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

	@Override
	public String getGrammarFileName() { return "BoardLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BoardLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public StartTileContext startTile() {
			return getRuleContext(StartTileContext.class,0);
		}
		public SizesContext sizes() {
			return getRuleContext(SizesContext.class,0);
		}
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public List<TileCommandContext> tileCommand() {
			return getRuleContexts(TileCommandContext.class);
		}
		public TileCommandContext tileCommand(int i) {
			return getRuleContext(TileCommandContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardLanguageVisitor ) return ((BoardLanguageVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			startTile();
			setState(21);
			sizes();
			setState(22);
			end();
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NUMBER) {
				{
				{
				setState(23);
				tileCommand();
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StartTileContext extends ParserRuleContext {
		public TerminalNode START() { return getToken(BoardLanguageParser.START, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(BoardLanguageParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(BoardLanguageParser.NUMBER, i);
		}
		public StartTileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startTile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).enterStartTile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).exitStartTile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardLanguageVisitor ) return ((BoardLanguageVisitor<? extends T>)visitor).visitStartTile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartTileContext startTile() throws RecognitionException {
		StartTileContext _localctx = new StartTileContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_startTile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(START);
			setState(30);
			match(NUMBER);
			setState(31);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SizesContext extends ParserRuleContext {
		public TerminalNode SIZE() { return getToken(BoardLanguageParser.SIZE, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(BoardLanguageParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(BoardLanguageParser.NUMBER, i);
		}
		public SizesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sizes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).enterSizes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).exitSizes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardLanguageVisitor ) return ((BoardLanguageVisitor<? extends T>)visitor).visitSizes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SizesContext sizes() throws RecognitionException {
		SizesContext _localctx = new SizesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sizes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(SIZE);
			setState(34);
			match(NUMBER);
			setState(35);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EndContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(BoardLanguageParser.END, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(BoardLanguageParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(BoardLanguageParser.NUMBER, i);
		}
		public EndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).enterEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).exitEnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardLanguageVisitor ) return ((BoardLanguageVisitor<? extends T>)visitor).visitEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndContext end() throws RecognitionException {
		EndContext _localctx = new EndContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(END);
			setState(38);
			match(NUMBER);
			setState(39);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TileCommandContext extends ParserRuleContext {
		public CoordsContext coords() {
			return getRuleContext(CoordsContext.class,0);
		}
		public BoardTileContext boardTile() {
			return getRuleContext(BoardTileContext.class,0);
		}
		public AddExtraContext addExtra() {
			return getRuleContext(AddExtraContext.class,0);
		}
		public TileCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tileCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).enterTileCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).exitTileCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardLanguageVisitor ) return ((BoardLanguageVisitor<? extends T>)visitor).visitTileCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TileCommandContext tileCommand() throws RecognitionException {
		TileCommandContext _localctx = new TileCommandContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tileCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			coords();
			setState(42);
			boardTile();
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEY || _la==BUTTON) {
				{
				setState(43);
				addExtra();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CoordsContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(BoardLanguageParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(BoardLanguageParser.NUMBER, i);
		}
		public CoordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coords; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).enterCoords(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).exitCoords(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardLanguageVisitor ) return ((BoardLanguageVisitor<? extends T>)visitor).visitCoords(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoordsContext coords() throws RecognitionException {
		CoordsContext _localctx = new CoordsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_coords);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(NUMBER);
			setState(47);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddExtraContext extends ParserRuleContext {
		public ExtraContext extra() {
			return getRuleContext(ExtraContext.class,0);
		}
		public ColorContext color() {
			return getRuleContext(ColorContext.class,0);
		}
		public AddExtraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExtra; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).enterAddExtra(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).exitAddExtra(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardLanguageVisitor ) return ((BoardLanguageVisitor<? extends T>)visitor).visitAddExtra(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddExtraContext addExtra() throws RecognitionException {
		AddExtraContext _localctx = new AddExtraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_addExtra);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			extra();
			setState(50);
			color();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoardTileContext extends ParserRuleContext {
		public TerminalNode PATH() { return getToken(BoardLanguageParser.PATH, 0); }
		public TerminalNode WATER() { return getToken(BoardLanguageParser.WATER, 0); }
		public BoardTileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boardTile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).enterBoardTile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).exitBoardTile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardLanguageVisitor ) return ((BoardLanguageVisitor<? extends T>)visitor).visitBoardTile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoardTileContext boardTile() throws RecognitionException {
		BoardTileContext _localctx = new BoardTileContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_boardTile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_la = _input.LA(1);
			if ( !(_la==PATH || _la==WATER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExtraContext extends ParserRuleContext {
		public TerminalNode KEY() { return getToken(BoardLanguageParser.KEY, 0); }
		public TerminalNode BUTTON() { return getToken(BoardLanguageParser.BUTTON, 0); }
		public ExtraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extra; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).enterExtra(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).exitExtra(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardLanguageVisitor ) return ((BoardLanguageVisitor<? extends T>)visitor).visitExtra(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtraContext extra() throws RecognitionException {
		ExtraContext _localctx = new ExtraContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_extra);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_la = _input.LA(1);
			if ( !(_la==KEY || _la==BUTTON) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColorContext extends ParserRuleContext {
		public TerminalNode YELLOW() { return getToken(BoardLanguageParser.YELLOW, 0); }
		public TerminalNode RED() { return getToken(BoardLanguageParser.RED, 0); }
		public TerminalNode BLUE() { return getToken(BoardLanguageParser.BLUE, 0); }
		public TerminalNode GREEN() { return getToken(BoardLanguageParser.GREEN, 0); }
		public TerminalNode NONE() { return getToken(BoardLanguageParser.NONE, 0); }
		public TerminalNode PURPLE() { return getToken(BoardLanguageParser.PURPLE, 0); }
		public ColorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_color; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).enterColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardLanguageListener ) ((BoardLanguageListener)listener).exitColor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardLanguageVisitor ) return ((BoardLanguageVisitor<? extends T>)visitor).visitColor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorContext color() throws RecognitionException {
		ColorContext _localctx = new ColorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_color);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << YELLOW) | (1L << RED) | (1L << BLUE) | (1L << GREEN) | (1L << PURPLE) | (1L << NONE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\21=\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\3\2\3\2\7\2\33\n\2\f\2\16\2\36\13\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\5\6/\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\5\3\2\5\6"+
		"\3\2\b\t\3\2\n\17\2\64\2\26\3\2\2\2\4\37\3\2\2\2\6#\3\2\2\2\b\'\3\2\2"+
		"\2\n+\3\2\2\2\f\60\3\2\2\2\16\63\3\2\2\2\20\66\3\2\2\2\228\3\2\2\2\24"+
		":\3\2\2\2\26\27\5\4\3\2\27\30\5\6\4\2\30\34\5\b\5\2\31\33\5\n\6\2\32\31"+
		"\3\2\2\2\33\36\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\3\3\2\2\2\36\34"+
		"\3\2\2\2\37 \7\3\2\2 !\7\20\2\2!\"\7\20\2\2\"\5\3\2\2\2#$\7\4\2\2$%\7"+
		"\20\2\2%&\7\20\2\2&\7\3\2\2\2\'(\7\7\2\2()\7\20\2\2)*\7\20\2\2*\t\3\2"+
		"\2\2+,\5\f\7\2,.\5\20\t\2-/\5\16\b\2.-\3\2\2\2./\3\2\2\2/\13\3\2\2\2\60"+
		"\61\7\20\2\2\61\62\7\20\2\2\62\r\3\2\2\2\63\64\5\22\n\2\64\65\5\24\13"+
		"\2\65\17\3\2\2\2\66\67\t\2\2\2\67\21\3\2\2\289\t\3\2\29\23\3\2\2\2:;\t"+
		"\4\2\2;\25\3\2\2\2\4\34.";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}