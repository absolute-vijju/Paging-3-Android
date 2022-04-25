package developer.vijay.paging3.models

data class PassengerList(
    val `data`: List<Data> = listOf(),
    val totalPages: Int = 0,
    val totalPassengers: Int = 0
) {
    data class Data(
        val __v: Int = 0,
        val _id: String = "",
        val airline: List<Airline> = listOf(),
        val name: String = "",
        val trips: Int = 0
    ) {
        data class Airline(
            val country: String = "",
            val established: String = "",
            val head_quaters: String = "",
            val id: Int = 0,
            val logo: String = "",
            val name: String = "",
            val slogan: String = "",
            val website: String = ""
        )
    }
}