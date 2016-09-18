package com.fragments;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import SQL.MyDatabaseHelper;
import adapter.adapter_base;
import android.R.integer;
import android.R.string;
import android.app.AlertDialog;
import android.app.ListFragment;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.zhy.demo_zhy_25_detail_of_download.R;
import com.zhy.view.MyInnerScrollView;


public class TabFragment extends Fragment
{
	public static final String TITLE = "title";
	protected static final int GET_ALL_APP_FINISH = 80;
	private String mTitle = "Defaut Value";

	private TextView mTextView;
	private MyInnerScrollView mInnerScrollView;
	
	private ScrollView mParentScrollView;
	//private View mHeadView;
	private ListView list;
	private LinearLayout ll_loading;
	private List<String> mlist;
	//private List<String> mxinghao;
//	public static List<Map<String,Object>> list_lft;	
	private TextView model;
	private String[] xinghao= new String[]{"1号","2号","3号","10号"};
	public static  Map<String, Object> map=new HashMap<String, Object>();
	private String word="滴水";
	private String word2;
	private TextView tab_dialog_tv;
	//public String db_name = "mysqlite";
	//final MyDatabaseHelper helper = new MyDatabaseHelper(getActivity(),db_name, null, 1);   
    
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		if (getArguments() != null)
		{
			mTitle = getArguments().getString(TITLE);
		}
     
      
             

	}

	private void creatDialog() {
		// TODO Auto-generated method stub
	   list.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, final int arg2,
				long arg3) {
			// TODO Auto-generated method stub
		model=(TextView)arg1.findViewById(R.id.model_tv);
	   // tab_dialog_tv=(TextView)arg1.findViewById(R.id.fragment_tab_dialog_tv);
		
		AlertDialog.Builder dialog=new AlertDialog.Builder(getActivity());
		dialog.setTitle("尺寸大小");
		dialog.setSingleChoiceItems(xinghao,-1, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub		
				//word=tab_dialog_tv.getText().toString();
			    //word2=word.substring(0, word.length()-1);
				switch(which){
				
				case 0:					
					model.setText("1号");
					Log.v("恩恩", "enheng");
					//getData(word, "1号");				
					map.put(mlist.get(arg2), "1号");
					break;
				case 1:
					model.setText("2号");
					//getData(word, "2号");
					map.put(mlist.get(arg2), "2号");
					break;
				case 2:
					model.setText("3号");
					//getData(word, "3号");
					map.put(mlist.get(arg2), "3号");
					break;
				case 3:
					model.setText("10号");
					//getData(word, "10号");
					map.put(mlist.get(arg2), "10号");
					break;
				
				}
				dialog.dismiss();
			}
		}).show();
		}
	});
	  list.setOnItemLongClickListener(new OnItemLongClickListener() {

		@Override
		public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
				int arg2, long arg3) {
			// TODO Auto-generated method stub
			AlertDialog.Builder dialog_long=new AlertDialog.Builder(getActivity());
			dialog_long.setTitle("提示")
			           .setMessage("修改瓦品种*^*")
			           .setPositiveButton("添加", new DialogInterface.OnClickListener() {				
				          @Override
			  	        public void onClick( DialogInterface dialog, int which) {
					
					       // TODO Auto-generated method stub
					      // dialog.dismiss();
					
					      final AlertDialog.Builder dialog_edit=new AlertDialog.Builder(getActivity());
					      View view_dialog=LayoutInflater.from(getActivity()).inflate(R.layout.item_fragment_tab_dialog,null);
				           final EditText et_pinzhong=(EditText)view_dialog.findViewById(R.id.fragment_tab_dialog_et);
				           
					       dialog_edit.setTitle("添加")
					           .setView(view_dialog)
					           .setPositiveButton("确定", new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									 

									final String pinzhong=et_pinzhong.getText().toString();
									 if((!mlist.contains(pinzhong))&&(pinzhong!=""))							
									{ 
										
										 mlist.add(pinzhong);
										Log.v("么么", pinzhong);
									
									}
									   
									
								}
							})
							.setNegativeButton("取消", null)
							.create()
							.show();			    
				}

			})
			.setNegativeButton("取消", null)
			.create()
			.show();
			return false;
		}
	});
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_tab, container, false);
		View view_item = inflater.inflate(R.layout.item_tab, container, false);
		
		//mTextView = (TextView) view.findViewById(R.id.id_info);
		list=(ListView)view.findViewById(R.id.content_lv);
		//model=(TextView)view_item.findViewById(R.id.model_tv);
		// mTextView.setText(mTitle);

		 mlist = new ArrayList<String>();
        // mxinghao=new ArrayList<String>();
         
         mlist.add(new String("滴水"));
         mlist.add(new String("猫头"));
         mlist.add(new String("板瓦"));
         mlist.add(new String("筒瓦"));
         mlist.add(new String("折腰"));
         mlist.add(new String("花边"));
         mlist.add(new String("瓦架"));

         
        
/*         for(int i=0; i<mlist.size();i++){
          imageids.put(mlist.get(i), R.drawable.dishui);
         
         {,R.drawable.maotou,R.drawable.zheyao,R.drawable.banwa,R.drawable.tongwa,
        	 R.drawable.huabian,R.drawable.wajia}*/;
         //} 
        refreshlist();
		creatDialog();
		mapfetch();
		refreshlist();
		
		return view;
	

	}

private void mapfetch() {
	
		// TODO Auto-generated method stub
	int i=map.size();
	System.out.println( " and value= " + i);
	if(i==0){
		map.put(new String("实例"), "1号");
		
	}else{
		 
		 System.out.println( " and value= " + i);
		for (Object v : map.values()) {
			
			 
			
		}  
       
    
	}
}

/*	private void getData(String word,String detail) {
		// TODO Auto-generated method stub
		SQLiteDatabase db=helper.getReadableDatabase();
		db.execSQL("insert into dict values(null,?,?)",new String[]{word,detail});
	    
	}*/



	public static TabFragment newInstance(String title)
	{
		TabFragment tabFragment = new TabFragment();
		Bundle bundle = new Bundle();
		bundle.putString(TITLE, title);
		tabFragment.setArguments(bundle);
		return tabFragment;
	}
	
	public void setParentScrollView(ScrollView scrollView)
	{
		this.mParentScrollView = scrollView;
	}
	public void refreshlist() {
		// TODO Auto-generated method stub
		adapter_base madapter=new adapter_base(getActivity(), mlist);
		list.setAdapter(madapter);
	}

}
	