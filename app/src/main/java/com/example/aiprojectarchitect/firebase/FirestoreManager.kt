package com.example.aiprojectarchitect.firebase
import com.example.aiprojectarchitect.model.Project
import com.google.firebase.firestore.FirebaseFirestore
import com.example.aiprojectarchitect.firebase.FirestoreManager
class FirestoreManager{

    private val firestore = FirebaseFirestore.getInstance()

    fun saveUser(
        uid: String,
        email: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

        val user = hashMapOf(
            "uid" to uid,
            "email" to email
        )

        firestore.collection("users")
            .document(uid)
            .set(user)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener { expectation ->
                onError(expectation.message ?: "Failed to Save User")
            }
    }


    fun saveProject(
        project : Project ,
        onSuccess  : () ->Unit ,
        onError  : (String) ->Unit
    ){

        val projectId = firestore
            .collection("projects")
            .document()
            .id

        val projectWithId = project.copy(
            id = projectId
        )

        firestore.collection("projects")
            .document(projectId)
            .set(projectWithId)
            .addOnSuccessListener{
                onSuccess()
            }
            .addOnFailureListener { exception ->
                onError(
                    exception.message ?: "Failed to save project"
                )
            }

    }
}