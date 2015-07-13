package fpinscala.datastructures

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x,xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x,xs) => x * product(xs)
  }

  def tail[A](l: List[A]) = {
    l match {
      case Cons(_ , x) => x
      case Nil         => Nil
    }
  }

  def drop[A](l: List[A], count: Int ): List[A] = {
    if( count == 0 )
      l
    else
      drop(tail(l), count - 1)
  }

  def dropWhile[A]( l: List[A])( f: A => Boolean ): List[A] = {
    l match {
      case Nil => Nil
      case Cons( h, t ) => if( f(h) ) dropWhile( t )( f ) else Cons( h, t )
    }
  }

  def setHead[A]( l: List[A], h: A ) = {
    l match {
      case Cons(oh, t ) => Cons( h, t )
      case Nil => Cons( h, Nil )
    }
  }

  def apply[A](as: A*): List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }

  def init[A]( l: List[A] ): List[A] = {
    l match {
      case Cons( h, Nil ) => Nil
      case Cons( h, t )   => Cons( h,  init( t ) )
      case Nil            => throw new UnsupportedOperationException("empty.init")
    }
  }

  def foldRight[A,B](l: List[A], z: B)(f: (A, B) => B): B = {
    l match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }
  }

  def foldLeft[A,B](l: List[A], z: B)( f: (B, A) => B ): B = {
    l match {
      case Nil => z
      case Cons( x, xs ) => foldLeft( xs, f(z,x) )( f )
    }
  }
  
  def length[A]( l: List[A] ) : Int = {
    foldRight( l, 0 )( (a,b) => b + 1 )
  }

  def reverse[A]( l: List[A] ) : List[A] = {
    foldLeft[A,List[A]]( l, Nil)( (xs, x ) => Cons( x, xs ) ) 
  }

  //Holy crap can this stack overflow
  def flatten[A]( l: List[List[A]] ): List[A] = {
    l match {
      case Nil => Nil
      case Cons( x, xs ) => foldRight( x, flatten(xs) )( Cons.apply _ )
    }
  }

}
