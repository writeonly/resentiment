package pl.writeonly.re.shared

class Calculator {
  type T = Int

  def add(a: T, b: T): T = a + b

  def mul(a: T, b: T): T = a * b

  def leq(a: T, b: T): Boolean = a < b

}
