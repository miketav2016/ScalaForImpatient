package ch15Annotations.s6AnnotationsForOptimizations

import scala.annotation.switch

object JumpTableGenerationAndInlining extends App {

  val n = scala.util.Random.nextInt
  println((n: @switch) match {
    case 0 => "Zero"
    case 1 => "One"
    case _ => "?"
  })
}
