package com.yuan.s18_http01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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
        button =(Button)findViewById(R.id.buttonId);
        
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//ԭ�������̵߳��в��ܷ�������
				//���߳����������û��Ĵ����ͽ������ݵ�
				NetWorkThread ttNetWorkThread =new NetWorkThread();
				ttNetWorkThread.start();
			}
		});
    }

    class NetWorkThread extends Thread{
		@Override
		public void run() {
			//����HttpClient
			HttpClient httpClient = new DefaultHttpClient();
			//������������Ķ��󣬲����Ƿ��ʵķ������ĵ�ַ
			//
			HttpGet httpGet = new HttpGet("https://blog.csdn.net/qq_36243942");
			//��ȡ����ͷ���е���Ϣ
			Header reqHeader[]=httpGet.getAllHeaders();
			//��ӡ����ͷ������
			for (int i = 0; i < reqHeader.length; i++) {
				String name = reqHeader[i].getName();
				String value = reqHeader[i].getValue();
				Log.d("Http","reqHeader name:"+name+",value:"+value);
			}
			//ִ�����󣬻�ȡ��������������Ӧ����
			try {
				HttpResponse resp = httpClient.execute(httpGet);
				//�����Ӧ��״̬�Ƿ�����,����200����
				int code = resp.getStatusLine().getStatusCode();
				//�õ���Ӧͷ������
				Header resHeader[]=httpGet.getAllHeaders();
				//��ӡ����ͷ������
				for (int i = 0; i < resHeader.length; i++) {
					String name = resHeader[i].getName();
					String value = resHeader[i].getValue();
					Log.d("Http","resqHeader name:"+name+",value:"+value);
				}
				if(code == 200){
					//����Ӧ����ȡ������
					HttpEntity entity = resp.getEntity();
					InputStream in = entity.getContent();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					String line = reader.readLine();
					Log.d("HTTP","�ӷ�����ȡ��������Ϊ"+line);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
