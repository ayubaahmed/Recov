package com.example.recov;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    TextView alreadyHaveAccount;
    EditText inputEmail;
    EditText inputPassword;

    EditText inputConfirmPassword;

    Button buttonRegister;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]\\[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupactivity_main);

        inputEmail = findViewById(R.id.input_email);
        inputPassword = findViewById(R.id.input_password);
        inputConfirmPassword = findViewById(R.id.input_confirmPassword);
        buttonRegister = findViewById(R.id.register);
        alreadyHaveAccount = findViewById(R.id.alreadyHaveAnAccount);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        String getEmail = inputEmail.getText().toString();

        Intent o = new Intent(SignUpActivity.this, ProfileActivity.class);
        o.putExtra("inputEmail",getEmail);
        startActivity(o);

        alreadyHaveAccount.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,MainActivity.class));
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerformAuth();
            }
        });

    }

    private void PerformAuth() {
        // performs authentication for user when signing in
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        String confirmPassword = inputConfirmPassword.getText().toString();

        if (email.matches(emailPattern))
        {
            inputEmail.setError("Enter Correct Email");
        }
        else if (password.isEmpty() || password.length() < 6)
        {
            inputPassword.setError("Enter Proper Password");
        }
        else if (!password.equals(confirmPassword))
        {
            inputConfirmPassword.setError("Password Does Not match");

        }
        else {
            progressDialog.setMessage("Please wait while registration...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            // creates a new user on firebase
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        // if registration is successful
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(SignUpActivity.this,"Registration successful", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if registration is not successful
                        progressDialog.dismiss();
                        Toast.makeText(SignUpActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(SignUpActivity.this,HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
