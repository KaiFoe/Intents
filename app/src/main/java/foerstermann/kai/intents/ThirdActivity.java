package foerstermann.kai.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends Activity {

    ThirdActivityListener thirdActivityListener;
    Button btnBack;
    TextView txtvInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.thirdactivity_layout);

        txtvInput = findViewById(R.id.txtvInput);
        btnBack = findViewById(R.id.btnBack);

        thirdActivityListener = new ThirdActivityListener(this);

        btnBack.setOnClickListener(thirdActivityListener);
    }

    private class ThirdActivityListener implements View.OnClickListener {

        Intent intent;
        ThirdActivity thirdActivity;

        public ThirdActivityListener(ThirdActivity thirdActivity) {
            this.thirdActivity = thirdActivity;
            intent = thirdActivity.getIntent();
            if (intent.hasExtra("Message"))
                thirdActivity.txtvInput.setText(intent.getStringExtra("Message"));
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnBack:
                    thirdActivity.finish();
                    break;
            }

        }
    }
}
