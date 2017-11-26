package com.example.jatinderkumar.appoint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.provider.ContactsContract;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import Helpers.InputValidation;
import Sql.DatabaseHolder;

public class SignIn extends AppCompatActivity  implements View.OnClickListener{


    TextView txtViewActionBar;
    Button btnSignInSubmit;
    EditText edtSignInUserName,edtSignInPassword;
    TextView register;
    ConstraintLayout constraintLayout;
    AnimationDrawable animationDrawable;
    ConstraintLayout.LayoutParams layoutParams;
    private final AppCompatActivity activity = SignIn.this;

    private InputValidation inputValidation;
    private DatabaseHolder databaseHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
       ActionBar actionBar = this.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
       // actionBar.setHomeButtonEnabled(true);

        constraintLayout =(ConstraintLayout) findViewById(R.id.signin_constraintLayout);


        initViews();
        initObjects();
        initListeners();


    }

    private void initViews()
    {
        btnSignInSubmit =(Button)  findViewById( R.id.btnSignInSubmit );
        edtSignInUserName =(EditText)  findViewById( R.id.edtSignInUserName );
        edtSignInPassword =(EditText) findViewById( R.id.edtSignInPassword );
        register =(TextView) findViewById( R.id.register );
    }
    private void initListeners()
    {
        btnSignInSubmit.setOnClickListener( this );
        register.setOnClickListener( this );
    }
    private void initObjects()
    {
        databaseHolder = new DatabaseHolder( activity );
        inputValidation = new InputValidation(activity);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSignInSubmit:

                if((verifyFromSQLite()))
                {
                    String user = edtSignInUserName.getText().toString();
                    String password = edtSignInPassword.getText().toString();
                    SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                    //String savedPassword = preferences.getString(password, "");
                    //String savedUserName = preferences.getString(user, "");

                    String userDetails = preferences.getString(user + password + "data","No information on that user.");
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("display",userDetails);
                    editor.apply();

//                     String UserName =getIntent().getExtras().getString("NAME");
 //                    String Email =getIntent().getExtras().getString("EMAIL");
 //                    String Phone = getIntent().getExtras().getString("PHONE");

                    Intent displayScreen = new Intent(SignIn.this, MainActivity.class);
                   // displayScreen.putExtra("UserName",user);
                  //  displayScreen.putExtra("Phone_No",Phone);
                  //  displayScreen.putExtra("Email",Email);
                    startActivity(displayScreen);
                }
                break;
            case R.id.register:
                Intent intentSignUp = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intentSignUp);
                break;
        }
    }



    private boolean verifyFromSQLite() {
        if (!inputValidation.isInputEditTextFilled( edtSignInUserName, getString( R.string.enter_user_name ) ) &&
                !inputValidation.isInputEditTextFilled(edtSignInPassword,"Enter Password")) {
            return false;
        }
        else if (!inputValidation.isInputEditTextFilled( edtSignInUserName, "Enter UserName" ))
        {
            return false;
        }
        else if( !(inputValidation.isInputEditTextFilled(edtSignInPassword,"Enter Password")))
        {
            return false;
        }

        if (databaseHolder.checkUser( edtSignInUserName.getText().toString().trim(),
                edtSignInPassword.getText().toString().trim() )) {
            Intent intentMain = new Intent( getApplicationContext(), MainActivity.class );
            intentMain.putExtra( "UserName", edtSignInUserName.getText().toString() );
            emptyInputEditText();
            startActivity( intentMain );
            return true;
        }else
        {
            Snackbar.make( constraintLayout,getString( R.string.enter_valid_user_name_or_password ),Snackbar.LENGTH_LONG ).show();
            return false;
        }

    }
    private void emptyInputEditText() {
        edtSignInUserName.setText(null);
        edtSignInPassword.setText(null);
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
