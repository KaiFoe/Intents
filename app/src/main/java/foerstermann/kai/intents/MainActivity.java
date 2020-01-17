package foerstermann.kai.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;

public class MainActivity extends Activity {

    Button btnDialer, btnCall, btnBrowser, btnSMS, btnActivity, btnCamera, btnThirdActivity;
    ImageView imgvPhoto;
    MainActivityListener mainActivityListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mainactivity_layout);

        mainActivityListener = new MainActivityListener(this);

        btnDialer = findViewById(R.id.btnDialer);
        btnCall = findViewById(R.id.btnCall);
        btnBrowser = findViewById(R.id.btnBrowser);
        btnSMS = findViewById(R.id.btnSMS);
        btnActivity = findViewById(R.id.btnActivity);
        btnCamera = findViewById(R.id.btnCamera);
        btnThirdActivity = findViewById(R.id.btnThirdActivity);
        imgvPhoto = findViewById(R.id.imgvPhoto);


        btnDialer.setOnClickListener(mainActivityListener);
        btnCall.setOnClickListener(mainActivityListener);
        btnBrowser.setOnClickListener(mainActivityListener);
        btnSMS.setOnClickListener(mainActivityListener);
        btnActivity.setOnClickListener(mainActivityListener);
        btnCamera.setOnClickListener(mainActivityListener);
        btnThirdActivity.setOnClickListener(mainActivityListener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mainActivityListener.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mainActivityListener.onActivityResult(requestCode, resultCode, data);
    }
}
