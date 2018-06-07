sealed trait Node

case class Program(functions: List[FunctionDeclaration], main: Node) extends Node
case class FunctionDeclaration(name: String, params: List[String], body: Node) extends Node

//TODO Add case classes to represent the AST.
case class Id(name: String) extends Node
case class Variable(variable: Id) extends Node
case class Int(i: Int) extends Node
case class Bool(tf: String) extends Node
case class Braces(main: Node) extends Node
case class Block(param: List[Node]) extends Node
case class VarDec1(name: Id, main: Node) extends Node
case class VarAssign(name: Id, main: Node) extends Node
case class Cond(head: Node, body: Node, tail: Node) extends Node
case class Call(name: Id, params: List[String]) extends Node
case class Liste(list: List[String]) extends Node
case class RecordDef(main: List[RecordValueDec1]) extends Node
case class RecordValueDec1(name: Id, main: Node) extends Node
case class RecordAccess(param: RecordRef, name: Id) extends Node
case class RecordRef(main : Node) extends Node
case class Expr(main : Node) extends Node
