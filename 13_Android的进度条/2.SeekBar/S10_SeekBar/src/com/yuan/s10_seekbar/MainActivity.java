package com.yuan.s10_seekbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	//��������
	private SeekBar seekBar;
	private TextView textView1,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //��ȡ�ؼ��ı�ǩ�ö���ķ�����ʾ
        seekBar =(SeekBar)findViewById(R.id.seekBarId);
        textView1=(TextView)findViewById(R.id.textViewId1);
        textView2=(TextView)findViewById(R.id.textViewId2);
        //���ó�ʼֵ
        seekBar.setProgress(20);
        seekBar.setSecondaryProgress(30);
        //���ü�����
        SeekBarListener listener = new SeekBarListener();
        seekBar.setOnSeekBarChangeListener(listener);
    }

    class SeekBarListener implements OnSeekBarChangeListener{

    	//seekBar�����˴����˼�����SeekBar����
    	//progress��ǰSeekBar�Ľ���
    	//fromUser�������û���������ϵͳ�Զ��������ȣ���������û������ֵΪtrue
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
				textView1.setText("progress:"+progress+",fromUser:"+fromUser);
		}

		public void onStartTrackingTouch(SeekBar seekBar) {
				textView2.setText("��ʼ�϶�");
		}
		public void onStopTrackingTouch(SeekBar seekBar) {
				textView2.setText("ֹͣ�϶�");
			
		}
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
