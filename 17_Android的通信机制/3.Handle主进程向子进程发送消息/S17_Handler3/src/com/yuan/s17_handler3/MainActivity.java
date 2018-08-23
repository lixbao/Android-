package com.yuan.s17_handler3;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

	private Button button;
	private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //��ȡ����ؼ��Ķ���
        button =(Button)findViewById(R.id.buttonId3);
        //�����̶߳�������MyThread�߳�
        Thread ft = new MyThread();
        ft.start();
     
        //���ɼ��������󣬰󶨼�������ʹ�������ڲ��෽��
        button.setOnClickListener(new OnClickListener(){
			@Override  
			public void onClick(View v) {
				System.out.println("onClick---->"+Thread.currentThread().getName());
				//�õ�һ��Message����
				Message msg = handler.obtainMessage();
				//��msg��what���Ը�ֵ
				msg.what=10;
				//���Message����ͻᷢ����Ϣ������
				handler.sendMessage(msg);
			}
        	
        });
    }
   
    //���߳�
    class MyThread extends Thread{
		@Override
		public void run() {
			//׼��Looper����
			Looper.prepare();
			//��Work Thread����һ��Handler����
			//ʹ�������ڲ���ʵ��
			handler = new Handler(){
				@Override
				public void handleMessage(Message msg) {
					System.out.println("handleMessage---->"+Thread.currentThread().getName());
					System.out.println("�յ��˴�MainThread��������Ϣ��"+msg.what);
				}
			};
			//����Looper��loop��������֮��Looper���󲻶ϴ���Ϣ������ȡ����Ϣ����
			//Ȼ�����handler��handleMessage���������������Ϣ����
			//�����Ϣ������û����Ϣ�����߳�����
			Looper.loop();
		}
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
