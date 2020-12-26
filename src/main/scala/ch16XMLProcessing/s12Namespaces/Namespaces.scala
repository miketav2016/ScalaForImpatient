package ch16XMLProcessing.s12Namespaces

import scala.xml.{Attribute, Elem, NamespaceBinding, Node, Null, TopScope}

object Namespaces extends App {
  def namespaces(node: Node): List[(String, String)] = {
    def namespaces(scope: NamespaceBinding): List[(String, String)] =
      if (scope == null) {
        List()
      }
      else {
        namespaces(scope.parent) :+ ((scope.prefix, scope.uri))
      }

    namespaces(node.scope)
  }

  /**
   * To get the namespace of an attribute, use the prefixedKey method.
   * When you produce XML elements programmatically, you need to set prefixes and scopes.
   */
  val scope = new NamespaceBinding("svg", "http://www.w3.org/2000/svg", TopScope)
  val attrs = Attribute(null, "width", "100",
    Attribute(null, "height", "100", Null))
  val elem = Elem(null, "body", Null, TopScope, minimizeEmpty = true,
    Elem("svg", "svg", attrs, scope))
}
