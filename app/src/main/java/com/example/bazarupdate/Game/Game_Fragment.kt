package com.example.bazarupdate.Game

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.bazarupdate.Game.GameAdapter.*
import com.example.bazarupdate.MVVM.ViewModel
import com.example.bazarupdate.Game.Other.DetailGameFragment
import com.example.bazarupdate.Game.Other.MoreGameForYouFragment
import com.example.bazarupdate.R
import com.example.bazarupdate.Search.SearchAdapter
import com.example.bazarupdate.Search.Search_Fragment
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_game_.*

class Game_Fragment : Fragment() {

    lateinit var viewModel: ViewModel
    lateinit var newGameAdapter: NewGameAdapter
    lateinit var moreGameAdapter: MoreGameAdapter
    lateinit var bestNewGameAdapter: BestNewGameAdapter
    lateinit var updateGameAdapter: UpdateGameAdapter
    lateinit var catGameAdapter: CatGameAdapter
    lateinit var bannerGameAdapter: BannerGameAdapter
    lateinit var searchAdapter: SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_game_, container, false)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        getGoli(view)
        moreGame(view)
        newGame(view)
        bestNew(view)
        updateGame(view)
        moreGameForYou1(view)
        moreGameForYou2(view)
        moreGameForYou3(view)
        catGame(view)
        getBanners(view)
        uniqCat(view)
        search(view)

        return view
    }

    private fun getGoli(view: View) {

        val imgBigPic = view.findViewById<RoundedImageView>(R.id.img_fragmentGame_bigPic)
        val imgIcon = view.findViewById<RoundedImageView>(R.id.img_fragmentGame_iconGoli)
        val txtName = view.findViewById<TextView>(R.id.txt_fragmentGame_goli)

        viewModel.getGoli().observe(viewLifecycleOwner, { it ->
            it.map {
                txtName.text = it.name
                Picasso.get().load(it.big_img).into(imgBigPic)
                Picasso.get().load(it.icon).into(imgIcon)

            }

        })

        viewModel.getGoli()
    }

    private fun moreGame(view: View) {

        val moreGameRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentGame_moreGame)

        moreGameRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)

        viewModel.moreGame().observe(viewLifecycleOwner, { it ->
            moreGameAdapter = MoreGameAdapter(it) {
                val detailFragment = DetailGameFragment()
                val bundle = Bundle()
                bundle.putParcelable("id", it)
                detailFragment.arguments = bundle

                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                YoYo.with(Techniques.FadeInDown)
                    .duration(900)
                    .repeat(0)
                    .playOn(requireActivity().findViewById(R.id.fram_parent))
                transaction.replace(R.id.fram_parent, detailFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
            moreGameRecycler.adapter = moreGameAdapter
        })

    }

    private fun newGame(view: View) {

        val newGameRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentGame_newGame)

        newGameRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)

        viewModel.newGame().observe(viewLifecycleOwner, { it ->
            newGameAdapter = NewGameAdapter(it) {
                val bundle = Bundle()
                val detailFragment = DetailGameFragment()
                bundle.putParcelable("id", it)
                detailFragment.arguments = bundle
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
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
            newGameRecycler.adapter = newGameAdapter
        })

    }

    private fun bestNew(view: View) {

        val bestNewRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentGame_bestNew)

        bestNewRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)

        viewModel.bestNew().observe(viewLifecycleOwner, { it ->

            bestNewGameAdapter = BestNewGameAdapter(it) {

                val bundle = Bundle()
                val detailFragment = DetailGameFragment()
                bundle.putParcelable("id", it)
                detailFragment.arguments = bundle
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
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
            bestNewRecycler.adapter = bestNewGameAdapter
        })

    }

    private fun updateGame(view: View) {

        val updateGameRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentGame_update)

        updateGameRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)

        viewModel.updateGame().observe(viewLifecycleOwner, { it ->

            updateGameAdapter = UpdateGameAdapter(it) {

                val bundle = Bundle()
                val detailFragment = DetailGameFragment()
                bundle.putParcelable("id", it)
                detailFragment.arguments = bundle
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
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
            updateGameRecycler.adapter = updateGameAdapter
        })
    }

    private fun catGame(view: View) {

        val catGameRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentGame_catGame)
        catGameRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel.catGame().observe(viewLifecycleOwner, { it ->

            catGameAdapter = CatGameAdapter(it) {

                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                YoYo.with(Techniques.FadeInDown)
                    .duration(900)
                    .repeat(0)
                    .playOn(requireActivity().findViewById(R.id.fram_parent)); transaction.replace(
                R.id.fram_parent,
                MoreGameForYouFragment()
            )
                transaction.addToBackStack(null)
                transaction.commit()

            }
            catGameRecycler.adapter = catGameAdapter
        })

    }

    private fun uniqCat(view: View) {

        val catGameRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentGame_catGame)

        catGameRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)

        viewModel.catGame().observe(viewLifecycleOwner, { it ->

            catGameAdapter = CatGameAdapter(it) {

                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                YoYo.with(Techniques.FadeInDown)
                    .duration(900)
                    .repeat(0)
                    .playOn(requireActivity().findViewById(R.id.fram_parent)); transaction.replace(
                R.id.fram_parent,
                MoreGameForYouFragment()
            )
                transaction.addToBackStack(null)
                transaction.commit()

            }
            catGameRecycler.adapter = catGameAdapter
        })


    }

    private fun moreGameForYou1(view: View) {

        val rel = view.findViewById<RelativeLayout>(R.id.rel_fragmentGame_5)!!

        rel.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            YoYo.with(Techniques.FadeInDown)
                .duration(900)
                .repeat(0)
                .playOn(requireActivity().findViewById(R.id.fram_parent)); transaction.replace(
            R.id.fram_parent,
            MoreGameForYouFragment()
        )
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    private fun moreGameForYou2(view: View) {

        val rel = view.findViewById<RelativeLayout>(R.id.rel_fragmentGame_6)!!

        rel.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            YoYo.with(Techniques.FadeInDown)
                .duration(900)
                .repeat(0)
                .playOn(requireActivity().findViewById(R.id.fram_parent)); transaction.replace(
            R.id.fram_parent,
            MoreGameForYouFragment()
        )
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    private fun moreGameForYou3(view: View) {

        val rel = view.findViewById<RelativeLayout>(R.id.rel_fragmentGame_7)!!

        rel.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            YoYo.with(Techniques.FadeInDown)
                .duration(900)
                .repeat(0)
                .playOn(requireActivity().findViewById(R.id.fram_parent)); transaction.replace(
            R.id.fram_parent,
            MoreGameForYouFragment()
        )
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    private fun getBanners(view: View) {

        val bannerRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentGame_banners)
        bannerRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)

        viewModel.getBanners().observe(viewLifecycleOwner, { it ->

            bannerGameAdapter = BannerGameAdapter(it)
            bannerRecycler.adapter = bannerGameAdapter

        })

    }

    private fun search(view: View) {

        var edtSearch = view.findViewById<TextView>(R.id.edt_fragmentGame_edtSearch)
//        var searchRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentGame_search)
        var relGame = view.findViewById<RelativeLayout>(R.id.rel_fragmentGame_game)
        var relSearch = view.findViewById<RelativeLayout>(R.id.rel_fragmentGame_search)

//        searchRecycler.layoutManager =
//            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        edtSearch.setOnClickListener {

            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fram_parent, Search_Fragment())
            transaction.addToBackStack(null)
            transaction.commit()

        }


//        if (relSearch.callOnClick()) {
        //با استفاده از خاصیت addTextChangeListener ادیت تکس سرچ میکنیم
//            edtSearch.addTextChangedListener(object : TextWatcher {
//
//
//                override fun beforeTextChanged(
//                    s: CharSequence?,
//                    start: Int,
//                    count: Int,
//                    after: Int
//                ) {
//                }
//
//                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                }
//
//                override fun afterTextChanged(s: Editable?) {
//                    viewModel.search(s.toString()).observe(viewLifecycleOwner, { it ->
//                        searchAdapter = SearchAdapter(it) {
//
//                            var detailFragment = DetailGameFragment()
//                            var bundle = Bundle()
//                            bundle.putParcelable("id", it)
//                            detailFragment.arguments = bundle
//
//                            var transaction =
//                                requireActivity().supportFragmentManager.beginTransaction()
//                            YoYo.with(Techniques.FadeInDown)
//                                .duration(900)
//                                .repeat(0)
//                                .playOn(requireActivity().findViewById(R.id.fram_parent))
//                            transaction.replace(R.id.fram_parent, detailFragment)
//                            transaction.addToBackStack(null)
//                            transaction.commit()
//
//                        }
//                        searchRecycler.adapter = searchAdapter
//                        searchAdapter.notifyDataSetChanged()
//
//                    })
//                }
//
//            })
//        } else {
//            searchRecycler.visibility = View.GONE
//        }
    }

}
