object Fibonacci {

  def nth( n: Int ): Int = {

    def go( n: Int, generated: (Int, Int ) ) : Int = {
      if( n < 2 ) {
        generated._2
      } else {
        go( n - 1, ( generated._2, generated._1 + generated._2 ))
      }
    }
    if( n < 2 ){
      n
    } else {
      go( n, (0,1) )
    }
  }
}
