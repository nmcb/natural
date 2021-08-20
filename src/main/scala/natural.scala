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
  object runtime:
    
    type Nat =
      [A] => (A => A) => A => A

    def Zero: Nat =
      [A] => (f: A => A) => (a: A) => a

    def Succ[A](n: Nat): Nat =
      [A] => (f: A => A) => (a: A) => f(n(f)(a))

    def one: Nat =
      Succ(Zero)

    def add(m: Nat)(n: Nat): Nat =
      [A] => (f: A => A) => (a: A) => m(f)(n(f)(a))

    def mul(m: Nat)(n: Nat): Nat =
      [A] => (f: A => A) => (a: A) => m(n(f))(a)

    def exp(m: Nat)(n: Nat): Nat =
      // the compiler throws a StackOverflowError without the type annotations!
      [A] => (f: A => A) => (a: A) => (n[Nat](mul(m))(one): Nat)(f)(a) 
      // and we would like to implememnt exp like this, correctly interfered.
      // [A] => (f: A => A) => (a: A) => n(m)(f)(a) 

    object compat:

      def eval(n: Nat): Int =
        n[Int](_ + 1)(0)
