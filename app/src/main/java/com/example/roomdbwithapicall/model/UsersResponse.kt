package com.example.roomdbwithapicall.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class UsersResponse(
    @SerializedName("limit") val limit: Int?, // 30
    @SerializedName("skip") val skip: Int?, // 0
    @SerializedName("total") val total: Int?, // 100
    @SerializedName("users") val users: List<User?>?
) {
    @Keep
    data class User(
        @SerializedName("address") val address: Address?,
        @SerializedName("age") val age: Int?, // 50
        @SerializedName("bank") val bank: Bank?,
        @SerializedName("birthDate") val birthDate: String?, // 2000-12-25
        @SerializedName("bloodGroup") val bloodGroup: String?, // A-
        @SerializedName("company") val company: Company?,
        @SerializedName("crypto") val crypto: Crypto?,
        @SerializedName("domain") val domain: String?, // slashdot.org
        @SerializedName("ein") val ein: String?, // 20-9487066
        @SerializedName("email") val email: String?, // atuny0@sohu.com
        @SerializedName("eyeColor") val eyeColor: String?, // Green
        @SerializedName("firstName") val firstName: String?, // Terry
        @SerializedName("gender") val gender: String?, // male
        @SerializedName("hair") val hair: Hair?,
        @SerializedName("height") val height: Int?, // 189
        @SerializedName("id") val id: Int?, // 1
        @SerializedName("image") val image: String?, // https://robohash.org/Terry.png?set=set4
        @SerializedName("ip") val ip: String?, // 117.29.86.254
        @SerializedName("lastName") val lastName: String?, // Medhurst
        @SerializedName("macAddress") val macAddress: String?, // 13:69:BA:56:A3:74
        @SerializedName("maidenName") val maidenName: String?, // Smitham
        @SerializedName("password") val password: String?, // 9uQFF1Lh
        @SerializedName("phone") val phone: String?, // +63 791 675 8914
        @SerializedName("ssn") val ssn: String?, // 661-64-2976
        @SerializedName("university") val university: String?, // Capitol University
        @SerializedName("userAgent") val userAgent: String?, // Mozilla/5.0 (Windows NT 6.1) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/12.0.702.0 Safari/534.24
        @SerializedName("username") val username: String?, // atuny0
        @SerializedName("weight") val weight: Double? // 75.4
    ) {
        @Keep
        data class Address(
            @SerializedName("address") val address: String?, // 1745 T Street Southeast
            @SerializedName("city") val city: String?, // Washington
            @SerializedName("coordinates") val coordinates: Coordinates?,
            @SerializedName("postalCode") val postalCode: String?, // 20020
            @SerializedName("state") val state: String? // DC
        ) {
            @Keep
            data class Coordinates(
                @SerializedName("lat") val lat: Double?, // 38.867033
                @SerializedName("lng") val lng: Double? // -76.979235
            )
        }

        @Keep
        data class Bank(
            @SerializedName("cardExpire") val cardExpire: String?, // 06/22
            @SerializedName("cardNumber") val cardNumber: String?, // 50380955204220685
            @SerializedName("cardType") val cardType: String?, // maestro
            @SerializedName("currency") val currency: String?, // Peso
            @SerializedName("iban") val iban: String? // NO17 0695 2754 967
        )

        @Keep
        data class Company(
            @SerializedName("address") val address: Address?,
            @SerializedName("department") val department: String?, // Marketing
            @SerializedName("name") val name: String?, // Blanda-O'Keefe
            @SerializedName("title") val title: String? // Help Desk Operator
        ) {
            @Keep
            data class Address(
                @SerializedName("address") val address: String?, // 629 Debbie Drive
                @SerializedName("city") val city: String?, // Nashville
                @SerializedName("coordinates") val coordinates: Coordinates?,
                @SerializedName("postalCode") val postalCode: String?, // 37076
                @SerializedName("state") val state: String? // TN
            ) {
                @Keep
                data class Coordinates(
                    @SerializedName("lat") val lat: Double?, // 36.208114
                    @SerializedName("lng") val lng: Double? // -86.58621199999999
                )
            }
        }

        @Keep
        data class Crypto(
            @SerializedName("coin") val coin: String?, // Bitcoin
            @SerializedName("network") val network: String?, // Ethereum (ERC20)
            @SerializedName("wallet") val wallet: String? // 0xb9fc2fe63b2a6c003f1c324c3bfa53259162181a
        )

        @Keep
        data class Hair(
            @SerializedName("color") val color: String?, // Black
            @SerializedName("type") val type: String? // Strands
        )
    }
}