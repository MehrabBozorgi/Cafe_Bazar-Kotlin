package com.example.bazarupdate.Game.Other

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.bazarupdate.Game.GameAdapter.CommentGameAdapter
import com.example.bazarupdate.Game.GameAdapter.ExtraGameAdapter
import com.example.bazarupdate.Game.GameAdapter.SlideGameAdapter
import com.example.bazarupdate.MVVM.ViewModel
import com.example.bazarupdate.Model.App_Game.GetComment
import com.example.bazarupdate.Model.App_Game.MoreGame
import com.example.bazarupdate.Game.Game_Fragment
import com.example.bazarupdate.R
import com.example.bazarupdate.Room.RCourse
import com.example.bazarupdate.Room.RoomViewModel
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.concurrent.timerTask

class DetailGameFragment : Fragment() {

    private lateinit var viewModel: ViewModel
    private lateinit var downloadManager: DownloadManager
    lateinit var sharedPreferences: SharedPreferences
    private lateinit var request: DownloadManager.Request
    lateinit var bundleMoreGame: MoreGame
    lateinit var comment: List<GetComment>
    lateinit var commentGameAdapter: CommentGameAdapter
    lateinit var extraGameAdapter: ExtraGameAdapter
    lateinit var slides: List<String>
    lateinit var txtName: TextView
    lateinit var timer: Timer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_detail, container, false)

        var bundle = arguments
        bundleMoreGame = bundle!!.getParcelable<MoreGame>("id")!!

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        sharedPreferences =
            requireContext().getSharedPreferences("account", Context.MODE_PRIVATE)

        getAll(view)
        getDesc(view)
        AllMore(view)
        getComment(view)
        extraGame(view)
        back(view)
        share(view)
        download(view)
        checkLoginGame(view)

        return view
    }

    @SuppressLint("SetTextI18n")
    fun getAll(view: View) {

        var txtKind = view.findViewById<TextView>(R.id.txt_fragmentDetail_kind)
        var txtDownload = view.findViewById<TextView>(R.id.txt_fragmentDetail_download)
        var txtSize = view.findViewById<TextView>(R.id.txt_fragmentDetail_size)
        var txtName = view.findViewById<TextView>(R.id.txt_fragmentDetail_name)
        var txtCat = view.findViewById<TextView>(R.id.txt_fragmentDetail_cat)
        var txtDeveloperName = view.findViewById<TextView>(R.id.txt_fragmentDetail_developerName)
        var txtComment = view.findViewById<TextView>(R.id.txt_fragmentDetail_comment)
        var txtDesc = view.findViewById<TextView>(R.id.txt_fragmentDetail_desc)
        var txtEmail = view.findViewById<TextView>(R.id.txt_fragmentDetail_developerEmail)
        var txtPhone = view.findViewById<TextView>(R.id.txt_fragmentDetail_developerphone)
        var txtWeb = view.findViewById<TextView>(R.id.txt_fragmentDetail_developerWeb)
        var rel = view.findViewById<RelativeLayout>(R.id.rel_fragmentDetail_developerInformation3)
        var imgIcon = view.findViewById<ImageView>(R.id.img_fragmentDetail_icon)


        txtKind.text = bundleMoreGame.kind
        txtDownload.text = bundleMoreGame.download + "هزار "
        txtSize.text = bundleMoreGame.size + " مگابایت"
        txtName.text = bundleMoreGame.name
        txtCat.text = bundleMoreGame.cat
        txtDeveloperName.text = bundleMoreGame.developer_name
        txtComment.text = "100+ " + "بیشتر"
        txtDesc.text = bundleMoreGame.description
        txtPhone.text = bundleMoreGame.developer_phone
        txtEmail.text = bundleMoreGame.developer_email
        txtWeb.text = bundleMoreGame.developer_web
        Picasso.get().load(bundleMoreGame.icon).into(imgIcon)

        if (!txtWeb.text.isEmpty()) {

            rel.visibility = View.VISIBLE
        }

    }

    //دکمه ی بیشتر برای دیدن توضیحات
    private fun getDesc(view: View) {
        var cardMore = view.findViewById<RelativeLayout>(R.id.card_fragmentDetail_more)
        cardMore.setOnClickListener {
            var bundle1 = Bundle()
            var descFragment = DescGameFragment()
            bundle1.putParcelable("desc", bundleMoreGame)
            descFragment.arguments = bundle1
            var transaction = requireActivity().supportFragmentManager.beginTransaction()
            YoYo.with(Techniques.FadeInDown)
                .duration(900)
                .repeat(0)
                .playOn(requireActivity().findViewById(R.id.fram_parent)); transaction.replace(
            R.id.fram_parent,
            descFragment
        )
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    //  اسلاید ریسایکلر ویو تصویرهای ورقه ای
    private fun AllMore(view: View) {
        var slideRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentDetail_slide)
        slideRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        viewModel.AllMore(bundleMoreGame.id).observe(viewLifecycleOwner, { it ->

            slides = it.slide
            slideRecycler.adapter = SlideGameAdapter(slides)
        })

    }

    //کامنتها رو دریافت می کنه
    private fun getComment(view: View) {
        var commentRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentDetail_comment)
        commentRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
        viewModel.getComment(bundleMoreGame.id).observe(viewLifecycleOwner, { it ->

            comment = it.comment
            commentGameAdapter = CommentGameAdapter(comment)
            commentRecycler.adapter = commentGameAdapter
        })

    }

    //یه ریسایکلرویو پایین اطلاعات
    private fun extraGame(view: View) {

        var extraGameRecycler = view.findViewById<RecyclerView>(R.id.rv_fragmentDetail_extra)
        extraGameRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        viewModel.extraGame().observe(viewLifecycleOwner, { it ->
            extraGameAdapter = ExtraGameAdapter(it) {
                val detailFragment = DetailGameFragment()
                val bundle = Bundle()
                bundle.putParcelable("id", it)
                detailFragment.arguments = bundle

                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                YoYo.with(Techniques.FadeInDown)
                    .duration(900)
                    .repeat(0)
                    .playOn(requireActivity().findViewById(R.id.fram_parent));
                transaction.replace(R.id.fram_parent, detailFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
            extraGameRecycler.adapter = extraGameAdapter
        })
    }

    //اون فلشه زدیم روش برگردیم عقب
    private fun back(view: View) {

        var imgBack = view.findViewById<ImageView>(R.id.img_fragmentDetail_back)
        imgBack.setOnClickListener {

            var transaction = requireActivity().supportFragmentManager.beginTransaction()
            YoYo.with(Techniques.FadeInDown)
                .duration(900)
                .repeat(0)
                .playOn(requireActivity().findViewById(R.id.fram_parent));
            transaction.replace(
                R.id.fram_parent, Game_Fragment()
            )
            transaction.commit()

        }

    }

    //لینک اشتراک گذاری بده
    private fun share(view: View) {

        var imgShare = view.findViewById<ImageView>(R.id.img_fragmentDetail_share)

        imgShare.setOnClickListener {

            var intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "https://www.instagram.com/mehrab.code/"
            )

            startActivity(Intent.createChooser(intent, "انتشار اپلیکیشن"))

        }

    }

    //برای دکمهه که دانلود کنه
    private fun download(view: View) {
        var btnSetup = view.findViewById<Button>(R.id.btn_fragmentDetail_install)
        var progressBar = view.findViewById<ProgressBar>(R.id.progress_fragmentDetail_progressBar)

        if (btnSetup.isClickable) {
            btnSetup.setOnClickListener {
                Toast.makeText(context, "در حال دریافت ...", Toast.LENGTH_SHORT).show()
                btnSetup.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
                var link =
                    "https://www.dl.farsroid.com/ap/WhatsApp-Messenger-2.20.205.16+x86_64(www.farsroid.com).apk"
                var progressBar =
                    view.findViewById<ProgressBar>(R.id.progress_fragmentDetail_progressBar)
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
                            progressBar.progress = percent
                            when (status) {
                                DownloadManager.STATUS_SUCCESSFUL -> {
                                    Toast.makeText(
                                        context,
                                        " دانلود با موفقیت انجام شد",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    timer.purge()
                                    timer.cancel()
                                    progressBar.visibility = View.GONE
                                    btnSetup.text = "نصب"
                                }
                            }
                        }
                    }
                }, 0, 1000)
            }


        }


    }

    //در متد چک می کنیم که اگه توی حساب کاربری بودش میتونه سیو کنه و امتیاز بده
    private fun checkLoginGame(view: View) {

        var ratingBar = view.findViewById<RatingBar>(R.id.ratingBar)
        var linear_rating = view.findViewById<LinearLayout>(R.id.linear_rating)
        var roomViewModel = ViewModelProvider(this).get(RoomViewModel::class.java)
        var imgSaveEmpty = view.findViewById<ImageView>(R.id.save_detailGame)

        //چک می کنیم که توی حساب هست یا نه اگه بودش میتونه رای بده و سیو کنه
        var email = sharedPreferences.getString("email", "")
        if (!email!!.equals("")) {

            ratingBar.visibility = View.VISIBLE
            //دستور پایین برای سیو کردنه
            roomViewModel.getSignCourse(bundleMoreGame.name).observe(viewLifecycleOwner, { it ->

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
                        bundleMoreGame.id.toInt(),
                        bundleMoreGame.icon,
                        bundleMoreGame.name,
                        bundleMoreGame.size,

                        )
                    roomViewModel.deleteCourse(rCourse)
                    Toast.makeText(
                        context,
                        "بازی از لیست علاقه مندی ها حذف شد",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else {
                    var rCourse = RCourse(
                        bundleMoreGame.id.toInt(),
                        bundleMoreGame.icon,
                        bundleMoreGame.name,
                        bundleMoreGame.size,
                    )
                    roomViewModel.insert(rCourse)
                    Toast.makeText(
                        context,
                        "بازی به لیست علاقه مندی ها اضافه شد",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }


            }

            //این دستور برای ثبت رای هستش
            ratingBar.visibility = View.VISIBLE
            linear_rating.visibility = View.GONE
            ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
                Toast.makeText(context, ":رای شما ثبت گردید" + rating, Toast.LENGTH_SHORT).show()

            }


        } else {
            //میگه اگه توی حساب نبود پیغام بده
            imgSaveEmpty.setOnClickListener {
                Toast.makeText(context, "وارد حساب کاربری شوید", Toast.LENGTH_SHORT).show()
            }

            linear_rating.setOnClickListener {

                Toast.makeText(context, "وارد حساب کاربری شوید", Toast.LENGTH_SHORT).show()


            }

        }


    }


}
