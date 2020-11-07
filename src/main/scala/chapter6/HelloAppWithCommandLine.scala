package chapter6

object HelloAppWithCommandLine extends App {
  if (args.length > 0)
    println(f"Hello ${args(0)}")
  else
    println("Hello, World!")
}
