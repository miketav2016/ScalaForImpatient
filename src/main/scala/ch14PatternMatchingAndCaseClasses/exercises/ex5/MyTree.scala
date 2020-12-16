package ch14PatternMatchingAndCaseClasses.exercises.ex5

sealed trait MyTree
case class Tree(leaves: MyTree*) extends MyTree
case class Leaves(int: Int*) extends MyTree
