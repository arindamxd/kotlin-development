# Training (Android)

Advanced Android Developement Practise

[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=102)](https://opensource.org/licenses/Apache-2.0)
[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://github.com/arindamxd/certification-training/blob/master/LICENSE)

---

## 1. [App Link](https://developer.android.com/training/app-links)

### Handling Android App Links (Deep linking)
Secure and specific, Seamless user experience, Android Instant Apps support, Engage users from Google Search


#### Manifest

```xml
<intent-filter android:autoVerify="true" tools:targetApi="m">
      <action android:name="android.intent.action.VIEW" />
  
      <category android:name="android.intent.category.DEFAULT" />
      <category android:name="android.intent.category.BROWSABLE" />
  
      <data
            android:host="arindamxd.github.io"
            android:path="/main"
            android:scheme="https" />
</intent-filter>
```

#### Activity/Fragment (Java)

```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }
```

#### Activity/Fragment (Kotlin)

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      
      // ATTENTION: This was auto-generated to handle app links.
      val appLinkIntent = intent
      val appLinkAction = appLinkIntent.action
      val appLinkData = appLinkIntent.data
}
```

#### App Link URL

* https://arindamxd.github.io/main
* https://arindamxd.github.io/payment

---

### Find this project useful ? :heart:
* Support it by clicking the :star: button on the upper right of this page. :v:

### TODO

* Add many more features and bug fixes.

### Contact - Let's become friends

* [Twitter](https://twitter.com/arindamxd)
* [Linkedin](https://in.linkedin.com/in/arindamxd)
* [GitHub](https://github.com/arindamxd)

### License

```
   Copyright (C) 2019 Arindam Karmakar, Android Open Source Project

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

### Contributing to Advanced Android Training

All pull requests are welcome, make sure to follow the [contribution guidelines](CONTRIBUTING.md) when you submit pull request.
