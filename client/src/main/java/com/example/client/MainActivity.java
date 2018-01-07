package com.example.client;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.server.Book;
import com.example.server.IBookManager;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    IBookManager mBookManager = null;
    private boolean mBound = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void getBookInfo(View view){
        if (!mBound) {
            Intent intent = new Intent("com.lxn.getbook");
            bindService(intent,mBookConnection,BIND_AUTO_CREATE);
        }
    }
    private ServiceConnection mBookConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected: " + name +"--service--" + service);
            mBookManager = IBookManager.Stub.asInterface(service);
            Log.d(TAG, "mBookManager: " + Thread.currentThread().getName());
            mBound = true;
            if (mBookManager != null) {
                Book book = new Book(1,"AA");
                try {
                    mBookManager.addBook(book);
                    for (Book book2 : mBookManager.getBookList()) {
                        Log.d(TAG, "onServiceConnected: " + book2);
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(mBookConnection);
            mBound = false;
        }
    }
}
