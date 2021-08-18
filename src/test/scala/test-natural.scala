import org.junit.Test
import org.junit.Assert.*

import natural.*

class TestNat:

  def Nul[A]:   Nat[A] = Zero[A]
  def One[A]:   Nat[A] = Succ(Nul)
  def Two[A]:   Nat[A] = Succ(One)
  def Three[A]: Nat[A] = Succ(Two)
  def Four[A]:  Nat[A] = Succ(Three)

  import compat.*

  @Test def testAdd(): Unit =
    assertEquals( eval(One)   , eval(add(Nul)(One)) )
    assertEquals( eval(One)   , eval(add(One)(Nul)) )
    assertEquals( eval(Two)   , eval(add(One)(One)) )
    assertEquals( eval(Three) , eval(add(One)(Two)) )
    assertEquals( eval(Four)  , eval(add(Two)(Two)) )

  def Five[A]: Nat[A] = Succ(Four)
  def Six[A]:  Nat[A]  = Succ(Five)

  @Test def testMul(): Unit =
    assertEquals( eval(Nul)  , eval(mul(Nul)(One))   )   
    assertEquals( eval(Nul)  , eval(mul(One)(Nul))   )   
    assertEquals( eval(One)  , eval(mul(One)(One))   )   
    assertEquals( eval(Two)  , eval(mul(One)(Two))   )   
    assertEquals( eval(Four) , eval(mul(Two)(Two))   )   
    assertEquals( eval(Six)  , eval(mul(Two)(Three)) ) 

  def Seven[A]: Nat[A] = Succ(Six)
  def Eight[A]: Nat[A] = Succ(Seven)
  def Nine[A]:  Nat[A] = Succ(Eight)

  @Test def testExp(): Unit =
    assertEquals( eval(Nul)   , eval(exp(Nul)(One))   )
    assertEquals( eval(One)   , eval(exp(One)(Nul))   )
    assertEquals( eval(One)   , eval(exp(One)(One))   )
    assertEquals( eval(One)   , eval(exp(One)(Two))   )
    assertEquals( eval(Four)  , eval(exp(Two)(Two))   )
    assertEquals( eval(Eight) , eval(exp(Two)(Three)) )
    assertEquals( eval(Nine)  , eval(exp(Three)(Two)) )
