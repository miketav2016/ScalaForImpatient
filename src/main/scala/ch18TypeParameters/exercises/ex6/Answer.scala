package ch18TypeParameters.exercises.ex6

object Answer extends App {
  def middleElement[T](iterable: Iterable[T]) = {
    val middle: Int = iterable.size / 2 + iterable.size % 2
    iterable.take(middle).last
  }
  println(middleElement("World"))
}
