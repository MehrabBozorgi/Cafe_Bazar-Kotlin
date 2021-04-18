package com.example.bazarupdate.Profile.Other

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.bazarupdate.MVVM.ViewModel
import com.example.bazarupdate.Profile.Profile_Fragment
import com.example.bazarupdate.R
import kotlinx.android.synthetic.main.fragment_login.*
import java.util.regex.Pattern

////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
//فرگمنتی که در اون با شریت پریفرنس رو ایجاد می کنیم
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////

class LoginFragment : Fragment() {

    lateinit var viewModel: ViewModel
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_login, container, false)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        login(view)
        return view
    }

    fun login(view: View) {

        var edtEmail = view.findViewById<EditText>(R.id.edt_login_email)
        var edtPass = view.findViewById<EditText>(R.id.edt_login_pass)
        var btnEnter = view.findViewById<Button>(R.id.btn_login_enter)

        //شرط میذاریم برای اینکه وقتی که مخوایم اطلاعات رو توی ادیت تکس ریختیم
        btnEnter.setOnClickListener {
            if (!isEmailValid(edtEmail.text.toString()) || edtEmail.text.length > 50 ||
                edtEmail.text.isEmpty() || edtPass.text.isEmpty() || edtPass.text.length < 5
            ) {
                Toast.makeText(context, "ایمیل یا نام کاربری نادرست است", Toast.LENGTH_SHORT).show()
                rel_fragment_login_parent.visibility = View.VISIBLE
            } else {
                viewModel.getSignUp(edtEmail.toString(), edtPass.toString())
                    .observe(viewLifecycleOwner, { it ->
                        Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                    })

                sharedPreferences =
                    requireContext().getSharedPreferences("account", Context.MODE_PRIVATE)
                var editor = sharedPreferences.edit()
                editor.putString("email", edtEmail.toString())
                editor.apply()

                rel_fragment_login_parent.visibility = View.GONE
                var transaction = requireActivity().supportFragmentManager.beginTransaction()
                YoYo.with(Techniques.FadeInDown)
                    .duration(900)
                    .repeat(0)
                    .playOn(requireActivity().findViewById(R.id.fram_parent));
                transaction.replace(R.id.fram_parent, Profile_Fragment())
                transaction.commit()
            }
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }

}