package ch20Parsing.s5GeneratingParseTrees

class Expr
case class Number(value: Int) extends Expr
case class Operator(op: String, left: Expr, right: Expr) extends Expr
