package ch19AdvancedTypes.s7InfixTypes

object InfixTypes {
  val map1: String Map Int = Map[String, Int]()
  type ×[A, B] = (A, B)

  val tuple0: (String, Int) = ("string", 1000)
  val tuple1@(str, i): (String, Int) = ("string", 1000)
  val tuple2: String × Int = ("string", 1000)
}
