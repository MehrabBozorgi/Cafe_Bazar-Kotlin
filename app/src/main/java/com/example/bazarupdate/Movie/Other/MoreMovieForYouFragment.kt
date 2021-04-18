package com.example.bazarupdate.Movie.Other

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
import com.example.bazarupdate.MVVM.ViewModel
import com.example.bazarupdate.Movie.MovieAdapter.More1MovieAdapter
import com.example.bazarupdate.R

class MoreMovieForYouFragment : Fragment() {

    lateinit var viewModel: ViewModel
    lateinit var more1MovieAdapter: More1MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_more_movie_for_you, container, false)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        getMore1(view)

        return view
    }

    fun getMore1(view: View) {
        var moreMovieRecycler1 = view.findViewById<RecyclerView>(R.id.rv_moreMovieFroYou_1)
        moreMovieRecycler1.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel.getMore1().observe(viewLifecycleOwner, { it ->

            more1MovieAdapter = More1MovieAdapter(it) {

                var bundle = Bundle()
                var detailMovie = DetailMovieFragment()
                detailMovie.arguments = bundle
                bundle.putParcelable("id",it)
                var transaction = requireActivity().supportFragmentManager.beginTransaction()
                YoYo.with(Techniques.FadeInDown)
                    .duration(900)
                    .repeat(0)
                    .playOn(requireActivity().findViewById(R.id.fram_parent));
                transaction.replace(R.id.fram_parent, detailMovie)
                transaction.addToBackStack(null)
                transaction.commit()

            }
            moreMovieRecycler1.adapter = more1MovieAdapter

        })
    }

}