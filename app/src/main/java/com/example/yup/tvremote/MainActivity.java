package com.example.yup.tvremote;

import android.hardware.ConsumerIrManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.hardware.ConsumerIrManager.CarrierFrequencyRange;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    ConsumerIrManager remoteManager;
    int tvFrequency = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        remoteManager = (ConsumerIrManager) getSystemService(CONSUMER_IR_SERVICE);

    }



    public void onClick(View v) {
        final int id = v.getId();
        switch (id) {
            case R.id.volUp:
//                transmit( int carrierFrequency, int[] pattern);
                System.out.println("Volume Up");
                break;
            case R.id.voldown:
                System.out.println("Volume Down");

                break;
            case R.id.channelUp:
                System.out.println("Up");
                break;
            case R.id.channelDown:
                System.out.println("Down");
                break;
            case R.id.setup:
                remoteSetup();
                System.out.println("Setup");
                break;
            case R.id.ok:
                System.out.println("Ok");
                break;
            case R.id.power:
                System.out.println("Power");
                break;
            case R.id.dpadUp:
                System.out.println("Arrow Up");
                break;
            case R.id.dpadDown:
                System.out.println("Arrow Down");
                break;
            case R.id.dpadLeft:
                System.out.println("Arrow Left");
                break;
            case R.id.dpadRight:
                System.out.println("Arrow Right");
                break;
        }
        }


        public void remoteSetup(){
        CarrierFrequencyRange[] frequencies = remoteManager.getCarrierFrequencies();
        Log.i("Testing", Integer.toString(frequencies.length));
        CarrierFrequencyRange frequency = frequencies[0];
        Log.i("Testing", Integer.toString(frequency.getMaxFrequency()));
        Log.i("Testing", Integer.toString(frequency.getMinFrequency()));

        }


}

