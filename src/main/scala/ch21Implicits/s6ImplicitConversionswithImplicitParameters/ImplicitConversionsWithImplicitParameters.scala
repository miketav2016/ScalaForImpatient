package ch21Implicits.s6ImplicitConversionswithImplicitParameters

object ImplicitConversionsWithImplicitParameters extends App {
//  def smaller[T](a: T, b: T) = if (a < b) a else b // Not quite
  def smaller[T](a: T, b: T)(implicit order: T => Ordered[T])
  = if (order(a) < b) a else b

  smaller(40, 2)
  smaller("Hello", "World")

}
