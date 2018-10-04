package lecture.part2oop

object Generics extends App {

  class MyList[+A] { //generic type `A`
    def add[B >: A](element: B): MyList[B] = ???

  }
  /**
    * A = Cat
    * Then B = Animal
   */

  class MyMap[Key, Value]{

  }

  val listOfString = new MyList[String]
  val listOfInt = new MyList[Int]


  //generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfInt = MyList.empty[Int]

  ////////////////////
  // variance problem
  ////////////////////

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes List[Cat] extends List[Animal] -> this is called covariance
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) THIS IS A HARD QUESTION
  // answer: this list will be turned into a list of animals


  // 2. no, -> Invariance list
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal] //Cat won't work


  // 3. Hell, no -> Contravariance List
  class ContravariantList[-A]
  val contravariantAnimalList: ContravariantList[Cat] = new ContravariantList[Animal]
  // e.g. trainers
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]


  // bounded types
  // SUB-TYPE
  class Cage[A <: Animal](animal: A) // Cage only accept subclass of animals

  val cage = new Cage(new Dog)

  class Car
 // val carCage = new Cage(new Car) //this won't work
  // SUPER-TYPE >:



}
