package xt.candy.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @描述: listView对应的adapter基类
 * @更新描述:
 */
public abstract class HxtListAdapter<T> extends BaseAdapter {
	protected List<T> mDatas;


	public List<T> getDatas() {
		if(null == mDatas){
			return new ArrayList<>();
		}
		return mDatas;
	}


	public HxtListAdapter(List<T> datas) {
		this.mDatas = datas;
	}

	public void deleteList(){};
	public void setmCurrentState(int mcurrentState){}

	@Override
	public int getCount()
	{
		if (mDatas != null) { return mDatas.size(); }
		return 0;
	}

	public void upDateList( List<T> list,boolean isRefresh){
		if(list == null){
			return;
		}
		if(mDatas == null){
			mDatas = new ArrayList<T>();
		}

		if(isRefresh){
			mDatas.clear();
			mDatas.addAll(list);
		}else {
			mDatas.addAll(list);
		}
		notifyDataSetChanged();

	}
	@Override
	public Object getItem(int position)
	{
		if (mDatas != null) { return mDatas.get(position); }
		return null;
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		HxtListHolder holder = null;
		if (convertView == null)
		{
			// 没有复用

			// 1. holder初始化
			holder = getHolder(parent);

			// 2. 加载View
			convertView = holder.getRootView();
		}
		else
		{
			// 有复用
			holder = (HxtListHolder) convertView.getTag();
		}

		// 设置数据,给View铺数据
		holder.setData(mDatas.get(position),position);

		return convertView;
	}


	protected abstract HxtListHolder<T> getHolder(ViewGroup parent);

}
