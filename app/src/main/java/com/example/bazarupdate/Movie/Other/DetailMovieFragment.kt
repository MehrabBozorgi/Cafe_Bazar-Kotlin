package com.example.bazarupdate.Movie.Other

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.bazarupdate.MVVM.ViewModel
import com.example.bazarupdate.Model.App_Game.CommentMovie
import com.example.bazarupdate.Model.Movie.Fasl
import com.example.bazarupdate.Model.Movie.Movie
import com.example.bazarupdate.Movie.MovieAdapter.CommentMovieAdapter
import com.example.bazarupdate.Movie.MovieAdapter.FaslAdapter
import com.example.bazarupdate.Movie.MovieAdapter.MovieLikeAdapter
import com.example.bazarupdate.Movie.Movie_Fragment
import com.example.bazarupdate.R
import com.example.bazarupdate.Room.RCourse
import com.example.bazarupdate.Room.RoomViewModel
import com.makeramen.roundedimageview.RoundedImageView
import com.skyhope.showmoretextview.ShowMoreTextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_movie.*

class DetailMovieFragment : Fragment() {

    lateinit var viewModel: ViewModel
    private lateinit var bundleList: Movie
    lateinit var commentList: List<CommentMovie>
    lateinit var faslList: List<Fasl>
    lateinit var commentMovieAdapter: CommentMovieAdapter
    lateinit var movieLikeAdapter: MovieLikeAdapter
    lateinit var faslAdapter: FaslAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_detail_movie, container, false)

        var bundle = arguments
        bundleList = bundle!!.getParcelable<Movie>("id")!!
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        getAll(view)
        getCommentMovie(view)
        getMovieLike(view)
        getFasl(view)
        back(view)
        share(view)

        return view
    }

    private fun getAll(view: View) {

        var txtName = view.findViewById<TextView>(R.id.txt_fragmentDetailMovie_name)
        var txtKodom_site = view.findViewById<TextView>(R.id.txt_fragmentDetailMovie_kodom_site)
        var txtCat = view.findViewById<TextView>(R.id.txt_fragmentDetailMovie_cat)
        var txtPoint = view.findViewById<TextView>(R.id.txt_fragmentDetail_point)
        var txtSub1 = view.findViewById<TextView>(R.id.txt_fragmentDetail_sub)
        var txtAge = view.findViewById<TextView>(R.id.txt_fragmentDetail_age)
        //////////
        var txtDescMore = view.findViewById<ShowMoreTextView>(R.id.txt_ViewMore)
        //////////
        var txtYear = view.findViewById<TextView>(R.id.txt_fragmentDetailMovie_year)
        var txtKind = view.findViewById<TextView>(R.id.txt_fragmentDetailMovie_kind)
        var txtTime = view.findViewById<TextView>(R.id.txt_fragmentDetailMovie_time)
        var txtCountry = view.findViewById<TextView>(R.id.txt_fragmentDetailMovie_country)
        var txtKeyfiat = view.findViewById<TextView>(R.id.txt_fragmentDetailMovie_keyfiat)
        var txtTools = view.findViewById<TextView>(R.id.txt_fragmentMovie_tools)
        var txtSub2 = view.findViewById<TextView>(R.id.txt_fragmentDetailMovie_sub)

        var txtWrite = view.findViewById<TextView>(R.id.txt_fragmentDetailMovie_write)
        var imgIcon = view.findViewById<RoundedImageView>(R.id.img_fragmentDetailMovie_icon)
        var rel = view.findViewById<RelativeLayout>(R.id.rel_InfoMovie6)

        txtName.text = bundleList.name
        txtKodom_site.text = bundleList.kodom_site
        txtCat.text = bundleList.cat
        txtPoint.text = bundleList.point + "/10"
        txtSub1.text = bundleList.zaban
        txtAge.text = bundleList.sale_sakh
        txtYear.text = bundleList.sale_sakh
        txtKind.text = bundleList.cat
        txtTime.text = bundleList.time + " دقیقه"
        txtCountry.text = bundleList.country
        txtKeyfiat.text = bundleList.keyfiat
        txtTools.text = bundleList.tools
        txtSub2.text = bundleList.zir_nevis
        // txtWrite.text=bundleList.
        Picasso.get().load(bundleList.icon).into(imgIcon)

        //مقدار برای توضیحات زیاد
        txtDescMore.text = bundleList.description

        txtDescMore.addShowMoreText("  ادامه");
        txtDescMore.addShowLessText("بستن  ");

        txtDescMore.setShowMoreColor(Color.RED)
        txtDescMore.setShowLessTextColor(Color.RED)

        txtDescMore.setShowingLine(2)

        if (txtSub2.text.isEmpty()) {

            rel.visibility = View.GONE
        }

        //باز شدن صفحه ی فیلیمو
        var btnPlay = view.findViewById<Button>(R.id.btn_fragmentDetailMovie_play)
        btnPlay.setOnClickListener {

            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.filimo.com/"))
            startActivity(intent)
        }
    }

//        var roomViewModel = ViewModelProvider(this).get(RoomViewModel::class.java)
//        var imgSaveEmpty = view.findViewById<ImageView>(R.id.save_emptyMovie)
//
//        roomViewModel.getSignCourse(bundleList.name).observe(viewLifecycleOwner, { it ->
//
//            if (it != null) {
//                imgSaveEmpty.setImageDrawable(
//                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_white))
//                imgSaveEmpty.tag = "signed"
//
//            }
//
//        })
//
//        imgSaveEmpty.setOnClickListener {
//            if (imgSaveEmpty.tag == "signed") {
//                imgSaveEmpty.setImageDrawable(
//                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_mark_white))
//                imgSaveEmpty.tag="unSigned"
//                var rCourse = RCourse(
//                    bundleList.id.toInt(),
//                    bundleList.icon,
//                    bundleList.name,
//                    bundleList.size,
//
//                    )
//                roomViewModel.deleteCourse(rCourse)
//                Toast.makeText(context, "بازی از لیست علاقه مندی ها حذف شد", Toast.LENGTH_SHORT)
//                    .show()
//            } else {
//                var rCourse = RCourse(
//                    bundleList.id.toInt(),
//                    bundleList.icon,
//                    bundleList.name,
//                    bundleList.size,
//                )
//                roomViewModel.insert(rCourse)
//                Toast.makeText(context, "بازی به لیست علاقه مندی ها اضافه شد", Toast.LENGTH_SHORT)
//                    .show()
//            }
//
//        }


    private fun getCommentMovie(view: View) {

        var commentMovieRecycler =
            view.findViewById<RecyclerView>(R.id.rv_fragmentDetailMovie_movieComment)
        commentMovieRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewModel.getCommentMovie(bundleList.id).observe(viewLifecycleOwner, { it ->


            commentList = it.comment
            commentMovieAdapter = CommentMovieAdapter(commentList)
            commentMovieRecycler.adapter = commentMovieAdapter

            if (it.comment.isEmpty()) {

                commentMovieRecycler.visibility = View.GONE
                viewMovie2.visibility = View.GONE
                txtMovie2.visibility = View.GONE
                txtMovie3.visibility = View.GONE

            }


        })

    }

    private fun getFasl(view: View) {

        var faslRecycler =
            view.findViewById<RecyclerView>(R.id.rv_fragmentDetail_fasl)
        faslRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewModel.getFasl(bundleList.id).observe(viewLifecycleOwner, { it ->


            faslList = it.faslha
            faslAdapter = FaslAdapter(faslList) {

            }
            faslRecycler.adapter = faslAdapter

            if (it.faslha.isEmpty()) {

                faslRecycler.visibility = View.GONE
                txtMovie6.visibility = View.GONE

            }

        })

    }

    fun getMovieLike(view: View) {

        var movieLikeRecycler =
            view.findViewById<RecyclerView>(R.id.rv_fragmentDetailMovie_movieLike)
        movieLikeRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)

        viewModel.getFilmHero().observe(viewLifecycleOwner, { it ->

            movieLikeAdapter = MovieLikeAdapter(it) {

                var bundle = Bundle()
                var detailMovie = DetailMovieFragment()
                detailMovie.arguments = bundle
                bundle.putParcelable("id", it)
                var transaction = requireActivity().supportFragmentManager.beginTransaction()
                YoYo.with(Techniques.FadeInDown)
                    .duration(900)
                    .repeat(0)
                    .playOn(requireActivity().findViewById(R.id.fram_parent)); transaction.replace(
                R.id.fram_parent,
                detailMovie
            )
                transaction.addToBackStack(null)
                transaction.commit()

            }
            movieLikeRecycler.adapter = movieLikeAdapter

        })


    }

    fun back(view: View) {

        var back = view.findViewById<ImageView>(R.id.img_fragmentDetailMovie_back)

        back.setOnClickListener {

            var transaction = requireActivity().supportFragmentManager.beginTransaction()
            YoYo.with(Techniques.FadeInDown)
                .duration(900)
                .repeat(0)
                .playOn(requireActivity().findViewById(R.id.fram_parent)); transaction.replace(
            R.id.fram_parent,
            Movie_Fragment()
        )
            transaction.commit()

        }
    }

    fun share(view: View) {

        var imgShare = view.findViewById<ImageView>(R.id.img_fragmentDetailMovie_share)

        imgShare.setOnClickListener {

            var intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "https://www.filimo.com/"
            )

            startActivity(Intent.createChooser(intent, "انتشار فیلم"))

        }

    }
}