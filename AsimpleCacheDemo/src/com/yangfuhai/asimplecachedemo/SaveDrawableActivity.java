package com.yangfuhai.asimplecachedemo;

import org.afinal.simplecache.ACache;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/**
 * 
 * @ClassName: SaveDrawableActivity
 * @Description: ����drawable
 * @Author Yoson Hao
 * @WebSite www.haoyuexing.cn
 * @Email haoyuexing@gmail.com
 * @Date 2013-8-8 ����10:40:47
 * 
 */
public class SaveDrawableActivity extends Activity {

	private ImageView mIv_drawable_res;

	private ACache mCache;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_save_drawable);
		// ��ʼ���ؼ�
		initView();

		mCache = ACache.get(this);
	}

	/**
	 * ��ʼ���ؼ�
	 */
	private void initView() {
		mIv_drawable_res = (ImageView) findViewById(R.id.iv_drawable_res);
	}

	/**
	 * ���save�¼�
	 * 
	 * @param v
	 */
	public void save(View v) {
		Resources res = getResources();
		Drawable drawable = res.getDrawable(R.drawable.img_test);
		mCache.put("testDrawable", drawable);
	}

	/**
	 * ���read�¼�
	 * 
	 * @param v
	 */
	public void read(View v) {
		Drawable testDrawable = mCache.getAsDrawable("testDrawable");
		if (testDrawable == null) {
			Toast.makeText(this, "Drawable cache is null ...",
					Toast.LENGTH_SHORT).show();
			mIv_drawable_res.setImageDrawable(null);
			return;
		}
		mIv_drawable_res.setImageDrawable(testDrawable);
	}

	/**
	 * ���clear�¼�
	 * 
	 * @param v
	 */
	public void clear(View v) {
		mCache.remove("testDrawable");
	}
}