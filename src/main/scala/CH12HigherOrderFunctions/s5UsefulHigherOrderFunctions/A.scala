package CH12HigherOrderFunctions.s5UsefulHigherOrderFunctions

object A extends App {
  println((1 to 9).map(0.1 * _))
  (1 to 9).map("*" * _) foreach println
  (1 to 9).filter(_ % 2 == 0)
  println((1 to 9).reduceLeft(_ * _))
  "Mary had a little lamb".split(" ").sortWith(_.length < _.length)
}
