package ch13Collections.s15ParallelCollections

import scala.collection.parallel.CollectionConverters._

object A extends App {
  val coll0: Seq[Int] = (1 to scala.Int.MaxValue)
  val coll: Seq[Int] = (1 to 100000)
  val t0 = System.nanoTime()
  coll.par.sum
  val t1 = System.nanoTime()
//  coll.sum
  val t2 = System.nanoTime()
  println("Elapsed time parallel: " + (t1 - t0) + "ns")
  println("Elapsed time seq: " + (t2 - t1) + "ns")
//  for (i <- (0 until 100000).par) print(s" $i")
  val res: Boolean = (for (i <- (0 until 100000).par) yield i) == (0 until 100000)
  println(res)

  val result = coll.par.filter(_% 2 == 0).seq
  println(result)

  val list = (1 to 10000).toList
  list.map(_ + 42)
  list.par.map(_ + 42)
}
