package com.yuan.s09_datepicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends Activity {
    //��������
	private DatePicker datePicker;
	private Button button;
	private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //��ȡ�ؼ��ı�ǩ�ö����ʾ
        datePicker = (DatePicker)findViewById(R.id.datePickerId);
        textView = (TextView)findViewById(R.id.TextViewId);
        button = (Button)findViewById(R.id.buttonId);
        //����Ĭ��ʱ��
        datePicker.updateDate(2018, 8, 20);
        //ΪButton�󶨼�����
        ButtonListener listener =new ButtonListener();
        button.setOnClickListener(listener);
    }

    //ʵ��OnClickListener�ӿ�
    class ButtonListener implements OnClickListener{
		@Override
		//��дonClick����
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int y = datePicker.getYear();
			int m = datePicker.getMonth()+1;
			int d =datePicker.getDayOfMonth();
			//��ʾʱ�䣬��ΪJava�·ݴ�0��ʼ��������m��Ҫ��һ
			textView.setText("��ǰʱ��  ��"+y+"��"+m+"��"+d+"��");	
		}
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
