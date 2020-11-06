package chapter5

object exercises {

  object exercises1 {
    class Counter {
      private var value: Long = 0
      def increment(): Unit = value += 1
      def current(): Long = value
    }
  }


}
