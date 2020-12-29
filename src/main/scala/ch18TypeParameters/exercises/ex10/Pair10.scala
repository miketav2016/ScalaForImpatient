package ch18TypeParameters.exercises.ex10

class Pair10[T, S](var a: T, var b: S) {
  def swap(implicit ev: T =:= S): Unit = {
    val tmp = a.asInstanceOf[S]
    a = b.asInstanceOf[T]
    b = tmp
  }
}
