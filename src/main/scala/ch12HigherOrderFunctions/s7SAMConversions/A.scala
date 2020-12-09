package ch12HigherOrderFunctions.s7SAMConversions

import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.JButton

object A extends App {
  var counter = 0
  val button = new JButton("Increment")
  button.addActionListener(new ActionListener {
    override def actionPerformed(event: ActionEvent) {
      counter += 1
    }
  })
  button.addActionListener(event => counter += 1)
  // val listener0 = (event: ActionListener) => println(counter)
  //  button.addActionListener(listener0)
  // Cannot convert a nonliteral function to a Java SAM interface
  //The simplest remedy is to declare the variable holding the function as a Java SAM interface
  val listener: ActionListener = event => println(counter)
  button.addActionListener(listener) // Ok
  //Alternatively, you can turn a function variable into a literal expression
  val exit = (event: ActionEvent) => if (counter > 9) System.exit(0)
  button.addActionListener(exit(_))


}
