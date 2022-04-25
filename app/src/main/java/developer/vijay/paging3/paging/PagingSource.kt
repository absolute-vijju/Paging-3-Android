package developer.vijay.paging3.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import developer.vijay.paging3.models.PassengerList
import developer.vijay.paging3.retrofit.PassengerAPI

class PagingSource(private val passengerAPI: PassengerAPI) : PagingSource<Int, PassengerList.Data>() {

    override fun getRefreshKey(state: PagingState<Int, PassengerList.Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PassengerList.Data> {
        return try {
            val position = params.key ?: 1
            val response = passengerAPI.getPassengers(position)

            return LoadResult.Page(
                data = response.data,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == response.totalPages) null else position + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }


}