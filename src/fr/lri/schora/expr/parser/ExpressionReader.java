/* Generated By:JavaCC: Do not edit this line. ExpressionReader.java */
package fr.lri.schora.expr.parser;
import fr.lri.schora.expr.*;

import java.util.*;
public class ExpressionReader implements ExpressionReaderConstants {

//EXPRESSION
  final public Expression expression() throws ParseException {
  Token op;
  Expression l,r;
    l = expression_1();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMPUTATION_OPERATION_1:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      op = jj_consume_token(COMPUTATION_OPERATION_1);
      r = expression_1();
                        BinaryExpression rel = ExprFactory.eINSTANCE.createBinaryExpression();
                        rel.setLeft(l);
                        rel.setOp(op.image);
                        rel.setRight(r);
                        l = rel;
    }
          {if (true) return l;}
    throw new Error("Missing return statement in function");
  }

  final public Expression expression_1() throws ParseException {
  Token op;
  Expression l,r;
    l = expression_2();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMPUTATION_OPERATION_2:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      op = jj_consume_token(COMPUTATION_OPERATION_2);
      r = expression_2();
                        BinaryExpression rel = ExprFactory.eINSTANCE.createBinaryExpression();
                        rel.setLeft(l);
                        rel.setOp(op.image);
                        rel.setRight(r);
                        l = rel;
    }
                {if (true) return l;}
    throw new Error("Missing return statement in function");
  }

  final public Expression expression_2() throws ParseException {
  Token l;
  Expression ex;
  List<Variable > vars;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      l = jj_consume_token(INT);
                fr.lri.schora.expr.Integer i = ExprFactory.eINSTANCE.createInteger();
                i.setValue(java.lang.Integer.parseInt(l.image));
                {if (true) return i;}
      break;
    case IDENT:
      l = jj_consume_token(IDENT);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 15:
        jj_consume_token(15);
        vars = variables();
        jj_consume_token(16);
            Function f = ExprFactory.eINSTANCE.createFunction();
                f.setName(l.image);
                f.getVariables().addAll(vars);
                {if (true) return f;}
        break;
      default:
        jj_la1[2] = jj_gen;
        ;
      }
                Variable v = ExprFactory.eINSTANCE.createVariable();
                v.setName(l.image);
                {if (true) return v;}
      break;
    case STRING:
      l = jj_consume_token(STRING);
                String str = l.image;
            str = str.substring(1, str.length()-1);

                StringValue s = ExprFactory.eINSTANCE.createStringValue();
                s.setValue(str);
                {if (true) return s;}
      break;
    case CONST:
      l = jj_consume_token(CONST);
          Constance c = ExprFactory.eINSTANCE.createConstance();
          c.setName(l.image);
          {if (true) return c;}
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public List<Variable > variables() throws ParseException {
        List<Variable > lst = new ArrayList<Variable >();
        Token l;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENT:
      l = jj_consume_token(IDENT);
                  Variable v = ExprFactory.eINSTANCE.createVariable();
                  v.setName(l.image);
                  lst.add(v);
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
          {if (true) return lst;}
    throw new Error("Missing return statement in function");
  }

//CONDITION
  final public Condition condition() throws ParseException {
  Token op;
  Condition l,r;
  fr.lri.schora.expr.Boolean b;
    l = condition2();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENT:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_3;
      }
      op = jj_consume_token(IDENT);
      r = condition2();
                        BinaryCondition rel;
                        if (op.image.equals("and"))
                                rel = ExprFactory.eINSTANCE.createAnd();
                        else if (op.image.equals("or"))
                                rel = ExprFactory.eINSTANCE.createOr();
                        else
                                {if (true) return null;}
                        rel.setExpr(l);
                        rel.setExpr2(r);

                        l = rel;
    }
         {if (true) return l;}
    throw new Error("Missing return statement in function");
  }

  final public Condition condition2() throws ParseException {
  Token op;
  Expression l,r;
  Condition b;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENT:
    case CONST:
    case INT:
    case STRING:
      l = expression();
      op = jj_consume_token(RELATION_OPERATION);
      r = expression();
                        RelationalCondition rel = ExprFactory.eINSTANCE.createRelationalCondition();
                        rel.setLeft(l);
                        rel.setOp(op.image);
                        rel.setRight(r);
                        {if (true) return rel;}
      break;
    case TRUE:
    case FALSE:
    case 15:
      b = condition3();
                {if (true) return b;}
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Condition condition3() throws ParseException {
  Condition c;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TRUE:
      jj_consume_token(TRUE);
                {if (true) return ExprFactory.eINSTANCE.createBTrue();}
      break;
    case FALSE:
      jj_consume_token(FALSE);
                {if (true) return ExprFactory.eINSTANCE.createBFalse();}
      break;
    case 15:
      jj_consume_token(15);
      c = condition();
      jj_consume_token(16);
          {if (true) return c;}
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public ExpressionReaderTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[8];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x200,0x400,0x8000,0x7800,0x800,0x800,0xf8c0,0x80c0,};
   }

  /** Constructor with InputStream. */
  public ExpressionReader(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ExpressionReader(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ExpressionReaderTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ExpressionReader(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ExpressionReaderTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ExpressionReader(ExpressionReaderTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ExpressionReaderTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[17];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 8; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 17; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}