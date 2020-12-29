package ch18TypeParameters.s2GenericFunctions

object GenericFunctions extends App {
  def getMiddle[T](a: Array[T]): T = a(a.length / 2)

  val tmp0 = getMiddle(Array("Mary", "had", "a", "little", "lamb")) // Calls getMiddle[String]
  println(tmp0)

  val f = getMiddle[String] _ // The function, saved in f
  val tmp1 = f(Array("Mary", "had", "a", "little", "lamb"))
  println(tmp0 ==  tmp1)
}
