package fpoly.ph46626.ph46626_and103_assignment.AccountActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import fpoly.ph45160.ph45160_and103_assignment.databinding.ActivityAccountBinding;

public class ActivityAccount extends AppCompatActivity {

    ActivityAccountBinding binding;
    FirebaseAuth mAuth;
    FirebaseFirestore db;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            loadUserProfile();
        }

        binding.btnSubmit.setOnClickListener(v -> {
            updateProfile();
        });

        binding.icPerson.setOnClickListener(v -> {
            finish(); // Trở về màn hình trước đó
        });
    }

    private void loadUserProfile() {
        String userId = currentUser.getUid();
        DocumentReference userRef = db.collection("users").document(userId);

        userRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    binding.edtUser.setText(document.getString("userName"));
                    binding.edtEmail.setText(document.getString("email"));
                    binding.edtBirthday.setText(document.getString("birthday"));
                    binding.edtPhone.setText(document.getString("phone"));
                } else {
                    Log.d("ActivityAccount", "No such document");
                }
            } else {
                Log.d("ActivityAccount", "get failed with ", task.getException());
            }
        });
    }

    private void updateProfile() {
        String userId = currentUser.getUid();
        DocumentReference userRef = db.collection("users").document(userId);

        String userName = binding.edtUser.getText().toString().trim();
        String email = binding.edtEmail.getText().toString().trim();
        String birthday = binding.edtBirthday.getText().toString().trim();
        String phone = binding.edtPhone.getText().toString().trim();

        userRef.update(
                "userName", userName,
                "email", email,
                "birthday", birthday,
                "phone", phone
        ).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(ActivityAccount.this, "Profile updated successfully.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ActivityAccount.this, "Profile update failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
