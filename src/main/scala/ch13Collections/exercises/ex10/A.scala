package ch13Collections.exercises.ex10

object A extends App {
  val timeZoneNameProvider: Array[String] = java.util.TimeZone.getAvailableIDs
  val res: Map[String, Array[String]] = timeZoneNameProvider.groupBy(str => str.split('/').head)
  val res1 = res.foldLeft(Map[String, Int]())((res, cur) => res + (cur._1 -> cur._2.length))
  println(res1.filter(res1.values.max == _._2).keys.head)

  val resM = java.util.TimeZone.getAvailableIDs
    .filter(_.contains('/'))
    .groupBy(str => str.split('/').head)
    .foldLeft(("", 0)) { case ((str, num), (name, array)) =>
      if (num < array.length){
        (name, array.length)
      } else {
        (str, num)
      }
    }._1
  println(resM)

}
