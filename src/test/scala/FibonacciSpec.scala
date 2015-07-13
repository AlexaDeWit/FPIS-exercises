import org.scalatest._

class FibonacciSpec extends FlatSpec {

  "The fibonacci function" should "return the correct fibonacci value" in {
    assert( Fibonacci.nth(0) == 0 )
    assert( Fibonacci.nth(1) == 1 )
    assert( Fibonacci.nth(5) == 5 )
    assert( Fibonacci.nth(9) == 34 )
  }
}
