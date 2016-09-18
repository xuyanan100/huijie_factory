package adapter;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewHolder {
	private TextView Tvxinghao;
	private TextView TvName;
	private EditText Etdanwei;
    private TextView Tvshuliang;
    private Button viewBtn;
    public Button getViewBtn() {
		return viewBtn;
	}
	public void setViewBtn(Button viewBtn) {
		this.viewBtn = viewBtn;
	}
	public EditText getEtdanwei() {
		return Etdanwei;
	}
	public void setEtdanwei(EditText etdanwei) {
		Etdanwei = etdanwei;
	}
	public TextView getTvshuliang() {
		return Tvshuliang;
	}
	public void setTvshuliang(TextView tvshuliang) {
		Tvshuliang = tvshuliang;
	} 
   public TextView getTvName(){
	return TvName;  
   }
   public void setTvName(TextView tvname){
	 TvName=tvname;
   }
   public TextView getTvxinghao() {
		return Tvxinghao;
	}
	public void setTvxinghao(TextView tvxinghao) {
		Tvxinghao = tvxinghao;
	}
  }
