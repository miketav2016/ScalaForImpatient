package chapter8.exercise6

class Circle(r: Double) extends Shape {
  private val pi = math.Pi
  override def square: Double = pi * math.pow(r, 2)

  override def centerPoint: (Double, Double) = (r / 2, r / 2)
}
