package ch14PatternMatchingAndCaseClasses.exercises.ex5

object A extends App {
  val myTree = Tree(Tree(Leaves(3), Leaves(8)), Leaves(2), Tree(Leaves(5)))

  def leafSum(tree: MyTree): Int = {
    tree match {
      case Tree(leaves@_*) => leaves.map(t => leafSum(t)).sum
      case Leaves(i: Int) => i
    }
  }

  println(leafSum(myTree))
}
