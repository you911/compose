# scaffold

#### 介绍

基于kotlin、navigation、mvvm、flow、livedata的脚手架

#### 使用教程

  1. 添加jitpack.io
```
   maven { url 'https://jitpack.io' } 
```
  2. 添加依赖
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
#### 使用说明

- Activity
    创建类Activity extends BaseActivity<VM>，重写InitView方法
- BaseViewModel
    BaseViewModel利用lifecycleObserver对组件生命周期进行观察，通过继承并重写对应生命周期，即可实现相关逻辑
- LifecycleHandler
    自动解除注册的Handler,避免因忘记解除注册导致的内存泄露
- FastDNS
    国产部分旧机型dns解析存在问题，library提供的okhttp配置了该dns解析工具。可按实际情况决定是否使用该类
- LauncherUtil
    动态换桌面图标
- NotifyUtils
    通知工具类，提供打开通知设置、通知等方法
- DeviceUtils、EventUtils，提供常用的工具方法

更多功能开发中，敬请期待
#### 参与贡献

1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request

