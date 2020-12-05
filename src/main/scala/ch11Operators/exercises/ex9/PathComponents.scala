package ch11Operators.exercises.ex9

object PathComponents {
  def unapply(path: String)= {
    val directory = path.substring(0, path.lastIndexOf('/'))
    val name = path.substring(path.lastIndexOf('/'))
    if(directory.nonEmpty && name.nonEmpty)
      Some(directory, name)
    else
      None
  }
}
