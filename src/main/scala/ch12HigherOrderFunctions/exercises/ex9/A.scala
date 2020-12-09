package ch12HigherOrderFunctions.exercises.ex9

object A extends App {
  def corresponds[A, B](a: Seq[A], b: Seq[B], foo: (A, B) => Boolean): Boolean = {
    !a.zip(b).map(x => foo(x._1, x._2)).contains(false)
//    a.zip(b).forall(x => foo(x._1, x._2))

  }
  val a = Array("Hello", "World")
  val b = Array(5, 5)
//  println(a.corresponds(b)(_.length == _))
  println(corresponds(a, b, (_: String).length == (_: Int)))
}
