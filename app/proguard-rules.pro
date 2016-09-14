#指定代码的压缩级别
-optimizationpasses 7

#包明不混合大小写
-dontusemixedcaseclassnames

#不去忽略非公共的库类
-dontskipnonpubliclibraryclasses

#优化  不优化输入的类文件
-dontoptimize

#不去预校验
-dontpreverify

#混淆时是否记录日志
-verbose

# 混淆时所采用的算法
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

#保护注解
-keepattributes *Annotation*
-keepattributes Signature

#忽略警告
-ignorewarning
-ignorewarnings
-dontwarn

-dontwarn android.support.**

#混淆时应用侵入式重载
-overloadaggressively

#确定统一的混淆类的成员名称来增加混淆
-useuniqueclassmembernames

#记录生成的日志数据,gradle build时在本项目根目录输出
#apk 包内所有 class 的内部结构
-dump class_files.txt
#未混淆的类和成员
-printseeds seeds.txt
#列出从 apk 中删除的代码
-printusage unused.txt
#混淆前后的映射
-printmapping mapping.txt



# 组件并没有混淆，因为系统需要通过清单(AndroidManifest.xml)文件来查找和运行应用程序。

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Application
-keep public class * extends android.support.multidex.MultiDexApplication
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class com.android.vending.licensing.ILicensingService
-keep class android.support.** {*;}
-keep public class * extends android.support.**
-keep public class * extends android.view.View {*;}

#保留R文件
-keep class **.R$* {*;}


##排除基本的包
-dontwarn android.**
-keep class android.** { *; }

# java
-dontwarn javax.naming.**
-dontwarn java.lang.invoke**
-dontwarn java.nio.file.Files
-dontwarn java.nio.file.Path
-dontwarn java.nio.file.OpenOption
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement



#这个主要是在layout 中写的onclick方法android:onclick="onClick"，不进行混淆
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}



#枚举
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

#// natvie 方法不混淆
-keepclasseswithmembernames class * {
    native <methods>;
}

#保持 Parcelable 不被混淆
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

#保持 Serializable 不被混淆
-keep public class * implements java.io.Serializable {*;}

-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# support-v4
-dontwarn android.support.v4.**
-keep class android.support.v4.** { *; }
-keep interface android.support.v4.app.** { *; }
-keep public class * extends android.support.v4.**
-keep public class * extends android.app.Fragment

# support-v7
-dontwarn android.support.v7.**
-keep class android.support.v7.internal.** { *; }
-keep interface android.support.v7.internal.** { *; }
-keep class android.support.v7.** { *; }

# nineoldandroids
-keep class com.nineoldandroids.** {*; }
-dontwarn com.nineoldandroids.**

# support design
#@link http://stackoverflow.com/a/31028536
-dontwarn android.support.design.**
-keep class android.support.design.** { *; }
-keep interface android.support.design.** { *; }
-keep public class android.support.design.R$* { *; }


####################################################################################################
####################################################################################################
####   上面是所有混淆基本模板    ######
#--------------------------------------------------------------------------------------------------#
####   下面是项目自定义混淆      ######
####################################################################################################
####################################################################################################









#gson  + 项目中的model
-keep class com.google.gson.** {*;}
-keep class com.google.**{*;}
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }
-keep class xt.candy.model.** { *;}
-dontnote com.google.**
-dontwarn com.google.**
-keep class com.google.** {*;}

##butterknife
-dontwarn butterknife.internal.**
-keep class butterknife.** { *; }
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

## TSnackbar
-dontwarn com.androidadvance.topsnackbar.**
-keep class com.androidadvance.topsnackbar.{*;}

## okhttp
-dontwarn com.squareup.okhttp.**
-keep class com.squareup.okhttp.{*;}

#okhttputils
-dontwarn com.zhy.http.**
-keep class com.zhy.http.**{*;}


#okhttp
-dontwarn okhttp3.**
-keep class okhttp3.**{*;}

#okio
-dontwarn okio.**
-keep class okio.**{*;}

#baidu
-keep class com.baidu.** {*;}
-keep class vi.com.** {*;}
-dontwarn com.baidu.**

#tencent
-keep class bin.**{*;}
-keep class test.com.**{*;}
-keep class test-gen.com.**{*;}
-keep class com.tencent.**{*;}

#imageloder
-keep class com.nostra13.universalimageloader.**{*;}

#eventbus
-keep class de.greenrobot.event.** {*;}
-keepclassmembers class ** {
    public void onEvent*(**);
    void onEvent*(**);
}
-keepclassmembers class * {
    void *(*Event);
}




#-dontwarn com.mikepenz.**
#-dontwarn com.android.volley.**
#-dontwarn com.rey.**
#-dontwarn com.testin.**
#-dontwarn jp.wasabeef.**

#webkit
-dontnote android.webkit.**
-dontwarn android.webkit.**
-keep class android.webkit.** {*;}

#高德地图
-dontwarn com.amap.**
-dontnote com.amap.api.**
-dontwarn com.amap.api.**
-keep class com.amap.api.** {*;}
-dontnote com.autonavi.**
-dontwarn com.autonavi.**
-keep class com.autonavi.** {*;}
-dontnote com.aps.**
-dontwarn com.aps.**
-keep class com.aps.** {*;}


##apache
#-dontnote org.apache.**
#-dontwarn org.apache.**
#-keep class org.apache.** {*;}

#易信
-dontnote org.jivesoftware.**
-dontwarn org.jivesoftware.**
-keep class org.jivesoftware.** {*;}
-dontnote de.measite.smack.**
-dontwarn de.measite.smack.**
-keep class de.measite.smack.** {*;}
-dontnote novell.sasl.client.**
-dontwarn novell.sasl.client.**
-keep class novell.sasl.client.** {*;}
-dontnote org.xbill.DNS.**
-dontwarn org.xbill.DNS.**
-keep class org.xbill.DNS.** {*;}

#sharesdk
-dontnote cn.sharesdk.**
-dontwarn cn.sharesdk.**
-keep class cn.sharesdk.** {*;}
-dontnote m.framework.**
-dontwarn m.framework.**
-keep class m.framework.** {*;}
-dontnote com.sina.**
-dontwarn com.sina.**
-keep class com.sina.** {*;}

#MultipleTextView
-keep class com.zhy.** {*;}
-dontnote com.zhy.**
-dontwarn com.zhy.**

# LeakCanary
-dontnote org.eclipse.mat.**
-dontwarn org.eclipse.mat.**
-keep class org.eclipse.mat.** { *; }
-dontnote com.squareup.leakcanary.**
-dontwarn com.squareup.leakcanary.**
-keep class com.squareup.leakcanary.** { *; }
-dontwarn com.larvalabs.svgandroid.**

# greendao
-keepclassmembers class * extends org.greenrobot.greendao.AbstractDao {
public static java.lang.String TABLENAME;
}
-keep class **$Properties

#// If you do not use SQLCipher:
-dontwarn org.greenrobot.greendao.database.**
#// If you do not use Rx:
-dontwarn org.greenrobot.greendao.rx.**

#loadingveiw
-keep class com.wang.avi.** { *; }
-keep class com.wang.avi.indicators.** { *; }