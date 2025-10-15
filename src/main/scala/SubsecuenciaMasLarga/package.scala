package object SubsecuenciaMasLarga {
    type Secuencia = Seq[Int]
    type Subsecuencia = Seq[Int]

  /**
   * Calcula todas las subsecuencias incrementales entre los índices i y n exclusivo
   */
    def subindices(i:Int, n: Int): Set[Seq[Int]] = {
      if (i >= n) Set(Seq.empty[Int])
      else {
        val remaining = subindices(i+1, n)
        val concatI = (for {seq <- remaining} yield  i +: seq).toSet
        remaining ++ concatI
      }
    }
}
