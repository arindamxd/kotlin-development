# Training (Android)

Advanced Android Developement Practise

[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=102)](https://opensource.org/licenses/Apache-2.0)
[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://github.com/arindamxd/certification-training/blob/master/LICENSE)

---

## 1. [App Link](https://developer.android.com/training/app-links)

### Handling Android App Links (Deep linking)
> Secure and specific, Seamless user experience, Android Instant Apps support, Engage users from 
Google Search


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

- https://arindamxd.github.io/main
- https://arindamxd.github.io/payment

## 2. [Kotlin](https://kotlinlang.org/) Training

### #30DaysOfKotlin

- Day 1: [Synthetics](app/src/main/java/com/arindam/android/training/kotlin/Synthetics.kt)
- Day 2: [Null-safety](app/src/main/java/com/arindam/android/training/kotlin/NullSafety.kt)
- Day 3: [`.use` Extension](app/src/main/java/com/arindam/android/training/kotlin/UseExtension.kt)
- Day 4: [Mask Credit Card Number](app/src/main/java/com/arindam/android/training/kotlin/CreditCardNumberMask.kt)
- Day 5: [Grocery Shopping](app/src/main/java/com/arindam/android/training/kotlin/GroceryShopping.kt)
- Day 6: [Immutability](app/src/main/java/com/arindam/android/training/kotlin/Immutability.kt)
- Day 7: [Partition](app/src/main/java/com/arindam/android/training/kotlin/Partition.kt)
- Day 8: [Replace Deprecated Functions](app/src/main/java/com/arindam/android/training/kotlin/ReplaceDeprecated.kt)
- Day 9: [Short and Group](app/src/main/java/com/arindam/android/training/kotlin/ShortAndGroup.kt)
- Day 10: [Tail Recursion](app/src/main/java/com/arindam/android/training/kotlin/TailRecursion.kt)
- Day 11: [Two Same Class Name](app/src/main/java/com/arindam/android/training/kotlin/SameClassName.kt)
- Day 12: [Vetoable](app/src/main/java/com/arindam/android/training/kotlin/Vetoable.kt)
- Day 13: [Serialization](app/src/main/java/com/arindam/android/training/kotlin/Serialization.kt)
- Day 14: [Sorted By Functions](app/src/main/java/com/arindam/android/training/kotlin/SortedByFunctions.kt)
- Day 15: [Sequences](app/src/main/java/com/arindam/android/training/kotlin/Sequences.kt)
- Day 16: [Time Stamp & Zones Parsing](app/src/main/java/com/arindam/android/training/kotlin/Timestamp.kt)


## 3. Dynamic & Pinned [Shortcuts](https://developer.android.com/guide/topics/ui/shortcuts)

### Handling Dynamic & Pinned Shortcuts [Package](app/src/main/java/com/arindam/android/training/shortcuts)
> Although you can publish up to five shortcuts (static and dynamic shortcuts combined) at a time 
for your app, most launchers can only display four. However, there is no limit to the number of
pinned shortcuts to your app that users can create. Even though your app cannot remove pinned
shortcuts, it can still disable them.

- Manifest: [Meta Data](app/src/main/AndroidManifest.xml#L73)
- Shortcut: [XML](app/src/main/res/xml/shortcuts.xml)
- Activities: [OldActivity](app/src/main/java/com/arindam/android/training/shortcuts/OldActivity.kt), [NewActivity](app/src/main/java/com/arindam/android/training/shortcuts/NewActivity.kt)


## 4. Activity Alias [<activity-alias>](https://developer.android.com/guide/topics/manifest/activity-alias-element)

### Understanding Activity Aliases in Android To Preserve Your Launchers
> So, in order to keep the shortcut on the home screen, even after the change in the Launcher 
Activity name, we use the concept of Activtiy-Alias.

- Manifest: `LaunchActivity` [<activity-alias>](app/src/main/AndroidManifest.xml#L63)

---

### Find this project useful ? :heart:
> Support it by clicking the :star: button on the upper right of this page. :v:

### TODO

> Add many more features and bug fixes.

### Contact - Let's become friends

- [Twitter](https://twitter.com/arindamxd)
- [Linkedin](https://in.linkedin.com/in/arindamxd)
- [GitHub](https://github.com/arindamxd)

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
