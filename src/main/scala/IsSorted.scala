object IsSorted {

  def check[A]( arr: Array[A], gt: (A, A) => Boolean ): Boolean = {
    @annotation.tailrec
    def iter( invalidated: Boolean, arr: Array[A] ): Boolean = {
      if( invalidated ) {
        false
      } else if( arr.length >= 2 ) {
        iter( gt( arr(0), arr(1) ), arr.drop(2) )
      } else {
        true
      }
    }
    iter( false, arr )
  }
}
