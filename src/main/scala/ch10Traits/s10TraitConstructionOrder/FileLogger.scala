package ch10Traits.s10TraitConstructionOrder

import java.io.PrintWriter

import ch10Traits.s7TraitsForRichInterfaces.Logger

trait FileLogger extends Logger {
  val filename: String
  val out = new PrintWriter(filename) // Part of the trait's constructor
  out.println(s"# ${java.time.Instant.now()}") // Also part of the constructor
  def log(msg: String) { out.println(msg); out.flush() }
}
