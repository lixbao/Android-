package com.yuan.s11_mutiactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //��ȡ��ǩ�ؼ��ö����ʾ
        button = (Button)findViewById(R.id.buttonId);
        //����button�������ʵ������󣬲�Ϊbutton����󶨼�����
        OnButtonListener buttonLitener = new OnButtonListener();
        button.setOnClickListener(buttonLitener);
    }
    class OnButtonListener implements OnClickListener{

		public void onClick(View v) {
			//������ͼ����
			Intent intent = new Intent();
			//������ͼ�ķ�����setClass����
			//setClass�����ĵ�һ��������Context����
			//Context��һ���࣬Activity��Context��һ������
			//�������е�Activity���󣬶���������ת��ΪContext����
			//----->|����Activity����ʹ�ã�MainActivity.this |<------
			//ֱ����this,��ʾ�ǵ�����������Ķ��󣬾���button��
			//setClass�����ĵڶ���������һ��Class����
			//�ڵ�ǰ������Ӧ������Ҫ��������Activity��Class����
			intent.setClass(MainActivity.this, secondActivity.class);
			//����startActivity,�������intent�������ͼ���Ǵ���һ��Activity
			startActivity(intent);
		}
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
