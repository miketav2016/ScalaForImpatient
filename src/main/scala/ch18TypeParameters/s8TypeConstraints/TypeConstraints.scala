package ch18TypeParameters.s8TypeConstraints

object TypeConstraints extends App {
  val friends: Map[String, String] = Map("Fred" -> "Barney")
  val friendOpt: Option[String] = friends.get("Wilma") // An Option[String]
  val friendOrNull: String = friendOpt.orNull // A String or null
  def firstLastBad[A, C <: Iterable[A]](it: C): (A, A) = (it.head, it.last)
  def firstLastFix[A, C](it: C)(implicit ev: C <:< Iterable[A]) =
    (it.head, it.last)
  println(firstLastBad[Int,List[Int]](List(1, 2, 3)))
  println(firstLastFix(List(1, 2, 3)))
}
