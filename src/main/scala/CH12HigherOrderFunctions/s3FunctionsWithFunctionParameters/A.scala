package CH12HigherOrderFunctions.s3FunctionsWithFunctionParameters

import scala.math.{ceil, sqrt}

object A extends App {
  def valueAtOneQuarter(f: (Double) => Double) = f(0.25)
  /*Since valueAtOneQuarter is a function that receives a function,
   it is called a higher-order function*/
  println(valueAtOneQuarter(ceil))
  println(valueAtOneQuarter(sqrt))
  /*A higher-order function can also produce a function*/
  def mulBy(factor : Double): Double => Double = (x : Double) => factor * x
  mulBy(3)
  println(mulBy(3)(5))
}
