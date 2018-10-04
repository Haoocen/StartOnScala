package lecture.part1

object Expression extends App {
  val x = 1 + 2 // expressions

  println(x)

  println(2 + 3 * 4)

  println(1 == x)

  println(!(1 == x))

  var aVariable = 2
  aVariable += 3
  println(aVariable)

  //////////////////////////////
  // Instructions do things
  // Expressions are values
  //////////////////////////////

  // IF IS A EXPRESSION !!!!
  val aCondition = true
  val aConditionedValue = if (aCondition) 100 else 0

  // While loop
  // but never do this again
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // EVERYTHING in Scala is an Expression!!
  val aWeirdValue: Unit = (aVariable = 3) // the type is Unit == void
  println(aWeirdValue)

  // side effects: println(), while, reassigning returns UNIT

  //////////////////////////////
  // Code blocks
  //////////////////////////////

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    println(if (z > 2) "hello" else "goodbye")

  }


}
