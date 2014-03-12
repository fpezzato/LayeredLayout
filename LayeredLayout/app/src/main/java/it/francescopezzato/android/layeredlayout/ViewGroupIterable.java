package it.francescopezzato.android.layeredlayout;

import android.view.View;
import android.view.ViewGroup;

import java.util.Iterator;

/**
 * Created by pablisco on 14/01/2014.
 */
public class ViewGroupIterable implements Iterable<View> {

	private ViewGroup mViewGroup;

	private ViewGroupIterable(ViewGroup mViewGroup) {
		this.mViewGroup = mViewGroup;
	}

	public static final Iterable<View> iterate(ViewGroup viewGroup) {
		return new ViewGroupIterable(viewGroup);
	}

	@Override
	public Iterator<View> iterator() {
		return new Iterator<View>() {

			int i = 0;
			int n = mViewGroup.getChildCount();

			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public View next() {
				View result = mViewGroup.getChildAt(i);
				remove();
				return result;
			}

			@Override
			public void remove() {
				i++;
			}
		};
	}
}