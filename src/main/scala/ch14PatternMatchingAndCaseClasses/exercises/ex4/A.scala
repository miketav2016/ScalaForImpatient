package ch14PatternMatchingAndCaseClasses.exercises.ex4

object A extends App {
  val item0 = Multiple(10, Article("Blackwell Toaster", 29.95))
  val item1 = Multiple(10, Article("Blackwell Toaster", 29.95), Multiple(5, Article("Cyberpunk 2077", 1999)))
}
