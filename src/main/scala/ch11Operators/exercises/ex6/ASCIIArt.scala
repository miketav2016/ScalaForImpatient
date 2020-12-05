package ch11Operators.exercises.ex6

class ASCIIArt(aStr: List[String]) {
  def showFig() = {
    aStr.foreach(println)
  }

  def addFigV(posFig: List[String]): ASCIIArt = {
    new ASCIIArt(aStr.lazyZip(posFig).map(_ + _))
  }

  def addFigH(posFig: List[String]): ASCIIArt = {
    new ASCIIArt(aStr ++ posFig)
  }

}
