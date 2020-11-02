package chapter4


import java.util
import java.util.Properties

import scala.collection.mutable
import scala.jdk.CollectionConverters._


object MapTuplesExercises extends App {
  //1. Set up a map of prices for a number of gizmos that you covet. Then produce a second map with
  //the same keys and the prices at a 10 percent discount.
  val itemPrice = Map(
    "float" -> 3200000,
    "bike" -> 75000,
    "suit" -> 30000,
    "boots" -> 8500,
    "jacket" -> 5000
  )
  val itemPriceDis = itemPrice.map { case (item, price) => (item, price * .9) }
  //  println(itemPriceDis)
  //2.Write a program that reads words from a file. Use a mutable map to count how often each word
  //appears. To read the words, simply use a java.util.Scanner:
  //val in = new java.util.Scanner(new java.io.File("myfile.txt"))
  //while (in.hasNext()) process in.next()

  val in = new java.util.Scanner(new java.io.File("src/main/scala/chapter4/MapTuplesExamples.scala"))
  val mapCountMutt: mutable.Map[String, Int] = scala.collection.mutable.Map()
  while (in.hasNext()) {
    val currentWords = in.next()
    mapCountMutt += currentWords -> (if (mapCountMutt.contains(currentWords)) {
      mapCountMutt(currentWords) + 1
    } else {
      1
    }
      )
  }
  //  println(mapCount.mkString("Map ( \n", " \n", "\n)"))
  //4. Repeat the preceding exercise with an immutable map
  //val myMapImmutableUpdate = myMapImmutable0 + ("bob" -> 80, "--" -> 10)
  val in1 = new java.util.Scanner(new java.io.File("src/main/scala/chapter4/MapTuplesExamples.scala"))
  var mapCountIm: Map[String, Int] = Map()
  while (in1.hasNext()) {
    val currentWords = in1.next()
    val pair: (String, Int) = currentWords -> (mapCountIm.getOrElse(currentWords, 0) + 1)
    mapCountIm = mapCountIm + pair
  }
  //  println(mapCountIm.mkString("Map ( \n", " \n", "\n)"))
  //5. Repeat the preceding exercise with a sorted map, so that the words are printed in sorted order.
  val inS = new java.util.Scanner(new java.io.File("src/main/scala/chapter4/MapTuplesExamples.scala"))
  var mapCountS: Map[String, Int] = scala.collection.immutable.SortedMap()
  while (in1.hasNext()) {
    val currentWords = in1.next()
    val pair: (String, Int) = currentWords -> (mapCountS.getOrElse(currentWords, 0) + 1)
    mapCountS = mapCountS + pair
  }
  //  println(mapCountIm.mkString("Map ( \n", " \n", "\n)"))
  //6. Repeat the preceding exercise with a java.util.TreeMap that you adapt to the Scala API

  import scala.jdk.CollectionConverters.MapHasAsScala

  val inJ = new java.util.Scanner(new java.io.File("src/main/scala/chapter4/MapTuplesExamples.scala"))
  var mapCountJ: util.TreeMap[String, Int] = new java.util.TreeMap[String, Int]()

  while (inJ.hasNext()) {
    val currentWords = inJ.next()
    val (k, v) = currentWords -> (mapCountJ.asScala.getOrElse(currentWords, 0) + 1)
    mapCountJ.put(k, v)
  }
  //  println(mapCountIm.mkString("Map ( \n", " \n", "\n)"))
  //7. Print a table of all Java properties reported by the getProperties method of the
  //java.lang.System class
  val property: Properties = java.lang.System.getProperties
  val likeScala: mutable.Map[String, String] = property.asScala
  val maxLength = likeScala.keySet.map(_.length).max + 10
  for ((k,v) <- likeScala) println(k + " " * (maxLength - k.length) + " | " + v)
}
