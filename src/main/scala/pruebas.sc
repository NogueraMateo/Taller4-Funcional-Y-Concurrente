import SubsecuenciaMasLarga._

val seqProfesor1 = Seq(10,9,8,7,6,5,4,3,2,1,22,21,20,19,18,17,16,15,14,13,12,11)
val seqProfesor2 = Seq(20,30,10,40,15,16,17)
subsecuenciaIncrementalMasLarga(seqProfesor2)
ssimlComenzandoEn(4,seqProfesor1)
ssimlComenzandoEn(12,seqProfesor2)
subSecIncMasLargaV2(seqProfesor1)
subSecIncMasLargaV2(seqProfesor2)

/*
Casos de prueba subSecuenciasInc
 */

// Valor esperado: Set(List(), List(2), List(1), List(1, 2))
// Valor obtenido: Set(List(), List(2), List(1), List(1, 2))
subSecuenciasInc(Seq(1,2))

// Valor esperado: Set(List(), List(1), List(3))
// Valor obtenido: Set(List(), List(1), List(3))
subSecuenciasInc(Seq(3,1))

// Valor esperado: HashSet(List(1), List(1, 2, 3), List(1, 3), List(3), List(), List(2, 3), List(1, 2), List(2))
// Valor obtenido: HashSet(List(1), List(1, 2, 3), List(1, 3), List(3), List(), List(2, 3), List(1, 2), List(2))
subSecuenciasInc(Seq(1,2,3))

// Valor esperado: HashSet(List(1), List(1, 3), List(3), List(), List(2, 3), List(2))
// Valor obtenido: HashSet(List(1), List(1, 3), List(3), List(), List(2, 3), List(2))
subSecuenciasInc(Seq(2,1,3))

// Valor esperado: HashSet(List(3), List(), List(5), List(2))
// Valor obtenido: HashSet(List(3), List(), List(5), List(2))
subSecuenciasInc(Seq(5,3,2))


/*
Casos de prueba subsecuenciaIncrementalMasLarga
 */

// Valor esperado: List(4, 5, 7, 9, 21)
// Valor obtenido: List(4, 5, 7, 9, 21)
subsecuenciaIncrementalMasLarga(Seq(4,5,3,2,7,9,22,3,21,14))

// Valor esperado: List(1, 2, 3, 4, 5)
// Valor obtenido: List(1, 2, 3, 4, 5)
subsecuenciaIncrementalMasLarga(Seq(1,2,3,4,5))

// Valor esperado: List(1) o cualquier elemento individual
// Valor obtenido: List(1)
subsecuenciaIncrementalMasLarga(Seq(5,4,3,2,1))

// Valor esperado: List(14, 21, 22)
// Valor obtenido: List(14, 21, 22)
subsecuenciaIncrementalMasLarga(Seq(14,21,3,22,9,7,2,3,5,4))

// Valor esperado: List(1, 2, 3, 4)
// Valor obtenido: List(1, 2, 3, 4)
subsecuenciaIncrementalMasLarga(Seq(9,1,8,2,7,3,6,4))

/*
Casos de prueba ssimlComenzandoEn
 */

// Valor esperado: List(4, 5, 7, 9, 22)
// Valor obtenido: List(4, 5, 7, 9, 22)
ssimlComenzandoEn(0, Seq(4,5,3,2,7,9,22,3,21,14))

// Valor esperado: List(2, 7, 9, 22)
// Valor obtenido: List(2, 7, 9, 22)
ssimlComenzandoEn(3, Seq(4,5,3,2,7,9,22,3,21,14))

// Valor esperado: List(5)
// Valor obtenido: List(5)
ssimlComenzandoEn(0, Seq(5,4,3,2,1))

// Valor esperado: List(3, 22)
// Valor obtenido: List(3, 22)
ssimlComenzandoEn(2, Seq(14,21,3,22,9,7,2,3,5,4))

// Valor esperado: List(1, 2, 3, 6)
// Valor obtenido: List(1, 2, 3, 6)
ssimlComenzandoEn(1, Seq(9,1,8,2,7,3,6,4))

/*
Casos de prueba subSecIncMasLargaV2
 */

// Valor esperado: List(4, 5, 7, 9, 22)
// Valor obtenido: List(4, 5, 7, 9, 22)
subSecIncMasLargaV2(Seq(4,5,3,2,7,9,22,3,21,14))

// Valor esperado: List(14, 21, 22)
// Valor obtenido: List(14, 21, 22)
subSecIncMasLargaV2(Seq(14,21,3,22,9,7,2,3,5,4))

// Valor esperado: List(1, 2, 3, 4, 5)
// Valor obtenido: List(1, 2, 3, 4, 5)
subSecIncMasLargaV2(Seq(1,2,3,4,5))

// Valor esperado: List(5)
// Valor obtenido: List(5)
subSecIncMasLargaV2(Seq(5,4,3,2,1))

// Valor esperado: List(1, 2, 3, 6)
// Valor obtenido: List(1, 2, 3, 6)
subSecIncMasLargaV2(Seq(9,1,8,2,7,3,6,4))

