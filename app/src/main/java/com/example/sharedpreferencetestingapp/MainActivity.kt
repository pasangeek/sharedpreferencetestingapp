package com.example.sharedpreferencetestingapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.sharedpreferencetestingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

   binding.buttonsave.setOnClickListener {

       val data = binding.editTextTextPersonName.text.toString()
       saveData(data)

   }

        binding.button2get.setOnClickListener {

           val savedData = getData()
            binding.tvshowvalue.text = savedData
        }


    }
    fun saveData(dataToSave:String){

        val sharedPref=getPreferences(Context.MODE_PRIVATE)?:return
        with(sharedPref.edit()){
            putString("string1",dataToSave)
            commit()

        }
    }
    fun getData():String?
    {

        val sharedPref=getPreferences(Context.MODE_PRIVATE)
        return sharedPref.getString("string1","no data")

    }




}