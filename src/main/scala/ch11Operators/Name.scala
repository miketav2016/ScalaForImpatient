package ch11Operators

object Name {
  /**
   * Do not supply both an unapply and an unapplySeq methods with the same argument types.
*/
//  def unapply(input: String): Option[(String, String)] = {
//    val pos = input.indexOf(" ")
//    if (pos == -1) None
//    else Some((input.substring(0, pos), input.substring(pos + 1)))
//  }
  def unapplySeq(input: String): Option[Seq[String]] =
    if (input.trim == "") None else Some(input.trim.split("\\s+"))
}
