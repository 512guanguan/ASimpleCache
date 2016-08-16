package com.yangfuhai.asimplecachedemo;

import org.afinal.simplecache.ACache;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @ClassName: SaveStringActivity
 * @Description: ����string
 * @Author Yoson Hao
 * @WebSite www.haoyuexing.cn
 * @Email haoyuexing@gmail.com
 * @Date 2013-8-7 ����9:59:43
 * 
 */
public class SaveStringActivity extends Activity {

	private EditText mEt_string_input;
	private TextView mTv_string_res;

	private ACache mCache;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_save_string);
		// ��ʼ���ؼ�
		initView();

		mCache = ACache.get(this);
	}

	/**
	 * ��ʼ���ؼ�
	 */
	private void initView() {
		mEt_string_input = (EditText) findViewById(R.id.et_string_input);
		mTv_string_res = (TextView) findViewById(R.id.tv_string_res);
	}

	/**
	 * ���save�¼�
	 * 
	 * @param v
	 */
	public void save(View v) {
		if (mEt_string_input.getText().toString().trim().length() == 0) {
			Toast.makeText(
					this,
					"Cuz u input is a nullcharacter ... So , when u press \"read\" , if do not show any result , plz don't be surprise",
					Toast.LENGTH_SHORT).show();
		}
		mCache.put("testString", mEt_string_input.getText().toString());
	}

	/**
	 * ���read�¼�
	 * 
	 * @param v
	 */
	public void read(View v) {
		String testString = mCache.getAsString("testString");
		if (testString == null) {
			Toast.makeText(this, "String cache is null ...", Toast.LENGTH_SHORT)
					.show();
			mTv_string_res.setText(null);
			return;
		}
		mTv_string_res.setText(testString);
	}

	/**
	 * ���clear�¼�
	 * 
	 * @param v
	 */
	public void clear(View v) {
		mCache.remove("testString");
	}

}
