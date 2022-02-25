package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class enternum extends AppCompatActivity {

    EditText enternumber;
    Button getotpbytn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enternum);

        getSupportActionBar().hide();

        enternumber = findViewById(R.id.input_mobile_number);
        getotpbytn = findViewById(R.id.buttongetotp);

        ProgressBar progressBar = findViewById(R.id.progressbar_sending_otp);


        getotpbytn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!enternumber.getText().toString().trim().isEmpty()) {
                    if ((enternumber.getText().toString().trim()).length() == 10) {

                        progressBar.setVisibility(View.VISIBLE);
                        getotpbytn.setVisibility(View.VISIBLE);

                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                "+91" + enternumber.getText().toString(),
                                60,
                                TimeUnit.SECONDS, enternum.this,
                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                        progressBar.setVisibility(View.GONE);
                                        getotpbytn.setVisibility(View.VISIBLE);
                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        progressBar.setVisibility(View.GONE);
                                        getotpbytn.setVisibility(View.VISIBLE);
                                        Toast.makeText(enternum.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String backendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        progressBar.setVisibility(View.GONE);
                                        getotpbytn.setVisibility(View.VISIBLE);
                                        Intent intent = new Intent(getApplicationContext(), otpcheck.class);
                                        intent.putExtra("mobile", enternumber.getText().toString());
                                        intent.putExtra("backendotp",backendotp);
                                        startActivity(intent);
                                    }
                                }
                        );

                    } else {
                        Toast.makeText(enternum.this, "Please enter contact number", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(enternum.this, "Please enter number", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}