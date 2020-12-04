package ch11Operators.exercises.ex5

object A extends App {
  val str = """Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET"""
  val res = Table().toHTMLTable(str)
  println(res)
}
