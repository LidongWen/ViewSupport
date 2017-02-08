# 自定义View 支持库

该开源库的主要作用就是简化自定义View过程中的一些流程，让自定义View更简单，更方便，更高效。
- 继承 CustomView 以自动获取 View 大小以及默认画笔。
- 使用 CanvasAidUtils 绘制当前坐标系以检查绘制的位置。
- 使用 MathUtils 方便的进行角度弧度转换，计算距离。
- 使用 DensityUtils 方便px sp等像素值之间的相互转化。

## 引用
```groovy
// 项目引用
dependencies {
    compile ''
}

// 根目录下引用
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.1.0'
        classpath 'com.github.dcendents:android-maven-gradle-plugin:1.5'
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        jcenter()
        maven { url "https://www.jitpack.io" }
    }
}
```

#Contact me

E-mail:wenld2014@163.com

blog: [wenld's blog](http://blog.csdn.net/sinat_15877283)
