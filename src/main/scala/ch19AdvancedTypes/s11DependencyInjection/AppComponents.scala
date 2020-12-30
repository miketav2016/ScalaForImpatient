package ch19AdvancedTypes.s11DependencyInjection


//object MyApp11 extends App11 with FileLogger11 ("test.log") with MockAuth ("users.txt")  //does not work
object AppComponents extends LoggerComponent11 with AuthComponent11 {
    val logger = new FileLogger("test.log")
    val auth = new MockAuth("users.txt")
    /**
     * Either approach is better than component wiring in an XML file because the compiler can verify that
     * the module dependencies are satisfied.
     */
}