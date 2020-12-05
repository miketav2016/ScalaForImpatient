package ch11Operators.exercises.ex7

object A extends  App {
  val t: BitSequence = (new BitSequence(8))
  val t1: Long = (new BitSequence(8)).apply(2)
  println(t.bits)
  println(t1)
  println()
  println(t.apply(3))
  println(t.update(3, isNeg = true))
  println(t.update(3, isNeg = false))
}
