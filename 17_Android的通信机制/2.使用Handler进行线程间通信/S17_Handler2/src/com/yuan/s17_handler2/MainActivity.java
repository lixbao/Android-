package com.yuan.s17_handler2;

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
        //��ȡ����ؼ��Ķ���
        textView =(TextView)findViewById(R.id.textViewId2);
        button =(Button)findViewById(R.id.buttonId2);
        //����һ��handler����
        handler = new MyHandler();
        //���ɼ��������󣬰󶨼�����
        button.setOnClickListener(new OnbuttonListener());
    }
    class MyHandler extends Handler{
		@Override
		public void handleMessage(Message msg) {
			//��ӡ��ǰ�̵߳�����
	    	System.out.println("handlerMessage-->"+ Thread.currentThread().getName());
	    	//�����̵߳�MyHandler���� msg
	    	String s=(String)msg.obj;
	    	//���߳��޸�TextView������
	    	textView.setText(s);
		}
    	
    }
    class OnbuttonListener implements OnClickListener{
		@Override
		public void onClick(View v) {
			Thread ft =new NetWorkThread();
			ft.start();
		}
    }
    //ģ��һ�������߳�
    class NetWorkThread extends Thread{
		@Override
		public void run() {
			//��ӡ��ǰ�̵߳�����
	    	System.out.println("netWork-->"+ Thread.currentThread().getName());
			//ģ��������磬�߳�����ʱ������2s
			try {
				Thread.sleep(2*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//����s��ֵ��ģ������統�л�ȡ������
			//ӦΪ���ﲻ��UI�̣߳����Բ���ȥ�޸�UI�����ԣ���������ؼ�
			String s = "�������ȡ������";
			//����Message����
			Message msg = handler.obtainMessage();
			//��s��ֵ��ֵ����msg��obj����
			msg.obj =s;
			//����Ϣ���͵���Ϣ�������棬Looper�ͻ��Զ�����Ϣȡ����
			//Ȼ�������Ӧ��Handler�����handleMessageȥ����Message����
			handler.sendMessage(msg);
		}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
