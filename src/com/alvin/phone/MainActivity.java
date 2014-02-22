package com.alvin.phone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	private EditText edittext;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        //ͨ��id���EditText
		edittext=(EditText)findViewById(R.id.mobile);
        //ͨ��id���button
        Button button=(Button)this.findViewById(R.id.button);
        //��������Ǵ�������
        button.setOnClickListener(new ButtonClickListener());
    }
    
    private final class ButtonClickListener implements View.OnClickListener{
    	//������д
    	public void onClick(View v){
    		//��ñ༭���е�����
    		String number=edittext.getText().toString();
    		//����һ����ͼ
    		Intent intent=new Intent();
    		//����ƥ�����������Activity
    		intent.setAction("android.intent.action.CALL");
    		intent.setData(Uri.parse("tel:"+number));
    		//ͨ����ͼ����Activity,�����ڲ����Զ���Intent������
    		startActivity(intent);
    	}
    }
}