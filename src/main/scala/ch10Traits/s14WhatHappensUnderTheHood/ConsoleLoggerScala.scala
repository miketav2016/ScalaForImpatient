package ch10Traits.s14WhatHappensUnderTheHood

trait ConsoleLoggerScala {
  def log(msg: String): Unit = {
    println(msg)
  }
}
