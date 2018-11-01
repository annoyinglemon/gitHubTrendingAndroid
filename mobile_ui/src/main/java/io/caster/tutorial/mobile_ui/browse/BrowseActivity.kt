package io.caster.tutorial.mobile_ui.browse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import io.caster.tutorial.mobile_ui.R
import kotlinx.android.synthetic.main.activity_browse.*

class BrowseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)

        setupBrowseRecycler()
    }

    private fun setupBrowseRecycler() {
        recycler_projects.layoutManager = LinearLayoutManager(this)
    }

}