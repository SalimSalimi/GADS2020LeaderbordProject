package dz.salim.salimi.gadsleaderbordproject.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dz.salim.salimi.gadsleaderbordproject.R
import dz.salim.salimi.gadsleaderbordproject.data.models.Leader
import dz.salim.salimi.gadsleaderbordproject.data.models.Learner

class LeadersAdapter(private val leadersList: List<Leader>): RecyclerView.Adapter<LeaderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderViewHolder {
        val context: Context = parent.context
        val inflatedView = LayoutInflater.from(context).inflate(R.layout.leader_list_item, parent, false)
        return LeaderViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: LeaderViewHolder, position: Int) {
        val leader = leadersList[position]
        holder.bind(leader)
    }

    override fun getItemCount(): Int {
        return leadersList.size
    }
}

class LeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var nameTextView: TextView? = null
    private var descriptionTextView: TextView? = null
    private var badgeImageView: ImageView? = null

    init {
        nameTextView =  itemView.findViewById(R.id.name_text_view)
        descriptionTextView = itemView.findViewById(R.id.description_text_view)
        badgeImageView = itemView.findViewById(R.id.badge_image_view)
    }

    fun bind(leader: Leader) = with(leader) {
        nameTextView!!.text = name
        if (this is Learner ) {
            leader as Learner
            descriptionTextView!!.text = "${hours} learning hours, ${country}"
        }
    }
}
