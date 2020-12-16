package ch14PatternMatchingAndCaseClasses.exercises.ex7

sealed abstract class NTree
case class Leaf(value: Int) extends NTree
case class Node(NTree: NTree*) extends NTree
