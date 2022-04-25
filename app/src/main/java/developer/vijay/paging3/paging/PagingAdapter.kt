package developer.vijay.paging3.paging

import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import developer.vijay.paging3.databinding.ItemPassengerBinding
import developer.vijay.paging3.models.PassengerList
import kotlin.random.Random

class PagingAdapter : PagingDataAdapter<PassengerList.Data, PagingAdapter.PassengerViewHolder>(COMPARATOR) {

    inner class PassengerViewHolder(val mBinding: ItemPassengerBinding) : RecyclerView.ViewHolder(mBinding.root)

    override fun onBindViewHolder(holder: PassengerViewHolder, position: Int) {
        holder.mBinding.apply {
            val item = getItem(position)
            tvName.text = item?._id.plus(" | ").plus(position + 1)
            tvName.setBackgroundColor(Color.argb(1, Random.nextInt(), Random.nextInt(), Random.nextInt()))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PassengerViewHolder =
        PassengerViewHolder(ItemPassengerBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<PassengerList.Data>() {
            override fun areItemsTheSame(oldItem: PassengerList.Data, newItem: PassengerList.Data): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: PassengerList.Data, newItem: PassengerList.Data): Boolean {
                return oldItem == newItem
            }
        }
    }
}