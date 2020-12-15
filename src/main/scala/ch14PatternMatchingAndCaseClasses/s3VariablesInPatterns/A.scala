package ch14PatternMatchingAndCaseClasses.s3VariablesInPatterns

object A extends App {
  var sign = 0
  var digit = 0
  val str = "zxvbdsdf"
  val i = 3
  str(i) match {
    case '+' => sign = 1
    case '-' => sign = -1
    case ch => digit = Character.digit(ch, 10)
  }
  println(digit)
  //The rule is that a variable must start with a lowercase letter.
  import java.io.File._ // Imports java.io.File.pathSeparator
  str match {
    case `pathSeparator` => ??? // If str == pathSeparator ...
    case pathSeparator => ???
    // Caution—declares a new variable pathSeparator
  }


}
