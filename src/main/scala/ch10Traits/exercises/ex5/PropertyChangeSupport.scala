package ch10Traits.exercises.ex5

import java.beans
import java.beans.{PropertyChangeListener, PropertyChangeSupport}

trait PropertyChangeSupport {

  private val pcs: beans.PropertyChangeSupport = PropertyChangeSupport

  def addPropertyChangeListener(p: String, listener: PropertyChangeListener) {
    pcs.addPropertyChangeListener(p,listener)
  }

  def removePropertyChangeListener(listener: PropertyChangeListener) {
    pcs.removePropertyChangeListener(listener)
  }
}
