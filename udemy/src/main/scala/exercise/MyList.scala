package exercise

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def toString: String = "[ " + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]


}

case object Empty extends MyList[Nothing] { // should be a substitute of list of anything
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  override def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list


}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(h, this)

  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  override def printElements: String = {
    if (tail.isEmpty) head + " "
    else head.toString + " , " + tail.printElements
  }

  def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons(transformer.transform(head), t.map(transformer))
  }

  override def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)


  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }




}

trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}






object ListTest extends App{
  val listOfIntegers: MyList[Int] =  Cons(1, Cons(2, Cons(3, Empty)))
  val listOfStrings: MyList[String] =  Cons("haha", Cons("huhu", Cons("Scala", Empty)))
  println(listOfIntegers.toString)

  println(listOfStrings.toString)
}