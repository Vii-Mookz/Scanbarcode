package com.example.vii_mook.scanbarcode;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.R.attr.data;
import static android.R.attr.handle;

public class MainActivity extends AppCompatActivity {

    public static TextView txtResult;
    private  Button btn_scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = (TextView) findViewById(R.id.txtResult);

        btn_scan = (Button) findViewById(R.id.btn_scan);

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScanActivity.class);
                startActivity(intent);
            }
        });

    }
}
//public class MainActivity extends AppCompatActivity  implements ZXingScannerView.ResultHandler{
//
//    private ZXingScannerView mScannerView;
//    private TextView txtResult;
//    private Button button;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        txtResult = (TextView) findViewById(R.id.txtResult);
//        button = (Button) findViewById(R.id.btn_scan);
//    }
//    public void QrScanner(View view){
//
//
//        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
//        setContentView(mScannerView);
//
//        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
//        mScannerView.startCamera();         // Start camera
//
//    }
//
//    public void handleResult(Result rawResult) {
//
//        // Do something with the result here
//        String contents = rawResult.getText().toString();
//        Log.e("handler", rawResult.getText()); // Prints scan results
//        Log.e("handler", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode)
//        Log.d("BARCODE ==>" , contents);
//
//        // show the scanner result into dialog box.
////        AlertDialog.Builder builder = new AlertDialog.Builder(this);
////        builder.setTitle("Scan Result");
////        builder.setMessage("Result : " + rawResult.getText());
////        AlertDialog alert1 = builder.create();
////        alert1.show();
//        startActivity(new Intent(this,MainActivity.class));
//        MainActivity.this.txtResult.setText(contents);
//        onBackPressed();
////
//
////
////
////
//////        this.txtResult.setText("Result : " +content);
////this.txtResult.setText(contents);
//        Toast.makeText(this,"Result :" + rawResult.getText(),Toast.LENGTH_LONG).show();
////        this.finish();
//        // If you would like to resume scanning, call this method below:
////         mScannerView.resumeCameraPreview(this);
//
//
//    }
//
////
////    @Override
////    public void onPause() {
////        super.onPause();
////        mScannerView.stopCamera();           // Stop camera on pause
////    }
//
//
//
//
//}
