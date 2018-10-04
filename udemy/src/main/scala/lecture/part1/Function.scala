package lecture.part1

object Function extends App {

  // the return type could be omitted
  def aFunction(a: String, b:Int): String = {
    a + " " + b
  }

  def aParameterlessFunction(): Int = 42

  // a recursive function has to have return typed specified
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a: Int, b:Int): Int = a + b
    aSmallFunction(n, n - 2)
  }

  // Greeting
  def greeting(name: Int, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old."
  }

  // Factorial
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  // Fibonacci
  def fibo(n: Int): Int = {
    if (n <= 2) 1
    else fibo(n - 1) + fibo(n - 2)
  }

  // isPrime
  def isPrime(n: Int): Boolean = {
    def isPrimeHelper(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeHelper(t - 1)
    }

    isPrimeHelper(n / 2)
  }
}
