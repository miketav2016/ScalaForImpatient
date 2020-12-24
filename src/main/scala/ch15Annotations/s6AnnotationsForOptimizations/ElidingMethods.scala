package ch15Annotations.s6AnnotationsForOptimizations

import scala.annotation.elidable

object ElidingMethods extends App {
  @elidable(500) def dump(props: Map[String, String]) = {
    println("need write realization")
    10
  }
  dump(Map())

  def makeMap(keys: Seq[String], values: Seq[String]) = {
    assert(keys.length == values.length, "lengths don't match")
  }
  makeMap(Seq("",""),Seq(",",""))
}
