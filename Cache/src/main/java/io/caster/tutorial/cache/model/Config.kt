package io.caster.tutorial.cache.model

import android.arch.persistence.room.Entity
import io.caster.tutorial.cache.db.ConfigConstants

@Entity(tableName = ConfigConstants.TABLE_NAME)
class Config(val lastCacheTime: Long)