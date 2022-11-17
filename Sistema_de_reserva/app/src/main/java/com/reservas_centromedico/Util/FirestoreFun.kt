package com.reservas_centromedico.Util

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

object FirestoreFun {
    private val firestoreinst: FirebaseFirestore by lazy {FirebaseFirestore.getInstance()}

    private val DocumentRef: DocumentReference
    get() = firestoreinst.document("Usuarios/${FirebaseAuth.getInstance().uid?: 
    throw NullPointerException("id es nulo")}")

    //funcion cuando se accede por primera vez a la funcion
    //fun IniciarPri()
}