package com.example.lesson37

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson37.Character
import com.example.lesson37.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var characterData: Character

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characterData = arguments?.getSerializable("rick") as Character
        characterData.image?.let { binding.imgDetail.loadImage(it) }
        binding.tvDetailIsAlive.text = characterData.isAlive
        binding.tvDetailName.text = characterData.name

    }




}