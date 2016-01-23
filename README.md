AspectRatioImageView
===

ImageView which keep it's aspect ratio; height / width.

Usage
---

XML:
```xml
<team.birdhead.widget.AspectRatioImageView
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="#ff0000"
    app:aspectRatio="0.5"
    app:fixed="width"/>        <!-- height = width * 0.5 -->
<team.birdhead.widget.AspectRatioImageView
    android:layout_width="wrap_content"
    android:layout_height="100dp"
    android:background="#00ff00"
    app:aspectRatio="2"
    app:fixed="height"/>       <!-- width = height / 2-->
<team.birdhead.widget.AspectRatioImageView
    android:layout_width="match_parent"
    android:layout_height="100dp"
    android:background="#0000ff"
    app:aspectRatio="0"/>     <!-- if aspectRatio <= 0 do not keep aspect ratio -->
```

Java:
```java
AspectRatioImageView imageView;
imageView.setAspectRatio(0.5);
imageView.setFixed(AspectRatioImageView.FIXED_WIDTH);
```

Download
---
Gradle:
```groovy
repositories {
    maven { url 'http://team-birdhead.github.io/maven' }
}

dependencies {
    compile 'team.birdhead.aspectratioimageview:aspectratioimageview:1.0.0'
}
```

License
---
    Copyright 2016 alzybaad

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
