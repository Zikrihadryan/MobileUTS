package com.example.zikriuts.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zikriuts.DetailKomikActivity
import com.example.zikriuts.R
import com.example.zikriuts.komikAdapter

class UntukmuFragment : Fragment() {
    private lateinit var adapter: komikAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var komikArrayList: ArrayList<Komik>

    lateinit var image: Array<Int>
    lateinit var detailimage: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>
    lateinit var chapter: Array<String>

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_untukmu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_komik)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = context?.let {
            komikAdapter(it, komikArrayList){
                val intent = Intent(context, DetailKomikActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
        }

    }
    private fun dataInitialize(){
        komikArrayList = arrayListOf<Komik>()

        detailimage = arrayOf(
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.img_9,
        )

        image = arrayOf(
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.img_9,
        )

        title = arrayOf(
            "Real madrid",
            "barcelona",
            "Real sociedad",
            "Real betis",
            "girona",
            "osasuna",
            "Celta vigo",
            "Rayo volcano",
            "elche",
            "getafe",

            )

        description = arrayOf(
            "salah satu klub sepak bola terkaya di dunia dalam hal pendapatan, senilai €757,3 juta dan total aset yang senilai €3,8 miliar (atau \$4,2 miliar) di 2019.",
            "salah satu pusat ekonomi, pariwisata, pameran, olahraga, dan budaya dunia. Semua ini berkat statusnya sebagai salah satu kota global utama dunia",
            "sebuah klub sepak bola Spanyol yang berbasis di kota San Sebastián, Basque, didirikan pada 7 September 1909. ",
            "sepak bola profesional yang berbasis di Sevilla. Real Betis Balompié bermain di La Liga dan menempati posisi ke-10 dalam klasifikasi historik liga Spanyol,",
            "sebuah tim sepak bola Spanyol yang saat ini bermain di La Liga. Klub ini didirikan pada tahun 1930. Saat ini memainkan pertandingan kandangnya di Estadi Montilivi yang berkapasitas 13.450 kursi.",
            "nama tim sepak bola Spanyol yang bermain di Divisi Primera La Liga. Osasuna berbasis di kota Pamplona, Navarre. Didirikan pada tahun 1920, Osasuna berhasil meraih posisi ke-4 di La Liga pada tahun 1991 dan 2006, yang merupakan posisi terbaik mereka sepanjang sejarah klub.",
            "Klub ini memainkan pertandingan kandangnya di Stadion Balaidos yang berkapasitas 31.500 penonton. Seragam mereka berwarna biru langit dan celana putih.",
            "sebuah tim sepak bola Spanyol yang bermain di La Liga. Didirikan pada tahun 1924. Berbasis di Madrid. Klub ini memainkan pertandingan kandangnya di Campo de Fútbol de Vallecas yang berkapasitas 15.500 penonton. ",
            "sebuah kota di Alicante, Spanyol, yang berpenduduk sekitar 228.000 jiwa pada tahun 2008. Kota ini terletak di dekat Laut Tengah",
            "Letaknya di bagian tengah. Tepatnya di wilayah otonomi Madrid. Pada tahun 2006, kota ini memiliki jumlah penduduk sebanyak 156.320 jiwa dengan memiliki luas wilayah 78,74 km². ",

            )

        chapter = arrayOf(
            "Chapter 2",
            "Chapter 5",
            "Chapter 4",
            "Chapter 2",
            "Chapter 6",
            "Chapter 3",
            "Chapter 5",
            "Chapter 4",
            "Chapter 4",
            "Chapter 5",
        )
        for (i in image.indices){
            val komik = Komik(image[i], title[i], description[i], detailimage[i], chapter[i],)
            komikArrayList.add(komik)
        }
    }


}