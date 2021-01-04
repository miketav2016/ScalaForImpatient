package ch21Implicits.exercises.ex13

object Answer extends App {
  val tmp0: String = "abc".map(_.toUpper)
  val tmp1: Seq[Int] = "abc".map(_.toInt)
  println(tmp0)
  println(tmp1)

  // string is a seq[char], when char.toInt => seq[Int]
  // and this case  can't be convert in string(it can build result `String` collection only for `Char` elements.)


}
