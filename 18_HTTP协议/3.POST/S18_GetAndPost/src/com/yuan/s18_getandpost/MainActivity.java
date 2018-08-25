package com.yuan.s18_getandpost;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private Button button;
	private EditText nameText;
	private EditText pwdText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =(Button)findViewById(R.id.buttonId);
        nameText =(EditText)findViewById(R.id.nameText);
        pwdText =(EditText)findViewById(R.id.pswText);
        
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//��ȡ������û�������
				String name =nameText.getText().toString();
				String pwd = pwdText.getText().toString();
				//ʹ��Get�������������������
				//GetThread tt = new GetThread(name,pwd);
				//tt.start();
				
				
				//ʹ��POST�������������������
				PostThread td = new PostThread(name,pwd);
				td.start();
			}
		});
    }
    //���߳�ʹ��GET���������������
    class GetThread extends Thread{
    	//�����̻߳�ȡ���û��������ȡ����
    	String name;
    	String pwd;
    	//����һ�����캯��
    	public GetThread(String name,String pwd){
    		this.name=name;
    		this.pwd =pwd;
    	}
		@Override
		public void run() {
			//����HttpClient
			HttpClient httpClient = new DefaultHttpClient();
			String url = "http://192.168.1.113:8080/s18http.jsp?name="+name+"&passward="+pwd;
			
			//������������Ķ��󣬲����Ƿ��ʵķ������ĵ�ַ
			HttpGet httpGet = new HttpGet(url);
			try {
				HttpResponse resp = httpClient.execute(httpGet);
				//�����Ӧ��״̬�Ƿ�����,����200����
				if( resp.getStatusLine().getStatusCode()== 200){
					//����Ӧ����ȡ������
					HttpEntity entity = resp.getEntity();
					InputStream in = entity.getContent();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					String line = reader.readLine();
					Log.d("HTTPGET","�ӷ�����ȡ��������Ϊ"+line);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
    	
    }
  //���߳�ʹ��POST���������������
    class PostThread extends Thread{
    	//�����̻߳�ȡ���û��������ȡ����
    	String name;
    	String pwd;
    	//����һ�����캯��
    	public PostThread(String name,String pwd){
    		this.name=name;
    		this.pwd =pwd;
    	}
		@Override
		public void run() {
			//����HttpClient
			HttpClient httpClient = new DefaultHttpClient();
			//���ղ�Url��һ��
			//Post��Get���������ǣ�POST�������壬��GETû��������
			String url ="http://192.168.1.113:8080/s18http.jsp?";
			//����POST���������
			HttpPost httpPost = new HttpPost(url);
			
			//������ֵ�Զ��� ,NameValuePair���������һ����Ҫ�����������ļ�ֵ��
			NameValuePair pair1 = new BasicNameValuePair("name", name);
			NameValuePair pair2 = new BasicNameValuePair("passward", pwd);
			//��׼���õļ�ֵ�Զ��������һ��List����
			ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
			//��������ֵ�ԣ������ֵ��List
			pairs.add(pair1);
			pairs.add(pair2);
			//��������������Ķ���
			try {
				//�����������������˼�ֵ�Զ����List
				HttpEntity requesEntity = new UrlEncodedFormEntity(pairs);
				//����������������������
				httpPost.setEntity(requesEntity);
				//ִ���������
				try {
					HttpResponse resp = httpClient.execute(httpPost);
					//�����Ӧ��״̬�Ƿ�����,����200����
					if( resp.getStatusLine().getStatusCode()== 200){
						//����Ӧ����ȡ������
						HttpEntity entity = resp.getEntity();
						InputStream in = entity.getContent();
						BufferedReader reader = new BufferedReader(new InputStreamReader(in));
						String line = reader.readLine();
						Log.d("HTTPPOST","������������Ϊ"+line);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
    	
    }
    //ʹ��POST�������������������
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
