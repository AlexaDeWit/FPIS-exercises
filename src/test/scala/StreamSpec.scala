import fpinscala.datastructures
import org.scalatest._

class StreamSpec extends FlatSpec {

  "to list" should "return the correct list from a stream" in {
    val strm = Stream("A", "B", "C", "D")
    val exp = List("A","B", "C", "D")
    assert( strm.toList == exp  )
  }

}
