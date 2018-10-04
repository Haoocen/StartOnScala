package lecture.part2oop

object CaseClass extends App {

  case class Person(name: String, age: Int)
  // 1. class parameters are fields
  val jim = new Person("Jim", 34)

  // 2. sensible toString
  // println(instance) = println(instance.toString)
  println(jim.toString)
  println(jim)

  // 3. euqals and hashCode implemented OOTB
  var jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. CCs have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. CCs has companion objects
  // we don't have to use the keyword new for case class
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. CCs are serializable

  // 7. CCs have extractor patterns == CCs can be used in pattern matching

  case object UnitedKingdom {
    def name: String = "the UK of GB and NI"
  }



}
