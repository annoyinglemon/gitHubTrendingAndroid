package io.caster.tutorial.cache.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import io.caster.tutorial.cache.db.ConfigConstants

@Entity(tableName = ConfigConstants.TABLE_NAME)
class Config(@PrimaryKey val lastCacheTime: Long)