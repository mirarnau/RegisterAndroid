package edu.upc.dsa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    public static final String BASE_URL = "http://localhost:8080/dsaApp/";
    TextView username;
    TextView fullName;
    TextView email;
    TextView password;

    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }

    //Returns a TO with the information of the new registered user.
    public LoginUserTO doneClick(View view) throws IOException {
        this.username = (TextView) findViewById(R.id.usernamePlainText);
        this.fullName = (TextView) findViewById(R.id.fullNamePlainText);
        this.email = (TextView) findViewById(R.id.emailPlainText);
        this.password = (TextView) findViewById(R.id.passwordTextView);

        Call<LoginUserTO> call = apiInterface.addUser();
        LoginUserTO registeredUser = call.execute().body();
        Toast.makeText(this, "Welcome " + registeredUser.getUserName(), Toast.LENGTH_LONG).show();
        return registeredUser;

    }
}