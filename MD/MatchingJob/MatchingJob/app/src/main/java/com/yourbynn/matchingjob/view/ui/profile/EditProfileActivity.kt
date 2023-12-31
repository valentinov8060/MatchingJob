package com.yourbynn.matchingjob.view.ui.profile

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.yourbynn.matchingjob.R
import com.yourbynn.matchingjob.Utils.MessageUtils
import com.yourbynn.matchingjob.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding
    private var currentImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpTopBar()
        changeImageProfile()
    }

    private fun setUpTopBar(){
        supportActionBar?.apply {
            title = getString(R.string.edit_profile)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun changeImageProfile(){
        binding.buttonChangeImage.setOnClickListener {
            startGallery()
        }
    }

    private val launcherPhotoPicker = registerForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            currentImageUri = uri
            binding.previewEditImage.setImageURI(currentImageUri)
        } else {
            MessageUtils.showToast(this, getString(R.string.no_image))
        }
    }

    private fun startGallery() {
        launcherPhotoPicker.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }
}