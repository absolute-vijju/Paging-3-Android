package developer.vijay.paging3.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import developer.vijay.paging3.databinding.ItemLoadStateBinding

class LoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<developer.vijay.paging3.paging.LoadStateAdapter.LoadStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {

        holder.mBinding.apply {

            btnRetry.isVisible = loadState !is LoadState.Loading
            tvError.isVisible = loadState !is LoadState.Loading
            progressBar.isVisible = loadState is LoadState.Loading

            if (loadState is LoadState.Error) {
                tvError.text = loadState.error.localizedMessage
            }

            btnRetry.setOnClickListener {
                retry.invoke()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder =
        LoadStateViewHolder(ItemLoadStateBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    class LoadStateViewHolder(val mBinding: ItemLoadStateBinding) : RecyclerView.ViewHolder(mBinding.root)
}