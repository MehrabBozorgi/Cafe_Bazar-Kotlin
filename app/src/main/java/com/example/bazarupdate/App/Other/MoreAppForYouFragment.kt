package com.example.bazarupdate.App.Other

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.bazarupdate.App.AppAdapter.MoreAppForYouAdapter
import com.example.bazarupdate.MVVM.ViewModel
import com.example.bazarupdate.R

class MoreAppForYouFragment : Fragment() {

    lateinit var viewModel: ViewModel
    lateinit var moreAppForYouAdapter: MoreAppForYouAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_more_app_for_you, container, false)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        moreAppForYou(view)
        return view
    }

    private fun moreAppForYou(view: View) {

        var moreAppForYouRecycler =
            view.findViewById<RecyclerView>(R.id.rv_fragmentMoreAppForYou_moreYouAppRecycler)
        moreAppForYouRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel.moreAppForYou().observe(viewLifecycleOwner, { it ->
            moreAppForYouAdapter = MoreAppForYouAdapter(it) {

                var detailAppFragment = DetailAppFragment()
                var bundle = Bundle()
                bundle.putParcelable("id", it)
                detailAppFragment.arguments = bundle
                var transaction = requireActivity().supportFragmentManager.beginTransaction()
                YoYo.with(Techniques.FadeInDown)
                    .duration(900)
                    .repeat(0)
                    .playOn(requireActivity().findViewById(R.id.fram_parent)); transaction.replace(
                R.id.fram_parent,
                detailAppFragment
            )
                transaction.addToBackStack(null)
                transaction.commit()

            }

            moreAppForYouRecycler.adapter = moreAppForYouAdapter
        })

    }
}

