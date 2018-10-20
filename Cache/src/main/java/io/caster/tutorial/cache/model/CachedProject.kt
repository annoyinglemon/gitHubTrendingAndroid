package io.caster.tutorial.cache.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import io.caster.tutorial.cache.db.ProjectConstants.COLUMN_IS_BOOKMARKED
import io.caster.tutorial.cache.db.ProjectConstants.COLUMN_PROJECT_ID
import io.caster.tutorial.cache.db.ProjectConstants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class CachedProject (

    @PrimaryKey
    @ColumnInfo(name = COLUMN_PROJECT_ID)
    var id: String,
    var name: String,
    var fullName: String,
    var starCount: String,
    var dateCreated: String,
    var ownerName: String,
    var ownerAvatar: String,
    @ColumnInfo(name = COLUMN_IS_BOOKMARKED)
    var isBookmarked: Boolean

)