package com.example.recov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button signUp;
    EditText inputEmail;
    EditText inputPassword;


    Button login;

    // contains a regular expression pattern to match email addresses.
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]\\[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth; // provides methods from firebase for authenticating
    FirebaseUser mUser; // represents a user signing in from firebase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        login = findViewById(R.id.login);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance(); // initialised
        mUser = mAuth.getCurrentUser(); // initialised
        signUp = findViewById(R.id.signUp);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perforLogin();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void perforLogin() {

        // performs log in for user
        // grabs information from firebase database that I set up

        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();


        // checks of email matches the email pattern that was initialised
        if (email.matches(emailPattern))
        {
            inputEmail.setError("Enter Correct Email");
        }
        else if (password.isEmpty() || password.length() < 6)
        {
            inputPassword.setError("Enter Proper Password");
        }
        else {
            progressDialog.setMessage("Please wait while log in...");
            progressDialog.setTitle("Log in");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();


            // method used to authenticate a user using firebase, users email and password are used as arguments.
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    // if user authentication was successful
                    if (task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        // message to indicate login was successful
                        Toast.makeText(MainActivity.this,"Login successful", Toast.LENGTH_SHORT).show();
                    }else
                    {
                        // message to indicate login was unsuccessful
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }

    // method is ran if user authentication is successful, sends user to the home page
    private void sendUserToNextActivity() {
        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

// Intent intent = new Intent(this,page2.class);
// StartActivity(intent);