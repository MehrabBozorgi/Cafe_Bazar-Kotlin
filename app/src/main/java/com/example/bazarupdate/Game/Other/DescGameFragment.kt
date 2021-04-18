package com.example.bazarupdate.Game.Other

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.bazarupdate.MVVM.ViewModel
import com.example.bazarupdate.Model.App_Game.MoreGame
import com.example.bazarupdate.R
import com.squareup.picasso.Picasso


class DescGameFragment : Fragment() {

    lateinit var viewModel: ViewModel
    lateinit var list: MoreGame

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        var view = inflater.inflate(R.layout.fragment_desc, container, false)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        var bundle = arguments

        var getDesc = bundle!!.getParcelable<MoreGame>("desc")

        var imgIcon = view.findViewById<ImageView>(R.id.img_fragmentDesc_icon)
        var txtName = view.findViewById<TextView>(R.id.txt_fragmentDesc_name)
        var txtDesc = view.findViewById<TextView>(R.id.txt_fragmentDesc_desc)
        var txtDownload = view.findViewById<TextView>(R.id.txt_moreInfoRow_download)!!
        var txtVersion = view.findViewById<TextView>(R.id.txt_moreInfoRow_version)!!
        var txtSize = view.findViewById<TextView>(R.id.txt_moreInfoRow_size)!!
        var txtCat = view.findViewById<TextView>(R.id.txt_moreInfoRow_cat)!!



        txtDesc.text = getDesc!!.description
        txtName.text = getDesc.name
        txtDownload.text = getDesc.download + "هزار "
        txtSize.text = getDesc.size + " مگابایت"
        txtCat.text = getDesc.cat
        txtVersion.text = getDesc.version
        Picasso.get().load(getDesc.icon).into(imgIcon)


//        getMoreInfo(view)

        return view

    }

    fun getMoreInfo(view: View) {
        var imgBack = view.findViewById<ImageView>(R.id.img_fragmentDesc_back)
        imgBack.setOnClickListener {

            var transaction = requireActivity().supportFragmentManager.beginTransaction()

            transaction.replace(R.id.fram_parent, DetailGameFragment())
            transaction.commit()

        }

    }
}