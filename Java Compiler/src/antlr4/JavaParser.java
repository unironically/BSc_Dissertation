// Generated from /home/luke/Programming/FullUnit_1920_LukeBessant/Java Compiler/src/antlr4/Java.g4 by ANTLR 4.8
package antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, PUBLIC=5, STATIC=6, VOID=7, CLASS=8, RETURN=9, 
		EXTENDS=10, IF=11, ELSE=12, SUPER=13, THIS=14, NEW=15, BOOLEAN_LITERAL=16, 
		STRING_LITERAL=17, INTEGER_LITERAL=18, NULL_LITERAL=19, LPAREN=20, RPAREN=21, 
		LBRACE=22, RBRACE=23, LSQUARE=24, RSQUARE=25, SEMI=26, COMMA=27, DOT=28, 
		ASSIGN=29, DIV=30, MUL=31, ADD=32, SUB=33, EQ=34, NE=35, AND=36, OR=37, 
		NOT=38, COMMENT=39, LINE_COMMENT=40, WHITESPACE=41, IDENTIFIER=42;
	public static final int
		RULE_input = 0, RULE_classDeclaration = 1, RULE_superClassDeclaration = 2, 
		RULE_classModifierList = 3, RULE_classModifier = 4, RULE_classBody = 5, 
		RULE_classBodyDeclaration = 6, RULE_memberDeclaration = 7, RULE_methodDeclaration = 8, 
		RULE_constructorDeclaration = 9, RULE_fieldDeclaration = 10, RULE_returnType = 11, 
		RULE_type = 12, RULE_parameters = 13, RULE_parameter = 14, RULE_methodBody = 15, 
		RULE_statement = 16, RULE_block = 17, RULE_localVariableDeclaration = 18, 
		RULE_localDeclarationList = 19, RULE_localDeclaration = 20, RULE_expression = 21, 
		RULE_constructor = 22, RULE_classObjectConstructor = 23, RULE_arrayConstructor = 24, 
		RULE_literal = 25, RULE_methodReference = 26, RULE_expressionList = 27, 
		RULE_identifier = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"input", "classDeclaration", "superClassDeclaration", "classModifierList", 
			"classModifier", "classBody", "classBodyDeclaration", "memberDeclaration", 
			"methodDeclaration", "constructorDeclaration", "fieldDeclaration", "returnType", 
			"type", "parameters", "parameter", "methodBody", "statement", "block", 
			"localVariableDeclaration", "localDeclarationList", "localDeclaration", 
			"expression", "constructor", "classObjectConstructor", "arrayConstructor", 
			"literal", "methodReference", "expressionList", "identifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<='", "'>='", "'>'", "'<'", "'public'", "'static'", "'void'", 
			"'class'", "'return'", "'extends'", "'if'", "'else'", "'super'", "'this'", 
			"'new'", null, null, null, "'null'", "'('", "')'", "'{'", "'}'", "'['", 
			"']'", "';'", "','", "'.'", "'='", "'/'", "'*'", "'+'", "'-'", "'=='", 
			"'!='", "'&&'", "'||'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "PUBLIC", "STATIC", "VOID", "CLASS", "RETURN", 
			"EXTENDS", "IF", "ELSE", "SUPER", "THIS", "NEW", "BOOLEAN_LITERAL", "STRING_LITERAL", 
			"INTEGER_LITERAL", "NULL_LITERAL", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"LSQUARE", "RSQUARE", "SEMI", "COMMA", "DOT", "ASSIGN", "DIV", "MUL", 
			"ADD", "SUB", "EQ", "NE", "AND", "OR", "NOT", "COMMENT", "LINE_COMMENT", 
			"WHITESPACE", "IDENTIFIER"
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
	public String getGrammarFileName() { return "Java.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class InputContext extends ParserRuleContext {
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_input);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PUBLIC) | (1L << STATIC) | (1L << CLASS))) != 0)) {
				{
				{
				setState(58);
				classDeclaration();
				}
				}
				setState(63);
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

	public static class ClassDeclarationContext extends ParserRuleContext {
		public ClassModifierListContext classModifierList() {
			return getRuleContext(ClassModifierListContext.class,0);
		}
		public TerminalNode CLASS() { return getToken(JavaParser.CLASS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public SuperClassDeclarationContext superClassDeclaration() {
			return getRuleContext(SuperClassDeclarationContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			classModifierList();
			setState(65);
			match(CLASS);
			setState(66);
			identifier();
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(67);
				superClassDeclaration();
				}
			}

			setState(70);
			match(LBRACE);
			setState(71);
			classBody();
			setState(72);
			match(RBRACE);
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

	public static class SuperClassDeclarationContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(JavaParser.EXTENDS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SuperClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superClassDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterSuperClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitSuperClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitSuperClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuperClassDeclarationContext superClassDeclaration() throws RecognitionException {
		SuperClassDeclarationContext _localctx = new SuperClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_superClassDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(EXTENDS);
			setState(75);
			identifier();
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

	public static class ClassModifierListContext extends ParserRuleContext {
		public List<ClassModifierContext> classModifier() {
			return getRuleContexts(ClassModifierContext.class);
		}
		public ClassModifierContext classModifier(int i) {
			return getRuleContext(ClassModifierContext.class,i);
		}
		public ClassModifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classModifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterClassModifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitClassModifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitClassModifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassModifierListContext classModifierList() throws RecognitionException {
		ClassModifierListContext _localctx = new ClassModifierListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classModifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUBLIC || _la==STATIC) {
				{
				{
				setState(77);
				classModifier();
				}
				}
				setState(82);
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

	public static class ClassModifierContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(JavaParser.PUBLIC, 0); }
		public TerminalNode STATIC() { return getToken(JavaParser.STATIC, 0); }
		public ClassModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterClassModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitClassModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitClassModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassModifierContext classModifier() throws RecognitionException {
		ClassModifierContext _localctx = new ClassModifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_la = _input.LA(1);
			if ( !(_la==PUBLIC || _la==STATIC) ) {
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

	public static class ClassBodyContext extends ParserRuleContext {
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PUBLIC) | (1L << STATIC) | (1L << VOID) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(85);
				classBodyDeclaration();
				}
				}
				setState(90);
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

	public static class ClassBodyDeclarationContext extends ParserRuleContext {
		public ClassModifierListContext classModifierList() {
			return getRuleContext(ClassModifierListContext.class,0);
		}
		public MemberDeclarationContext memberDeclaration() {
			return getRuleContext(MemberDeclarationContext.class,0);
		}
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterClassBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitClassBodyDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitClassBodyDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyDeclarationContext classBodyDeclaration() throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classBodyDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			classModifierList();
			setState(92);
			memberDeclaration();
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

	public static class MemberDeclarationContext extends ParserRuleContext {
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public MemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterMemberDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitMemberDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitMemberDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberDeclarationContext memberDeclaration() throws RecognitionException {
		MemberDeclarationContext _localctx = new MemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_memberDeclaration);
		try {
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				methodDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				constructorDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				fieldDeclaration();
				}
				break;
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

	public static class MethodDeclarationContext extends ParserRuleContext {
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_methodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			returnType();
			setState(100);
			identifier();
			setState(101);
			match(LPAREN);
			setState(102);
			parameters();
			setState(103);
			match(RPAREN);
			setState(104);
			match(LBRACE);
			setState(105);
			methodBody();
			setState(106);
			match(RBRACE);
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

	public static class ConstructorDeclarationContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterConstructorDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitConstructorDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitConstructorDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorDeclarationContext constructorDeclaration() throws RecognitionException {
		ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_constructorDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			identifier();
			setState(109);
			match(LPAREN);
			setState(110);
			parameters();
			setState(111);
			match(RPAREN);
			setState(112);
			match(LBRACE);
			setState(113);
			methodBody();
			setState(114);
			match(RBRACE);
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

	public static class FieldDeclarationContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitFieldDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitFieldDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_fieldDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			localVariableDeclaration();
			setState(117);
			match(SEMI);
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

	public static class ReturnTypeContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(JavaParser.VOID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitReturnType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitReturnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_returnType);
		try {
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(VOID);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				type(0);
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

	public static class TypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> LSQUARE() { return getTokens(JavaParser.LSQUARE); }
		public TerminalNode LSQUARE(int i) {
			return getToken(JavaParser.LSQUARE, i);
		}
		public List<TerminalNode> RSQUARE() { return getTokens(JavaParser.RSQUARE); }
		public TerminalNode RSQUARE(int i) {
			return getToken(JavaParser.RSQUARE, i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(124);
			identifier();
			}
			_ctx.stop = _input.LT(-1);
			setState(135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(126);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(129); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(127);
							match(LSQUARE);
							setState(128);
							match(RSQUARE);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(131); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					} 
				}
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_parameters);
		int _la;
		try {
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RPAREN:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				parameter();
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(140);
					match(COMMA);
					setState(141);
					parameter();
					}
					}
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			type(0);
			setState(150);
			identifier();
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

	public static class MethodBodyContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitMethodBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitMethodBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_methodBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << IF) | (1L << SUPER) | (1L << THIS) | (1L << NEW) | (1L << BOOLEAN_LITERAL) | (1L << STRING_LITERAL) | (1L << INTEGER_LITERAL) | (1L << NULL_LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(152);
				statement();
				}
				}
				setState(157);
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

	public static class StatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(JavaParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(JavaParser.ELSE, 0); }
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(JavaParser.RETURN, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_statement);
		int _la;
		try {
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(IF);
				setState(159);
				match(LPAREN);
				setState(160);
				expression(0);
				setState(161);
				match(RPAREN);
				setState(162);
				block();
				setState(165);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(163);
					match(ELSE);
					setState(164);
					block();
					}
					break;
				}
				}
				break;
			case RETURN:
			case SUPER:
			case THIS:
			case NEW:
			case BOOLEAN_LITERAL:
			case STRING_LITERAL:
			case INTEGER_LITERAL:
			case NULL_LITERAL:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(167);
					localVariableDeclaration();
					}
					break;
				case 2:
					{
					setState(168);
					expression(0);
					}
					break;
				case 3:
					{
					setState(169);
					match(RETURN);
					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUPER) | (1L << THIS) | (1L << NEW) | (1L << BOOLEAN_LITERAL) | (1L << STRING_LITERAL) | (1L << INTEGER_LITERAL) | (1L << NULL_LITERAL) | (1L << IDENTIFIER))) != 0)) {
						{
						setState(170);
						expression(0);
						}
					}

					}
					break;
				}
				setState(175);
				match(SEMI);
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_block);
		int _la;
		try {
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
			case IF:
			case SUPER:
			case THIS:
			case NEW:
			case BOOLEAN_LITERAL:
			case STRING_LITERAL:
			case INTEGER_LITERAL:
			case NULL_LITERAL:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				statement();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(LBRACE);
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << IF) | (1L << SUPER) | (1L << THIS) | (1L << NEW) | (1L << BOOLEAN_LITERAL) | (1L << STRING_LITERAL) | (1L << INTEGER_LITERAL) | (1L << NULL_LITERAL) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(180);
					statement();
					}
					}
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(186);
				match(RBRACE);
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

	public static class LocalVariableDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LocalDeclarationListContext localDeclarationList() {
			return getRuleContext(LocalDeclarationListContext.class,0);
		}
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterLocalVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitLocalVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitLocalVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_localVariableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			type(0);
			setState(190);
			localDeclarationList();
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

	public static class LocalDeclarationListContext extends ParserRuleContext {
		public List<LocalDeclarationContext> localDeclaration() {
			return getRuleContexts(LocalDeclarationContext.class);
		}
		public LocalDeclarationContext localDeclaration(int i) {
			return getRuleContext(LocalDeclarationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public LocalDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterLocalDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitLocalDeclarationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitLocalDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalDeclarationListContext localDeclarationList() throws RecognitionException {
		LocalDeclarationListContext _localctx = new LocalDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_localDeclarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			localDeclaration();
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(193);
				match(COMMA);
				setState(194);
				localDeclaration();
				}
				}
				setState(199);
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

	public static class LocalDeclarationContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(JavaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LocalDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterLocalDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitLocalDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitLocalDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalDeclarationContext localDeclaration() throws RecognitionException {
		LocalDeclarationContext _localctx = new LocalDeclarationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_localDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			identifier();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(201);
				match(ASSIGN);
				setState(202);
				expression(0);
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

	public static class ExpressionContext extends ParserRuleContext {
		public Token bop;
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode THIS() { return getToken(JavaParser.THIS, 0); }
		public MethodReferenceContext methodReference() {
			return getRuleContext(MethodReferenceContext.class,0);
		}
		public ConstructorContext constructor() {
			return getRuleContext(ConstructorContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(JavaParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(JavaParser.DIV, 0); }
		public TerminalNode ADD() { return getToken(JavaParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(JavaParser.SUB, 0); }
		public TerminalNode EQ() { return getToken(JavaParser.EQ, 0); }
		public TerminalNode NE() { return getToken(JavaParser.NE, 0); }
		public TerminalNode AND() { return getToken(JavaParser.AND, 0); }
		public TerminalNode OR() { return getToken(JavaParser.OR, 0); }
		public TerminalNode ASSIGN() { return getToken(JavaParser.ASSIGN, 0); }
		public TerminalNode DOT() { return getToken(JavaParser.DOT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(206);
				literal();
				}
				break;
			case 2:
				{
				setState(207);
				identifier();
				}
				break;
			case 3:
				{
				setState(208);
				match(THIS);
				}
				break;
			case 4:
				{
				setState(209);
				methodReference();
				}
				break;
			case 5:
				{
				setState(210);
				constructor();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(242);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(240);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(213);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(214);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==DIV || _la==MUL) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(215);
						expression(9);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(216);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(217);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(218);
						expression(8);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(219);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(220);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3))) != 0)) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(221);
						expression(7);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(222);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(223);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NE) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(224);
						expression(6);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(225);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(226);
						((ExpressionContext)_localctx).bop = match(AND);
						setState(227);
						expression(5);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(228);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(229);
						((ExpressionContext)_localctx).bop = match(OR);
						setState(230);
						expression(4);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(231);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(232);
						match(ASSIGN);
						setState(233);
						expression(2);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(234);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(235);
						match(DOT);
						setState(238);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
						case 1:
							{
							setState(236);
							identifier();
							}
							break;
						case 2:
							{
							setState(237);
							methodReference();
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConstructorContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(JavaParser.NEW, 0); }
		public ClassObjectConstructorContext classObjectConstructor() {
			return getRuleContext(ClassObjectConstructorContext.class,0);
		}
		public ArrayConstructorContext arrayConstructor() {
			return getRuleContext(ArrayConstructorContext.class,0);
		}
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(NEW);
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(246);
				classObjectConstructor();
				}
				break;
			case 2:
				{
				setState(247);
				arrayConstructor();
				}
				break;
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

	public static class ClassObjectConstructorContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ClassObjectConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classObjectConstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterClassObjectConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitClassObjectConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitClassObjectConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassObjectConstructorContext classObjectConstructor() throws RecognitionException {
		ClassObjectConstructorContext _localctx = new ClassObjectConstructorContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_classObjectConstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			type(0);
			setState(251);
			match(LPAREN);
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUPER) | (1L << THIS) | (1L << NEW) | (1L << BOOLEAN_LITERAL) | (1L << STRING_LITERAL) | (1L << INTEGER_LITERAL) | (1L << NULL_LITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(252);
				expressionList();
				}
			}

			setState(255);
			match(RPAREN);
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

	public static class ArrayConstructorContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> LSQUARE() { return getTokens(JavaParser.LSQUARE); }
		public TerminalNode LSQUARE(int i) {
			return getToken(JavaParser.LSQUARE, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RSQUARE() { return getTokens(JavaParser.RSQUARE); }
		public TerminalNode RSQUARE(int i) {
			return getToken(JavaParser.RSQUARE, i);
		}
		public ArrayConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayConstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterArrayConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitArrayConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitArrayConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayConstructorContext arrayConstructor() throws RecognitionException {
		ArrayConstructorContext _localctx = new ArrayConstructorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_arrayConstructor);
		int _la;
		try {
			int _alt;
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(257);
				type(0);
				setState(258);
				match(LBRACE);
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUPER) | (1L << THIS) | (1L << NEW) | (1L << BOOLEAN_LITERAL) | (1L << STRING_LITERAL) | (1L << INTEGER_LITERAL) | (1L << NULL_LITERAL) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(259);
					expressionList();
					}
				}

				setState(262);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				identifier();
				setState(269); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(265);
						match(LSQUARE);
						setState(266);
						expression(0);
						setState(267);
						match(RSQUARE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(271); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(JavaParser.STRING_LITERAL, 0); }
		public TerminalNode INTEGER_LITERAL() { return getToken(JavaParser.INTEGER_LITERAL, 0); }
		public TerminalNode BOOLEAN_LITERAL() { return getToken(JavaParser.BOOLEAN_LITERAL, 0); }
		public TerminalNode NULL_LITERAL() { return getToken(JavaParser.NULL_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN_LITERAL) | (1L << STRING_LITERAL) | (1L << INTEGER_LITERAL) | (1L << NULL_LITERAL))) != 0)) ) {
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

	public static class MethodReferenceContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode SUPER() { return getToken(JavaParser.SUPER, 0); }
		public TerminalNode THIS() { return getToken(JavaParser.THIS, 0); }
		public MethodReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterMethodReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitMethodReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitMethodReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodReferenceContext methodReference() throws RecognitionException {
		MethodReferenceContext _localctx = new MethodReferenceContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_methodReference);
		int _la;
		try {
			setState(296);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				identifier();
				setState(278);
				match(LPAREN);
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUPER) | (1L << THIS) | (1L << NEW) | (1L << BOOLEAN_LITERAL) | (1L << STRING_LITERAL) | (1L << INTEGER_LITERAL) | (1L << NULL_LITERAL) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(279);
					expressionList();
					}
				}

				setState(282);
				match(RPAREN);
				}
				break;
			case SUPER:
				enterOuterAlt(_localctx, 2);
				{
				setState(284);
				match(SUPER);
				setState(285);
				match(LPAREN);
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUPER) | (1L << THIS) | (1L << NEW) | (1L << BOOLEAN_LITERAL) | (1L << STRING_LITERAL) | (1L << INTEGER_LITERAL) | (1L << NULL_LITERAL) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(286);
					expressionList();
					}
				}

				setState(289);
				match(RPAREN);
				}
				break;
			case THIS:
				enterOuterAlt(_localctx, 3);
				{
				setState(290);
				match(THIS);
				setState(291);
				match(LPAREN);
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUPER) | (1L << THIS) | (1L << NEW) | (1L << BOOLEAN_LITERAL) | (1L << STRING_LITERAL) | (1L << INTEGER_LITERAL) | (1L << NULL_LITERAL) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(292);
					expressionList();
					}
				}

				setState(295);
				match(RPAREN);
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

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			expression(0);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(299);
				match(COMMA);
				setState(300);
				expression(0);
				}
				}
				setState(305);
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(JavaParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(IDENTIFIER);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 21:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u0137\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\7\2>\n\2\f\2\16"+
		"\2A\13\2\3\3\3\3\3\3\3\3\5\3G\n\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\7\5"+
		"Q\n\5\f\5\16\5T\13\5\3\6\3\6\3\7\7\7Y\n\7\f\7\16\7\\\13\7\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\5\td\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\5\r|\n\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\6\16\u0084\n\16\r\16\16\16\u0085\7\16\u0088\n\16\f"+
		"\16\16\16\u008b\13\16\3\17\3\17\3\17\3\17\7\17\u0091\n\17\f\17\16\17\u0094"+
		"\13\17\5\17\u0096\n\17\3\20\3\20\3\20\3\21\7\21\u009c\n\21\f\21\16\21"+
		"\u009f\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00a8\n\22\3\22\3"+
		"\22\3\22\3\22\5\22\u00ae\n\22\5\22\u00b0\n\22\3\22\5\22\u00b3\n\22\3\23"+
		"\3\23\3\23\7\23\u00b8\n\23\f\23\16\23\u00bb\13\23\3\23\5\23\u00be\n\23"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\7\25\u00c6\n\25\f\25\16\25\u00c9\13\25"+
		"\3\26\3\26\3\26\5\26\u00ce\n\26\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00d6"+
		"\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00f1"+
		"\n\27\7\27\u00f3\n\27\f\27\16\27\u00f6\13\27\3\30\3\30\3\30\5\30\u00fb"+
		"\n\30\3\31\3\31\3\31\5\31\u0100\n\31\3\31\3\31\3\32\3\32\3\32\5\32\u0107"+
		"\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\6\32\u0110\n\32\r\32\16\32\u0111"+
		"\5\32\u0114\n\32\3\33\3\33\3\34\3\34\3\34\5\34\u011b\n\34\3\34\3\34\3"+
		"\34\3\34\3\34\5\34\u0122\n\34\3\34\3\34\3\34\3\34\5\34\u0128\n\34\3\34"+
		"\5\34\u012b\n\34\3\35\3\35\3\35\7\35\u0130\n\35\f\35\16\35\u0133\13\35"+
		"\3\36\3\36\3\36\2\4\32,\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$"+
		"&(*,.\60\62\64\668:\2\b\3\2\7\b\3\2 !\3\2\"#\3\2\3\6\3\2$%\3\2\22\25\2"+
		"\u0146\2?\3\2\2\2\4B\3\2\2\2\6L\3\2\2\2\bR\3\2\2\2\nU\3\2\2\2\fZ\3\2\2"+
		"\2\16]\3\2\2\2\20c\3\2\2\2\22e\3\2\2\2\24n\3\2\2\2\26v\3\2\2\2\30{\3\2"+
		"\2\2\32}\3\2\2\2\34\u0095\3\2\2\2\36\u0097\3\2\2\2 \u009d\3\2\2\2\"\u00b2"+
		"\3\2\2\2$\u00bd\3\2\2\2&\u00bf\3\2\2\2(\u00c2\3\2\2\2*\u00ca\3\2\2\2,"+
		"\u00d5\3\2\2\2.\u00f7\3\2\2\2\60\u00fc\3\2\2\2\62\u0113\3\2\2\2\64\u0115"+
		"\3\2\2\2\66\u012a\3\2\2\28\u012c\3\2\2\2:\u0134\3\2\2\2<>\5\4\3\2=<\3"+
		"\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\3\3\2\2\2A?\3\2\2\2BC\5\b\5\2CD"+
		"\7\n\2\2DF\5:\36\2EG\5\6\4\2FE\3\2\2\2FG\3\2\2\2GH\3\2\2\2HI\7\30\2\2"+
		"IJ\5\f\7\2JK\7\31\2\2K\5\3\2\2\2LM\7\f\2\2MN\5:\36\2N\7\3\2\2\2OQ\5\n"+
		"\6\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\t\3\2\2\2TR\3\2\2\2UV\t"+
		"\2\2\2V\13\3\2\2\2WY\5\16\b\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2"+
		"[\r\3\2\2\2\\Z\3\2\2\2]^\5\b\5\2^_\5\20\t\2_\17\3\2\2\2`d\5\22\n\2ad\5"+
		"\24\13\2bd\5\26\f\2c`\3\2\2\2ca\3\2\2\2cb\3\2\2\2d\21\3\2\2\2ef\5\30\r"+
		"\2fg\5:\36\2gh\7\26\2\2hi\5\34\17\2ij\7\27\2\2jk\7\30\2\2kl\5 \21\2lm"+
		"\7\31\2\2m\23\3\2\2\2no\5:\36\2op\7\26\2\2pq\5\34\17\2qr\7\27\2\2rs\7"+
		"\30\2\2st\5 \21\2tu\7\31\2\2u\25\3\2\2\2vw\5&\24\2wx\7\34\2\2x\27\3\2"+
		"\2\2y|\7\t\2\2z|\5\32\16\2{y\3\2\2\2{z\3\2\2\2|\31\3\2\2\2}~\b\16\1\2"+
		"~\177\5:\36\2\177\u0089\3\2\2\2\u0080\u0083\f\3\2\2\u0081\u0082\7\32\2"+
		"\2\u0082\u0084\7\33\2\2\u0083\u0081\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0088\3\2\2\2\u0087\u0080\3\2"+
		"\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\33\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u0096\3\2\2\2\u008d\u0092\5\36\20"+
		"\2\u008e\u008f\7\35\2\2\u008f\u0091\5\36\20\2\u0090\u008e\3\2\2\2\u0091"+
		"\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0096\3\2"+
		"\2\2\u0094\u0092\3\2\2\2\u0095\u008c\3\2\2\2\u0095\u008d\3\2\2\2\u0096"+
		"\35\3\2\2\2\u0097\u0098\5\32\16\2\u0098\u0099\5:\36\2\u0099\37\3\2\2\2"+
		"\u009a\u009c\5\"\22\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009e!\3\2\2\2\u009f\u009d\3\2\2\2\u00a0"+
		"\u00a1\7\r\2\2\u00a1\u00a2\7\26\2\2\u00a2\u00a3\5,\27\2\u00a3\u00a4\7"+
		"\27\2\2\u00a4\u00a7\5$\23\2\u00a5\u00a6\7\16\2\2\u00a6\u00a8\5$\23\2\u00a7"+
		"\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00b3\3\2\2\2\u00a9\u00b0\5&"+
		"\24\2\u00aa\u00b0\5,\27\2\u00ab\u00ad\7\13\2\2\u00ac\u00ae\5,\27\2\u00ad"+
		"\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\3\2\2\2\u00af\u00a9\3\2"+
		"\2\2\u00af\u00aa\3\2\2\2\u00af\u00ab\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00b3\7\34\2\2\u00b2\u00a0\3\2\2\2\u00b2\u00af\3\2\2\2\u00b3#\3\2\2\2"+
		"\u00b4\u00be\5\"\22\2\u00b5\u00b9\7\30\2\2\u00b6\u00b8\5\"\22\2\u00b7"+
		"\u00b6\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00be\7\31\2\2\u00bd"+
		"\u00b4\3\2\2\2\u00bd\u00b5\3\2\2\2\u00be%\3\2\2\2\u00bf\u00c0\5\32\16"+
		"\2\u00c0\u00c1\5(\25\2\u00c1\'\3\2\2\2\u00c2\u00c7\5*\26\2\u00c3\u00c4"+
		"\7\35\2\2\u00c4\u00c6\5*\26\2\u00c5\u00c3\3\2\2\2\u00c6\u00c9\3\2\2\2"+
		"\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8)\3\2\2\2\u00c9\u00c7\3"+
		"\2\2\2\u00ca\u00cd\5:\36\2\u00cb\u00cc\7\37\2\2\u00cc\u00ce\5,\27\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce+\3\2\2\2\u00cf\u00d0\b\27\1\2"+
		"\u00d0\u00d6\5\64\33\2\u00d1\u00d6\5:\36\2\u00d2\u00d6\7\20\2\2\u00d3"+
		"\u00d6\5\66\34\2\u00d4\u00d6\5.\30\2\u00d5\u00cf\3\2\2\2\u00d5\u00d1\3"+
		"\2\2\2\u00d5\u00d2\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6"+
		"\u00f4\3\2\2\2\u00d7\u00d8\f\n\2\2\u00d8\u00d9\t\3\2\2\u00d9\u00f3\5,"+
		"\27\13\u00da\u00db\f\t\2\2\u00db\u00dc\t\4\2\2\u00dc\u00f3\5,\27\n\u00dd"+
		"\u00de\f\b\2\2\u00de\u00df\t\5\2\2\u00df\u00f3\5,\27\t\u00e0\u00e1\f\7"+
		"\2\2\u00e1\u00e2\t\6\2\2\u00e2\u00f3\5,\27\b\u00e3\u00e4\f\6\2\2\u00e4"+
		"\u00e5\7&\2\2\u00e5\u00f3\5,\27\7\u00e6\u00e7\f\5\2\2\u00e7\u00e8\7\'"+
		"\2\2\u00e8\u00f3\5,\27\6\u00e9\u00ea\f\4\2\2\u00ea\u00eb\7\37\2\2\u00eb"+
		"\u00f3\5,\27\4\u00ec\u00ed\f\13\2\2\u00ed\u00f0\7\36\2\2\u00ee\u00f1\5"+
		":\36\2\u00ef\u00f1\5\66\34\2\u00f0\u00ee\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1"+
		"\u00f3\3\2\2\2\u00f2\u00d7\3\2\2\2\u00f2\u00da\3\2\2\2\u00f2\u00dd\3\2"+
		"\2\2\u00f2\u00e0\3\2\2\2\u00f2\u00e3\3\2\2\2\u00f2\u00e6\3\2\2\2\u00f2"+
		"\u00e9\3\2\2\2\u00f2\u00ec\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2"+
		"\2\2\u00f4\u00f5\3\2\2\2\u00f5-\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00fa"+
		"\7\21\2\2\u00f8\u00fb\5\60\31\2\u00f9\u00fb\5\62\32\2\u00fa\u00f8\3\2"+
		"\2\2\u00fa\u00f9\3\2\2\2\u00fb/\3\2\2\2\u00fc\u00fd\5\32\16\2\u00fd\u00ff"+
		"\7\26\2\2\u00fe\u0100\58\35\2\u00ff\u00fe\3\2\2\2\u00ff\u0100\3\2\2\2"+
		"\u0100\u0101\3\2\2\2\u0101\u0102\7\27\2\2\u0102\61\3\2\2\2\u0103\u0104"+
		"\5\32\16\2\u0104\u0106\7\30\2\2\u0105\u0107\58\35\2\u0106\u0105\3\2\2"+
		"\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\7\31\2\2\u0109"+
		"\u0114\3\2\2\2\u010a\u010f\5:\36\2\u010b\u010c\7\32\2\2\u010c\u010d\5"+
		",\27\2\u010d\u010e\7\33\2\2\u010e\u0110\3\2\2\2\u010f\u010b\3\2\2\2\u0110"+
		"\u0111\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0114\3\2"+
		"\2\2\u0113\u0103\3\2\2\2\u0113\u010a\3\2\2\2\u0114\63\3\2\2\2\u0115\u0116"+
		"\t\7\2\2\u0116\65\3\2\2\2\u0117\u0118\5:\36\2\u0118\u011a\7\26\2\2\u0119"+
		"\u011b\58\35\2\u011a\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\3\2"+
		"\2\2\u011c\u011d\7\27\2\2\u011d\u012b\3\2\2\2\u011e\u011f\7\17\2\2\u011f"+
		"\u0121\7\26\2\2\u0120\u0122\58\35\2\u0121\u0120\3\2\2\2\u0121\u0122\3"+
		"\2\2\2\u0122\u0123\3\2\2\2\u0123\u012b\7\27\2\2\u0124\u0125\7\20\2\2\u0125"+
		"\u0127\7\26\2\2\u0126\u0128\58\35\2\u0127\u0126\3\2\2\2\u0127\u0128\3"+
		"\2\2\2\u0128\u0129\3\2\2\2\u0129\u012b\7\27\2\2\u012a\u0117\3\2\2\2\u012a"+
		"\u011e\3\2\2\2\u012a\u0124\3\2\2\2\u012b\67\3\2\2\2\u012c\u0131\5,\27"+
		"\2\u012d\u012e\7\35\2\2\u012e\u0130\5,\27\2\u012f\u012d\3\2\2\2\u0130"+
		"\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u01329\3\2\2\2"+
		"\u0133\u0131\3\2\2\2\u0134\u0135\7,\2\2\u0135;\3\2\2\2#?FRZc{\u0085\u0089"+
		"\u0092\u0095\u009d\u00a7\u00ad\u00af\u00b2\u00b9\u00bd\u00c7\u00cd\u00d5"+
		"\u00f0\u00f2\u00f4\u00fa\u00ff\u0106\u0111\u0113\u011a\u0121\u0127\u012a"+
		"\u0131";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}