package foerstermann.kai.intents;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;

import static android.app.Activity.RESULT_OK;
import static android.content.Intent.ACTION_SENDTO;

class MainActivityListener implements View.OnClickListener {

    MainActivity mainActivity;
    int permissionRequestCode = 123;
    Intent intent_Call = new Intent(Intent.ACTION_CALL);

    public MainActivityListener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDialer:
                Uri uri = Uri.parse("tel: +490160123456789");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                mainActivity.startActivity(intent);
                break;
            case R.id.btnCall:
                Uri call = Uri.parse("tel: +490160123456789");
                intent_Call.setData(call);
                if (mainActivity.checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermission();
                } else {
                mainActivity.startActivity(intent_Call); }
                break;
            case R.id.btnBrowser:
                Uri browser = Uri.parse("https://www.alfatraining.de");
                Intent intent_browser = new Intent(Intent.ACTION_VIEW);
                intent_browser.setData(browser);
                mainActivity.startActivity(intent_browser);
                break;
            case R.id.btnSMS:
                Uri sms = Uri.parse("smsto:0160123456789");
                Intent intent_SMS = new Intent(ACTION_SENDTO, sms);
                intent_SMS.putExtra("sms_body", "Beispieltext für unsere SMS");
                mainActivity.startActivity((intent_SMS));
                break;
            case R.id.btnActivity:
                Intent newActivity = new Intent(mainActivity, SecondActivity.class);
                mainActivity.startActivity(newActivity);
                break;
            case R.id.btnCamera:
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                mainActivity.startActivityForResult(camera, 234);
                break;
            case R.id.btnThirdActivity:
                Intent extra = new Intent(mainActivity, ThirdActivity.class);
                extra.putExtra("Message", "Dies ist ein Beispieltext");
                
                mainActivity.startActivity(extra);
        }
    }

    private void requestPermission() {
        mainActivity.requestPermissions(new String[] {Manifest.permission.CALL_PHONE}, permissionRequestCode);
    }
    public void onRequestPermissionsResult(int permissionRequestCode, String[] permissions, int[] grantResults) {
        switch (permissionRequestCode) {
            case 123:
                mainActivity.startActivity(intent_Call);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 234 && resultCode == RESULT_OK ) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            mainActivity.imgvPhoto.setImageBitmap(photo);
        }
    }
}
