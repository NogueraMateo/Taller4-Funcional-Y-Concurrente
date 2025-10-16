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

  /**
   * Devuelve la secuencia correspondiente a la secuencia creciente de índices inds
   * @param s Secuencia de enteros
   * @param inds Secuencia creciente de índices asociada a s
   * @return
   */
    def subSecuenciaAsoc(s: Secuencia, inds: Seq[Int]): Subsecuencia = {
      for (ind <- inds) yield s(ind)
    }

  /**
   * Devuelve el conjunto de todas las subsecuencias de s
   * @param s Secuencia de enteros
   */
    def subSecuenciasDe(s: Secuencia): Set[Subsecuencia] = {
      val indexSubsequences = subindices(0, s.length)
      for (subseq <- indexSubsequences) yield subSecuenciaAsoc(s, subseq)
    }

  /**
   * Decide si una secuencia es incremental o no
   * @param s Secuencia de enteros
   */
    def incremental(s: Subsecuencia): Boolean = {
      val wrongOrder = for {
        i <- 0 until (s.length - 1) // Índices de s menos el último
        if s(i) > s(i+1) // Revisa si s(i) es mayor que s(i+1) el siguiente en la secuencia
      } yield i // Lo recolecta

      // Si el resultado de lo anterior tiene al menos un elemento, entonces, existe al menos un s(i) talque s(i+1) es menor que él
      // luego la lista no es incremental
      wrongOrder.isEmpty
    }

    /**
     * Devuelve el conjunto de subsecuencias incrementales de s
     * @param s Secuencia de enteros
     * @return
     */
    def subSecuenciasInc(s: Secuencia): Set[Subsecuencia] = {
        for {
          subseq <- subSecuenciasDe(s)
          if incremental(subseq)
        } yield subseq
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
