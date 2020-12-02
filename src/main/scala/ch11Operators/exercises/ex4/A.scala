package ch11Operators.exercises.ex4

object A extends App {
  val res = new Money(1, 75) + new Money(0, 50) ==  new Money(2, 25)
  println(res)
  println(new Money(1, 75) * 100)
  println(new Money(1, 75) / 100)
}
