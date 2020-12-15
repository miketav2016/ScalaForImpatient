package ch14PatternMatchingAndCaseClasses.s12MatchingNestedStructures

object A extends App {
  val nestedStructures = Bundle("Father's day special", 20.0,
    Article("Scala for the Impatient", 39.95),
    Bundle("Anchor Distillery Sampler", 10.0,
      Article("Old Potrero Straight Rye Whiskey", 79.95),
      Article("Junípero Gin", 32.95)))

  nestedStructures match {
    case Bundle(_, _, Article(descr, _), _*) => println("AAAAAAAAA!!!")
    case Bundle(_, _, art @ Article(_, _), rest @ _*) => art
  }

  def price(it: Item): Double = it match {
    case Article(_, p) => p
    case Bundle(_, disc, its @ _*) => its.map(price _).sum - disc
  }

}
