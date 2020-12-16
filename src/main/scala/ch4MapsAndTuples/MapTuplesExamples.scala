package ch4MapsAndTuples

import scala.collection.mutable

object MapTuplesExamples extends App {
  // Constructing a Map
  val myMapImmutable0: Map[String, Int] = Map("bob" -> 3, "K" -> 34, "J" -> 65)
  val myMapMutable: mutable.Map[String, Int] = scala.collection.mutable.Map("bob" -> 3, "K" -> 34, "J" -> 65)
  val cleanMapMutable: mutable.Map[String, Int] = scala.collection.mutable.Map()
  val pair: (String, Int) = "" -> 0
  val myMapImmutableP: Map[String, Int] = Map(("bob" -> 3), ("K" -> 34), ("J" -> 65))
  //Accessing Map Values
  val bob: Int = myMapImmutable0("bob")
  val isBob: Int = if (myMapImmutable0.contains("bob")) myMapImmutable0("bob") else 0
  val isBobM: Int = myMapImmutable0.getOrElse("bob", 0)
  val myMapImmutable1: Map[String, Int] = myMapImmutable0.withDefaultValue(0)
  //  println(myMapImmutable1("afdg"))
  val myMapImmutable2: Map[String, Int] = myMapImmutable0.withDefault(_.length)
  //  println(myMapImmutable2("afdg"))
  //Updating Map Values
  //mutable
  myMapMutable("bob") = 999 //update value by key
  myMapMutable("newBob") = -999 //add to map
  myMapMutable += "0" -> 0 //add to map
  myMapMutable ++= List("" -> 0, "--" -> 10) //add to map
  myMapMutable -= "0" //remove from map
  //immutable
  val myMapImmutableUpdate = myMapImmutable0 + ("bob" -> 80, "--" -> 10)
  // or  used var
  var myMapImmutable01 = Map("bob" -> 3, "K" -> 34, "J" -> 65)
  myMapImmutable01 = myMapImmutable01 + ("bob" -> 80, "--" -> 10)
  myMapImmutable01 ++= List("bob" -> 80, "--" -> 10)
  myMapImmutable01 = myMapImmutable01 - "bob"
  myMapImmutable01 -= "bob"
  //Iterating over Maps
  for ((k, v) <- myMapImmutable0) println(s"Key: $k  Value: $v")
  myMapImmutable0.keySet
  for (v <- myMapImmutable0.values) println(v)
  println(for ((k, v) <- myMapImmutable0) yield (v, k))
  //Sorted Maps
  val sortedMapMut = scala.collection.mutable.SortedMap(
    "bob" -> 3,
    "K" -> 34,
    "J" -> 65,
    "a" -> 999
  )
  println(sortedMapMut)
  val months = scala.collection.mutable.LinkedHashMap(
    "j" -> 1,
    "f" -> 2,
    "m" -> 3,
    "a" -> 4
  )
  // Interoperating with Java

  import scala.jdk.CollectionConverters.MapHasAsScala

  val scores: mutable.Map[String, Int] = new java.util.TreeMap[String, Int]().asScala
  val props: mutable.Map[AnyRef, AnyRef] = System.getProperties.asScala

  import java.awt.font.TextAttribute._
  import scala.jdk.CollectionConverters.MapHasAsJava
  import java.awt.font.TextAttribute

  val attrs: Map[TextAttribute, Any] = Map(FAMILY -> "Serif", SIZE -> 12) // A Scala map
  val font = new java.awt.Font(attrs.asJava) // Expects a Java map
  //Tuples
  val myTuple0: (Int, Double, String) = (1, 3.14, "Fred")
  val myTuple1: Tuple3[Int, Double, String] = (1, 3.14, "Fred")
  // can be able access be ._N -where N num

  import collection.SortedMap
  //example
  var t: SortedMap[String, Int] = SortedMap[String, Int]() ++ new java.util.TreeMap[String, Int].asScala

  import scala.language.postfixOps

  println(myTuple0._2 * (myTuple1 _2))
  val (first0, second0, third) = myTuple0
  val (first1, second1, _) = myTuple1
  println("New York".partition(_.isUpper))
  //Zipping
  val symbols = Array("<", "-", ">")
  val counts = Array(2, 10, 2)
  val pairs: Array[(String, Int)] = symbols.zip(counts)
  println(pairs.mkString("Array(", ", ", ")"))
  for ((s, n) <- pairs) print(s * n) // Prints <<---------->>
  println
  println(symbols.zip(counts).toMap)
}
