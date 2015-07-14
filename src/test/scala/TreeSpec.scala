import org.scalatest._
import fpinscala.datastructures._

class TreeSpec extends FlatSpec {

  "size" should "return the number of nodes in a tree" in {
    val t1 = Branch( Branch( Leaf(1), Leaf(2) ), Leaf(3) )
    assert( Tree.size( t1 ) == 5 )
  }

  "max" should "return the maximum value in a tree" in {
    val t1 = Branch( Branch( Leaf(1), Leaf(2) ), Leaf(3) )
    assert( Tree.max( t1 ) == 3 )
  }

  "depth" should "return the maximum depth in a tree" in {
    val t1 = Branch( Branch( Leaf(1), Leaf(2) ), Leaf(3) )
    assert( Tree.depth( t1 ) == 2 )
  }
  
  "map" should "return a new tree with each leaf mapped to a new value" in {
    val t1 = Branch( Branch( Leaf(1), Leaf(2) ), Leaf(3) )
    val expected = Branch( Branch( Leaf(2), Leaf(4) ), Leaf(6) )
    assert( Tree.map( t1 )( _ * 2 ) == expected )
  }

  "foldRIght" should "accurately sum a list" in {
    val t1 = Branch( Branch( Leaf(1), Leaf(2) ), Leaf(3) )
    assert( Tree.foldRight( t1, 0 )( _ + _ ) == 6 )
  }


}
