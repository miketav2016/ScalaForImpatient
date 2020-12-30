package ch19AdvancedTypes.s13FamilyPolymorphism

import java.awt.event.ActionEvent

class Button extends Source[ActionEvent, ActionListener] {
    def click() {
    fire(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "click"))
}
}