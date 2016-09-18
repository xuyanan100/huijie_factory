package com.fragments;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.zhy.demo_zhy_25_detail_of_download.R;

import adapter.Adapter_calculate;
import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


public class Fragment_calculate extends Fragment
{
    private EditText mlong;
    private EditText mwidth;
    private EditText item_danjia;
    private Button calculate_bt;
    private Button calculate_clear;
   // private List<Map<String,Object>> list_left;
    private List<String> mpinzhong;
    private List<String> mxinghao;
    private Map<String, Object> ownmap;
    private  String item_danjia_string;
    private String mlong_string;
    private String mwidth_string;
    private ListView calculate_lv;
    private Context context;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View calculate_view= inflater.inflate(R.layout.fragment_calculate, container, false);
		//View calculate_view_item = inflater.inflate(R.layout.item_calculate, container, false);
		calculate_lv=(ListView)calculate_view.findViewById(R.id.calculate_lv);
		//item_danjia=(EditText)calculate_view_item.findViewById(R.id.item_calculate_danwei);
	   // item_danjia_string=item_danjia.getText().toString();
		mlong=(EditText)calculate_view.findViewById(R.id.calculate_type_changdu);
		
		mwidth=(EditText)calculate_view.findViewById(R.id.calculate_type_kuandu);
		
		
		
		calculate_clear=(Button)calculate_view.findViewById(R.id.construction_clear);
		
			
		calculate_clear.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//flag=true;
				mlong_string=mlong.getText().toString();
				mwidth_string=mwidth.getText().toString();
				  if(mlong_string.equals("")&& mlong_string==null ||mwidth_string.equals("")&&mwidth_string==null){
					  Toast.makeText(getActivity(), "请检查长度或宽度", Toast.LENGTH_LONG);
				  }
				initdata();
				refreshlistview();	
			}
			
		});

	
		return calculate_view;   
   }
	
		
	
	private void refreshlistview() {
		// TODO Auto-generated method stub

	  Adapter_calculate madapter=new Adapter_calculate(getActivity(),mpinzhong,mxinghao,mlong_string,mwidth_string);
	  calculate_lv.setAdapter(madapter);
	}
	private void initdata() {
		// TODO Auto-generated method stub
		TabFragment tabfrag=new TabFragment();
		mpinzhong=new ArrayList<String>();
		mxinghao=new ArrayList<String>();
		//System.out.println(list_left);
		 ownmap=new HashMap<String, Object>();
		 ownmap=tabfrag.map;
			int x=ownmap.size();
			System.out.println( " and value= " + x);
	     Iterator<Entry<String, Object>> it=ownmap.entrySet().iterator();
	    
	     while(it.hasNext()){
		  Map.Entry<String, Object> entry=it.next();
		  
		  mpinzhong.add(entry.getKey());		  
		  mxinghao.add((String) entry.getValue());
       }
	
	}
}  
	

