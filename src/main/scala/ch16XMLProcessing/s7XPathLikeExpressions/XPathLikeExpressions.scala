package ch16XMLProcessing.s7XPathLikeExpressions

object XPathLikeExpressions extends App {
  val list = <dl><dt>Java</dt><dd>Gosling</dd><dt>Scala</dt><dd>Odersky</dd></dl>
  val languages = list \ "dt" // Or "body" , "_"(ALL) , "li" - contain ul and ol
  languages.foreach(println)
  val tmp = for (n <- list \\ "_") yield n
  println(tmp)
  val doc = <img src="hamster.jpg"/><img src="frog.jpg"/>
  val tmp1 = (doc \\ "@src").text
  println(tmp1)
}
