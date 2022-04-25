package developer.vijay.paging3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import developer.vijay.paging3.databinding.ActivityMainBinding
import developer.vijay.paging3.paging.LoadStateAdapter
import developer.vijay.paging3.paging.PagingAdapter
import developer.vijay.paging3.viewmodels.PassengerViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val passengerViewModel by viewModels<PassengerViewModel>()
    private val pagingAdapter by lazy { PagingAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        mBinding.apply {

            rvPassengers.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = pagingAdapter.withLoadStateHeaderAndFooter(
                    LoadStateAdapter { pagingAdapter.retry() },
                    LoadStateAdapter { pagingAdapter.retry() }
                )
            }

            passengerViewModel.list.observe(this@MainActivity) {
                pagingAdapter.submitData(lifecycle, it)
            }

        }
    }
}