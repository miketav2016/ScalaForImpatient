package ch11Operators.exercises.ex6

class ASCIIArt {
  private val s00 = """ /\_/\ """
  private val s01 = """( ' ' )"""
  private val s02 = """ ( - ) """
  private val s03 = """ | | | """
  private val s04 = """(__|__)"""
  val f0 = List(s00, s01, s02, s03, s04)

  private val s10 = """  -----"""
  private val s11 = """/ Hello \"""
  private val s12 = """< Scala |"""
  private val s13 = """\ Coder /"""
  private val s14 = """  -----"""
  private val f1 = List(s10, s11, s12, s13, s14)
  val f01: List[String] =f0.lazyZip(f1).map(_ + _)

}
