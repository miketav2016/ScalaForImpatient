package ch18TypeParameters.s3BoundsForTypeVariables

object BoundsForTypeVariables extends App {
  val p = new PairS3("Fred", "Brooks")
  println(p.smaller)
  //val pInt = new PairS3(4, 5)
  //println(pInt.smaller) // now it's error( Int not a subtype of Comparable[Int] ), fix it next section


  val p1: PairS31[Int] = new PairS31(1,4)
  val p11: PairS31[Any] =p1.replaceFirst0("")
  val p12: PairS31[Any] =p1.replaceFirst1("")
  val p13: PairS31[Any] =p1.replaceFirst2("")
}
