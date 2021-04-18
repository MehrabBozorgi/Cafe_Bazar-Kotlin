package com.example.bazarupdate.App

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
import com.example.bazarupdate.App.AppAdapter.*
import com.example.bazarupdate.Game.GameAdapter.SlidersGameAdapter
import com.example.bazarupdate.MVVM.ViewModel
import com.example.bazarupdate.App.Other.DetailAppFragment
import com.example.bazarupdate.Game.Other.DetailGameFragment
import com.example.bazarupdate.App.Other.MoreAppForYouFragment
import com.example.bazarupdate.R
import com.example.bazarupdate.Search.SearchAdapter
import com.example.bazarupdate.Search.Search_Fragment

class App_Fragment : Fragment() {
    lateinit var viewModel: ViewModel
    lateinit var newAppAdapter: NewAppAdapter
    lateinit var moreAppAdapter: MoreAppAdapter
    lateinit var bestNewAppAdapter: BestNewAppAdapter
    lateinit var updateAppAdapter: UpdateAppAdapter
    lateinit var catAppAdapter: CatAppAdapter
    lateinit var slidersGameAdapter: SlidersGameAdapter
    lateinit var searchAdapter: SearchAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_app_, container, false)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        moreApplication(view)
        newApp(view)
        bestNewApp(view)
        updateApp(view)
        moreAppForYou1(view)
        moreAppForYou2(view)
        moreAppForYou3(view)
        catApp(view)
        getSliders(view)
        search(view)

        return view
    }


    private fun moreApplication(view: View) {

        var moreApplicationRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentApp_moreApp)

        moreApplicationRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)

        viewModel.moreApplication().observe(viewLifecycleOwner, { it ->
            moreAppAdapter = MoreAppAdapter(it) {
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
            moreApplicationRecycler.adapter = moreAppAdapter
        })

    }

    fun newApp(view: View) {

        var newAppRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentApp_newApp)

        newAppRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)

        viewModel.newApp().observe(viewLifecycleOwner, { it ->
            newAppAdapter = NewAppAdapter(it) {
                var bundle = Bundle()
                var detailAppFragment = DetailAppFragment()
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
            newAppRecycler.adapter = newAppAdapter
        })

    }

    private fun bestNewApp(view: View) {

        var bestNewAppRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentApp_bestNew)

        bestNewAppRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)

        viewModel.bestNewApp().observe(viewLifecycleOwner, { it ->

            bestNewAppAdapter = BestNewAppAdapter(it) {

                var bundle = Bundle()
                var detailAppFragment = DetailGameFragment()
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
            bestNewAppRecycler.adapter = bestNewAppAdapter
        })

    }

    private fun updateApp(view: View) {

        var updateAppRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentApp_update)

        updateAppRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)

        viewModel.updateApp().observe(viewLifecycleOwner, { it ->

            updateAppAdapter = UpdateAppAdapter(it) {

                var bundle = Bundle()
                var detailAppFragment = DetailAppFragment()
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
            updateAppRecycler.adapter = updateAppAdapter
        })
    }

    private fun catApp(view: View) {

        var catAppRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentApp_catApp)
        catAppRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel.catApp().observe(viewLifecycleOwner, { it ->

            catAppAdapter = CatAppAdapter(it) {

                var transaction = requireActivity().supportFragmentManager.beginTransaction()
                YoYo.with(Techniques.FadeInDown)
                    .duration(900)
                    .repeat(0)
                    .playOn(requireActivity().findViewById(R.id.fram_parent)); transaction.replace(
                R.id.fram_parent,
                MoreAppForYouFragment()
            )
                transaction.addToBackStack(null)
                transaction.commit()

            }
            catAppRecycler.adapter = catAppAdapter
        })

    }

    private fun getSliders(view: View) {

        var slidersRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentApp_banners)
        slidersRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)

        viewModel.getSliders().observe(viewLifecycleOwner, { it ->

            slidersGameAdapter = SlidersGameAdapter(it)
            slidersRecycler.adapter = slidersGameAdapter

        })

    }

    private fun moreAppForYou1(view: View) {

        var rel = view.findViewById<RelativeLayout>(R.id.rel_fragmentApp_5)!!

        rel.setOnClickListener {
            var transaction = requireActivity().supportFragmentManager.beginTransaction()
            YoYo.with(Techniques.FadeInDown)
                .duration(900)
                .repeat(0)
                .playOn(requireActivity().findViewById(R.id.fram_parent)); transaction.replace(
            R.id.fram_parent,
            MoreAppForYouFragment()
        )
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    private fun moreAppForYou2(view: View) {

        var rel = view.findViewById<RelativeLayout>(R.id.rel_fragmentApp_6)!!

        rel.setOnClickListener {
            var transaction = requireActivity().supportFragmentManager.beginTransaction()
            YoYo.with(Techniques.FadeInDown)
                .duration(900)
                .repeat(0)
                .playOn(requireActivity().findViewById(R.id.fram_parent)); transaction.replace(
            R.id.fram_parent,
            MoreAppForYouFragment()
        )
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    private fun moreAppForYou3(view: View) {

        var rel = view.findViewById<RelativeLayout>(R.id.rel_fragmentApp_7)!!

        rel.setOnClickListener {
            var transaction = requireActivity().supportFragmentManager.beginTransaction()
            YoYo.with(Techniques.FadeInDown)
                .duration(900)
                .repeat(0)
                .playOn(requireActivity().findViewById(R.id.fram_parent)); transaction.replace(
            R.id.fram_parent,
            MoreAppForYouFragment()
        )
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    private fun search(view: View) {

        var edtSearch = view.findViewById<TextView>(R.id.edt_fragmentApp_edtSearch)
//        var searchRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentApp_search)


        edtSearch.setOnClickListener {

            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fram_parent, Search_Fragment())
            transaction.addToBackStack(null)
            transaction.commit()

        }


//        searchRecycler.layoutManager =
//            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//
//
//        //با استفاده از خاصیت addTextChangeListener ادیت تکس سرچ میکنیم
//        edtSearch.addTextChangedListener(object : TextWatcher {
//
//
//            override fun beforeTextChanged(
//                s: CharSequence?,
//                start: Int,
//                count: Int,
//                after: Int
//            ) {
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                viewModel.search(s.toString()).observe(viewLifecycleOwner, { it ->
//                    searchAdapter = SearchAdapter(it) {
//
//                        var detailFragment = DetailGameFragment()
//                        var bundle = Bundle()
//                        bundle.putParcelable("id", it)
//                        detailFragment.arguments = bundle
//
//                        var transaction =
//                            requireActivity().supportFragmentManager.beginTransaction()
//                        YoYo.with(Techniques.FadeInDown)
//                            .duration(900)
//                            .repeat(0)
//                            .playOn(requireActivity().findViewById(R.id.fram_parent))
//                        transaction.replace(R.id.fram_parent, detailFragment)
//                        transaction.addToBackStack(null)
//                        transaction.commit()
//
//                    }
//                    searchRecycler.adapter = searchAdapter
//                    searchAdapter.notifyDataSetChanged()
//
//                })
//            }
//
//        })
    }

}