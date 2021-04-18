package com.example.bazarupdate.App.Other

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.bazarupdate.MVVM.ViewModel
import com.example.bazarupdate.Model.App_Game.MoreGame
import com.example.bazarupdate.R
import com.squareup.picasso.Picasso


class DescAppFragment : Fragment() {

    lateinit var viewModel: ViewModel
    lateinit var list: MoreGame

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_desc_app, container, false)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        val bundle = arguments

        val getDescApp = bundle!!.getParcelable<MoreGame>("desc")

        val imgIcon = view.findViewById<ImageView>(R.id.img_fragmentDescApp_icon)
        val txtName = view.findViewById<TextView>(R.id.txt_fragmentDescApp_name)
        val txtDesc = view.findViewById<TextView>(R.id.txt_fragmentDescApp_desc)
        val txtDownload = view.findViewById<TextView>(R.id.txt_moreInfoRowApp_download)!!
        val txtVersion = view.findViewById<TextView>(R.id.txt_moreInfoRowApp_version)!!
        val txtSize = view.findViewById<TextView>(R.id.txt_moreInfoRowApp_size)!!
        val txtCat = view.findViewById<TextView>(R.id.txt_moreInfoRowApp_cat)!!


        txtDesc.text = getDescApp!!.description
        txtName.text = getDescApp.name
        txtDownload.text = getDescApp.download + "هزار "
        txtSize.text = getDescApp.size + " مگابایت"
        txtCat.text = getDescApp.cat
        txtVersion.text = getDescApp.version
        Picasso.get().load(getDescApp.icon).into(imgIcon)



//        val imgBackApp = view.findViewById<ImageView>(R.id.img_fragmentDescApp_back1)
//        imgBackApp.setOnClickListener {
//            val transaction = requireActivity().supportFragmentManager.beginTransaction()
////            YoYo.with(Techniques.FadeInDown)
////                .duration(900)
////                .repeat(0)
////                .playOn(requireActivity().findViewById(R.id.fram_parent));
//            transaction.replace(R.id.fragmentApp_parent, DetailAppFragment())
//            transaction.commit()
////   val transaction = requireActivity().supportFragmentManager.beginTransaction()
////            YoYo.with(Techniques.FadeInDown)
////                .duration(900)
////                .repeat(0)
////                .playOn(requireActivity().findViewById(R.id.fram_parent));
////            transaction.replace(R.id.fram_parent, App_Fragment()
////        )
////            transaction.commit()
////
////        }
//        }


        return view

    }



}