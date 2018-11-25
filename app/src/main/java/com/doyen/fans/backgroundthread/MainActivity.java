package com.doyen.fans.backgroundthread;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DialogTitle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    private static final String TAG = "MainActivity";
    
    private Button btnStart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startThread(v);
            }
        });
    }

    public void startThread(View view){

        ExampleRunnable runnable = new ExampleRunnable(10);
        new Thread(runnable).start();

        //ExampleThread thread = new ExampleThread(10);
        //thread.run();
    }

    class ExampleThread extends Thread {
        private int seconds;

        ExampleThread(int seconds){
            this.seconds = seconds;
        }

        @Override
        public void run() {
            for (int i = 0; i<seconds; i++){
                Log.d(TAG, "startThread: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class ExampleRunnable implements Runnable{
        private int seconds;
        ExampleRunnable(int seconds){
            this.seconds = seconds;
        }
        @Override
        public void run() {
            for (int i = 0; i<seconds; i++){
                Log.d(TAG, "startThread: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
