package ch13Collections.exercises.ex5

object A extends App {
  def likeMkString(iterable: Iterable[String]): String = {
    iterable.iterator.reduceLeft((l,r) => l + " " + r)
  }
  val tmp = Array[String](" g"," g"," g"," g"," g"," g"," g" )
  println(tmp.mkString(" "))
  println(likeMkString(tmp))
}
