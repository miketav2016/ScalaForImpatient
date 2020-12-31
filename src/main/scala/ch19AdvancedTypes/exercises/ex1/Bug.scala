package ch19AdvancedTypes.exercises.ex1

import ch19AdvancedTypes.exercises.ex2.BugFluent

class Bug extends BugFluent{
  private var position = 0
  private var direct = true

  def move(n: Int): this.type = {
    if (direct)
      position += n
    else
      position -= n
    this
  }

  def show(): this.type = {
    print(position + " ")
    this
  }

  def turn(): this.type = {
    direct = !direct
    this
  }
}
