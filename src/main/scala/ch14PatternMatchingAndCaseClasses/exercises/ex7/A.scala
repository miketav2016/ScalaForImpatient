package ch14PatternMatchingAndCaseClasses.exercises.ex7

object A extends App {
  def leafSum(binaryTree: NTree): Int = {
    binaryTree match {
      case Leaf(v) => v
      case Node(n@_*) => n.map(leafSum).sum
    }
  }
  val nTree = Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))
  println(leafSum(nTree))
}
