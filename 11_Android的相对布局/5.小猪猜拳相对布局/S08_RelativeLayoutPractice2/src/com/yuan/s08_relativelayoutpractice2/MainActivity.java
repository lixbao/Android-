package com.yuan.s08_relativelayoutpractice2;




import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity {
	private RadioGroup aradioGroup;
	private RadioGroup bradioGroup;
	private Button button;
	private TextView textView;
	private TextView atextView;
	private TextView btextView;
	int Astatus=0,Bstatus=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        aradioGroup =(RadioGroup)findViewById(R.id.ArarioGroup);
        bradioGroup =(RadioGroup)findViewById(R.id.BrarioGroup);
        button =(Button)findViewById(R.id.buttonId);
        textView=(TextView)findViewById(R.id.resultTextViedId);
        atextView=(TextView)findViewById(R.id.aTextViewId);
        btextView=(TextView)findViewById(R.id.bTextViewId);
        
        RadioGroupListener listener = new RadioGroupListener();
        aradioGroup.setOnCheckedChangeListener(listener);
        bradioGroup.setOnCheckedChangeListener(listener);
        
        ButtonListener listener1 = new ButtonListener();
        button.setOnClickListener(listener1);
    }
    class RadioGroupListener implements OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			if(group ==aradioGroup ){//����ѡ��
				if(checkedId ==R.id.AstoneId){//ѡ��ʯͷ
					atextView.setText("����ѡʯͷ");
					Astatus = 1;
				}else if(checkedId == R.id.AcutterId){//ѡ�����
					atextView.setText("����ѡ����");
					Astatus = 2;
				}else if(checkedId == R.id.AclothId){//ѡ��
					atextView.setText("����ѡ��");
					Astatus = 3;
				}else{
					Astatus = 0;
				}
				
			}
			else if(group == bradioGroup ){//����ѡ��
				if(checkedId == R.id.BstoneId){//ѡ��ʯͷ
					btextView.setText("����ѡʯͷ");
					Bstatus = 1;
				}else if(checkedId == R.id.BcutterId){//ѡ�����
					btextView.setText("����ѡ����");
					Bstatus = 2;
				}else if(checkedId == R.id.BclothId){//ѡ��
					btextView.setText("����ѡ��");
					Bstatus = 3;
				}else{
					Bstatus = 0;
				}
				
			}
			
		}
    	
    }
    class ButtonListener implements OnClickListener{
        int i;
		@Override
		public void onClick(View v) {
			if(Astatus==1){
				if(Astatus-Bstatus==0){
					textView.setText("ƽ��");
				}else if(Astatus-Bstatus==-1){
					textView.setText("����Ӯ");
				}
				else if(Astatus-Bstatus==-2){
					textView.setText("����Ӯ");
				}
			}else if(Astatus ==2){
				if(Astatus-Bstatus==1){
					textView.setText("����Ӯ");
				}else if(Astatus-Bstatus==0){
					textView.setText("ƽ��");
				}
				else if(Astatus-Bstatus==-1){
					textView.setText("����Ӯ");
				}
			}else if(Astatus ==3){
				if(Astatus-Bstatus==2){
					textView.setText("����Ӯ");
				}else if(Astatus-Bstatus==1){
					textView.setText("����Ӯ");
				}
				else if(Astatus-Bstatus==0){
					textView.setText("ƽ��");
				}
			}
			// TODO Auto-generated method stub
			
		}
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
