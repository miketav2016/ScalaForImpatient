package ch18TypeParameters.s9Variance

class Pair9 [+T](val first: T, val second: T)
//The + means that the type is covariant in T—that is, it varies in the same direction
// Since Student
//is a subtype of Person, a Pair[Student] is now a subtype of Pair[Person].