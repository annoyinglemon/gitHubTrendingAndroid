package io.caster.tutorial.mobile_ui.mapper

interface ViewMapper<in P, out V> {

    fun mapToView(presentation: P): V

}