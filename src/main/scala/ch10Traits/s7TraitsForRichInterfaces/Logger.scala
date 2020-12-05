package ch10Traits.s7TraitsForRichInterfaces

trait Logger {
  def log(msg: String)
  def info(msg: String) { log(s"INFO: $msg") }
  def warn(msg: String) { log(s"WARN: $msg") }
  def severe(msg: String) { log(s"SEVERE: $msg") }
}