package ch21Implicits.exercises.ex3

object Answer extends App {

  implicit class MyClass(val n: Int) {
    def !(): Int = {
      n match {
        case i if i > 0 => n * ((n - 1).!())
        case _ => 1
      }
    }
  }

  val tmp = 5.!
  println(tmp)

}
