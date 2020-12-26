package ch16XMLProcessing.s6UncommonNodeTypes

import scala.xml.{Group, PCData}

object UncommonNodeTypes extends App {

  val js0 = <script><![CDATA[if (temp < 0) alert("Cold!")]]></script>

  val code = """if (temp < 0) alert("Cold!")"""
  val js1 = <script>{PCData(code)}</script>
  println(js0)
  println(js1)
//  val n1 = <xml:unparsed><&></xml:unparsed> // mon recommend
//  val n2 = Unparsed("<&>")

  val g1 = <xml:group><li>Item 1</li><li>Item 2</li></xml:group>
  val g2 = Group(Seq(<li>Item 1</li>, <li>Item 2</li>))

  val items = <li>Item 1</li><li>Item 2</li>
  val group = for (n <- <xml:group>{items}</xml:group>) yield n
  // Yields two li elements
  val li = for (n <- <ol>{items}</ol>) yield n
  // Yields one ol element


}
