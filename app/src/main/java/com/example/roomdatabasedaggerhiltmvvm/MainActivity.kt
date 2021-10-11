package com.example.roomdatabasedaggerhiltmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabasedaggerhiltmvvm.database.UserEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var viewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_add.setOnClickListener {
            val userEntity = UserEntity(name = edt_name.text.toString())
            viewModel.insertUser(userEntity)
            edt_name.setText("")
        }
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.getUserObserver().observe(this, object : Observer<List<UserEntity>> {
            override fun onChanged(t: List<UserEntity>?) {
                tv_result.text = ""
                t?.forEach {
                    tv_result.append(it.name + "\n")
                }
            }

        })
    }
}