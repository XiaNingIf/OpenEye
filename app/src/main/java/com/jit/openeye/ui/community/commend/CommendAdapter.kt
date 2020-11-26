package com.jit.openeye.ui.community.commend

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jit.openeye.Const
import com.jit.openeye.R
import com.jit.openeye.extension.load
import com.jit.openeye.logic.model.CommunityRecommend
import com.jit.openeye.util.ActionUrlUtil

/**
 *
 *@author created by XiaNingIf
 *@data 2020/11/26
 */
class CommendAdapter(val fragment: CommendFragment,var dataList:List<CommunityRecommend.Item>) :RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun getItemViewType(position: Int): Int {
        val item = dataList[position]
        return when(item.type){
            STR_HORIZONTAL_SCROLLCARD_TYPE -> {
                when(item.data.dataType){
                    STR_ITEM_COLLECTION_DATA_TYPE -> HORIZONTAL_SCROLLCARD_ITEM_COLLECTION_TYPE
                    STR_HORIZONTAL_SCROLLCARD_DATA_TYPE -> HORIZONTAL_SCROLLCARD_TYPE
                    else-> Const.ItemViewType.UNKNOWN
                }
            }
            STR_COMMUNITY_COLUMNS_CARD ->{
                if (item.data.dataType == STR_FOLLOW_CARD_DATA_TYPE) FOLLOW_CARD_TYPE
                else Const.ItemViewType.UNKNOWN
            }
            else -> Const.ItemViewType.UNKNOWN
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            HORIZONTAL_SCROLLCARD_ITEM_COLLECTION_TYPE -> {
                HorizontalS
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = dataList.size

    inner class HorizontalScrollCardItemCollectionViewHolder(view: View):RecyclerView.ViewHolder(view){
        val recyclerView:RecyclerView = view.findViewById(R.id.recyclerView)
    }

    inner class SquareCardOfCommunityContentAdapter(val fragment: CommendFragment,var dataList: List<CommunityRecommend.ItemX>):
        RecyclerView.Adapter<SquareCardOfCommunityContentAdapter.ViewHolder>(){

        inner class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
            val ivBgPicture : ImageView = view.findViewById(R.id.ivBgPicture)
            val tvTitle:TextView = view.findViewById(R.id.tvTitle)
            val tvSubTitle: TextView = view.findViewById(R.id.tvSubTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SquareCardOfCommunityContentAdapter.ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_community_horizontal_scroll_card_itemcollection_item_type,parent,false))
        }

        override fun onBindViewHolder(holder: SquareCardOfCommunityContentAdapter.ViewHolder, position: Int) {
            val item = dataList[position]
            holder.ivBgPicture.layoutParams.width = fragment.maxImageWidth
            holder.ivBgPicture.load(item.data.bgPicture)
            holder.tvTitle.text = item.data.title
            holder.tvSubTitle.text = item.data.subTitle
            holder.itemView.setOnClickListener { ActionUrlUtil.process(fragment,item.data.actionUrl,item.data.title) }
        }

        override fun getItemCount() = dataList.size

    }

    inner class SquareCardOfCommunityContentItemDecoration(val fragment: CommendFragment) : RecyclerView.ItemDecoration(){
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            val position = parent.getChildAdapterPosition(view)
            val count = parent.adapter?.itemCount?.minus(1)

            when(position){
                0->{
                    outRect.right = fragment.middleSpace
                }
                count->{
                    outRect.left = fragment.middleSpace
                }
                else ->{
                    outRect.left = fragment.middleSpace
                    outRect.right = fragment.middleSpace
                }
            }
        }
    }

    companion object {
        const val TAG = "CommendAdapter"

        const val STR_HORIZONTAL_SCROLLCARD_TYPE = "horizontalScrollCard"
        const val STR_COMMUNITY_COLUMNS_CARD = "communityColumnsCard"

        const val STR_HORIZONTAL_SCROLLCARD_DATA_TYPE = "HorizontalScrollCard"
        const val STR_ITEM_COLLECTION_DATA_TYPE = "ItemCollection"
        const val STR_FOLLOW_CARD_DATA_TYPE = "FollowCard"

        const val STR_VIDEO_TYPE = "video"
        const val STR_UGC_PICTURE_TYPE = "ugcPicture"

        const val HORIZONTAL_SCROLLCARD_ITEM_COLLECTION_TYPE = 1   //type:horizontalScrollCard -> dataType:ItemCollection
        const val HORIZONTAL_SCROLLCARD_TYPE = 2                   //type:horizontalScrollCard -> dataType:HorizontalScrollCard
        const val FOLLOW_CARD_TYPE = 3                             //type:communityColumnsCard -> dataType:FollowCard
    }
}