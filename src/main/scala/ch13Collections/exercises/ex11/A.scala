package ch13Collections.exercises.ex11

import scala.collection.immutable.HashMap
import scala.collection.parallel.CollectionConverters._

object A extends App {
  val str = ".zd.fjkhbafv;asdf;vbadfbg;ahgashv;snbv;kbasgh'gfdf;kjgbdnb,mcvbkdbvnvc.,bndbvjdf;bnc.,ndflng;ejhg;ngldvnb;kjadn'lkadfn;bsndf;bnsdk;jbnsdlhbvlfhbg;dfb;kdzfbnv;dfnb;ksdbn" * 1000000

  def frequenciesHackerParallel(str: String): collection.Map[Char, Int] = {
    val t0 = System.nanoTime()
    val frequencies = new scala.collection.mutable.HashMap[Char, Int]
    for (c <- str.toCharArray.par) frequencies(c) = frequencies.getOrElse(c, 0) + 1
    val t1 = System.nanoTime()
    println("One thread time Par: " + (t1 - t0) + "ns")
    frequencies
  }

  def frequenciesHackerOneThread(str: String): collection.Map[Char, Int] = {
    val t0 = System.nanoTime()
    val frequencies = new scala.collection.mutable.HashMap[Char, Int]
    for (c <- str) frequencies(c) = frequencies.getOrElse(c, 0) + 1
    val t1 = System.nanoTime()
    println("One thread time One: " + (t1 - t0) + "ns")
    frequencies
  }

  def frequenciesHackerOneThreadM1(str: String): collection.Map[Char, Int] = {
    val t0 = System.nanoTime()
    val res = str.foldLeft(Map[Char, Int]())((map, ch) => map + (ch -> (map.getOrElse(ch, 0) + 1)))
    val t1 = System.nanoTime()
    println("One thread time O1 : " + (t1 - t0) + "ns")
    res
  }

  def frequenciesHackerNThread(str: String): collection.Map[Char, Int] = {
    val t0 = System.nanoTime()
    val res = str.toCharArray.par.aggregate(HashMap[Char, Int]())((map, c) =>
      map + (c -> (map.getOrElse(c, 0) + 1)),
      (mapA, mapB) => mapA.merged(mapB) { case ((ak, av), (bk, bv)) => (ak, av + bv) }
    )
    val t1 = System.nanoTime()
    println("One thread time P1 : " + (t1 - t0) + "ns")
    res
  }

  frequenciesHackerOneThread(str)
  frequenciesHackerOneThreadM1(str)
  frequenciesHackerParallel(str)
  frequenciesHackerNThread(str)
}
