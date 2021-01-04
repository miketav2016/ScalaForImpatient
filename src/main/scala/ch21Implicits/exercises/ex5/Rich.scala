package ch21Implicits.exercises.ex5

object Rich {

  implicit class RichFraction(fractionL: Fraction) extends Ordered[Fraction]{

    override def compare(that: Fraction): Int = {
      (fractionL - that).num
    }
  }

}
