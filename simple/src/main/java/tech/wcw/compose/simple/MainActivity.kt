package tech.wcw.compose.simple

import android.Manifest
import android.content.Intent
import  androidx.compose.ui.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import tech.wcw.compose.base.BaseActivity
import tech.wcw.compose.base.Head
import tech.wcw.compose.simple.ui.theme.SimpleTheme
import tech.wcw.compose.simple.vm.MainViewModel
import tech.wcw.support.os.OnActivityResultListener
import tech.wcw.support.toast
import tech.wcw.support.utils.LogUtils


class MainActivity : BaseActivity<MainViewModel>() {
    @Preview(uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
    @Composable
    fun previewDark() {
        mViewModel = MainViewModel()
        InitView(savedInstanceState = null)
    }

    @Preview(uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO)
    @Composable
    fun previewLight() {
        mViewModel = MainViewModel()
        InitView(savedInstanceState = null)
    }

    @Composable
    fun MainView() {
        val state = rememberLazyListState()
        LaunchedEffect(key1 = true) {
            mViewModel.fetchData()
        }
        Scaffold(topBar = {
            Head(
                title = {
                    Text(
                        text = "首页", modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center)
                    )
                },
            )
        }) {
            LogUtils.i(TAG, "draw scaffold")
            LazyColumn(state = state, modifier = Modifier.fillMaxWidth()) {
                LogUtils.i(TAG, "draw LazyColumn")
                item {
                    Button(
                        onClick = {
                            runOnPermission(Manifest.permission.CAMERA) {
                                toast("获取权限成功")
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "测试权限")
                    }
                }
                item {
                    Button(
                        onClick = {
                            launcherForUri("image/*", object : OnActivityResultListener<Uri?> {
                                override fun onActivityResult(result: Uri?) {
                                    result?.let {
                                        toast(result.toString())
                                    }
                                }

                            })
                        }, modifier = Modifier.fillMaxWidth()

                    ) {
                        Text(text = "测试相册")
                    }
                }
                item {
                    Button(
                        onClick = {
                            mViewModel.fetchData()
                        }, modifier = Modifier.fillMaxWidth()

                    ) {
                        Text(text = "测试网络接口")
                    }
                }
                item {
                    Button(
                        onClick = {
                            mViewModel.clearData()
                        }, modifier = Modifier.fillMaxWidth()

                    ) {
                        Text(text = "清空接口数据")
                    }
                }
                mViewModel.errorMsg.value?.let {
                    item {
                        Text(
                            text = "${mViewModel.errorMsg.value}",
                            style = TextStyle(color = Color.Red)
                        )
                    }
                }

                items(mViewModel.newsResult.size) { index ->
                    Text(text = "${mViewModel.newsResult[index].title}")
                }

            }

        }
    }

    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        startActivity(intent)
    }


    @Composable
    override fun InitView(savedInstanceState: Bundle?) {
        SimpleTheme {
            MainView()
        }
    }


}
