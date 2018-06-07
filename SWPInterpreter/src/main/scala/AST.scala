sealed trait Node

case class Program(functions: List[FunctionDeclaration], main: Node) extends Node
case class FunctionDeclaration(name: String, params: List[String], body: Node) extends Node

case class expr(block: List[block], recordDef: List[recordDef], recordAccess: recordAccess, varDec1: varDec1,
                      varAssign: varAssign, cond: cond, call: call, list: list, variable: variable, int: int,
                      bool: bool, braces: braces)

case class block(expr: String)
case class recordDef(recordValueDec1: String)
case class recordAccess(recordRef: String, id: String)
case class varDec1(id: String, expr: String)
case class varAssign(id: String, expr: String)
case class cond(expr: String, expr: String, expr: String)
case class call(id:String, expr: List[String], expr: String)
case class list(expr: List[String], expr: String)
case class variable(id: String)
case class int(int: String)
case class bool(bool: String)
case class braces(expr: String)

