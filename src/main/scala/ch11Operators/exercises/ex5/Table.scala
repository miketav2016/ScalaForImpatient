package ch11Operators.exercises.ex5

class Table {
  def recordHandler(string: String): String = {
    val elements: Array[String] = string.split("""\|""")
    elements.foldLeft("")((str, elem) => str + s"<td>$elem</td>")
  }

  def lineHandler(string: String): String = {
    val s = """\|\|"""
    val lines: Array[String] = string.substring(1).trim.split(s)
    lines.foldLeft("")((str, elem) => str + s"<tr>${recordHandler(elem)}</tr>")
  }

  def toHTMLTable(string: String): String = {
    val l = List('"',' ')
    val str = string.filterNot(l.contains).substring("<table>".length)
    val res = lineHandler(str)
    "<table>" + res
  }
}

object Table {
  def apply(): Table = new Table()
}
