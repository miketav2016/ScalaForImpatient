package ch11Operators.exercises.ex6

object A extends App {

  private val s00 = """ /\_/\ """
  private val s01 = """( ' ' )"""
  private val s02 = """ ( - ) """
  private val s03 = """ | | | """
  private val s04 = """(__|__)"""
  val f0 = List(s00, s01, s02, s03, s04)
  val fig0 = new ASCIIArt(f0)
  fig0.showFig

  private val s10 = """  -----"""
  private val s11 = """/ Hello \"""
  private val s12 = """< Scala |"""
  private val s13 = """\ Coder /"""
  private val s14 = """  -----"""
  private val f1 = List(s10, s11, s12, s13, s14)
  val fig1 = fig0.addFigV(f1)
  fig1.showFig
  val fig2 = fig0.addFigH(f1)
  fig2.showFig
}
