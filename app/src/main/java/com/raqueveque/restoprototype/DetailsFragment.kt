package com.raqueveque.restoprototype

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_details, container, false)

        val name: TextView = view.findViewById(R.id.name)
        name.text = "${arguments?.getString("name")}"
        val image: ImageView = view.findViewById(R.id.image)
        Glide.with(requireContext()).load(arguments?.getString("image")).into(image)
        val price: TextView = view.findViewById(R.id.price)
        price.text = arguments?.getString("price")
        val description: TextView = view.findViewById(R.id.description)
        description.text = arguments?.getString("description")

        return view
    }

}