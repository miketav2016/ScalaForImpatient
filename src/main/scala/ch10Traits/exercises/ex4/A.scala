package ch10Traits.exercises.ex4

object A extends App {
  val msg = "my Caesar cipher"
  val msg1 = (new Logger).encrypts(msg)
  val msg2 = (new Logger).encrypts(msg1, -3)
  println(msg2 equals msg)
}
