package ch11Operators.exercises.ex8

object A extends App {
  val m0 = Matrix.apply(Seq(2,3,4,5))
  val m1 = m0
  val m2 = m0 + m1 + m1
  println(m2)
  println(m2 + 1)
  println(m2 * 2)
  val m21 = Matrix.apply(2,2, Seq(1,2,3,4))
  val m12 = Matrix.apply(2,2, Seq(1,2,3,4))
  println(m21 * m12)
}
