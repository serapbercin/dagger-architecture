package serapbercin.com.myapplication.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class EventResponse(var list: List<EventList>)

@Parcelize
data class EventList(@SerializedName("id") var id: String) : Parcelable