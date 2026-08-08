import com.google.firebase.firestore.FirebaseFirestore

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
            .addOnCompleteListener {
                onSuccess()
            }
            .addOnFailureListener { expectation ->
                onError(expectation.message ?: "Failed to Save User")
            }
    }
}