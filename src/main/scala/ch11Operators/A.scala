package ch11Operators

object A extends App {
  val Fraction(a, b) = Fraction(3, 4) * Fraction(2, 5)
  val result = Fraction(3, 4) * Fraction(2, 5)
  println(s"$a $b")
  val author = "Cay Horstmann"
  val Name(first, last) = author // Calls Name.unapply(author)
  val Number(n) = "1729"
  author match {
    case Name(first, IsCompound()) => println("only first name")
    // Matches if the last name is compound, such as van der Linden
    case Name(first, last) => println("full name")
  }

  author match {
    case Name(first, last) => println(1)
    case Name(first, middle, last) => println(2)
    case Name(first, "van", "der", last) => println(3)
  }

  val sysProps = new DynamicProps(System.getProperties)
  sysProps.username = "Fred" // Sets the "username" property to "Fred"
  val home = sysProps.java_home // Gets the "java.home" property
  sysProps.add(username="Fred", password="Secret")
}
