package developer.vijay.paging3.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import developer.vijay.paging3.repository.PassengerRepository
import javax.inject.Inject

@HiltViewModel
class PassengerViewModel @Inject constructor(repository: PassengerRepository) : ViewModel() {
    val list = repository.getPassengers().cachedIn(viewModelScope)
}