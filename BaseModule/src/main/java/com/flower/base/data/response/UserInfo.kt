package com.flower.base.data.response

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by ${XiLei} on 2018/8/18.
 * 用户实体类
 */


@Parcelize
@Entity(tableName = "SgmUserTable")
class UserInfo(
    @PrimaryKey
    val id: String,
    val mobile: String,
    val nickname: String
) : Parcelable