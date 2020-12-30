package ch19AdvancedTypes.s5StructuralTypes

object StructuralTypes extends App {
  //You can call the appendLines method with an instance of any class that has an append method.
  def appendLines(target: {def append(str: String): Any},
                  lines: Iterable[String]) {
    for (l <- lines) {
      target.append(l)
      target.append("\n")
    }
  }
}
