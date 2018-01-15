package com.example.mvpdemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mvcdemo.R;
import com.example.mvpdemo.util.LogUtil;
import com.example.mvpdemo.util.Util;
import com.example.mvpdemo.view.adapter.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    private static final int ACTION_CHOOSE = 1;
    private RecyclerView recyclerView;
    List<String> bitmaps = new ArrayList<>();
    private ImageAdapter imageAdapter;
    private boolean mIsClickFirstImg = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) {

            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        };
        recyclerView.setLayoutManager(linearLayoutManager);
//        bitmaps.add("first");
        imageAdapter = new ImageAdapter(this,bitmaps);
        recyclerView.setAdapter(imageAdapter);
        imageAdapter.setOnImageClickListener(new ImageAdapter.OnImageClickListener() {
            @Override
            public void onImageClick(int position) {
                if (!mIsClickFirstImg && position == 0 || mIsClickFirstImg && position == bitmaps.size()){
                    LogUtil.e("1111111111111111111111111 ：" + position +"==== bitmaps : " +bitmaps.size());
                    choosePhoto();
                }
//                if (position != bitmaps.size() - 1 && bitmaps.size() > 0) return;
//                choosePhoto();
//                mPostion = position;
            }
        });
    }
    public void choosePhoto(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
        startActivityForResult(intent,ACTION_CHOOSE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null){
            String path = Util.getImageAbsolutePath(this,data.getData());
            bitmaps.add(path);
            mIsClickFirstImg = true;
            imageAdapter.notifyDataSetChanged();
//            File file = new File(path);
//            Uri uri = Uri.fromFile(file);
//            try {
//                Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
//                Bitmap smallBmp = setScaleBitmap(photo, 2);
//                imageview.setImageBitmap(smallBmp );
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
            }
    }
}
