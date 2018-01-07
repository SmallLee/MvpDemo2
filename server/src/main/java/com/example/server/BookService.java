package com.example.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class BookService extends Service {
    private static final String TAG = "MainActivity";
    private ArrayList<Book> mBookList = new ArrayList<Book>();
    public BookService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBookManager;
    }
    IBookManager.Stub mBookManager = new IBookManager.Stub() {
        @Override
        public List<Book> getBookList() throws RemoteException {
            synchronized (this) {
                Log.d(TAG, "getBookList: " + mBookList + Thread.currentThread().getName());
                if (mBookList != null) {
                    return mBookList;
                }
                return new ArrayList<Book>();
            }
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            synchronized (this) {
                if (mBookList == null) {
                    mBookList = new ArrayList<Book>();
                }
                if (!mBookList.contains(book)) {
                    Log.d(TAG, "addBook: " + book + Thread.currentThread().getName());
                    mBookList.add(book);
                }
            }
        }
    };
}
