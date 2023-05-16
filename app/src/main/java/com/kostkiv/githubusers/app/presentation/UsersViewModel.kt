package com.kostkiv.githubusers.app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kostkiv.githubusers.domain.GetDetailedInfoAboutUser
import com.kostkiv.githubusers.domain.GetListOfUsersUseCase
import com.kostkiv.githubusers.domain.LoadListOfUsersUseCase
import com.kostkiv.githubusers.domain.UserDetailed
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel(
    private val getDetailedInfoAboutUser: GetDetailedInfoAboutUser,
    getListOfUsersUseCase: GetListOfUsersUseCase,
    private val loadListOfUsersUseCase: LoadListOfUsersUseCase
) : ViewModel() {

    val usersList = getListOfUsersUseCase()

    private val _detailedUserInfo = MutableLiveData<UserDetailed>()
    val detailedUserInfo: LiveData<UserDetailed>
    get() = _detailedUserInfo

    private val _connectionError = MutableLiveData<Boolean>()
    val connectionError : LiveData<Boolean>
    get() = _connectionError

    fun loadListOfUsers(since: Int) {
        viewModelScope.launch(Dispatchers.Default) {
            try {
                loadListOfUsersUseCase(since)
                _connectionError.postValue(false)
            } catch (e : Exception) {
                _connectionError.postValue(true)
            }
        }
    }

    fun loadDetailedInfoAboutUser(username: String) {
        viewModelScope.launch(Dispatchers.Default) {
            try {
                val detailedUser = getDetailedInfoAboutUser(username)
                _detailedUserInfo.postValue(detailedUser)
                _connectionError.postValue(false)
            } catch(e : Exception) {
                _connectionError.postValue(true)
            }
        }
    }
}