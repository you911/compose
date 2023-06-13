package tech.wcw.compose.base

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import tech.wcw.support.os.OnActivityResultListener
import java.lang.reflect.ParameterizedType

/**
 * @Author: tech_wcw
 * @Eamil tech_wcw@163.com
 * @Data: 2021/2/3 18:41
 * @Description:
 */
abstract class BaseFragment<VM : BaseViewModel> : Fragment() {
    lateinit var mViewModel: VM
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = LayoutInflater.from(requireContext()).inflate(layoutId(), null, false)
        mViewModel = initViewModel()
        mViewModel.injectLifecycle(viewLifecycleOwner)

        initView(savedInstanceState)
        initData()
        return view
    }

    fun requestPermission(permission: String, callBack: OnActivityResultListener<Boolean>) {
        val requireActivity = requireActivity() as BaseActivity<*>
        requireActivity.launcherForPermission(permission, callBack)
    }

    fun launcherForUri(type: String, callBack: OnActivityResultListener<Uri?>) {
        val requireActivity = requireActivity() as BaseActivity<*>
        requireActivity.launcherForUri(type, callBack)
    }

    fun launcher(intent: Intent, callBack: OnActivityResultListener<ActivityResult>) {
        val requireActivity = requireActivity() as BaseActivity<*>
        requireActivity.launcher(intent, callBack)
    }

    fun launcherForCamera(uri: Uri, callBack: OnActivityResultListener<ActivityResult>) {
        val requireActivity = requireActivity() as BaseActivity<*>
        requireActivity.launcherForCamera(uri, callBack)
    }

    abstract fun layoutId(): Int

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun initData()

    open fun initViewModel(): VM {
        val type = javaClass.genericSuperclass
        mViewModel = if (type is ParameterizedType) {
            ViewModelProvider(
                this
            )[type.actualTypeArguments[0] as Class<VM>]
        } else {
            ViewModelProvider(
                this
            )[BaseViewModel::class.java as Class<VM>]
        }
        return mViewModel;
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}