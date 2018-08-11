package br.com.fiap.pokedex.model

import android.os.Parcel
import android.os.Parcelable

data class Pokemon(
        val numero: Int,
        val nome: String,
        val tipo: String,
        val descricao:String,
        val resourceId: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(numero)
        parcel.writeString(nome)
        parcel.writeString(tipo)
        parcel.writeString(descricao)
        parcel.writeInt(resourceId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pokemon> {
        override fun createFromParcel(parcel: Parcel): Pokemon {
            return Pokemon(parcel)
        }

        override fun newArray(size: Int): Array<Pokemon?> {
            return arrayOfNulls(size)
        }
    }
}