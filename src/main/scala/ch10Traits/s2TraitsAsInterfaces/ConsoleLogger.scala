package ch10Traits.s2TraitsAsInterfaces
/**If you need more than one trait, add the others using the with keyword:*/
trait ConsoleLogger extends Logger with Serializable {
  /**All Java interfaces can be used as Scala traits.*/
  def log(msg: String): Unit = {
    println(msg)
  }
}

