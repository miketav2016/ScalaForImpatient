package ch14PatternMatchingAndCaseClasses.exercises.ex8

sealed abstract class CalcTree

case class Leaf(value: Int) extends CalcTree

case class Node(operator: Operator, NTree: CalcTree*) extends CalcTree

class Operator(val num: Int, op: (Int, Int) => Int) {
  def apply(a: Int, b: Int): Int = op(a, b)
}

object Operator {
  val * = new Operator(1, _ * _)
  val + = new Operator(0, _ + _)
  val - = new Operator(0, _ - _)
}
