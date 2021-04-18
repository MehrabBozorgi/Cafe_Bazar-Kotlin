package com.example.bazarupdate.Profile.Other

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bazarupdate.Profile.Adapter.SignedAdapter
import com.example.bazarupdate.R
import com.example.bazarupdate.Room.RoomViewModel


class SignedFragment : Fragment() {

    lateinit var viewModel: RoomViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_signed, container, false)
        viewModel = ViewModelProvider(this).get(RoomViewModel::class.java)

        savedList(view)

        return view
    }

    fun savedList(view: View) {

        var recyclerView = view.findViewById<RecyclerView>(R.id.rv_signedFragment_signed)
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, true)

        viewModel.getAllCourse().observe(viewLifecycleOwner, { it ->

            recyclerView.adapter = SignedAdapter(it) {

//                var detailFragment = DetailFragment()
//                var bundle = Bundle()
//                var moreGame = MoreGame(it.id, it.icon, it.name, it.kind, it.description, it.size, it.download, it.version)
//                bundle.putParcelable("id", moreGame)
//                detailFragment.arguments = bundle
//
//                var transaction = requireActivity().supportFragmentManager.beginTransaction()
//                YoYo.with(Techniques.FadeInDown)
//                    .duration(900)
//                    .repeat(0)
//                    .playOn(requireActivity().findViewById(R.id.fram_parent));
//                transaction.replace(R.id.fram_parent, detailFragment)
//                transaction.addToBackStack(null)
//                transaction.commit()


            }
        })

    }


}