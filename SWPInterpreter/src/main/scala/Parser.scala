import scala.util.parsing.combinator._

class ExpParser extends JavaTokenParsers {

  // TODO Implement the expression parser and add additional parsers for terminal and non terminal symbols, where necessary.
  def program: Parser[Program] = ???
kjdnfjksdj00
  def id = """(a-z)(A-Z|a-z|0-9|?|_)*"""
  def int = """0 | (1-9)(0-9)* | -(1-9)(0-9)*"""


}

object ParseProgram extends ExpParser {
  def parse(s: String): ParseResult[Program] = {
    parseAll(program, s)
  }
}
