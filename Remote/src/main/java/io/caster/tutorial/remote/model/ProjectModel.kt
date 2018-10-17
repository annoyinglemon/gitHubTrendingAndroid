package io.caster.tutorial.remote.model;

import com.google.gson.annotations.SerializedName;

class ProjectModel(val name: String, @SerializedName("full_name") val fullname: String,
                   @SerializedName("stargazers_count") val starCount: Int,
                   @SerializedName("created_at") val dateCreated: String,
                   val owner: OwnerModel)
