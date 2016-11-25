![Mobile Jazz Vastra](https://raw.githubusercontent.com/mobilejazz/metadata/master/images/banners/mobile-jazz-knockknock-android.jpg)

KnockKnock
==========

It's a library that check if there is an internet connection and which type of connection is available in a funny way.

## How To Get KnockKnock

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://oss.sonatype.org/content/repositories/snapshots' }
	}
}
```

Add KnockKnock dependency to your `build.gradle` file (in your module)

```xml
dependencies {
  compile 'com.mobilejazz.knockknock:library:0.9-SNAPSHOT'
}
```

## Using KnockKnock

*For a working implementation of this project see the `sample/` folder.*

### Initializing the library

You must initialize the library passing the application context.

```java
Knock.knock().initialize(this);
```

### Check reachability

You can check reachability at any time by retreiving the shared object and calling the methods `areYouThere()` or `whosThere(Knock.Actor)` passing the desired reachability


```java
boolean areYouThere = Knock.knock().areYouThere(); // Check if there is internet connection

boolean areYouThereWifi = Knock.knock().whosThere(Knock.Actor.WIFI); // Check if there is internet connection and the connection is Wifi

boolean areYouThereCellular = Knock.knock().whosThere(Knock.Actor.CELLULAR); // Check if there is internet connection and the connection is Cellular

```

## Project Maintainer

This open source project is maintained by [Jose Luis Franconetti](https://github.com/joselufo).

## License

    Copyright 2016 Mobile Jazz

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
