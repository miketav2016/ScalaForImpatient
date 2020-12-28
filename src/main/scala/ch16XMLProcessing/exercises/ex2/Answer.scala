package ch16XMLProcessing.exercises.ex2

import scala.xml.Elem

object Answer extends App {

  val tmp: Elem = <ul>
    <li>Opening bracket: [</li>
    <li>Closing bracket: ]</li>
    <li>Opening brace: {{</li>
    <li>Closing brace: }}</li>
  </ul>
  println(tmp)
}
