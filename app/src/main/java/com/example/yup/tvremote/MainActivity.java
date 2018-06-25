package com.example.yup.tvremote;

import android.hardware.ConsumerIrManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    ConsumerIrManager remoteManager;
//    Power code from irdb.tk search for Samsung
    final static String POWER = "0000 006d 0022 0003 00a9 00a8 0015 003f 0015 003f 0015 003f 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 003f 0015 003f 0015 003f 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 003f 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0040 0015 0015 0015 003f 0015 003f 0015 003f 0015 003f 0015 003f 0015 003f 0015 0702 00a9 00a8 0015 0015 0015 0e6e";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        remoteManager = (ConsumerIrManager) getSystemService(CONSUMER_IR_SERVICE);

    }

    private IRCommand hex2ir(final String irData){
//        Converts the hex information and makes an IRCommand object to store the pattern and frequency.
        List<String> list = new ArrayList<>(Arrays.asList(irData.split(" ")));
        list.remove(0);
        int frequency = Integer.parseInt(list.remove(0),16);
        list.remove(0);
        list.remove(0);
        frequency = (int) (1000000 / (frequency * 0.241246));
        int pulses = 1000000 / frequency;
        int count;

        int[] pattern = new int[list.size()];
        for (int j = 0 ; j < list.size(); j++){
            count = Integer.parseInt(list.get(j), 16);
            pattern[j] = count * pulses;
        }
        return new IRCommand(frequency, pattern);
    }


    public void onClick(View v) {
        final int id = v.getId();
        switch (id) {
            case R.id.volUp:
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
            case R.id.ok:
                System.out.println("Ok");
                break;
            case R.id.power:
                System.out.println("Power");
                IRCommand powerCommand = hex2ir(POWER);
                remoteManager.transmit(powerCommand.freq, powerCommand.pattern);
                System.out.println("Setup");
                Log.i("Testing", "Frequency " + powerCommand.freq);
                Log.i("Testing", "Pattern " + Arrays.toString(powerCommand.pattern));
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





        private class IRCommand {
            private final int freq;
            private final int[] pattern;

            private IRCommand(int freq, int[] pattern){
                this.freq = freq;
                this.pattern = pattern;
            }
        }
}

