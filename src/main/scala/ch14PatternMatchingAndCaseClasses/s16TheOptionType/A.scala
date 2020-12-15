package ch14PatternMatchingAndCaseClasses.s16TheOptionType


object A extends App {

  val scores = Map("Alice" -> 17)

  val alicesScore = scores.get("Alice")
  alicesScore match {
    case Some(score) => println(score)
    case None => println("No score")
  }

  if (alicesScore.isEmpty) println("No score")
  else println(alicesScore.get)

  println(alicesScore.getOrElse("No score"))
  for (score <- alicesScore) println(score)

  alicesScore.foreach(println)

  val biggerScore = alicesScore.map(_ + 1) // Some(score + 1) or None
  val acceptableScore = alicesScore.filter(_ > 5) // Some(score) if score > 5 or None


}
