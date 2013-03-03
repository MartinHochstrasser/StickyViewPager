StickyViewPager Android Library
-------------------------------

StickyViewPager is an Android library project that contains a simple subclass of the android.support.v4.view.ViewPager.

The normal ViewPager implementation causes trouble with views that require touch event input to scroll horizontally (e.g. a map fragment).
Instead of allowing the scroll input, the normal ViewPager initiates a swipe gesture to navigate to another view.

The StickyViewPager can solve this problem by overriding the ViewPager's default touch input detection on pager positions that have been marked as "sticky".
A navigation swipe gesture is only initiated if the user begins the swipe within a certain margin of the pagers inner edge.

View positions that are not declared "sticky" will still be handled by ViewPagers's default gesture handling.


## Usage

### 1. Add StickyViewPager to your project:

Download the source and add the project in the _library_ directory as an Android library project.

### 2. Use the StickyViewPager in your XML layout.

Example:
```xml
<ch.bretscherhochstrasser.android.stickyviewpager.StickyViewPager xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:stickyviewpager="http://schemas.android.com/apk/res-auto"
    android:id="@+id/pager"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    stickyviewpager:stickyPositions="1"
    stickyviewpager:swipeMarginWidth="50dp"
    tools:context=".AbstractViewPagerActivity" >

</ch.bretscherhochstrasser.android.stickyviewpager.StickyViewPager>
```
*Do not forget to add the XML namespace http://schemas.android.com/apk/res-auto. Otherwise the Android SDK will not recognize the StickyViewPager's custom attributes.*

### 3. Configure it:
Set the sticky positions:
```xml
stickyviewpager:stickyPositions="3"
```
You can declare multiple positions separated by comma:
```xml
stickyviewpager:stickyPositions="1,4,5"
```
Set the with of the swipe margin (the margin on the left and right that allows the initiation of a swipe gesture for the pager). 
```xml
stickyviewpager:swipeMarginWidth="50dp"
```
The value is optional. The default is 40dip.


## Sample Project
You can find a sample project demonstrating the StickyViewPager under the _sample_ directory.


## License
The library is provided under the Apache 2.0 License. See _LICENSE_ file for details.
```
 Copyright (C) 2013 Martin Hochstrasser
 
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 
    http://www.apache.org/licenses/LICENSE-2.0
 
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
```



