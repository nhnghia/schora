/* Generated By:JavaCC: Do not edit this line. SchoraReaderConstants.java */
package fr.lri.schora.core.parser;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface SchoraReaderConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int DECLARATIONS = 10;
  /** RegularExpression Id. */
  int COMPONENT = 11;
  /** RegularExpression Id. */
  int CHORD = 12;
  /** RegularExpression Id. */
  int STG = 13;
  /** RegularExpression Id. */
  int COMMANDS = 14;
  /** RegularExpression Id. */
  int SHOW_STG = 15;
  /** RegularExpression Id. */
  int SHOW_TIME = 16;
  /** RegularExpression Id. */
  int SHOW_STAT = 17;
  /** RegularExpression Id. */
  int PROJECTION = 18;
  /** RegularExpression Id. */
  int CONFORMANCE = 19;
  /** RegularExpression Id. */
  int SHOW_REACHABLE_STG = 20;
  /** RegularExpression Id. */
  int SHOW_REALIZABLE_STG = 21;
  /** RegularExpression Id. */
  int SYNC = 22;
  /** RegularExpression Id. */
  int ASYNC_SENDER = 23;
  /** RegularExpression Id. */
  int ASYNC_RECEIVER = 24;
  /** RegularExpression Id. */
  int ASYNC_DISJOINT = 25;
  /** RegularExpression Id. */
  int COM_END = 26;
  /** RegularExpression Id. */
  int SCRIPT = 27;
  /** RegularExpression Id. */
  int IDENT = 28;
  /** RegularExpression Id. */
  int UNEXPECTED_CHAR = 29;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int IN_COMMENT = 1;
  /** Lexical state. */
  int IN_COMPONENT = 2;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\r\"",
    "\"\\t\"",
    "\"\\n\"",
    "<token of kind 5>",
    "\"/*\"",
    "<token of kind 7>",
    "\"/*\"",
    "\"*/\"",
    "\"DECLARATIONS\"",
    "\"component\"",
    "\"chorD\"",
    "\"STG\"",
    "\"COMMANDS\"",
    "\"showSTG\"",
    "\"showTime\"",
    "\"showStat\"",
    "\"projection\"",
    "\"conformance\"",
    "\"showReachableSTG\"",
    "\"showRealizableSTG\"",
    "\"SYNC\"",
    "\"ASYNC_SENDER\"",
    "\"ASYNC_RECEIVER\"",
    "\"ASYNC_DISJOINT\"",
    "\"end component\"",
    "<SCRIPT>",
    "<IDENT>",
    "<UNEXPECTED_CHAR>",
  };

}