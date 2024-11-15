package com.example.apptest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterUser extends AppCompatActivity {
EditText emailid;
EditText password;
Button Register;
public static final String Shared_per="shared_per";
private FirebaseAuth auth;
FirebaseAuth user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_user);
        emailid=findViewById(R.id.emailid);
        password=findViewById(R.id.editText);
        Register=findViewById(R.id.button2);
        auth = FirebaseAuth.getInstance();
        Register.setOnClickListener(view -> {
            createUser();
            Intent next=new Intent(RegisterUser.this,UserValidate.class);
            startActivity(next);
            finish();
        });
    }
    public void createUser(){
        String email = emailid.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if (email.isEmpty() || pass.isEmpty()) {
            Toast.makeText(RegisterUser.this, "Email and password must not be empty", Toast.LENGTH_SHORT).show();
            return;
        }
            auth.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(RegisterUser.this, "Registration Sucessfull", Toast.LENGTH_SHORT).show();
                                 user = auth;

                            } else {
                                // If sign in fails, display a message to the user.

                                Toast.makeText(RegisterUser.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

        }




}
