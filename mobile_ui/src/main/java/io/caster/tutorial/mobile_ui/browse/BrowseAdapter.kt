package io.caster.tutorial.mobile_ui.browse

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.caster.tutorial.mobile_ui.R
import io.caster.tutorial.mobile_ui.model.Project
import kotlinx.android.synthetic.main.item_project.view.*
import javax.inject.Inject

class BrowseAdapter @Inject constructor(): RecyclerView.Adapter<BrowseAdapter.ViewHolder>() {

    var projects: List<Project> = arrayListOf()
    var projectListener: ProjectListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_project, parent, false)
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

        val resource = if (project.isBookmarked) {
            R.drawable.ic_favorite
        } else {
            R.drawable.ic_not_favorite
        }
        holder.itemView.image_bookmarked.setImageResource(resource)

        holder.itemView.setOnClickListener {
            if (project.isBookmarked)
                projectListener?.onBookmarkedProjectClicked(project.id)
            else
                projectListener?.onProjectClicked(project.id)
        }
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }

}