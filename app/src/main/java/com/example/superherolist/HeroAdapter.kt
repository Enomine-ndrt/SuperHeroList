package com.example.superherolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.superherolist.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso


//Adapter en kotlin
class HeroAdapter(val superHero:List<SuperHero>): RecyclerView.Adapter<HeroAdapter.HeroHolder>(){

    private lateinit var binding: ItemSuperheroBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate(R.layout.item_superhero,parent,false))
    }

    override fun getItemCount(): Int = superHero.size

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.render(superHero[position])
    }

//class holder
    class HeroHolder(val view: View):RecyclerView.ViewHolder(view){
    private val binding = ItemSuperheroBinding.bind(view)
    fun render(superHero: SuperHero)= with(binding){
            tvRealName.text = superHero.realName
            tvSuperHeroName.text = superHero.superHeroName
            tvPublisher.text = superHero.publisher
            Picasso.get().load(superHero.image).into(ivHero)
            view.setOnClickListener{
                Toast.makeText(view.context,
                "Haz selecionado a ${superHero.superHeroName} ",
                Toast.LENGTH_LONG).show()}
        }
    }


}
