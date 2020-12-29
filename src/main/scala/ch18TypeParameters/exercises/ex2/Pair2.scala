package ch18TypeParameters.exercises.ex2

class Pair2[T](var a:T, var b:T) {
  def swap(): Unit = {
    val tmp = a
    a = b
    b = tmp
  }
}
