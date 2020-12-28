package ch16XMLProcessing.exercises.ex10

import java.io.{FileInputStream, PrintWriter}
import scala.xml.transform.{RewriteRule, RuleTransformer}
import scala.xml._

object Answer extends App {
  val rule1: RewriteRule = new RewriteRule {
    override def transform(n: Node) = n match {
      case e @ <img/> if e.attribute("alt").isEmpty || e.attributes("alt").text.isEmpty =>
        e.asInstanceOf[Elem] % Attribute(null, "alt", "TODO", Null)
      case _ => n
    }
  }
  val path: String = "src/main/scala/ch16XMLProcessing/exercises/ex9/test.XML"
  val root: Elem = XML.load(new FileInputStream(path))
  val transformed= new RuleTransformer(rule1).transform(root)

  val printer = new PrettyPrinter(width = 100, step = 4)
  val str = printer.formatNodes(transformed)

  val out = new PrintWriter("src/main/scala/ch16XMLProcessing/exercises/ex10/myfile.xml")
  out.println(str)
  out.close()
}
