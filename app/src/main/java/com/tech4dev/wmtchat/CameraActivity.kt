package com.tech4dev.wmtchat

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

class CameraActivity : AppCompatActivity() {
    private lateinit var cameraPreview: PreviewView
    private lateinit var takePhotoBtn: FloatingActionButton
    private lateinit var imageCapture: ImageCapture

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        cameraPreview = findViewById(R.id.cameraPreview)
        takePhotoBtn = findViewById(R.id.takePhotoBtn)

        if (allPermissionsGranted()) {
            //start camera
            startCamera()
            takePhotoBtn.setOnClickListener {
                Toast.makeText(this, "Image Captured ...", Toast.LENGTH_LONG).show()
            }
        } else {
            //request permission
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                111
            )
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode==11 && allPermissionsGranted()){
            startCamera()
        } else {
            finish()
        }
    }
    override fun onBackPressed() {
        finish()
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)

        cameraProviderFuture.addListener(
            {
                // bind to lifecycle
                val cameraProvider = cameraProviderFuture.get()
                val preview = Preview.Builder().build()
                preview.setSurfaceProvider(cameraPreview.surfaceProvider)
                imageCapture = ImageCapture.Builder().build()

                //select  the camera use
                val cameraSelected = CameraSelector.DEFAULT_BACK_CAMERA

                try {
                    cameraProvider.unbindAll()
                    cameraProvider.bindToLifecycle(
                        this,
                        cameraSelected,
                        preview,
                        imageCapture
                    )
                } catch (e: Exception) {
                    Log.e("WMTchat", "Camera Binding Failed $e")
                    Toast.makeText(
                        this,
                        "Camera Binding unsuccessful",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }, ContextCompat.getMainExecutor(this)
        )
    }

    private fun allPermissionsGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

}