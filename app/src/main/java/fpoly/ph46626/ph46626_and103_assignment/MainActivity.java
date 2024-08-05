package fpoly.ph46626.ph46626_and103_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import fpoly.ph45160.ph45160_and103_assignment.R;
import fpoly.ph46626.ph46626_and103_assignment.AccountActivity.ActivitySignIn;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, ActivitySignIn.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}