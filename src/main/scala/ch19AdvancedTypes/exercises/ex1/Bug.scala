package ch19AdvancedTypes.exercises.ex1

class Bug {
  private var position = 0
  private var direct = true

  def move(n: Int): Bug = {
    if (direct)
      position += n
    else
      position -= n
    this
  }

  def show(): Bug = {
    print(position + " ")
    this
  }

  def turn(): Bug = {
    direct = !direct
    this
  }


}
