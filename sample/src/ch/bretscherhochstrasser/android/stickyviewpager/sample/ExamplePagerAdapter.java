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

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ExamplePagerAdapter extends FragmentPagerAdapter {

	private final Context context;

	public ExamplePagerAdapter(final Context context, final FragmentManager fm) {
		super(fm);
		this.context = context;
	}

	@Override
	public Fragment getItem(final int position) {
		if (position == 1) {
			return new TouchInputFragment();
		}
		final Fragment fragment = new SimpleFragment();
		final Bundle args = new Bundle();
		args.putInt(SimpleFragment.ARG_NUMBER, position);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public CharSequence getPageTitle(final int position) {
		if (position == 1) {
			return context.getString(R.string.touchInputFragmentTitle);
		} else {
			return context.getString(R.string.simpleFragmentTitle, position);
		}
	}
}