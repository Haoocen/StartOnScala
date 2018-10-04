package lecture.part2oop

object OOBasics extends App{

  val person = new Person("John", 26)
  //println(person.name)
  person.greet()
  person.greet("Danial")

  ///////

  val author = new Writer("Charles","Dickens", 1812)
  val novel = new Novel ("Great Expectation", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  /////
  val counter = new Counter()
  counter.inc.print
  counter.print
  counter.inc(3).print
}

// THIS IS a CONSTRUCTOR
class Person(val name: String, val age: Int){
  // class parameters are not fields unless adding var or val

  // x is a field
  val x = 2

  println("A person is being instantiated")

  // methods
  def greet(name: String): Unit = println(s"${this.name} says hi to $name")

  def greet(): Unit = println(s"Hello, $name")


  // overloading constructors
  // default parameter works, so this is not necessary
  def this(name: String) = this(name, 0)

}


class Writer(firstName: String, lastName: String, val year: Int) {
  def fullName: String = firstName + " " + lastName
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge: Int = year - author.year
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)

}


////// Counter class

class Counter(val count: Int = 0) {
  // IMMUTABILITY
  def inc = {
    println("incrementing")
    new Counter(count + 1)
  }
  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc( n - 1 )
  }
  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec( n - 1 )
  }

  def print = println(count)
}

