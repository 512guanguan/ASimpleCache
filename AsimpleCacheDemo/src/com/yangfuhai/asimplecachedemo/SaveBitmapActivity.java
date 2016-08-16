package com.yangfuhai.asimplecachedemo;

import org.afinal.simplecache.ACache;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 
 * @ClassName: SaveBitmapActivity
 * @Description: ����bitmap
 * @Author Yoson Hao
 * @WebSite www.haoyuexing.cn
 * @Email haoyuexing@gmail.com
 * @Date 2013-8-7 ����5:20:37
 * 
 */
public class SaveBitmapActivity extends Activity {

	private ImageView mIv_bitmap_res;

	private ACache mCache;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_save_bitmap);
		// ��ʼ���ؼ�
		initView();

		mCache = ACache.get(this);
	}

	/**
	 * ��ʼ���ؼ�
	 */
	private void initView() {
		mIv_bitmap_res = (ImageView) findViewById(R.id.iv_bitmap_res);
	}

	/**
	 * ���save�¼�
	 * 
	 * @param v
	 */
	public void save(View v) {
		Resources res = getResources();
		Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.img_test);
		mCache.put("testBitmap", bitmap);
	}

	/**
	 * ���read�¼�
	 * 
	 * @param v
	 */
	public void read(View v) {
		Bitmap testBitmap = mCache.getAsBitmap("testBitmap");
		if (testBitmap == null) {
			Toast.makeText(this, "Bitmap cache is null ...", Toast.LENGTH_SHORT)
					.show();
			mIv_bitmap_res.setImageBitmap(null);
			return;
		}
		mIv_bitmap_res.setImageBitmap(testBitmap);
	}

	/**
	 * ���clear�¼�
	 * 
	 * @param v
	 */
	public void clear(View v) {
		mCache.remove("testBitmap");
	}
}
