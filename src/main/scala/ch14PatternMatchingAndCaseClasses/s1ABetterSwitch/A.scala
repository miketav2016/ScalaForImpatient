package ch14PatternMatchingAndCaseClasses.s1ABetterSwitch

import java.awt.Color

object A extends App {
  var sign = 0
  val ch: Char = '*'
  ch match {
    case '+' => sign = 1
    case '-' => sign = -1
    case _ => sign = 0 // default case
  }
  sign = ch match {
    case '+' => 1
    case '-' => -1
    case _ => 0
  }
  val prefix = "0x"
  prefix match {
    case "0" | "0x" | "0X" => println("true case")
    case _ => println("false case")
  }
  val color = Color.BLACK
  color match {
    case Color.RED => println(color)
    case Color.BLACK =>  println(color)
  }

}
