package foerstermann.kai.intents;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {

    SecondActivityListener secondActivityListener;

    Button btn_gotoMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.secondactivity_layout);

        secondActivityListener = new SecondActivityListener(this);

        btn_gotoMain = findViewById(R.id.btn_gotoMain);

        btn_gotoMain.setOnClickListener(secondActivityListener);
    }

    private class SecondActivityListener implements View.OnClickListener {

        SecondActivity secondActivity;

        public SecondActivityListener(SecondActivity secondActivity) {
            this.secondActivity = secondActivity;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_gotoMain:
                    secondActivity.finish();
                    break;
            }
        }
    }
}

