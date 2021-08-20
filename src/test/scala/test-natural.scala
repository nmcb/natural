import org.junit.Test
import org.junit.Assert.*

class TestRuntimeNat:
  
  import natural.runtime.*

  def Nul:   Nat = Zero
  def One:   Nat = Succ(Nul)
  def Two:   Nat = Succ(One)
  def Three: Nat = Succ(Two)
  def Four:  Nat = Succ(Three)

  import compat.*

  @Test def testAdd(): Unit =
    assertEquals( eval( One   ), eval( add(Nul)(One) ))
    assertEquals( eval( One   ), eval( add(One)(Nul) ))
    assertEquals( eval( Two   ), eval( add(One)(One) ))
    assertEquals( eval( Three ), eval( add(One)(Two) ))
    assertEquals( eval( Four  ), eval( add(Two)(Two) ))

  def Five: Nat = Succ(Four)
  def Six:  Nat  = Succ(Five)

  @Test def testMul(): Unit =
    assertEquals( eval( Nul  ), eval( mul(Nul)(One)   ))   
    assertEquals( eval( Nul  ), eval( mul(One)(Nul)   ))   
    assertEquals( eval( One  ), eval( mul(One)(One)   ))   
    assertEquals( eval( Two  ), eval( mul(One)(Two)   ))   
    assertEquals( eval( Four ), eval( mul(Two)(Two)   ))   
    assertEquals( eval( Six  ), eval( mul(Two)(Three) ))

  def Seven: Nat = Succ(Six)
  def Eight: Nat = Succ(Seven)
  def Nine:  Nat = Succ(Eight)

  @Test def testExp(): Unit =
    assertEquals( eval( Nul   ), eval(exp(Nul)(One)   ))
    assertEquals( eval( One   ), eval(exp(One)(Nul)   ))
    assertEquals( eval( One   ), eval(exp(One)(One)   ))
    assertEquals( eval( One   ), eval(exp(One)(Two)   ))
    assertEquals( eval( Four  ), eval(exp(Two)(Two)   ))
    assertEquals( eval( Eight ), eval(exp(Two)(Three) ))
    assertEquals( eval( Nine  ), eval(exp(Three)(Two) ))