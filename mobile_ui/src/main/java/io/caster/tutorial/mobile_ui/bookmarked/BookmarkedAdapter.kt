package io.caster.tutorial.mobile_ui.bookmarked

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.caster.tutorial.mobile_ui.R
import io.caster.tutorial.mobile_ui.model.Project
import kotlinx.android.synthetic.main.item_bookmarked_project.view.*
import javax.inject.Inject

class BookmarkedAdapter @Inject constructor(): RecyclerView.Adapter<BookmarkedAdapter.ViewHolder>() {

    var projects: List<Project> = arrayListOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.item_bookmarked_project, viewGroup, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return projects.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val project = projects.get(position)
        holder.itemView.text_owner_name.text = project.ownerName
        holder.itemView.text_project_name.text = project.fullName

        Glide.with(holder.itemView.context)
            .load(project.ownerAvatar)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.itemView.image_owner_avatar)
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view)
}