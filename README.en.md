# scaffold

#### Introduce

Scaffolding based on kotlin, navigation, mvvm, flow, livedata

#### Using Tutorials

  1. Add jitpack.io
```
   maven { url 'https://jitpack.io' } 
```
  2. Add Dependency
```
   dependencies {
            implementation 'com.github.you911:compose:Tag'
    }
```
     配置compose
```
        android{
          ...
          buildFeatures{
            compose = true
          }
		}
```
#### How To Use

- Activity
   Create class Activity extensions BaseActivity<VM, DB>, override methods, and implement layout files
- BaseViewModel
   BaseViewModel utilizes lifecycleObserver to observe the component lifecycle, and by inheriting and rewriting the corresponding lifecycle, relevant logic can be implemented
- LifecycleHandler
   Handlers that automatically unregister to avoid memory leaks caused by forgetting to unregister
- FastDNS
   There are issues with DNS parsing for some old domestic models, and the okhttp provided by the library is configured with this DNS parsing tool. It can be decided whether to use this type according to the actual situation
- LauncherUtil
   Dynamically changing desktop icons
- NotifyUtils
   Notification tool class, providing methods such as opening notification settings and notifications
- DeviceUtils、EventUtils，Provide commonly used tools and methods

More features in development, please stay tuned
#### Participation contribution

1. Fork
2. New Feat_ Xxx branch
3. Submit Code
4. New Pull Request

