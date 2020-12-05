package ch11Operators.exercises.ex8

import scala.collection.mutable.ArrayBuffer

class Matrix(m: Int, n: Int, val elements: Seq[Double]) {
  val size: Int = n * m
  val row: Int = m
  val col: Int = n

  def getElem(m: Int, n: Int): Double = {
    elements(row * m + n)
  }

  def +(matrix: Matrix): Matrix = {
    if (row == matrix.row && col == matrix.col) {
      Matrix(row, col, elements.lazyZip(matrix.elements).map(_ + _))
    } else {
      println("Size not equal")
      this
    }
  }

  def +(n: Double): Matrix = {
    Matrix(row, col, elements.map(_ + n))
  }
  def *(n: Double): Matrix = {
    Matrix(row, col, elements.map(_ * n))
  }
  def *(matrix: Matrix): Matrix = {
    val res = ArrayBuffer[Double]()
    if( col == matrix.row) {
        for(i <- 0 until row;
            j <- 0 until matrix.col){
          res += (for (k <- 0 until col) yield elements(row * i + k) * matrix.elements(matrix.col * k + j)).sum
        }
      }
    new Matrix(row, matrix.col, res.toSeq)
  }

  override def toString: String = {
    val s = ArrayBuffer[String]()
    for (i <- 0 until row; j <- 0 until col) {
      if (j == 0) s += "\n"
      s += getElem(i, j) + " "
    }
    s.foldLeft("")((s, i) => s + i)
  }
}

object Matrix {
  def apply(seq: Seq[Double]) = new Matrix(2, 2, seq)

  def apply(n: Int, seq: Seq[Double]) = new Matrix(n, n, seq)

  def apply(m: Int, n: Int, seq: Seq[Double]) = new Matrix(m, n, seq)
}