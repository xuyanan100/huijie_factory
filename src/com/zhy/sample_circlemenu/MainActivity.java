package com.zhy.sample_circlemenu;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * <pre>
 * @author zhy 
 * http://blog.csdn.net/lmj623565791/article/details/43131133
 * </pre>
 */
public class MainActivity extends Activity
{
	
	private Button chushibtn;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
        chushibtn=(Button)findViewById(R.id.enter_btn);
        chushibtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				ComponentName comp=new ComponentName(MainActivity.this,CircleActivity.class);
				Intent intent = new Intent();
				intent.setComponent(comp);
				
				startActivity(intent);	
			
			}
		});
		

	}

	


//创建Actionbar
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if (item.getItemId()==R.id.action_settings)
		{
	
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_VIEW);
			intent.setData(Uri
					.parse("http://blog.csdn.net/lmj623565791?viewmode=contents"));
			startActivity(intent);
			return true;
		}else{
			return false;
		}
		
	}

}
