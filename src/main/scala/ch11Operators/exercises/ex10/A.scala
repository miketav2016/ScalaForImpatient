package ch11Operators.exercises.ex10

object A extends App {
  val path = "/home/cay/readme.txt"
  println(PathComponents.unapplySeq(path).mkString("\n"))
}
