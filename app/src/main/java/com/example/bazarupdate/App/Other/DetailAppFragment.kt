package com.example.bazarupdate.App.Other

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.bazarupdate.App.AppAdapter.CommentAppAdapter
import com.example.bazarupdate.App.AppAdapter.ExtraAppAdapter
import com.example.bazarupdate.App.AppAdapter.SlideAppAdapter
import com.example.bazarupdate.MVVM.ViewModel
import com.example.bazarupdate.Model.App_Game.GetComment
import com.example.bazarupdate.Model.App_Game.MoreGame
import com.example.bazarupdate.App.App_Fragment
import com.example.bazarupdate.R
import com.example.bazarupdate.Room.RCourse
import com.example.bazarupdate.Room.RoomViewModel
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.concurrent.timerTask


class DetailAppFragment : Fragment() {

    private lateinit var viewModel: ViewModel
    private lateinit var downloadManager: DownloadManager
    lateinit var sharedPreferences: SharedPreferences
    private lateinit var request: DownloadManager.Request
    lateinit var bundleMoreApp: MoreGame
    lateinit var comment: List<GetComment>
    lateinit var commentAppAdapter: CommentAppAdapter
    lateinit var extraAppAdapter: ExtraAppAdapter
    lateinit var slides: List<String>
    lateinit var txtName: TextView
    lateinit var timer: Timer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_detail_app, container, false)
        var bundle = arguments
        bundleMoreApp = bundle!!.getParcelable<MoreGame>("id")!!
        sharedPreferences =
            requireContext().getSharedPreferences("account", Context.MODE_PRIVATE)

        viewModel = ViewModelProvider(this).get(
            ViewModel::
            class.java
        )

        getAllApp(view)
        getDescApp(view)
        AllMoreApp(view)
        getCommentApp(view)
        extraApp(view)
        backApp(view)
        shareApp(view)
        downloadApp(view)
        checkLoginApp(view)

        return view
    }

    @SuppressLint("SetTextI18n")
    private fun getAllApp(view: View) {

        val txtKind = view.findViewById<TextView>(R.id.txt_fragmentDetailApp_kind)
        val txtDownload = view.findViewById<TextView>(R.id.txt_fragmentDetailApp_download)
        val txtSize = view.findViewById<TextView>(R.id.txt_fragmentDetailApp_size)
        val txtName = view.findViewById<TextView>(R.id.txt_fragmentDetailApp_name)
        val txtCat = view.findViewById<TextView>(R.id.txt_fragmentDetailApp_cat)
        val txtDeveloperName = view.findViewById<TextView>(R.id.txt_fragmentDetailApp_developerName)
        val txtComment = view.findViewById<TextView>(R.id.txt_fragmentDetailApp_comment)
        val txtDesc = view.findViewById<TextView>(R.id.txt_fragmentDetailApp_desc)
        val txtEmail = view.findViewById<TextView>(R.id.txt_fragmentDetailApp_developerEmail)
        val txtPhone = view.findViewById<TextView>(R.id.txt_fragmentDetailApp_developerphone)
        val txtWeb = view.findViewById<TextView>(R.id.txt_fragmentDetailApp_developerWeb)
        val rel =
            view.findViewById<RelativeLayout>(R.id.rel_fragmentDetailApp_developerInformation3)
        val imgIcon = view.findViewById<ImageView>(R.id.img_fragmentDetailApp_icon)

        txtKind.text = bundleMoreApp.kind
        txtDownload.text = bundleMoreApp.downloads + "هزار "
        txtSize.text = bundleMoreApp.size + " مگابایت"
        txtName.text = bundleMoreApp.name
        txtCat.text = bundleMoreApp.cat
        txtDeveloperName.text = bundleMoreApp.developer_name
        txtComment.text = "100+ " + "بیشتر"
        txtDesc.text = bundleMoreApp.description
        txtPhone.text = bundleMoreApp.developer_phone
        txtEmail.text = bundleMoreApp.developer_email
        txtWeb.text = bundleMoreApp.developer_web
        Picasso.get().load(bundleMoreApp.icon).into(imgIcon)

        if (!txtWeb.text.isEmpty()) {

            rel.visibility = View.VISIBLE
        }

//        var roomViewModel = ViewModelProvider(this).get(RoomViewModel::class.java)
//        var imgSaveEmpty = view.findViewById<ImageView>(R.id.save_emptyApp)
//
//        roomViewModel.getSignCourse(bundleMoreApp.name).observe(viewLifecycleOwner, { it ->
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
//                    bundleMoreApp.id.toInt(),
//                    bundleMoreApp.icon,
//                    bundleMoreApp.name,
//                    bundleMoreApp.size,
//
//                )
//                roomViewModel.deleteCourse(rCourse)
//                Toast.makeText(context, "اپلیکیشن از لیست علاقه مندی ها حذف شد", Toast.LENGTH_SHORT)
//                    .show()
//            } else {
//                var rCourse = RCourse(
//                    bundleMoreApp.id.toInt(),
//                    bundleMoreApp.icon,
//                    bundleMoreApp.name,
//                    bundleMoreApp.size,
//                )
//                roomViewModel.insert(rCourse)
//                Toast.makeText(context, "اپلیکیشن به لیست علاقه مندی ها اضافه شد", Toast.LENGTH_SHORT)
//                    .show()
//            }
//
//        }
//

    }

    //دکمه ی بیشتر برای دیدن توضیحات
    private fun getDescApp(view: View) {
        var cardMoreApp = view.findViewById<RelativeLayout>(R.id.card_fragmentDetailApp_more)
        cardMoreApp.setOnClickListener {
            var bundle1 = Bundle()
            var descAppFragment = DescAppFragment()
            bundle1.putParcelable("desc", bundleMoreApp)
            descAppFragment.arguments = bundle1
            var transaction = requireActivity().supportFragmentManager.beginTransaction()
            YoYo.with(Techniques.FadeInDown)
                .duration(900)
                .repeat(0)
                .playOn(requireActivity().findViewById(R.id.fram_parent));
            transaction.replace(R.id.fram_parent, descAppFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    //اسلاید ریسایکلر ویو
    private fun AllMoreApp(view: View) {
        val slideRecyclerApp = view.findViewById<RecyclerView>(R.id.rv_fragmentDetailApp_slide)
        slideRecyclerApp.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        viewModel.AllMoreApp(bundleMoreApp.id).observe(viewLifecycleOwner, { it ->

            slides = it.slide
            slideRecyclerApp.adapter = SlideAppAdapter(slides)
        })
    }

    //کامنتها
    private fun getCommentApp(view: View) {
        val commentAppRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentDetailApp_comment)
        commentAppRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
        viewModel.getCommentApp(bundleMoreApp.id).observe(viewLifecycleOwner, { it ->

            comment = it.comment
            commentAppAdapter = CommentAppAdapter(comment)
            commentAppRecycler.adapter = commentAppAdapter
        })

    }

    private fun extraApp(view: View) {
        val extraAppRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentDetailApp_extra)
        extraAppRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        viewModel.extraApp().observe(viewLifecycleOwner, { it ->
            extraAppAdapter = ExtraAppAdapter(it) {

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
            extraAppRecycler.adapter = extraAppAdapter
        })
    }

    private fun backApp(view: View) {

        val imgBackApp = view.findViewById<ImageView>(R.id.img_fragmentDetailApp_back)
        imgBackApp.setOnClickListener {

            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            YoYo.with(Techniques.FadeInDown)
                .duration(900)
                .repeat(0)
                .playOn(requireActivity().findViewById(R.id.fram_parent));
            transaction.replace(
                R.id.fram_parent, App_Fragment()
            )
            transaction.commit()

        }

    }

    private fun shareApp(view: View) {

        val imgShareApp = view.findViewById<ImageView>(R.id.img_fragmentDetailApp_share)

        imgShareApp.setOnClickListener {

            var intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "https://www.instagram.com/mehrab.code/"
            )

            startActivity(Intent.createChooser(intent, "انتشار اپلیکیشن"))

        }

    }

    private fun downloadApp(view: View) {
        var btnSetupApp = view.findViewById<Button>(R.id.btn_fragmentDetailApp_install)
        var progressBarApp =
            view.findViewById<ProgressBar>(R.id.progress_fragmentDetailApp_progressBar)

        if (btnSetupApp.isClickable) {
            btnSetupApp.setOnClickListener {
                Toast.makeText(context, "در حال دریافت ...", Toast.LENGTH_SHORT).show()
                btnSetupApp.visibility = View.GONE
                progressBarApp.visibility = View.VISIBLE
                var link =
                    "https://www.dl.farsroid.com/ap/WhatsApp-Messenger-2.20.205.16+x86_64(www.farsroid.com).apk"
                var progressBarApp =
                    view.findViewById<ProgressBar>(R.id.progress_fragmentDetailApp_progressBar)
                downloadManager =
                    requireContext().getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
                var fileUri = Uri.parse(link)
                request = DownloadManager.Request(fileUri)
                request.setTitle("درحال دانلود...")
                request.setDescription("لطفا منتظر بمانبد")
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                request.setAllowedOverMetered(true)
//                var fileName = link.substring(link.lastIndexOf("/"))
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE or DownloadManager.Request.NETWORK_WIFI)
                var id: Long = downloadManager.enqueue(request)
                timer = Timer()
                timer.schedule(timerTask {
                    var query = DownloadManager.Query()
                    query.setFilterById(id)
                    var cursor: Cursor
                    cursor = downloadManager.query(query)
                    if (cursor.moveToFirst()) {
                        val downloadedBytes =
                            cursor.getLong(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR))
                        val totalBytes =
                            cursor.getLong(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES))
                        val status =
                            cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS))
                        val percent = (downloadedBytes * 100 / totalBytes).toInt()
                        requireActivity().runOnUiThread {
                            progressBarApp.progress = percent
                            when (status) {
                                DownloadManager.STATUS_SUCCESSFUL -> {
                                    Toast.makeText(
                                        context,
                                        " دانلود با موفقیت انجام شد",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    timer.purge()
                                    timer.cancel()
                                    progressBarApp.visibility = View.GONE
                                    btnSetupApp.text = "نصب"
                                }
                            }
                        }
                    }
                }, 0, 1000)
            }


        }


    }

    private fun checkLoginApp(view: View) {

        var ratingBar = view.findViewById<RatingBar>(R.id.ratingBarApp)
        var linear_ratingApp = view.findViewById<LinearLayout>(R.id.linear_ratingApp)
        var roomViewModel = ViewModelProvider(this).get(RoomViewModel::class.java)
        var imgSaveEmpty = view.findViewById<ImageView>(R.id.save_emptyApp)
        //چک می کنیم که توی حساب هست یا نه اگه بودش میتونه رای بده و سیو کنه
        var email = sharedPreferences.getString("email", "")
        if (!email!!.equals("")) {

            ratingBar.visibility = View.VISIBLE

            //دستور پایین برای سیو کردنه
            roomViewModel.getSignCourse(bundleMoreApp.name).observe(viewLifecycleOwner, { it ->

                if (it != null) {
                    imgSaveEmpty.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.ic_baseline_white
                        )
                    )
                    imgSaveEmpty.tag = "signed"

                }

            })
            imgSaveEmpty.setOnClickListener {
                if (imgSaveEmpty.tag == "signed") {
                    imgSaveEmpty.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.ic_baseline_mark_white
                        )
                    )
                    imgSaveEmpty.tag = "unSigned"

                    var rCourse = RCourse(
                        bundleMoreApp.id.toInt(),
                        bundleMoreApp.icon,
                        bundleMoreApp.name,
                        bundleMoreApp.size,

                        )
                    roomViewModel.deleteCourse(rCourse)
                    Toast.makeText(
                        context,
                        "اپلیکیشن از لیست علاقه مندی ها حذف شد",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else {
                    var rCourse = RCourse(
                        bundleMoreApp.id.toInt(),
                        bundleMoreApp.icon,
                        bundleMoreApp.name,
                        bundleMoreApp.size,
                    )
                    roomViewModel.insert(rCourse)
                    Toast.makeText(
                        context,
                        "اپلیکیشن به لیست علاقه مندی ها اضافه شد",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }


            }

            //این دستور برای ثبت رای هستش
            ratingBar.visibility = View.VISIBLE
            linear_ratingApp.visibility = View.GONE
            ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
                Toast.makeText(context, ":رای شما ثبت گردید" + rating, Toast.LENGTH_SHORT).show()

            }


        } else {
            //میگه اگه توی حساب نبود پیغام بده
            imgSaveEmpty.setOnClickListener {
                Toast.makeText(context, "وارد حساب کاربری شوید", Toast.LENGTH_SHORT).show()
            }

            linear_ratingApp.setOnClickListener {

                Toast.makeText(context, "وارد حساب کاربری شوید", Toast.LENGTH_SHORT).show()

            }


        }


    }

}