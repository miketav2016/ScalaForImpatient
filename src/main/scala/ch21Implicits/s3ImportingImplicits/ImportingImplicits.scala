package ch21Implicits.s3ImportingImplicits


object ImportingImplicits extends App {

  //  import ch21Implicits.s3ImportingImplicits.FractionConversions._

  import ch21Implicits.s3ImportingImplicits.FractionConversions.{fraction2Double => _, _}

  //it must be imported without a prefix
  val result = 3 * Fraction(4, 5) // now int2Fractionimporn from FractionConversions O_o
  println(result)

}
