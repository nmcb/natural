import org.junit.Test
import org.junit.Assert.*

import natural.*

class TestNat:

  def Nul:   Nat[Int] = Zero[Int]
  def One:   Nat[Int] = Succ(Nul)
  def Two:   Nat[Int] = Succ(One)
  def Three: Nat[Int] = Succ(Two)
  def Four:  Nat[Int] = Succ(Three)

  import compat.*

  @Test def testAdd(): Unit =
    assertEquals(eval(add(Nul)(One)), eval(One))
    assertEquals(eval(add(One)(Nul)), eval(One))
    assertEquals(eval(add(One)(One)), eval(Two))
    assertEquals(eval(add(One)(Two)), eval(Three))
    assertEquals(eval(add(Two)(Two)), eval(Four))
