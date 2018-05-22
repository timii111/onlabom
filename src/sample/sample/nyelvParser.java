// Generated from C:/Users/Timi/IdeaProjects/onlabom/src/sample\nyelv.g4 by ANTLR 4.7
package sample.sample;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class nyelvParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		YELLOW=1, RED=2, BLUE=3, GREEN=4, NONE=5, IF=6, THEN=7, ELSE=8, REPEAT=9, 
		FOR=10, GO=11, TURNLEFT=12, TURNRIGHT=13, PUSH=14, EAT=15, MYCOLOR=16, 
		EQUAL=17, SQUARE1=18, SQUARE2=19, BRACKET1=20, BRACKET2=21, NUMBER=22, 
		SKIPER=23;
	public static final int
		RULE_program = 0, RULE_commandlines = 1, RULE_structure = 2, RULE_branch = 3, 
		RULE_elseStatement = 4, RULE_cycle = 5, RULE_equality = 6, RULE_command = 7, 
		RULE_goThere = 8, RULE_pushIt = 9, RULE_eatIt = 10, RULE_getColor = 11, 
		RULE_turnLeft = 12, RULE_turnRight = 13, RULE_color = 14;
	public static final String[] ruleNames = {
		"program", "commandlines", "structure", "branch", "elseStatement", "cycle", 
		"equality", "command", "goThere", "pushIt", "eatIt", "getColor", "turnLeft", 
		"turnRight", "color"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'yellow'", "'red'", "'blue'", "'green'", "'none'", "'if'", "'then'", 
		"'else'", "'repeat'", "'for'", "'go'", "'turnLeft'", "'turnRight'", "'push'", 
		"'eat'", "'myColor'", "'='", "'['", "']'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "YELLOW", "RED", "BLUE", "GREEN", "NONE", "IF", "THEN", "ELSE", 
		"REPEAT", "FOR", "GO", "TURNLEFT", "TURNRIGHT", "PUSH", "EAT", "MYCOLOR", 
		"EQUAL", "SQUARE1", "SQUARE2", "BRACKET1", "BRACKET2", "NUMBER", "SKIPER"
	};
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
	public String getGrammarFileName() { return "nyelv.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public nyelvParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
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
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nyelvVisitor ) return ((nyelvVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << REPEAT) | (1L << GO) | (1L << TURNLEFT) | (1L << TURNRIGHT) | (1L << PUSH) | (1L << EAT) | (1L << MYCOLOR))) != 0)) {
				{
				{
				setState(30);
				commandlines();
				}
				}
				setState(35);
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
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).enterCommandlines(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).exitCommandlines(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nyelvVisitor ) return ((nyelvVisitor<? extends T>)visitor).visitCommandlines(this);
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
			setState(38); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(38);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case GO:
					case TURNLEFT:
					case TURNRIGHT:
					case PUSH:
					case EAT:
					case MYCOLOR:
						{
						setState(36);
						command();
						}
						break;
					case IF:
					case REPEAT:
						{
						setState(37);
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
				setState(40); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).enterStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).exitStructure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nyelvVisitor ) return ((nyelvVisitor<? extends T>)visitor).visitStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructureContext structure() throws RecognitionException {
		StructureContext _localctx = new StructureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_structure);
		try {
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				branch();
				}
				break;
			case REPEAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
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
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
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
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).enterBranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).exitBranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nyelvVisitor ) return ((nyelvVisitor<? extends T>)visitor).visitBranch(this);
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
			setState(46);
			match(IF);
			setState(47);
			match(SQUARE1);
			setState(48);
			equality();
			setState(49);
			match(SQUARE2);
			setState(50);
			match(THEN);
			setState(51);
			match(SQUARE1);
			setState(52);
			commandlines();
			setState(53);
			match(SQUARE2);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(54);
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
		public CommandlinesContext commandlines() {
			return getRuleContext(CommandlinesContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nyelvVisitor ) return ((nyelvVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(ELSE);
			setState(58);
			match(SQUARE1);
			setState(59);
			commandlines();
			setState(60);
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
		public CommandlinesContext commandlines() {
			return getRuleContext(CommandlinesContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(nyelvParser.NUMBER, 0); }
		public CycleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cycle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).enterCycle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).exitCycle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nyelvVisitor ) return ((nyelvVisitor<? extends T>)visitor).visitCycle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CycleContext cycle() throws RecognitionException {
		CycleContext _localctx = new CycleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cycle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(REPEAT);
			setState(63);
			match(SQUARE1);
			setState(64);
			commandlines();
			setState(65);
			match(SQUARE2);
			setState(66);
			match(FOR);
			setState(67);
			match(SQUARE1);
			setState(68);
			match(NUMBER);
			setState(69);
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
		public ColorContext color() {
			return getRuleContext(ColorContext.class,0);
		}
		public EqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).enterEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).exitEquality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nyelvVisitor ) return ((nyelvVisitor<? extends T>)visitor).visitEquality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityContext equality() throws RecognitionException {
		EqualityContext _localctx = new EqualityContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_equality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			getColor();
			setState(72);
			match(EQUAL);
			setState(73);
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
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nyelvVisitor ) return ((nyelvVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_command);
		try {
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GO:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				goThere();
				}
				break;
			case PUSH:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				pushIt();
				}
				break;
			case EAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				eatIt();
				}
				break;
			case MYCOLOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				getColor();
				}
				break;
			case TURNLEFT:
				enterOuterAlt(_localctx, 5);
				{
				setState(79);
				turnLeft();
				}
				break;
			case TURNRIGHT:
				enterOuterAlt(_localctx, 6);
				{
				setState(80);
				turnRight();
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
		public TerminalNode NUMBER() { return getToken(nyelvParser.NUMBER, 0); }
		public GoThereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goThere; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).enterGoThere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).exitGoThere(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nyelvVisitor ) return ((nyelvVisitor<? extends T>)visitor).visitGoThere(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GoThereContext goThere() throws RecognitionException {
		GoThereContext _localctx = new GoThereContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_goThere);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(GO);
			setState(84);
			match(BRACKET1);
			setState(85);
			match(NUMBER);
			setState(86);
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
		public PushItContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pushIt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).enterPushIt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).exitPushIt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nyelvVisitor ) return ((nyelvVisitor<? extends T>)visitor).visitPushIt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PushItContext pushIt() throws RecognitionException {
		PushItContext _localctx = new PushItContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_pushIt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(PUSH);
			setState(89);
			match(BRACKET1);
			setState(90);
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
		public EatItContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eatIt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).enterEatIt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).exitEatIt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nyelvVisitor ) return ((nyelvVisitor<? extends T>)visitor).visitEatIt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EatItContext eatIt() throws RecognitionException {
		EatItContext _localctx = new EatItContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_eatIt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(EAT);
			setState(93);
			match(BRACKET1);
			setState(94);
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
		public GetColorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getColor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).enterGetColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).exitGetColor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nyelvVisitor ) return ((nyelvVisitor<? extends T>)visitor).visitGetColor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GetColorContext getColor() throws RecognitionException {
		GetColorContext _localctx = new GetColorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_getColor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(MYCOLOR);
			setState(97);
			match(BRACKET1);
			setState(98);
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
		public TerminalNode NUMBER() { return getToken(nyelvParser.NUMBER, 0); }
		public TurnLeftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_turnLeft; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).enterTurnLeft(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).exitTurnLeft(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nyelvVisitor ) return ((nyelvVisitor<? extends T>)visitor).visitTurnLeft(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TurnLeftContext turnLeft() throws RecognitionException {
		TurnLeftContext _localctx = new TurnLeftContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_turnLeft);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(TURNLEFT);
			setState(101);
			match(BRACKET1);
			setState(102);
			match(NUMBER);
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

	public static class TurnRightContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(nyelvParser.NUMBER, 0); }
		public TurnRightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_turnRight; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).enterTurnRight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).exitTurnRight(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nyelvVisitor ) return ((nyelvVisitor<? extends T>)visitor).visitTurnRight(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TurnRightContext turnRight() throws RecognitionException {
		TurnRightContext _localctx = new TurnRightContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_turnRight);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(TURNRIGHT);
			setState(106);
			match(BRACKET1);
			setState(107);
			match(NUMBER);
			setState(108);
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

	public static class ColorContext extends ParserRuleContext {
		public TerminalNode YELLOW() { return getToken(nyelvParser.YELLOW, 0); }
		public TerminalNode RED() { return getToken(nyelvParser.RED, 0); }
		public TerminalNode BLUE() { return getToken(nyelvParser.BLUE, 0); }
		public TerminalNode GREEN() { return getToken(nyelvParser.GREEN, 0); }
		public TerminalNode NONE() { return getToken(nyelvParser.NONE, 0); }
		public ColorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_color; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).enterColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nyelvListener ) ((nyelvListener)listener).exitColor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof nyelvVisitor ) return ((nyelvVisitor<? extends T>)visitor).visitColor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorContext color() throws RecognitionException {
		ColorContext _localctx = new ColorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_color);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << YELLOW) | (1L << RED) | (1L << BLUE) | (1L << GREEN) | (1L << NONE))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31s\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\7\2\"\n\2\f\2\16\2%\13"+
		"\2\3\3\3\3\6\3)\n\3\r\3\16\3*\3\4\3\4\5\4/\n\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\5\5:\n\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\5\tT\n\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\2\2\21\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36\2\3\3\2\3\7\2m\2#\3\2\2\2\4(\3\2\2\2\6"+
		".\3\2\2\2\b\60\3\2\2\2\n;\3\2\2\2\f@\3\2\2\2\16I\3\2\2\2\20S\3\2\2\2\22"+
		"U\3\2\2\2\24Z\3\2\2\2\26^\3\2\2\2\30b\3\2\2\2\32f\3\2\2\2\34k\3\2\2\2"+
		"\36p\3\2\2\2 \"\5\4\3\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\3\3"+
		"\2\2\2%#\3\2\2\2&)\5\20\t\2\')\5\6\4\2(&\3\2\2\2(\'\3\2\2\2)*\3\2\2\2"+
		"*(\3\2\2\2*+\3\2\2\2+\5\3\2\2\2,/\5\b\5\2-/\5\f\7\2.,\3\2\2\2.-\3\2\2"+
		"\2/\7\3\2\2\2\60\61\7\b\2\2\61\62\7\24\2\2\62\63\5\16\b\2\63\64\7\25\2"+
		"\2\64\65\7\t\2\2\65\66\7\24\2\2\66\67\5\4\3\2\679\7\25\2\28:\5\n\6\29"+
		"8\3\2\2\29:\3\2\2\2:\t\3\2\2\2;<\7\n\2\2<=\7\24\2\2=>\5\4\3\2>?\7\25\2"+
		"\2?\13\3\2\2\2@A\7\13\2\2AB\7\24\2\2BC\5\4\3\2CD\7\25\2\2DE\7\f\2\2EF"+
		"\7\24\2\2FG\7\30\2\2GH\7\25\2\2H\r\3\2\2\2IJ\5\30\r\2JK\7\23\2\2KL\5\36"+
		"\20\2L\17\3\2\2\2MT\5\22\n\2NT\5\24\13\2OT\5\26\f\2PT\5\30\r\2QT\5\32"+
		"\16\2RT\5\34\17\2SM\3\2\2\2SN\3\2\2\2SO\3\2\2\2SP\3\2\2\2SQ\3\2\2\2SR"+
		"\3\2\2\2T\21\3\2\2\2UV\7\r\2\2VW\7\26\2\2WX\7\30\2\2XY\7\27\2\2Y\23\3"+
		"\2\2\2Z[\7\20\2\2[\\\7\26\2\2\\]\7\27\2\2]\25\3\2\2\2^_\7\21\2\2_`\7\26"+
		"\2\2`a\7\27\2\2a\27\3\2\2\2bc\7\22\2\2cd\7\26\2\2de\7\27\2\2e\31\3\2\2"+
		"\2fg\7\16\2\2gh\7\26\2\2hi\7\30\2\2ij\7\27\2\2j\33\3\2\2\2kl\7\17\2\2"+
		"lm\7\26\2\2mn\7\30\2\2no\7\27\2\2o\35\3\2\2\2pq\t\2\2\2q\37\3\2\2\2\b"+
		"#(*.9S";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}