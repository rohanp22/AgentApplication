package kitchen.goodboy.agentapp_goodboy.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import kitchen.goodboy.agentapp_goodboy.others.ApplicationUtility;
import kitchen.goodboy.agentapp_goodboy.R;

public class Splash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        boolean checkConnection = new ApplicationUtility().checkConnection(this);
        if (checkConnection) {

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    SharedPreferences preferences = getSharedPreferences("default", MODE_PRIVATE);
                    Boolean isLoggedIn = preferences.getBoolean("isLoggedIn", false);


                    if (isLoggedIn) {
                        Intent i = new Intent(Splash.this, MainActivity.class);
                        startActivity(i);

                    } else {

                        Intent i = new Intent(Splash.this, Login.class);
                        startActivity(i);
                    }
                }
            }, SPLASH_TIME_OUT);

        } else {

            Toast.makeText(getApplicationContext(), "Connection not Found... Kindly Check Connection",
                    Toast.LENGTH_LONG).show();

        }


    }
}