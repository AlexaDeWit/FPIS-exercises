import org.scalatest._
import fpinscala.datastructures._

class ListSpec extends FlatSpec {

  "tail of nil" should "return nil" in {
    assert( List.tail(Nil) == Nil )
  }

  "tail of a cons list" should "return the cons list" in {
    assert( List.tail( List(1,2,3) ) == List(2,3) )
    assert( List.tail( List(1,2) ) == Cons( 2, Nil ) )
  }

  "drop from nil" should "return nil" in {
    assert( List.drop(Nil, 5) == Nil )
  }

  "dropping from lists" should "return lists missing the correct number of elements" in {
    assert( List.drop( List(1,2,3,4), 1 ) == List(2,3,4) )
    assert( List.drop( List(5,2,9,1), 2 ) == List(9,1) )
  }

  "dropping while" should "return Nil when nothing remains, regardless of predicate" in {
    assert( List.dropWhile( List[Int]())( _ > 5 ) == Nil )
  }

  "dropping evens" should "return a list with an odd number or Nil at the start" in {
    assert( List.dropWhile( List(2,4,1,2,3) )( _ % 2 == 0 ) == List(1,2,3) )
    assert( List.dropWhile( List(2,4,6) )( _ % 2 == 0 ) == Nil )
  }

  "set head" should "return a new list with the replaced head" in {
    assert( List.setHead( List[Int](), 1 ) == List(1) )
    assert( List.setHead( List(1,2,3), 2 ) == List(2,2,3) )
  }

  "init" should "return a new list containing all but the last element" in {
    assert( List.init( List(1,2,3,4) ) == List(1,2,3) )
    assert( List.init( List(1) ) == Nil )
  }

  "length" should "return the length of a given list" in {
    assert( List.length( List() ) == 0 )
    assert( List.length( List(1) ) == 1 )
    assert( List.length( List(1,2,3,4) ) == 4 )
  }

  "foldLeft" should "be able to sum and product a list correctly" in {
    assert( List.foldLeft( List(2,4,6), 0 )( (a,b) => a + b) == 12 )
    assert( List.foldLeft( List(2,4,6), 1 )( (a,b) => a * b) == 48 )
  }

}