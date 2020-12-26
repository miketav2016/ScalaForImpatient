package ch16XMLProcessing.s10TransformingXML

import scala.xml.{Elem, Node}
import scala.xml.transform.{RewriteRule, RuleTransformer}

object TransformingXML extends App {

  val rule1: RewriteRule = new RewriteRule { //change all ul nodes in a document to ol.
    override def transform(n: Node) = n match {
      case e @ <ul>{_*}</ul> => e.asInstanceOf[Elem].copy(label = "ol")
      case _ => n
    }
  }
  val rule2 = rule1
  val rule3 = rule1
  val transformer = new RuleTransformer(rule1, rule2, rule3)
  val root: Elem = <li>Fred</li>
  val transformed = new RuleTransformer(rule1).transform(root) //Then you can transform a tree with the command


}
