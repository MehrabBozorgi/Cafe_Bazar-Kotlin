package com.example.bazarupdate.Profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.bazarupdate.R

class AboutUsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_about_us, container, false)


        goToWeb1(view)
        goToWeb2(view)
        goToWeb3(view)


        return view
    }

    private fun goToWeb1(view: View) {
        var youtube = view.findViewById<RelativeLayout>(R.id.relConnect1)
        youtube.setOnClickListener {

            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://youtube.com/channel/UCJtri6qm3ZgD8NfMrbgtYoQ"))
            Toast.makeText(context, "به صفحه یوتیوب وارد میشوید", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }

    private fun goToWeb2(view: View) {
        var linkDin = view.findViewById<RelativeLayout>(R.id.relConnect2)
        linkDin.setOnClickListener {

            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.linkedin.com"))
            Toast.makeText(context, "به صفحه لینکدین وارد میشوید", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

    }

    private fun goToWeb3(view: View) {
        var insta = view.findViewById<RelativeLayout>(R.id.relConnect3)
        insta.setOnClickListener {

            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.instagram.com/mehrab.code"))
            Toast.makeText(context, "به صفحه ایسنتاگرام وارد میشوید", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }

}