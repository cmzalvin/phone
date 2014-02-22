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
        //通过id获得EditText
		edittext=(EditText)findViewById(R.id.mobile);
        //通过id获得button
        Button button=(Button)this.findViewById(R.id.button);
        //当鼠标点击是创建监听
        button.setOnClickListener(new ButtonClickListener());
    }
    
    private final class ButtonClickListener implements View.OnClickListener{
    	//方法重写
    	public void onClick(View v){
    		//获得编辑框中的内容
    		String number=edittext.getText().toString();
    		//创建一个意图
    		Intent intent=new Intent();
    		//设置匹配过滤器激活Activity
    		intent.setAction("android.intent.action.CALL");
    		intent.setData(Uri.parse("tel:"+number));
    		//通过意图激活Activity,方法内部会自动对Intent添加类别
    		startActivity(intent);
    	}
    }
}