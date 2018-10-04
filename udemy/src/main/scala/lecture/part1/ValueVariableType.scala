package lecture.part1

import java.security.KeyStore.TrustedCertificateEntry

object ValueVariableType extends App {


  ///////////////////////////////////////
  // Val
  ///////////////////////////////////////
  val x: Int = 42
  // ": Int" is optional
  // compiler can infer types

  println(x)

  /** x = 2 */
  // Val is immutable

  ///////////////////////////////////////
  // Types
  ///////////////////////////////////////
  val aString: String = "Hello"
  val anotherString = "Goodbye"

  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val aInt: Int = 1
  val aShort: Short = 4613
  val aLong: Long = 6739495729495881L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  ///////////////////////////////////////
  // Variables
  ///////////////////////////////////////
  var aVariable: Int = 4
  aVariable = 5 //side effect



}
