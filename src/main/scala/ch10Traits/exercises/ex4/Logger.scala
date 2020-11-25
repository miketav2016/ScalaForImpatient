package ch10Traits.exercises.ex4

class Logger extends CryptoLogger {
  def log(msg: String): String = {
    println(encrypts(msg))
    msg
  }
}
