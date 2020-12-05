package ch11Operators.exercises.ex9

object A extends App {
  val path = "/home/cay/readme.txt"
  println(PathComponents.unapply(path))
}
