package it.francescopezzato.android.layeredlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by francescopezzato on 12/03/2014.
 */
public class LayeredLayout extends ViewGroup {

	private int mOffset;

	public LayeredLayout(Context context) {
		super(context);
	}

	public LayeredLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public LayeredLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {

		for (View child : ViewGroupIterable.iterate(this)) {
			child.layout(0,0,child.getMeasuredWidth(),child.getMeasuredHeight());
		}
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		measureChildren(widthMeasureSpec, heightMeasureSpec);

		int maxWidth = 30;
		int maxHeight = 30;

		setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, 0),
				resolveSizeAndState(maxHeight, heightMeasureSpec, 0));

	}

	public void setOffset(int offset) {
		this.mOffset = offset;
		//this.invalidate();
		if(offset!=mOffset)
		requestLayout();
	}
}
