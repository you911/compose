package tech.wcw.compose.simple

import android.app.Application
import okhttp3.logging.HttpLoggingInterceptor
import tech.wcw.compose.BuildConfig
import tech.wcw.support.net.RetrofitFactory
import tech.wcw.support.utils.LogUtils

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            LogUtils.setLevel(LogUtils.VERBOSE or LogUtils.WARN or LogUtils.DEBUG or LogUtils.INFO or LogUtils.ERROR)
        } else {
            LogUtils.setLevel(LogUtils.ERROR or LogUtils.WARN)
        }
        RetrofitFactory.getInstance().init("http://v.juhe.cn/", HttpLoggingInterceptor.Level.BASIC)
    }
}