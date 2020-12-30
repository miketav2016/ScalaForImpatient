package ch19AdvancedTypes.s11DependencyInjection

trait LoggerComponent11 {
    trait Logger11
    val logger: Logger11
    class FileLogger(file: String) extends Logger11
}