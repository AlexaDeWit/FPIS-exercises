import org.scalatest._

class IsSortedSpec extends FlatSpec {
  "Sorted ints" should "return true" in {
    val input  = Array(1,2,3,4,5,6)
    assert( IsSorted.check( input, ( x: Int, y: Int ) => x >= y ) == true)
  }

  "Unsorted Ints" should "return false" in {
    val input  = Array(6,2,3,4,5,1)
    assert( IsSorted.check( input, ( x: Int, y: Int ) => x >= y ) == false)
  }

  "One Item" should "return true" in {
    val input  = Array(1)
    assert( IsSorted.check( input, ( x: Int, y: Int ) => x >= y ) == true)
  }
}
