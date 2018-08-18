package com.yuan.s06_imageview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MainActivity extends Activity {
    //��������
	private ImageView imageView1;
	private ImageView imageView2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //��ȡImageView��ǩ�Ķ���
        imageView1 =(ImageView)findViewById(R.id.imageViewId);
        imageView2 =(ImageView)findViewById(R.id.imageViewId1);
        //ͼƬ1������center��ͼƬ2����fitCenter
        imageView1.setScaleType(ScaleType.CENTER);
        imageView2.setScaleType(ScaleType.FIT_CENTER);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
