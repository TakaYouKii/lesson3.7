package com.example.lesson37

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lesson37.databinding.FragmentCharactersBinding


class CharactersFragment : Fragment() {

    private lateinit var binding: FragmentCharactersBinding
    private var characterList = arrayListOf<Character>(
        Character("https://cdn4.whatculture.com/images/2018/10/5c1802e5135089a1-600x338.png", "Rick Sanchez", "Alive"),
        Character("https://static.tvtropes.org/pmwiki/pub/images/morty_smith_2.png", "Morty Smith", "Alive"),
        Character("https://cdn.costumewall.com/wp-content/uploads/2017/10/summer-smith.jpg", "Summer Smith", "Alive"),
        Character("https://www.looper.com/img/gallery/the-worst-thing-thats-ever-happened-to-jerry-on-rick-and-morty/intro-1567519981.jpg", "Jerry Smith", "Alive"),
        Character("https://static.wikia.nocookie.net/villains/images/0/07/RickerHD.jpg/revision/latest?cb=20170825132103.jpg", "Prince Nebulon", "Dead"),
        Character("https://static.wikia.nocookie.net/rickandmorty/images/1/1e/S1e7_funny_daddy.png/revision/latest?cb=20160917044623.jpg", "Morty Jr.", "Dead"),
        Character("https://static.wikia.nocookie.net/xianb/images/1/1b/Vagina.png/revision/latest?cb=20141016030952.jpg", "Principal Gene", "Dead"),

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharactersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CharacterAdapter(characterList, this::onItemClick)
        binding.rvCharacter.adapter = adapter

    }

    private fun onItemClick(i: Int) {
        findNavController().navigate(R.id.detailFragment, bundleOf("rick" to characterList[i]))
    }
}