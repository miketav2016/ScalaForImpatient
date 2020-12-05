package ch11Operators.exercises.ex7

class BitSequence(val bits: Long) {
  def apply(poss: Int) = {
    bits >> poss
  }
  def update (poss: Int, isNeg: Boolean ) = {
    if (isNeg)
      apply(poss)
    else
       ~ bits << poss
  }
}
