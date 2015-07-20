package fpinscala.datastructures

sealed trait Option[+A] {
  def map[B]( f: A => B ): Option[B] = {
    this match {
      case Some( a ) => Some(f(a))
      case None      => None
    }
  }

  def flatMap[B]( f: A => Option[B] ): Option[B] = {
    this match {
      case Some( a ) => f( a )
      case None      => None
    }
  }

  def getOrElse[B >: A]( b: B ): B = {
    this match {
      case Some( a ) => a
      case None      => b
    }
  }
}
case class Some[A](get: A) extends Option[A]
case object None extends Option[Nothing]


