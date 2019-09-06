package com.example.groceteria.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.groceteria.Extras.DatabaseHelper;
import com.example.groceteria.Extras.InputValidation;
import com.example.groceteria.R;

public class SignInActivity extends AppCompatActivity {

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private EditText edtUsername, edtPassword;
    private ImageView btnSignIn;
    private TextView txtForgotPassword, txtCreateUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignIn = findViewById(R.id.imgSignIn);
        txtForgotPassword = findViewById(R.id.txtforgotPassword);
        txtCreateUser = findViewById(R.id.txtCreateAccount);
        databaseHelper = new DatabaseHelper(this);
        inputValidation = new InputValidation(this);

        btnSignIn.setOnClickListener(v -> verifyFromSQLite());

        txtCreateUser.setOnClickListener(v -> startActivity(new Intent(SignInActivity.this, SignUpActivity.class)));

    }

    private void verifyFromSQLite() {
        if (inputValidation.isInputEditTextFilled(edtUsername, "Please enter valid username")) {
            return;
        } else if (inputValidation.isInputEditTextFilled(edtPassword, "Please enter valid password")) {
            return;
        }
        if (databaseHelper.checkUser(edtUsername.getText().toString().trim(), edtPassword.getText().toString().trim())) {
            emptyInputEditText();
            Toast.makeText(this, "Login SuccessFull", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please enter you valid credential", Toast.LENGTH_SHORT).show();
        }
    }

    private void emptyInputEditText() {
        edtUsername.setText(null);
        edtPassword.setText(null);
    }
}
