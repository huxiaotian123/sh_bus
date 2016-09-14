package xt.candy.base;


import android.view.View;

/**
 * @描述: MVC中C，用来控制视图和数据，对视图和数据进行合理的显示
 */
public abstract class HxtListHolder<T>
{
	protected View mRootView;
	protected T		mData;

	public HxtListHolder() {
		mRootView = initView();

		// 打标记
		mRootView.setTag(this);
	}

	protected abstract View initView();

	protected abstract void refreshUI(T data, int postion);

	public void setData(T data,int postion)
	{
		this.mData = data;

		// UI刷新
		refreshUI(mData,postion);
	}

	public View getRootView()
	{
		return mRootView;
	}
}
