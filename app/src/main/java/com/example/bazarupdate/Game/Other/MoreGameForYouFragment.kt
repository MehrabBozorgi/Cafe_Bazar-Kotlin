package com.example.bazarupdate.Game.Other

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
import com.example.bazarupdate.Game.GameAdapter.MoreGameForYouAdapter
import com.example.bazarupdate.MVVM.ViewModel
import com.example.bazarupdate.R

class MoreGameForYouFragment : Fragment() {

    lateinit var viewModel: ViewModel
    lateinit var moreGameForYouAdapter: MoreGameForYouAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_more_for_you_game, container, false)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        getMoreGameForYou(view)
        return view

    }

    private fun getMoreGameForYou(view: View) {

        var moreGameForYouRecycler =
            view.findViewById<RecyclerView>(R.id.rv_fragmentMoreGameForYou_moreYouRecycler)
        moreGameForYouRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel.moreGameForYou().observe(viewLifecycleOwner, { it ->
            moreGameForYouAdapter = MoreGameForYouAdapter(it) {

                var detailFragment = DetailGameFragment()
                var bundle = Bundle()
                bundle.putParcelable("id", it)
                detailFragment.arguments = bundle
                var transaction = requireActivity().supportFragmentManager.beginTransaction()
                YoYo.with(Techniques.FadeInDown)
                    .duration(900)
                    .repeat(0)
                    .playOn(requireActivity().findViewById(R.id.fram_parent)); transaction.replace(
                R.id.fram_parent,
                detailFragment
            )
                transaction.addToBackStack(null)
                transaction.commit()

            }

            moreGameForYouRecycler.adapter = moreGameForYouAdapter
        })


    }
}