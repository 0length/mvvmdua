package ga.bolehju.mvvmdua

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ga.bolehju.mvvmdua.viewmodel.LoginViewModel
import ga.bolehju.mvvmdua.databinding.LoginBinding
import ga.bolehju.mvvmdua.presenter.Presenter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.login)

        var activityMainBinding:LoginBinding
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.login)

        var viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        viewModel.getResultLogin().observe(this, Observer {

            showToast(""+it)
        })

        activityMainBinding!!.presenter = object : Presenter {

            override fun logIn() {
                var name : String = activityMainBinding.username.text.toString()
                var pass : String = activityMainBinding.password.text.toString()

                viewModel.loginCall(name, pass)
            }
        }

    }

    fun showToast(msg : String){
        Toast.makeText(this, ""+msg, Toast.LENGTH_LONG).show()
    }
}
