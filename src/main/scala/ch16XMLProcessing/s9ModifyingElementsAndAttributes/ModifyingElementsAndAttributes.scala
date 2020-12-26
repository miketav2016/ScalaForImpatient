package ch16XMLProcessing.s9ModifyingElementsAndAttributes

import scala.xml.{Attribute, Null}

object ModifyingElementsAndAttributes extends App {
  val list = <ul><li>Fred</li><li>Wilma</li></ul>
  val list2 = list.copy(label = "ol") // ul -> ol
  println(list == list2)
  list.copy(child = list.child ++ <li>Another item</li>) // added child

  val image = <img src="hamster.jpg"/>
  //The first argument is the namespace. The last one is a list of additional metadata.
  val image2 = image % Attribute(null, "alt", "An image of a hamster", Null) //add or change an attribute: operator %
  //Here, scala.xml.Null is an empty attribute list. It is not the scala.Null type.

  val image3 = image % Attribute( //add more than one attribute
    null, "alt", "An image of a frog",
    Attribute(null, "src", "frog.jpg", Null)//Adding an attribute with the same key replaces the existing one
  )


}

