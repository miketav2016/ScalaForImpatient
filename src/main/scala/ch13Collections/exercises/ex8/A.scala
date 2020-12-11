package ch13Collections.exercises.ex8

object A extends App {
  def arrayToTwoDimArray[T](array: Array[T]): Iterator[Array[T]] = {
    array.grouped(array.length/2)
  }

  val array = Array[Int](1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
  val res = arrayToTwoDimArray(array)
  res.foreach(l1 => {
    l1.foreach(l2 => print(l2 +" "))
    println()
  })
}
