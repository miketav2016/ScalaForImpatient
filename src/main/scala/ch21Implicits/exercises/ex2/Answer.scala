package ch21Implicits.exercises.ex2

object Answer extends App {

  implicit class MyClass(n: Int) {
    def +%(int: Int): Int = {
      this.n + this.n * int / 100
    }
  }

  val tmp = 120 +% 10
  println(tmp)

}
