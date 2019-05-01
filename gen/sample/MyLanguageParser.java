// Generated from C:/Users/Timi/IdeaProjects/szakdoga/src/sample\MyLanguage.g4 by ANTLR 4.7.2
package sample;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		YELLOW=1, RED=2, BLUE=3, GREEN=4, PURPLE=5, NONE=6, IF=7, THEN=8, ELSE=9, 
		REPEAT=10, FOR=11, GO=12, TURNLEFT=13, TURNRIGHT=14, PUSH=15, EAT=16, 
		MYCOLOR=17, DEF=18, EQUAL=19, SQUARE1=20, SQUARE2=21, BRACKET1=22, BRACKET2=23, 
		BRACE1=24, BARCE2=25, NUMBER=26, WORD=27, SKIPER=28;
	public static final int
		RULE_program = 0, RULE_commandlines = 1, RULE_structure = 2, RULE_branch = 3, 
		RULE_elseStatement = 4, RULE_cycle = 5, RULE_equality = 6, RULE_command = 7, 
		RULE_goThere = 8, RULE_pushIt = 9, RULE_eatIt = 10, RULE_getColor = 11, 
		RULE_turnLeft = 12, RULE_turnRight = 13, RULE_function_def = 14, RULE_function_call = 15, 
		RULE_buzzwords = 16, RULE_color = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "commandlines", "structure", "branch", "elseStatement", "cycle", 
			"equality", "command", "goThere", "pushIt", "eatIt", "getColor", "turnLeft", 
			"turnRight", "function_def", "function_call", "buzzwords", "color"
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

	@Override
	public String getGrammarFileName() { return "MyLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MyLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<Function_defContext> function_def() {
			return getRuleContexts(Function_defContext.class);
		}
		public Function_defContext function_def(int i) {
			return getRuleContext(Function_defContext.class,i);
		}
		public List<CommandlinesContext> commandlines() {
			return getRuleContexts(CommandlinesContext.class);
		}
		public CommandlinesContext commandlines(int i) {
			return getRuleContext(CommandlinesContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEF) {
				{
				{
				setState(36);
				function_def();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << REPEAT) | (1L << GO) | (1L << TURNLEFT) | (1L << TURNRIGHT) | (1L << PUSH) | (1L << EAT) | (1L << MYCOLOR) | (1L << WORD))) != 0)) {
				{
				{
				setState(42);
				commandlines();
				}
				}
				setState(47);
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

	public static class CommandlinesContext extends ParserRuleContext {
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<StructureContext> structure() {
			return getRuleContexts(StructureContext.class);
		}
		public StructureContext structure(int i) {
			return getRuleContext(StructureContext.class,i);
		}
		public CommandlinesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commandlines; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterCommandlines(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitCommandlines(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitCommandlines(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandlinesContext commandlines() throws RecognitionException {
		CommandlinesContext _localctx = new CommandlinesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_commandlines);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(50);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case GO:
					case TURNLEFT:
					case TURNRIGHT:
					case PUSH:
					case EAT:
					case MYCOLOR:
					case WORD:
						{
						setState(48);
						command();
						}
						break;
					case IF:
					case REPEAT:
						{
						setState(49);
						structure();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(52); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class StructureContext extends ParserRuleContext {
		public BranchContext branch() {
			return getRuleContext(BranchContext.class,0);
		}
		public CycleContext cycle() {
			return getRuleContext(CycleContext.class,0);
		}
		public StructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitStructure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructureContext structure() throws RecognitionException {
		StructureContext _localctx = new StructureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_structure);
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				branch();
				}
				break;
			case REPEAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				cycle();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class BranchContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MyLanguageParser.IF, 0); }
		public List<TerminalNode> SQUARE1() { return getTokens(MyLanguageParser.SQUARE1); }
		public TerminalNode SQUARE1(int i) {
			return getToken(MyLanguageParser.SQUARE1, i);
		}
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public List<TerminalNode> SQUARE2() { return getTokens(MyLanguageParser.SQUARE2); }
		public TerminalNode SQUARE2(int i) {
			return getToken(MyLanguageParser.SQUARE2, i);
		}
		public TerminalNode THEN() { return getToken(MyLanguageParser.THEN, 0); }
		public CommandlinesContext commandlines() {
			return getRuleContext(CommandlinesContext.class,0);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public BranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterBranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitBranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchContext branch() throws RecognitionException {
		BranchContext _localctx = new BranchContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_branch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(IF);
			setState(59);
			match(SQUARE1);
			setState(60);
			equality();
			setState(61);
			match(SQUARE2);
			setState(62);
			match(THEN);
			setState(63);
			match(SQUARE1);
			setState(64);
			commandlines();
			setState(65);
			match(SQUARE2);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(66);
				elseStatement();
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

	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(MyLanguageParser.ELSE, 0); }
		public TerminalNode SQUARE1() { return getToken(MyLanguageParser.SQUARE1, 0); }
		public CommandlinesContext commandlines() {
			return getRuleContext(CommandlinesContext.class,0);
		}
		public TerminalNode SQUARE2() { return getToken(MyLanguageParser.SQUARE2, 0); }
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(ELSE);
			setState(70);
			match(SQUARE1);
			setState(71);
			commandlines();
			setState(72);
			match(SQUARE2);
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

	public static class CycleContext extends ParserRuleContext {
		public TerminalNode REPEAT() { return getToken(MyLanguageParser.REPEAT, 0); }
		public List<TerminalNode> SQUARE1() { return getTokens(MyLanguageParser.SQUARE1); }
		public TerminalNode SQUARE1(int i) {
			return getToken(MyLanguageParser.SQUARE1, i);
		}
		public CommandlinesContext commandlines() {
			return getRuleContext(CommandlinesContext.class,0);
		}
		public List<TerminalNode> SQUARE2() { return getTokens(MyLanguageParser.SQUARE2); }
		public TerminalNode SQUARE2(int i) {
			return getToken(MyLanguageParser.SQUARE2, i);
		}
		public TerminalNode FOR() { return getToken(MyLanguageParser.FOR, 0); }
		public TerminalNode NUMBER() { return getToken(MyLanguageParser.NUMBER, 0); }
		public CycleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cycle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterCycle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitCycle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitCycle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CycleContext cycle() throws RecognitionException {
		CycleContext _localctx = new CycleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cycle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(REPEAT);
			setState(75);
			match(SQUARE1);
			setState(76);
			commandlines();
			setState(77);
			match(SQUARE2);
			setState(78);
			match(FOR);
			setState(79);
			match(SQUARE1);
			setState(80);
			match(NUMBER);
			setState(81);
			match(SQUARE2);
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

	public static class EqualityContext extends ParserRuleContext {
		public GetColorContext getColor() {
			return getRuleContext(GetColorContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(MyLanguageParser.EQUAL, 0); }
		public ColorContext color() {
			return getRuleContext(ColorContext.class,0);
		}
		public EqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitEquality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitEquality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityContext equality() throws RecognitionException {
		EqualityContext _localctx = new EqualityContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_equality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			getColor();
			setState(84);
			match(EQUAL);
			setState(85);
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

	public static class CommandContext extends ParserRuleContext {
		public GoThereContext goThere() {
			return getRuleContext(GoThereContext.class,0);
		}
		public PushItContext pushIt() {
			return getRuleContext(PushItContext.class,0);
		}
		public EatItContext eatIt() {
			return getRuleContext(EatItContext.class,0);
		}
		public GetColorContext getColor() {
			return getRuleContext(GetColorContext.class,0);
		}
		public TurnLeftContext turnLeft() {
			return getRuleContext(TurnLeftContext.class,0);
		}
		public TurnRightContext turnRight() {
			return getRuleContext(TurnRightContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_command);
		try {
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GO:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				goThere();
				}
				break;
			case PUSH:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				pushIt();
				}
				break;
			case EAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				eatIt();
				}
				break;
			case MYCOLOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(90);
				getColor();
				}
				break;
			case TURNLEFT:
				enterOuterAlt(_localctx, 5);
				{
				setState(91);
				turnLeft();
				}
				break;
			case TURNRIGHT:
				enterOuterAlt(_localctx, 6);
				{
				setState(92);
				turnRight();
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 7);
				{
				setState(93);
				function_call();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class GoThereContext extends ParserRuleContext {
		public TerminalNode GO() { return getToken(MyLanguageParser.GO, 0); }
		public TerminalNode BRACKET1() { return getToken(MyLanguageParser.BRACKET1, 0); }
		public TerminalNode NUMBER() { return getToken(MyLanguageParser.NUMBER, 0); }
		public TerminalNode BRACKET2() { return getToken(MyLanguageParser.BRACKET2, 0); }
		public GoThereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goThere; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterGoThere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitGoThere(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitGoThere(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GoThereContext goThere() throws RecognitionException {
		GoThereContext _localctx = new GoThereContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_goThere);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(GO);
			setState(97);
			match(BRACKET1);
			setState(98);
			match(NUMBER);
			setState(99);
			match(BRACKET2);
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

	public static class PushItContext extends ParserRuleContext {
		public TerminalNode PUSH() { return getToken(MyLanguageParser.PUSH, 0); }
		public TerminalNode BRACKET1() { return getToken(MyLanguageParser.BRACKET1, 0); }
		public TerminalNode BRACKET2() { return getToken(MyLanguageParser.BRACKET2, 0); }
		public PushItContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pushIt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterPushIt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitPushIt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitPushIt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PushItContext pushIt() throws RecognitionException {
		PushItContext _localctx = new PushItContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_pushIt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(PUSH);
			setState(102);
			match(BRACKET1);
			setState(103);
			match(BRACKET2);
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

	public static class EatItContext extends ParserRuleContext {
		public TerminalNode EAT() { return getToken(MyLanguageParser.EAT, 0); }
		public TerminalNode BRACKET1() { return getToken(MyLanguageParser.BRACKET1, 0); }
		public TerminalNode BRACKET2() { return getToken(MyLanguageParser.BRACKET2, 0); }
		public EatItContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eatIt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterEatIt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitEatIt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitEatIt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EatItContext eatIt() throws RecognitionException {
		EatItContext _localctx = new EatItContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_eatIt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(EAT);
			setState(106);
			match(BRACKET1);
			setState(107);
			match(BRACKET2);
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

	public static class GetColorContext extends ParserRuleContext {
		public TerminalNode MYCOLOR() { return getToken(MyLanguageParser.MYCOLOR, 0); }
		public TerminalNode BRACKET1() { return getToken(MyLanguageParser.BRACKET1, 0); }
		public TerminalNode BRACKET2() { return getToken(MyLanguageParser.BRACKET2, 0); }
		public GetColorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getColor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterGetColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitGetColor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitGetColor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GetColorContext getColor() throws RecognitionException {
		GetColorContext _localctx = new GetColorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_getColor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(MYCOLOR);
			setState(110);
			match(BRACKET1);
			setState(111);
			match(BRACKET2);
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

	public static class TurnLeftContext extends ParserRuleContext {
		public TerminalNode TURNLEFT() { return getToken(MyLanguageParser.TURNLEFT, 0); }
		public TerminalNode BRACKET1() { return getToken(MyLanguageParser.BRACKET1, 0); }
		public TerminalNode NUMBER() { return getToken(MyLanguageParser.NUMBER, 0); }
		public TerminalNode BRACKET2() { return getToken(MyLanguageParser.BRACKET2, 0); }
		public TurnLeftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_turnLeft; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterTurnLeft(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitTurnLeft(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitTurnLeft(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TurnLeftContext turnLeft() throws RecognitionException {
		TurnLeftContext _localctx = new TurnLeftContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_turnLeft);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(TURNLEFT);
			setState(114);
			match(BRACKET1);
			setState(115);
			match(NUMBER);
			setState(116);
			match(BRACKET2);
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

	public static class TurnRightContext extends ParserRuleContext {
		public TerminalNode TURNRIGHT() { return getToken(MyLanguageParser.TURNRIGHT, 0); }
		public TerminalNode BRACKET1() { return getToken(MyLanguageParser.BRACKET1, 0); }
		public TerminalNode NUMBER() { return getToken(MyLanguageParser.NUMBER, 0); }
		public TerminalNode BRACKET2() { return getToken(MyLanguageParser.BRACKET2, 0); }
		public TurnRightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_turnRight; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterTurnRight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitTurnRight(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitTurnRight(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TurnRightContext turnRight() throws RecognitionException {
		TurnRightContext _localctx = new TurnRightContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_turnRight);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(TURNRIGHT);
			setState(119);
			match(BRACKET1);
			setState(120);
			match(NUMBER);
			setState(121);
			match(BRACKET2);
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

	public static class Function_defContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(MyLanguageParser.DEF, 0); }
		public TerminalNode WORD() { return getToken(MyLanguageParser.WORD, 0); }
		public TerminalNode BRACKET1() { return getToken(MyLanguageParser.BRACKET1, 0); }
		public TerminalNode BRACKET2() { return getToken(MyLanguageParser.BRACKET2, 0); }
		public TerminalNode BRACE1() { return getToken(MyLanguageParser.BRACE1, 0); }
		public CommandlinesContext commandlines() {
			return getRuleContext(CommandlinesContext.class,0);
		}
		public TerminalNode BARCE2() { return getToken(MyLanguageParser.BARCE2, 0); }
		public Function_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterFunction_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitFunction_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitFunction_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_defContext function_def() throws RecognitionException {
		Function_defContext _localctx = new Function_defContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_function_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(DEF);
			setState(124);
			match(WORD);
			setState(125);
			match(BRACKET1);
			setState(126);
			match(BRACKET2);
			setState(127);
			match(BRACE1);
			setState(128);
			commandlines();
			setState(129);
			match(BARCE2);
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

	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(MyLanguageParser.WORD, 0); }
		public TerminalNode BRACKET1() { return getToken(MyLanguageParser.BRACKET1, 0); }
		public TerminalNode NUMBER() { return getToken(MyLanguageParser.NUMBER, 0); }
		public TerminalNode BRACKET2() { return getToken(MyLanguageParser.BRACKET2, 0); }
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitFunction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_function_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(WORD);
			setState(132);
			match(BRACKET1);
			setState(133);
			match(NUMBER);
			setState(134);
			match(BRACKET2);
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

	public static class BuzzwordsContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MyLanguageParser.IF, 0); }
		public TerminalNode THEN() { return getToken(MyLanguageParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(MyLanguageParser.ELSE, 0); }
		public TerminalNode REPEAT() { return getToken(MyLanguageParser.REPEAT, 0); }
		public TerminalNode FOR() { return getToken(MyLanguageParser.FOR, 0); }
		public TerminalNode GO() { return getToken(MyLanguageParser.GO, 0); }
		public TerminalNode TURNLEFT() { return getToken(MyLanguageParser.TURNLEFT, 0); }
		public TerminalNode TURNRIGHT() { return getToken(MyLanguageParser.TURNRIGHT, 0); }
		public TerminalNode PUSH() { return getToken(MyLanguageParser.PUSH, 0); }
		public TerminalNode EAT() { return getToken(MyLanguageParser.EAT, 0); }
		public TerminalNode MYCOLOR() { return getToken(MyLanguageParser.MYCOLOR, 0); }
		public TerminalNode DEF() { return getToken(MyLanguageParser.DEF, 0); }
		public BuzzwordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_buzzwords; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterBuzzwords(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitBuzzwords(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitBuzzwords(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuzzwordsContext buzzwords() throws RecognitionException {
		BuzzwordsContext _localctx = new BuzzwordsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_buzzwords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << THEN) | (1L << ELSE) | (1L << REPEAT) | (1L << FOR) | (1L << GO) | (1L << TURNLEFT) | (1L << TURNRIGHT) | (1L << PUSH) | (1L << EAT) | (1L << MYCOLOR) | (1L << DEF))) != 0)) ) {
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
		public TerminalNode YELLOW() { return getToken(MyLanguageParser.YELLOW, 0); }
		public TerminalNode RED() { return getToken(MyLanguageParser.RED, 0); }
		public TerminalNode BLUE() { return getToken(MyLanguageParser.BLUE, 0); }
		public TerminalNode GREEN() { return getToken(MyLanguageParser.GREEN, 0); }
		public TerminalNode NONE() { return getToken(MyLanguageParser.NONE, 0); }
		public TerminalNode PURPLE() { return getToken(MyLanguageParser.PURPLE, 0); }
		public ColorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_color; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitColor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitColor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorContext color() throws RecognitionException {
		ColorContext _localctx = new ColorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_color);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u008f\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\7\2.\n\2\f\2\16\2\61\13\2\3"+
		"\3\3\3\6\3\65\n\3\r\3\16\3\66\3\4\3\4\5\4;\n\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\5\5F\n\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\ta\n\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\2\2"+
		"\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\4\3\2\t\24\3\2\3\b\2"+
		"\u0088\2)\3\2\2\2\4\64\3\2\2\2\6:\3\2\2\2\b<\3\2\2\2\nG\3\2\2\2\fL\3\2"+
		"\2\2\16U\3\2\2\2\20`\3\2\2\2\22b\3\2\2\2\24g\3\2\2\2\26k\3\2\2\2\30o\3"+
		"\2\2\2\32s\3\2\2\2\34x\3\2\2\2\36}\3\2\2\2 \u0085\3\2\2\2\"\u008a\3\2"+
		"\2\2$\u008c\3\2\2\2&(\5\36\20\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2"+
		"\2\2*/\3\2\2\2+)\3\2\2\2,.\5\4\3\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60"+
		"\3\2\2\2\60\3\3\2\2\2\61/\3\2\2\2\62\65\5\20\t\2\63\65\5\6\4\2\64\62\3"+
		"\2\2\2\64\63\3\2\2\2\65\66\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\5\3"+
		"\2\2\28;\5\b\5\29;\5\f\7\2:8\3\2\2\2:9\3\2\2\2;\7\3\2\2\2<=\7\t\2\2=>"+
		"\7\26\2\2>?\5\16\b\2?@\7\27\2\2@A\7\n\2\2AB\7\26\2\2BC\5\4\3\2CE\7\27"+
		"\2\2DF\5\n\6\2ED\3\2\2\2EF\3\2\2\2F\t\3\2\2\2GH\7\13\2\2HI\7\26\2\2IJ"+
		"\5\4\3\2JK\7\27\2\2K\13\3\2\2\2LM\7\f\2\2MN\7\26\2\2NO\5\4\3\2OP\7\27"+
		"\2\2PQ\7\r\2\2QR\7\26\2\2RS\7\34\2\2ST\7\27\2\2T\r\3\2\2\2UV\5\30\r\2"+
		"VW\7\25\2\2WX\5$\23\2X\17\3\2\2\2Ya\5\22\n\2Za\5\24\13\2[a\5\26\f\2\\"+
		"a\5\30\r\2]a\5\32\16\2^a\5\34\17\2_a\5 \21\2`Y\3\2\2\2`Z\3\2\2\2`[\3\2"+
		"\2\2`\\\3\2\2\2`]\3\2\2\2`^\3\2\2\2`_\3\2\2\2a\21\3\2\2\2bc\7\16\2\2c"+
		"d\7\30\2\2de\7\34\2\2ef\7\31\2\2f\23\3\2\2\2gh\7\21\2\2hi\7\30\2\2ij\7"+
		"\31\2\2j\25\3\2\2\2kl\7\22\2\2lm\7\30\2\2mn\7\31\2\2n\27\3\2\2\2op\7\23"+
		"\2\2pq\7\30\2\2qr\7\31\2\2r\31\3\2\2\2st\7\17\2\2tu\7\30\2\2uv\7\34\2"+
		"\2vw\7\31\2\2w\33\3\2\2\2xy\7\20\2\2yz\7\30\2\2z{\7\34\2\2{|\7\31\2\2"+
		"|\35\3\2\2\2}~\7\24\2\2~\177\7\35\2\2\177\u0080\7\30\2\2\u0080\u0081\7"+
		"\31\2\2\u0081\u0082\7\32\2\2\u0082\u0083\5\4\3\2\u0083\u0084\7\33\2\2"+
		"\u0084\37\3\2\2\2\u0085\u0086\7\35\2\2\u0086\u0087\7\30\2\2\u0087\u0088"+
		"\7\34\2\2\u0088\u0089\7\31\2\2\u0089!\3\2\2\2\u008a\u008b\t\2\2\2\u008b"+
		"#\3\2\2\2\u008c\u008d\t\3\2\2\u008d%\3\2\2\2\t)/\64\66:E`";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}