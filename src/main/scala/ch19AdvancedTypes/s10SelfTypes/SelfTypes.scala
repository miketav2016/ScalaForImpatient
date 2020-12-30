package ch19AdvancedTypes.s10SelfTypes

import javax.swing.JFrame

object SelfTypes extends App {
//        val f = new JFrame with LoggedException {override def log(msg: String): Unit = ???}
//     Error: JFrame isn't a subtype of Exception, the self type of LoggedException

}
