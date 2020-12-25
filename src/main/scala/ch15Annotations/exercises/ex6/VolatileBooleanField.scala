package ch15Annotations.exercises.ex6

object VolatileBooleanField extends App {
  @volatile
  private var done = false

  def foo(): Unit = {
    val threads = List(new Thread(() => {
      println("Sleep thread " + Thread.currentThread().getId)
      Thread.sleep(2000)
      VolatileBooleanField.done = true
      println(done)
      println("Sleep thread " + Thread.currentThread().getId)
    }),
      new Thread(() => {
        println("Wait thread " + Thread.currentThread().getId)
        while (!VolatileBooleanField.done) {
          println("wait")
          Thread.sleep(1)
        }
        println("now is true")
      }))
    threads.foreach(_.start())
    threads.foreach(_.join())
  }

  foo()
  println("end")
}



