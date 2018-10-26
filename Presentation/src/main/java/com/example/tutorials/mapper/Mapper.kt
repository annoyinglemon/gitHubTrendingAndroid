package com.example.tutorials.mapper

interface Mapper<out V, in D> {

    fun mapToView(type: D) : V

}