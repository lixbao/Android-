package com.yaun.s10_progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
//����һЩ��
public class MainActivity extends Activity {
	//��������
	private ProgressBar progressBar;
	private Button firstButton,secondButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //��ȡ�ؼ��ı�ǩ�ö���ķ�����ʾ
        progressBar = (ProgressBar)findViewById(R.id.ProgressBarId);
        firstButton =(Button)findViewById(R.id.firstButtonId);
        secondButton= (Button)findViewById(R.id.secondButtonId);
        //�����ֵ
        progressBar.setMax(100);
        //���õ�һ��������ֵ
        progressBar.setProgress(20);
        //��ڶ���������ֵ
        progressBar.setSecondaryProgress(50);
        //���ɼ��������󣬲�δ������ť�󶨼�����
        OnButtonListener1 listener1 =new OnButtonListener1();
        OnbuttonListener2 listener2 =new OnbuttonListener2();
        firstButton.setOnClickListener(listener1);
        secondButton.setOnClickListener(listener2);
        
    }
    //ʵ�ְ�ť����������
    class OnButtonListener1 implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			progressBar.incrementProgressBy(10);	
		}  	
    }
    //ʵ�ְ�ť����������
    class OnbuttonListener2 implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			progressBar.incrementSecondaryProgressBy(20);
		}
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
