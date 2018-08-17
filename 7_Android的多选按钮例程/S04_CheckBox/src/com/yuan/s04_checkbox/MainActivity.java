package com.yuan.s04_checkbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;


public class MainActivity extends Activity {

	private CheckBox eatBox;
	private CheckBox sleepBox;
	private CheckBox readBox;
	private CheckBox allSelectBox;
	private TextView textView1;
	private TextView textView2;
	private TextView textView3;
	private TextView allSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        eatBox = (CheckBox)findViewById(R.id.eatId);
        sleepBox=(CheckBox)findViewById(R.id.sleepId);
        readBox =(CheckBox)findViewById(R.id.readId);;
        allSelectBox =(CheckBox)findViewById(R.id.allSelectId);
        textView1 =(TextView)findViewById(R.id.textview1);
        textView2 =(TextView)findViewById(R.id.textview2);
        textView3 =(TextView)findViewById(R.id.textview3);
        allSelect =(TextView)findViewById(R.id.allselect);
        //���ɼ�������Ķ���
        CheckBoxLitener listener = new CheckBoxLitener();
        //Ϊ������ѡ���ͬһ������������
        //�������ؼ��������ĸ������������ִ��listener��onCheckedChanged����
        eatBox.setOnCheckedChangeListener(listener);
        sleepBox.setOnCheckedChangeListener(listener);
        readBox.setOnCheckedChangeListener(listener);
        allSelectBox.setOnCheckedChangeListener(listener);
    }
    class CheckBoxLitener implements OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
			if(isChecked){
				if(buttonView.getId()==R.id.eatId){
					textView1.setText("�Է���ѡ��");
				}
				else if(buttonView.getId()==R.id.sleepId){
					textView2.setText("˯����ѡ��");
				}else if(buttonView.getId()==R.id.readId){
					textView3.setText("���鱻ѡ��");
				}else{
					allSelect.setText("ȫѡѡ��");
					eatBox.setChecked(isChecked);
					sleepBox.setChecked(isChecked);
					readBox.setChecked(isChecked);
				}
			}else{
				if(buttonView.getId()==R.id.eatId){
					textView1.setText("�Է�δѡ��");
				}
				else if(buttonView.getId()==R.id.sleepId){
					textView2.setText("˯��δѡ��");
				}else if(buttonView.getId()==R.id.readId){
					textView3.setText("����δѡ��");
				}else{
					allSelect.setText("ȫѡδѡ");
					eatBox.setChecked(false);
					sleepBox.setChecked(false);
					readBox.setChecked(false);
				}
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
