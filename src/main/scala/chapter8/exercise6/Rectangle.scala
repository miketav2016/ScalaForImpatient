package chapter8.exercise6

class Rectangle(a: Double, b: Double) extends Shape {
  override def square: Double = a * b

  override def centerPoint: (Double, Double) = (a / 2, b / 2)
}
