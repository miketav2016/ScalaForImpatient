package ch21Implicits.s11CanBuildFromDemystified

import scala.collection.BuildFrom

object CanBuildFromDemystified extends App {
  def map[B, That](f : (A) => B)(implicit bf: BuildFrom[Repr, B, That]): That = {
    val builder = bf()
    val iter = iterator()
    while (iter.hasNext) builder += f(iter.next())
    builder.result
  }

}
