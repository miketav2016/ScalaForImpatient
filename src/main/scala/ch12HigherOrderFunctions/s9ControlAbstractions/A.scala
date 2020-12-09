package ch12HigherOrderFunctions.s9ControlAbstractions

object A extends App {
  def runInThread(block: () => Unit) {
    new Thread {
      override def run() {
        block()
      }
    }.start()
  }

  def runInThread1(block: => Unit) {
    new Thread {
      override def run() {
        block
      }
    }.start()
  }

  runInThread { () => println("Hi"); Thread.sleep(1000); println("Bye") }
  runInThread1 {
    println("Hi"); Thread.sleep(2000); println("Bye")
  }

  def until(condition: => Boolean)(block: => Unit) {
    if (!condition) {
      block
      until(condition)(block)
    }
  }

  var x = 10
  until(x == 0) {
    x -= 1
    println(x)
  }
  /*
  * The technical term for such a function parameter is a call-by-name parameter. Unlike a regular (or
call-by-value) parameter, the parameter expression is not evaluated when the function is called. After
all, we don’t want x == 0 to evaluate to false in the call to until. Instead, the expression
becomes the body of a function with no arguments. That function is passed as a parameter.
*/
  /*
  * Look carefully at the until function definition. Note that it is curried: It first consumes the
condition, then the block as a second parameter. Without currying, the call would look like this:
until(x == 0, { ... })
which wouldn’t be as pretty*/

}
