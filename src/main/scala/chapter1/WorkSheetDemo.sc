import scala.math.BigInt.probablePrime
import scala.util.Random

// run type Plain
object WorkSheetDemo {
  println("welcome to the Scala WorkSheet")
  val num: Int = 8 + 5 * 4
  num / 7
  ("Hello, " + num).toLowerCase
  //2
  //scala> math.sqrt(3)
  // res2: Double = 1.7320508075688772
  //scala> math.pow(res2, 2)
  // res3: Double = 2.9999999999999996
  // 3 - res3
  // res4: Double = 4.440892098500626E-16
  //3. Are the res variables val or var?
  // Answer val
  //4
  "crazy" * 3
  //5
  10 max 2
  //6
  BigInt(2).pow(1024)
  //7
  probablePrime(100, Random).toByteArray.map(_.toChar).foldLeft("")(_ + _)
  val bigInt: BigInt = probablePrime(100, Random)
  //8
  val longInBase36: String = java.lang.Long.toString(bigInt.toLong, 36)
  //9
  "very long string".head
  "very long string".take(1)
  "very long string".reverse.last
  "very long string".last
  //10
  "very long string".drop(3)
  "very long string".dropRight(3)
  "very long string".takeRight(3)
}

