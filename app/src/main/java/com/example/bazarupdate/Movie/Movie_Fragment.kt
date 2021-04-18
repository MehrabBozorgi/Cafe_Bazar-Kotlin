package com.example.bazarupdate.Movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.bazarupdate.MVVM.ViewModel
import com.example.bazarupdate.Movie.MovieAdapter.*
import com.example.bazarupdate.Movie.Other.DetailMovieFragment
import com.example.bazarupdate.Movie.Other.MoreMovieForYouFragment
import com.example.bazarupdate.R
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso

class Movie_Fragment : Fragment() {

    lateinit var viewModel: ViewModel
    lateinit var updateAdapter: UpdateFilmAdapter
    lateinit var filmIranAdapter: FilmIranAdapter
    lateinit var filmHeroAdapter: FilmHeroAdapter
    lateinit var animatAdapter: AnimatAdapter
    lateinit var catMovieAdapter: CatMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_movie, container, false)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        getImage(view)
        getUpdateFilm(view)
        getFilmIran(view)
        getFilmHero(view)
        getFilmIran(view)
        getAnimat(view)
        getCat(view)
        moreMovieForYou1(view)
        moreMovieForYou2(view)
        moreMovieForYou3(view)


        return view

    }

    fun getImage(view: View) {

        var img = view.findViewById<RoundedImageView>(R.id.img_fragmentMovie_bigImage)
        viewModel.getBigImage().observe(viewLifecycleOwner, { it ->

            it.map {
                Picasso.get().load(R.drawable.dare).into(img)
            }
        })

    }

    fun getUpdateFilm(view: View) {

        var updateRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentMovie_updateFilm)
        updateRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        viewModel.getUpdateFilm().observe(viewLifecycleOwner, { it ->

            updateAdapter = UpdateFilmAdapter(it) {

                var bundle = Bundle()
                var detailMovie = DetailMovieFragment()
                detailMovie.arguments = bundle
                bundle.putParcelable("id", it)
                var transaction = requireActivity().supportFragmentManager.beginTransaction()
                YoYo.with(Techniques.FadeInDown)
                    .duration(900)
                    .repeat(0)
                    .playOn(requireActivity().findViewById(R.id.fram_parent));
                transaction.replace(R.id.fram_parent, detailMovie)
                transaction.addToBackStack(null)
                transaction.commit()

            }
            updateRecycler.adapter = updateAdapter

        })


    }

    fun getFilmIran(view: View) {

        var filmIranRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentMovie_serialIran)
        filmIranRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        viewModel.getFilmIran().observe(viewLifecycleOwner, { it ->

            filmIranAdapter = FilmIranAdapter(it) {

                var bundle = Bundle()
                var detailMovie = DetailMovieFragment()
                detailMovie.arguments = bundle
                bundle.putParcelable("id", it)
                var transaction = requireActivity().supportFragmentManager.beginTransaction()
                YoYo.with(Techniques.FadeInDown)
                    .duration(900)
                    .repeat(0)
                    .playOn(requireActivity().findViewById(R.id.fram_parent));
                transaction.replace(R.id.fram_parent, detailMovie)
                transaction.addToBackStack(null)
                transaction.commit()

            }
            filmIranRecycler.adapter = filmIranAdapter

        })


    }

    fun getFilmHero(view: View) {

        var filmHeroRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentMovie_serialSuper)
        filmHeroRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        viewModel.getFilmHero().observe(viewLifecycleOwner, { it ->

            filmHeroAdapter = FilmHeroAdapter(it) {
                var bundle = Bundle()
                var detailMovie = DetailMovieFragment()
                detailMovie.arguments = bundle
                bundle.putParcelable("id", it)
                var transaction = requireActivity().supportFragmentManager.beginTransaction()
                YoYo.with(Techniques.FadeInDown)
                    .duration(900)
                    .repeat(0)
                    .playOn(requireActivity().findViewById(R.id.fram_parent));
                transaction.replace(R.id.fram_parent, detailMovie)
                transaction.addToBackStack(null)
                transaction.commit()

            }
            filmHeroRecycler.adapter = filmHeroAdapter

        })


    }

    fun getAnimat(view: View) {

        var animateRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentMovie_animate)
        animateRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        viewModel.getAnimat().observe(viewLifecycleOwner, { it ->

            animatAdapter = AnimatAdapter(it) {
                var bundle = Bundle()
                var detailMovie = DetailMovieFragment()
                detailMovie.arguments = bundle
                bundle.putParcelable("id", it)
                var transaction = requireActivity().supportFragmentManager.beginTransaction()
                YoYo.with(Techniques.FadeInDown)
                    .duration(900)
                    .repeat(0)
                    .playOn(requireActivity().findViewById(R.id.fram_parent));
                transaction.replace(R.id.fram_parent, detailMovie)
                transaction.addToBackStack(null)
                transaction.commit()

            }
            animateRecycler.adapter = animatAdapter

        })


    }

    fun getCat(view: View) {

        var catRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentMovie_catMovie)
        catRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewModel.getCat().observe(viewLifecycleOwner, { it ->

            catMovieAdapter = CatMovieAdapter(it) {

                var transaction = requireActivity().supportFragmentManager.beginTransaction()
                YoYo.with(Techniques.FadeInDown)
                    .duration(900)
                    .repeat(0)
                    .playOn(requireActivity().findViewById(R.id.fram_parent));
                transaction.replace(R.id.fram_parent, MoreMovieForYouFragment())
                transaction.addToBackStack(null)
                transaction.commit()

            }
            catRecycler.adapter = catMovieAdapter

        })

    }

    fun moreMovieForYou1(view: View) {

        var rel = view.findViewById<RelativeLayout>(R.id.rel_fragmentMovie_1)
        rel.setOnClickListener {
            var transaction = requireActivity().supportFragmentManager.beginTransaction()
            YoYo.with(Techniques.FadeInDown)
                .duration(900)
                .repeat(0)
                .playOn(requireActivity().findViewById(R.id.fram_parent));
            transaction.replace(R.id.fram_parent, MoreMovieForYouFragment())
            transaction.addToBackStack(null)
            transaction.commit()

        }

    }

    fun moreMovieForYou2(view: View) {

        var rel = view.findViewById<RelativeLayout>(R.id.rel_fragmentMovie_2)
        rel.setOnClickListener {
            var transaction = requireActivity().supportFragmentManager.beginTransaction()
            YoYo.with(Techniques.FadeInDown)
                .duration(900)
                .repeat(0)
                .playOn(requireActivity().findViewById(R.id.fram_parent));
            transaction.replace(R.id.fram_parent, MoreMovieForYouFragment())
            transaction.addToBackStack(null)
            transaction.commit()

        }

    }

    fun moreMovieForYou3(view: View) {

        var rel = view.findViewById<RelativeLayout>(R.id.rel_fragmentMovie_4)
        rel.setOnClickListener {
            var transaction = requireActivity().supportFragmentManager.beginTransaction()
            YoYo.with(Techniques.FadeInDown)
                .duration(900)
                .repeat(0)
                .playOn(requireActivity().findViewById(R.id.fram_parent));
            transaction.replace(R.id.fram_parent, MoreMovieForYouFragment())
            transaction.addToBackStack(null)
            transaction.commit()

        }

    }


}






