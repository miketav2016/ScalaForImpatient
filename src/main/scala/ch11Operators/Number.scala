package ch11Operators

object Number {
  def unapply(input: String): Option[Int] =
    try {
      Some(input.trim.toInt)
    } catch {
      case ex: NumberFormatException => None
    }

}
