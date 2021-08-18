object natural:

  /*
  * the church encoding of natural numbers in the lambda calculus defines
  * zero as to not apply a given function to given input and the succesor
  * of a given natural number n as it's n-fold composition.  that is, the
  * successor of given natural number n composes given function f, n times
  * with itself and applies given input to the result:
  *
  *   0 == λf.λx.x           --no application of f
  *   1 == λf.λx.f(x)        --applies x to f
  *   2 == λf.λx.f(f(x))     --applies x to f composed with itself 
  *    
  *   n == λf.λx.f(...f(x))  --applies x to f composed n times with itself
  */
  type Nat[A] =
    (A => A) => A => A

  def Zero[A]: Nat[A] =
    f => identity

  def Succ[A](n: Nat[A]): Nat[A] =
    f => x => f(n(f)(x))

  def add[A](m: Nat[A])(n: Nat[A]): Nat[A] =
    f => x => m(f)(n(f)(x))

  def mul[A](m: Nat[A])(n: Nat[A]): Nat[A] =
    f => x => m(n(f))(x)

  def exp[A](m: Nat[A])(n: Nat[A]): Nat[A] =
    n compose m

  
  object compat:

    def eval(n: Nat[Int]): Int =
      n(_ + 1)(0)

    def str(n: Nat[Int]): String =
      eval(n).toString
