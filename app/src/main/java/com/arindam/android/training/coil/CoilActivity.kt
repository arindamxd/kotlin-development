package com.arindam.android.training.coil

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import coil.Coil
import coil.api.load
import coil.request.CachePolicy
import coil.request.RequestDisposable
import com.arindam.android.training.R
import kotlinx.android.synthetic.main.activity_coil.*
import kotlinx.coroutines.delay

/**
 * Created by Arindam Karmakar on 12/8/19.
 */

class CoilActivity : AppCompatActivity() {

    private data class ImageData(val view: ImageView, val url: String)
    private lateinit var disposable: RequestDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coil)

        val imageList = listOf(
                ImageData(image_one, "https://cdn.pixabay.com/photo/2016/11/29/04/19/beach-1867285_960_720.jpg"),
                ImageData(image_two, "https://images.unsplash.com/photo-1500382017468-9049fed747ef?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80"),
                ImageData(image_three, "https://images.unsplash.com/photo-1501854140801-50d01698950b?ixlib=rb-0.3.5&q=99&fm=jpg&crop=entropy&cs=tinysrgb&w=2048&fit=max&s=57cb1a2f500a7ac0f99ea3f256446ad9"),
                ImageData(image_four, "https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500")
        )

        for (index in 0 until imageList.size) {
            disposable = imageList[index].view.load(imageList[index].url) {
                memoryCachePolicy(CachePolicy.DISABLED)
                crossfade(2000)
            }
        }

        // Coil (has optional callbacks for start and error)
        Coil.load(this, "https://miro.medium.com/max/1838/1*F8aymrD8vHCfS5zDyDZN7g.jpeg") {
            crossfade(false)
            target { drawable ->
                // Handle the successful result.
                image_four.setImageDrawable(drawable)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}
