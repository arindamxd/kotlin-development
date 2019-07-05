# Training (Android)
Google Associate Android Developer Certification Exam Practise

[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=102)](https://opensource.org/licenses/Apache-2.0)
[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://github.com/arindamxd/certification-training/blob/master/LICENSE)

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
#### Activity/Fragment
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
