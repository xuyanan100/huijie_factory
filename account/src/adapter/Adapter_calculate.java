package adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zhy.demo_zhy_25_detail_of_download.R;

import android.R.integer;
import android.R.string;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Adapter_calculate extends BaseAdapter{
    private List<String> mpinzhong;
    private List<String> mxinghao;
    private LayoutInflater minInflater;
    private String mlong_string;
    private String mwidth_string;
    private int danwei;
    private Context mcontext;
   // private String b_string;
    private Context context;
    private Button jisuan_bn;
    private ViewHolder holder_calculate;
    public Map<Integer,String> editorValue=new HashMap<Integer, String>();
    private Map<Integer,String> editor=new HashMap<Integer,String>();
    private String value;
    private String value2;
    private  int position_again;
    private  int position_again2;
    private List value2_list=new ArrayList<String>();
    private Button viewbn;

	public Adapter_calculate(FragmentActivity activity, List<String> mpinzhong,
			List<String> mxinghao, String mlong_string2, String mwidth_string2) {
		// TODO Auto-generated constructor stub
		this.minInflater=LayoutInflater.from(activity);
		this.mlong_string=mlong_string2;
		this.mwidth_string=mwidth_string2;
		this.mpinzhong=mpinzhong;
		this.mxinghao=mxinghao;
		//this.mcontext=context2;
		System.out.println("在标记一下"+mwidth_string);
	}
	private void init(){
		
		editorValue.clear();
		editor.clear();
		value2_list.clear();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mpinzhong.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mpinzhong.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		 holder_calculate=null;
		if(convertView==null){
			holder_calculate=new ViewHolder();
			// myListener=new MyListener(position); 
			convertView=minInflater.inflate(R.layout.item_calculate, null);
			//jisuan_bn=(Button)convertView.findViewById(R.id.item_calculate_jisuan);
			//holder_calculate.setViewBtn((Button)convertView.findViewById(R.id.item_calculate_jisuan));
			//holder_calculate.getViewBtn().setTag(position); 
			holder_calculate.setTvName((TextView)convertView.findViewById(R.id.item_calculate_pinzhong));
		    holder_calculate.setTvxinghao((TextView)convertView.findViewById(R.id.item_calculate_xinghao));
		    holder_calculate.setEtdanwei((EditText)convertView.findViewById(R.id.item_calculate_danwei));
		    holder_calculate.getEtdanwei().setTag(position); 
		    holder_calculate.setTvshuliang((TextView)convertView.findViewById(R.id.item_calculate_shuliang));
		    holder_calculate.getTvshuliang().setTag(position); 
		    holder_calculate.getEtdanwei().addTextChangedListener(new TextWatcher() {
				
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void afterTextChanged(Editable s) {
					// TODO Auto-generated method stub				
					 editor.clear();
					 if(s.equals("")&& s==null ||mlong_string.equals("") ||mwidth_string.equals("")){
						 //Toast.makeText(mcontext, "请检查单位或长宽是否填写", Toast.LENGTH_LONG).show();
						 holder_calculate.getTvshuliang().setText("0");		 
						 System.out.println("0标记一下"+s);
					 }
					   int position=(Integer) holder_calculate.getEtdanwei().getTag();
					   editorValue.put(position, s.toString());				   
					   position_again=(Integer) holder_calculate.getEtdanwei().getTag();
					   Set keys=editorValue.keySet();
					   if(keys!=null){
						  Iterator<Integer> iterator=keys.iterator();
						  while(iterator.hasNext()){
							   position_again=iterator.next();
							   value=editorValue.get(position_again);
								  if(value!=null&&!"".equals(value)){
									  try {
											danwei=Integer.parseInt(value);
											int chang=Integer.parseInt(mlong_string);
											int kuan=Integer.parseInt(mwidth_string);
											int i=(int) (chang/danwei*kuan);
											String s1=String.valueOf(i);
											editor.put(position_again, s1);					
											
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
						                 }
									  position_again2=(Integer) holder_calculate.getTvshuliang().getTag();
									   Set keys2=editor.keySet();
									   if(keys!=null){
										  Iterator<Integer> iterator2=keys.iterator();
										  while(iterator2.hasNext()){
											   position_again2=iterator2.next();
											   value2=editor.get(position_again2);
											   System.out.println("2标记一下"+value2);
											   holder_calculate.getTvshuliang().setText(value2);
											   value2_list.add(value2);	
											 
									           
										  }
										 
									   }
									  
					              }

							}
					  }		  
				}
				
			});
		    convertView.setTag(holder_calculate);
		}else{
			holder_calculate=(ViewHolder)convertView.getTag();
		}
		 try {
			  holder_calculate.getTvName().setText(mpinzhong.get(position));
			  holder_calculate.getTvxinghao().setText(mxinghao.get(position));
		      if(value2_list.size()==mpinzhong.size()){
		    	  holder_calculate.getTvshuliang().setText(value2_list.get(position).toString());		          
		      }
		  //b_string= holder_calculate.getEtdanwei().getText().toString();	  
		  System.out.println("1标记一下"+mwidth_string);
		  //System.out.println("2标记一下"+b_string);
		  System.out.println("3标记一下"+mlong_string);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return convertView;
	}
	private void listfrash(int position) {
		// TODO Auto-generated method stub

		 
		  
	}
   


	/*private class MyListener implements OnClickListener{
	      
	        int mPosition;
	        public MyListener(int inPosition){
	        	 mPosition= inPosition; 
	        }
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				b_string= holder_calculate.getEtdanwei().getText().toString();		
				 System.out.println("2标记一下"+b_string);
				 if(b_string=="" ||mlong_string=="" ||mwidth_string==""){
					 Toast.makeText(context, "请填写单位", Toast.LENGTH_LONG).show();
					 holder_calculate.getTvshuliang().setText("0");		 
					 System.out.println("0标记一下"+b_string);
				 }
					Log.v("lalalaalala", b_string);
					try {
						danwei=Integer.parseInt(b_string);
						int chang=Integer.parseInt(mlong_string);
						int kuan=Integer.parseInt(mwidth_string);
						int i=(int) (chang/danwei*kuan);
						String s=String.valueOf(i);
						
						holder_calculate.getTvshuliang().setText(s);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  
			}
		}*/
 }

