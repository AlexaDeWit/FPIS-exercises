import org.scalatest._
import fpinscala.datastructures._


class OptionSpec extends FlatSpec {

  "mapping an option" should "yield another option of the new type" in {
    val opt: Option[Int] = Some(5)
    val exp: Option[String] = Some("5")
    assert( opt.map( _.toString ) == exp )
  }

  "mapping a None" should "result in a None of the appropriate type" in {
    val opt: Option[Int] = None
    val exp: Option[String] = None
    assert( opt.map( _.toString ) == exp )
  }

  "flat mapping an option" should "yield another option of the new type" in {
    val opt: Option[Int] = Some(5)
    val exp: Option[String] = Some("5")
    assert( opt.flatMap { x: Int =>  Some(x.toString) } == exp )
  }

  "flat mapping a None" should "result in a None of the appropriate type" in {
    val opt: Option[Int] = None
    val exp: Option[String] = None
    assert( opt.flatMap { x: Int => Some(x.toString) } == exp )
  }

  "get or else" should "do get or else type stuff" in {
    val empty: Option[Int] = None
    val five: Option[Int] = Some(5)
    assert( empty.getOrElse( 10 ) == 10 )
    assert( five.getOrElse( 10 ) == 5 )
  }

  "or else" should "return the original if Some" in {
    val opt: Option[Int] = Some(1)
    assert( opt.orElse( Some(2) ) == opt )
  }

  "or else" should "return the alternative if None" in {
    val opt: Option[Int] = None
    val alt: Option[Int] = Some(1)
    assert( opt.orElse( alt ) == alt )
  }

}

