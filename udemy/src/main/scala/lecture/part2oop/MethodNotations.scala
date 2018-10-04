package lecture.part2oop

object MethodNotations extends App {

  class Person(val name:String, favouriteMovie: String) {
    def likes(movie: String): Boolean = movie == favouriteMovie
    def <>(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! :String = s"$name, what the heck"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name"
  }

  val mary = new Person("Mary", "Inception")
  val tom = new Person("Tom", "Fight Club")
  println(mary.likes("Inception"))


  // infix notation = operation notation (syntactic sugar)
  println(mary likes "Inception")
  println(mary <> tom)

  println(1 + 2)
  println(1.+(2))
  // ALL OPERATIONS ARE METHODS

  // prefix notion
  val x = -1
  val y = 1.unary_-
  /* unary_ prefix only works with - + ~ ! */

  println(!mary)

  println(mary.isAlive)
  println(mary isAlive)

  println(mary())


  // apply is a special methods in scala

}
