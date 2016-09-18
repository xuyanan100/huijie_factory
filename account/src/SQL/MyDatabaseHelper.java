package SQL;

import com.fragments.TabFragment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.Fragment;

public class MyDatabaseHelper extends SQLiteOpenHelper {

	public MyDatabaseHelper(Context tabFragment, String name,
			CursorFactory factory, int version) {
		super(tabFragment, name, factory, version);
		// TODO Auto-generated constructor stub
	}







	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		 String sql = "CREATE  TABLE pic (_id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , fileName VARCHAR, description VARCHAR)";   
         db.execSQL(sql);  
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
