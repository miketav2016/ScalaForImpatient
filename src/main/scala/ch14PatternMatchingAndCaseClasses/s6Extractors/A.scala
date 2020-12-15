package ch14PatternMatchingAndCaseClasses.s6Extractors

object A extends App {
  val pattern = "([0-9]+) ([a-z]+)".r
  "99 bottles" match {
    case pattern(num, item) => println(s"num = $num item = $item")
    // Sets num to "99", item to "bottles"
    //Note that here the extractor isn’t a companion object but a regular expression object.
  }
}
