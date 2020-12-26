package ch16XMLProcessing.s11LoadingAndSaving

import java.io.{File, FileInputStream, InputStreamReader}
import scala.xml.dtd.{DocType, PublicID}
import scala.xml.parsing.ConstructingParser
import scala.xml.{Document, Elem, Node, NodeBuffer, NodeSeq, PrettyPrinter, XML}

object LoadingAndSaving extends App {
  val path: String = "src/main/resources/myfile.xml"
  val root1: Elem = XML.loadFile(path)
  val root2: Elem = XML.load(new FileInputStream(path))
  val root3: Elem = XML.load(new InputStreamReader(new FileInputStream(path), "UTF-8"))
  //  val root4 = XML.load(new URL("http://horstmann.com/index.html"))
  //  for (n <- root4.child) println(n)

  val parser: ConstructingParser = ConstructingParser.fromFile(new File(path), preserveWS = true)
  val doc: Document = parser.document
  val root: Node = doc.docElem
  println(root)
  XML.save("src/main/scala/ch16XMLProcessing/s11LoadingAndSaving/myfile.xml", root)
  XML.save("src/main/scala/ch16XMLProcessing/s11LoadingAndSaving/myfile1.xhtml", root,
    enc = "UTF-8",
    xmlDecl = true,
    doctype = DocType("html",
      PublicID("-//W3C//DTD XHTML 1.0 Strict//EN",
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"),
      Nil))
  XML.write(java.io.Writer.nullWriter(), root, "UTF-8", xmlDecl = false, null)

  val printer = new PrettyPrinter(width = 100, step = 4)

  val items: NodeBuffer = new NodeBuffer
  items += <li>Fred</li>
  items += <li>Wilma</li>
  items += <!-- ... -->
  val nodes: NodeSeq = items
  val str = printer.formatNodes(nodes)
  println(str)

}
