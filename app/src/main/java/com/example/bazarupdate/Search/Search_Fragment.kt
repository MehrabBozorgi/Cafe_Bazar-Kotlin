package com.example.bazarupdate.Search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.bazarupdate.Game.Other.DetailGameFragment
import com.example.bazarupdate.MVVM.ViewModel
import com.example.bazarupdate.R


class Search_Fragment : Fragment() {

    lateinit var viewModel: ViewModel
    lateinit var searchAdapter: SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_search_, container, false)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        search(view)

        return view
    }

    fun search(view: View) {
        var edtSearch = view.findViewById<EditText>(R.id.edt_search_edtSearch)
        var searchRecycler = view.findViewById<RecyclerView>(R.id.rv_searchFragment_search)
        searchRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        //با استفاده از خاصیت addTextChangeListener ادیت تکس سرچ میکنیم
        edtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable?) {

                viewModel.search(s.toString()).observe(viewLifecycleOwner, { it ->
                    searchAdapter = SearchAdapter(it) {

                        var detailFragment = DetailGameFragment()
                        var bundle = Bundle()
                        bundle.putParcelable("id", it)
                        detailFragment.arguments = bundle

                        var transaction = requireActivity().supportFragmentManager.beginTransaction()
                        YoYo.with(Techniques.FadeInDown)
                            .duration(900)
                            .repeat(0)
                            .playOn(requireActivity().findViewById(R.id.fram_parent));
                        transaction.replace(R.id.fram_parent, detailFragment)
                        transaction.addToBackStack(null)
                        transaction.commit()

                    }
                    searchRecycler.adapter = searchAdapter
                    searchAdapter.notifyDataSetChanged()

                })
            }
        })

    }
}