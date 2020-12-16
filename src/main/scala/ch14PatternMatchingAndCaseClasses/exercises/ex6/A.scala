package ch14PatternMatchingAndCaseClasses.exercises.ex6

object A extends App {
  def leafSum(binaryTree: BinaryTree): Int = {
    binaryTree match {
      case Leaf(v) => v
      case Node(l, r) => leafSum(l) + leafSum(r)
    }
  }

  val bt = Node(Node(Leaf(1), Leaf(2)),Leaf(3))
  println(leafSum(bt))
}
