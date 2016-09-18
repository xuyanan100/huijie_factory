package adapter;

import java.util.List;
import java.util.Map;

import com.zhy.demo_zhy_25_detail_of_download.R;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class adapter_base extends BaseAdapter{

	private List<String> list;
	private LayoutInflater minflater;
    private String[] names;
  //  private int[] images;
	/*public  adapter_base(Context context,List<Map<names,images>> list) {
		this.list = list; 
		//this.names=this.names;
		//this.images=this.images;
		this.minflater=LayoutInflater.from(context);
		// TODO Auto-generated constructor stub
	}*/
	public adapter_base(Context context, List mlist) {
		this.list=mlist;
		//this.images=imageids;
		this.minflater=LayoutInflater.from(context);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size() ;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder=null;
		if (convertView==null){
			holder=new ViewHolder();
			convertView=minflater.inflate(R.layout.item_tab, null);
			holder.setTvName((TextView)convertView.findViewById(R.id.name_tv));
			//holder.setImage((ImageView)convertView.findViewById(R.id.item_im));
		convertView.setTag(holder);
		}else{
			holder=(ViewHolder)convertView.getTag();
		}
		
		holder.getTvName().setText(list.get(position));
	/*	if (images[position]!=0)
		holder.getImage().setImageResource(images[position]);
		else{
			holder.getImage().setImageResource(R.drawable.ic_launcher);
		}*/
		/*if(position==0){
			holder.getReLayout().setBackgroundColor(18);
		}else{
			holder.getReLayout().setBackgroundColor(45);
		}*/
		return convertView;
	}

}
