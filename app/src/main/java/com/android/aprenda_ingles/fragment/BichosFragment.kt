package com.android.aprenda_ingles.fragment


import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageButton

import com.android.aprenda_ingles.R
import kotlinx.android.synthetic.main.fragment_bichos.view.*

/**
 * A simple [Fragment] subclass.
 */
class BichosFragment : Fragment(), OnClickListener {

    lateinit var btnCao : ImageButton;
    lateinit var btnGato : ImageButton;
    lateinit var btnLeao : ImageButton;
    lateinit var btnMacaco : ImageButton;
    lateinit var btnOvelha : ImageButton;
    lateinit var btnVaca : ImageButton;
    lateinit var mediaPlayer : MediaPlayer;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bichos, container, false)

        btnCao = view.findViewById(R.id.btnCao)
        btnGato = view.findViewById(R.id.btnGato)
        btnLeao = view.findViewById(R.id.btnLeao)
        btnMacaco = view.findViewById(R.id.btnMacaco)
        btnOvelha = view.findViewById(R.id.btnOvelha)
        btnVaca = view.findViewById(R.id.btnVaca)

        //Criando evento de Click
        btnCao.setOnClickListener(this)
        btnGato.setOnClickListener(this)
        btnLeao.setOnClickListener(this)
        btnMacaco.setOnClickListener(this)
        btnOvelha.setOnClickListener(this)
        btnVaca.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {

        when(v?.id) {
            R.id.btnCao -> {mediaPlayer = MediaPlayer.create(activity, R.raw.dog); this.tocarSom();};
            R.id.btnGato -> {mediaPlayer = MediaPlayer.create(activity, R.raw.cat); this.tocarSom()};
            R.id.btnLeao ->{mediaPlayer = MediaPlayer.create(activity, R.raw.lion); this.tocarSom()};
            R.id.btnMacaco -> {mediaPlayer = MediaPlayer.create(activity, R.raw.monkey); this.tocarSom()};
            R.id.btnOvelha -> {mediaPlayer = MediaPlayer.create(activity, R.raw.sheep); this.tocarSom()};
            R.id.btnVaca -> {mediaPlayer = MediaPlayer.create(activity, R.raw.cow); this.tocarSom()}
            else -> Log.e("Erro: ", "Não foi encontrado o botão desejado");
        }
    }

    private fun tocarSom() {
        mediaPlayer?.start();
        mediaPlayer.setOnCompletionListener { mp ->  mp.release()}
    }

}
