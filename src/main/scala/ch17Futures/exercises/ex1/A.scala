package ch17Futures.exercises.ex1

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object A extends App {
  def foo0 = {
    for {n1 <- Future {
      Thread.sleep(1000)
      println("foo0 thread one " + Thread.currentThread().getId)
      2
    }
         n2 <- Future {
           Thread.sleep(1000)
           println("foo0 thread two " + Thread.currentThread().getId)
           40
         }} {
      println(n1 + n2)
    }
  }

  def foo1 = {
    Future {
      Thread.sleep(1000)
      println("foo1 thread one " + Thread.currentThread().getId)
      2
    }.map(n1 => Future {
      Thread.sleep(1000)
      println("foo1 thread two " + Thread.currentThread().getId)
      40
    }.map(n2 => println(n1 + n2 + " Thread: " + Thread.currentThread().getId)))
  }

  def foo2 = {
    Future {
      Thread.sleep(1000)
      println("foo2 thread one " + Thread.currentThread().getId)
      2
    }.flatMap(n1 => Future {
      Thread.sleep(1000)
      println("foo2 thread two " + Thread.currentThread().getId)
      40
    }.map(n2 => println(n1 + n2 + " Thread: " + Thread.currentThread().getId)))
  }

  foo0
  foo1
  foo2
  Thread.sleep(10000)
}
