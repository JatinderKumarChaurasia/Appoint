package com.example.jatinderkumar.appoint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import Helpers.InputValidation;
import Model.User;
import Sql.DatabaseHolder;

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    EditText edtSignUpName,edtSignUpEmail,edtSignUpPhone,edtSignUpPassword,edtSignUpConfirmPassword;
    TextView txtViewActionBar,textViewLoginLink;
    ScrollView scrollView;

    ScrollView.LayoutParams layoutParams;
    Button btnCreateAccount;
    private AppCompatActivity activity =SignUp.this;

    InputValidation validation;
    DatabaseHolder databaseHolder;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        initViews();
        initListeners();
        initObjects();
    }


    private void initViews()
    {
        btnCreateAccount =(Button)  findViewById(R.id.btnCreateAccount);
        scrollView =(ScrollView)  findViewById(R.id.signUpactivity_main);
        edtSignUpName = (EditText) findViewById(R.id.edtSignUpName);
        edtSignUpEmail =(EditText)  findViewById( R.id.edtSignUpEmail );
        textViewLoginLink =(TextView)  findViewById( R.id.textViewLoginLink );
        edtSignUpPhone =(EditText)  findViewById( R.id.edtSignUpPhone );
        edtSignUpPassword =(EditText)  findViewById( R.id.edtSignUpPassword );
        edtSignUpConfirmPassword =(EditText) findViewById( R.id.edtSignUpConfirmPassword );
    }
    private void initListeners()
    {
        btnCreateAccount.setOnClickListener( this );
        textViewLoginLink.setOnClickListener( this );
    }

    private void initObjects()
    {
        validation =new InputValidation( activity );
        databaseHolder = new DatabaseHolder( activity );
        user =new User();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnCreateAccount:
                if(postDataToSQLite()) {

                    SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
                    String newUser  = edtSignUpName.getText().toString();
                    String newPassword = edtSignUpPassword.getText().toString();
                    String newEmail = edtSignUpEmail.getText().toString();
                    String newPhone_No =edtSignUpPhone.getText().toString();

                    SharedPreferences.Editor editor = preferences.edit();

                    //stores 3 new instances of sharedprefs. Both the user and password's keys are the same as the input.
                    //Must be done this way because sharedprefs is stupid and inefficient. You cannot store Arrays easily
                    //so I use strings instead.
                    editor.putString(newUser,newUser);
                    editor.apply();
                    editor.putString(newPassword, newPassword);
                    editor.apply();
                    editor.putString(newEmail,newEmail);
                    editor.apply();
                    editor.putString(newUser + newPassword + "data", newUser + "\n" + newEmail+newPhone_No);
                    editor.apply();
                    Intent intent = new Intent(SignUp.this,SignIn.class);
                    intent.putExtra("NAME",newUser);
                    intent.putExtra("EMAIL",newEmail);
                    intent.putExtra("PHONE",newPhone_No);
                    startActivity(intent);
                }
                break;
            case R.id.textViewLoginLink:
                Intent in = new Intent( SignUp.this, SignIn.class );
                startActivity( in );
                break;

        }
    }

    private boolean postDataToSQLite()
    {
        if(!validation.isInputEditTextFilled( edtSignUpName,getString( R.string.enter_user_name ) ))
        {
            return false;
        }
        if(!validation.isInputEditTextFilled( edtSignUpEmail,getString( R.string.enter_valid_email ) ))
        {
            return false;
        }
        if(!validation.isInputEditTextFilled( edtSignUpPhone,getString( R.string.enter_phone_no ) ))
        {
            return false;
        }
        if(!validation.isInputEditTextFilled( edtSignUpPassword,getString( R.string.enter_password) ))
        {
            return false;
        }
        if(!validation.isInputEditTextFilled( edtSignUpConfirmPassword,getString( R.string.enter_password ) ))
        {
            return false;
        }
        if(!validation.isInputEditTextEmail( edtSignUpEmail,getString( R.string.error_invalid_email ) ))
        {
            return false;
        }
        if(!validation.isInputEditTextPhone( edtSignUpPhone,getString( R.string.error_valid_phone_no ) ))
        {
            return false;
        }
        if(!validation.isInputEditTextMatches( edtSignUpPassword,edtSignUpConfirmPassword,
                getString( R.string.error_password_not_match ) ))
        {
            return false;
        }
        if(!databaseHolder.checkUser( edtSignUpEmail.getText().toString().trim() )) {
            user.setName( edtSignUpName.getText().toString().trim() );
            user.setEmail( edtSignUpEmail.getText().toString().trim() );


            user.setPassword( edtSignUpPassword.getText().toString().trim() );
            databaseHolder.addUser( user );
            Snackbar.make( scrollView,getString( R.string.create_account_success ),Snackbar.LENGTH_LONG ).show();

            emptyInputEditText();
            Intent i = new Intent( SignUp.this,SignIn.class );
            startActivity( i );
            return true;
        }
        else
        {
            Snackbar.make(scrollView,getString( R.string.user_name_already_exists ),Snackbar.LENGTH_LONG ).show();
            return false;
        }
    }

    private void emptyInputEditText()
    {
        edtSignUpName.setText( null );
        edtSignUpEmail.setText( null );
        edtSignUpPhone.setText( null );
        edtSignUpPassword.setText( null );
        edtSignUpConfirmPassword.setText( null );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
