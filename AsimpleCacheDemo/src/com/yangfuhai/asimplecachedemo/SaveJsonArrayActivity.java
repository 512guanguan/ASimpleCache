package com.yangfuhai.asimplecachedemo;

import org.afinal.simplecache.ACache;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

/**
 * 
 * @ClassName: SaveJsonArrayActivity
 * @Description: ����jsonarray
 * @Author Yoson Hao
 * @WebSite www.haoyuexing.cn
 * @Email haoyuexing@gmail.com
 * @Date 2013-8-8 ����1:54:19
 * 
 */
public class SaveJsonArrayActivity extends Activity {

	private TextView mTv_jsonarray_original, mTv_jsonarray_res;
	private JSONArray jsonArray;

	private ACache mCache;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_save_jsonarray);
		// ��ʼ���ؼ�
		initView();

		mCache = ACache.get(this);
		jsonArray = new JSONArray();
		JSONObject yosonJsonObject = new JSONObject();

		try {
			yosonJsonObject.put("name", "Yoson");
			yosonJsonObject.put("age", 18);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		JSONObject michaelJsonObject = new JSONObject();
		try {
			michaelJsonObject.put("name", "Michael");
			michaelJsonObject.put("age", 25);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		jsonArray.put(yosonJsonObject);
		jsonArray.put(michaelJsonObject);

		mTv_jsonarray_original.setText(jsonArray.toString());
	}

	/**
	 * ��ʼ���ؼ�
	 */
	private void initView() {
		mTv_jsonarray_original = (TextView) findViewById(R.id.tv_jsonarray_original);
		mTv_jsonarray_res = (TextView) findViewById(R.id.tv_jsonarray_res);
	}

	/**
	 * ���save�¼�
	 * 
	 * @param v
	 */
	public void save(View v) {
		mCache.put("testJsonArray", jsonArray);
	}

	/**
	 * ���read�¼�
	 * 
	 * @param v
	 */
	public void read(View v) {
		JSONArray testJsonArray = mCache.getAsJSONArray("testJsonArray");
		if (testJsonArray == null) {
			Toast.makeText(this, "JSONArray cache is null ...",
					Toast.LENGTH_SHORT).show();
			mTv_jsonarray_res.setText(null);
			return;
		}
		mTv_jsonarray_res.setText(testJsonArray.toString());
	}

	/**
	 * ���clear�¼�
	 * 
	 * @param v
	 */
	public void clear(View v) {
		mCache.remove("testJsonArray");
	}
}
