package com.gmail.wiryanatha.agus.kpkrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gmail.wiryanatha.agus.kpkrecyclerview.adapter.PelangganAdapter
import com.gmail.wiryanatha.agus.kpkrecyclerview.model.Pelanggan
import kotlinx.android.synthetic.main.activity_camera.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.alamat
import kotlinx.android.synthetic.main.activity_main.gardu
import kotlinx.android.synthetic.main.activity_main.idpel
import kotlinx.android.synthetic.main.activity_main.nama
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select


class MainActivity : AppCompatActivity() {

    // buat variable unntuk menampung data pelanggan
    var listPlg = mutableListOf<Pelanggan>()
    val adapterPlg = PelangganAdapter(listPlg)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // memanggil init tampilan
        initTampilan()

        //tambahkan data kedalam variabel listplg, sementara di offkan karena langsung dari db

        //listPlg.add(Pelanggan("441234567890","Pelanggan A","Mataram","R1",900,"SL001","A1B2C3D4","0811111111"))
        //listPlg.add(Pelanggan("441234567890","Pelanggan B","Mataram","R1",1300,"SL002","A1B2C3D4","08222222222"))
        //listPlg.add(Pelanggan("441234567890","Pelanggan C","Mataram","I3",197000,"SL003","A1B2C3D4","0333333333333"))
        //listPlg.add(Pelanggan("441234567890","Pelanggan D","Mataram","B1",4400,"SL004","A1B2C3D4","0844444444444"))
        //listPlg.add(Pelanggan("441234567890","Pelanggan E","Mataram","S2",450,"SL005","A1B2C3D4","0855555555555"))
        //listPlg.add(Pelanggan("441234567890","Pelanggan F","Mataram","LB2",5555000,"SL006","A1B2C3D4","08666666666"))
        //listPlg.add(Pelanggan("441234567890","Pelanggan G","Mataram","B2",13200,"SL001","A1B2C3D4","081111111111"))

        // masukkan data pelanggan  ke Recycler View
        rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PelangganAdapter(listPlg)
        }

         cameraBtn.setOnClickListener {
             val cameraIntent = Intent (this,CameraActivity::class.java)
             startActivity(cameraIntent)
         }

    }

    fun initTampilan() {
        btnsimpan.setOnClickListener {
            database.use {
//                insert(
//                    "pelanggan",
//                    "idpel" to idpel.text.toString(),
//                    "nama" to nama.text.toString(),
//                    "alamat" to alamat.text.toString(),
//                    "tarif" to tarif.text.toString(),
//                    "daya" to daya.text.toString(),
//                    "gardu" to gardu.text.toString(),
//                    "tiang" to tiang.text.toString(),
//                    "notelp" to notelp.text.toString()
//                )

                insert(
                    "pelanggan",
                    "idpel" to idpel.text.toString(),
                    "idpel" to idpel.text.toString(),
                    "nama" to nama.text.toString(),
                    "alamat" to alamat.text.toString(),
                    "tarif" to tarif.text.toString(),
                    "daya" to daya.text.toString(),
                    "gardu" to gardu.text.toString(),
                    "tiang" to tiang.text.toString(),
                    "notelp" to notelp.text.toString()

                )
                listPlg.add(Pelanggan(
                    idpel.text.toString(),
                    nama.text.toString(),
                    alamat.text.toString(),
                    tarif.text.toString(),
                    daya.text.toString(),
                    gardu.text.toString(),
                    tiang.text.toString(),
                    notelp.text.toString()
                ))
                //refresh recycler view, agar data yang baru di insert
                // langsung muncul
                adapterPlg.notifyDataSetChanged()
            }
        }
    }

    override fun onResume() {
        bacaDatabase()
        super.onResume()
    }

    private fun bacaDatabase() {
        database.use {
                select("pelanggan").exec{
                listPlg.clear()
                    while(this.moveToNext()){
                        listPlg.add(
                            Pelanggan(
                            getString(getColumnIndex("idpel")),
                            getString(getColumnIndex("nama")),
                            getString(getColumnIndex("alamat")),
                            getString(getColumnIndex("tarif")),
                            getString(getColumnIndex("daya")),
                            getString(getColumnIndex("gardu")),
                            getString(getColumnIndex("tiang")),
                            getString(getColumnIndex("notelp"))

                        )
                        )
                    }
                    adapterPlg.notifyDataSetChanged()
            }
        }

    }
}

