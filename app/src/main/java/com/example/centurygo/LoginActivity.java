package com.example.centurygo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText editTextEmail, editTextPassword;

    Button signIn;

    TextView signUp;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        signIn = findViewById(R.id.sign_in);
        signUp = findViewById(R.id.sign_up);

        signUp.setOnClickListener(view -> {
            Intent Intent = new Intent(LoginActivity.this, Register.class);
            startActivity(Intent);
            finish();
        });

        signIn.setOnClickListener(view -> {
            String email,password;
            email= String.valueOf(editTextEmail.getText());
            password = String.valueOf(editTextPassword.getText());

            if(TextUtils.isEmpty(email)){
                Toast.makeText(LoginActivity.this,"Ingresa tu correo electrónico",Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(password)){
                Toast.makeText(LoginActivity.this,"Ingresa su contraseña",Toast.LENGTH_SHORT).show();
                return;
            }

            firebaseAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(task -> {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"Ingreso Exitoso",Toast.LENGTH_SHORT).show();
                            Intent Intent = new Intent(LoginActivity.this, HomePage.class);
                            startActivity(Intent);
                            finish();
                        }else{
                            Toast.makeText(LoginActivity.this,"Error al ingresar",Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}
