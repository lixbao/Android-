package com.yuan.s12_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
	//��������
	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//ʹ��setContentView(View)����ʾָ���ؼ�
		setContentView(R.layout.activity_second);
		//��ȡ����ռ�Ķ���
		textView =(TextView)findViewById(R.id.secondTextViewId2);
		//������ͼ����
		Intent intent = getIntent();
		//��ȡ��ͼ���������
		int age = intent.getIntExtra("com.yuan.s12_intent.Age", 10);
		String name =intent.getStringExtra("com.yuan.s12_intent.name");
		//��ʾ��ȡ����ֵ
		textView.setText("Age:"+age+",name:"+name);
	}

}
