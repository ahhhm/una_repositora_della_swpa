import scala.util.parsing.combinator._

class ExpParser extends JavaTokenParsers {

  // TODO Implement the expression parser and add additional parsers for terminal and non terminal symbols, where necessary.
  def program: Parser[Program] = rep(function ~ ";") ~ expr ^^ {case f ~ e => new Program(f, e)}

  def function: Parser[FunctionDeclaration] = ("fun" ~> ident) ~ id ~ ("(" ~> arguments) ~ rep1(rep(id ~ ("," ~> arguments)) ~ id) ~ (")" ~> arguments) ~ ("=" ~> arguments) ~ expr ^^

  def expr = block | recordDef | recordAccess | varDec1 | varAssign | cond | call | list | variable | int | bool | braces
  def recordRef = block | call | variable | recordDef | braces
  def id = """(a-z)(A-Z|a-z|0-9|?|_)""".r ^^ {_.toString }
  def int = """0 | (1-9)(0-9)* | -(1-9)(0-9)""".r ^^ {_.toInt }
  def block = "{" ~ expr ~ ")"
  def varDec1 = "$" ~ id ~ "=" ~ expr
  def varAssign = id ~ "=" ~ expr
  def cond = "if" ~ expr ~ "then" ~ expr ~ "else" ~ expr
  def call = id ~ "(" ~ rep1(rep(expr ~ ", ") ~ expr) ~ ")"
  def list = "[" ~ rep1(rep(expr ~ ", ") ~ expr) ~ "]"
  def variable = id
  def recordDef = "object" ~ "{" ~ rep(recordValueDec1 ~ ";") ~ "}"
  def recordValueDec1 = "$" ~ id ~ "=" ~ expr
  def recordAccess = recordRef ~ "." ~ id

}

object ParseProgram extends ExpParser {
  def parse(s: String): ParseResult[Program] = {
    parseAll(program, s)
  }
}
