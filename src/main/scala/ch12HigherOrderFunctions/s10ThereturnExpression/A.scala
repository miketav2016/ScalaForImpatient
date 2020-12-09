package ch12HigherOrderFunctions.s10ThereturnExpression

import ch12HigherOrderFunctions.s9ControlAbstractions.A.until

object A extends App {
  def indexOf(str: String, ch: Char): Int = {
    var i = 0
    until(i == str.length) {
      if (str(i) == ch) return i
      i += 1
    }
    return -1
  }
  println(indexOf("hello world",'7'))
  /*
  * If the exception is caught in a try block, before it is delivered to the named function, then the
  value will not be returned.*/

}
