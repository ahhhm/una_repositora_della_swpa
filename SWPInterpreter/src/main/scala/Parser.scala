import scala.util.parsing.combinator._

class ExpParser extends JavaTokenParsers {

  def expr = block | recordDef | recordAccess | varDec1 | varAssign | cond | call | list | variable | int | bool | braces ^^ {_ => Expr(_)}

  // TODO Implement the expression parser and add additional parsers for terminal and non terminal symbols, where necessary.
  def program: Parser[Program] = rep(function ~ ";".r) ~ epxr







  def function: Parser[FunctionDeclaration] = "fun".r ~ id ~ "(".r ~ rep1("[".r ~ rep(id ~ ",".r) ~ id) ~ ")".r ~ "=".r ~ expr
  def braces = "(".r ~ expr ~ ")".r
  def block = "{".r ~ rep(expr ~ ";".r) ~ "}".r
  def varDec1 = "$".r ~ id ~ "=".r ~ expr
  def varAssign = id ~ "=".r ~ expr
  def cond = "if".r ~ expr ~ "then".r ~ expr ~ "else".r expr
  def call = id ~ "(".r ~ rep1(rep(expr ~ ";".r) ~ expr) + ")".r
  def list = "[".r ~ rep1(rep(expr ~ ",".r)~ expr) ~ "]".r
  def variable = id
  def recordDef = "object".r ~ "{".r ~ rep(recordValueDec1 ~ ";".r) ~ "}".r
  def recordValueDec1 = "$".r ~ id ~ "=".r ~ expr
  def recordRef = block | call | variable | recordDef | braces ^^ {_ => RecordRef(_)}
  def recordAccess = recordRef ~ ".".r ~ id
  def int = """0 | (1-9)(0-9)* | -(1-9)(0-9)*""".r ^^ {_.toInt}
  def id = """(a-z)(A-Z | a-z | 0-9 | ? | _)*""".r ^^ {_to.String}
  def bool = """True | False""".r
}

object ParseProgram extends ExpParser {
  def parse(s: String): ParseResult[Program] = {
    parseAll(program, s)
  }
}
