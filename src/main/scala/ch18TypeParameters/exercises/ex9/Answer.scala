package ch18TypeParameters.exercises.ex9

object Answer extends App {
  val tmp = new Pair9(4.1 ,5.1)
  val res: Pair9[Any] = tmp.replaceFirst("Hello")
  println(res.a)
}
