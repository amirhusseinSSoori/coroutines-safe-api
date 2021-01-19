package com.amirhusseinsoori.template.ui

import android.annotation.SuppressLint
import android.graphics.Color
import  android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.amirhusseinsoori.template.R
import kotlinx.android.synthetic.main.main_fragment.*

import java.util.*


open class MainFragment(@LayoutRes val contentLayoutId: Int) :Fragment() {

    private val TAG_MAIN_FRAGMENT = "MainFragment"
    @LayoutRes
    private var mContentLayoutId = 0
    private var timer: Timer? = null
    private var callback: OnBackPressedCallback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContentLayoutId = contentLayoutId
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (mContentLayoutId != 0) layout_stub.layoutResource = mContentLayoutId
        layout_stub.inflate()


    }

    protected fun showLoading(isDim: Boolean = false){
        if (isDim){
            card_myF_loading.setBackgroundColor(Color.parseColor("#cc000000"))
        }
        card_myF_loading.visibility = View.VISIBLE
    }

    protected fun hideLoading(){
        card_myF_loading.visibility = View.GONE
    }

    protected fun toastNet(text: String = "لطفا از وضعیت اینترنت خود مطمعن شوید") {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    protected fun toastError(text: String = "مشکلی رخ داده لطفا مجددا تلاش نمایید") {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    protected fun toasty(text: String){
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    fun timery(delay: Long ,call: () -> Unit): Timer {
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                Handler(Looper.getMainLooper()).post {
                    call.invoke()
                }
            }
        }, delay)
        return timer!!
    }



    fun onMyBackPressed(owner: LifecycleOwner ,call: () -> Unit) {

        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                call.invoke()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(owner, callback!!)
    }
     @SuppressLint("ResourceAsColor")
     fun showToast(titleToast: String, selectToast: Int? = null) {
        val layout = layoutInflater.inflate(R.layout.toast_layout, requireView().findViewById(R.id.toast_root))
        when (selectToast) {

            1 -> {
                //correct
                layout.findViewById<ImageView>(R.id.toast_img).setImageResource(R.drawable.ic_corroct_toast)
                layout.findViewById<ConstraintLayout>(R.id.toast_root).setBackgroundResource(R.drawable.bg_corroct_toast)
            }
            2 -> {
                //Warning
                layout.findViewById<ImageView>(R.id.toast_img).setImageResource(R.drawable.ic_warning_toast)
                layout.findViewById<ConstraintLayout>(R.id.toast_root).setBackgroundResource(R.drawable.bg_warning_toast)
                layout.findViewById<TextView>(R.id.toast_txt).setTextColor(R.color.black)
            }
            3 -> {
                //Error
                layout.findViewById<ImageView>(R.id.toast_img).setImageResource(R.drawable.ic_error_toast)
                layout.findViewById<ConstraintLayout>(R.id.toast_root).setBackgroundResource(R.drawable.bg_error_toast)
            }
            else -> {
                //AnyNumber
                Toast.makeText(requireContext(), titleToast, Toast.LENGTH_LONG).show()
            }

        }

        layout.findViewById<TextView>(R.id.toast_txt).text = titleToast
        if(selectToast!=null){
            Toast(requireActivity()).apply {
                setGravity(Gravity.BOTTOM, 0, 100)
                duration = Toast.LENGTH_LONG
                view = layout
            }.show()
        }
    }
    override fun onDestroyView() {
        if (callback != null){
            callback?.isEnabled = false
            callback?.remove()
        }
        if (timer != null){
            timer?.purge()
            timer?.cancel()
            timer = null
        }

        super.onDestroyView()
    }
}