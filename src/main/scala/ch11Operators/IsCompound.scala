package ch11Operators

object IsCompound {
  def unapply(input: String): Boolean = input.contains(" ")
}
