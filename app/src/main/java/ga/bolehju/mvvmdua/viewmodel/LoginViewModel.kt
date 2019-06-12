package ga.bolehju.mvvmdua.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField


class LoginViewModel : ViewModel{

    var username = ObservableField("")
    var password = ObservableField("")

    var resultdata = MutableLiveData<String>()

    constructor() : super()

    fun loginCall(usernameP:String,userpassP:String){
        var result : String = ""
        username.set(usernameP)
        password.set(userpassP)

        if(username.get().equals("tes")&&(password.get().equals("tes")))
        {
            result = "access"
        }
        else {
            result = "denied"
        }

        resultdata.value = result
    }

    fun getResultLogin() : MutableLiveData<String> {
        return resultdata
    }
}