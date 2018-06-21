package com.example.yup.tvremote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.hardware.ConsumerIrManager.CarrierFrequencyRange;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void onClick(View v) {
        final int id = v.getId();
        switch (id) {
            case R.id.volUp:
                transmit(int carrierFrequency, int[] pattern);
                System.out.println("Volume Up");

                break;
        }

        switch (id) {
            case R.id.voldown:
                System.out.println("Volume Down");

                break;

        }
        switch (id) {
            case R.id.up:
                System.out.println("Up");
                break;
        }

        switch (id) {
            case R.id.down:
                System.out.println("Down");
                break;
        }

        switch (id) {
            case R.id.scan:
                System.out.println("Scan");
                break;
        }
        switch (id) {
            case R.id.ok:
                System.out.println("Ok");
                break;
        }
        switch (id) {
            case R.id.power:
                System.out.println("Power");
                break;
        }

}}
