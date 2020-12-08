package CH12HigherOrderFunctions.s4ParameterInference

import CH12HigherOrderFunctions.s3FunctionsWithFunctionParameters.A.valueAtOneQuarter

object A extends App {
  valueAtOneQuarter((x: Double) => 3 * x) // 0.75
  valueAtOneQuarter(x => 3 * x)
  valueAtOneQuarter(3 * _)
  /*Keep in mind that these shortcuts only work when the parameter types are known.*/
  //val fun0 = 3 * _ // Error: Can't infer types
  val fun1 = 3 * (_: Double) // OK
  val fun2: (Double) => Double = 3 * _ // OK because we specified the type for fun
  val fun3: (String, Int, Int) => String = (_: String).substring(_: Int, _: Int)
}
