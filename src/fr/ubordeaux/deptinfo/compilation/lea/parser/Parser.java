/* A Bison parser, made by GNU Bison 3.7.4.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015, 2018-2020 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* DO NOT RELY ON FEATURES THAT ARE NOT DOCUMENTED in the manual,
   especially those whose name start with YY_ or yy_.  They are
   private implementation details that can be changed or removed.  */

package fr.ubordeaux.deptinfo.compilation.lea.parser;



import java.text.MessageFormat;
/* "%code imports" blocks.  */
/* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":20  */

	import fr.ubordeaux.deptinfo.compilation.lea.type.TType;
	import fr.ubordeaux.deptinfo.compilation.lea.type.Type;
	import fr.ubordeaux.deptinfo.compilation.lea.type.TypeExpr;
	import fr.ubordeaux.deptinfo.compilation.lea.type.TypeException;
	import fr.ubordeaux.deptinfo.compilation.lea.environment.Environment;
	import fr.ubordeaux.deptinfo.compilation.lea.environment.MapEnvironment;
	import fr.ubordeaux.deptinfo.compilation.lea.environment.EnvironmentException;

	// Ajout pour le switch
	import fr.ubordeaux.deptinfo.compilation.lea.SwitchStack;
	import java.util.Stack;  

/* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/src/fr/ubordeaux/deptinfo/compilation/lea/parser/Parser.java":58  */

/**
 * A Bison parser, automatically generated from <tt>/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class Parser
{
  /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.7.4";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";





  /**
   * A class defining a pair of positions.  Positions, defined by the
   * <code>Position</code> class, denote a point in the input.
   * Locations represent a part of the input through the beginning
   * and ending positions.
   */
  public static class Location {
    /**
     * The first, inclusive, position in the range.
     */
    public Position begin;

    /**
     * The first position beyond the range.
     */
    public Position end;

    /**
     * Create a <code>Location</code> denoting an empty range located at
     * a given point.
     * @param loc The position at which the range is anchored.
     */
    public Location (Position loc) {
      this.begin = this.end = loc;
    }

    /**
     * Create a <code>Location</code> from the endpoints of the range.
     * @param begin The first position included in the range.
     * @param end   The first position beyond the range.
     */
    public Location (Position begin, Position end) {
      this.begin = begin;
      this.end = end;
    }

    /**
     * Print a representation of the location.  For this to be correct,
     * <code>Position</code> should override the <code>equals</code>
     * method.
     */
    public String toString () {
      if (begin.equals (end))
        return begin.toString ();
      else
        return begin.toString () + "-" + end.toString ();
    }
  }

  private Location yylloc(YYStack rhs, int n)
  {
    if (0 < n)
      return new Location(rhs.locationAt(n-1).begin, rhs.locationAt(0).end);
    else
      return new Location(rhs.locationAt(0).end);
  }

  public enum SymbolKind
  {
    S_YYEOF(0),                    /* "end of file"  */
    S_YYerror(1),                  /* error  */
    S_YYUNDEF(2),                  /* "invalid token"  */
    S_ASSIGN(3),                   /* ":="  */
    S_PLUS_ASSIGN(4),              /* "+="  */
    S_MINUS_ASSIGN(5),             /* "-="  */
    S_TIMES_ASSIGN(6),             /* "*="  */
    S_DIV_ASSIGN(7),               /* "/="  */
    S_PERC_ASSIGN(8),              /* "%="  */
    S_PIPE_PIPE_ASSIGN(9),         /* "||="  */
    S_AMP_AMP_ASSIGN(10),          /* "&&="  */
    S_AMP_ASSIGN(11),              /* "&="  */
    S_PIPE_ASSIGN(12),             /* "|="  */
    S_LT_LT_ASSIGN(13),            /* "<<="  */
    S_GT_GT_ASSIGN(14),            /* ">>="  */
    S_PLUS_PLUS(15),               /* "++"  */
    S_MINUS_MINUS(16),             /* "--"  */
    S_AMP_AMP(17),                 /* "&&"  */
    S_PIPE_PIPE(18),               /* "||"  */
    S_LT_LT(19),                   /* "<<"  */
    S_GT_GT(20),                   /* ">>"  */
    S_DOTS(21),                    /* ".."  */
    S_EQ_EQ(22),                   /* "=="  */
    S_LT_EQ(23),                   /* "<="  */
    S_GT_EQ(24),                   /* ">="  */
    S_BANG_EQ(25),                 /* "!="  */
    S_BOOLEAN(26),                 /* "boolean"  */
    S_BREAK(27),                   /* "break"  */
    S_CHAR(28),                    /* "char"  */
    S_CLASS(29),                   /* "class"  */
    S_COMPARABLE(30),              /* "comparable"  */
    S_CONST(31),                   /* "const"  */
    S_CONTINUE(32),                /* "continue"  */
    S_DO(33),                      /* "do"  */
    S_ELSE(34),                    /* "else"  */
    S_ENUM(35),                    /* "enum"  */
    S_EQUIVALENT(36),              /* "equivalent"  */
    S_EXTENDS(37),                 /* "extends"  */
    S_FINAL(38),                   /* "final"  */
    S_FLOAT(39),                   /* "float"  */
    S_FOR(40),                     /* "for"  */
    S_FOREACH(41),                 /* "foreach"  */
    S_FUNCTION(42),                /* "function"  */
    S_IF(43),                      /* "if"  */
    S_IMPLEMENTS(44),              /* "implements"  */
    S_IMPORT(45),                  /* "import"  */
    S_IN(46),                      /* "in"  */
    S_INTEGER(47),                 /* "integer"  */
    S_INTERFACE(48),               /* "interface"  */
    S_LIST(49),                    /* "list"  */
    S_MAP(50),                     /* "map"  */
    S_MAIN(51),                    /* "main"  */
    S_NEW(52),                     /* "new"  */
    S_NULL(53),                    /* "null"  */
    S_OPERATOR(54),                /* "operator"  */
    S_PRIVATE(55),                 /* "private"  */
    S_PROTECTED(56),               /* "protected"  */
    S_PUBLIC(57),                  /* "public"  */
    S_PROCEDURE(58),               /* "procedure"  */
    S_RANGE(59),                   /* "range"  */
    S_READLN(60),                  /* "readln"  */
    S_RETURN(61),                  /* "return"  */
    S_SET(62),                     /* "set"  */
    S_STRING(63),                  /* "string"  */
    S_THIS(64),                    /* "this"  */
    S_TYPE(65),                    /* "type"  */
    S_VIRTUAL(66),                 /* "virtual"  */
    S_WRITE(67),                   /* "write"  */
    S_WRITELN(68),                 /* "writeln"  */
    S_WHILE(69),                   /* "while"  */
    S_SWITCH(70),                  /* "switch"  */
    S_CASE(71),                    /* "case"  */
    S_DEFAULT(72),                 /* "default"  */
    S_IDENTIFIER(73),              /* IDENTIFIER  */
    S_LITTERAL_STRING(74),         /* LITTERAL_STRING  */
    S_NUMBER_INTEGER(75),          /* NUMBER_INTEGER  */
    S_LITTERAL_CHAR(76),           /* LITTERAL_CHAR  */
    S_NUMBER_FLOAT(77),            /* NUMBER_FLOAT  */
    S_WITHOUT_ELSE(78),            /* WITHOUT_ELSE  */
    S_DETERMINER(79),              /* DETERMINER  */
    S_SPECIFIER(80),               /* SPECIFIER  */
    S_81_(81),                     /* '!'  */
    S_82_(82),                     /* '<'  */
    S_83_(83),                     /* '>'  */
    S_84_(84),                     /* '+'  */
    S_85_(85),                     /* '-'  */
    S_86_(86),                     /* '*'  */
    S_87_(87),                     /* '/'  */
    S_88_(88),                     /* '%'  */
    S_LEFTPLUSPLUS(89),            /* LEFTPLUSPLUS  */
    S_LEFTMINUSMINUS(90),          /* LEFTMINUSMINUS  */
    S_UMINUS(91),                  /* UMINUS  */
    S_92_(92),                     /* '|'  */
    S_93_(93),                     /* '&'  */
    S_94_(94),                     /* '{'  */
    S_95_(95),                     /* '}'  */
    S_96_(96),                     /* ','  */
    S_97_(97),                     /* ':'  */
    S_98_(98),                     /* ';'  */
    S_99_(99),                     /* '('  */
    S_100_(100),                   /* ')'  */
    S_101_(101),                   /* "[]"  */
    S_102_(102),                   /* '['  */
    S_103_(103),                   /* ']'  */
    S_104_(104),                   /* '.'  */
    S_YYACCEPT(105),               /* $accept  */
    S_S(106),                      /* S  */
    S_imports(107),                /* imports  */
    S_import(108),                 /* import  */
    S_declarations(109),           /* declarations  */
    S_declaration(110),            /* declaration  */
    S_implements(111),             /* implements  */
    S_extends(112),                /* extends  */
    S_extends_public(113),         /* extends_public  */
    S_classNames(114),             /* classNames  */
    S_className(115),              /* className  */
    S_classDefinition(116),        /* classDefinition  */
    S_classDefinitionContent(117), /* classDefinitionContent  */
    S_typeDefinition(118),         /* typeDefinition  */
    S_constDefinition(119),        /* constDefinition  */
    S_attributeDefinition(120),    /* attributeDefinition  */
    S_methodDefinition(121),       /* methodDefinition  */
    S_122_1(122),                  /* $@1  */
    S_123_2(123),                  /* $@2  */
    S_124_3(124),                  /* $@3  */
    S_125_4(125),                  /* $@4  */
    S_126_5(126),                  /* $@5  */
    S_127_6(127),                  /* $@6  */
    S_128_7(128),                  /* $@7  */
    S_129_8(129),                  /* $@8  */
    S_determiner(130),             /* determiner  */
    S_specifier(131),              /* specifier  */
    S_user_defined_operators(132), /* user_defined_operators  */
    S_interfaceDefinition(133),    /* interfaceDefinition  */
    S_typeExpr(134),               /* typeExpr  */
    S_typePtrExpr(135),            /* typePtrExpr  */
    S_typeExprs(136),              /* typeExprs  */
    S_typeNames(137),              /* typeNames  */
    S_typeName(138),               /* typeName  */
    S_argsDefinition(139),         /* argsDefinition  */
    S_argDefinition(140),          /* argDefinition  */
    S_block(141),                  /* block  */
    S_varDefinitions(142),         /* varDefinitions  */
    S_varDefinition(143),          /* varDefinition  */
    S_stms(144),                   /* stms  */
    S_stm(145),                    /* stm  */
    S_case(146),                   /* case  */
    S_default(147),                /* default  */
    S_simple_stm(148),             /* simple_stm  */
    S_assignedVariable(149),       /* assignedVariable  */
    S_methodName(150),             /* methodName  */
    S_args(151),                   /* args  */
    S_constExpr(152),              /* constExpr  */
    S_expr(153),                   /* expr  */
    S_args_opt(154);               /* args_opt  */


    private final int yycode_;

    SymbolKind (int n) {
      this.yycode_ = n;
    }

    private static final SymbolKind[] values_ = {
      SymbolKind.S_YYEOF,
      SymbolKind.S_YYerror,
      SymbolKind.S_YYUNDEF,
      SymbolKind.S_ASSIGN,
      SymbolKind.S_PLUS_ASSIGN,
      SymbolKind.S_MINUS_ASSIGN,
      SymbolKind.S_TIMES_ASSIGN,
      SymbolKind.S_DIV_ASSIGN,
      SymbolKind.S_PERC_ASSIGN,
      SymbolKind.S_PIPE_PIPE_ASSIGN,
      SymbolKind.S_AMP_AMP_ASSIGN,
      SymbolKind.S_AMP_ASSIGN,
      SymbolKind.S_PIPE_ASSIGN,
      SymbolKind.S_LT_LT_ASSIGN,
      SymbolKind.S_GT_GT_ASSIGN,
      SymbolKind.S_PLUS_PLUS,
      SymbolKind.S_MINUS_MINUS,
      SymbolKind.S_AMP_AMP,
      SymbolKind.S_PIPE_PIPE,
      SymbolKind.S_LT_LT,
      SymbolKind.S_GT_GT,
      SymbolKind.S_DOTS,
      SymbolKind.S_EQ_EQ,
      SymbolKind.S_LT_EQ,
      SymbolKind.S_GT_EQ,
      SymbolKind.S_BANG_EQ,
      SymbolKind.S_BOOLEAN,
      SymbolKind.S_BREAK,
      SymbolKind.S_CHAR,
      SymbolKind.S_CLASS,
      SymbolKind.S_COMPARABLE,
      SymbolKind.S_CONST,
      SymbolKind.S_CONTINUE,
      SymbolKind.S_DO,
      SymbolKind.S_ELSE,
      SymbolKind.S_ENUM,
      SymbolKind.S_EQUIVALENT,
      SymbolKind.S_EXTENDS,
      SymbolKind.S_FINAL,
      SymbolKind.S_FLOAT,
      SymbolKind.S_FOR,
      SymbolKind.S_FOREACH,
      SymbolKind.S_FUNCTION,
      SymbolKind.S_IF,
      SymbolKind.S_IMPLEMENTS,
      SymbolKind.S_IMPORT,
      SymbolKind.S_IN,
      SymbolKind.S_INTEGER,
      SymbolKind.S_INTERFACE,
      SymbolKind.S_LIST,
      SymbolKind.S_MAP,
      SymbolKind.S_MAIN,
      SymbolKind.S_NEW,
      SymbolKind.S_NULL,
      SymbolKind.S_OPERATOR,
      SymbolKind.S_PRIVATE,
      SymbolKind.S_PROTECTED,
      SymbolKind.S_PUBLIC,
      SymbolKind.S_PROCEDURE,
      SymbolKind.S_RANGE,
      SymbolKind.S_READLN,
      SymbolKind.S_RETURN,
      SymbolKind.S_SET,
      SymbolKind.S_STRING,
      SymbolKind.S_THIS,
      SymbolKind.S_TYPE,
      SymbolKind.S_VIRTUAL,
      SymbolKind.S_WRITE,
      SymbolKind.S_WRITELN,
      SymbolKind.S_WHILE,
      SymbolKind.S_SWITCH,
      SymbolKind.S_CASE,
      SymbolKind.S_DEFAULT,
      SymbolKind.S_IDENTIFIER,
      SymbolKind.S_LITTERAL_STRING,
      SymbolKind.S_NUMBER_INTEGER,
      SymbolKind.S_LITTERAL_CHAR,
      SymbolKind.S_NUMBER_FLOAT,
      SymbolKind.S_WITHOUT_ELSE,
      SymbolKind.S_DETERMINER,
      SymbolKind.S_SPECIFIER,
      SymbolKind.S_81_,
      SymbolKind.S_82_,
      SymbolKind.S_83_,
      SymbolKind.S_84_,
      SymbolKind.S_85_,
      SymbolKind.S_86_,
      SymbolKind.S_87_,
      SymbolKind.S_88_,
      SymbolKind.S_LEFTPLUSPLUS,
      SymbolKind.S_LEFTMINUSMINUS,
      SymbolKind.S_UMINUS,
      SymbolKind.S_92_,
      SymbolKind.S_93_,
      SymbolKind.S_94_,
      SymbolKind.S_95_,
      SymbolKind.S_96_,
      SymbolKind.S_97_,
      SymbolKind.S_98_,
      SymbolKind.S_99_,
      SymbolKind.S_100_,
      SymbolKind.S_101_,
      SymbolKind.S_102_,
      SymbolKind.S_103_,
      SymbolKind.S_104_,
      SymbolKind.S_YYACCEPT,
      SymbolKind.S_S,
      SymbolKind.S_imports,
      SymbolKind.S_import,
      SymbolKind.S_declarations,
      SymbolKind.S_declaration,
      SymbolKind.S_implements,
      SymbolKind.S_extends,
      SymbolKind.S_extends_public,
      SymbolKind.S_classNames,
      SymbolKind.S_className,
      SymbolKind.S_classDefinition,
      SymbolKind.S_classDefinitionContent,
      SymbolKind.S_typeDefinition,
      SymbolKind.S_constDefinition,
      SymbolKind.S_attributeDefinition,
      SymbolKind.S_methodDefinition,
      SymbolKind.S_122_1,
      SymbolKind.S_123_2,
      SymbolKind.S_124_3,
      SymbolKind.S_125_4,
      SymbolKind.S_126_5,
      SymbolKind.S_127_6,
      SymbolKind.S_128_7,
      SymbolKind.S_129_8,
      SymbolKind.S_determiner,
      SymbolKind.S_specifier,
      SymbolKind.S_user_defined_operators,
      SymbolKind.S_interfaceDefinition,
      SymbolKind.S_typeExpr,
      SymbolKind.S_typePtrExpr,
      SymbolKind.S_typeExprs,
      SymbolKind.S_typeNames,
      SymbolKind.S_typeName,
      SymbolKind.S_argsDefinition,
      SymbolKind.S_argDefinition,
      SymbolKind.S_block,
      SymbolKind.S_varDefinitions,
      SymbolKind.S_varDefinition,
      SymbolKind.S_stms,
      SymbolKind.S_stm,
      SymbolKind.S_case,
      SymbolKind.S_default,
      SymbolKind.S_simple_stm,
      SymbolKind.S_assignedVariable,
      SymbolKind.S_methodName,
      SymbolKind.S_args,
      SymbolKind.S_constExpr,
      SymbolKind.S_expr,
      SymbolKind.S_args_opt
    };

    static final SymbolKind get(int code) {
      return values_[code];
    }

    public final int getCode() {
      return this.yycode_;
    }

    /* YYNAMES_[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
       First, the terminals, then, starting at \a YYNTOKENS_, nonterminals.  */
    private static final String[] yynames_ = yynames_init();
  private static final String[] yynames_init()
  {
    return new String[]
    {
  "end of file", "error", "invalid token", ":=", "+=", "-=", "*=", "/=",
  "%=", "||=", "&&=", "&=", "|=", "<<=", ">>=", "++", "--", "&&", "||",
  "<<", ">>", "..", "==", "<=", ">=", "!=", "boolean", "break", "char",
  "class", "comparable", "const", "continue", "do", "else", "enum",
  "equivalent", "extends", "final", "float", "for", "foreach", "function",
  "if", "implements", "import", "in", "integer", "interface", "list",
  "map", "main", "new", "null", "operator", "private", "protected",
  "public", "procedure", "range", "readln", "return", "set", "string",
  "this", "type", "virtual", "write", "writeln", "while", "switch", "case",
  "default", "IDENTIFIER", "LITTERAL_STRING", "NUMBER_INTEGER",
  "LITTERAL_CHAR", "NUMBER_FLOAT", "WITHOUT_ELSE", "DETERMINER",
  "SPECIFIER", "'!'", "'<'", "'>'", "'+'", "'-'", "'*'", "'/'", "'%'",
  "LEFTPLUSPLUS", "LEFTMINUSMINUS", "UMINUS", "'|'", "'&'", "'{'", "'}'",
  "','", "':'", "';'", "'('", "')'", "[]", "'['", "']'", "'.'", "$accept",
  "S", "imports", "import", "declarations", "declaration", "implements",
  "extends", "extends_public", "classNames", "className",
  "classDefinition", "classDefinitionContent", "typeDefinition",
  "constDefinition", "attributeDefinition", "methodDefinition", "$@1",
  "$@2", "$@3", "$@4", "$@5", "$@6", "$@7", "$@8", "determiner",
  "specifier", "user_defined_operators", "interfaceDefinition", "typeExpr",
  "typePtrExpr", "typeExprs", "typeNames", "typeName", "argsDefinition",
  "argDefinition", "block", "varDefinitions", "varDefinition", "stms",
  "stm", "case", "default", "simple_stm", "assignedVariable", "methodName",
  "args", "constExpr", "expr", "args_opt", null
    };
  }

    /* The user-facing name of this symbol.  */
    public final String getName() {
      return yynames_[yycode_];
    }
  };


  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>Parser</tt>.
   */
  public interface Lexer {
    /* Token kinds.  */
    /** Token "end of file", to be returned by the scanner.  */
    static final int YYEOF = 0;
    /** Token error, to be returned by the scanner.  */
    static final int YYerror = 256;
    /** Token "invalid token", to be returned by the scanner.  */
    static final int YYUNDEF = 257;
    /** Token ":=", to be returned by the scanner.  */
    static final int ASSIGN = 258;
    /** Token "+=", to be returned by the scanner.  */
    static final int PLUS_ASSIGN = 259;
    /** Token "-=", to be returned by the scanner.  */
    static final int MINUS_ASSIGN = 260;
    /** Token "*=", to be returned by the scanner.  */
    static final int TIMES_ASSIGN = 261;
    /** Token "/=", to be returned by the scanner.  */
    static final int DIV_ASSIGN = 262;
    /** Token "%=", to be returned by the scanner.  */
    static final int PERC_ASSIGN = 263;
    /** Token "||=", to be returned by the scanner.  */
    static final int PIPE_PIPE_ASSIGN = 264;
    /** Token "&&=", to be returned by the scanner.  */
    static final int AMP_AMP_ASSIGN = 265;
    /** Token "&=", to be returned by the scanner.  */
    static final int AMP_ASSIGN = 266;
    /** Token "|=", to be returned by the scanner.  */
    static final int PIPE_ASSIGN = 267;
    /** Token "<<=", to be returned by the scanner.  */
    static final int LT_LT_ASSIGN = 268;
    /** Token ">>=", to be returned by the scanner.  */
    static final int GT_GT_ASSIGN = 269;
    /** Token "++", to be returned by the scanner.  */
    static final int PLUS_PLUS = 270;
    /** Token "--", to be returned by the scanner.  */
    static final int MINUS_MINUS = 271;
    /** Token "&&", to be returned by the scanner.  */
    static final int AMP_AMP = 272;
    /** Token "||", to be returned by the scanner.  */
    static final int PIPE_PIPE = 273;
    /** Token "<<", to be returned by the scanner.  */
    static final int LT_LT = 274;
    /** Token ">>", to be returned by the scanner.  */
    static final int GT_GT = 275;
    /** Token "..", to be returned by the scanner.  */
    static final int DOTS = 276;
    /** Token "==", to be returned by the scanner.  */
    static final int EQ_EQ = 277;
    /** Token "<=", to be returned by the scanner.  */
    static final int LT_EQ = 278;
    /** Token ">=", to be returned by the scanner.  */
    static final int GT_EQ = 279;
    /** Token "!=", to be returned by the scanner.  */
    static final int BANG_EQ = 280;
    /** Token "boolean", to be returned by the scanner.  */
    static final int BOOLEAN = 281;
    /** Token "break", to be returned by the scanner.  */
    static final int BREAK = 282;
    /** Token "char", to be returned by the scanner.  */
    static final int CHAR = 283;
    /** Token "class", to be returned by the scanner.  */
    static final int CLASS = 284;
    /** Token "comparable", to be returned by the scanner.  */
    static final int COMPARABLE = 285;
    /** Token "const", to be returned by the scanner.  */
    static final int CONST = 286;
    /** Token "continue", to be returned by the scanner.  */
    static final int CONTINUE = 287;
    /** Token "do", to be returned by the scanner.  */
    static final int DO = 288;
    /** Token "else", to be returned by the scanner.  */
    static final int ELSE = 289;
    /** Token "enum", to be returned by the scanner.  */
    static final int ENUM = 290;
    /** Token "equivalent", to be returned by the scanner.  */
    static final int EQUIVALENT = 291;
    /** Token "extends", to be returned by the scanner.  */
    static final int EXTENDS = 292;
    /** Token "final", to be returned by the scanner.  */
    static final int FINAL = 293;
    /** Token "float", to be returned by the scanner.  */
    static final int FLOAT = 294;
    /** Token "for", to be returned by the scanner.  */
    static final int FOR = 295;
    /** Token "foreach", to be returned by the scanner.  */
    static final int FOREACH = 296;
    /** Token "function", to be returned by the scanner.  */
    static final int FUNCTION = 297;
    /** Token "if", to be returned by the scanner.  */
    static final int IF = 298;
    /** Token "implements", to be returned by the scanner.  */
    static final int IMPLEMENTS = 299;
    /** Token "import", to be returned by the scanner.  */
    static final int IMPORT = 300;
    /** Token "in", to be returned by the scanner.  */
    static final int IN = 301;
    /** Token "integer", to be returned by the scanner.  */
    static final int INTEGER = 302;
    /** Token "interface", to be returned by the scanner.  */
    static final int INTERFACE = 303;
    /** Token "list", to be returned by the scanner.  */
    static final int LIST = 304;
    /** Token "map", to be returned by the scanner.  */
    static final int MAP = 305;
    /** Token "main", to be returned by the scanner.  */
    static final int MAIN = 306;
    /** Token "new", to be returned by the scanner.  */
    static final int NEW = 307;
    /** Token "null", to be returned by the scanner.  */
    static final int NULL = 308;
    /** Token "operator", to be returned by the scanner.  */
    static final int OPERATOR = 309;
    /** Token "private", to be returned by the scanner.  */
    static final int PRIVATE = 310;
    /** Token "protected", to be returned by the scanner.  */
    static final int PROTECTED = 311;
    /** Token "public", to be returned by the scanner.  */
    static final int PUBLIC = 312;
    /** Token "procedure", to be returned by the scanner.  */
    static final int PROCEDURE = 313;
    /** Token "range", to be returned by the scanner.  */
    static final int RANGE = 314;
    /** Token "readln", to be returned by the scanner.  */
    static final int READLN = 315;
    /** Token "return", to be returned by the scanner.  */
    static final int RETURN = 316;
    /** Token "set", to be returned by the scanner.  */
    static final int SET = 317;
    /** Token "string", to be returned by the scanner.  */
    static final int STRING = 318;
    /** Token "this", to be returned by the scanner.  */
    static final int THIS = 319;
    /** Token "type", to be returned by the scanner.  */
    static final int TYPE = 320;
    /** Token "virtual", to be returned by the scanner.  */
    static final int VIRTUAL = 321;
    /** Token "write", to be returned by the scanner.  */
    static final int WRITE = 322;
    /** Token "writeln", to be returned by the scanner.  */
    static final int WRITELN = 323;
    /** Token "while", to be returned by the scanner.  */
    static final int WHILE = 324;
    /** Token "switch", to be returned by the scanner.  */
    static final int SWITCH = 325;
    /** Token "case", to be returned by the scanner.  */
    static final int CASE = 326;
    /** Token "default", to be returned by the scanner.  */
    static final int DEFAULT = 327;
    /** Token IDENTIFIER, to be returned by the scanner.  */
    static final int IDENTIFIER = 328;
    /** Token LITTERAL_STRING, to be returned by the scanner.  */
    static final int LITTERAL_STRING = 329;
    /** Token NUMBER_INTEGER, to be returned by the scanner.  */
    static final int NUMBER_INTEGER = 330;
    /** Token LITTERAL_CHAR, to be returned by the scanner.  */
    static final int LITTERAL_CHAR = 331;
    /** Token NUMBER_FLOAT, to be returned by the scanner.  */
    static final int NUMBER_FLOAT = 332;
    /** Token WITHOUT_ELSE, to be returned by the scanner.  */
    static final int WITHOUT_ELSE = 333;
    /** Token DETERMINER, to be returned by the scanner.  */
    static final int DETERMINER = 334;
    /** Token SPECIFIER, to be returned by the scanner.  */
    static final int SPECIFIER = 335;
    /** Token LEFTPLUSPLUS, to be returned by the scanner.  */
    static final int LEFTPLUSPLUS = 336;
    /** Token LEFTMINUSMINUS, to be returned by the scanner.  */
    static final int LEFTMINUSMINUS = 337;
    /** Token UMINUS, to be returned by the scanner.  */
    static final int UMINUS = 338;

    /** Deprecated, use YYEOF instead.  */
    public static final int EOF = YYEOF;

    /**
     * Method to retrieve the beginning position of the last scanned token.
     * @return the position at which the last scanned token starts.
     */
    Position getStartPos();

    /**
     * Method to retrieve the ending position of the last scanned token.
     * @return the first position beyond the last scanned token.
     */
    Position getEndPos();

    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    Object getLVal();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * and beginning/ending positions of the token.
     * @return the token identifier corresponding to the next token.
     */
    int yylex() throws java.io.IOException;

    /**
     * Emit an error referring to the given locationin a user-defined way.
     *
     * @param loc The location of the element to which the
     *                error message is related.
     * @param msg The string for the error message.
     */
     void yyerror(Location loc, String msg);


    /**
     * Build and emit a "syntax error" message in a user-defined way.
     *
     * @param ctx  The context of the error.
     */
     void reportSyntaxError (Context ctx);

  }


  /**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;





  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public Parser (Lexer yylexer)
  {

    this.yylexer = yylexer;

  }


  private java.io.PrintStream yyDebugStream = System.err;

  /**
   * The <tt>PrintStream</tt> on which the debugging output is printed.
   */
  public final java.io.PrintStream getDebugStream () { return yyDebugStream; }

  /**
   * Set the <tt>PrintStream</tt> on which the debug output is printed.
   * @param s The stream that is used for debugging output.
   */
  public final void setDebugStream (java.io.PrintStream s) { yyDebugStream = s; }

  private int yydebug = 0;

  /**
   * Answer the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   */
  public final int getDebugLevel () { return yydebug; }

  /**
   * Set the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   * @param level The verbosity level for debugging output.
   */
  public final void setDebugLevel (int level) { yydebug = level; }


  private int yynerrs = 0;

  /**
   * The number of syntax errors so far.
   */
  public final int getNumberOfErrors () { return yynerrs; }

  /**
   * Print an error message via the lexer.
   * Use a <code>null</code> location.
   * @param msg The error message.
   */
  public final void yyerror(String msg) {
      yylexer.yyerror((Location)null, msg);
  }

  /**
   * Print an error message via the lexer.
   * @param loc The location associated with the message.
   * @param msg The error message.
   */
  public final void yyerror(Location loc, String msg) {
      yylexer.yyerror(loc, msg);
  }

  /**
   * Print an error message via the lexer.
   * @param pos The position associated with the message.
   * @param msg The error message.
   */
  public final void yyerror(Position pos, String msg) {
      yylexer.yyerror(new Location (pos), msg);
  }

  protected final void yycdebug (String s) {
    if (0 < yydebug)
      yyDebugStream.println (s);
  }

  private final class YYStack {
    private int[] stateStack = new int[16];
    private Location[] locStack = new Location[16];
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push (int state, Object value, Location loc) {
      height++;
      if (size == height)
        {
          int[] newStateStack = new int[size * 2];
          System.arraycopy (stateStack, 0, newStateStack, 0, height);
          stateStack = newStateStack;
          Location[] newLocStack = new Location[size * 2];
          System.arraycopy (locStack, 0, newLocStack, 0, height);
          locStack = newLocStack;

          Object[] newValueStack = new Object[size * 2];
          System.arraycopy (valueStack, 0, newValueStack, 0, height);
          valueStack = newValueStack;

          size *= 2;
        }

      stateStack[height] = state;
      locStack[height] = loc;
      valueStack[height] = value;
    }

    public final void pop () {
      pop (1);
    }

    public final void pop (int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (0 < num) {
        java.util.Arrays.fill (valueStack, height - num + 1, height + 1, null);
        java.util.Arrays.fill (locStack, height - num + 1, height + 1, null);
      }
      height -= num;
    }

    public final int stateAt (int i) {
      return stateStack[height - i];
    }


    public final Location locationAt (int i) {
      return locStack[height - i];
    }

    public final Object valueAt (int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print (java.io.PrintStream out) {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++)
        {
          out.print (' ');
          out.print (stateStack[i]);
        }
      out.println ();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).
   */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).
   */
  public static final int YYABORT = 1;



  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.
   */
  public static final int YYERROR = 2;

  /**
   * Internal return codes that are not supported for user semantic
   * actions.
   */
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;


  private int yyerrstatus_ = 0;


  /**
   * Whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.
   */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  /** Compute post-reduction state.
   * @param yystate   the current state
   * @param yysym     the nonterminal to push on the stack
   */
  private int yyLRGotoState (int yystate, int yysym)
  {
    int yyr = yypgoto_[yysym - YYNTOKENS_] + yystate;
    if (0 <= yyr && yyr <= YYLAST_ && yycheck_[yyr] == yystate)
      return yytable_[yyr];
    else
      return yydefgoto_[yysym - YYNTOKENS_];
  }

  private int yyaction(int yyn, YYStack yystack, int yylen) throws EnvironmentException, TypeException
  {
    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    Object yyval = (0 < yylen) ? yystack.valueAt(yylen - 1) : yystack.valueAt(0);
    Location yyloc = yylloc(yystack, yylen);

    yyReducePrint(yyn, yystack);

    switch (yyn)
      {
          case 27: /* typeDefinition: "type" IDENTIFIER ":=" typeExpr  */
  if (yyn == 27)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":225  */
        {
		typeEnvironment.put(((String)(yystack.valueAt (2))), ((Type)(yystack.valueAt (0))));
	};
  break;


  case 28: /* constDefinition: "const" IDENTIFIER ":=" constExpr  */
  if (yyn == 28)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":232  */
        {
		constEnvironment.put(((String)(yystack.valueAt (2))), ((Type)(yystack.valueAt (0))));
	};
  break;


  case 29: /* attributeDefinition: determiner IDENTIFIER ':' typeExpr ';'  */
  if (yyn == 29)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":239  */
        {
		varEnvironment.put(((String)(yystack.valueAt (3))), ((Type)(yystack.valueAt (1))));
	};
  break;


  case 31: /* $@1: %empty  */
  if (yyn == 31)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":247  */
        {
		varEnvironment.put(((String)(yystack.valueAt (3))), new TypeExpr(TType.FUNCTION, ((Type)(yystack.valueAt (1))), new TypeExpr(TType.VOID)));
	};
  break;


  case 33: /* $@2: %empty  */
  if (yyn == 33)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":252  */
        {
		varEnvironment.put(((String)(yystack.valueAt (3))), new TypeExpr(TType.FUNCTION, ((Type)(yystack.valueAt (1))), new TypeExpr(TType.VOID)));
	};
  break;


  case 35: /* $@3: %empty  */
  if (yyn == 35)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":257  */
        {
		varEnvironment.put(((String)(yystack.valueAt (3))), new TypeExpr(TType.FUNCTION, ((Type)(yystack.valueAt (1))), new TypeExpr(TType.VOID)));
	};
  break;


  case 37: /* $@4: %empty  */
  if (yyn == 37)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":262  */
        {
		varEnvironment.put(((String)(yystack.valueAt (3))), new TypeExpr(TType.FUNCTION, ((Type)(yystack.valueAt (1))), new TypeExpr(TType.VOID)));
	};
  break;


  case 39: /* $@5: %empty  */
  if (yyn == 39)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":267  */
        {
		varEnvironment.put(((String)(yystack.valueAt (5))), new TypeExpr(TType.FUNCTION, ((Type)(yystack.valueAt (3))), ((Type)(yystack.valueAt (0)))));
	};
  break;


  case 41: /* $@6: %empty  */
  if (yyn == 41)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":272  */
        {
		varEnvironment.put(((String)(yystack.valueAt (5))), new TypeExpr(TType.FUNCTION, ((Type)(yystack.valueAt (3))), ((Type)(yystack.valueAt (0)))));
	};
  break;


  case 43: /* $@7: %empty  */
  if (yyn == 43)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":277  */
        {
		varEnvironment.put(((String)(yystack.valueAt (5))), new TypeExpr(TType.FUNCTION, ((Type)(yystack.valueAt (3))), ((Type)(yystack.valueAt (0)))));
	};
  break;


  case 45: /* $@8: %empty  */
  if (yyn == 45)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":282  */
        {
		varEnvironment.put(((String)(yystack.valueAt (5))), new TypeExpr(TType.FUNCTION, ((Type)(yystack.valueAt (3))), ((Type)(yystack.valueAt (0)))));
	};
  break;


  case 54: /* user_defined_operators: "&&"  */
  if (yyn == 54)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":302  */
                                {yyval = "&&";};
  break;


  case 55: /* user_defined_operators: "||"  */
  if (yyn == 55)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":303  */
                                {yyval = "||";};
  break;


  case 56: /* user_defined_operators: '!'  */
  if (yyn == 56)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":304  */
                                {yyval = "!";};
  break;


  case 57: /* user_defined_operators: '<'  */
  if (yyn == 57)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":305  */
                                {yyval = "<";};
  break;


  case 58: /* user_defined_operators: "<="  */
  if (yyn == 58)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":306  */
                                {yyval = "<=";};
  break;


  case 59: /* user_defined_operators: '>'  */
  if (yyn == 59)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":307  */
                                {yyval = ">";};
  break;


  case 60: /* user_defined_operators: ">="  */
  if (yyn == 60)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":308  */
                                {yyval = ">=";};
  break;


  case 61: /* user_defined_operators: "=="  */
  if (yyn == 61)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":309  */
                                {yyval = "==";};
  break;


  case 62: /* user_defined_operators: "!="  */
  if (yyn == 62)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":310  */
                                {yyval = "!=";};
  break;


  case 63: /* user_defined_operators: '+'  */
  if (yyn == 63)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":311  */
                                {yyval = "+";};
  break;


  case 64: /* user_defined_operators: '-'  */
  if (yyn == 64)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":312  */
                                {yyval = "-";};
  break;


  case 65: /* user_defined_operators: '*'  */
  if (yyn == 65)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":313  */
                                {yyval = "*";};
  break;


  case 66: /* user_defined_operators: '/'  */
  if (yyn == 66)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":314  */
                                {yyval = "/";};
  break;


  case 67: /* user_defined_operators: '%'  */
  if (yyn == 67)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":315  */
                                {yyval = "%";};
  break;


  case 68: /* user_defined_operators: "++"  */
  if (yyn == 68)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":316  */
                                {yyval = "++";};
  break;


  case 69: /* user_defined_operators: "--"  */
  if (yyn == 69)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":317  */
                                {yyval = "--";};
  break;


  case 70: /* user_defined_operators: '&'  */
  if (yyn == 70)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":318  */
                                {yyval = "&";};
  break;


  case 71: /* user_defined_operators: '|'  */
  if (yyn == 71)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":319  */
                                {yyval = "|";};
  break;


  case 72: /* user_defined_operators: "<<"  */
  if (yyn == 72)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":320  */
                                {yyval = "<<";};
  break;


  case 73: /* user_defined_operators: ">>"  */
  if (yyn == 73)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":321  */
                                {yyval = ">>";};
  break;


  case 74: /* user_defined_operators: ":="  */
  if (yyn == 74)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":322  */
                                {yyval = ":=";};
  break;


  case 75: /* user_defined_operators: "+="  */
  if (yyn == 75)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":323  */
                                {yyval = "+=";};
  break;


  case 76: /* user_defined_operators: "-="  */
  if (yyn == 76)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":324  */
                                {yyval = "-=";};
  break;


  case 77: /* user_defined_operators: "*="  */
  if (yyn == 77)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":325  */
                                {yyval = "*=";};
  break;


  case 78: /* user_defined_operators: "/="  */
  if (yyn == 78)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":326  */
                                {yyval = "/=";};
  break;


  case 79: /* user_defined_operators: "%="  */
  if (yyn == 79)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":327  */
                                {yyval = "%=";};
  break;


  case 80: /* user_defined_operators: "||="  */
  if (yyn == 80)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":328  */
                                        {yyval = "||=";};
  break;


  case 81: /* user_defined_operators: "&&="  */
  if (yyn == 81)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":329  */
                                        {yyval = "&&=";};
  break;


  case 82: /* user_defined_operators: "&="  */
  if (yyn == 82)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":330  */
                                {yyval = "&=";};
  break;


  case 83: /* user_defined_operators: "|="  */
  if (yyn == 83)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":331  */
                                {yyval = "|=";};
  break;


  case 84: /* user_defined_operators: "<<="  */
  if (yyn == 84)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":332  */
                                        {yyval = "<<=";};
  break;


  case 85: /* user_defined_operators: ">>="  */
  if (yyn == 85)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":333  */
                                        {yyval = ">>=";};
  break;


  case 86: /* user_defined_operators: "[]"  */
  if (yyn == 86)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":334  */
                                {yyval = "[]";};
  break;


  case 89: /* typeExpr: "char"  */
  if (yyn == 89)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":343  */
                                                                                                {yyval = new TypeExpr(TType.CHAR);};
  break;


  case 90: /* typeExpr: "integer"  */
  if (yyn == 90)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":344  */
                                                                                        {yyval = new TypeExpr(TType.INTEGER);};
  break;


  case 91: /* typeExpr: "float"  */
  if (yyn == 91)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":345  */
                                                                                                {yyval = new TypeExpr(TType.FLOAT);};
  break;


  case 92: /* typeExpr: "boolean"  */
  if (yyn == 92)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":346  */
                                                                                        {yyval = new TypeExpr(TType.BOOLEAN);};
  break;


  case 93: /* typeExpr: "string"  */
  if (yyn == 93)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":347  */
                                                                                                {yyval = new TypeExpr(TType.STRING);};
  break;


  case 94: /* typeExpr: "enum" '<' typeNames '>'  */
  if (yyn == 94)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":348  */
                                                                                {yyval = new TypeExpr(TType.ENUM, ((Type)(yystack.valueAt (1))));};
  break;


  case 95: /* typeExpr: "range" '<' typeExpr '>'  */
  if (yyn == 95)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":349  */
                                                                                {yyval = new TypeExpr(TType.RANGE, ((Type)(yystack.valueAt (1))));};
  break;


  case 96: /* typeExpr: "list" '<' typeExpr '>'  */
  if (yyn == 96)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":350  */
                                                                {yyval = new TypeExpr(TType.LIST, ((Type)(yystack.valueAt (1))));};
  break;


  case 97: /* typeExpr: "set" '<' typeExpr '>'  */
  if (yyn == 97)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":351  */
                                                                {yyval = new TypeExpr(TType.SET, ((Type)(yystack.valueAt (1))));};
  break;


  case 98: /* typeExpr: "map" '<' typeExpr ',' typeExpr '>'  */
  if (yyn == 98)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":352  */
                                                {yyval = new TypeExpr(TType.MAP, ((Type)(yystack.valueAt (3))), ((Type)(yystack.valueAt (1))));};
  break;


  case 99: /* typeExpr: typePtrExpr  */
  if (yyn == 99)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":353  */
                                                                                {yyval = ((Type)(yystack.valueAt (0)));};
  break;


  case 100: /* typePtrExpr: IDENTIFIER '<' typeExprs '>'  */
  if (yyn == 100)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":357  */
                                                {yyval = new TypeExpr(TType.CLASS, ((String)(yystack.valueAt (3))), ((Type)(yystack.valueAt (1))));};
  break;


  case 101: /* typePtrExpr: IDENTIFIER  */
  if (yyn == 101)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":358  */
                                                                        {yyval = new TypeExpr(TType.CLASS, ((String)(yystack.valueAt (0))), null);};
  break;


  case 102: /* typeExprs: typeExprs ',' typeExpr  */
  if (yyn == 102)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":362  */
                                                                        {yyval = new TypeExpr(TType.PRODUCT, ((Type)(yystack.valueAt (2))), ((Type)(yystack.valueAt (0))));};
  break;


  case 103: /* typeExprs: typeExpr  */
  if (yyn == 103)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":363  */
                                                                                        {yyval = ((Type)(yystack.valueAt (0)));};
  break;


  case 104: /* typeNames: typeNames ',' typeName  */
  if (yyn == 104)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":367  */
                                                                        {yyval = new TypeExpr(TType.PRODUCT, ((Type)(yystack.valueAt (2))), ((Type)(yystack.valueAt (0))));};
  break;


  case 105: /* typeNames: typeName  */
  if (yyn == 105)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":368  */
                                                                                        {yyval = ((Type)(yystack.valueAt (0)));};
  break;


  case 106: /* typeName: IDENTIFIER  */
  if (yyn == 106)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":372  */
                                                                                        {yyval = new TypeExpr(TType.NAME, ((String)(yystack.valueAt (0))));};
  break;


  case 107: /* argsDefinition: argsDefinition ',' argDefinition  */
  if (yyn == 107)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":376  */
                                         {yyval = new TypeExpr(TType.PRODUCT, ((Type)(yystack.valueAt (2))), ((Type)(yystack.valueAt (0))));};
  break;


  case 108: /* argsDefinition: argDefinition  */
  if (yyn == 108)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":377  */
                        {yyval = ((Type)(yystack.valueAt (0)));};
  break;


  case 109: /* argDefinition: IDENTIFIER ':' typeExpr  */
  if (yyn == 109)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":382  */
        {
		localVarEnvironment.put(((String)(yystack.valueAt (2))), ((Type)(yystack.valueAt (0))));
		yyval = new TypeExpr(TType.FEATURE, ((String)(yystack.valueAt (2))), ((Type)(yystack.valueAt (0))));
	};
  break;


  case 113: /* varDefinition: IDENTIFIER ':' typeExpr ';'  */
  if (yyn == 113)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":398  */
                                    {localVarEnvironment.put(((String)(yystack.valueAt (3))), ((Type)(yystack.valueAt (1))));};
  break;


  case 123: /* stm: "switch" '(' assignedVariable ')' '{' case default '}'  */
  if (yyn == 123)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":414  */
                                                                        {	
																	int cpt = 0;
																	while(cpt != 1)
																	{
																		SwitchStack stack = stk.pop();
																		try{
																			((Type)(yystack.valueAt (5))).assertEqual(stack.type);
																		} catch(TypeException err){
																			yyerror(stack.loc, err.getMessage());
																		}
																		cpt = stack.count;
																	}				
																};
  break;


  case 125: /* case: "case" expr ':' stms  */
  if (yyn == 125)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":431  */
                                        { stk.push(new SwitchStack(((Type)(yystack.valueAt (2))),yystack.locationAt (2),1)); };
  break;


  case 126: /* case: "case" expr ':' stms case  */
  if (yyn == 126)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":432  */
                                    { stk.push(new SwitchStack(((Type)(yystack.valueAt (3))),yystack.locationAt (3),stk.peek().count + 1)); };
  break;


  case 127: /* case: error  */
  if (yyn == 127)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":433  */
                                                        { return YYABORT; };
  break;


  case 130: /* simple_stm: assignedVariable ":=" expr  */
  if (yyn == 130)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":442  */
                                   {((Type)(yystack.valueAt (2))).assertEqual(((Type)(yystack.valueAt (0))));};
  break;


  case 151: /* assignedVariable: IDENTIFIER  */
  if (yyn == 151)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":467  */
        {
		yyval = localVarEnvironment.get(((String)(yystack.valueAt (0))));
		if (yyval == null)
			yyval = varEnvironment.get(((String)(yystack.valueAt (0))));
		if (yyval == null)
			throw new EnvironmentException("unknown variable " + ((String)(yystack.valueAt (0))));
	};
  break;


  case 152: /* assignedVariable: IDENTIFIER '[' args ']'  */
  if (yyn == 152)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":474  */
                                  {yyval = null;};
  break;


  case 153: /* assignedVariable: assignedVariable '.' IDENTIFIER  */
  if (yyn == 153)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":475  */
                                          {yyval = null;};
  break;


  case 154: /* assignedVariable: "this"  */
  if (yyn == 154)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":476  */
                 {yyval = null;};
  break;


  case 155: /* methodName: IDENTIFIER  */
  if (yyn == 155)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":481  */
        {
		yyval = localVarEnvironment.get(((String)(yystack.valueAt (0))));
		if (yyval == null)
			yyval = varEnvironment.get(((String)(yystack.valueAt (0))));
		if (yyval == null)
			throw new EnvironmentException("unknown variable " + ((String)(yystack.valueAt (0))));
	};
  break;


  case 156: /* methodName: assignedVariable '.' IDENTIFIER  */
  if (yyn == 156)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":488  */
                                          {Type type = ((Type)(yystack.valueAt (2))); yyval = null; /*to be completed*/};
  break;


  case 157: /* args: args ',' expr  */
  if (yyn == 157)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":492  */
                      {yyval = new TypeExpr(TType.PRODUCT, ((Type)(yystack.valueAt (2))), ((Type)(yystack.valueAt (0))));};
  break;


  case 158: /* args: expr  */
  if (yyn == 158)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":493  */
               {yyval = ((Type)(yystack.valueAt (0)));};
  break;


  case 159: /* constExpr: "null"  */
  if (yyn == 159)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":497  */
                                                                                        {yyval = new TypeExpr(TType.INTEGER);};
  break;


  case 160: /* constExpr: NUMBER_INTEGER  */
  if (yyn == 160)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":498  */
                                                                                {yyval = new TypeExpr(TType.INTEGER);};
  break;


  case 161: /* constExpr: NUMBER_FLOAT  */
  if (yyn == 161)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":499  */
                                                                                {yyval = new TypeExpr(TType.FLOAT);};
  break;


  case 162: /* constExpr: LITTERAL_CHAR  */
  if (yyn == 162)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":500  */
                                                                                {yyval = new TypeExpr(TType.CHAR);};
  break;


  case 163: /* constExpr: LITTERAL_STRING  */
  if (yyn == 163)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":501  */
                                                                                {yyval = new TypeExpr(TType.STRING);};
  break;


  case 164: /* constExpr: '[' NUMBER_INTEGER ".." NUMBER_INTEGER ']'  */
  if (yyn == 164)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":502  */
                                                        {yyval = new TypeExpr(TType.RANGE);};
  break;


  case 165: /* expr: constExpr  */
  if (yyn == 165)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":506  */
                                                        {yyval = ((Type)(yystack.valueAt (0)));};
  break;


  case 166: /* expr: assignedVariable  */
  if (yyn == 166)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":507  */
                                                {yyval = ((Type)(yystack.valueAt (0)));};
  break;


  case 167: /* expr: methodName '(' args ')'  */
  if (yyn == 167)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":508  */
                                        {Type type = ((Type)(yystack.valueAt (3))); if (type != null) yyval = type.getRight(); else yyval = null;};
  break;


  case 168: /* expr: "new" typePtrExpr '(' args_opt ')'  */
  if (yyn == 168)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":509  */
                                                                {yyval = ((Type)(yystack.valueAt (3)));};
  break;


  case 169: /* expr: expr "&&" expr  */
  if (yyn == 169)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":510  */
                                                        {yyval = ((Type)(yystack.valueAt (2)));};
  break;


  case 170: /* expr: expr "||" expr  */
  if (yyn == 170)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":511  */
                                                        {yyval = ((Type)(yystack.valueAt (2)));};
  break;


  case 171: /* expr: '!' expr  */
  if (yyn == 171)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":512  */
                                                        {yyval = ((Type)(yystack.valueAt (0)));};
  break;


  case 172: /* expr: expr '<' expr  */
  if (yyn == 172)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":513  */
                                                {yyval = new TypeExpr(TType.BOOLEAN);};
  break;


  case 173: /* expr: expr "<=" expr  */
  if (yyn == 173)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":514  */
                                                        {yyval = new TypeExpr(TType.BOOLEAN);};
  break;


  case 174: /* expr: expr '>' expr  */
  if (yyn == 174)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":515  */
                                                {yyval = new TypeExpr(TType.BOOLEAN);};
  break;


  case 175: /* expr: expr ">=" expr  */
  if (yyn == 175)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":516  */
                                                        {yyval = new TypeExpr(TType.BOOLEAN);};
  break;


  case 176: /* expr: expr "==" expr  */
  if (yyn == 176)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":517  */
                                                        {yyval = new TypeExpr(TType.BOOLEAN);};
  break;


  case 177: /* expr: expr "!=" expr  */
  if (yyn == 177)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":518  */
                                                        {yyval = new TypeExpr(TType.BOOLEAN);};
  break;


  case 178: /* expr: expr '+' expr  */
  if (yyn == 178)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":519  */
                                                {yyval = ((Type)(yystack.valueAt (2)));};
  break;


  case 179: /* expr: expr '-' expr  */
  if (yyn == 179)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":520  */
                                        {yyval = ((Type)(yystack.valueAt (2)));};
  break;


  case 180: /* expr: '-' expr  */
  if (yyn == 180)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":521  */
                                                {yyval = ((Type)(yystack.valueAt (0)));};
  break;


  case 181: /* expr: expr '*' expr  */
  if (yyn == 181)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":522  */
                                                {yyval = ((Type)(yystack.valueAt (2)));};
  break;


  case 182: /* expr: expr '/' expr  */
  if (yyn == 182)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":523  */
                                        {yyval = ((Type)(yystack.valueAt (2)));};
  break;


  case 183: /* expr: expr '%' expr  */
  if (yyn == 183)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":524  */
                                        {yyval = ((Type)(yystack.valueAt (2)));};
  break;


  case 184: /* expr: expr "++"  */
  if (yyn == 184)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":525  */
                                        {yyval = ((Type)(yystack.valueAt (1)));};
  break;


  case 185: /* expr: expr "--"  */
  if (yyn == 185)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":526  */
                                        {yyval = ((Type)(yystack.valueAt (1)));};
  break;


  case 186: /* expr: "++" expr  */
  if (yyn == 186)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":527  */
                                                        {yyval = ((Type)(yystack.valueAt (0)));};
  break;


  case 187: /* expr: "--" expr  */
  if (yyn == 187)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":528  */
                                                                {yyval = ((Type)(yystack.valueAt (0)));};
  break;


  case 188: /* expr: expr '&' expr  */
  if (yyn == 188)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":529  */
                                        {yyval = ((Type)(yystack.valueAt (2)));};
  break;


  case 189: /* expr: expr '|' expr  */
  if (yyn == 189)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":530  */
                                        {yyval = ((Type)(yystack.valueAt (2)));};
  break;


  case 190: /* expr: expr "<<" expr  */
  if (yyn == 190)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":531  */
                                                {yyval = ((Type)(yystack.valueAt (2)));};
  break;


  case 191: /* expr: expr ">>" expr  */
  if (yyn == 191)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":532  */
                                                {yyval = ((Type)(yystack.valueAt (2)));};
  break;


  case 192: /* expr: '(' expr ')'  */
  if (yyn == 192)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":533  */
                                        {yyval = ((Type)(yystack.valueAt (1)));};
  break;


  case 193: /* args_opt: %empty  */
  if (yyn == 193)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":537  */
               {yyval = null;};
  break;


  case 194: /* args_opt: args  */
  if (yyn == 194)
    /* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":538  */
               {yyval = ((Type)(yystack.valueAt (0)));};
  break;



/* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/src/fr/ubordeaux/deptinfo/compilation/lea/parser/Parser.java":1817  */

        default: break;
      }

    yySymbolPrint("-> $$ =", SymbolKind.get(yyr1_[yyn]), yyval, yyloc);

    yystack.pop(yylen);
    yylen = 0;
    /* Shift the result of the reduction.  */
    int yystate = yyLRGotoState(yystack.stateAt(0), yyr1_[yyn]);
    yystack.push(yystate, yyval, yyloc);
    return YYNEWSTATE;
  }


  /*--------------------------------.
  | Print this symbol on YYOUTPUT.  |
  `--------------------------------*/

  private void yySymbolPrint(String s, SymbolKind yykind,
                             Object yyvalue, Location yylocation) {
      if (0 < yydebug) {
          yycdebug(s
                   + (yykind.getCode() < YYNTOKENS_ ? " token " : " nterm ")
                   + yykind.getName() + " ("
                   + yylocation + ": "
                   + (yyvalue == null ? "(null)" : yyvalue.toString()) + ")");
      }
  }


  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
  public boolean parse() throws java.io.IOException, EnvironmentException, TypeException

  {
    /* @$.  */
    Location yyloc;


    /* Lookahead token kind.  */
    int yychar = YYEMPTY_;
    /* Lookahead symbol kind.  */
    SymbolKind yytoken = null;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;
    YYStack yystack = new YYStack ();
    int label = YYNEWSTATE;


    /* The location where the error started.  */
    Location yyerrloc = null;

    /* Location. */
    Location yylloc = new Location (null, null);

    /* Semantic value of the lookahead.  */
    Object yylval = null;

    yycdebug ("Starting parse");
    yyerrstatus_ = 0;
    yynerrs = 0;

    /* Initialize the stack.  */
    yystack.push (yystate, yylval, yylloc);



    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
      case YYNEWSTATE:
        yycdebug ("Entering state " + yystate);
        if (0 < yydebug)
          yystack.print (yyDebugStream);

        /* Accept?  */
        if (yystate == YYFINAL_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yyPactValueIsDefault (yyn))
          {
            label = YYDEFAULT;
            break;
          }

        /* Read a lookahead token.  */
        if (yychar == YYEMPTY_)
          {

            yycdebug ("Reading a token");
            yychar = yylexer.yylex ();
            yylval = yylexer.getLVal();
            yylloc = new Location(yylexer.getStartPos(),
                                          yylexer.getEndPos());

          }

        /* Convert token to internal form.  */
        yytoken = yytranslate_ (yychar);
        yySymbolPrint("Next token is", yytoken,
                      yylval, yylloc);

        if (yytoken == SymbolKind.S_YYerror)
          {
            // The scanner already issued an error message, process directly
            // to error recovery.  But do not keep the error token as
            // lookahead, it is too special and may lead us to an endless
            // loop in error recovery. */
            yychar = Lexer.YYUNDEF;
            yytoken = SymbolKind.S_YYUNDEF;
            yyerrloc = yylloc;
            label = YYERRLAB1;
          }
        else
          {
            /* If the proper action on seeing token YYTOKEN is to reduce or to
               detect an error, take that action.  */
            yyn += yytoken.getCode();
            if (yyn < 0 || YYLAST_ < yyn || yycheck_[yyn] != yytoken.getCode())
              label = YYDEFAULT;

            /* <= 0 means reduce or error.  */
            else if ((yyn = yytable_[yyn]) <= 0)
              {
                if (yyTableValueIsError (yyn))
                  label = YYERRLAB;
                else
                  {
                    yyn = -yyn;
                    label = YYREDUCE;
                  }
              }

            else
              {
                /* Shift the lookahead token.  */
                yySymbolPrint("Shifting", yytoken,
                              yylval, yylloc);

                /* Discard the token being shifted.  */
                yychar = YYEMPTY_;

                /* Count tokens shifted since error; after three, turn off error
                   status.  */
                if (yyerrstatus_ > 0)
                  --yyerrstatus_;

                yystate = yyn;
                yystack.push (yystate, yylval, yylloc);
                label = YYNEWSTATE;
              }
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction(yyn, yystack, yylen);
        yystate = yystack.stateAt (0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs;
            if (yychar == YYEMPTY_)
              yytoken = null;
            yyreportSyntaxError (new Context (yystack, yytoken, yylloc));
          }

        yyerrloc = yylloc;
        if (yyerrstatus_ == 3)
          {
            /* If just tried and failed to reuse lookahead token after an
               error, discard it.  */

            if (yychar <= Lexer.YYEOF)
              {
                /* Return failure if at end of input.  */
                if (yychar == Lexer.YYEOF)
                  return false;
              }
            else
              yychar = YYEMPTY_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
      case YYERROR:
        yyerrloc = yystack.locationAt (yylen - 1);
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt (0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

        // Pop stack until we find a state that shifts the error token.
        for (;;)
          {
            yyn = yypact_[yystate];
            if (!yyPactValueIsDefault (yyn))
              {
                yyn += SymbolKind.S_YYerror.getCode();
                if (0 <= yyn && yyn <= YYLAST_
                    && yycheck_[yyn] == SymbolKind.S_YYerror.getCode())
                  {
                    yyn = yytable_[yyn];
                    if (0 < yyn)
                      break;
                  }
              }

            /* Pop the current state because it cannot handle the
             * error token.  */
            if (yystack.height == 0)
              return false;


            yyerrloc = yystack.locationAt (0);
            yystack.pop ();
            yystate = yystack.stateAt (0);
            if (0 < yydebug)
              yystack.print (yyDebugStream);
          }

        if (label == YYABORT)
          /* Leave the switch.  */
          break;


        /* Muck with the stack to setup for yylloc.  */
        yystack.push (0, null, yylloc);
        yystack.push (0, null, yyerrloc);
        yyloc = yylloc (yystack, 2);
        yystack.pop (2);

        /* Shift the error token.  */
        yySymbolPrint("Shifting", SymbolKind.get(yystos_[yyn]),
                      yylval, yyloc);

        yystate = yyn;
        yystack.push (yyn, yylval, yyloc);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
}




  /**
   * Information needed to get the list of expected tokens and to forge
   * a syntax error diagnostic.
   */
  public static final class Context
  {
    Context (YYStack stack, SymbolKind token, Location loc)
    {
      yystack = stack;
      yytoken = token;
      yylocation = loc;
    }

    private YYStack yystack;


    /**
     * The symbol kind of the lookahead token.
     */
    public final SymbolKind getToken ()
    {
      return yytoken;
    }

    private SymbolKind yytoken;

    /**
     * The location of the lookahead.
     */
    public final Location getLocation ()
    {
      return yylocation;
    }

    private Location yylocation;
    static final int NTOKENS = Parser.YYNTOKENS_;

    /**
     * Put in YYARG at most YYARGN of the expected tokens given the
     * current YYCTX, and return the number of tokens stored in YYARG.  If
     * YYARG is null, return the number of expected tokens (guaranteed to
     * be less than YYNTOKENS).
     */
    int getExpectedTokens (SymbolKind yyarg[], int yyargn)
    {
      return getExpectedTokens (yyarg, 0, yyargn);
    }

    int getExpectedTokens (SymbolKind yyarg[], int yyoffset, int yyargn)
    {
      int yycount = yyoffset;
      int yyn = yypact_[this.yystack.stateAt (0)];
      if (!yyPactValueIsDefault (yyn))
        {
          /* Start YYX at -YYN if negative to avoid negative
             indexes in YYCHECK.  In other words, skip the first
             -YYN actions for this state because they are default
             actions.  */
          int yyxbegin = yyn < 0 ? -yyn : 0;
          /* Stay within bounds of both yycheck and yytname.  */
          int yychecklim = YYLAST_ - yyn + 1;
          int yyxend = yychecklim < NTOKENS ? yychecklim : NTOKENS;
          for (int yyx = yyxbegin; yyx < yyxend; ++yyx)
            if (yycheck_[yyx + yyn] == yyx && yyx != SymbolKind.S_YYerror.getCode()
                && !yyTableValueIsError(yytable_[yyx + yyn]))
              {
                if (yyarg == null)
                  yycount += 1;
                else if (yycount == yyargn)
                  return 0; // FIXME: this is incorrect.
                else
                  yyarg[yycount++] = SymbolKind.get(yyx);
              }
        }
      if (yyarg != null && yycount == yyoffset && yyoffset < yyargn)
        yyarg[yycount] = null;
      return yycount - yyoffset;
    }
  }



  /**
   * Build and emit a "syntax error" message in a user-defined way.
   *
   * @param ctx  The context of the error.
   */
  private void yyreportSyntaxError(Context yyctx) {
      yylexer.reportSyntaxError(yyctx);
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yyPactValueIsDefault (int yyvalue)
  {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yyTableValueIsError (int yyvalue)
  {
    return yyvalue == yytable_ninf_;
  }

  private static final short yypact_ninf_ = -256;
  private static final short yytable_ninf_ = -157;

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short[] yypact_ = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
    -256,    14,   -16,  -256,   -40,   -49,   -36,  -256,   -17,  -256,
     -34,    33,  -256,    57,  -256,   131,    71,   133,    71,    74,
     102,    95,   254,  -256,  -256,  -256,   129,   115,   131,  -256,
    -256,  -256,  -256,   -14,   121,   116,  -256,   183,   103,  -256,
     -20,   215,   152,  -256,  -256,  -256,  -256,  -256,  -256,  -256,
    -256,  -256,  -256,  -256,  -256,  -256,  -256,  -256,  -256,  -256,
    -256,  -256,  -256,  -256,  -256,  -256,  -256,  -256,  -256,  -256,
    -256,  -256,  -256,  -256,  -256,  -256,   128,   227,  -256,  -256,
    -256,  -256,    55,    -1,    71,    71,    71,   131,   162,   168,
     180,   249,   184,   -11,  -256,   152,   963,   963,   152,   207,
     209,    42,  -256,  -256,   188,   185,   186,  -256,  -256,  -256,
    -256,  -256,  -256,   211,  -256,   963,   152,   193,    30,  -256,
    -256,   206,  -256,  -256,   210,   212,   213,   225,  -256,   226,
    -256,  -256,   191,    64,   192,   194,  -256,  -256,   152,   152,
     288,  -256,  -256,  -256,  -256,   214,   237,   963,   963,   963,
     963,   963,  -256,   216,   152,   152,    65,    93,   238,   887,
     963,  -256,    44,  -256,   229,   219,   234,   235,  -256,    45,
     193,   221,   108,   109,   223,   230,   224,  -256,  -256,   926,
     232,   -46,   244,   246,    82,  -256,   253,   255,   271,   272,
      81,  -256,  -256,   848,  -256,   236,   240,   273,   250,  -256,
     237,  -256,   963,  -256,  -256,  -256,   963,  -256,  -256,   278,
     279,   963,  -256,  -256,   -63,   264,   -46,   274,   -42,    82,
      82,    82,    82,   305,    82,    82,    82,   275,   283,  -256,
     735,    82,    82,    82,   -46,   963,    82,  -256,  -256,  -256,
      82,    82,    82,    82,    82,    82,    82,    82,    82,    82,
      82,    82,  -256,  -256,   307,    82,   193,   293,  -256,   313,
    -256,   963,   193,   299,   300,   301,    25,    82,   326,   281,
     370,    31,    31,   302,   762,    31,   389,    82,  -256,  -256,
      82,    82,    82,    82,    82,    82,    82,    82,    82,    82,
      82,    82,    82,    82,    82,    82,    82,   408,   487,   506,
     111,   304,    40,   735,   735,   735,   735,   735,   735,   735,
     735,   735,   735,   735,   735,   735,   311,   123,  -256,  -256,
    -256,   317,  -256,  -256,  -256,    82,    82,   706,  -256,   926,
    -256,    82,  -256,   124,   762,   786,   101,   101,   810,   810,
     810,   810,   810,   810,     0,     0,    80,    80,    80,   -10,
     101,  -256,  -256,   926,   309,  -256,    82,  -256,  -256,   193,
     318,   525,   604,  -256,   383,   322,   319,  -256,  -256,     4,
     735,  -256,  -256,   323,   926,   926,  -256,  -256,    82,   348,
    -256,  -256,  -256,   623,   325,   334,   926,   926,  -256,   289,
     926,  -256
    };
  }

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
  private static final short[] yydefact_ = yydefact_init();
  private static final short[] yydefact_init()
  {
    return new short[]
    {
       3,     0,     0,     1,     0,     0,     0,     4,     2,     7,
       0,    11,     5,    15,     6,    47,     0,    13,     0,     0,
       0,     0,     0,    48,    50,    49,     0,     0,    47,    23,
      24,    25,    26,    51,    19,    12,    18,    47,     0,    16,
       0,     0,     0,    74,    75,    76,    77,    78,    79,    80,
      81,    82,    83,    84,    85,    68,    69,    54,    55,    72,
      73,    61,    58,    60,    62,    56,    57,    59,    63,    64,
      65,    66,    67,    71,    70,    86,     0,     0,     9,    22,
      53,    52,     0,     0,     0,     0,     0,    47,     0,     0,
       0,     0,     0,     0,   108,     0,     0,     0,     0,     0,
       0,     0,    17,    14,     0,     0,     0,    10,   159,   163,
     160,   162,   161,     0,    28,     0,     0,     0,     0,    92,
      89,     0,    91,    90,     0,     0,     0,     0,    93,   101,
      27,    99,     0,     0,     0,     0,    20,     8,     0,     0,
       0,   109,   107,   111,    30,     0,     0,     0,     0,     0,
       0,     0,    29,    31,     0,     0,     0,     0,     0,     0,
       0,   106,     0,   105,     0,     0,     0,     0,   103,     0,
       0,     0,     0,     0,     0,     0,     0,   148,   149,     0,
       0,     0,     0,     0,     0,   154,     0,     0,     0,     0,
     151,   124,   112,     0,   115,     0,     0,     0,    43,    94,
       0,    96,     0,    95,    97,   100,     0,    32,    34,     0,
      35,     0,    87,   164,   151,     0,     0,   151,     0,     0,
       0,     0,     0,     0,     0,     0,     0,   166,     0,   165,
     150,     0,     0,     0,     0,     0,     0,   110,   114,   116,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,   131,   132,     0,     0,     0,     0,   104,     0,
     102,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,   186,   187,     0,   171,   180,     0,     0,   184,   185,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,   158,   130,   133,   134,   135,   136,   137,
     138,   139,   140,   141,   142,   143,   153,     0,    44,    46,
      98,    39,    36,    38,    88,     0,     0,     0,   153,     0,
     145,   193,   192,     0,   169,   170,   190,   191,   176,   173,
     175,   177,   172,   174,   178,   179,   181,   182,   183,   189,
     188,   146,   147,     0,     0,   113,     0,   152,   144,     0,
       0,     0,     0,   122,   117,   194,     0,   167,   119,     0,
     157,    40,    42,     0,     0,     0,   168,   127,     0,   129,
     120,   121,   118,     0,     0,     0,     0,     0,   123,     0,
     128,   126
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final short[] yypgoto_ = yypgoto_init();
  private static final short[] yypgoto_init()
  {
    return new short[]
    {
    -256,  -256,  -256,  -256,  -256,   426,  -256,  -256,  -256,   351,
      16,   -26,  -256,  -256,  -256,  -256,  -256,  -256,  -256,  -256,
    -256,  -256,  -256,  -256,  -256,   399,  -256,  -256,  -256,   -69,
     217,  -256,  -256,   239,    52,   321,  -117,  -256,  -256,  -255,
    -176,    49,  -256,  -256,  -158,  -153,  -247,   350,  -177,  -256
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final short[] yydefgoto_ = yydefgoto_init();
  private static final short[] yydefgoto_init()
  {
    return new short[]
    {
      -1,     1,     2,     7,     8,     9,    17,    38,    19,    35,
      36,    27,    28,    29,    30,    31,    32,   170,   171,   262,
     263,   359,   360,   256,   257,    33,    83,    76,    90,   130,
     131,   169,   162,   163,    93,    94,   191,   159,   192,   193,
     194,   379,   385,   195,   227,   228,   302,   229,   303,   366
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final short[] yytable_ = yytable_init();
  private static final short[] yytable_init()
  {
    return new short[]
    {
     144,   196,    79,   215,   267,   377,   197,   230,   317,   282,
     283,    10,     4,     4,     3,   278,   279,   238,   185,   282,
     283,   196,    88,   218,    80,    12,   197,   217,   132,     5,
     333,     6,     6,    11,    39,   196,  -155,    13,    89,   236,
     197,    99,   269,   270,   271,   272,   141,   274,   275,   276,
     282,   283,    81,   207,   297,   298,   299,   100,   266,    82,
      15,   104,   268,   304,   305,   306,   307,   308,   309,   310,
     311,   312,   313,   314,   315,   378,   300,    16,   164,   165,
     166,   167,   168,   296,   365,   116,   292,   293,   294,   117,
     327,   198,   295,   296,    18,   278,   279,   221,   222,   282,
     283,   102,   103,   334,   335,   336,   337,   338,   339,   340,
     341,   342,   343,   344,   345,   346,   347,   348,   349,   350,
     282,   283,   326,   295,   296,   136,   116,   199,   205,   268,
     145,   389,   390,   259,   223,   108,   356,   260,    85,   318,
     200,   206,   264,   357,    34,   322,   185,   118,   361,   362,
     133,   363,    97,   364,    98,   214,   109,   110,   111,   112,
     116,   116,    20,   224,   153,   174,   301,   225,    40,   196,
      37,   196,   295,   296,   197,    41,   197,   368,   235,   370,
    -155,   226,    21,   236,   113,    22,    23,    24,    25,   116,
     156,   157,   321,   175,    42,   196,    26,    87,   381,   382,
     197,   383,    77,    84,   116,   116,   172,   173,   209,   210,
      78,   354,    85,   238,   238,   268,   196,   196,    91,   356,
     356,   197,   197,   358,   367,    92,   -21,    95,   196,   196,
      96,   196,   196,   197,   197,   105,   197,   197,    23,    24,
      25,   106,   371,   240,   241,   242,   243,   244,   245,   246,
     247,   248,   249,   250,   251,   252,   253,    43,    44,    45,
      46,    47,    48,    49,    50,    51,    52,    53,    54,    55,
      56,    57,    58,    59,    60,   107,    61,    62,    63,    64,
     134,   115,   135,   137,   138,   139,   140,   143,   146,   152,
     377,   154,   147,   155,   148,   149,   278,   279,   280,   281,
     282,   283,   108,   284,   285,   286,   287,   150,   151,   158,
     161,   160,   201,   176,   -33,   202,   177,   203,   204,   208,
     211,   178,   179,   109,   110,   111,   112,   213,   212,   180,
     181,   216,   182,   265,   239,    65,    66,    67,    68,    69,
      70,    71,    72,   219,   254,   220,    73,    74,   -45,   183,
     184,   113,   231,   185,   232,    75,   186,   187,   188,   189,
     378,  -125,   214,   288,   289,   290,   291,   292,   293,   294,
     233,   234,   255,   295,   296,   261,   236,   -37,   129,   254,
     316,   329,   277,   143,  -125,   278,   279,   280,   281,   282,
     283,   319,   284,   285,   286,   287,   320,   323,   324,   328,
     325,   331,   355,   369,   278,   279,   280,   281,   282,   283,
    -156,   284,   285,   286,   287,   -41,   372,   375,   356,   376,
     384,   380,   387,   278,   279,   280,   281,   282,   283,   388,
     284,   285,   286,   287,    14,   101,    86,   142,   391,   258,
     273,   114,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,   288,   289,   290,   291,   292,   293,   294,     0,
       0,     0,   295,   296,     0,     0,     0,     0,     0,     0,
     330,   288,   289,   290,   291,   292,   293,   294,     0,     0,
       0,   295,   296,     0,     0,     0,     0,     0,     0,   332,
     288,   289,   290,   291,   292,   293,   294,     0,     0,     0,
     295,   296,   278,   279,   280,   281,   282,   283,   351,   284,
     285,   286,   287,     0,     0,     0,     0,     0,     0,     0,
       0,   278,   279,   280,   281,   282,   283,     0,   284,   285,
     286,   287,     0,     0,     0,     0,     0,     0,     0,     0,
     278,   279,   280,   281,   282,   283,     0,   284,   285,   286,
     287,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,   288,
     289,   290,   291,   292,   293,   294,     0,     0,     0,   295,
     296,     0,     0,     0,     0,     0,     0,   352,   288,   289,
     290,   291,   292,   293,   294,     0,     0,     0,   295,   296,
       0,     0,     0,     0,     0,     0,   353,   288,   289,   290,
     291,   292,   293,   294,     0,     0,     0,   295,   296,   278,
     279,   280,   281,   282,   283,   373,   284,   285,   286,   287,
       0,     0,     0,     0,     0,     0,     0,     0,   278,   279,
     280,   281,   282,   283,     0,   284,   285,   286,   287,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,   288,   289,   290,   291,
     292,   293,   294,     0,     0,     0,   295,   296,     0,     0,
       0,     0,     0,     0,   374,   288,   289,   290,   291,   292,
     293,   294,     0,     0,     0,   295,   296,     0,     0,     0,
     386,   278,   279,   280,   281,   282,   283,     0,   284,   285,
     286,   287,     0,   177,     0,     0,     0,     0,   178,   179,
       0,     0,     0,     0,     0,     0,   180,   181,     0,   182,
     278,   279,   280,   281,   282,   283,     0,   284,   285,   286,
     287,     0,     0,     0,     0,     0,   183,   184,     0,     0,
     185,     0,     0,   186,   187,   188,   189,   278,   279,   214,
       0,   282,   283,     0,   284,   285,   286,   287,   288,   289,
     290,   291,   292,   293,   294,     0,     0,     0,   295,   296,
     143,   278,   279,   280,     0,   282,   283,     0,   284,   285,
     286,   287,     0,     0,     0,     0,     0,   288,   289,   290,
     291,   292,   293,   294,     0,   278,   279,   295,   296,   282,
     283,     0,  -157,  -157,  -157,  -157,     0,     0,     0,     0,
       0,     0,     0,     0,   288,   289,   290,   291,   292,   293,
     294,     0,     0,     0,   295,   296,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,   288,   289,
     290,   291,   292,   293,   294,   177,     0,     0,   295,   296,
     178,   179,     0,     0,     0,     0,     0,     0,   180,   181,
       0,   182,  -157,  -157,   290,   291,   292,   293,   294,     0,
       0,     0,   295,   296,     0,     0,     0,     0,   183,   184,
       0,     0,   185,     0,   177,   186,   187,   188,   189,   178,
     179,   214,     0,     0,     0,     0,     0,   180,   181,     0,
     182,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,   143,   237,     0,     0,     0,   183,   184,     0,
       0,   185,     0,   177,   186,   187,   188,   189,   178,   179,
     190,     0,     0,     0,     0,     0,   180,   181,     0,   182,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,   143,     0,     0,     0,     0,   183,   184,     0,   119,
     185,   120,     0,   186,   187,   188,   189,     0,   121,   214,
       0,     0,   122,     0,     0,     0,     0,     0,     0,     0,
     123,     0,   124,   125,     0,     0,     0,     0,     0,     0,
     143,     0,   126,     0,     0,   127,   128,     0,     0,     0,
       0,     0,     0,     0,     0,     0,   129
    };
  }

private static final short[] yycheck_ = yycheck_init();
  private static final short[] yycheck_init()
  {
    return new short[]
    {
     117,   159,    28,   179,    46,     1,   159,   184,   255,    19,
      20,    51,    29,    29,     0,    15,    16,   193,    64,    19,
      20,   179,    42,   181,    38,    74,   179,    73,    97,    45,
     277,    48,    48,    73,    18,   193,    99,    73,    58,   102,
     193,    42,   219,   220,   221,   222,   115,   224,   225,   226,
      19,    20,    66,   170,   231,   232,   233,    58,   216,    73,
      94,    87,   104,   240,   241,   242,   243,   244,   245,   246,
     247,   248,   249,   250,   251,    71,   234,    44,   147,   148,
     149,   150,   151,    93,   331,    96,    86,    87,    88,   100,
     267,   160,    92,    93,    37,    15,    16,    15,    16,    19,
      20,    85,    86,   280,   281,   282,   283,   284,   285,   286,
     287,   288,   289,   290,   291,   292,   293,   294,   295,   296,
      19,    20,    97,    92,    93,    83,    96,    83,    83,   104,
     100,   386,   387,   202,    52,    53,    96,   206,    96,   256,
      96,    96,   211,   103,    73,   262,    64,    95,   325,   326,
      98,   327,    97,   329,    99,    73,    74,    75,    76,    77,
      96,    96,    31,    81,   100,   100,   235,    85,    94,   327,
      37,   329,    92,    93,   327,    73,   329,   353,    97,   356,
      99,    99,    51,   102,   102,    54,    55,    56,    57,    96,
     138,   139,   261,   100,    99,   353,    65,    94,   374,   375,
     353,   378,    73,    82,    96,    96,   154,   155,   100,   100,
      95,   100,    96,   389,   390,   104,   374,   375,     3,    96,
      96,   374,   375,   100,   100,    73,    95,    99,   386,   387,
       3,   389,   390,   386,   387,    73,   389,   390,    55,    56,
      57,    73,   359,     3,     4,     5,     6,     7,     8,     9,
      10,    11,    12,    13,    14,    15,    16,     3,     4,     5,
       6,     7,     8,     9,    10,    11,    12,    13,    14,    15,
      16,    17,    18,    19,    20,    95,    22,    23,    24,    25,
      73,    97,    73,    95,    99,    99,    75,    94,    82,    98,
       1,    99,    82,    99,    82,    82,    15,    16,    17,    18,
      19,    20,    53,    22,    23,    24,    25,    82,    82,    21,
      73,    97,    83,    75,    98,    96,    27,    83,    83,    98,
      97,    32,    33,    74,    75,    76,    77,   103,    98,    40,
      41,    99,    43,    69,    98,    81,    82,    83,    84,    85,
      86,    87,    88,    99,   104,    99,    92,    93,    98,    60,
      61,   102,    99,    64,    99,   101,    67,    68,    69,    70,
      71,    72,    73,    82,    83,    84,    85,    86,    87,    88,
      99,    99,    99,    92,    93,    97,   102,    98,    73,   104,
      73,   100,    99,    94,    95,    15,    16,    17,    18,    19,
      20,    98,    22,    23,    24,    25,    83,    98,    98,    73,
      99,    99,    98,    94,    15,    16,    17,    18,    19,    20,
      99,    22,    23,    24,    25,    98,    98,    34,    96,   100,
      72,    98,    97,    15,    16,    17,    18,    19,    20,    95,
      22,    23,    24,    25,     8,    84,    37,   116,   389,   200,
     223,    91,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      -1,    -1,    82,    83,    84,    85,    86,    87,    88,    -1,
      -1,    -1,    92,    93,    -1,    -1,    -1,    -1,    -1,    -1,
     100,    82,    83,    84,    85,    86,    87,    88,    -1,    -1,
      -1,    92,    93,    -1,    -1,    -1,    -1,    -1,    -1,   100,
      82,    83,    84,    85,    86,    87,    88,    -1,    -1,    -1,
      92,    93,    15,    16,    17,    18,    19,    20,   100,    22,
      23,    24,    25,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      -1,    15,    16,    17,    18,    19,    20,    -1,    22,    23,
      24,    25,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      15,    16,    17,    18,    19,    20,    -1,    22,    23,    24,
      25,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    82,
      83,    84,    85,    86,    87,    88,    -1,    -1,    -1,    92,
      93,    -1,    -1,    -1,    -1,    -1,    -1,   100,    82,    83,
      84,    85,    86,    87,    88,    -1,    -1,    -1,    92,    93,
      -1,    -1,    -1,    -1,    -1,    -1,   100,    82,    83,    84,
      85,    86,    87,    88,    -1,    -1,    -1,    92,    93,    15,
      16,    17,    18,    19,    20,   100,    22,    23,    24,    25,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    15,    16,
      17,    18,    19,    20,    -1,    22,    23,    24,    25,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    82,    83,    84,    85,
      86,    87,    88,    -1,    -1,    -1,    92,    93,    -1,    -1,
      -1,    -1,    -1,    -1,   100,    82,    83,    84,    85,    86,
      87,    88,    -1,    -1,    -1,    92,    93,    -1,    -1,    -1,
      97,    15,    16,    17,    18,    19,    20,    -1,    22,    23,
      24,    25,    -1,    27,    -1,    -1,    -1,    -1,    32,    33,
      -1,    -1,    -1,    -1,    -1,    -1,    40,    41,    -1,    43,
      15,    16,    17,    18,    19,    20,    -1,    22,    23,    24,
      25,    -1,    -1,    -1,    -1,    -1,    60,    61,    -1,    -1,
      64,    -1,    -1,    67,    68,    69,    70,    15,    16,    73,
      -1,    19,    20,    -1,    22,    23,    24,    25,    82,    83,
      84,    85,    86,    87,    88,    -1,    -1,    -1,    92,    93,
      94,    15,    16,    17,    -1,    19,    20,    -1,    22,    23,
      24,    25,    -1,    -1,    -1,    -1,    -1,    82,    83,    84,
      85,    86,    87,    88,    -1,    15,    16,    92,    93,    19,
      20,    -1,    22,    23,    24,    25,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    82,    83,    84,    85,    86,    87,
      88,    -1,    -1,    -1,    92,    93,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    82,    83,
      84,    85,    86,    87,    88,    27,    -1,    -1,    92,    93,
      32,    33,    -1,    -1,    -1,    -1,    -1,    -1,    40,    41,
      -1,    43,    82,    83,    84,    85,    86,    87,    88,    -1,
      -1,    -1,    92,    93,    -1,    -1,    -1,    -1,    60,    61,
      -1,    -1,    64,    -1,    27,    67,    68,    69,    70,    32,
      33,    73,    -1,    -1,    -1,    -1,    -1,    40,    41,    -1,
      43,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      -1,    -1,    94,    95,    -1,    -1,    -1,    60,    61,    -1,
      -1,    64,    -1,    27,    67,    68,    69,    70,    32,    33,
      73,    -1,    -1,    -1,    -1,    -1,    40,    41,    -1,    43,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      -1,    94,    -1,    -1,    -1,    -1,    60,    61,    -1,    26,
      64,    28,    -1,    67,    68,    69,    70,    -1,    35,    73,
      -1,    -1,    39,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      47,    -1,    49,    50,    -1,    -1,    -1,    -1,    -1,    -1,
      94,    -1,    59,    -1,    -1,    62,    63,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    73
    };
  }

/* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
   symbol of state STATE-NUM.  */
  private static final short[] yystos_ = yystos_init();
  private static final short[] yystos_init()
  {
    return new short[]
    {
       0,   106,   107,     0,    29,    45,    48,   108,   109,   110,
      51,    73,    74,    73,   110,    94,    44,   111,    37,   113,
      31,    51,    54,    55,    56,    57,    65,   116,   117,   118,
     119,   120,   121,   130,    73,   114,   115,    37,   112,   115,
      94,    73,    99,     3,     4,     5,     6,     7,     8,     9,
      10,    11,    12,    13,    14,    15,    16,    17,    18,    19,
      20,    22,    23,    24,    25,    81,    82,    83,    84,    85,
      86,    87,    88,    92,    93,   101,   132,    73,    95,   116,
      38,    66,    73,   131,    82,    96,   130,    94,    42,    58,
     133,     3,    73,   139,   140,    99,     3,    97,    99,    42,
      58,   114,   115,   115,   116,    73,    73,    95,    53,    74,
      75,    76,    77,   102,   152,    97,    96,   100,   139,    26,
      28,    35,    39,    47,    49,    50,    59,    62,    63,    73,
     134,   135,   134,   139,    73,    73,    83,    95,    99,    99,
      75,   134,   140,    94,   141,   100,    82,    82,    82,    82,
      82,    82,    98,   100,    99,    99,   139,   139,    21,   142,
      97,    73,   137,   138,   134,   134,   134,   134,   134,   136,
     122,   123,   139,   139,   100,   100,    75,    27,    32,    33,
      40,    41,    43,    60,    61,    64,    67,    68,    69,    70,
      73,   141,   143,   144,   145,   148,   149,   150,   134,    83,
      96,    83,    96,    83,    83,    83,    96,   141,    98,   100,
     100,    97,    98,   103,    73,   145,    99,    73,   149,    99,
      99,    15,    16,    52,    81,    85,    99,   149,   150,   152,
     153,    99,    99,    99,    99,    97,   102,    95,   145,    98,
       3,     4,     5,     6,     7,     8,     9,    10,    11,    12,
      13,    14,    15,    16,   104,    99,   128,   129,   138,   134,
     134,    97,   124,   125,   134,    69,   149,    46,   104,   153,
     153,   153,   153,   135,   153,   153,   153,    99,    15,    16,
      17,    18,    19,    20,    22,    23,    24,    25,    82,    83,
      84,    85,    86,    87,    88,    92,    93,   153,   153,   153,
     149,   134,   151,   153,   153,   153,   153,   153,   153,   153,
     153,   153,   153,   153,   153,   153,    73,   151,   141,    98,
      83,   134,   141,    98,    98,    99,    97,   153,    73,   100,
     100,    99,   100,   151,   153,   153,   153,   153,   153,   153,
     153,   153,   153,   153,   153,   153,   153,   153,   153,   153,
     153,   100,   100,   100,   100,    98,    96,   103,   100,   126,
     127,   153,   153,   145,   145,   151,   154,   100,   145,    94,
     153,   141,    98,   100,   100,    34,   100,     1,    71,   146,
      98,   145,   145,   153,    72,   147,    97,    97,    95,   144,
     144,   146
    };
  }

/* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final short[] yyr1_ = yyr1_init();
  private static final short[] yyr1_init()
  {
    return new short[]
    {
       0,   105,   106,   107,   107,   108,   109,   109,   110,   110,
     110,   111,   111,   112,   112,   113,   113,   114,   114,   115,
     115,   116,   116,   117,   117,   117,   117,   118,   119,   120,
     121,   122,   121,   123,   121,   124,   121,   125,   121,   126,
     121,   127,   121,   128,   121,   129,   121,   130,   130,   130,
     130,   131,   131,   131,   132,   132,   132,   132,   132,   132,
     132,   132,   132,   132,   132,   132,   132,   132,   132,   132,
     132,   132,   132,   132,   132,   132,   132,   132,   132,   132,
     132,   132,   132,   132,   132,   132,   132,   133,   133,   134,
     134,   134,   134,   134,   134,   134,   134,   134,   134,   134,
     135,   135,   136,   136,   137,   137,   138,   139,   139,   140,
     141,   142,   142,   143,   144,   144,   145,   145,   145,   145,
     145,   145,   145,   145,   145,   146,   146,   146,   147,   147,
     148,   148,   148,   148,   148,   148,   148,   148,   148,   148,
     148,   148,   148,   148,   148,   148,   148,   148,   148,   148,
     148,   149,   149,   149,   149,   150,   150,   151,   151,   152,
     152,   152,   152,   152,   152,   153,   153,   153,   153,   153,
     153,   153,   153,   153,   153,   153,   153,   153,   153,   153,
     153,   153,   153,   153,   153,   153,   153,   153,   153,   153,
     153,   153,   153,   154,   154
    };
  }

/* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
  private static final byte[] yyr2_ = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     2,     0,     2,     2,     2,     1,     7,     5,
       6,     0,     2,     0,     3,     0,     2,     3,     1,     1,
       4,     0,     2,     1,     1,     1,     1,     4,     4,     5,
       5,     0,     7,     0,     7,     0,     9,     0,     9,     0,
      11,     0,    11,     0,     9,     0,     9,     0,     1,     1,
       1,     0,     1,     1,     1,     1,     1,     1,     1,     1,
       1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
       1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
       1,     1,     1,     1,     1,     1,     1,     6,     8,     1,
       1,     1,     1,     1,     4,     4,     4,     4,     6,     1,
       4,     1,     3,     1,     3,     1,     1,     3,     1,     3,
       4,     0,     2,     4,     2,     1,     2,     5,     7,     5,
       7,     7,     5,     8,     1,     4,     5,     1,     3,     0,
       3,     2,     2,     3,     3,     3,     3,     3,     3,     3,
       3,     3,     3,     3,     4,     4,     4,     4,     1,     1,
       2,     1,     4,     3,     1,     1,     3,     3,     1,     1,
       1,     1,     1,     1,     5,     1,     1,     4,     5,     3,
       3,     2,     3,     3,     3,     3,     3,     3,     3,     3,
       2,     3,     3,     3,     2,     2,     2,     2,     3,     3,
       3,     3,     3,     0,     1
    };
  }



  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
  private static final short[] yyrline_ = yyrline_init();
  private static final short[] yyrline_init()
  {
    return new short[]
    {
       0,   162,   162,   167,   168,   172,   176,   177,   181,   182,
     183,   187,   188,   192,   193,   197,   198,   202,   203,   207,
     208,   212,   213,   217,   218,   219,   220,   224,   231,   238,
     245,   247,   246,   252,   251,   257,   256,   262,   261,   267,
     266,   272,   271,   277,   276,   282,   281,   289,   290,   291,
     292,   296,   297,   298,   302,   303,   304,   305,   306,   307,
     308,   309,   310,   311,   312,   313,   314,   315,   316,   317,
     318,   319,   320,   321,   322,   323,   324,   325,   326,   327,
     328,   329,   330,   331,   332,   333,   334,   338,   339,   343,
     344,   345,   346,   347,   348,   349,   350,   351,   352,   353,
     357,   358,   362,   363,   367,   368,   372,   376,   377,   381,
     389,   393,   394,   398,   402,   403,   407,   408,   409,   410,
     411,   412,   413,   414,   427,   431,   432,   433,   437,   438,
     442,   443,   444,   445,   446,   447,   448,   449,   450,   451,
     452,   453,   454,   455,   456,   457,   458,   459,   460,   461,
     462,   466,   474,   475,   476,   480,   488,   492,   493,   497,
     498,   499,   500,   501,   502,   506,   507,   508,   509,   510,
     511,   512,   513,   514,   515,   516,   517,   518,   519,   520,
     521,   522,   523,   524,   525,   526,   527,   528,   529,   530,
     531,   532,   533,   537,   538
    };
  }


  // Report on the debug stream that the rule yyrule is going to be reduced.
  private void yyReducePrint (int yyrule, YYStack yystack)
  {
    if (yydebug == 0)
      return;

    int yylno = yyrline_[yyrule];
    int yynrhs = yyr2_[yyrule];
    /* Print the symbols being reduced, and their result.  */
    yycdebug ("Reducing stack by rule " + (yyrule - 1)
              + " (line " + yylno + "):");

    /* The symbols being reduced.  */
    for (int yyi = 0; yyi < yynrhs; yyi++)
      yySymbolPrint("   $" + (yyi + 1) + " =",
                    SymbolKind.get(yystos_[yystack.stateAt (yynrhs - (yyi + 1))]),
                    yystack.valueAt ((yynrhs) - (yyi + 1)),
                    yystack.locationAt ((yynrhs) - (yyi + 1)));
  }

  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final SymbolKind yytranslate_(int t)
  {
    // Last valid token kind.
    int code_max = 339;
    if (t <= 0)
      return SymbolKind.S_YYEOF;
    else if (t <= code_max)
      return SymbolKind.get(yytranslate_table_[t]);
    else
      return SymbolKind.S_YYUNDEF;
  }
  private static final byte[] yytranslate_table_ = yytranslate_table_init();
  private static final byte[] yytranslate_table_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,    81,     2,     2,     2,    88,    93,     2,
      99,   100,    86,    84,    96,    85,   104,    87,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,    97,    98,
      82,     2,    83,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,   102,     2,   103,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,    94,    92,    95,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    43,    44,
      45,    46,    47,    48,    49,    50,    51,    52,    53,    54,
      55,    56,    57,    58,    59,    60,    61,    62,    63,    64,
      65,    66,    67,    68,    69,    70,    71,    72,    73,    74,
      75,    76,    77,    78,    79,    80,    89,    90,    91,   101
    };
  }


  private static final int YYLAST_ = 1036;
  private static final int YYEMPTY_ = -2;
  private static final int YYFINAL_ = 3;
  private static final int YYNTOKENS_ = 105;

/* Unqualified %code blocks.  */
/* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":34  */

	private Environment<Type> typeEnvironment = new MapEnvironment<Type>("types", true);
	private Environment<Type> varEnvironment = new MapEnvironment<Type>("var", true);
	private Environment<Type> localVarEnvironment = new MapEnvironment<Type>("local", true);
	private Environment<Type> constEnvironment = new MapEnvironment<Type>("const", true);

	// Ajout pour le switch
	private Stack<SwitchStack> stk = new Stack<>();  


/* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/src/fr/ubordeaux/deptinfo/compilation/lea/parser/Parser.java":2822  */

}
/* "/mnt/c/Users/yohan/OneDrive/Documents/FAC/L3/Cours semestre 6/Compilation/miniprojet/parser/Parser.y":541  */

