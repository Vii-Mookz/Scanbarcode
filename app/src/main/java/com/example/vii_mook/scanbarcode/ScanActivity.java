package com.example.vii_mook.scanbarcode;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by vii-mook on 10/19/2017 AD.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ZXingScannerView mScannerView;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {

        // Do something with the result here
        String contents = rawResult.getText().toString();
        Log.d("handler", rawResult.getText()); // Prints scan results
        Log.d("handler", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode)
        Log.d("BARCODE ==>" , contents);
//
//        // show the scanner result into dialog box.
////        AlertDialog.Builder builder = new AlertDialog.Builder(this);
////        builder.setTitle("Scan Result");
////        builder.setMessage("Result : " + rawResult.getText());
////        AlertDialog alert1 = builder.create();
////        alert1.show();


        MainActivity.txtResult.setText("Result: " + contents);
        onBackPressed();

        Toast.makeText(this,"Result :" + contents,Toast.LENGTH_LONG).show();
        // If you would like to resume scanning, call this method below:
        //mScannerView.resumeCameraPreview(this);
    }
}