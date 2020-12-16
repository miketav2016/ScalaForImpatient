package ch14PatternMatchingAndCaseClasses.exercises.ex8

object A extends App {
  def eval(calcTree: CalcTree): Int = {
    calcTree match {
      case Leaf(value) => value
      case Node(operator, n@_*) =>
        n.foldLeft(operator.num) { (acc, item) => operator(acc, eval(item)) }
    }
  }

  //(3 × 8) + 2 + (–5) = 21.
  val calcTree = Node(Operator.+, Node(Operator.*, Leaf(3), Leaf(8)), Leaf(2), Node(Operator.-, Leaf(5)))
  val res =  eval(calcTree)
  println(res)
}
