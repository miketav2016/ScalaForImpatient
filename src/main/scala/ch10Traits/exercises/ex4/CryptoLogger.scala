package ch10Traits.exercises.ex4

trait CryptoLogger {
  def encrypts(string: String, shift: Int = 3): String ={
    string.map(ch => (ch + shift).toChar)
  }
}
