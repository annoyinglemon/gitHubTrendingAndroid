package com.example.tutorials.state

class Resource<out T> constructor(val status: ResourceState,
                                  val data: T?,
                                  val message: String?)