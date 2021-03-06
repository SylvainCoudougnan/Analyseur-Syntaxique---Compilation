// Premiere version du parser en comparant les types des cases 2 à 2

%language "Java"

%define api.package {fr.ubordeaux.deptinfo.compilation.lea.parser}
%define api.parser.public
%define api.parser.class {Parser}
%define throws {EnvironmentException, TypeException}
 
%define lr.type ielr

%verbose
%define parse.trace

%locations

%code imports {
	import fr.ubordeaux.deptinfo.compilation.lea.type.TType;
	import fr.ubordeaux.deptinfo.compilation.lea.type.Type;
	import fr.ubordeaux.deptinfo.compilation.lea.type.TypeExpr;
	import fr.ubordeaux.deptinfo.compilation.lea.type.TypeException;
	import fr.ubordeaux.deptinfo.compilation.lea.environment.Environment;
	import fr.ubordeaux.deptinfo.compilation.lea.environment.MapEnvironment;
	import fr.ubordeaux.deptinfo.compilation.lea.environment.EnvironmentException;
}

%code {
	private Environment<Type> typeEnvironment = new MapEnvironment<Type>("types", true);
	private Environment<Type> varEnvironment = new MapEnvironment<Type>("var", true);
	private Environment<Type> localVarEnvironment = new MapEnvironment<Type>("local", true);
	private Environment<Type> constEnvironment = new MapEnvironment<Type>("const", true);
}

// operators
%token ASSIGN ":="
	PLUS_ASSIGN "+="
	MINUS_ASSIGN "-="
	TIMES_ASSIGN "*="
	DIV_ASSIGN "/="
	PERC_ASSIGN "%="
	PIPE_PIPE_ASSIGN "||="
	AMP_AMP_ASSIGN "&&="
	AMP_ASSIGN "&="
	PIPE_ASSIGN "|="
	LT_LT_ASSIGN "<<="
	GT_GT_ASSIGN ">>="
	PLUS_PLUS "++"
	MINUS_MINUS "--"
	AMP_AMP "&&"
	PIPE_PIPE "||"
	LT_LT "<<"
	GT_GT ">>"
	DOTS ".."
	EQ_EQ "=="
	LT_EQ "<="
	GT_EQ ">="
	BANG_EQ "!=";

//keywords
%token 
	BOOLEAN "boolean"
	BREAK "break"
	CHAR "char"
	CLASS "class"
	COMPARABLE "comparable"
	CONST "const"
	CONTINUE "continue"
	DO "do"
	ELSE "else"
	ENUM "enum"
	EQUIVALENT "equivalent"
	EXTENDS "extends"
	FINAL "final"
	FLOAT "float"
	FOR "for"
	FOREACH "foreach"
	FUNCTION "function"
	IF "if"
	IMPLEMENTS "implements"
	IMPORT "import"
	IN "in"
	INTEGER "integer"
	INTERFACE "interface"
	LIST "list"
	MAP "map"
	MAIN "main"
	NEW "new"
	NULL "null"
	OPERATOR "operator"
	PRIVATE "private"
	PROTECTED "protected"
	PUBLIC "public"
	PROCEDURE "procedure"
	RANGE "range"
	READLN "readln"
	RETURN "return"
	SET "set"
	STRING "string"
	THIS "this"
	TYPE "type"
	VIRTUAL "virtual"
	WRITE "write"
	WRITELN "writeln"
	WHILE "while"
	SWITCH "switch"
	CASE "case"
	DEFAULT "default"
	
	

// constants
%token<String> 
	IDENTIFIER 
	LITTERAL_STRING;

%token<Integer> 
	NUMBER_INTEGER
	LITTERAL_CHAR;

%token<Float> 
	NUMBER_FLOAT;


%nterm<Type> typeExprs typeExpr typePtrExpr typeNames typeName argsDefinition argDefinition
	constExpr expr assignedVariable 
	methodName args args_opt case ;

%nterm<String> user_defined_operators;

%precedence WITHOUT_ELSE
%precedence ELSE;

%precedence DETERMINER
%precedence SPECIFIER

%left "||";
%left "&&";
%nonassoc '!';
%nonassoc '<' "<=" '>' ">=" "!=" "==";
%left '+' '-';
%left '*' '/' '%';
%left "++" "--";
%right LEFTPLUSPLUS LEFTMINUSMINUS;
%nonassoc UMINUS;
%left '|';
%left '&';
%right "<<" ">>";

%%

S: 	imports  
	declarations
	;

imports:
	%empty
	| imports import
	;

import:
	"import" LITTERAL_STRING
	;
	
declarations:
	declarations declaration
	| declaration
	;
	
declaration:
	"class" IDENTIFIER implements extends '{' classDefinition '}'
	| "class" "main" '{' classDefinition '}'
	| "interface" IDENTIFIER extends_public '{' interfaceDefinition '}'
	;
	
implements:
	%empty
	| "implements" classNames
	;
	
extends:
	%empty
	| "extends" determiner className
	;
	
extends_public:
	%empty
	| "extends" className
	;
	
classNames:
	classNames ',' className
	| className
	;
	
className:
	IDENTIFIER
	| IDENTIFIER '<' classNames '>'
	;
	
classDefinition:
	%empty
	| classDefinitionContent classDefinition
	;
	
classDefinitionContent:
	typeDefinition
	| constDefinition
	| attributeDefinition
	| methodDefinition
	;
	
typeDefinition:
	"type" IDENTIFIER ":=" typeExpr 	
	{
		typeEnvironment.put($2, $4);
	}
	;
	
constDefinition:
	"const" IDENTIFIER ":=" constExpr 
	{
		constEnvironment.put($2, $4);
	}
	;
	
attributeDefinition:
	determiner IDENTIFIER ':' typeExpr ';' 	
	{
		varEnvironment.put($2, $4);
	}
	;
	
methodDefinition:
	"main" '(' argsDefinition ')' block
	| determiner IDENTIFIER '(' argsDefinition ')'
	{
		varEnvironment.put($2, new TypeExpr(TType.FUNCTION, $4, new TypeExpr(TType.VOID)));
	}
	block
	| determiner IDENTIFIER '(' argsDefinition ')'
	{
		varEnvironment.put($2, new TypeExpr(TType.FUNCTION, $4, new TypeExpr(TType.VOID)));
	}
	';'
	| determiner specifier "procedure" IDENTIFIER '(' argsDefinition ')' 	
	{
		varEnvironment.put($4, new TypeExpr(TType.FUNCTION, $6, new TypeExpr(TType.VOID)));
	}
	block
	| determiner specifier "procedure" IDENTIFIER '(' argsDefinition ')'
	{
		varEnvironment.put($4, new TypeExpr(TType.FUNCTION, $6, new TypeExpr(TType.VOID)));
	}
	';'
	| determiner specifier "function" IDENTIFIER '(' argsDefinition ')' ':' typeExpr  	
	{
		varEnvironment.put($4, new TypeExpr(TType.FUNCTION, $6, $9));
	}
	block
	| determiner specifier "function" IDENTIFIER '(' argsDefinition ')' ':' typeExpr	
	{
		varEnvironment.put($4, new TypeExpr(TType.FUNCTION, $6, $9));
	}
	';'
	| "operator" user_defined_operators '(' argsDefinition ')' ':' typeExpr
	{
		varEnvironment.put($2, new TypeExpr(TType.FUNCTION, $4, $7));
	}
	block
	| "operator" user_defined_operators '(' argsDefinition ')' ':' typeExpr
	{
		varEnvironment.put($2, new TypeExpr(TType.FUNCTION, $4, $7));
	}
	';'
	;

determiner:
	%empty %prec DETERMINER
	| "private"
	| "public"
	| "protected"
	;
	
specifier:
	%empty %prec SPECIFIER
	| "virtual"
	| "final"
	;
	
user_defined_operators:
	"&&" 			{$$ = "&&";}
	| "||" 			{$$ = "||";}
	| '!' 			{$$ = "!";}
	| '<' 			{$$ = "<";}
	| "<=" 			{$$ = "<=";}
	| '>' 			{$$ = ">";}
	| ">=" 			{$$ = ">=";}
	| "==" 			{$$ = "==";}
	| "!=" 			{$$ = "!=";}
	| '+'  			{$$ = "+";}
	| '-' 			{$$ = "-";}
	| '*'  			{$$ = "*";}
	| '/' 			{$$ = "/";}
	| '%' 			{$$ = "%";}
	| "++" 			{$$ = "++";}
	| "--"			{$$ = "--";}
	| '&' 			{$$ = "&";}
	| '|' 			{$$ = "|";}
	| "<<" 			{$$ = "<<";}
	| ">>" 			{$$ = ">>";}
	| ":=" 			{$$ = ":=";}
	| "+=" 			{$$ = "+=";}
	| "-=" 			{$$ = "-=";}
	| "*=" 			{$$ = "*=";}
	| "/=" 			{$$ = "/=";}
	| "%=" 			{$$ = "%=";}
	| "||=" 			{$$ = "||=";}
	| "&&=" 			{$$ = "&&=";}
	| "&=" 			{$$ = "&=";}
	| "|=" 			{$$ = "|=";}
	| "<<=" 			{$$ = "<<=";}
	| ">>=" 			{$$ = ">>=";}
	| "[]" 			{$$ = "[]";}
	;

interfaceDefinition:
	"procedure" IDENTIFIER '(' argsDefinition ')' ';'
	| "function" IDENTIFIER '(' argsDefinition ')' ':' typeExpr ';'
	;

typeExpr:
	"char"											{$$ = new TypeExpr(TType.CHAR);}
	| "integer"									{$$ = new TypeExpr(TType.INTEGER);}
	| "float"										{$$ = new TypeExpr(TType.FLOAT);}
	| "boolean"									{$$ = new TypeExpr(TType.BOOLEAN);}
	| "string"										{$$ = new TypeExpr(TType.STRING);}
	| "enum" '<' typeNames '>'						{$$ = new TypeExpr(TType.ENUM, $3);}
	| "range" '<' typeExpr '>'						{$$ = new TypeExpr(TType.RANGE, $3);}
	| "list" '<' typeExpr '>'				{$$ = new TypeExpr(TType.LIST, $3);}
	| "set" '<' typeExpr '>'				{$$ = new TypeExpr(TType.SET, $3);}
	| "map" '<' typeExpr ',' typeExpr '>'	{$$ = new TypeExpr(TType.MAP, $3, $5);}
	| typePtrExpr								{$$ = $1;}
	;
	
typePtrExpr:
	IDENTIFIER '<' typeExprs '>'		{$$ = new TypeExpr(TType.CLASS, $1, $3);}
	| IDENTIFIER	 						{$$ = new TypeExpr(TType.CLASS, $1, null);}
	;
	
typeExprs:
	typeExprs ',' typeExpr						{$$ = new TypeExpr(TType.PRODUCT, $1, $3);}
	| typeExpr									{$$ = $1;}
	;
	
typeNames:
	typeNames ',' typeName						{$$ = new TypeExpr(TType.PRODUCT, $1, $3);}
	| typeName									{$$ = $1;}
	;
	
typeName:
	IDENTIFIER									{$$ = new TypeExpr(TType.NAME, $1);}
	;
	
argsDefinition:
	argsDefinition ',' argDefinition {$$ = new TypeExpr(TType.PRODUCT, $1, $3);}
	| argDefinition {$$ = $1;}
	;	
	
argDefinition:
	IDENTIFIER ':' typeExpr 
	{
		localVarEnvironment.put($1, $3);
		$$ = new TypeExpr(TType.FEATURE, $1, $3);
	}
	;	
	
block:
	'{' varDefinitions stms '}'
	;
	
varDefinitions:
	%empty
	| varDefinitions varDefinition
	;
	
varDefinition:
	IDENTIFIER ':' typeExpr ';' {localVarEnvironment.put($1, $3);}
	;
	
stms:
	stms stm
	| stm
	;
	
stm:
	simple_stm ';'
	| "if" '(' expr ')' stm %prec WITHOUT_ELSE
	| "if" '(' expr ')' stm "else" stm
	| "while" '(' expr ')' stm
	| "do" stm WHILE '(' expr ')' ';'
	| "for" '(' assignedVariable ':' expr ')' stm
	| "foreach" assignedVariable "in" expr stm
	| "switch" '(' assignedVariable ')' '{' case default '}' 	{
																	if ($3.equals($6) )
																		System.out.println("Trouver switch !");
																	else 
																		System.out.println("Switch : Les types cases ne correspondent pas : " + $3 + " attendu");
																}
	| block
	;	

case:
	"case" 	 expr ':' stm  		{$$ = $2; System.out.println("Trouver case !");} 
	| "case" expr ':' stm case  {
									$$ = $2;
									try{
										$2.assertEqual($5);
									} catch(TypeException err){
										if($5 != null) yyerror(@2, err.getMessage());
										$$ = null;
									}
									if($2.equals($5)){
										System.out.println("Trouver case !");
									}
								}
	| error						{ $$ = null; System.out.println("Switch case non conforme à " + @1); return YYABORT;}		
	;

default:
	"default" ':' stm {System.out.println("Trouver default !");} 
	| %empty
;

simple_stm:
	assignedVariable ":=" expr {$1.assertEqual($3);}
	| assignedVariable "++"
	| assignedVariable "--"
	| assignedVariable "+=" expr
	| assignedVariable "-=" expr
	| assignedVariable "*=" expr
	| assignedVariable "/=" expr
	| assignedVariable "%=" expr
	| assignedVariable "||=" expr
	| assignedVariable "&&=" expr
	| assignedVariable "&=" expr
	| assignedVariable "|=" expr
	| assignedVariable "<<=" expr
	| assignedVariable ">>=" expr
	| methodName '(' args ')'
	| "readln" '(' expr ')'
	| "write" '(' expr ')'
	| "writeln" '(' expr ')'
	| "break"
	| "continue"
	| "return" expr
	;

assignedVariable:
	IDENTIFIER 
	{
		$$ = localVarEnvironment.get($1);
		if ($$ == null)
			$$ = varEnvironment.get($1);
		if ($$ == null)
			throw new EnvironmentException("unknown variable " + $1);
	}
	| IDENTIFIER '[' args ']' {$$ = null;}
	| assignedVariable '.' IDENTIFIER {$$ = null;}
	| "this" {$$ = null;}
	;

methodName:
	IDENTIFIER
	{
		$$ = localVarEnvironment.get($1);
		if ($$ == null)
			$$ = varEnvironment.get($1);
		if ($$ == null)
			throw new EnvironmentException("unknown variable " + $1);
	}
	| assignedVariable '.' IDENTIFIER {Type type = $1; $$ = null; /*to be completed*/}
	;

args:
	args ',' expr {$$ = new TypeExpr(TType.PRODUCT, $1, $3);}
	| expr {$$ = $1;}
	;
	
constExpr:
	"null" 										{$$ = new TypeExpr(TType.INTEGER);}
	| NUMBER_INTEGER 							{$$ = new TypeExpr(TType.INTEGER);}
	| NUMBER_FLOAT								{$$ = new TypeExpr(TType.FLOAT);}
	| LITTERAL_CHAR								{$$ = new TypeExpr(TType.CHAR);}
	| LITTERAL_STRING							{$$ = new TypeExpr(TType.STRING);}
	| '[' NUMBER_INTEGER DOTS NUMBER_INTEGER ']'	{$$ = new TypeExpr(TType.RANGE);}
	;
	
expr:
	constExpr 					{$$ = $1;}
	| assignedVariable			{$$ = $1;}
	| methodName '(' args ')'	{Type type = $1; if (type != null) $$ = type.getRight(); else $$ = null;}
	| "new" typePtrExpr '(' args_opt ')'			{$$ = $2;}
	| expr "&&" expr				{$$ = $1;}
	| expr "||" expr				{$$ = $1;}
	| '!' expr					{$$ = $2;}
	| expr '<' expr				{$$ = new TypeExpr(TType.BOOLEAN);}
	| expr "<=" expr				{$$ = new TypeExpr(TType.BOOLEAN);}
	| expr '>' expr				{$$ = new TypeExpr(TType.BOOLEAN);}
	| expr ">=" expr				{$$ = new TypeExpr(TType.BOOLEAN);}
	| expr "==" expr				{$$ = new TypeExpr(TType.BOOLEAN);}
	| expr "!=" expr				{$$ = new TypeExpr(TType.BOOLEAN);}
	| expr '+' expr 			{$$ = $1;}
	| expr '-' expr			{$$ = $1;}
	| '-' expr %prec UMINUS			{$$ = $2;}
	| expr '*' expr 			{$$ = $1;}
	| expr '/' expr			{$$ = $1;}
	| expr '%' expr			{$$ = $1;}
	| expr "++" 			{$$ = $1;}
	| expr "--"			{$$ = $1;}
	| "++" expr %prec LEFTPLUSPLUS			{$$ = $2;}
	| "--" expr %prec LEFTMINUSMINUS			{$$ = $2;}
	| expr '&' expr			{$$ = $1;}
	| expr '|' expr			{$$ = $1;}
	| expr "<<" expr			{$$ = $1;}
	| expr ">>" expr			{$$ = $1;}
	| '(' expr ')'			{$$ = $2;}
	;

args_opt:
	%empty {$$ = null;}
	| args {$$ = $1;}
	;

%%
