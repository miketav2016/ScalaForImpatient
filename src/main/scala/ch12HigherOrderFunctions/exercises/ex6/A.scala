package ch12HigherOrderFunctions.exercises.ex6

object A extends App {
  def largest(fun: (Int) => Int, inputs: Seq[Int]) = {
    inputs.foldLeft((inputs.head,fun(inputs.head))){ case ((i,res), n) =>
      if (fun(n) > res)
        (n, fun(n))
      else
        (i,res)
    }._1
  }
  println(largest(x => 10 * x - x * x, 1 to 10 ))
}
