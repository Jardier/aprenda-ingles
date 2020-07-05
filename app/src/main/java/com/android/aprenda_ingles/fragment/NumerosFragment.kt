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

/**
 * A simple [Fragment] subclass.
 */
class NumerosFragment : Fragment(), OnClickListener {

    lateinit var btnUm : ImageButton;
    lateinit var btnDois : ImageButton;
    lateinit var btnTres : ImageButton;
    lateinit var btnQuatro : ImageButton;
    lateinit var btnCinco : ImageButton;
    lateinit var btnSeis : ImageButton;
    lateinit var mediaPlayer: MediaPlayer;


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_numeros, container, false);

        btnUm = view.findViewById(R.id.btnUm);
        btnDois = view.findViewById(R.id.btnDois);
        btnTres = view.findViewById(R.id.btnTres);
        btnQuatro = view.findViewById(R.id.btnQuatro);
        btnCinco = view.findViewById(R.id.btnCinco);
        btnSeis = view.findViewById(R.id.btnSeis);

        //Ação de click nos Botões
        btnUm.setOnClickListener(this);
        btnDois.setOnClickListener(this);
        btnTres.setOnClickListener(this);
        btnQuatro.setOnClickListener(this);
        btnCinco.setOnClickListener(this);
        btnSeis.setOnClickListener(this);

        return view;
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnUm -> this.executarSom(R.raw.one);
            R.id.btnDois -> this.executarSom(R.raw.two);
            R.id.btnTres -> this.executarSom(R.raw.three);
            R.id.btnQuatro -> this.executarSom(R.raw.four);
            R.id.btnCinco -> this.executarSom(R.raw.five);
            R.id.btnSeis -> this.executarSom(R.raw.six);
            else -> {
                Log.e("Erro:", "Ocorreu um erro ao executar a ação")}
        }
    }

    private fun executarSom(som: Int) {
        mediaPlayer = MediaPlayer.create(activity, som);
        mediaPlayer.start();

        //Ao completar liberar o recurso
        mediaPlayer.setOnCompletionListener({mp -> mp.release()})
    }
}
