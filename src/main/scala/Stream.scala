package fpinscala.datastructures

trait Stream[+A] {
  def uncons: Option[(A, Stream[A])]
  def isEmpty: Boolean = uncons.isEmpty

  def toList: List[A] = {
    def go( stream: Stream[A] ): List[A] = {
      uncons match {
        case Some(( a, as )) => Cons( a, go( as ) )
        case None            => Nil
      }
    }
    go( this )
  }
}

object Stream {
  def empty[A]: Stream[A] = {
    new Stream[A] { def uncons = None }
  }

  def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
    new Stream[A] {
      lazy val uncons = Some((hd, tl))
    }
  }

  def apply[A](as: A*): Stream[A] = {
    if (as.isEmpty) empty
    else cons(as.head, apply(as.tail: _*))
  }

}
