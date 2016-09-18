package com.zhy.demo_zhy_25_detail_of_download;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;
import cn.androiddevelop.cycleviewpager.lib.CycleViewPager;
import cn.androiddevelop.cycleviewpager.lib.CycleViewPager.ImageCycleViewListener;

import com.fragments.Fragment_calculate;
import com.fragments.Fragment_calculate;
import com.fragments.TabFragment;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.stevenhu.android.phone.bean.ADInfo;
import com.stevenhu.android.phone.utils.ViewFactory;
import com.zhy.view.SimpleViewPagerIndicator;




/**
 * 
 * http://blog.csdn.net/lmj623565791/
 * @author zhy
 *
 */
public class MainActivity extends FragmentActivity
{
	private String[] mTitles = new String[] { "品种", "计算" };
	private SimpleViewPagerIndicator mIndicator;
	private ViewPager mViewPager;
	private FragmentPagerAdapter mAdapter;
	private ScrollView mParentScrollView;
	
    
    private List<Fragment> fragmentList; 
    private Fragment_calculate abfrag;
    private TabFragment mFragment1;
    //private Fragment_calculate mFragment_calculate;
    
	private List<ImageView> views = new ArrayList<ImageView>();
	private List<ADInfo> infos = new ArrayList<ADInfo>();
	private CycleViewPager cycleViewPager;
	private  String[] image = {"http://img.redocn.com/photo/20140504/Redocn_2014041522480902.jpg",
			"http://pic16.nipic.com/20110924/8419166_143729213000_2.jpg",
			"http://pic55.nipic.com/file/20141209/3302065_211158122825_2.jpg",
			"http://image86.360doc.com/DownloadImg/2015/07/0522/55722362_149.jpg",
			"http://img2.imgtn.bdimg.com/it/u=638040982,3580635910&fm=21&gp=0.jpg"};
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
		initDatas();
		initEvents();
		Log.v("呵呵", "meme");
		configImageLoader();
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		for(int i = 0; i < image.length; i ++){
			ADInfo info = new ADInfo();
			info.setUrl(image[i]);
			info.setContent("图片-->" + i );
			infos.add(info);
		}
		
		// 将最后一个ImageView添加进来
		views.add(ViewFactory.getImageView(this, infos.get(infos.size() - 1).getUrl()));
		//views.add(image( image.get(image.size() - 1).getUrl()));
		for (int i = 0; i < infos.size(); i++) {
			views.add(ViewFactory.getImageView(this, infos.get(i).getUrl()));
		}
		// 将第一个ImageView添加进来
		views.add(ViewFactory.getImageView(this, infos.get(0).getUrl()));
		
		// 设置循环，在调用setData方法前调用
		cycleViewPager.setCycle(true);

		// 在加载数据前设置是否循环
		cycleViewPager.setData(views, infos, mAdCycleViewListener);
		//设置轮播
		cycleViewPager.setWheel(true);

	    // 设置轮播时间，默认5000ms
		cycleViewPager.setTime(2000);
		//设置圆点指示图标组居中显示，默认靠右
		cycleViewPager.setIndicatorCenter();
	}
	private ImageCycleViewListener mAdCycleViewListener = new ImageCycleViewListener() {

		@Override
		public void onImageClick(ADInfo info, int position, View imageView) {
			if (cycleViewPager.isCycle()) {
				position = position - 1;
				Toast.makeText(MainActivity.this,
						"position-->" + info.getContent(), Toast.LENGTH_SHORT)
						.show();
			}
			
		}

	};

	private void initEvents()
	{
		ViewTreeObserver vto = mViewPager.getViewTreeObserver();
		vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener()
		{

			public void onGlobalLayout()
			{
				mViewPager.getViewTreeObserver().removeGlobalOnLayoutListener(
						this);
				LayoutParams params = mViewPager.getLayoutParams();
				params.height = getWindow().getDecorView()
						.findViewById(android.R.id.content).getHeight()
						- mIndicator.getHeight();
				mViewPager.setLayoutParams(params);
			}
		});
		

		mViewPager.setOnPageChangeListener(new OnPageChangeListener()
		{

			@Override
			public void onPageSelected(int position)
			{
			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels)
			{
				mIndicator.scroll(position, positionOffset);
			}

			@Override
			public void onPageScrollStateChanged(int state)
			{

			}
		});

	}

	private void initDatas()
	{
		mIndicator.setTitles(mTitles);
		mFragment1 = new TabFragment();
	    //mFragment1.setParentScrollView(mParentScrollView);
	    //mFragment_calculate = new Fragment_calculate();
	    //mFragment2.setParentScrollView(mParentScrollView);   
	    abfrag= new Fragment_calculate();
		fragmentList=new ArrayList<Fragment>();
		fragmentList.add(mFragment1);		
		//fragmentList.add(mFragment_calculate);
		fragmentList.add(abfrag);
		    	
   
		
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
		{
			@Override
			public int getCount()
			{
		        if (fragmentList != null) {
		            return fragmentList.size();
		        }
		        return 0;
			}

			@Override
			public Fragment getItem(int position)
			{
				return fragmentList.get(position);
			}

		};

		mViewPager.setAdapter(mAdapter);
		mViewPager.setCurrentItem(0);
	}

	private void initViews()
	{
		mIndicator = (SimpleViewPagerIndicator) findViewById(R.id.id_indicator);
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
		mParentScrollView = (ScrollView) findViewById(R.id.id_sv_wrapper);
		mIndicator.setParentScrollView(mParentScrollView);
		cycleViewPager = (CycleViewPager) getFragmentManager()
				.findFragmentById(R.id.fragment_cycle_viewpager_content);
	}
	private void configImageLoader() {
		// 初始化ImageLoader
		@SuppressWarnings("deprecation")
		DisplayImageOptions options = new DisplayImageOptions.Builder().showStubImage(R.drawable.icon_stub) // 设置图片下载期间显示的图片
				.showImageForEmptyUri(R.drawable.icon_empty) // 设置图片Uri为空或是错误的时候显示的图片
				.showImageOnFail(R.drawable.icon_error) // 设置图片加载或解码过程中发生错误显示的图片
				.cacheInMemory(true) // 设置下载的图片是否缓存在内存中
				.cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
				// .displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
				.build(); // 创建配置过得DisplayImageOption对象

		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(options)
				.threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
				.discCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).build();
		ImageLoader.getInstance().init(config);		
	}

}
