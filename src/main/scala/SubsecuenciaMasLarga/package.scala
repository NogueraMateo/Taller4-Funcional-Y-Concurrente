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

  

  
  def ssimlComenzandoEn(i: Int, s: Secuencia): Subsecuencia = {
    if (i >= s.length) Seq.empty[Int]
    else {
      
      val subsecuenciasPosteriores = for {
        j <- i + 1 until s.length
        if s(j) > s(i)
      } yield ssimlComenzandoEn(j, s)
      
      
      if (subsecuenciasPosteriores.isEmpty) Seq(s(i))
      else {
        
        val masLarga = subsecuenciasPosteriores.maxBy(_.length)
        s(i) +: masLarga
      }
    }
  }



  def subSecIncMasLargaV2(s: Secuencia): Subsecuencia = {
    if (s.isEmpty) Seq.empty[Int]
    else {
      val todasLasSubsecuencias = for {
        i <- s.indices
      } yield ssimlComenzandoEn(i, s)

      todasLasSubsecuencias.maxBy(_.length)
    }
  }

}
