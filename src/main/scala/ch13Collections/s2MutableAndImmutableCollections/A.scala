package ch13Collections.s2MutableAndImmutableCollections

object A extends App {
  /*
  * If n was already in the set, you just get a reference to the old set.
  */
  def digits(n: Int): Set[Int] =
    if (n < 0) digits(-n)
    else if (n < 10) Set(n)
    else digits(n / 10) + (n % 10)

  val res = digits(987)
  println(res)
}
