package ch15Annotations.s6AnnotationsForOptimizations

import scala.annotation.elidable
import scala.annotation.elidable.{FINE, WARNING}

object Test extends App {
  def expensiveComputation(): Int = { Thread.sleep(1000) ; 172 }

  @elidable(WARNING) def warning(msg: String) = println(msg)
  @elidable(FINE) def debug(msg: String)      = println(msg)
  @elidable(FINE) def computedValue           = expensiveComputation()

  warning("Warning! Danger! Warning!")
  debug("Debug! Danger! Debug!")
  println("I computed a value: " + computedValue)
}
