package ch19AdvancedTypes.s13FamilyPolymorphism.WithAbstractTypes
/*
Now when you want to define a button with a button event and a button listener, enclose the
definitions in a module that extends this trait:
 */
object ButtonModule extends ListenerSupport {
    type S = Button
    type E = ButtonEvent
    type L = ButtonListener
    class ButtonEvent extends Event
    trait ButtonListener extends Listener
    class Button extends Source {
        def click() { fire(new ButtonEvent) }
    }
}

/*
* In this example, Author used single-letter names for the abstract types, to show the analogy with the
version that uses type parameters. It is common in Scala to use more descriptive type names,
which leads to more self-documenting code:
object ButtonModule extends ListenerSupport {
type SourceType = Button
type EventType = ButtonEvent
type ListenerType = ButtonListener
}
* */
