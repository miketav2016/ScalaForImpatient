package ch18TypeParameters.s1GenericClasses

object GenericClasses extends App {
  val p1: PairS1[Int, String] = new PairS1(42, "String")
  val p2: PairS1[Any, Any] = new PairS1[Any, Any](42, "String")
}
