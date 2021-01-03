package ch21Implicits.s5ImplicitParameters

object ImplicitParameters {
  def quote(what: String)(implicit delims: Delimiters) = {
    delims.left + what + delims.right
  }
  quote("Bonjour le monde")(Delimiters("«", "»")) // Returns «Bonjour le monde»
  implicit val quoteDelimiters: Delimiters = Delimiters("«", "»")
  quote("Bonjour le monde")

}
