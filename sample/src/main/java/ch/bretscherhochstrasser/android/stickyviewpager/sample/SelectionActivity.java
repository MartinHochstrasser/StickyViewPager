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

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SelectionActivity extends ListActivity {

	private static final String[] SELECTION = { "Classic View Pager",
			"Sticky View Pager" };

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, SELECTION));
	}

	@Override
	protected void onListItemClick(final ListView l, final View v,
			final int position, final long id) {
		switch (position) {
		case 0:
			startActivity(new Intent(this, ClassicViewPagerActivity.class));
			return;
		case 1:
			startActivity(new Intent(this, StickyViewPagerActivity.class));
		}
	};

}
