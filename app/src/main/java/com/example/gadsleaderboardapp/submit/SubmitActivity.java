package com.example.gadsleaderboardapp.submit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.gadsleaderboardapp.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SubmitActivity extends AppCompatActivity {
    private Button submitButton;
    private EditText emailInput, firstNameInput, lastNameInput, projectLinkInput;
    Dialog custom_dialog, success_dialog;
    MaterialButton close_button, yes_button;
    private int width, height;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        Toolbar toolbar = findViewById(R.id.toolbar_submit_layout);
        submitButton = findViewById(R.id.submit_button);
        emailInput = findViewById(R.id.text_input_email);
        firstNameInput = findViewById(R.id.text_input_first_name);
        lastNameInput = findViewById(R.id.text_input_last_name);
        projectLinkInput = findViewById(R.id.text_input_project_link);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        width = metrics.widthPixels;
        height = metrics.heightPixels;


        toolbar.setNavigationIcon(R.drawable.ic_baseline_keyboard_backspace_24);

        setSupportActionBar(toolbar);

        custom_dialog = new Dialog(this);
        success_dialog = new Dialog(this);

        Retrofit retrofitSubmit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .build();

        final APIInterfaceSubmit googleForms = retrofitSubmit.create(APIInterfaceSubmit.class);

        submitButton.setOnClickListener(view -> {
            if(firstNameInput.getText().toString().isEmpty() || lastNameInput.getText().toString().isEmpty() || emailInput.getText().toString().isEmpty() ||projectLinkInput.getText().toString().isEmpty()){
                Toast.makeText(SubmitActivity.this, "Please complete details", Toast.LENGTH_SHORT).show();
            }else{

                custom_dialog.setContentView(R.layout.custom_are_you_sure_screen);
                close_button = custom_dialog.findViewById(R.id.close_button);
                yes_button =  custom_dialog.findViewById(R.id.yes_button);

                close_button.setOnClickListener(view1 -> custom_dialog.dismiss());

                custom_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                custom_dialog.getWindow().setLayout((6 * width)/7, (4 * height)/5);
                custom_dialog.show();

                yes_button.setOnClickListener(view12 -> {
                    String email = emailInput.getText().toString();
                    String firstName = firstNameInput.getText().toString();
                    String lastName = lastNameInput.getText().toString();
                    String projectLink = projectLinkInput.getText().toString();

                    Call<Void> completeGoogleForms = googleForms.completeGoogleForm(email, firstName, lastName, projectLink);

                    completeGoogleForms.enqueue(callBack);
                });


            }


        });

    }

    private final Callback<Void> callBack = new Callback<Void>() {
        @Override
        public void onResponse(Call<Void> call, Response<Void> response) {
            success_dialog.setContentView(R.layout.custom_successful);
            success_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            success_dialog.getWindow().setLayout((6 * width)/7, (4 * height)/5);
            success_dialog.show();

            handler = new Handler();
            handler.postDelayed(() -> {
                success_dialog.cancel();
                success_dialog.dismiss();
                custom_dialog.dismiss();
            }, 1000);
        }

        @Override
        public void onFailure(Call<Void> call, Throwable t) {
            success_dialog.setContentView(R.layout.custom_not_successful);
            success_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            success_dialog.getWindow().setLayout((6 * width)/7, (4 * height)/5);
            success_dialog.show();

            handler = new Handler();
            handler.postDelayed(() -> {
                success_dialog.cancel();
                success_dialog.dismiss();
            }, 1000);

        }
    };


}