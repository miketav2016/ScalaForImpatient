package ch11Operators.exercises.ex10

object PathComponents {
  def unapplySeq(path: String): Array[String] = {
    path.trim.substring(1).split('/')
  }
}
