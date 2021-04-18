package com.example.bazarupdate.Profile

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.bazarupdate.Profile.Adapter.SignedAdapter
import com.example.bazarupdate.Profile.Other.LoginFragment
import com.example.bazarupdate.Profile.Other.SignedFragment
import com.example.bazarupdate.R

////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
//فرگمنتی که در اون با شریت پریفرنس وارد حساب کاربری میشیم و از اون خارج میشی
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
class Profile_Fragment : Fragment() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_profile_, container, false)
        sharedPreferences =
            requireContext().getSharedPreferences("account", Context.MODE_PRIVATE)

        //وقتی دکمه ورود به حساب کاربری رو زدیم میره توی صفحه ی وارد کردن رمز عبور و ایمیل
        var btnEnter = view.findViewById<Button>(R.id.btn_profile_enter)
        btnEnter.setOnClickListener {
            var transaction = requireActivity().supportFragmentManager.beginTransaction()
            YoYo.with(Techniques.SlideInDown)
                .duration(900)
                .repeat(0)
                .playOn(requireActivity().findViewById(R.id.fram_parent));
            transaction.replace(R.id.fram_parent, LoginFragment())
            transaction.commit()
        }

        checkLogin(view)
        exitAccount(view)
        goToSigned(view)
        goToAboutUs(view)

        return view
    }

    //چک میکنه که توی حسابش هست یا نه
    private fun checkLogin(view: View) {

        var relEnter = view.findViewById<RelativeLayout>(R.id.rel_profile_parent)
        var relExit = view.findViewById<RelativeLayout>(R.id.rel_profile_parentExit)
        var relSigned = view.findViewById<RelativeLayout>(R.id.rel_signed)
        var view = view.findViewById<View>(R.id.view7)

        var email = sharedPreferences.getString("email", "")
        if (!email!!.equals("")) {

            relEnter.visibility = View.GONE
            relExit.visibility = View.VISIBLE
            relSigned.visibility = View.VISIBLE
            view.visibility = View.VISIBLE
        }

    }

    //حساب کاربری خارج میشیم با شریت پریفرنس
    private fun exitAccount(view: View) {

        var relEnter = view.findViewById<RelativeLayout>(R.id.rel_profile_parent)
        var relExit = view.findViewById<RelativeLayout>(R.id.rel_profile_parentExit)
        var btnExit = view.findViewById<Button>(R.id.btn_profile_exit)
        var relSigned = view.findViewById<RelativeLayout>(R.id.rel_signed)
        var view = view.findViewById<View>(R.id.view7)

        btnExit.setOnClickListener {

            var editor = sharedPreferences.edit()
            editor.putString("email", "")
            editor.apply()

            relEnter.visibility = View.VISIBLE
            relExit.visibility = View.GONE
            relSigned.visibility = View.GONE
            view.visibility = View.GONE

        }
    }

    //وقتی که روی نشان شده ها کلیک میکنیم میریم به جایی نشان شده ها هستن
    private fun goToSigned(view: View) {
        var rel = view.findViewById<RelativeLayout>(R.id.rel_signed)

        rel.setOnClickListener {

            var transaction = requireActivity().supportFragmentManager.beginTransaction()
            YoYo.with(Techniques.SlideInDown)
                .duration(900)
                .repeat(0)
                .playOn(requireActivity().findViewById(R.id.fram_parent))

            transaction.replace(R.id.fram_parent, SignedFragment())
            transaction.commit()
        }
    }

    fun goToAboutUs(view: View) {

        var imgUs = view.findViewById<ImageView>(R.id.aboutUs)
        imgUs.setOnClickListener {

            var transation = requireActivity().supportFragmentManager.beginTransaction()
            YoYo.with(Techniques.SlideInDown)
                .duration(1100)
                .repeat(0)
                .playOn(requireActivity().findViewById(R.id.fram_parent))
            transation.replace(R.id.fram_parent, AboutUsFragment())

            transation.addToBackStack(null)
            transation.commit()

        }

    }


}