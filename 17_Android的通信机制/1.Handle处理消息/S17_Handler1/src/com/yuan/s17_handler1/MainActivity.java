package com.yuan.s17_handler1;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	//��������
	private TextView textView;
	private Button button;
	private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //��ȡ�ؼ��ı�ǩ�ö����ʾ
        button =(Button)findViewById(R.id.buttonId);
        textView =(TextView)findViewById(R.id.textViewId);
        handler = new FirstHandler(); 
        //���ɼ���������Ϊbutton�󶨼�����
        OnButtonListener listener =new OnButtonListener();
        button.setOnClickListener(listener);
    }
    //���û����°�ť�󣬾ͻᴴ��һ����Ϣ���󣬲��Ҹ������Ϣ�����what���Ը�ֵΪ2
    //Ȼ�����handler��sendMessage��������msg�����͵���Ϣ����ȥ
    //����Ϣ�����ж���֮��Looper�ͻ����Ϣ�����н���Ϣ����ȡ��
    //Looper�����ҵ�����Ϣ�����Ӧ��Handler����
    //Looper�������Handler�����handlerMessage(Message,msg)���������ڴ�����Ϣ����
    class OnButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			//���û������ťʱ������һ����Ϣ���󣬲�ʹ��Handler���͸ö���
			//������Ϣ����
			Message msg = handler.obtainMessage();//ÿ����Ϣ���󣬶�����֮��Ӧ��Handler����
			//������Ϣ��������� what,��ֵΪ2
			msg.what =2;
			//����Handler����������Ϣ������뵽��Ϣ���е���ȥ
			handler.sendMessage(msg);
		}	
    }
    //Ҳ���ǵ����������ĵ�HandlerMessage����
    class FirstHandler extends Handler{
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			textView.setText("what:"+what);
		}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
