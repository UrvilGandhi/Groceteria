package com.example.groceteria.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.groceteria.Constants.BaseActivity;
import com.example.groceteria.Extras.DatabaseHelper;
import com.example.groceteria.Extras.InputValidation;
import com.example.groceteria.Modal.User;
import com.example.groceteria.R;

public class SignUpActivity extends BaseActivity {

    private EditText edtUser, edtEmail, edtMobile, edtPassword;
    private TextView txtLoginIn;
    private ImageView btnNext;
    private User user;
    private DatabaseHelper databaseHelper;
    private InputValidation inputValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtUser = findViewById(R.id.edtUser);
        edtEmail = findViewById(R.id.edtEmail);
        edtMobile = findViewById(R.id.edtMobile);
        edtPassword = findViewById(R.id.edtPassword);
        txtLoginIn = findViewById(R.id.txtCreateAccount);
        btnNext = findViewById(R.id.imgSignUp);

        databaseHelper = new DatabaseHelper(this);
        inputValidation = new InputValidation(this);
        user = new User();

        btnNext.setOnClickListener(v -> postDataToSQLite());
        txtLoginIn.setOnClickListener(v -> startActivity(new Intent(SignUpActivity.this, SignInActivity.class)));
    }

    private void postDataToSQLite() {
        if (inputValidation.isInputEditTextFilled(edtUser, "Please enter username")) {
            return;
        } else if (!inputValidation.isInputEditTextEmail(edtEmail, "Please enter valid email")) {
            return;
        } else if (inputValidation.isInputEditTextFilled(edtMobile, "Please enter valid mobile number")) {
            return;
        } else if (inputValidation.isInputEditTextFilled(edtPassword, "Please enter password")) {
            return;
        }

        if (!databaseHelper.checkUser(edtEmail.getText().toString().trim())) {

            user.setName(edtUser.getText().toString().trim());
            user.setEmail(edtEmail.getText().toString().trim());
            user.setMobile(edtMobile.getText().toString().trim());
            user.setPassword(edtPassword.getText().toString().trim());

            databaseHelper.addUser(user);
            Toast.makeText(this, "Welcome to Groceteria", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, SignInActivity.class));
            emptyInputEditText();
        } else {
            Toast.makeText(this, "Your email is already registered.Please enter you valid credentials", Toast.LENGTH_SHORT).show();
        }
    }

    private void emptyInputEditText() {
        edtUser.setText(null);
        edtEmail.setText(null);
        edtMobile.setText(null);
        edtPassword.setText(null);
    }
}
