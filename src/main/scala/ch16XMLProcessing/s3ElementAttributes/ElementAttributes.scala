package ch16XMLProcessing.s3ElementAttributes

import scala.xml.{Elem, Node, Text}

object ElementAttributes extends App {
  val elem: Elem = <a href="http://scala-lang.org">The Scala language</a>
  val url: collection.Seq[Node] = elem.attributes("href") //this yields a node sequence
  println(url)
  val image: Elem = <img alt="San Jos&eacute; State University Logo"
  src="http://www.sjsu.edu/publicaffairs/pics/sjsu_logo_color_web.jpg"/>
  val alt: collection.Seq[Node] = image.attributes("alt")
  println(alt)
  val url1 = Option(elem.attributes("href1")).map(_.text)
  println(url1)
  val url2 = elem.attributes.get("href").getOrElse(Text(""))
  println("!!!" + url2)

}
