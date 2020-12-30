package ch19AdvancedTypes.s14HigherKindedTypes

trait Iterable[E, C[X] <: Container[X]] {
    def build[F](): C[F]
    def iterator(): Iterator[E]
    def map[F](f : (E) => F) : C[F] = {
        val res = build[F]()
        val iter = iterator()
        while (iter.hasNext) res += f(iter.next())
        res
    }
}