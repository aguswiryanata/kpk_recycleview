package com.gmail.wiryanatha.agus.kpkrecyclerview.viewholdel

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gmail.wiryanatha.agus.kpkrecyclerview.R
import com.gmail.wiryanatha.agus.kpkrecyclerview.model.Pelanggan

class PelangganViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(
        inflater.inflate(R.layout.item_pelanggan, parent, false)

//deklarasi variable untuk memegang komponen yang ada pada layout


    ) {
    var idpel: TextView? = null
    var nama: TextView? = null
    var alamat: TextView? = null
    var trfdya: TextView? = null
    var gardu: TextView? = null
    var tiang: TextView? = null
    var notelp: TextView? = null

    // ambil komponen dari layout, masukkan ke variable
    init {
        idpel = itemView.findViewById(R.id.idpel)
        nama = itemView.findViewById(R.id.nama)
        alamat = itemView.findViewById(R.id.alamat)
        trfdya = itemView.findViewById(R.id.trfdya)
        gardu = itemView.findViewById(R.id.gardu)
        tiang = itemView.findViewById(R.id.tiang)
        notelp = itemView.findViewById(R.id.notelp)
    }

    //binding data Pelanggan ke komponen (yang sudah dimasukkan variable
    fun bind(data: Pelanggan) {
        idpel?.text = data.idpel
        nama?.text = data.nama
        alamat?.text = data.alamat
        trfdya?.text = "${data.tarif} / ${data.daya} VA"
        gardu?.text = data.gardu
        tiang?.text = data.tiang
        notelp?.text = data.notelp
    }
}