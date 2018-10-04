package lecture.part2oop

object AnonymousClass extends App {
  abstract class Animal {
    def eat: Unit
  }


  // anonymous class
  val funnyAnimal: Animal = new Animal{
    override def eat: Unit = println("hahahaha...")
  }

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val jim = new Person ("Jim") {
    override def sayHi: Unit = super.sayHi
  }

}
