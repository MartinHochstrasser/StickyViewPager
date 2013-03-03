/*
 * Copyright (C) 2013 Martin Hochstrasser
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.bretscherhochstrasser.android.stickyviewpager.sample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

public class DummyMapView extends View {

	private final GestureDetector gestureDetector;
	private final ScaleGestureDetector scaleGestureDetector;

	private final Drawable map;

	private float mapPosX;
	private float mapPosY;
	private float mapScale = 1f;

	public DummyMapView(final Context context) {
		this(context, null, 0);
	}

	public DummyMapView(final Context context, final AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public DummyMapView(final Context context, final AttributeSet attrs,
			final int defStyle) {
		super(context, attrs, defStyle);
		map = context.getResources().getDrawable(R.drawable.map_image);
		gestureDetector = new GestureDetector(context, new ScrollListener());
		scaleGestureDetector = new ScaleGestureDetector(context,
				new ScaleListener());
		final ViewTreeObserver viewTreeObserver = getViewTreeObserver();
		if (viewTreeObserver.isAlive()) {
			viewTreeObserver
					.addOnGlobalLayoutListener(new FirstLayoutDoneListener());
		}
	}

	private void initMapBounds() {
		final int x = (getWidth() - map.getIntrinsicWidth()) / 2;
		final int y = (getHeight() - map.getIntrinsicHeight()) / 2;
		map.setBounds(x, y, map.getIntrinsicWidth(), map.getIntrinsicHeight());
	}

	@Override
	public boolean onTouchEvent(final MotionEvent event) {
		return gestureDetector.onTouchEvent(event)
				| scaleGestureDetector.onTouchEvent(event);
	}

	@Override
	public void onDraw(final Canvas canvas) {
		super.onDraw(canvas);
		canvas.save();
		canvas.translate(mapPosX, mapPosY);
		canvas.scale(mapScale, mapScale);
		map.draw(canvas);
		canvas.restore();
	}

	private class ScrollListener extends
			GestureDetector.SimpleOnGestureListener {
		@Override
		public boolean onScroll(final MotionEvent e1, final MotionEvent e2,
				final float distanceX, final float distanceY) {
			mapPosX -= distanceX;
			mapPosY -= distanceY;
			invalidate();
			return true;
		}
	}

	private class ScaleListener extends
			ScaleGestureDetector.SimpleOnScaleGestureListener {
		@Override
		public boolean onScale(final ScaleGestureDetector detector) {
			mapScale *= detector.getScaleFactor();
			// limit scaling
			mapScale = Math.max(0.1f, Math.min(mapScale, 4f));
			invalidate();
			return true;
		}
	}

	private class FirstLayoutDoneListener implements OnGlobalLayoutListener {
		@SuppressWarnings("deprecation")
		@SuppressLint("NewApi")
		@Override
		public void onGlobalLayout() {
			getViewTreeObserver().removeGlobalOnLayoutListener(this);
			initMapBounds();
		}
	}
}
