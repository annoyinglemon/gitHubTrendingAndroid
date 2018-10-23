package io.caster.tutorial.cache.test.factory

import io.caster.tutorial.cache.model.Config

object ConfigDataFactory {

    fun makeCachedConfig() : Config {
        return Config(DataFactory.randomLong())
    }

}