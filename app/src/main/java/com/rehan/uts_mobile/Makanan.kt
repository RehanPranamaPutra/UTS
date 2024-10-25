package com.rehan.uts_mobile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rehan.uts_mobile.adapter.MakananAdapter
import com.rehan.uts_mobile.model.FavoritesList
import com.rehan.uts_mobile.model.ModelMakanan

class Makanan : AppCompatActivity() {

    private lateinit var rv_favorites : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_makanan)
        rv_favorites = findViewById(R.id.rv_favorites)

        rv_favorites.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)

        val adapter = MakananAdapter(FavoritesList.getModel() as ArrayList<ModelMakanan>, this)

        rv_favorites.adapter = adapter
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}