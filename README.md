# Kotlin Everywhere

Kotlin Development Practises (Android)

[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=102)](https://opensource.org/licenses/Apache-2.0)
[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](LICENSE)

---

## 1. App [Link ↗](https://developer.android.com/training/app-links)

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



## 2. [Kotlin](https://kotlinlang.org/) Training [↗](https://kotlinlang.org/)

### #30DaysOfKotlin

- Day 1: [Synthetics](app/src/main/java/com/arindam/kotlin/x/Synthetics.kt)
- Day 2: [Null-safety](app/src/main/java/com/arindam/kotlin/x/NullSafety.kt)
- Day 3: [Null-check](app/src/main/java/com/arindam/kotlin/x/NullCheck.kt)
- Day 4: [Sealed Class](app/src/main/java/com/arindam/kotlin/x/SealedClass.kt) [↗](https://github.com/Kotlin/KEEP/blob/master/proposals/sealed-class-inheritance.md#open-questions)
- Day 5: [`.use` Extension](app/src/main/java/com/arindam/kotlin/x/UseExtension.kt)
- Day 6: [Mask Credit Card Number](app/src/main/java/com/arindam/kotlin/x/CreditCardNumberMask.kt)
- Day 7: [Grocery Shopping](app/src/main/java/com/arindam/kotlin/x/GroceryShopping.kt)
- Day 8: [Immutability](app/src/main/java/com/arindam/kotlin/x/Immutability.kt)
- Day 9: [Partition](app/src/main/java/com/arindam/kotlin/x/Partition.kt)
- Day 10: [Replace Deprecated Functions](app/src/main/java/com/arindam/kotlin/x/ReplaceDeprecated.kt)
- Day 11: [Short and Group](app/src/main/java/com/arindam/kotlin/x/ShortAndGroup.kt)
- Day 12: [Tail Recursion](app/src/main/java/com/arindam/kotlin/x/TailRecursion.kt)
- Day 13: [Two Same Class Name](app/src/main/java/com/arindam/kotlin/x/SameClassName.kt)
- Day 14: [Vetoable](app/src/main/java/com/arindam/kotlin/x/Vetoable.kt)
- Day 15: [Serialization](app/src/main/java/com/arindam/kotlin/x/Serialization.kt)
- Day 16: [Sorted By Functions](app/src/main/java/com/arindam/kotlin/x/SortedByFunctions.kt)
- Day 17: [Sequences](app/src/main/java/com/arindam/kotlin/x/Sequences.kt)
- Day 18: [Time Stamp & Zones Parsing](app/src/main/java/com/arindam/kotlin/x/Timestamp.kt)
- Day 19: [Delegation over Inheritance](app/src/main/java/com/arindam/kotlin/x/Delegation.kt)
- Day 20: [Infix Function](app/src/main/java/com/arindam/kotlin/x/InfixFunction.kt)
- Day 21: [Kotlin-Java Inter Operation](app/src/main/java/com/arindam/kotlin/x/interop/Vacation.java)
- Day 22: [Destructuring Declarations](app/src/main/java/com/arindam/kotlin/x/Destructuring.kt)
- Day 23: [Operator Overloading](app/src/main/java/com/arindam/kotlin/x/OperatorOverloading.kt)
- Day 24: [Jvm Static](app/src/main/java/com/arindam/kotlin/x/jvmstatic/JvmStatic.java)
- Day 25: [Spread](app/src/main/java/com/arindam/kotlin/x/Spread.kt)



## 3. Dynamic & Pinned [Shortcuts ↗](https://developer.android.com/guide/topics/ui/shortcuts)

### Handling Dynamic & Pinned Shortcuts [(Package)](app/src/main/java/com/arindam/kotlin/shortcuts)
> Although you can publish up to five shortcuts (static and dynamic shortcuts combined) at a time 
for your app, most launchers can only display four. However, there is no limit to the number of
pinned shortcuts to your app that users can create. Even though your app cannot remove pinned
shortcuts, it can still disable them.

<img src="/documentation/shortcuts/1.png" width="25%"> <img src="/documentation/shortcuts/2.png" width="25%">

- Manifest: [Meta Data](app/src/main/AndroidManifest.xml#L79)
- Shortcut: [XML](app/src/main/res/xml/shortcuts.xml)
- Activities: [OldActivity](app/src/main/java/com/arindam/kotlin/shortcuts/OldActivity.kt), [NewActivity](app/src/main/java/com/arindam/kotlin/shortcuts/NewActivity.kt)



## 4. Activity Alias [Element ↗](https://developer.android.com/guide/topics/manifest/activity-alias-element)

### Understanding Activity Aliases in Android To Preserve Your Launchers
> So, in order to keep the shortcut on the home screen, even after the change in the Launcher 
Activity name, we use the concept of Activtiy-Alias.

- Manifest: [\<activity-alias\>](app/src/main/AndroidManifest.xml#L69&L80) `LaunchActivity`



## 5. Material [Dark Theme ↗](https://material.io/develop/android/theming/dark/)

### Implementing Dark Mode Theme in Android
> Some of the most common benefits of a dark theme include conserving battery power for devices 
with OLED screens, reducing eye strain, and facilitating use in low-light environments. Starting 
with Android Q, users are now able to switch their device into dark theme via a new system 
setting, which applies to both the Android system UI and apps running on the device.

<img src="/documentation/darkmode/1.png" width="25%"> <img src="/documentation/darkmode/2.png" width="25%">

- Helper: [ThemeHelper](app/src/main/java/com/arindam/kotlin/daynight/ThemeHelper.kt)
- Activity: [DayNightActivity](app/src/main/java/com/arindam/kotlin/daynight/DayNightActivity.kt)



## 6. [Coroutine Image Loader](https://coil-kt.github.io/coil/) (COIL) [↗](https://coil-kt.github.io/coil/)

### An image loading library for Android backed by Kotlin Coroutines.

- **Fast**: Coil performs a number of optimizations including memory and disk caching, downsampling the image in memory, re-using Bitmaps, automatically pausing/cancelling requests, and more.
- **Lightweight**: Coil adds ~1500 methods to your APK (for apps that already use OkHttp and Coroutines), which is comparable to Picasso and significantly less than Glide and Fresco.
- **Easy to use**: Coil's API leverages Kotlin's language features for simplicity and minimal boilerplate.
- **Modern**: Coil is Kotlin-first and uses modern libraries including Coroutines, OkHttp, Okio, and AndroidX Lifecycles.

<img src="/documentation/coil/1.png" width="25%"> <img src="/documentation/coil/2.png" width="25%"> <img src="/documentation/coil/3.png" width="25%">

- Activity: [CoilActivity](app/src/main/java/com/arindam/kotlin/coil/CoilActivity.kt)



## 7. The [Bubble API](https://developer.android.com/preview/features/bubbles) (Android Q Preview) [↗](https://developer.android.com/preview/features/bubbles)

### Bubbles are a new preview feature in Android Q, which let users easily multi-task from anywhere on their device.
> **Note**: Bubbles are currently enabled for all users in the Q developer previews. 
In the final release, Bubbles will be available for developer use only.

- Bubbles take up screen real estate and cover other app content. You should only send a notification as a bubble if it is important enough such as ongoing communications, or if the user has explicitly requested a bubble for some content.
- Note that the bubble can be disabled by the user. In that case, a bubble notification is shown as a normal notification. You should always make sure your bubble notification works as a normal notification as well.
- Processes that are launched from a bubble (such as activities and dialogs) appear within the bubble container. This means a bubble can have a task stack. Things can get complicated if there is a lot of functionality or navigation within your bubble. We recommend keeping the functionality as specific and light-weight as possible.

<img src="/documentation/bubble/1.png" width="25%"> <img src="/documentation/bubble/2.png" width="25%"> <img src="/documentation/bubble/3.png" width="25%">

- Manifest: [\<activity\>](app/src/main/AndroidManifest.xml#L92&L98)
- Activity: [BubbleActivity](app/src/main/java/com/arindam/kotlin/bubble/BubbleActivity.kt)



## 7. Caching with RxJava Operators [↗](https://blog.mindorks.com/implement-caching-in-android-using-rxjava-operators)

### Implement Caching in Android using RxJava Operators
> First, we need to understand why caching is useful? Caching is very useful in the following situations:

- **Reduce network calls**: We can reduce the network calls by caching the network response.
- **Fetch the data very fast**: We can fetch the data very fast if it is cached.

- Activity: 

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
